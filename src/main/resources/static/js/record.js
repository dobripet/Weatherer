var $record = document.querySelector('#record');
$record.onclick = doRecord;
var recorder;
var recordedData;

function doRecord () {
    navigator.mediaDevices.getUserMedia({
        audio: true
    })
        .then(function (stream) {
            $record.onclick = doStop;
            $record.innerHTML = '<i class="fa fa-microphone-slash"></i>stop';
            recordedData = [];

            recorder = new MediaRecorder(stream, {
                mimeType: 'audio/webm; codecs=opus'
            });

            recorder.addEventListener('error', function (event) {
                console.log('Audio Recording error', event)
            });

            recorder.addEventListener('dataavailable', function (event) {
                if (typeof event.data === 'undefined' || event.data.size === 0) return;
                recordedData.push(event.data)
            });

            recorder.addEventListener('stop', function (event) {
                var tracks = stream.getTracks();
                tracks.forEach(function (track) { track.stop() })
            });

            recorder.start(10);
        })
        .catch(function (error) { console.log(error) });
}

function doStop () {
    recorder.stop();
    $record.innerHTML = '<i class="fa fa-microphone"></i> record';
    $record.onclick = doRecord;
    var blob = new Blob(recordedData, {
        type: 'audio/webm'
    });

    var result = WatsonSpeech.SpeechToText.recognizeFile(blob, token);
    var text = document.getElementById('text');
    text.innerHTML = result;

    /*
    var a = document.createElement('a');
    var url = window.URL.createObjectURL(blob);

    a.href = url;
    a.download = 'record.webm';
    a.click();
    document.body.appendChild(a);

    // http://stackoverflow.com/questions/30694453/blob-createobjecturl-download-not-working-in-firefox-but-works-when-debugging
    setTimeout(function () {
        document.body.removeChild(a);
        window.URL.revokeObjectURL(url)
    }, 100);
    */
}