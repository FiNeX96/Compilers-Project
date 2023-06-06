# Dimana Grupo 1 

Neste documento, iremos entrar mais em detalhes nos requisitos implementados na linguagem DimAna desenvolvida, com o objetivo de facilitar a compreensão do código fonte e como o utilizar.

Foram desenvolvidos vários exemplos para mostrar as capacidades tanto da geração de código como da análise semântica desta linguagem, que se encontram na pasta examples. Estes exemplos apresentam vários comentários, de modo a serem auto-explicativos.

No total foram implementados todos os requesitos mínimos e os 4 primeiros requesitos desejáveis, estando a documentação de cada um destes presente abaixo.


## Requisitos Minimos

Todos os requisitos minimos foram implementados com sucesso, sendo testados com vários inputs para garantir que o programa se comporta como esperado.

## Instrução para definir uma nova dimensão

É possível definir tanto dimensões independentes ( que não dependem de outras dimensões) como dimensões dependentes (que dependem de outras dimensões), através da instrução "dimension {tipo_dados} {nome_dimensão} [{unidade_base}]".

Exemplo de definição de uma uma dimensão independente:

``` dimension real Grade [val]; ```

Exemplo de definição de uma uma dimensão dependente:

``` dimension real Velocity = Length/Time; ```

Para dimensões dependentes, a expressão ( multiplicação ou divisão entre dimensões ) é sempre decomposta o máximo possível ( decompondo dimensões dependentes caso existam na expressão em dimensões independentes ) e posteriormente  reduzida à menor fração possível, para garantir que não é declarada uma dimensão repetida.

Apenas é possível declarar dimensões com base nos tipos de dados númericos ( integer e real ).

## Instrução para definir uma nova unidade

É possível definir uma nova unidade para uma dimensão já existente, através da instrução "unit nome_dimensão [<unit-name>,<suffix-name>] = {expressão}".

É verificado através de análise semântica que a dimensão resultante da expressão corresponde à dimensão devida ( dimensão do qual se está a tentar criar uma nova unidade ).

Em termos de geração de código, todas as unidades são convertidas para a unidade base da dimensão, sendo que a conversão é feita através de uma multiplicação ou divisão pela expressão que define a unidade, como se pode ver no exemplo "mult_ex2.da".


## Tipos de dados

É possivel declarar variáveis de todos os tipos de dados pretendidos ( inteiro, real, texto e lista ), e também aceder aos valores destas variáveis propriamente, como se pode ver nos vários exemplos.


## Expressões aritméticas

Todas as unidades de dados suportam expressões aritméticas entre si, como somas, subtrações, multiplicações e divisões, desde que as dimensões sejam compatíveis.

No caso de somas e subtrações, apenas é possível somar ou subtrair valores com a mesma dimensão, sendo tratado casos na análise semântica em que se tenta somar ou subtrair valores com dimensões diferentes.

No caso de multiplicações e divisões, é possível multiplicar ou dividir valores com dimensões diferentes, desde que a dimensão resultante duma operação deste tipo esteja definida.

Por exemplo:

dimension real Length [meter,m];
dimension real Area = Length*Length;

Length l1 = 2.0m;
Length l2 = 3.0m;

l1 * l2 -> resulta numa expressão com o tipo de dados Length*Length, logo podendo ser atribuido o resultado a uma variável da dimensão Area.

l1 / l2 -> resulta numa expressão com o tipo de dados Length/Length, ou seja, um valor real, pelo que pode ser atribuida a uma variável do tipo real.

Mais casos são tratados na análise semântica para garantir que a dimensão resultante de uma expressão aritmética entre variaveis/valores de duas dimensões diferentes correspondem à dimensão correta.

É possível concatenar strings com o operador "+", como se pode ver compilando o exemplo "text_concat.da".


## Instrução de escrita

É possível escrever variáveis, strings, ou variáveis/expressões/string com right-align no terminal através das expressões 'write', que escreve no terminal sem mudar de linha, e 'writeln', que escreve no terminal e muda de linha.

Varios exemplos de escrita válida são fornecidos nos vários exemplos na pasta examples.


## Instrução de leitura a partir do standard input

É possível ler valores para variáveis de todos os tipos de dados a partir do standard input, através da instrução 'read'.

É também possível ler valores e fazer um cast para uma dimensão, assumindo que é lido um valor do tipo de dados correspondente à dimensão.

## Operação de conversão de dados

É possível fazer a conversão entre os tipos de dados real/integer/string, através de instruções do tipo:

``` string(10) -> converte o valor 10 para uma string ```

``` real("10") -> converte o valor 10 para um real ```

``` integer("10") -> converte o valor 10 para um integer ```

É verificado semânticamente se o tipo de dados de origem e destino são compatíveis, e se o valor a converter é válido para o tipo de dados de destino.


## Adicionar elemento ao fim de uma lista

É possível adicionar um elemento ao fim de uma lista, através de uma instrução do tipo:

```read "Name: " >> names;```

É verificado semânticamente se o tipo de dados lido é compativel com o tipo de dados da lista, e se o valor lido é válido para o tipo de dados da lista.
Tal como pretendido, as listas começam sempre no indice 1, sendo adicionado um elemento nulo ao inicio da lista sempre que ela é criada.

Esta tradução é traduzida na geração de código para uma instrução do tipo {nome_array}.add({elemento}) em java, instrução esta válida para listas da Interface java.util.ArrayList, a qual usamos para representar listas neste projeto.

## Operadores para aceder ao elemento de uma lista

Através da expressão 'get {nome_lista} [{indice}]', é possível aceder diretamente a um  índice duma lista pretendido, sendo verificado semanticamente se esta lista já existe.

Por si própria, esta expressão não tem efeito, pelo que um uso devido desta deverá ser do tipo:

( assumindo que names é um arraylist do tipo String )

```string x = get names[3];```   

Desta forma, a string x ficará com o valor do elemento da lista names no índice 3. ( este índice 3 é o 4º valor da lista, sendo a indexação nesta instrução feita a partir do índice 0 ).

Outros exemplos do uso deste operador podem ser vistos no exemplo "array_get.da"

Também é possível aceder a elementos de uma lista através de um índice que é uma variável iterada, como se pode ver compilando o exemplo "example2.da".



## Instrução de iteração ( loop )

É possível fazer uma iteração entre valores inteiros / ou variáveis do tipo integer, através da expressão:

```for i = 1 to N do  { instruções } end;```

No caso do uso de inteiros como valor inicial e final, é verificado semânticamente se o valor inicial é menor que o valor final.
O uso desta instrução é feito no exemplo "example2.da".

## Instrução para incluir o conteúdo de outro ficheiro

Seguindo a lógica dos exemplos fornecidos pelo professor, neste projeto, usamos o seguinte formato para incluir o conteúdo de outro ficheiro:

```use "{nome_ficheiro.da}";```

De modo a que esta instrução podesse ser utilizada com sucesso, foi desenvolvida uma gramática secundária, um precompilador.
O precompilador, antes da análise semântica, ou geração de código, visita cada nó, substituindo o nó de inclusão de ficheiro pelo conteúdo do ficheiro incluido.
Após isto, o precompilador gera um novo ficheiro, chamado temp.da, sendo executada a classe main com este ficheiro como argumento.

## Análise semântica do sistema de tipos

Sendo o maior objetivo deste trabalho uma análise dimensional de expressões numéricas e tipos definidos, foi desenvolvida uma análise semântica que garante que as operações aritméticas e lógicas são feitas entre tipos de dados compatíveis, e que as dimensões resultantes de operações aritméticas são as corretas.

Esta analise semântica garante que os seguintes aspetos são cumpridos :

- Não são declaradas variáveis repetidas

- Não sao atribuidas expressões de uma dimensão a variaveis de outra dimensão

- Não sao feitas operações aritméticas entre tipos de dados invalidos

- Não são usados nomes reservados da linguagem Java como nomes de variáveis

- Não são declaradas dimensões repetidas ( com a mesma representação )

- Em operações aritméticas, as dimensões resultantes são as corretas

- Não são usadas variáveis não declaradas

- Não são feitos casts inválidos entre tipos de dados

- Não são declaradas expressões inválidas dentro de loops, como por exemplo, criar uma variável dentro dum for loop

- Entre outros...

Estes são apenas alguns aspetos da análise semântica, sendo que a mesma é muito mais abrangente, pois tentamos ao máximo garantir que antes de haver a geração de qualquer código, o input dado era analisado e verificado se era válido.

Esta análise semântica também é responsável por gerar as variáveis, listas e dimensões que posteriormente são utilizadas na geração de código.

Vários exemplos de erros semânticos podem ser vistos no exemplo "semantic_errors.da", encontrando-se documentados com comentários, para se perceber o que está errado em cada um dos inputs.


## Requisitos Desejáveis

## Expressões booleanas, operadores de ordem e operadores booleanos

É possível o uso de expressões booleanas entre variáveis do tipo de dados real, integer e strings através de operadores ( <, >, <=, >=, ==, != ). É também possível o uso de operadores booleanos ( &&, ||) entre expressões booleanas.

É verificado semânticamente se o tipo de dados de origem e destino são compatíveis, e se o valor a converter é válido para o tipo de dados de destino. A comparação entre integer e real é possível, sendo que o integer é convertido para real. Já a conparação entre strings e integer/real não é possível.

## Expressões condicionais

É possível operar sobre expressões booleanas através de expressões condicionais do tipo:

```if (expressão_booleana) {instruções} else {instruções} ```
ou apenas
```if (expressão_booleana) {instruções} ```

É verificado semânticamente se a expressão booleana é válida, e se as instruções são válidas, já explicado anteriormente.

## Instruções repetitivas 

É possível repetir um conjunto de instruções enquanto uma expressão booleana for verdadeira, através de instruções do tipo:

```while (expressão_booleana) {instruções} ```
e
```do {instruções} while (expressão_booleana) ```

É verificado semânticamente se a expressão booleana é válida, e se as instruções são válidas, já explicado anteriormente.

## Definição de valores dimensionais literais com sufixo

É possível definir valores dimensionais literais com sufixo, como por exemplo:

```Length l1 = 2.0m;```

É verificado semânticamente se o sufixo e o valor são válidos para o tipo de dados de destino.




