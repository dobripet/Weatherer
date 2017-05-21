import React from 'react'
import WeatherCurrent from "./weather-current"
import WeatherForecast from "./weather-forecast"
import Place from "./place"
export default class ChatMessage extends React.Component{
    constructor(props) {
        super(props)
        this.renderDay = this.renderDay.bind(this);
    }

    renderDay(key, data, multipleDays){
        const {
            places,
            weather,
            current,
            day
        } = data;
        let placesComponents = null;
        if(places && Array.isArray(places)){
            placesComponents = places.map((place,i) => <Place key={i} place={place}/> );
        }
        let weatherComponent = null;
        if(weather) {
            if (current) {
                weatherComponent = <WeatherCurrent weather={weather}/>
            } else {
                weatherComponent = <WeatherForecast weather={weather}/>
            }
        }
        let dayName = null;
        if(multipleDays){
            if(day === 'SATURDAY'){
                dayName="Aktivity pro sobotu:"
            } else if(day === 'SUNDAY'){
                dayName="Aktivity pro neděli:"
            }
            if(dayName){
                dayName = <div className="alert alert-success">{dayName}</div>
            }
        }
        return (
            <div key={key}>
                {dayName}
                {weatherComponent}
                {placesComponents}
            </div>
        )
    }
    render() {
        const data = this.props.message.data;
        let dataComponents = [];
        let question = null;
        if(data && Array.isArray(data)){
            dataComponents = data.map((d, i) => this.renderDay(i, d, data.length > 1));
            if(dataComponents.length > 0 && Array.isArray(data[0].places) && data[0].places.length > 0){
                question = "Přejete si vědět něco dalšího?"
            }
        }
        let className = 'message-user';
        let classNameContainer = 'message-container-user';
        if(this.props.message.bot){
            className = 'message-bot';
            classNameContainer = 'message-container-bot';
        }
        return (
            <div className={classNameContainer}>
                <div className={className}>
                    {Array.isArray(this.props.message.text) ? this.props.message.text.join(" ") : this.props.message.text}
                    {dataComponents}
                    {question}
                </div>
            </div>
        )
    }
}