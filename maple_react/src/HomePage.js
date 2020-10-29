import React from "react"
import './login.css'
import URLs from "./URLs.js"
export default class HomePage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            status: "login"
        };
        this.Login = this.Login.bind(this);
        this.SignUp = this.SignUp.bind(this);
    }
    Login() {
        let username = $("#username").val();
        let password = $("#password").val();
        console.log(username);
        console.log(password);
        username = username.trim();
        password = password.trim();
        let loginInfo = {};
        loginInfo.username = username;
        loginInfo.password = password;
        console.log(JSON.stringify(loginInfo));
        $.ajax({
            contentType: "application/json",
            dataType: "json",
            url: URLs.loginURL,
            method: 'POST',
            data: JSON.stringify(loginInfo),
            error: (jqXHR, textStatus, errorThrown) => {
                console.log(errorThrown)
            }

        }).done((reply, textStatus, jqXHR)=>{
            if (reply.success) {
                alert("login Success!")
            } else {
                // TODO: 别用alert， 这个只是用来demo的， 最后还是要改
                alert("login Failed!");
                return;
            }
        })
    }
    SignUp() {
        let username = $("#username").val();
        let password = $("#password").val();
        let re_password = $("#password").val();
        // TODO: check username validility
        // TODO: check password validility
        if (password !== re_password) {
            //TODO: simple alert, modify it later
            console.log("re-entered password doesn't match")
        }
        $.ajax({
            url: URLs.buildHasUserURL(username),
            method: 'POST',
            dataType: 'json',
            error: (jqXHR, textStatus, errorThrown) => {
                console.log(errorThrown)
            }
        }).done((hasUser, textStatus, jqXHR)=>{
            //return true or false
            if (!hasUser) { // Means the provided username is valid

                $.ajax({
                    method: "POST",
                    url: URLs.signUpURL,
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify({username: username, password: password}),
                    error: (jqXHR, textStatus, errorThrown) => {
                        console.log(errorThrown)
                    }
                }).done((data, textStatus, jqXHR)=>{
                    if (data.regSuccess) {
                        alert("Register Successfully")
                        //TODO: Display corresponding UI, simple alert here, modify later
                    } else {
                        alert("Register Failed")
                        //TODO: Simple alert here, modify later
                    }
                });

            } else {
                //TODO: simple alert, modify later
                alert("Username already in user!")
            }
        });

    }
    render() {
        if (this.state.status === "login") {
            return(
                <>
                    <div className = "login">Log in as New User</div>
                    <div class="login">
                        <div class="login-triangle">
                        </div>
                        <div style={{"display": "flex"}}>
                            <div class="login-header" onClick={()=>{this.setState({status: "login"})}}>Log in</div>
                            <div className={"login-header"} onClick={()=>{this.setState({status: "register"})}}>Sign Up</div>
                        </div>
                        <div class="login-container">
                            <p><input id={"username"} type="email" placeholder="Email"/></p>
                            <p><input id={"password"} type="password" placeholder="Password"/></p>
                            <p><button onClick={this.Login}>Log In</button></p>
                        </div>
                    </div>
                </>
            )
        } else {
            return (
                <>
                    <div className="login">Log in as New User</div>
                    <div className="login">
                        <div className="login-triangle">
                        </div>
                        <div style={{"display": "flex"}}>
                            <div className="login-header" onClick={() => {
                                this.setState({status: "login"})
                            }}>Log in
                            </div>
                            <div className={"login-header"} onClick={() => {
                                this.setState({status: "register"})
                            }}>Sign Up
                            </div>
                        </div>
                        <div className="login-container">
                            <p><input id={"username"} type="email" placeholder="Email"/></p>
                            <p><input id={"password"} type="password" placeholder="Password"/></p>
                            <p><input id={"re_password"} type="re_password" placeholder="Re-enter Password"/></p>
                            <p><button onClick={this.SignUp}>Sign Up</button></p>
                        </div>
                    </div>
                </>
            )
        }

}
}
