# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutores

* **Professor** 
  * Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)
* **Monitores** 
  * Claudio Carvalho de Oliveira ([@evfgs](https://github.com/claudiocarvalhoo) --- cco2@cin)
  * Emanuel Victor ([@evfgs](https://github.com/evfgs) --- evfgs@cin)
  * Guilherme Gouveia Figueiredo Lima ([@Gui-Lima](https://github.com/Gui-Lima) --- ggfl@cin)
  * Jailson da Costa Dias ([@jailson-dias](https://github.com/jailson-dias) --- jcd2@cin)
  * Jose Murilo Sodre da Mota Filho ([@jmsmf](https://github.com/jmsmf) --- jmsmf@cin)
  
### Horário e Local de Aulas

* Quarta (13h-15h), E-112
* Sexta (15h-17h), grad 3

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

- [Slack](http://if688.slack.com)
- [Google Classroom](http://classroom.google.com) - Código: f3phap

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
| 01 | 15.08.18 (qua) | [Introdução, admin](2018-08-15.md) | --- |
| 02 | 17.08.18 (sex) | [Conceitos Básicos e Tradução Dirigida por Sintaxe](2018-08-17.md) | --- |
| 03 | 22.08.18 (qua) | [Análise Léxica](2018-08-22.md) | --- |
| 04 | 24.08.18 (sex) | [Ferramentas para Análise Léxica (JFlex)](2018-08-24.md) | [*Atividade 1 lançada*](atividades/01-AutoJflexTest) |
| 05 | 29.08.18 (qua) | [Introdução à Análise Sintática e Top-Down Parsing](2018-08-29.md) | --- |
| 06 | 31.08.18 (sex) | [Análise Sintática](2018-08-31.md) | *Deadline para entrega - Atividade 1* |
| 07 | 05.09.18 (qua) | [*Atividade 2*](#) | --- |
| -- | 07.09.18 (sex) | **FERIADO - Dia da Independência** | --- |
| 08 | 12.09.18 (qua) | [Análise Sintática](#) | --- |
| 09 | 14.09.18 (sex) | [Análise Sintática](#) | *Deadline para entrega - Atividade 2* |
| 10 | 19.09.18 (qua) | [Ferramentas para geração de Analisadores Sintáticos](#) | --- |
| 11 | 21.09.18 (sex) | [Análise Semântica](#) | --- |
| 12 | 26.09.18 (qua) | [Análise Semântica](#) | --- |
| 13 | 28.09.18 (sex) | [Análise Semântica](#) | --- |
| 14 | 03.10.18 (qua) | [Análise Semântica](#) | --- |
| 15 | 05.10.18 (sex) | [Análise Semântica](#) | --- |
| 16 | 10.10.18 (qua) | **1 Exercício Escolar** | --- |
| -- | 12.10.18 (sex) | **FERIADO - Dia de Nossa Senhora Aparecida** | --- |
| 17 | 17.10.18 (qua) | [Representações Intermediárias de Código](#) | --- |
| 18 | 19.10.18 (sex) | [Representações Intermediárias de Código](#) | --- |
| 19 | 24.10.18 (qua) | [Análise e Otimização de Código](#) | --- |
| 20 | 26.10.18 (sex) | [Análise e Otimização de Código](#) | --- |
| 21 | 31.10.18 (qua) | [Análise e Otimização de Código](#) | --- |
| -- | 02.11.18 (sex) | **FERIADO - Dia de Finados** | --- |
| 22 | 07.11.18 (qua) | [Análise e Otimização de Código](#) | --- |
| 23 | 09.11.18 (sex) | [Análise e Otimização de Código](#) | --- |
| 24 | 14.11.18 (qua) | [Ambientes de Execução](#) | --- |
| 25 | 16.11.18 (sex) | [Ambientes de Execução](#) | --- |
| 26 | 21.11.18 (qua) | [Ambientes de Execução](#) | --- |
| 27 | 23.11.18 (sex) | [Geração de Código](#) | --- |
| 28 | 28.11.18 (qua) | [Geração de Código](#) | --- |
| 29 | 30.11.18 (sex) | [Geração de Código](#) | --- |
| 30 | 05.12.18 (qua) | **2 Exercício Escolar** | --- |
| 31 | 07.12.18 (sex) | Tirar dúvidas | --- |
| 32 | 12.12.18 (qua) | **Segunda Chamada**  | --- |
| 33 | 14.12.18 (sex) | Tirar dúvidas | --- |
| 34 | 19.12.18 (qua) | **Prova Final**  | --- |