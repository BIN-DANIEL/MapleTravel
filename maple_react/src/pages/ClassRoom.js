import React, { useState } from "react";
import Form from "../form/Form";
import useStyles from "../hook/UseStyles";
import Zoom from "../zoom/Zoom";
import { Link } from 'react-router-dom';
import Header from '../partials/Header';
import URLs from '../partials/URL.js';
import $ from 'jquery';
window.$ = $;


const API_KEYS = {
  apiKey: process.env.REACT_APP_ZOOM_API_KEY,
  apiSecret: process.env.REACT_APP_ZOOM_API_SECRET_KEY,
};

const PATH = {
  formCssUrl: process.env.REACT_APP_ZOOM_FORM_CSS_URL,
  mainCssUrl: process.env.REACT_APP_ZOOM_MAIN_CSS_URL,
};

console.log("api key ::", API_KEYS.apiKey);
console.log("api key ::", API_KEYS.apiSecret);
console.log("PATH ::", PATH);

const zoomConfig = {
  apiKey: API_KEYS.apiKey, // can create from here https://marketplace.zoom.us/
  apiSecret: API_KEYS.apiSecret, // can create from here https://marketplace.zoom.us/
  meetingNumber: "9115168986",
  // meeting id generated when schedule a meeting in https://zoom.us/meeting/schedule
  // !!warning
  // meetingNumber must not have white space between numbers
  // 518 306 2219 - bad format
  // 5183062219 - good format
  leaveUrl: "https://zoom.us/",
  userName: "Yimiao Cao", // (required)
  userEmail: "", // (optional) must be the attendee email address
  passWord: "6XDwX6",
  // !!warning, this is the passcode for meeting room, not for user password
  role: 0, // 0 for guest, 1 for host
};

const ClassRoom = () => {
  const [config, setConfig] = useState(zoomConfig);
  const [isSubmitted, setIsSubmitted] = useState({
    stylePath: PATH.formCssUrl,
    status: false,
  });
  const { userName } = config;
  const { stylePath } = isSubmitted;

  const handleChange = (e) => {
    setConfig({
      ...config,
      [e.target.id]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!userName.length) return;

    setIsSubmitted({
      stylePath: PATH.mainCssUrl,
      status: true,
    });
  };

  useStyles(stylePath);

  return (
    <>
      <Form
        handleSubmit={handleSubmit}
        handleChange={handleChange}
        config={config}
      />
      <Zoom isSubmitted={isSubmitted} meetConfig={config} />
    </>
  );
};

export default ClassRoom;
