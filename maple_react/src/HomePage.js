import React from "react"
import './login.css'
export default class HomePage extends React.Component {
    constructor(props) {
        super(props)
    }
    render() {
        return(
            <>
          <div className = "longin">Log in as New User</div> 
            <div class="login">
                 <div class="login-triangle">
                </div>
                
             <h2 class="login-header">Log in</h2> 

                <form class="login-container">
                    <p><input type="email" placeholder="Email"/></p>
                    <p><input type="password" placeholder="Password"/></p>
                     <p><input type="submit" value="Log in"/></p> 
                </form>  
             </div>
             </>
        )
}
}
