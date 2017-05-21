import React from 'react'
export default class WeatherForecast extends React.Component{
    constructor(props) {
        super(props)
    }
    render() {
        const {
            day,
            eve,
            morn,
        } = this.props.weather.temp;
        const humidity = this.props.weather.humidity;
        const pressure = this.props.weather.pressure;
        const speed = this.props.weather.speed;
        const {
            description,
            icon
        } = this.props.weather.weather;

        let iconImg = null;
        if(icon) {
            let iconUrl = 'http://openweathermap.org/img/w/' + icon + ".png";
            iconImg = <img src={iconUrl} alt={description}></img>
        }
        let daySpan = null;
        if(day){
            daySpan = <span className="temperature">{Math.round(day)}°C</span>
        }
        let pressureRow = null;
        let humidityRow = null;
        if( pressure && humidity){
            pressureRow = <tr><td>Tlak:</td><td>{pressure}&nbsp;hPa</td></tr>;
            humidityRow = <tr><td>Vlhkost:</td><td>{humidity}&nbsp;%</td></tr>;
        }
        let speedRow = null;
        if (speed) {
            speedRow = <tr><td>Rychlost větru:</td><td>{speed}&nbsp;km/h</td></tr>;
        }
        let eveRow = null;
        let mornRow = null;
        if(eve && morn){
            mornRow = <tr><td>Ranní teplota:</td><td>{Math.round(morn)}°C</td></tr>;
            eveRow = <tr><td>Večerní teplota:</td><td>{Math.round(eve)}°C</td></tr>;
        }

        return (
            <div className="weather-container">
                <div className="weather-basics-container">
                    {iconImg}
                    {daySpan}
                    {description}
                </div>
                <table className="weather-detail-table small-table">
                    <tbody>
                    {humidityRow}
                    {pressureRow}
                    {speedRow}
                    {mornRow}
                    {eveRow}
                    </tbody>
                </table>
            </div>
        )
    }
}