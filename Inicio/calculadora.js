var nome = "minha calculadora V1";

function soma(a,b){
    return a+b;
}

function mult(a,b){
    return a*b;
}

function sub(a,b){
    return a-b;
}

function div(a,b){
    return a/b;
}

module.exports = { //Multiplas funções podem ser exportadas em blocos como pode ser observado. 
    soma,
    mult,
    sub,
    div,
    nome
}; // também podem ser exportadas variáveis