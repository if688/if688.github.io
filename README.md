# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutores

* **Professor** 
  * Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)
* **Monitores** 
  * Claudio Carvalho de Oliveira ([@evfgs](https://github.com/claudiocarvalhoo) --- cco2@cin)
  * Guilherme Gouveia Figueiredo Lima ([@Gui-Lima](https://github.com/Gui-Lima) --- ggfl@cin)
  * Lucas Barros de Almeida Machado ([@lucasbarross](https://github.com/lucasbarross) --- lbam@cin)
  * Lucas Cardoso Coelho Alves de Oliveira ([@Lucas-CardosoO](https://github.com/Lucas-CardosoO) --- lccao@cin)
  * Mário Victor Gomes de Matos Bezerra ([@mvgmb](https://github.com/mvgmb) --- mvgmb@cin)
  * Matheus Borba Alves ([@mlbas](https://github.com/mlbas) --- mlbas@cin)
  
### Horário e Local de Aulas

* Quarta (13h-15h), E112
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

- [Slack](https://if688.slack.com)
- [iudex.io](https://iudex.io/group/join/JsaMg1R)

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
| 01 | 07.08.19 (qua) | [Introdução, admin](2019-08-07.md) | --- |
| 02 | 09.08.19 (sex) | [Conceitos Básicos & Tradução Dirigida por Sintaxe](2019-08-09.md) | --- |
| 03 | 14.08.19 (qua) | [Análise Léxica](2019-08-14.md) | --- |
| 04 | 16.08.19 (sex) | [Geradores de Analisadores Léxicos - JFlex](2019-08-16.md) | [*Atividade 1 lançada*](atividades/01-AutoJflexTest/) |
| 05 | 21.08.19 (qua) | [Análise Sintática - Top-Down parsing - LL(1)](2019-08-21.md) | --- |
| 06 | 23.08.19 (sex) | [Análise Sintática - LL(1)](2019-08-23.md) | [*Atividade 2 lançada*](atividades/02-FirstFollow/) |
| 07 | 28.08.19 (qua) | [Análise Sintática - Bottom-up parsing - LR(0)](2019-08-28.md) | *Deadline para entrega da Atividade 1* |
| 08 | 30.08.19 (sex) | [Análise Sintática - Bottom-up parsing - LR(1)](2019-08-30.md) | --- |
| 09 | 04.09.19 (qua) | [Análise Semântica - ASTs & Visitors](2019-09-04.md) | --- |
| 10 | 06.09.19 (sex) | [Atividade 3 lançada - Aula dedicada a praticar](atividades/03-SimpleInterpreter/) | --- |
| 11 | 11.09.19 (qua) | _Aula dedicada a tirar dúvidas de ASTs e Visitors_ | --- |
| 12 | 13.09.19 (sex) | [Automatizando Análise Sintática (ANTLR)](https://docs.google.com/presentation/d/1AXv04ejDwzWBGQ2upKg2IYaVhtskbJr9mZmMFCvtODE/edit?usp=sharing) | *Deadline para entrega da Atividade 2* |
| 13 | 18.09.19 (qua) | [Análise Semântica - Escopo & Type Checking](2019-09-18.md) | --- |
| 14 | 20.09.19 (sex) | Tira-dúvidas | *Deadline para entrega da Atividade 3* |
| 15 | 25.09.19 (qua) | Tira-dúvidas (_online_) | --- |
| 16 | 27.09.19 (sex) | **1 Exercício Escolar** | --- |
| 17 | 02.10.19 (qua) | Representações Intermediárias de Código | --- |
| 18 | 04.10.19 (sex) | Representações Intermediárias de Código | --- |
| 19 | 09.10.19 (qua) | Representações Intermediárias de Código | --- |
| 20 | 11.10.19 (sex) | Análise e Otimização de Código | --- |
| 21 | 16.10.19 (qua) | Análise e Otimização de Código | --- |
| 22 | 18.10.19 (sex) | Análise e Otimização de Código | --- |
| 23 | 23.10.19 (qua) | Análise e Otimização de Código | --- |
| 24 | 25.10.19 (sex) | Análise e Otimização de Código | --- |
| 25 | 30.10.19 (qua) | Ambientes de Execução | --- |
| 26 | 01.11.19 (sex) | Ambientes de Execução | --- |
| 27 | 06.11.19 (qua) | Ambientes de Execução | --- |
| 28 | 08.11.19 (sex) | Ambientes de Execução | --- |
| 29 | 13.11.19 (qua) | Geração de Código | --- |
| -- | 15.11.19 (sex) | **FERIADO - Proclamação da República** | --- |
| 30 | 20.11.19 (qua) | Geração de Código | --- |
| 31 | 22.11.19 (sex) | Geração de Código | --- |
| 32 | 27.11.19 (qua) | Geração de Código | --- |
| 33 | 29.11.19 (sex) | **2 Exercício Escolar** | --- |
| 34 | 04.12.19 (qua) | Tira-dúvidas (_online_) | --- |
| 35 | 06.12.19 (sex) | **2 Chamada** | --- |
| 36 | 11.12.19 (qua) | Tira-dúvidas (_online_) | --- |
| 37 | 13.12.19 (sex) | **Prova Final**  | --- |