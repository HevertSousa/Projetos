var http = require("http"); //modulo já presente no nodeJS

http.createServer(function(requisicao, resposta){//recebe a requisição do usuário e envia uma resposta a ele.
    resposta.end("<h1>Bem vindo ao meu site</h1><br><h4>Hevert Soares de Sousa</h4>");
}).listen(8181);

console.log("Meu srvidor está rodando...");