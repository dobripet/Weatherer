import React from 'react'
export default class WeatherCurrent extends React.Component{
    constructor(props) {
        super(props)
    }
    render() {
        const {
            description,
            icon
        } = this.props.weather.weather[0];
        const {
            temp,
            pressure,
            humidity,
        } = this.props.weather.main;
        const speed = this.props.weather.wind.speed;
        const {
            sunset,
            sunrise
        } = this.props.weather.sys;

        let iconImg = null;
        if(icon) {
            let iconUrl = 'http://openweathermap.org/img/w/' + icon + ".png";
            iconImg = <img src={iconUrl} alt={description}></img>
        }
        let tempSpan = null;
        if(temp){
            tempSpan = <span className="temperature">{Math.round(temp)}°C</span>
        }
        let pressureRow = null;
        let humidityRow = null;
        if( pressure && humidity){
            pressureRow = <tr className="weather-small"><td>Tlak:</td><td>{pressure}&nbsp;hPa</td></tr>;
            humidityRow = <tr className="weather-small"><td>Vlhkost:</td><td>{humidity}&nbsp;%</td></tr>;
        }
        let speedRow = null;
        if (speed) {
            speedRow = <tr className="weather-small"><td>Rychlost větru:</td><td>{speed}&nbsp;km/h</td></tr>;
        }
        let sunsetRow = null;
        let sunriseRow = null;
        if(sunset && sunrise){
            let sunsetDate = new Date(sunset*1000);
            let sunsetString = sunsetDate.getHours()+':'+sunsetDate.getMinutes();
            sunsetRow = <tr className="weather-small"><td>Západ slunce:</td><td>{sunsetString}</td></tr>;
            let sunriseDate = new Date(sunrise*1000);
            let sunriseString = sunriseDate.getHours()+':'+sunriseDate.getMinutes();
            sunriseRow = <tr className="weather-small"><td>Východ slunce:</td><td>{sunriseString}</td></tr>;
        }

        return (
            <div className="weather-container">
                <div className="weather-basics-container">
                    {iconImg}
                    {tempSpan}
                    {description}
                </div>
                <table className="weather-detail-table">
                    <tbody>
                    {humidityRow}
                    {pressureRow}
                    {speedRow}
                    {sunriseRow}
                    {sunsetRow}
                    </tbody>
                </table>
            </div>
        )
    }
}