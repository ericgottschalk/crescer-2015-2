function CarrinhoDeComprasChantagista(){
	CarrinhoDeCompras.apply(this, arguments);
};

CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

CarrinhoDeComprasChantagista.prototype.forcarCompra = function(){
  if (!this.intervalo){
    var self = this;
    this.intervalo = setInterval(function() {
      self.basket.forEach(function(t) {
        t.valorUnitario += t.valorUnitario * 0.1;
        console.log(t.valorUnitario);
      });
    }, 5000);
  }
};

CarrinhoDeComprasChantagista.prototype.concluirPedido = function(){
  clearInterval(this.intervalo);
  delete this.intervalo;
};
