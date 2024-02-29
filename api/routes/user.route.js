const express = require('express');
const router = express.Router();
const userController = require('../controller/user.controller');

// Define the route with the correct controller method
router.get('/test', userController.test);

module.exports = router;