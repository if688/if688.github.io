# IF688 - Teoria e Implementação de Linguagens Computacionais

## Atividade 2 - Geração de Parsers LL(1)

O objetivo deste exercício é consolidar os conceitos de First, Follow e tabelas de parsing LL(1). Portanto, a ideia é implementar um gerador de parsers LL(1), desenvolvendo implementações para o cálculo de First e Follow, além da geração de tabela de parsing. 

O código que deve ser implementado está nas classes `br.ufpe.cin.if688.table.Table` e `br.ufpe.cin.if688.parsing.analysis.SetGenerator`, indicado com comentários. *Nenhum outro código deve ser modificado.* Apenas os métodos `getFirst(Grammar g)`, `getFollow(Grammar g, Map<Nonterminal, Set<GeneralSymbol>> first)` e `createTable(Grammar g)` devem ser modificados. 

Para a entrega, faça um zip contendo apenas os dois arquivos modificados (`Table` e `SetGenerator`) e inclua como resposta no Google Classroom, lembrando de nomear o arquivo zip com seu login. Ou seja, no meu caso, seria lmt.zip. 

Se desejar, pode enviar também um link de repositório github e um outro arquivo zip com o projeto inteiro, mas é importante que tenha um zip com seu login, contendo apenas estes dois arquivos modificados com a sua implementação.

Para você ter mais evidências de que seu código está correto, rode os testes disponíveis no projeto.