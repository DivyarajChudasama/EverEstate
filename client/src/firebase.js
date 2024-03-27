// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: import.meta.env.VITE_FIREBASE_API_KEY,
  authDomain: "mern-estate-5f3b7.firebaseapp.com",
  projectId: "mern-estate-5f3b7",
  storageBucket: "mern-estate-5f3b7.appspot.com",
  messagingSenderId: "80267455311",
  appId: "1:80267455311:web:12fea28912d4415abc733a"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);