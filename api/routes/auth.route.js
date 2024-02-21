const express=require('express')
const { signup } = require('../controller/auth.controller')
const { deflate } = require('zlib')
const router=express.Router()
router.post('/signup',signup)

// export default router
module.exports=router