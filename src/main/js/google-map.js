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
        return(<div className="map">
                <Map google={this.props.google}
                     containerStyle={{width: '200px', height: '200px', position: 'relative', marginLeft:"10px"}}
                     zoom={this.props.zoom}
                     initialCenter={this.props.marker}
                     onReady={this.onReady} >
                    {marker}
                </Map>
            </div>
        )
    }
}

export default GoogleApiWrapper({
    apiKey:'AIzaSyAyesbQMyKVVbBgKVi2g6VX7mop2z96jBo'
})(GoogleMap)