import React from 'react';
import { Link } from 'react-router-dom';
import Header from '../partials/Header';
import URLs from '../partials/URL.js';
import $ from 'jquery';
window.$ = $;
function ClassRoom() {
    return (
      <div className="flex flex-col min-h-screen overflow-hidden">
  
      <section className="relative">
      {/* Section background (needs .relative class on parent and next sibling elements) */}
      <div className="absolute inset-0 top-1/2 md:mt-24 lg:mt-0 bg-gray-900 pointer-events-none" aria-hidden="true"></div>
      <div className="absolute left-0 right-0 bottom-0 m-auto w-px p-px h-20 bg-gray-200 transform translate-y-1/2"></div>

      <div className="relative max-w-6xl mx-auto px-4 sm:px-6">
        <div className="py-12 md:py-20">

          {/* Section header */}
          <div className="max-w-3xl mx-auto text-center pb-12 md:pb-20">
            <h2 className="h2 mb-4">Talk to your Primary Care Doctor</h2>
            <p className="text-xl text-gray-600">Mary Alexanda MD </p>
            <p className="text-xl text-gray-600">Columbia University Clinic </p>

          </div>
          <div className="max-w-sm mx-auto grid gap-6 md:grid-cols-2 lg:grid-cols-3 items-start md:max-w-2xl lg:max-w-none">
            <iframe allowfullscreen="allowfullscreen" width="720" height="405" allow="microphone; camera" src="https://zoom.us/j/99824548074?pwd=OU9MNDJiemYzYWhURk1pMWJSK0ZGZz09"></iframe>
          </div>         

          </div>

        </div>
    </section>   
      </div>
    );
  }
  
  export default ClassRoom;