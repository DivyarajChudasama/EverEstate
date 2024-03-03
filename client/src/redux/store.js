import { configureStore } from '@reduxjs/toolkit';
import userReducer from './user/userSlice'; // Import the correct reducer

export default configureStore({
  reducer: {
    user: userReducer // Use the imported reducer here
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: false
    })
});
