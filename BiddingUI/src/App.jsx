import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Pages/Login';
import Signup from './Pages/Register';
import './App.css';
import Bidding from './Pages/Bidding';
import Property from './Pages/Property';

import { PropertyProvider } from './context/PropertyContext';

function App() {
  return (
    <Router>  
      <PropertyProvider>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/bidding" element={<Bidding />} />
          <Route path="/property/:id" element={<Property />} /> {/* Ensure that the :id parameter is passed correctly */}
        </Routes>
      </PropertyProvider>
    </Router>
  );
}

export default App;
