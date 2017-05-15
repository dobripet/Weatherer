import React from 'react'
import ChatMessage from './chat-message'
import ChatInput from './chat-input'
export default class Chat extends React.Component{
    constructor(props) {
        super(props);
        // bindings
        this.handleUserAnswer  = this.handleUserAnswer.bind(this);
    }

    handleUserAnswer(answer){
        this.props.handleUserAnswer(answer);
    }
    render() {
        //let msgs = [];
        /*for(const msg of messages){
            if(msg.bot){
                msgs.push(<ChatMessage bot={bot} message={}/>)
            }
        }*/
        const {
            messages
        } = this.props;
        let msgs = messages.map((msg, i) =>  <ChatMessage key={i} message={msg}/> );
        return (
            <div>
                {msgs}
                <ChatInput onSubmit={this.handleUserAnswer} disabled={this.props.disabledInput}/>
            </div>
        )
    }
}