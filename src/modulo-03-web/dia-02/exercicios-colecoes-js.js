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


/* 1.1
 * Crie uma função chamada ordenaPorNacionais(Array) que recebe o array de clubes 
   e retorna o array ordenado pela quantidade de títulos Nacionais descendente (Z->A).
 */

function ordenaPorNacionais(array){
    return array.sort((t, k) => t.titulos[0].qtd < k.titulos[0].qtd);
};


/* 1.2
 * Crie uma função chamada ordenaPorContinentais(Array) que recebe o array de clubes
   e retorna o array ordenado pela quantidade de títulos Continentais descendente (Z->A).
 */

function ordenaPorContinentais(array){
   return array.sort((t, k) => t.titulos[1].qtd < k.titulos[1].qtd);
};


/* 1.3
 * Crie uma função chamada ordenaPorMundiais(Array) que recebe o array de clubes 
   e retorna o array ordenado pela quantidade de títulos Mundiais descendente (Z->A).
 */

function ordenaPorMundiais(array){
   return array.sort((t, k) => t.titulos[2].qtd < k.titulos[2].qtd);
};


/* 2.1
 * Crie uma função chamada somarPorNacionais(Array) que recebe o array de clubes 
   e retorna o somatório de todas quantidades de títulos nacionais entre os clubes do array.
 */

function somarPorNacionais(array){
  var sum = 0;
  array.forEach(t => sum += t.titulos[0].qtd);
  return sum;
};


/* 2.2
 * Crie uma função chamada somarPorContinentais(Array) que recebe o array de clubes 
   e retorna o somatório de todas quantidades de títulos continentais entre os clubes do array.
 */

function somarPorContinentais(array){
  var sum = 0;
  array.forEach(t => sum += t.titulos[1].qtd);
  return sum;
};


/* 2.3
 * Crie uma função chamada somarPorTodosTitulos(Array) que recebe o array de clubes 
   e retorna o somatório de todas quantidades de todos os títulos entre os clubes do array.
 */

function somarPorTodosTitulos(array){
  var sum = 0;
  array.forEach(t => sum += t.titulos[2].qtd);
  return sum;
};


/* 3
 * Escreva uma função chamada apenasOsMelhores(Array) que recebe o array de clubes 
   e retorna apenas os clubes que têm mais de 18 títulos ingleses.
 */

function apenasOsMelhores(array){
  return array.filter(t => t.titulos[0].qtd > 18);
};