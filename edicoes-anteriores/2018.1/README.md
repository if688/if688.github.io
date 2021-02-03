# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutores

* **Professor** 
  * Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)
* **Monitores** 
  * Emanuel Victor ([@evfgs](https://github.com/evfgs) --- evfgs@cin)
  * Gabriel Henrique Daniel da Silva ([@gabrielh10](https://github.com/gabrielh10) --- ghds@cin)
  * Jailson da Costa Dias ([@jailson-dias](https://github.com/jailson-dias) --- jcd2@cin)
  * Jose Murilo Sodre da Mota Filho ([@jmsmf](https://github.com/jmsmf) --- jmsmf@cin)
  * Ramon Saboya Gomes ([@RamonSaboya](https://github.com/RamonSaboya) --- rsg3@cin)
  
### Horário e Local de Aulas

* Terça (8h-10h), grad 4
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
- [Terence Parr. The Definitive ANTLR 4 Reference. 2nd edition, Pragmatic Bookshelf, 2013](https://pragprog.com/book/tpantlr2/the-definitive-antlr-4-reference)
- [Ronald Mak. Writing Compilers and Interpreters: A Modern Software Engineering Approach Using Java. 1st edition, John Wiley & Sons, 2009](http://www.wiley.com/WileyCDA/WileyTitle/productCd-0470177071.html)

### Objetivos

O objetivo da disciplina é fornecer fundamentos para desenvolvimento da compreensão da teoria e prática de compiladores, e de questões envolvidas na implementação de linguagens.

### Metodologia

Na disciplina, combinaremos utilizada uma mistura de aulas tradicionais com exercícios e tarefas de programação em sala de aula e para casa. 

### Recursos

- [Slack](http://if688.slack.com)
- [Google Classroom](http://classroom.google.com) - Código: mpg9k1

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
| 01 | 27.02.18 (ter) | [Introdução, admin](2018-02-27.md) | --- |
| 02 | 02.03.18 (sex) | [Conceitos Básicos e Tradução Dirigida por Sintaxe](2018-03-02.md) | --- |
| -- | 06.03.18 (ter) | **FERIADO - Revolução Pernambucana** | --- |
| 03 | 09.03.18 (sex) | [Intro Análise Léxica](2018-03-09.md) | --- |
| 04 | 13.03.18 (ter) | [Ferramentas para Análise Léxica (JFlex)](2018-03-13.md) | --- |
| 05 | 16.03.18 (sex) | [Intro Análise Sintática e Top-Down Parsing](2018-03-16.md) | [*Atividade 1 lançada*](atividades/01-AutoJflexTest/) |
| 06 | 20.03.18 (ter) | [Top-Down parsing - LL(1) parsing](2018-03-20.md) | --- |
| 07 | 23.03.18 (sex) | [Bottom-up parsing - LR(0)](2018-03-23.md) | *Deadline - Atividade 1* |
| 08 | 27.03.18 (ter) | [Bottom-up parsing - LR(1)](2018-03-27.md) | [*Atividade 2 lançada*](atividades/02-LL1parsing/) |
| -- | 30.03.18 (sex) | **FERIADO - Sexta-feira Santa** | --- |
| 09 | 03.04.18 (ter) | [LALR Parsing e Intro Análise Semântica](2018-04-03.md) | --- |
| 10 | 06.04.18 (sex) | [ASTs e Padrão de Projeto Visitor](2018-04-06.md) | --- |
| 11 | 10.04.18 (ter) | [Automatizando Análise Sintática com ANTLR](2018-04-10.md) | *Deadline - Atividade 2* |
| 12 | 13.04.18 (sex) | [Análise Semântica - Escopo](2018-04-13.md) |  [*Atividade 3 lançada*](atividades/03-SimpleInterpreter/) | |
| 13 | 17.04.18 (ter) | [Análise Semântica - Type Checking](2018-04-17.md) | --- |
| 14 | 20.04.18 (sex) | Exercícios e tirar dúvidas | --- |
| 15 | 24.04.18 (ter) | **1 Exercício Escolar** | --- |
| 16 | 27.04.18 (sex) | Discussão da Prova e Exercício _Visitors_ | *Deadline - Atividade 3* |
| -- | 01.05.18 (ter) | **FERIADO - Dia do Trabalho** |  |
| 17 | 04.05.18 (sex) | [Representações Intermediárias de Código - Código de 3 endereços](2018-05-04.md) | --- |
| 18 | 08.05.18 (ter) | [Representações Intermediárias de Código - _Control-flow Graphs_](2018-05-08.md) |  |
| 19 | 11.05.18 (sex) | [_Static Single Assignment_ e Introdução à Análise de Código](2018-05-11.md) | [*Atividade 4 lançada*](atividades/04-MiniJavaAST/) |
| 20 | 15.05.18 (ter) | *Atividade 4* | --- |
| 21 | 18.05.18 (sex) | [Otimizações Globais e Análise de Fluxo de Dados _forward-flow_](2018-05-18.md) | --- |
| 22 | 22.05.18 (ter) | [_Liveness_ e Análises de Fluxo de Dados _backward-flow_](2018-05-22.md) | --- |
| -- | 25.05.18 (sex) | *Atividades Acadêmicas Suspensas* | *Deadline - Atividade 4* |
| -- | 29.05.18 (ter) | *Atividades Acadêmicas Suspensas* | --- |
| 23 | 01.06.18 (sex) | [_Dominance_](2018-06-01.md) | --- |
| 24 | 05.06.18 (ter) | [Ambientes de Execução - Pilha](2018-06-05.md) | [*Atividade 5 lançada*](atividades/05-TypeCheckerMiniJava/) |
| 25 | 08.06.18 (sex) | [Ambientes de Execução - Heap](2018-06-08.md) | --- |
| 26 | 12.06.18 (ter) | [Geração de Código - Seleção de Instruções](2018-06-12.md) | --- |
| 27 | 15.06.18 (sex) | [Geração de Código - Alocação de Registradores em Blocos Básicos](2018-06-15.md) | --- |
| 28 | 19.06.18 (ter) | [Geração de Código - Alocação de Registradores usando _Liveness_](2018-06-19.md) | --- |
| 29 | 22.06.18 (sex) | *Jogo do Brasil* | *Deadline - Atividade 5* |
| 30 | 26.06.18 (ter) | Exercícios e tirar dúvidas | --- |
| 31 | 29.06.18 (sex) | **2 Exercício Escolar** | --- |
| 32 | 03.07.18 (ter) | Tirar Dúvidas | --- |
| 33 | 06.07.18 (sex) | **Segunda Chamada**  | --- |
| 34 | 10.07.18 (ter) | Tirar Dúvidas | --- |
| 35 | 13.07.18 (sex) | **Prova Final**  | --- |
