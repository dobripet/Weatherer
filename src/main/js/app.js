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
            messages: [],
            disabledInput: true,
            error: null
        };
        // bindings
        this.handleUserAnswer  = this.handleUserAnswer.bind(this);
        this.handleReset = this.handleReset.bind(this);
    }
    handleReset(){
        this.setState({messages: [], disabledInput: true});
        fetch(API+'bot', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    context: null,
                    userInput: "a",
                })
            }
        ).then(response =>
            response.json()
        ).then(json => {
            if (json.error) {
                throw new Error();
            }
            console.log(json);
            this.setState({messages: [...this.state.messages, {bot: true, text:json.text, data: json.data, context: json.context}], disableInput: false});
        }).catch( error => {
            console.log("ERROR", error);
            this.setState({error:"Něco se pokazilo, zkuste jiný dotaz :(", disabledInput: false});
        });
    }
    componentDidMount(){
        this.handleReset();
    }
    handleUserAnswer(answer){
        let lastMsg = this.state.messages[this.state.messages.length -1];
        fetch(API+'/bot', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    context: lastMsg.context,
                    userInput: answer,
                })
            }
        ).then(response =>
            response.json()
        ).then(json => {
            if (json.error) {
                throw new Error();
            }
            console.log(json);
            this.setState({messages: [...this.state.messages, {bot: true, text:json.text, data: json.data, context: json.context}], disableInput: false});
        }).catch( error => {
            console.log("ERROR", error);
            this.setState({error:"Něco se pokazilo, zkuste jiný dotaz :(", disabledInput: false});
        });
    }
    /*
     <header>
     <ul className="nav navbar navbar-static-top nav-tabs">
     <li><Link to="/home" activeClassName="active">Home</Link></li>
     </ul>
     </header>
     */
    render() {
        let error = null;
        if(this.state.error){
            error = <div className="alert alert-danger">{this.state.error}</div>;
        }
        return (
            <div>
                <button className="btn btn-warning btn-lg start-over" onClick={this.handleReset}>Začít znovu</button>
                <div className="container">
                    {error}
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