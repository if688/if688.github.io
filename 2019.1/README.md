# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutores

* **Professor** 
  * Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)
* **Monitores** 
  * Claudio Carvalho de Oliveira ([@evfgs](https://github.com/claudiocarvalhoo) --- cco2@cin)
  * Guilherme Gouveia Figueiredo Lima ([@Gui-Lima](https://github.com/Gui-Lima) --- ggfl@cin)
  * Mário Victor Gomes de Matos Bezerra ([@mvgmb](https://github.com/mvgmb) --- mvgmb@cin)
  * Matheus Borba Alves ([@mlbas](https://github.com/mlbas) --- mlbas@cin)
  
### Horário e Local de Aulas

* Terça (08h-10h), grad 4
* Sexta (10h-12h), grad 4

### Ementa

Este curso explora os princípios, algoritmos, e estruturas de dados envolvidos na teoria e implementação de compiladores. 
O conteúdo planejado inclui uma introdução aos princípios e técnicas de construção de compiladores, conceitos básicos da teoria de linguagens, análise léxica, análise sintática, análise semântica, representação de código intermediário, ambientes de execução, análise estática, otimização de código, geração de código.

### Bibliografia Sugerida

- [Keith Cooper & Linda Torczon. Engineering a Compiler. 2nd Edition, Morgan Kaufmann, 2012](https://www.elsevier.com/books/engineering-a-compiler/cooper/978-0-12-088478-0)
- [Alfred Aho, Monica Lam, Ravi Sethi, and Jeffrey Ullman. Compilers: Principles, Techniques, and Tools. 2nd Edition, Addison-Wesley, 2006](http://dragonbook.stanford.edu)
- [Andrew Appel & Jens Palsberg. Modern Compiler Implementation in Java. 2nd edition, Cambridge University Press, 2003](https://www.cs.princeton.edu/~appel/modern/java/)

### Bibliografia Complementar
- [Michael Scott. Programming Language Pragmatics. 3rd edition, Morgan Kaufmann, 2009](https://www.cs.rochester.edu/u/scott/pragmatics/3e/)
- [Dick Grune & Ceriel J.H. Jacobs. Parsing Techniques. 2nd edition, Springer, 2008](https://dickgrune.com/Books/PTAPG_2nd_Edition/)
- [Terence Parr. Language Implementation Patterns. 1st edition, Pragmatic Bookshelf, 2010](https://pragprog.com/book/tpdsl/language-implementation-patterns)
- [Terence Parr. The Definitive ANTLR 4 Reference. 2nd edition, Pragmatic Bookshelf, 2013](https://pragprog.com/book/tpantlr2/the-definitive-antlr-4-reference)
- [Ronald Mak. Writing Compilers and Interpreters: A Modern Software Engineering Approach Using Java. 1st edition, John Wiley & Sons, 2009](http://www.wiley.com/WileyCDA/WileyTitle/productCd-0470177071.html)

### Objetivos

O objetivo da disciplina é fornecer fundamentos para desenvolvimento da compreensão da teoria e prática de compiladores, e de questões envolvidas na implementação de linguagens.

### Metodologia

Na disciplina, utilizaremos uma mistura de aulas tradicionais com exercícios e tarefas de programação em sala de aula e para casa. 

### Recursos

- [Slack](https://if688.slack.com)
- [iudex.io](https://iudex.io/group/join/5y5cD6V)

### Avaliação

* (`N1`+`N2`)/2, onde:
  * `N1` = `Prova1` (60%) + `Exercicios1` (40%)
    * `Prova1` = Teste com [assunto dado até o momento
    * `Exercicios1` = Tarefas passadas durante primeira unidade
  * `N2` = `Prova2` (60%) + `Exercicios2` (40%)
    * `Prova2` = Teste com [assunto dado a partir de Prova1 
    * `Exercicios2` = Tarefas passadas durante segunda unidade
* `Final`: Teste com todo o assunto da matéria

- Observações:
  - Entrega fora do prazo: **redutor de 1 ponto por dia de atraso**. 
  - Atraso máximo: **1 (uma) semana**. Após esse prazo, será dada nota **zero** para a respectiva atividade de avaliação.
  - Trabalhos **“CTRL-C + CTRL-V”** terão nota **zero** (vale tanto para cópia de colegas, como para trabalhos copiados da internet).

### Plano de Ensino

**Atenção!** 
*Este plano de ensino está sujeito a alterações durante o semestre, visite frequentemente a página para obter a versão mais atualizada, ou acompanhe os updates no repositório.*

| # | Data | Assunto | Atividades |
|:---:|:----:|:----------------------:|:----------------------|
| 01 | 19.02.19 (ter) | [Introdução, admin](2019-02-19.md) | --- |
| 02 | 22.02.19 (sex) | [Conceitos Básicos](2019-02-22.md) | --- |
| 03 | 26.02.19 (ter) | [Tradução Dirigida por Sintaxe](2019-02-26.md) | --- |
| 04 | 01.03.19 (sex) | [Análise Léxica (JFlex)](2019-03-01.md) | -- |
| -- | 05.03.19 (ter) | **FERIADO - Carnaval** | --- |
| 05 | 08.03.19 (sex) | [Ferramentas para Análise Léxica (JFlex)](2019-03-08.md) | [*Atividade 1 lançada*](atividades/01-AutoJflexTest) |
| 06 | 12.03.19 (ter) | [Introdução à Análise Sintática e Top-Down Parsing](2019-03-12.md) | --- |
| 07 | 15.03.19 (sex) | [LL(1) Parsing](2019-03-15.md) | [*Atividade 2 lançada*](atividades/02-FirstFollow) |
| 08 | 19.03.19 (ter) | [Bottom-up Parsing LR(0)](2019-03-19.md) | *Deadline para entrega - Atividade 1* |
| 09 | 22.03.19 (sex) | [Bottom-up Parsing LR(1) e LALR](2019-03-22.md) | --- |
| 10 | 26.03.19 (ter) | [Bottom-up Parsing LALR & Introdução à Análise Semântica](2019-03-26.md) | --- |
| 11 | 29.03.19 (sex) | [Análise Semântica - ASTs](2019-03-29.md) | --- |
| -- | 31.03.19 (dom) | **---** | *Deadline para entrega - Atividade 2* |
| 12 | 02.04.19 (ter) | [Análise Semântica - Visitors](2019-04-02.md) |  [*Atividade 3 lançada*](https://github.com/if688/if688.github.io/tree/master/atividades/03-SimpleInterpreter) |
| 13 | 05.04.19 (sex) | [Análise Semântica - Escopo & Type Checking](2019-04-05.md) | --- |
| 14 | 09.04.19 (ter) | *Revisão* | --- |
| 15 | 12.04.19 (sex) | **1 Exercício Escolar** | --- |
| -- | 15.04.19 (seg) | **---** | *Deadline para entrega - Atividade 3* |
| -- | 16.04.19 (ter) | *Aula cancelada* |  |
| -- | 19.04.19 (sex) | **FERIADO - Paixão de Cristo** | --- |
| 16 | 23.04.19 (ter) | [Representações Intermediárias de Código - Código de 3 Endereços](2019-04-23.md) | --- |
| 17 | 26.04.19 (sex) | [_Control-flow graphs_ e Introdução à Análise e Otimização de Código](2019-04-26.md) | --- |
| 18 | 30.04.19 (ter) | [Otimizações Locais e Globais](2019-04-30.md) | --- |
| 29 | 03.05.19 (sex) | [Automatizando Análise Sintática com ANTLR](2019-04-09.md) | *Atividades 4 e 5 lançadas* |
| 20 | 07.05.19 (ter) | **Exercício - Atividades 4 e 5** | --- |
| 21 | 10.05.19 (sex) | [Representações Intermediárias de Código - LLVM](2019-05-10.md) | --- |
| 22 | 14.05.19 (ter) | [Otimizações Globais](2019-05-14.md) |  |
| 23 | 17.05.19 (sex) | [Conclusão de Análise e Otimização de Código](2019-05-17.md) | *Deadline para entrega - Atividade 4* | |
| 24 | 21.05.19 (ter) | [Ambientes de Execução - Pilha](2019-05-21.md) | --- |
| 25 | 24.05.19 (sex) | [Ambientes de Execução - Heap](2019-05-24.md) | --- |
| 26 | 28.05.19 (ter) | [Geração de Código - Seleção de Instruções](2019-05-28.md) | --- |
| 27 | 31.05.19 (sex) | [Geração de Código - Alocação de Registradores](2019-05-31.md) | *Deadline para entrega - Atividade 5* |
| 28 | 04.06.19 (ter) | [Geração de Código - Alocação de Registradores](2019-06-04.md) | --- |
| 29 | 07.06.19 (sex) | *Revisão* | --- |
| 30 | 11.06.19 (ter) | **2 Exercício Escolar** | --- |
| 31 | 14.06.19 (sex) | Tirar dúvidas | --- |
| 32 | 18.06.19 (ter) | **Segunda Chamada**  | --- |
| 33 | 21.06.19 (sex) | Tirar dúvidas (_online_) | --- |
| 34 | 25.06.19 (ter) | Tirar dúvidas (_online_) | --- |
| 34 | 28.06.19 (ter) | **Prova Final**  | --- |