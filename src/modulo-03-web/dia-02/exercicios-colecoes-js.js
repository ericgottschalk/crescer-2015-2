var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

function ordenaPorIndice(indice, array){
  //return array.sort((t, k) => t.titulos[indice].qtd < k.titulos[indice].qtd);
  return array.concat().sort(function(t, k){
                        return t.titulos[indice].qtd < k.titulos[indice].qtd;
                    });
};

function somar(indice, array){
  return array.reduce(function(sum, atual){
                        return sum += atual.titulos[indice].qtd;
                      }, 0);
};

/* 1.1
 * Crie uma função chamada ordenaPorNacionais(Array) que recebe o array de clubes
   e retorna o array ordenado pela quantidade de títulos Nacionais descendente (Z->A).
 */

function ordenaPorNacionais(array){
    return ordenaPorIndice(0, array);
};


/* 1.2
 * Crie uma função chamada ordenaPorContinentais(Array) que recebe o array de clubes
   e retorna o array ordenado pela quantidade de títulos Continentais descendente (Z->A).
 */

function ordenaPorContinentais(array){
  return ordenaPorIndice(1, array);
};


/* 1.3
 * Crie uma função chamada ordenaPorMundiais(Array) que recebe o array de clubes
   e retorna o array ordenado pela quantidade de títulos Mundiais descendente (Z->A).
 */

function ordenaPorMundiais(array){
   return ordenaPorIndice(2, array);
};


/* 2.1
 * Crie uma função chamada somarPorNacionais(Array) que recebe o array de clubes
   e retorna o somatório de todas quantidades de títulos nacionais entre os clubes do array.
 */

function somarPorNacionais(array){
  return somar(0, array);
};


/* 2.2
 * Crie uma função chamada somarPorContinentais(Array) que recebe o array de clubes
   e retorna o somatório de todas quantidades de títulos continentais entre os clubes do array.
 */

function somarPorContinentais(array){
  return somar(1, array);
};


/* 2.3
 * Crie uma função chamada somarPorTodosTitulos(Array) que recebe o array de clubes
   e retorna o somatório de todas quantidades de todos os títulos entre os clubes do array.
 */

function somarPorTodosTitulos(array){
  return somar(0, array) + somar(1, array) + somar(2, array);
};


/* 3
 * Escreva uma função chamada apenasOsMelhores(Array) que recebe o array de clubes
   e retorna apenas os clubes que têm mais de 18 títulos ingleses.
 */

function apenasOsMelhores(array){
  //return array.filter(t => t.titulos[0].qtd > 18);
  return array.filter(function(t){
                        return t.titulos[0].qtd > 18;
                      });
};
