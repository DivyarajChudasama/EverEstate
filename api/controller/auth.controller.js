const User=require('../models/user.model.js')
const bcrypt=require('bcrypt')
import { errorHandler } from '../utils/error.js';
const signup=async (req,res,next)=> {
    const {username, email, password}=req.body;
    const hashedPassword= bcrypt.hashSync(password,10);
    const newUser = new User({username,email,password:hashedPassword});
    try
    {
        await newUser.save();
    res.status(201).json('User created successfully')
    }
    catch(error)
    {
       next(errorHandler(550,'Error from the function'));
    }
    
};
module.exports={
    signup
}