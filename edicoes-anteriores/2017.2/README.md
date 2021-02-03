# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutores

* **Professor** 
  * Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)
* **Monitores** 
  * Caio Rocha Pereira ([@crp3](https://github.com/crp3) --- crp3@cin)
  * Emanuel Victor ([@evfgs](https://github.com/evfgs) --- evfgs@cin)
  * Gabriel Henrique Daniel da Silva ([@gabrielh10](https://github.com/gabrielh10) --- ghds@cin)
  * Jailson da Costa Dias ([@jailson-dias](https://github.com/jailson-dias) --- jcd2@cin)
  * Jose Murilo Sodre da Mota Filho ([@jmsmf](https://github.com/jmsmf) --- jmsmf@cin)
  * Pedro Lins de Araujo Lima ([@plal](https://github.com/plal) --- plal@cin)
  
### Horário e Local de Aulas

* Quarta (13h-15h), E112 
* Sexta (15h-17h), grad 3.

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
- [Terence Parr. The Definitive ANTLR 4 Reference. 2nd edition, Pragmatic Bookshelf, 2013](https://pragprog.com/book/tpantlr2/the-definitive-antlr-4-reference)
- [Ronald Mak. Writing Compilers and Interpreters: A Modern Software Engineering Approach Using Java. 1st edition, John Wiley & Sons, 2009](http://www.wiley.com/WileyCDA/WileyTitle/productCd-0470177071.html)

### Objetivos

O objetivo da disciplina é fornecer fundamentos para desenvolvimento da compreensão da teoria e prática de compiladores, e de questões envolvidas na implementação de linguagens.

### Metodologia

Na disciplina, combinaremos utilizada uma mistura de aulas tradicionais com exercícios e tarefas de programação em sala de aula e para casa. 

### Recursos

- [Slack](http://if688.slack.com)
- [Google Classroom](http://classroom.google.com) - Código: sdbhetu

#### Ferramentas

* [JFlex](http://jflex.de)
* [ANTLR](http://www.antlr.org)

### Avaliação

* (`N1`+`N2`)/2, onde:
  * `N1` = `Prova1` (70%) + `Exercicios1` (30%)
    * `Prova1` = Teste com [assunto dado até o momento
    * `Exercicios1` = Tarefas passadas durante primeira unidade
  * `N2` = `Prova2` (70%) + `Exercicios2` (30%)
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

| # | Data | Assunto | Recursos |
|:---:|:----:|:----------------------|:--------:|
| 01 | 09.08.17 (qua) | [Introdução, admin](https://drive.google.com/open?id=0BwgdwrP1_WSjRkpST0FrZ3dwTFU)  | --- |
| 02 | 11.08.17 (sex) | [Conceitos Básicos](https://drive.google.com/open?id=0BwgdwrP1_WSjdGNyQnQxNE4wNm8)  | --- |
| 03 | 16.08.17 (qua) | [Tradução Dirigida por Sintaxe](https://drive.google.com/open?id=0BwgdwrP1_WSjUHJjV0taMVlDYmM)  | --- |
| 04 | 18.08.17 (sex) | [Análise Léxica](https://drive.google.com/open?id=0BwgdwrP1_WSjbXFBUkcxTnR0TXM)  | --- |
| 05 | 23.08.17 (qua) | [JFlex & Introdução a Análise Sintática](https://drive.google.com/open?id=0BwgdwrP1_WSjRjlJcmswcWd4Y0U)  | --- |
| 06 | 25.08.17 (sex) | Exercício Análise Léxica  | --- |
| 07 | 30.08.17 (qua) | [LL(1) parsing](https://drive.google.com/open?id=0BwgdwrP1_WSjVTZVS1lnckdFcUU)  | --- |
| 08 | 01.09.17 (sex) | [Bottom-up parsing - LR(0)](https://drive.google.com/open?id=0BwgdwrP1_WSjQ0NYM0dDSzRpTjA)  | --- |
| 09 | 06.09.17 (qua) | [LR(1) parsing](https://drive.google.com/open?id=0BwgdwrP1_WSjcENuMEJUZ2FSNTg)  | --- |
| 10 | 08.09.17 (sex) | Exercício LL(1) parsing  | --- |
| 11 | 13.09.17 (qua) | [Análise Semântica - ASTs e Escopo](https://drive.google.com/open?id=0BwgdwrP1_WSjUlFuVDAxNDZIcEE)  | --- |
| 12 | 15.09.17 (sex) | [Análise Semântica - Type Checking](https://drive.google.com/open?id=0BwgdwrP1_WSjZTNYWG1TbldwcTg)  | --- |
| 13 | 20.09.17 (qua) | [Automatizando Análise Sintática com ANTLR](https://docs.google.com/a/cin.ufpe.br/presentation/d/1HayLkMRa-0MPNfwOtbdvhzFy8dSUDOtbMcuXxJGhmdQ/edit?usp=sharing)  | --- |
| 14 | 22.09.17 (sex) | Exercício - Implementando Parsers com ANTLR  | --- |
| 15 | 27.09.17 (qua) | Implementando Análise Semântica com Visitors  | --- |
| 16 | 29.09.17 (sex) | Exercício - Type Checking + Revisão  | --- |
| 17 | 04.10.17 (qua) | Revisão  | --- |
| 18 | 06.10.17 (sex) | **1 Exercício Escolar**  | --- |
| 19 | 11.10.17 (qua) | [Representações Intermediárias de Código - código de 3 endereços](https://drive.google.com/open?id=0BwgdwrP1_WSjbnZvR2s1RElobDA)  | --- |
| 20 | 13.10.17 (sex) | Exercício Type Checking  | --- |
| 21 | 18.10.17 (qua) | [Representações Intermediárias de Código - Control-Flow Graphs](https://drive.google.com/open?id=0BwgdwrP1_WSjRWJXeFIwaGxhdTg)  | --- |
| 22 | 20.10.17 (sex) | [Introdução a Análise e Otimização de Código - Otimizações Locais](https://drive.google.com/open?id=0BwgdwrP1_WSjaHRCdWM4YmxSRUk)  | --- |
| 23 | 25.10.17 (qua) | [Introdução a Otimizações Globais - _Constant Propagation_](https://drive.google.com/open?id=0BwgdwrP1_WSjLUk2RXZYT0JLcDA)  | --- |
| 24 | 27.10.17 (sex) | [Análise de Fluxo de Dados _backwards_ - _Liveness_](https://drive.google.com/open?id=0BwgdwrP1_WSjUjZPSnlWV3JRbzQ)  | --- |
| 25 | 01.11.17 (qua) | [Análise e Otimização de Código - _Dominance_](https://drive.google.com/open?id=0BwgdwrP1_WSjSDhrT3U0YVpxa1U)  | --- |
| 26 | 03.11.17 (sex) | Exercício Análise e Otimização  | --- |
| 27 | 08.11.17 (qua) | [Ambientes de Execução - Pilha](https://drive.google.com/open?id=17pxprzOtb4qqS152v0-2lUk9gJSFWT52)  | --- |
| 28 | 10.11.17 (sex) | [Ambientes de Execução - Heap](https://drive.google.com/open?id=18NzPMIETELsB8uUpzvkuzTEUYDor3sPu)  | --- |
| -- | 15.11.17 (qua) | **FERIADO**  | --- |
| 29 | 17.11.17 (sex) | [Geração de Código - Seleção de Instruções](https://drive.google.com/open?id=1YEHDoydqjXNu-KkgT4ORNtCjTeYpnLWG)  | --- |
| 30 | 22.11.17 (qua) | [Geração de Código - Alocação de Registradores](https://drive.google.com/open?id=1UMSL4a_cFscx1ULjxD8OZFSjfdVG5rSH)  | --- |
| 31 | 24.11.17 (sex) | Tirar Dúvidas  | --- |
| 32 | 29.11.17 (qua) | Tirar Dúvidas  | --- |
| 33 | 01.12.17 (sex) | **2 Exercício Escolar**  | --- |
| 34 | 06.12.17 (qua) | **Segunda Chamada**  | --- |
| -- | 08.12.17 (sex) | **FERIADO**  | --- |
| 35 | 13.12.17 (qua) | **Prova Final**  | --- |
