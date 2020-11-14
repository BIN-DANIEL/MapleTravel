import React, { useEffect } from "react";
import { ZoomMtg } from "@zoomus/websdk";

let apiKeys = {
  apiKey: process.env.REACT_APP_ZOOM_API_KEY,
  apiSecret: process.env.REACT_APP_ZOOM_API_SECRET_KEY,
};

const meetConfig = {
  apiKey: apiKeys.apiKey,
  meetingNumber: "9115168986",
  userName: "Yimiao Cao",
  userEmail: "cao223@wisc.edu", // must be the attendee email address
  passWord: "6XDwX6",
  role: 0,
  leaveUrl: "https://zoom.us/"
};




const joinMeeting = (signature, meetConfig) => {
  ZoomMtg.init({
    leaveUrl: meetConfig.leaveUrl,
    isSupportAV: true,
    success: function (success) {
      console.log("Init Success ", success);
      ZoomMtg.join({
        meetingNumber: meetConfig.meetingNumber,
        userName: meetConfig.userName,
        signature: signature,
        apiKey: meetConfig.apiKey,
        passWord: meetConfig.passWord,

        success: (success) => {
          console.log(success);
        },

        error: (error) => {
          console.log(error);
        },
      });
    },
  });
}

const Zoom = ({meetConfig, isSubmitted}) => {

  useEffect(() => {
    if(isSubmitted.status) {
      // setZoomJSLib version 1.8.1 caused breaking, must be same as installed package verision
      // installing this of version 1.7.x caused breaking
      ZoomMtg.setZoomJSLib("https://source.zoom.us/1.8.1/lib", "/av");
      ZoomMtg.preLoadWasm();
      ZoomMtg.prepareJssdk();
  
      /**
       * You should not visible api secret key on frontend
       * Signature must be generated on server
       * https://marketplace.zoom.us/docs/sdk/native-sdks/web/essential/signature
       */
      ZoomMtg.generateSignature({
        meetingNumber: meetConfig.meetingNumber,
        apiKey: meetConfig.apiKey,
        apiSecret: meetConfig.apiSecret,
  
        role: meetConfig.role,
        success: function (res) {
          console.log("res", res);
  
          setTimeout(() => {
            joinMeeting(res.result, meetConfig);
          }, 1000);
        },
      });
    }

  }, [meetConfig, isSubmitted]);

  return <></>;
}

export default Zoom;
