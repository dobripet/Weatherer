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
            sport,
        } = this.props.place;
        const {
            name,
            address,
            phone,
            email,
            url,
            lat,
            lon,
            z,
        } = contact;
        const {
            monday,
            tuesday,
            wednesday,
            thursday,
            friday,
            saturday,
            sunday,
        } = open;
        let center = {lat, lng: lon};
        let map = null;
        map = <GoogleMap marker={center} zoom={z} name={name}/>;
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
                    <td>{url}</td>
                </tr>;
            }
            if(sport && Array.isArray(sport) && sport.length > 0 && sport[0] && Object.keys(sport[0])[0].price){
                priceRow = <tr>
                    <td>Cena za hodinu:</td>
                    <td>{Object.keys(sport[0])[0].price}&bsp;Kč</td>
                </tr>;
            }
            contactTable = <table>
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
                        <td>{monday[0]}&nbsp;-&nbsp;{monday[1]}</td>
                    </tr>
                    <tr>
                        <td>Úterý:</td>
                        <td>{tuesday[0]}&nbsp;-&nbsp;{tuesday[1]}</td>
                    </tr>
                    <tr>
                        <td>Středa:</td>
                        <td>{wednesday[0]}&nbsp;-&nbsp;{wednesday[1]}</td>
                    </tr>
                    <tr>
                        <td>Čtvrtek:</td>
                        <td>{thursday[0]}&nbsp;-&nbsp;{thursday[1]}</td>
                    </tr>
                    <tr>
                        <td>Pátek:</td>
                        <td>{friday[0]}&nbsp;-&nbsp;{friday[1]}</td>
                    </tr>
                    <tr>
                        <td>Sobota:</td>
                        <td>{saturday[0]}&nbsp;-&nbsp;{saturday[1]}</td>
                    </tr>
                    <tr>
                        <td>Neděle:</td>
                        <td>{sunday[0]}&nbsp;-&nbsp;{sunday[1]}</td>
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