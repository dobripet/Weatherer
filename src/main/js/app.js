'use strict';
import React from 'react'
import { render } from "react-dom"
import { Router, Route, Link, browserHistory } from 'react-router'
import Chat from './chat'
//import QueryBuilder from './query-builder/query-builder'
/*
class NotFound extends React.Component{
    constructor(props) {
        super(props)
    }
    render() {
        return <div className="jumbotron">
            <h1>404 - Page not found</h1>
            <p>
                The page you're looking for doesn't seem to exist.
            </p>
        </div>;
    }
}*/
const API = 'http://localhost:9080/sportbot/';
class App extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            messages: [{bot: true, message: "Nazdar, jsem sport robot, co chces vedet?"},
                {bot: false, message:"Muzu zitra na kolo?"},
                {bot: true, message:"Muzes, jestli ti nevadi chcavec jak svin."}],
            disabledInput: true
        };
        // bindings
        this.handleUserAnswer  = this.handleUserAnswer.bind(this);
        this.enable = this.enable.bind(this);
    }
    enable(){
        this.setState({messages: [...this.state.messages, {bot:true, message:"Sam ses!", m: true},  {bot:true, message:"Sam ses3!", m: true}], disabledInput:false});
    }
    componentDidMount(){
        setTimeout(this.enable, 1);
    }
    handleUserAnswer(answer){
        //TODO send request
        console.log("send request ", answer);
        this.setState({messages: [...this.state.messages, {bot:false, message:answer}], disabledInput:true});
        //setTimeout(this.enable, 1000);
        /*fetch(API+'/weather', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                answer:  answer,
            })
        }).then(response => response.json()
        ).then(json => console.log(json)
        ).catch( error => console.log("ERROR", error));*/
        fetch(API+'/weather/forecast/daily'
        ).then(response => response.json()
        ).then(json => {console.log(json); this.setState({messages: [...this.state.messages, {bot: true, message: "Pocasi: ",weatherType:"forecast", weather: json}]})}
        ).catch( error => console.log("ERROR", error));
    }
    /*
     <header>
     <ul className="nav navbar navbar-static-top nav-tabs">
     <li><Link to="/home" activeClassName="active">Home</Link></li>
     </ul>
     </header>
     */
    render() {
        return (
            <div>
                <h2>This is working react app!</h2>
                <div className="container">
                    <Chat handleUserAnswer={this.handleUserAnswer} messages={this.state.messages} disabledInput={this.state.disabledInput}/>
                </div>
            </div>
        )
    }
}
/*
class Home extends React.Component{
    constructor(props) {
        super(props)
    }
    render() {
        return (
            <h2>Welcome to React App!</h2>
        )
    }
}
*/
/*<Redirect from="/" to="builder" />
const router =
    <Router history={browserHistory}>
        <Route path="/" component={App}>
            <Route path="home" component={Home} />
            <Route path="*" component={NotFound}/>
        </Route>
    </Router>;

 render(router, document.getElementById("react"));
 */
render(<App/>, document.getElementById("react"));