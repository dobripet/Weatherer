import React from 'react'
import {GoogleApiWrapper, Map, Marker} from 'google-maps-react'


class GoogleMap extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            ready: false
        };
        this.onReady = this.onReady.bind(this);
    }
    onReady() {
        this.setState({ready:true});
    }
    render(){
        let marker = null;
        console.log(this.state.ready);
        if(this.state.ready){
            marker = <Marker
                name={this.props.name}
                position={this.props.marker} />;
        }
        return(
                <Map google={this.props.google}
                     containerStyle={{width: '250px', height: '250px', position: 'relative'}}
                     zoom={this.props.zoom}
                     initialCenter={this.props.marker}
                     onReady={this.onReady} >
                    {marker}
                </Map>
        )
    }
}

export default GoogleApiWrapper({
    apiKey:'AIzaSyAyesbQMyKVVbBgKVi2g6VX7mop2z96jBo'
})(GoogleMap)