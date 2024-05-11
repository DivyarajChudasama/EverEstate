import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import './Bidding.css';
import PropertyContext from '../context/PropertyContext';
import { Link } from 'react-router-dom';

const Bidding = () => {
  const [properties, setProperties] = useState([]);
  const { setSelectedProperty } = useContext(PropertyContext);

  useEffect(() => {
    async function fetchProperties() {
      try {
        const res = await axios.post('http://localhost:8000/bidding/properties/all');
        setProperties(res.data instanceof Array ? res.data : []);
      } catch (error) {
        console.error('Error fetching properties:', error);
      }
    }

    fetchProperties();
  }, []);

  return (
    <div className="container mx-auto px-4">
      <h1 className="text-3xl font-bold mb-4">Bidding Properties</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {properties.map((property) => (
          <div key={property.id} className="custom-card">
            <Link to={`/property/${property.id}`} onClick={() => setSelectedProperty(property)}>
              <h2 className="text-xl font-bold mb-2">{property.title}</h2>
              <p className="text-gray-700 mb-4">{property.description}</p>
              <div className="flex justify-between mb-2">
                <p className="text-gray-600">Bidding Start Time: {new Date(property.biddingStartTime).toLocaleString()}</p>
                <p className="text-gray-600">Bidding End Time: {new Date(property.biddingEndTime).toLocaleString()}</p>
              </div>
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Bidding;
