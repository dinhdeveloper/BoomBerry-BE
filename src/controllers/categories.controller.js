const pool = require("../config/db");

exports.getCategories = async (req, res) => {
  try {
    const result = await pool.query("SELECT * FROM categories ORDER BY category_id");
    res.status(200).json({
      success: true,
      data: result.rows,
      message: "Categories fetched successfully"
    });
  } catch (err) {
    console.error(err); // Log lỗi ra console
    res.status(500).json({
      success: false,
      data: null,
      message: "Internal server error",
    });
  }
};