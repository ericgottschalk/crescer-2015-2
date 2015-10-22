function CarrinhoDeCompras(){
	this.basket = [];
};

CarrinhoDeCompras.prototype.getItemIndex = function(sku) {
	return this.basket.map(function(t) { return t.sku; }).indexOf(sku);
};

CarrinhoDeCompras.prototype.adicionarItem = function(item) {
	this.basket.push(item);
};

CarrinhoDeCompras.prototype.removerItem = function(sku) {
	this.basket.splice(this.getItemIndex(sku), 1);
};

CarrinhoDeCompras.prototype.alterarQuantidade = function(sku, quant) {
	this.basket[this.getItemIndex(sku)].quantidade = quant;
};

CarrinhoDeCompras.prototype.getValorTotal = function() {
	var total = 0;

	this.basket.forEach(function(t) {
		total += t.getSubTotal();
	});

	var desconto = total * (this.temDesconto() ? 0.10 : 0);
	return total - desconto;
};

CarrinhoDeCompras.prototype.temDesconto = function() {
	return (Math.random() * (99) + 1) < 40;
};

