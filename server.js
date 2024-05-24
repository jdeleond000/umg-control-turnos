const express = require('express');
const path = require('path');
const app = express();

const appPath = __dirname + '/dist/AngularMaterial';
app.use(express.static(appPath));

// Send all requests to index.html
app.get('/*', function(req, res) {
  res.sendFile(path.join(appPath, 'index.html'));
});

// Default Heroku port
app.listen(process.env.PORT || 8080);
