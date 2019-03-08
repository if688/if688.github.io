# IF688 - Teoria e Implementação de Linguagens Computacionais

## Atividade 5 - _TypeChecker_ MiniJava

O objetivo deste exercício é criar um _type checker_ para programas MiniJava.

- Use o projeto disponível no [repositório da disciplina](https://github.com/if688/if688.github.io/tree/master/atividades/04-MiniJavaAST). Este projeto inclui classes `Java` representando os nós da AST de MiniJava, bem como interfaces para os _visitors_. No projeto, já há classes utilizadas para representação da tabela de símbolos (completamente implementadas já);
  - A classe `SymbolTable` tem a informação de tipo de todas as classes declaradas no programa. 
  - Cada nome de classe é mapeado num objeto `Class`, que tem toda a informação de tipo dos atributos e declarações de método. O mapa de nomes de classe para objetos `Class` está contido na classe `SymbolTable`; 
  - Cada método é mapeado num objeto `Method`, que tem toda a informação de tipo dos parâmetros, tipo de retorno e variáveis locais. O mapa de nomes de métodos para objetos `Method` está contido na _hashtable_ `methods` que está contida na entrada da classe onde o método foi declarado;
  - Similarmente, cada variável é mapeada a uma instância da classe `Variable`, armazenando a informação de tipo da variável. Este mapeamento é armazenado nas _hashtables_ locais de um objeto `Method`, ou dentro da _hashtable_ `globals` de um objeto `Class`, dependendo de onde a variável foi declarada (como variável local de um método ou como atributo de classe).
- As classes [`BuildSymbolTableVisitor`](https://github.com/if688/if688.github.io/tree/master/atividades/05-TypeCheckerMiniJava/BuildSymbolTableVisitor.java) e [`TypeCheckVisitor`](https://github.com/if688/if688.github.io/tree/master/atividades/05-TypeCheckerMiniJava/TypeCheckVisitor.java) estão *incompletas* e tem apenas o esqueleto do código que visita a AST de um programa MiniJava. *Para este exercício, você preencherá o código destes arquivos.*
- A checagem de tipos de um programa se dá em duas fases. Na primeira, você precisa construir a tabela de símbolos (`SymbolTable`) com a informação de tipo declarada. A implementação desta fase estará contida na classe `BuildSymbolTableVisitor`.
  - Estude as classes `SymbolTable` e `BuildSymbolTableVisitor`, disponíveis no [repositório da disciplina](https://github.com/if688/if688.github.io/tree/master/2018.1/atividades/05-TypeCheckerMiniJava);
  - Em `BuildSymbolTableVisitor` você deve adicionar código que processa nós da AST que declaram classes, métodos, variáveis, etc.
  - Ao visitar nós derivados de `ClassDecl`, você deve primeiro criar uma entrada na tabela de símbolos para o nó `ClassDecl` sendo visitado, usando o método `addClass(...)` da classe `SymbolTable`. Então, a variável `currClass` de `BuildSymbolTableVisitor` deve ser assinalada para a nova entrada (o objeto `Class`) do nó `ClassDecl` sendo visitado. Desta forma, fazer referência à variável `currClass` dentro dos métodos `visit` para os nós de `VarDecl` e `MethodDecl` permitirá a adição de variáveis e métodos de uma declaração de classe (`ClassDecl`) no objeto correto da tabela de símbolos;
  - De maneira similar, ao visitar nós `MethodDecl`, a variável `currMethod` de `BuildSymbolTableVisitor` deve ser assinalada para o objeto `Method` correspondente ao nó `MethodDecl` atual. Assim, dentro de outros métodos `visit` é possível adicionar variáveis locais e parâmetros formais de um `MethodDecl` no objeto `Method` correto.
- Uma vez que todas as declarações foram processadas e armazenadas no objeto `SymbolTable`, podemos fazer a checagem de tipo de instruções e expressões. A implementação desta fase estará contida na classe `TypeCheckVisitor`
  - Toda instrução e expressão tem suas próprias regras de tipo. A seguir há uma lista *incompleta* de tais regras. Outras podem ser derivadas a partir da especificação da linguagem Java (qualquer programa MiniJava válido é um programa Java válido)
    - Operandos de operações aritméticas devem ter o mesmo tipo, que deve consistir do tipo `Integer`;
    - Operandos de operações lógicas devem ter o mesmo tipo, que deve consistir do tipo `Boolean`;
    - Expressões condicionais de `if` e `while` devem ser do tipo `Boolean`;
    - O lado direito de uma instrução de atribuição deve ser do mesmo tipo que o lado esquerdo; 
- Na classe Main, você pode colocar algo como: 
```java 
//programa na forma de AST - obter objeto a partir do parser...
Program prog = ...;
BuildSymbolTableVisitor stVis = new BuildSymbolTableVisitor();
//construindo tabela de símbolos
prog.accept(stVis); 
//fazendo a checagem de tipos
prog.accept(new TypeCheckVisitor(stVis.getSymbolTable())); 
```