const express = require('express');
const router = express.Router();
const userController = require('../controller/user.controller');
router.get('/test', userController.test);
module.exports = router;