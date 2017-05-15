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
        } = this.props.weather.list[0].temp;
        const humidity = this.props.weather.list[0].humidity;
        const pressure = this.props.weather.list[0].pressure;
        const speed = this.props.weather.list[0].speed;
        const {
            description,
            icon
        } = this.props.weather.list[0].weather[0];

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
            pressureRow = <tr className="weather-small"><td>Tlak:</td><td>{pressure}&nbsp;hPa</td></tr>;
            humidityRow = <tr className="weather-small"><td>Vlhkost:</td><td>{humidity}&nbsp;%</td></tr>;
        }
        let speedRow = null;
        if (speed) {
            speedRow = <tr className="weather-small"><td>Rychlost větru:</td><td>{speed}&nbsp;km/h</td></tr>;
        }
        let eveRow = null;
        let mornRow = null;
        if(eve && morn){
            mornRow = <tr className="weather-small"><td>Ranní teplota:</td><td>{Math.round(morn)}°C</td></tr>;
            eveRow = <tr className="weather-small"><td>Večerní teplota</td><td>{Math.round(eve)}°C</td></tr>;
        }

        return (
            <div className="weather-container">
                <div className="weather-basics-container">
                    {iconImg}
                    {daySpan}
                    {description}
                </div>
                <table className="weather-detail-table">
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