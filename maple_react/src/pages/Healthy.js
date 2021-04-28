import React from 'react';

function Healthy() {
  return (
    <section className="relative">
      {/* Section background (needs .relative class on parent and next sibling elements) */}
      <div className="absolute inset-0 top-1/2 md:mt-24 lg:mt-0 bg-gray-900 pointer-events-none" aria-hidden="true"></div>
      <div className="absolute left-0 right-0 bottom-0 m-auto w-px p-px h-20 bg-gray-200 transform translate-y-1/2"></div>

      <div className="relative max-w-6xl mx-auto px-4 sm:px-6">
        <div className="py-12 md:py-20">

          {/* Section header */}
          <div className="max-w-3xl mx-auto text-center pb-12 md:pb-20">
            <h2 className="h2 mb-4">Report Your Health Today</h2>
            <p className="text-xl text-gray-600">Let's Estimate Your Covid Infection First</p>
          </div>
          



        <div className="max-w-3xl mx-auto text-center pb-12 md:pb-20">
            <h4 className="h2 mb-4">Covid-19 Inquiry</h4>
            <a style={{"background-color":"black"}} class="btn btn-success" href="http://chatbot-ui-yl4736.s3-website-us-east-1.amazonaws.com/" target="_blank">Covid-19 Inquiry</a>
        </div>


        <div className="max-w-3xl mx-auto text-center pb-12 md:pb-20">
            <h4 className="h2 mb-4">Upload your ECG for Doctor's Record</h4>
            <a style={{"background-color":"black"}} class="btn btn-success" href="http://frontendui2.s3-website-us-east-1.amazonaws.com/" target="_blank">ECG Upload</a>
        </div>


            {/* Items */}
          <div className="max-w-sm mx-auto grid gap-6 md:grid-cols-2 lg:grid-cols-3 items-start md:max-w-2xl lg:max-w-none">

          {/* 1st item */}
          <div className="relative flex flex-col items-center p-6 bg-white rounded shadow-xl">
            <svg className="w-16 h-16 p-1 -mt-1 mb-2" viewBox="0 0 64 64" xmlns="http://www.w3.org/2000/svg">
              <g fill="none" fillRule="evenodd">
                <rect className="fill-current text-blue-600" width="64" height="64" rx="32" />
                <g strokeWidth="2">
                  <path className="stroke-current text-blue-300" d="M34.514 35.429l2.057 2.285h8M20.571 26.286h5.715l2.057 2.285" />
                  <path className="stroke-current text-white" d="M20.571 37.714h5.715L36.57 26.286h8" />
                  <path className="stroke-current text-blue-300" strokeLinecap="square" d="M41.143 34.286l3.428 3.428-3.428 3.429" />
                  <path className="stroke-current text-white" strokeLinecap="square" d="M41.143 29.714l3.428-3.428-3.428-3.429" />
                </g>
              </g>
            </svg>
            <h4 className="text-xl font-bold leading-snug tracking-tight mb-1">How long has Arrowhead Camp been around?</h4>
            <p className="text-gray-600 text-center">Campers have been enjoying their summers at camp since 1972. Over the years the size and diversity of the program and facilities has grown and developed. For more info, please go to our history page.</p>
          </div>

          {/* 2nd item */}
          <div className="relative flex flex-col items-center p-6 bg-white rounded shadow-xl">
            <svg className="w-16 h-16 p-1 -mt-1 mb-2" viewBox="0 0 64 64" xmlns="http://www.w3.org/2000/svg">
              <g fill="none" fillRule="evenodd">
                <rect className="fill-current text-blue-600" width="64" height="64" rx="32" />
                <g strokeWidth="2" transform="translate(19.429 20.571)">
                  <circle className="stroke-current text-white" strokeLinecap="square" cx="12.571" cy="12.571" r="1.143" />
                  <path className="stroke-current text-white" d="M19.153 23.267c3.59-2.213 5.99-6.169 5.99-10.696C25.143 5.63 19.514 0 12.57 0 5.63 0 0 5.629 0 12.571c0 4.527 2.4 8.483 5.99 10.696" />
                  <path className="stroke-current text-blue-300" d="M16.161 18.406a6.848 6.848 0 003.268-5.835 6.857 6.857 0 00-6.858-6.857 6.857 6.857 0 00-6.857 6.857 6.848 6.848 0 003.268 5.835" />
                </g>
              </g>
            </svg>
            <h4 className="text-xl font-bold leading-snug tracking-tight mb-1">How effective will the vaccine be against COVID-19, and for how long?</h4>
            <p className="text-gray-600 text-center">All vaccines currently authorized for use in the US are highly effective at protecting against severe COVID-19 that can lead to hospitalization and death. At this time, experts do not know how long protection will last or whether a booster shot will be necessary later, after the initial recommended vaccine dose(s). CDC and DSHS will keep the public informed as they learn more.

            To learn about efficacy rates for specific vaccines</p>
          </div>

          {/* 3rd item */}
          <div className="relative flex flex-col items-center p-6 bg-white rounded shadow-xl">
            <svg className="w-16 h-16 p-1 -mt-1 mb-2" viewBox="0 0 64 64" xmlns="http://www.w3.org/2000/svg">
              <g fill="none" fillRule="evenodd">
                <rect className="fill-current text-blue-600" width="64" height="64" rx="32" />
                <g strokeLinecap="square" strokeWidth="2">
                  <path className="stroke-current text-blue-300" d="M38.826 22.504a9.128 9.128 0 00-13.291-.398M35.403 25.546a4.543 4.543 0 00-6.635-.207" />
                  <path className="stroke-current text-white" d="M19.429 25.143A6.857 6.857 0 0126.286 32v1.189L28 37.143l-1.714.571V40A2.286 2.286 0 0124 42.286h-2.286v2.285M44.571 25.143A6.857 6.857 0 0037.714 32v1.189L36 37.143l1.714.571V40A2.286 2.286 0 0040 42.286h2.286v2.285" />
                </g>
              </g>
            </svg>
            <h4 className="text-xl font-bold leading-snug tracking-tight mb-1">Who is at risk for infection with SARS-Cov-2, the virus that causes COVID-19</h4>
            <p className="text-gray-600 text-center">Currently, those at greatest risk of infection are persons who have had prolonged, unprotected close contact (i.e., within 6 feet for 15 minutes or longer) with a patient with confirmed SARS-CoV-2 infection, regardless of whether the patient has symptoms. Persons frequently in congregate settings see Risk Assessment and Your Health.</p>
          </div>

          {/* 4th item */}
          <div className="relative flex flex-col items-center p-6 bg-white rounded shadow-xl">
            <svg className="w-16 h-16 p-1 -mt-1 mb-2" viewBox="0 0 64 64" xmlns="http://www.w3.org/2000/svg">
              <g fill="none" fillRule="evenodd">
                <rect className="fill-current text-blue-600" width="64" height="64" rx="32" />
                <g transform="translate(22.857 19.429)" strokeWidth="2">
                  <path className="stroke-current text-white" strokeLinecap="square" d="M12.571 4.571V0H0v25.143h12.571V20.57" />
                  <path className="stroke-current text-white" d="M16 12.571h8" />
                  <path className="stroke-current text-white" strokeLinecap="square" d="M19.429 8L24 12.571l-4.571 4.572" />
                  <circle className="stroke-current text-blue-300" strokeLinecap="square" cx="12.571" cy="12.571" r="3.429" />
                </g>
              </g>
            </svg>              
            <h4 className="text-xl font-bold leading-snug tracking-tight mb-1">Who is at risk for severe COVID-19?</h4>
            <p className="text-gray-600 text-center">COVID-19 is a new disease and CDC is learning more about it every day. Among adults, the risk for severe illness from COVID-19 increases with age, with older adults at highest risk. Severe illness means that the person with COVID-19 may require hospitalization, intensive care, or a ventilator to help them breathe, or they may even die. People of any age with certain underlying medical conditions are also at increased risk for severe illness from SARS-CoV-2 infection.</p>
          </div>

          {/* 5th item */}
          <div className="relative flex flex-col items-center p-6 bg-white rounded shadow-xl">
            <svg className="w-16 h-16 p-1 -mt-1 mb-2" viewBox="0 0 64 64" xmlns="http://www.w3.org/2000/svg">
              <g fill="none" fillRule="evenodd">
                <rect className="fill-current text-blue-600" width="64" height="64" rx="32" />
                <g strokeLinecap="square" strokeWidth="2">
                  <path className="stroke-current text-white" d="M20.571 20.571h13.714v17.143H20.571z" />
                  <path className="stroke-current text-blue-300" d="M38.858 26.993l6.397 1.73-4.473 16.549-13.24-3.58" />
                </g>
              </g>
            </svg>
            <h4 className="text-xl font-bold leading-snug tracking-tight mb-1">Is there a Camp Nurse or Doctor?</h4>
            <p className="text-gray-600 text-center">At Arrowhead Camp we have a dedicated group of nurses and/or health care providers who ensure excellent healthcare and support is available for the entire camp family.  Since we are so close to Huntsville, if there is need to see a doctor, we take the camper into the local drop in clinic or hospital.</p>
          </div>

          {/* 6th item */}
          <div className="relative flex flex-col items-center p-6 bg-white rounded shadow-xl">
            <svg className="w-16 h-16 p-1 -mt-1 mb-2" viewBox="0 0 64 64" xmlns="http://www.w3.org/2000/svg">
              <g fill="none" fillRule="evenodd">
                <rect className="fill-current text-blue-600" width="64" height="64" rx="32" />
                <g strokeWidth="2">
                  <path className="stroke-current text-white" d="M32 37.714A5.714 5.714 0 0037.714 32a5.714 5.714 0 005.715 5.714" />
                  <path className="stroke-current text-white" d="M32 37.714a5.714 5.714 0 015.714 5.715 5.714 5.714 0 015.715-5.715M20.571 26.286a5.714 5.714 0 005.715-5.715A5.714 5.714 0 0032 26.286" />
                  <path className="stroke-current text-white" d="M20.571 26.286A5.714 5.714 0 0126.286 32 5.714 5.714 0 0132 26.286" />
                  <path className="stroke-current text-blue-300" d="M21.714 40h4.572M24 37.714v4.572M37.714 24h4.572M40 21.714v4.572" strokeLinecap="square" />
                </g>
              </g>
            </svg>
            <h4 className="text-xl font-bold leading-snug tracking-tight mb-1">What treated recommended for COVID-19 Kids?</h4>
            <p className="text-gray-600 text-center">Not all patients with COVID-19 will require medical supportive care. Clinical management for hospitalized patients with COVID-19 is focused on supportive care for complications, including supplemental oxygen and advanced organ support for respiratory failure, septic shock, and multi-organ failure. Empiric testing and treatment for other viral or bacterial etiologies may be warranted.

            The National Institutes of Health has published interim guidelines for the medical management of COVID-19external icon prepared by the COVID-19 Treatment Guidelines Panel.
            
            For information on investigational therapies, see Therapeutic Options for Patients with COVID-19.</p>
          </div>

        </div>

        </div>
      </div>
    </section>
  );
}

export default Healthy;
