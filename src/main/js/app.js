'use strict';
import React from 'react'
import { render } from "react-dom"
import { Router, Route, Link, browserHistory } from 'react-router'
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
class App extends React.Component{
    constructor(props) {
        super(props)
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
                <div>
                    {this.props.children}
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