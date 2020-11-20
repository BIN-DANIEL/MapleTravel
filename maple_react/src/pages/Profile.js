import React from 'react';

import Header from '../partials/Header';
import HeroHome from '../partials/HeroHome';
import FeaturesHome from '../partials/Features';
import FeaturesBlocks from '../partials/FeaturesBlocks';
import Testimonials from '../partials/Testimonials';
import Newsletter from '../partials/Newsletter';
import Footer from '../partials/Footer';
import { Link } from 'react-router-dom';
import URLs from '../partials/URL.js';
import $ from 'jquery';
window.$ = $;

class Profile extends React.Component {

    componentDidMount(){
        const { match: { params } } = this.props;
        this.getProfile(params.username);
    }
    updateProfile(){

    }

    getProfile(username){
       $.ajax({
           contentType: "application/json",
           dataType: "json",
           url: URLs.profileURL,
           method: 'GET',
           data: {username: username},
           error: (jqXHR, textStatus, errorThrown) => {
               console.log(jqXHR.status);
               console.log(errorThrown);
           }

       }).done((reply, textStatus, jqXHR)=>{
         document.getElementById("username").innerHTML = username;
         if(reply.length == 0){
            document.getElementById("courseList").innerHTML = "<label>Not Enrolled in any class</label>";
         }
         for(var i = 0; i < reply.length; i+=2){
            document.getElementById("courseList").innerHTML +=
            "<div className=\"flex flex-wrap -mx-3 mb-4\"> <div className=\"w-full px-3\"> <label className=\"block text-gray-800 text-sm font-medium mb-1\" htmlFor=\"course\">"
            + reply[i] + "</label>" + "</br>" + "<label>" + reply[i + 1] +  "</label>"
            + "</div></div><hr>";
         }
         console.log(reply);
       });
    }

    render(){
    return (
       <div className="flex flex-col min-h-screen overflow-hidden">

             {/*  Site header */}
             <Header />
             {/*  Page content */}
             <main className="flex-grow">

               <section className="bg-gradient-to-b from-gray-100 to-white">
                 <div className="max-w-6xl mx-auto px-4 sm:px-6">
                   <div className="pt-32 pb-12 md:pt-40 md:pb-20">

                     {/* Page header */}
                     <div className="max-w-3xl mx-auto text-center pb-12 md:pb-20">
                       <h1 className="h1" id = "username"></h1>
                     </div>

                     {/* Form */}
                     <div className="max-w-lg mx-auto">
                       <h1 className="h3" >Enrollment:</h1>
                       <ul id="courseList">


                       </ul>

                         <div className="flex flex-wrap -mx-3 mt-6">
                           <div className="w-full px-3">

                           </div>
                         </div>
                     </div>

                   </div>
                 </div>
               </section>

             </main>

           </div>
      );
    }
}

export default Profile;