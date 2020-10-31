import React from 'react';
import { Link } from 'react-router-dom';
import URLs from '../partials/URL';
import Header from '../partials/Header';
import $ from 'jquery';
window.$ = $;


function SignUp() {

  function HandleClick() {
        console.log(URLs.loginURL);
        let username = $("#username").val();
        let password = $("#password").val();
        let re_password = $("#re_password").val();
        // TODO: check username validility
        // TODO: check password validility
        if (password !== re_password) {
            //TODO: simple alert, modify it later
            alert("re-entered password doesn't match");
        }
        $.ajax({
            url: URLs.buildHasUserURL(username),
            method: 'POST',
            dataType: 'json',
            error: (jqXHR, textStatus, errorThrown) => {
                console.log(errorThrown);
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
                        console.log(errorThrown);
                    }
                }).done((data, textStatus, jqXHR)=>{
                    if (data.regSuccess) {
                        alert("Register Successfully");
                        //TODO: Display corresponding UI, simple alert here, modify later
                    } else {
                        alert("Register Failed");
                        //TODO: Simple alert here, modify later
                    }
                });

            } else {
                //TODO: simple alert, modify later
                alert("Username already in user!");
            }
        });
      }

  return (
    
    <div className="flex flex-col min-h-screen overflow-hidden" >

      {/*  Site header */}
      <Header />

      {/*  Page content */}
      <main className="flex-grow">

        <section className="bg-gradient-to-b from-gray-100 to-white">
          <div className="max-w-6xl mx-auto px-4 sm:px-6">
            <div className="pt-32 pb-12 md:pt-40 md:pb-20">

              {/* Page header */}
              <div className="max-w-3xl mx-auto text-center pb-12 md:pb-20">
                <h1 className="h1">Welcome</h1>
              </div>
              {/* Form */}
              <div className="max-w-sm mx-auto">
                <form>
                  <div className="flex flex-wrap -mx-3 mb-4">
                    <div className="w-full px-3">
                      <label className="block text-gray-800 text-sm font-medium mb-1" htmlFor="name">UserName <span className="text-red-600">*</span></label>
                      <input id="username" type="email" className="form-input w-full text-gray-800" placeholder="Enter your name" required />
                    </div>
                  </div>                  
                  <div className="flex flex-wrap -mx-3 mb-4">
                    <div className="w-full px-3">
                      <label className="block text-gray-800 text-sm font-medium mb-1" htmlFor="password">Password <span className="text-red-600">*</span></label>
                      <input id="password" type="password" className="form-input w-full text-gray-800" placeholder="Enter your password" required />
                    </div>
                  </div>
                  <div className="flex flex-wrap -mx-3 mb-4">
                    <div className="w-full px-3">
                      <label className="block text-gray-800 text-sm font-medium mb-1" htmlFor="re_password">Re-enter Password <span className="text-red-600">*</span></label>
                      <input id="re_password" type="password" className="form-input w-full text-gray-800" placeholder="Re-Enter your password" required />
                    </div>
                  </div>
                  <div className="flex flex-wrap -mx-3 mt-6">
                    <div className="w-full px-3" >
                      <button className="btn text-white bg-blue-600 hover:bg-blue-700 w-full" onClick={() => HandleClick()}>Sign up</button>
                    </div>
                  </div>
                  <div className="text-sm text-gray-500 text-center mt-3">
                    By creating an account, you agree to the <a className="underline" href="#0">terms & conditions</a>, and our <a className="underline" href="#0">privacy policy</a>.
                  </div>
                </form>
                <div className="flex items-center my-6">
                  <div className="border-t border-gray-300 flex-grow mr-3" aria-hidden="true"></div>
                  <div className="text-gray-600 italic">Or</div>
                  <div className="border-t border-gray-300 flex-grow ml-3" aria-hidden="true"></div>
                </div>
                
                <div className="text-gray-600 text-center mt-6">
                  Already using Maple Travel? <Link to="/signin" className="text-blue-600 hover:underline transition duration-150 ease-in-out">Sign in</Link>
                </div>
              </div>

            </div>
          </div>
        </section>

      </main>

    </div>
  );
}

export default SignUp;