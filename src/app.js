const express = require("express");
const path = require("path");
const app = express();

app.use(express.json());

// ===== Serve static files =====
app.use("/assets", express.static(path.join(__dirname, "assets")));

// Routes
app.use("/api/categories", require("./routes/categories.route"));

module.exports = app;