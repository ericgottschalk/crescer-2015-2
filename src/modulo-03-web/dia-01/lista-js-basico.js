/*
 * Faça uma função chamada daisyGame que receba por argumento o número de pétalas da margarida e retorne 'Love me' ou 'Love me not'
 */

function daisyGame(n){
 	if (typeof n === 'number')
 		return 'Love me' + (n % 2 == 0 ? ' not' : '');

	return NaN;
};


/*
 * Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto com maior número de caracteres.
 */

function maiorTexto(strArray){
	var maior = '';
	for (var prop in strArray){
		if (typeof strArray[prop] === 'string')
			if (strArray[prop].length > maior.length)
				maior = strArray[prop];
	}

	return maior;
};


/*
 *	Faça uma função chamada imprime que receba dois parâmetros:
 *		*Um array de strings e uma função.
 *	Dentro da função imprime chame a função do segundo parâmetro para cada elemento do array.
 */

function escreveNome(nome){
	console.log('Olá querido instrutor: ', nome);
};


function imprime(array, f){
	if (typeof f !== 'function')
		return 'JABULANI: TypeError: ' + typeof f + ' is not a function';

	for (var prop in array)
 		if (typeof array[prop] === 'string')
 			f(array[prop]);
};


/*
 * Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados.
 */

function fibo(n){
  if (n == 1 || n == 2)
	return 1;

  return fibo(n - 1) + fibo(n - 2);
};

function fiboSum(n){
	var sum = 0;

	if (typeof n !== 'number')
		return NaN;

	for (var i = 1; i <= n; i++)
		sum += fibo(i);

	return sum;
};

/*
 * Faça uma função excelis que receba uma string que seja uma referência válida para uma coluna Excel e retorne o valor que representa aquela coluna.
 */

function excelis(str){
	if (typeof str !== 'string')
		return 'Not a string';

	var value = 0;
	str = str.toUpperCase();
	for (var i = 0; i < str.length; i++){
		var chrNum = str.charCodeAt(i) - 64;
		value = chrNum + 26 * value;
	}

	return value;
};


/*
 * Escreva uma função queroCafe que recebe dois parâmetros:
 *   mascada: Valor numérico
 *   precos: Lista de preços de café
 * A sua implementação deve retornar uma string com todos os preços que estão abaixo
   ou igual ao valor mascada ordenados de forma ascendente e separados por ,
 */

function queroCafe(mascada, precos){
  var strPrecos = '';
	precos = precos.filter(function(x) { if (typeof x === 'number') return x <= mascada;
							 }).sort(function(x, y) { return x > y; } );

	return strPrecos += precos;
};
