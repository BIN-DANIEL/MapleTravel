import React from 'react';

function Newsletter() {
  return (
    <section>
      <div className="max-w-6xl mx-auto px-4 sm:px-6">
        <div className="pb-12 md:pb-20">

          {/* CTA box */}
          <div className="relative bg-gray-900 rounded py-10 px-8 md:py-16 md:px-12 shadow-2xl overflow-hidden" data-aos="zoom-y-out">

            {/* Background illustration */}
            <div className="absolute right-0 bottom-0 pointer-events-none hidden lg:block" aria-hidden="true">             
              
            
            <img src={require('../images/Picture2.jpg')} width="480" height="408"  />
            </div>

            <div className="relative flex flex-col lg:flex-row justify-between items-center">

              {/* CTA content */}
              <div className="text-center lg:text-left lg:max-w-xl">
                <h3 className="h3 text-white mb-2">Discover the Place</h3>
                <p className="text-gray-300 text-lg mb-6">Arrowhead Camp占地26英亩，可俯瞰美丽清澈的海湾湖。营地距多伦多240公里，距渥太华320公里，位于风景如画的马斯科卡、阿尔冈金公园和亨茨维尔之间。</p>

                {/* CTA form */}
                <form className="w-full lg:w-auto">
                  
                  {/* Success message */}
                  {/* <p className="text-sm text-gray-400 mt-3">Thanks for subscribing!</p> */}
                  <p className="text-sm text-gray-400 mt-3">营地很容易开车到达，因此他们鼓励首次露营者的父母在允许的情况下尽可能自驾将孩子送到营地，让他们有机会看到自己孩子的在营状况及工作人员的情况。
                  营地提供接送巴士（单程或回程），如需要相关服务的话可以与Arrowhead counselors联系，渥太华和多伦多都有发车点，需额外收费。
                  </p>
                </form>
              </div>

            </div>

          </div>

        </div>
      </div>
    </section>
  );
}

export default Newsletter;
