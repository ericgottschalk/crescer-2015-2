String.prototype.palindromo = function(){
	var text = this.toUpperCase();
	var reverse = text.split('').reverse().join('');

	return text === reverse;
};