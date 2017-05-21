'use strict';
import React from 'react'
import { render } from "react-dom"
import Chat from './chat'
//const API = 'http://localhost:9080/sportbot/';
const API = '/';
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
                    userInput: "",
                })
            }
        ).then(response =>
            response.json()
        ).then(json => {
            if (json.error) {
                throw new Error();
            }
            this.setState({messages: [...this.state.messages, {bot: true, text:json.text, data: json.data, context: json.context}], disabledInput: false, error:false});
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
        this.setState({messages: [...this.state.messages, {bot: false, text:answer, data: null, context: null}], disabledInput: true, error: false});
        fetch(API+'bot', {
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
            this.setState({messages: [...this.state.messages, {bot: true, text:json.text, data: json.data, context: json.context}], disabledInput: false, error: false});
        }).catch( error => {
            console.log("ERROR", error);
            this.setState({error:"Něco se pokazilo, zkuste jiný dotaz :(", disabledInput: false});
        });
    }
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
render(<App/>, document.getElementById("react"));