# IF688 - Teoria e Implementação de Linguagens Computacionais

## Atividade 2 - Geração de Parsers LL(1)

O objetivo deste exercício é consolidar os conceitos de First, Follow e tabelas de parsing LL(1). Portanto, a ideia é implementar um gerador de parsers LL(1), desenvolvendo implementações para o cálculo de First e Follow, além da geração de tabela de parsing. 

O código que deve ser implementado está nas classes `br.ufpe.cin.if688.table.Table` e `br.ufpe.cin.if688.parsing.analysis.SetGenerator`, indicado com comentários. *Nenhum outro código deve ser modificado.* Apenas os métodos `getFirst(Grammar g)`, `getFollow(Grammar g, Map<Nonterminal, Set<GeneralSymbol>> first)` e `createTable(Grammar g)` devem ser modificados. 

### Entrega no Classroom
Para a entrega, faça um zip contendo apenas os dois arquivos modificados (`Table` e `SetGenerator`) e inclua como resposta no Google Classroom, lembrando de nomear o arquivo zip com seu login. Ou seja, no meu caso, seria lmt.zip. 

Se desejar, pode enviar também um link de repositório github e um outro arquivo zip com o projeto inteiro, mas é importante que tenha um zip com seu login, contendo apenas estes dois arquivos modificados com a sua implementação.

### Entrega para o Iudex
No Iudex tem toda a especificação, mas de maneira semelhante, faça um Zip com o Main, o Table e o SetGenerator. Selecione Java 8 e submeta esse Zip. Seu arquivo deve conter alguns prints (quatro, não precisa mais que isso) que devem ser:
* Da Gramática
* Do First dela
* Do Follow dela
* Da Parsing Table LL(1) dela

### Testando seu código
Para testar, você pode rodar os testes pre-feitos nas classes "FirstSetTest", "FollowSetTest" e "TableTest", ou você pode rodar o Main e usar um Txt com uma gramática ou digitar no terminal de sua IDE uma gramática no formato que está mostrado como Input no Iudex.
A gramática que você está testando deve ser LL(1) caso vá rodar no Main. Faz parte da atividade que você descubra os erros no seu código sem ficar 100% dependendo do expected output.

### Erros Comuns
Pode ser que o Junit não seja importado automaticamente e você não consiga rodar as classes testes. Nesse caso, tente importar pela IDE o jar do Junit, ou coloque @Test em cima de alguma função que geralmente a IDE detecta.

### OBS
O Epsilon está sendo representado nesse projeto pelo símbolo "^". Uma regra " A -> ^" signica "A -> Epsilon".