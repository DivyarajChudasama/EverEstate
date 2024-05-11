import React, { useContext, useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import PropertyContext from '../context/PropertyContext'; // Import PropertyContext

const Property = () => {
  const { id } = useParams(); // Retrieve property ID from URL
  console.log('Property ID:', id); // Log the property ID to console

  const { selectedProperty } = useContext(PropertyContext); // Access selectedProperty from context

  const [bidAmount, setBidAmount] = useState(''); // State to store bid amount
  const [error, setError] = useState(''); // State to store error messages

  // Function to handle bid submission
  const handleBidSubmit = async () => {
    try {
      // Validate bid amount
      if (!bidAmount) {
        setError('Please enter a bid amount.');
        return;
      }
  
      const currentTime = new Date();
      const biddingEndTime = new Date(selectedProperty.biddingEndTime);
      const duration = Math.round((biddingEndTime.getTime() - currentTime.getTime()) / (1000 * 60));
  
      const bidData = {
        userId: 'currentUserId', // Assuming you have the current user ID
        amount: parseFloat(bidAmount),
        time: currentTime,
        propertyId: id, // Pass propertyId to the backend
      };
  
      // Call API to add bid
      const res = await axios.post(`http://localhost:8000/bids/add/${id}`, bidData);
      console.log('Bid submitted successfully:', res.data);
      // Clear bid amount and error message after successful submission
      setBidAmount('');
      setError('');
    } catch (error) {
      console.error('Error submitting bid:', error);
      setError('An error occurred while submitting your bid. Please try again later.');
    }
  };

  useEffect(() => {
    console.log('Selected Property:', selectedProperty); // Log selected property
  }, [selectedProperty]); // Log whenever selectedProperty changes

  // Check if selectedProperty is null
  if (!selectedProperty) {
    return <div>Loading...</div>;
  }

  return (
    <div className="container mx-auto px-4">
      <h1 className="text-3xl font-bold mb-4">{selectedProperty.title}</h1>
      <div className="custom-card">
        <p className="text-gray-700 mb-4">{selectedProperty.description}</p>
        <div className="flex justify-between mb-2">
          <p className="text-gray-600">Base Price: ${selectedProperty.startingPrice}</p>
          <p className="text-gray-600">Bidding Start Time: {selectedProperty.biddingStartTime}</p>
          <p className="text-gray-600">Bidding End Time: {selectedProperty.biddingEndTime}</p>
        </div>
      </div>
      <div className="mt-4">
        <h2 className="text-xl font-bold mb-2">Place Your Bid:</h2>
        <input
          type="number"
          placeholder="Enter bid amount"
          value={bidAmount}
          onChange={(e) => setBidAmount(e.target.value)}
          className="border border-gray-300 rounded-md px-3 py-2 w-1/3"
        />
        <button onClick={handleBidSubmit} className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ml-4">
          Bid Now
        </button>
        {error && <p className="text-red-500 mt-2">{error}</p>}
      </div>
    </div>
  );
};

export default Property;
