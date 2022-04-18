var soma_func = require("./calculadora");

function mult(a,b){
    return a*b;
}
function sub(a,b){
    return a-b;
}
function div(a,b){
    return a/b;
}
console.log(soma_func(10,20));
var resultado = mult(10,10);
var resultado_sub = sub(20,40);
console.log(div(10,2));
console.log(resultado);
console.log(resultado_sub);


/* var mostraSite = false;
const site = "www.guiadoprogramador.com";
console.log("Hello World");
console.log("Meu nome é Hevert");
console.log("Estou aprendendo javaScript com node");

if(mostraSite){ //se mostrar site 
    console.log(site);//Printe o site
} */