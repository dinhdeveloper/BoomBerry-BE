const express = require("express");
const path = require("path");
const app = express();

app.use(express.json());

// Serve static folder
// Nếu assets nằm trong public, URL sẽ bắt đầu từ /assets
app.use("/assets", express.static(path.join(__dirname, "public/assets")));

// Routes
app.use("/api/categories", require("./routes/categories.route"));

module.exports = app;
