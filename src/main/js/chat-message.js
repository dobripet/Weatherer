import React from 'react'
import GoogleMap from './google-map'
import WeatherCurrent from "./weather-current"
import WeatherForecast from "./weather-forecast"
export default class ChatMessage extends React.Component{
    constructor(props) {
        super(props)
    }
    render() {
        const {
            bot,
            message,
            m,
            weather,
            weatherType
        } = this.props.message;
        let className = 'message-user';
        let classNameContainer = 'message-container-user';
        if(bot){
            className = 'message-bot';
            classNameContainer = 'message-container-bot';
        }
        let map = null;
        if(m){
            let center = {lat: -25.363, lng: 131.044};
            //map = <GoogleMap marker={center} zoom={14} name="asd"/>;
        }
        let weatherComponent = null;
        if(weatherType === 'current'){
            weatherComponent = <WeatherCurrent  weather={weather}/>
        }else if(weatherType === 'forecast'){
            weatherComponent = <WeatherForecast  weather={weather}/>
        }
        return (
            <div className={classNameContainer}>
                <div className={className}>
                    {message}
                    {map}
                    {weatherComponent}
                </div>
            </div>
        )
    }
}