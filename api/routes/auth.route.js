const express=require('express')
const { signup, signin, google } = require('../controller/auth.controller')
const { deflate } = require('zlib')
const router=express.Router()
router.post('/signup',signup)
router.post('/signin',signin)
router.post('/google',google)
// export default router
module.exports=router