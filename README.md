# Tema **DimAna**, grupo **dimana-01**
-----
Nota: 16.9
## Constituição dos grupos e participação individual global

| NMec | Nome | email | Participação |
|:---:|:---|:---|:---:|
| 108122 | ALEXANDRE PEDRO RIBEIRO | alexandrepribeiro@ua.pt | 8.0% |
| 107637 | ANDRÉ ALMEIDA OLIVEIRA | andreaoliveira@ua.pt | 23.0% |
| 105926 | BERNARDO LEITÃO DA COSTA PINTO | bernardopinto@ua.pt | 8.0% |
| 107471 | FILIPE DE ORNELAS DIOGO OBRIST | filipe.obrist@ua.pt | 8.0% |
| 107188 | JOSÉ PEDRO SANTOS MENDES | mendes.j@ua.pt | 23.0% |
| 108969 | RODRIGO SILVA AGUIAR | rodrigoaguiar96@ua.pt | 30.0% |

## Estrutura do repositório

- **src** - deve conter todo o código fonte do projeto.

- **doc** -- deve conter toda a documentação adicional a este README.

- **examples** -- deve conter os exemplos ilustrativos das linguagens criadas.

    - Estes exemplos devem conter comentários (no formato aceite pelas linguagens),
      que os tornem auto-explicativos.

## Relatório

O objetivo geral deste trabalho era o desenvolvimento
de uma linguagem de programação compilada que permitisse
o uso de análise dimensional nas expressões numéricas.
Pretende-se estender o sistema de tipos de uma linguagem de
programação com a possibilidade de definir dimensões distintas 
a expressões numéricas (ex. definir undidade metro e segundo ou 
definir velocidade como distancia/tempo). O sistema de tipos de 
linguagem também deve permitir álgebra sobre dimensões, assim como a 
validação da mesma. Para tal, foi necessário aplicar uma álgebra
dimensional com regras de:

- comparações, atribuições de valor, somas e subtracções apenas para a mesma dimensão;

- multiplicações e divisões aplicáveis a expressões dimensionais a gerar outra dimensão;

- multiplicações e divisões por expressões adimensionais a manter a mesma dimensão;

Neste trabalho, foi desenvolvido todas as características da linguagem de modo a alcançar os 
objetivos acima definidos. Para além das características minimas, a linguagem foi desenvolvida para permitir alguns
objetivos desejáveis:
- Permitir a definição de expressões booleanas
- Incluir a instruição condicional (sobre expressões booleanas)
- Incluir outras Instruções repetitivas (sobre expressões booleanas)
- Permitir a definição de valores dimensionais literais com sufixo (Ex: Length l = 5m;)

Para isto foram desenvolvidas quatro componentes que tratam de cada uma das fases de compilação:

- Gramática principal da linguagem

- Gramática secundária ( precompilador )

- Análise Semântica 

- Geração de código

A gramática principal ( desenvolvida em ANTLR4 ) é responsável por receber o ficheiro de input e gerar os respétivos tokens ( a partir de um Lexer) e posteriormente uma árvore sintática ( a partir de um Parser).

A gramática secundária tem como objetivo lidar com o a expressão 'use' que pretende importar um ficheiro de dimensões.
Esta gramática é responsável por substituir qualquer ocorrência desta expressão pelo conteúdo do ficheiro respétivo, funcionando similarmente ao 'include' da linguagem C.

Na análise semântica é feita a verificação de todos os requisitos da linguagem, nomeadamente a verificação de tipos, a verificação de dimensões e a verificação de variáveis não declaradas. Esta é fundamental para garantir que o código gerado é válido e que não existem erros de compilação e também que qualquer erro de utilizador ( ou má utilização da linguagem ) é reportado.

A geração de código é feita através do padrão visitor do ANTLR4, que vai iterar a arvore sintática gerada pelo Parser nó a nó, fazendo a geração do código respétivo para cada nó. 
Neste projeto usamos como target language a linguagem Java, pelo que o código gerado é código válido da linguagem Java.
Para a geração de código foi utilizada a ferramenta StringTemplate4, que nos permitiu gerar código de forma simples e eficiente.

No Documento REPORT.md ( presente na pasta doc ) é explicado com mais pormenor cada uma destas fases e cada requisito implementado e respetivos detalhes.


## Como executar o programa

No diretório examples, os scripts:

- build.sh -> compilam todas as classes e gramáticas do ANTLR4 utilizadas

- compile.sh -> compilam um exemplo em especifico. 

Exemplo de utilização:

``` ./compile.sh example1.da ```

- run.sh -> executa o ficheiro Java resultante da compilação de um exemplo

Exemplo de utilização:

``` ./run.sh example1Compiled ```


Todos os exemplos compilados são guardados na pasta Results, sendo que nesta pasta também se encontra a classe DimensionVar, utilizada para representar variáveis de dimensões.

## Contribuições

- Alexandre Pedro Ribeiro

      - Análise Semântica ( Redução de frações de dimensões )
      - Alterações na gramática principal
      - Relatório
      - Documentação adicional

- André Almeida Oliveira

      - Gramática principal da linguagem (Compiler)
      - Análise Semântica (Compiler)
      - Geração de código (Compiler)
      - Exemplos
      - Relatório
      - Documentação adicional

- Bernardo Leitão da Costa Pinto

      - Análise Semântica (Compiler)
      - Relatório
      - Documentação adicional

- Filipe de Ornelas Diogo Obrist

      - Análise Semântica (Compiler)
      - Relatório
      - Documentação adicional

- José Pedro Santos Mendes

      - Gramática para preprocessamento da linguagem (Precompiler)
      - Geração de ficheiro temporário com o código preprocessado (Precompiler)
      - Gramática principal da linguagem (Compiler)
      - Geração de código do compilador (Compiler)
      - Relatório
      - Documentação adicional

- Rodrigo Silva Aguiar

      - Análise Semantica (Compiler)
      - Geração de código (Compiler)
      - Alterações na gramática principal
      - Exemplos
      - Relatório
      - Documentação adicional
