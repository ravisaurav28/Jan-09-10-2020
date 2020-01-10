let app = require("express")();
app.get("/hello", (req, res) => {
	res.end("hello server");
});
app.listen(8000);
console.log("Server started in 8000");