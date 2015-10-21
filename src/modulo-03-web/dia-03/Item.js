function Item(sku, desc, quant, valor){
	this.sku = sku;
	this.descricao = desc;
	this.quantidade = quant;
	this.valorUnitario = valor;
};

Item.prototype.getSubTotal = function(first_argument) {
	return this.quantidade * this.valorUnitario;
};
