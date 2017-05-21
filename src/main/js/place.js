import React from 'react'
import GoogleMap from './google-map'
export default class Place extends React.Component{
    constructor(props) {
        super(props)
    }
    render() {
        const {
            contact,
            open,
            sports,
            lat,
            lon
        } = this.props.place;
        const {
            name,
            address,
            phone,
            email,
            url
        } = contact;
        const {
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY,
            FRIDAY,
            SATURDAY,
            SUNDAY,
        } = open;
        let z = 14;
        if(this.props.place.z){
            z = this.props.place.z;
        }
        let map = null;
        if(lat && lon){
            let center = {lat, lng: lon};
            map = <GoogleMap marker={center} zoom={z} name={name}/>;
        }
        let contactTable = null;
        if(contact && (address || phone || email || url)) {
            let addressRow;
            let phoneRow;
            let emailRow;
            let urlRow;
            let priceRow = null;
            if(address) {
                addressRow = <tr>
                    <td>Adresa:</td>
                    <td>{address}</td>
                </tr>;
            }
            if(phone) {
                phoneRow = <tr>
                    <td>Telefon:</td>
                    <td>{phone}</td>
                </tr>;
            }
            if(email) {
                emailRow = <tr>
                    <td>Email:</td>
                    <td>{email}</td>
                </tr>;
            }
            if(url) {
                urlRow = <tr>
                    <td>Web:</td>
                    <td><a href={url}>{url}</a></td>
                </tr>;
            }
            if(sports && Array.isArray(sports) && sports.length > 0 && sports[0] && sports[0].price){
                priceRow = <tr>
                    <td>Cena za hodinu:</td>
                    <td>{sports[0].price}&nbsp;Kč</td>
                </tr>;
            }
            contactTable = <table className="contact-table">
                <tbody>
                {addressRow}
                {phoneRow}
                {emailRow}
                {urlRow}
                {priceRow}
                </tbody>
            </table>;
        }
        let openTable= null;
        if(open) {
            try {
                openTable = <table className="small-table">
                    <thead>
                    <tr><th colSpan="2">Porovozní doba</th></tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Pondělí:</td>
                        <td>{MONDAY.from}&nbsp;-&nbsp;{MONDAY.to}</td>
                    </tr>
                    <tr>
                        <td>Úterý:</td>
                        <td>{TUESDAY.from}&nbsp;-&nbsp;{TUESDAY.to}</td>
                    </tr>
                    <tr>
                        <td>Středa:</td>
                        <td>{WEDNESDAY.from}&nbsp;-&nbsp;{WEDNESDAY.to}</td>
                    </tr>
                    <tr>
                        <td>Čtvrtek:</td>
                        <td>{THURSDAY.from}&nbsp;-&nbsp;{THURSDAY.to}</td>
                    </tr>
                    <tr>
                        <td>Pátek:</td>
                        <td>{FRIDAY.from}&nbsp;-&nbsp;{FRIDAY.to}</td>
                    </tr>
                    <tr>
                        <td>Sobota:</td>
                        <td>{SATURDAY.from}&nbsp;-&nbsp;{SATURDAY.to}</td>
                    </tr>
                    <tr>
                        <td>Neděle:</td>
                        <td>{SUNDAY.from}&nbsp;-&nbsp;{SUNDAY.to}</td>
                    </tr>
                    </tbody>
                </table>;
            } catch (e) {
                console.log(e)
            }
        }
        return (
            <div className="place-container">
                <div className="place-info">
                    <span className="place-name">{name}</span>
                    {contactTable}
                </div>
                {openTable}
                {map}
            </div>
        )
    }
}