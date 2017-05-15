import React from 'react'
export default class ChatInput extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            value: ''

        };
        // bindings
        this.handleChange  = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    //nice focus tweak
    componentDidUpdate(prevProps){
        if(prevProps.disabled && !this.props.disabled){
            this.userInput.focus();
        }
    }
    componentDidMount() {
        this.userInput.focus();
    }
    handleChange(event) {
        this.setState({value: event.target.value});
    }
    handleSubmit(event) {
        event.preventDefault();
        let value = this.state.value;
        this.setState({value:''});
        this.props.onSubmit(value);
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <input
                    className="form-control input-lg"
                    placeholder={this.props.placeholder}
                    ref={input => { this.userInput = input }}
                    onChange={this.handleChange}
                    value={this.state.value}
                    disabled={this.props.disabled}
                />
            </form>
        )
    }
}