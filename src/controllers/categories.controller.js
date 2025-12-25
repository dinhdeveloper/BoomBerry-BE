const pool = require("../config/db");

exports.getAllCategories = async (req, res) => {
  try {
    const result = await pool.query(
      "SELECT * FROM categories ORDER BY category_id"
    );

    return res.status(200).json({
      success: true,
      data: result.rows,
      message: null,
    });
  } catch (err) {
    console.error("DB ERROR:", err);

    return res.status(500).json({
      success: false,
      data: null,
      message: "Internal server error",
    });
  }
};