const app = require("./app");

const PORT = process.env.PORT || 3000; // Render sẽ cung cấp PORT
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});