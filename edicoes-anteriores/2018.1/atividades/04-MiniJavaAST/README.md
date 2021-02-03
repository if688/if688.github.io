# IF688 - Teoria e Implementação de Linguagens Computacionais

## Atividade 4 - ASTs em MiniJava

O objetivo deste exercício é criar um parser e adicionar ações semânticas para produzir sintaxe abstrata para a linguagem MiniJava.

1. Use o projeto disponível neste repositório. Este projeto inclui classes Java representando os nós da AST de MiniJava, bem como interface para criação de _visitors_; 
2. Observe que já há classes Java utilizadas para representação da tabela de símbolos. Para este exercício especificamente, não iremos utilizar nada relacionado à tabela de símbolos, mas já deixei as classes disponíveis neste projeto, apenas para já irem se familiarizando. A explicação das mesmas seguirá no próximo exercício;
3. Caso não esteja confortável ainda com o padrão _Visitor_, sugiro a leitura da Seção 4.3 do livro _Modern Compiler Implementation in Java_, de Andrew Appel, além dos links já indicados nas aulas correspondentes. É importante entender como os métodos `accept` e `visit` interagem;
4. Em aula nós discutimos como especificar ações semânticas às regras de produção. Estas ações permitem escrever um interpretador, por exemplo. No entanto, escrever um interpretador diretamente no _parser_ é difícil de implementar e manter, e não permite muitas das otimizações e melhorias esperadas por compiladores, como as discutidas em sala de aula. Desta forma, o papel do _parser_ geralmente envolve a construção de uma representação intermediária, como por exemplo, uma AST. Crie ações semânticas no seu _parser_ com ANTLR de forma que o parser gerado retorna um objeto contendo a AST do programa, ao completar de forma bem-sucedida a análise;
5. Lembre de importar explicitamente as classes da AST no seu _parser_, se elas se localizarem em um pacote distinto;
6. No pacote visitor há uma classe denominada `PrettyPrintVisitor`, que você pode utilizar para testar o seu _parser_ e programa. Na classe `Main`, ao invés de existir um programa hard-coded como é o caso atualmente, ao término do exercício, você deverá colocar a chamada ao _parser_ gerado por ANTLR, armazenando o resultado em um objeto do tipo `Program`, com o nome `prog`. Uma vez feito o _parsing_ do arquivo, em seguida chame o método `accept` passando o `PrettyPrintVisitor`, como ilustrado abaixo: 

```java 
//programa na forma de AST
Program prog; //obter objeto usando parser ANTLR definido
//chama o visitor de pretty print
prog.accept(new PrettyPrintVisitor());
```