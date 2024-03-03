const express=require('express')
const { signup, signin } = require('../controller/auth.controller')
const { deflate } = require('zlib')
const router=express.Router()
router.post('/signup',signup)
router.post('/signin',signin)

// export default router
module.exports=router