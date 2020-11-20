import React, { useEffect } from 'react';


const useStyles = ( stylePath ) => {
//   const [ stylePath, setStylePath ] = useState("style1.css");
    
//   const handleButtonClick = () => {
//     setStylePath({stylePath: 'style2.css'});
//   }

  useEffect(() => {
      console.log("stlye path ::", stylePath)
    const head = document.head;
    const link = document.createElement("link");

    link.type = "text/css";
    link.rel = "stylesheet";
    link.href = stylePath;

    head.appendChild(link);

    return () => { head.removeChild(link); }

  }, [stylePath]);

  return stylePath;
};


export default useStyles;