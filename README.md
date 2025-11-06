# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação & Engenharia da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutor

* **Professor:** Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)

* **Monitores:** 
  - Ana Paula Sá Barreto Paiva da Cunha	[@anapsa](https://github.com/anapsa) --- apsbpc@cin
  - Andre de Freitas Saghaard	[@andrefgard](https://github.com/andrefgard) --- afs15@cin
  - Caio Nascimento Santos	[@caionsantos](https://github.com/caionsantos) --- cns@cin
  - Gabriel Stamford Arnaud	[@GabrielStamfordDev](https://github.com/GabrielStamfordDev) --- gsa6@cin
  - Guilherme Lins Rigaud	[@Gui-Rigaud](https://github.com/Gui-Rigaud) --- glr2@cin
  - Gustavo Santiago Silva Mariano [@Gust4voSSM](https://github.com/Gust4voSSM) --- gssm@cin
  - Hugo de Almeida Medeiros [@HugoZig](https://github.com/HugoZig) --- ham4@cin
  - Pedro Vítor de Oliveira Monte [@PedroMonte](https://github.com/PedroMonte) --- pvom@cin

### Horário e Local de Aulas

* Terça (13h-15h), Sala 1 - Área 2
* Quinta (15h-17h), Sala 1 - Área 2

### Ementa

Este curso explora os princípios, algoritmos, e estruturas de dados envolvidos na teoria e implementação de compiladores. 
O conteúdo planejado inclui uma introdução aos princípios e técnicas de construção de compiladores, conceitos básicos da teoria de linguagens, análise léxica, análise sintática, análise semântica, representação de código intermediário, ambientes de execução, análise estática, otimização de código, geração de código.

### Bibliografia Sugerida

- [Keith Cooper & Linda Torczon. Engineering a Compiler. 3rd Edition, Morgan Kaufmann, 2022](https://shop.elsevier.com/books/engineering-a-compiler/cooper/978-0-12-815412-0)
- [Robert Nystrom. Crafting interpreters. Genever Benning, 2021.](https://craftinginterpreters.com/)

### Bibliografia Complementar
- [Jeremy G. Siek. Essentials of Compilation: An Incremental Approach in Python. 1st Edition, MIT Press, 2023](https://mitpress.mit.edu/9780262048248/essentials-of-compilation/)
- [Dick Grune, Kees Van Reeuwijk, Henri E. Bal, Ceriel J. H. Jacobs, and Koen Langendoen. Modern Compiler Design. 2nd Edition, Springer, 2012](https://dickgrune.com/Books/MCD_2nd_Edition/)
- [Andrew Appel & Jens Palsberg. Modern Compiler Implementation in Java. 2nd edition, Cambridge University Press, 2003](https://www.cs.princeton.edu/~appel/modern/java/)
- [Alfred Aho, Monica Lam, Ravi Sethi, and Jeffrey Ullman. Compilers: Principles, Techniques, and Tools. 2nd Edition, Addison-Wesley, 2006](http://dragonbook.stanford.edu)
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

- [Discord](https://discord.gg/P4mndZ3r)
- Github Classroom - De acordo com instruções no Discord


### Avaliação

* `Nota` = (`Atividades` x 5 + `Prova` x 5) / 10 
  * `Atividades` = Atividades de programação
  * `Prova` = Exercício escolar
* `Final`

- Observações:
  - Entrega fora do prazo: **redutor de 1 ponto por dia de atraso**. 
  - Atraso máximo: **1 (uma) semana**. Após esse prazo, será dada nota **zero** para a respectiva atividade de avaliação.
  - Trabalhos **“CTRL-C + CTRL-V”** terão nota **zero** (vale tanto para cópia de colegas, como para trabalhos copiados da internet).

### Plano de Ensino

*Este plano de ensino está sujeito a alterações durante o semestre, visite frequentemente a página para obter a versão mais atualizada, ou acompanhe os updates no repositório.*

| Data     | Dia da Semana | Conteúdo Programático | Atividades Associadas |
|----------|---------------|-----------------------|-----------------------|
| 09.09.25 | terça         | [Introdução, admin](2025-09-09.md)                           | [Pesquisa inicial da disciplina](https://forms.gle/ydz8Ljx9nMrVFrz46) | 
| 11.09.25 | quinta        | [Análise Léxica](2025-09-11.md) |                       |
| 16.09.25 | terça         | [Análise Sintática Top-Down (intro, first, follow)](2025-09-16.md) |   |
| 18.09.25 | quinta        | [Análise Sintática Top-Down - LL(1) _parsing_](2025-09-18.md) |                       |
| 16.09.25 | terça         | [APS: Implementando Analisadores Léxicos](https://classroom.github.com/a/xG7wXD0l) |  Atividade 1 lançada |
| 25.09.25 | quinta        | [APS: _LL(1) Parsing_](https://classroom.github.com/a/YGAzT_Iv) | Atividade 2 lançada |
| 30.09.25 | terça         | [Análise Sintática - _Recursive-descent parsing_ e _Bottom-up parsing_](2025-09-30.md) |                       |
| 02.10.25 | quinta        | [Análise Sintática - LR(0) e LR(1) parsing](2025-10-02.md) | [Atividade 3 lançada](https://classroom.github.com/a/LdV-wAay) |
| 07.10.25 | terça         | [Análise Sintática - _LR(1) parsing_](2025-10-07.md) |                       |
| 09.10.25 | quinta        | [Análise Semântica - Introdução e Tipos](2025-10-09.md) |                       |
| 14.10.25 | terça         | [Análise Semântica - Tipos e Escopo](2025-10-14.md) |                       |
| 16.10.25 | quinta        | [Análise Semântica - ASTs e Visitors](2025-10-16.md) |                       |
| 21.10.25 | terça         | [APS: Atividade 4 LR(1) parsing](https://classroom.github.com/a/nIKx2OD_)        |                       |
| 23.10.25 | quinta        | [APS: Atividade 5 ANTLR](2025-10-23.md) |                       |
| 28.10.25 | terça         | [APS: Atividade 6 ASTs](2025-10-28.md) |   |
| 30.10.25 | quinta        | [Análise Semântica: Implementando Type-Checking](2025-10-30.md) |      |
| 04.11.25 | terça         | [Representações Intermediárias de Código - Código de 3 endereços](2025-11-04.md) |      |
| 06.11.25 | quinta        | [Representações Intermediárias de Código - _Control-Flow Graphs_](2025-11-06.md) | [Atividade 7 lançada](https://classroom.github.com/a/Vlr25Bjv)     |
| 11.11.25 | terça         | Análise e Otimização de Código |    |
| 13.11.25 | quinta        | Análise e Otimização de Código |    |
| 18.11.25 | terça         | Análise e Otimização de Código |    |
| 20.11.25 | quinta        | **Consciência Negra (Feriado Nacional)** |       |
| 25.11.25 | terça         | Análise e Otimização de Código |    |
| 27.11.25 | quinta        | Ambientes de Execução |                       |
| 02.12.25 | terça         | Ambientes de Execução |                       |
| 04.12.25 | quinta        | Geração de Código     |                       |
| 09.12.25 | terça         | Geração de Código     |                       |
| 11.12.25 | quinta        | **Exercício Escolar** |                       |
| 16.12.25 | terça         | **Segunda Chamada**   |                       | 
| 18.12.25 | quinta        | **Prova final**       |                       |
