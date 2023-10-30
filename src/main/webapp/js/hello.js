console.log("Xin chao hny");
const url ="http://localhost:8080/demo-api";
fetch(url)
	.then(function (response){
		return response.text()
	})
	.then(function (data){
		console.log(data)
	})