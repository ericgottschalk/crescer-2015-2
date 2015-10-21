function ElfoNoturno(){
  Elfo.apply(this, arguments);
};

ElfoNoturno.prototype = Object.create(Elfo.prototype);

//Override
ElfoNoturno.prototype.atirarFlecha = function (dwarf) {
  Elfo.prototype.atirarFlecha.call(this, dwarf);
  console.log('Elfo noturno');
};

//Static method
ElfoNoturno.mediaDeAlturaElfoNoturno = function() {
  console.log(2.15);
};
