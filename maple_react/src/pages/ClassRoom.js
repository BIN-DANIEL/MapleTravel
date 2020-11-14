import React from 'react';
import { Link } from 'react-router-dom';
import Header from '../partials/Header';
import URLs from '../partials/URL.js';
import $ from 'jquery';
window.$ = $;
function ClassRoom() {
    return (
      <div className="flex flex-col min-h-screen overflow-hidden">
  
        {/*  Site header */}
        <Header />      
      </div>
    );
  }
  
  export default ClassRoom;