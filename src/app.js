require("dotenv").config();
const express = require("express");

const app = express();

app.use(express.json());

// routes
app.use("/api/categories", require("./routes/categories.route"));

module.exports = app;