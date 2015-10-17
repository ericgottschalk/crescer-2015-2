/*
 * Faça uma função chamada daisyGame que receba por argumento o número de pétalas da margarida e retorne 'Love me' ou 'Love me not' 
 */

function daisyGame(n)
{
	if (typeof n === 'number')
	{
		if (n % 2 == 0)
			return 'Love me not';

		return 'Love me';
	}

	return NaN;
}


/*
 * Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto com maior número de caracteres.
 */

function maiorTexto(strArray)
{
	var maior = '';
	for (var prop in strArray)
	{
		if (typeof strArray[prop] === 'string')
			if (strArray[prop].length > maior.length)
				maior = strArray[prop];
	}

	return maior;
}


/*
 *	Faça uma função chamada imprime que receba dois parâmetros:
 *		*Um array de strings e uma função.
 *	Dentro da função imprime chame a função do segundo parâmetro para cada elemento do array. 
 */

function escreveNome(nome)
{
	console.log('Olá querido instrutor: ' nome);
} 


function imprime(array, f)
{
	if (typeof f !== 'function')
		return 'JABULANI: TypeError: ' + typeof f + ' is not a function';
	
	for (var prop in array)
 	{
 		if (typeof array[prop] === 'string')
 			f(array[prop])
    }
}