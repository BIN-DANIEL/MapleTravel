import firebase from "firebase/app"
import "firebase/auth"
const app = firebase.initializeApp(
{
    apiKey: "AIzaSyDFQlWk5ElX5rTAGLijGjDfnV9m2BaV0bQ",
    authDomain: "healthytrack-c170c.firebaseapp.com",
    projectId: "healthytrack-c170c",
    storageBucket: "healthytrack-c170c.appspot.com",
    messagingSenderId: "63981302103",
    appId: "1:63981302103:web:1c7aac74e5a75a1a534e12",
    measurementId: "G-KTTJ0M8XZW"

}
)
export const auth = app.auth()
export default app
