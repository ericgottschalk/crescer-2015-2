Date.prototype.bissexto = function() {
	return (this.getFullYear() % 4 === 0)
	 && (this.getFullYear() % 100 !== 0) 
	|| this.getFullYear() % 400 === 0;
};