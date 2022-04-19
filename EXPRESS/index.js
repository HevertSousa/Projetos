const { application } = require("express");
const express = require("express"); //importanto o express
const app = express(); //Iniciando o express através da variável app

//Iniciando o servidor express aqui estão os parametros necessários.
app.listen(4000,function(erro){
    if(erro){
        console.log("Ocorreu um erro");
    }else{
        console.log("Servidor iniciado com sucesso");
    }
})

