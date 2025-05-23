# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação & Engenharia da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutor

* **Professor:** Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)

* **Monitores:** 
  - João Victor Ribeiro Costa de Omena ([@Jvrco](https://github.com/Jvrco) --- jvrco@cin)
  - João Vitor Cavalcanti Regis ([@Jvcregis](https://github.com/Jvcregis) --- jvcr@cin)
  - Luis Guilherme Monteiro Maciel Nunes ([@nuneslg](https://github.com/nuneslg) --- lgmmn@cin)
  - Pedro Arthur Santana Patriota ([@pedro-patriota](https://github.com/pedro-patriota) --- pasp@cin)
  - Rodrigo Rossiter Ladvocat Cintra ([@rodrigoladvocat](https://github.com/matheusalb) --- rrlc@cin)

### Horário e Local de Aulas

* Terça (13h-15h), Sala D005
* Quinta (15h-17h), Sala D005

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

- [Discord](https://discord.gg/GavhqBfBRM)
- [Google Classroom](https://classroom.google.com/c/NzI5NzM2NDQwNzk4?cjc=bg4wmer)
- Github Classroom - Ver instruções no Google Classroom após o primeiro exercício ser disparado


### Avaliação

* `Nota` = (`Atividades` x 5 + `Provas` x 5) / 10 
  * `Atividades` = Atividades de programação
  * `Provas` = Exercícios escolares
* `Final`

- Observações:
  - Entrega fora do prazo: **redutor de 1 ponto por dia de atraso**. 
  - Atraso máximo: **1 (uma) semana**. Após esse prazo, será dada nota **zero** para a respectiva atividade de avaliação.
  - Trabalhos **“CTRL-C + CTRL-V”** terão nota **zero** (vale tanto para cópia de colegas, como para trabalhos copiados da internet).

### Plano de Ensino

*Este plano de ensino está sujeito a alterações durante o semestre, visite frequentemente a página para obter a versão mais atualizada, ou acompanhe os updates no repositório.*

| Data      | DIA    | Aula | Conteúdo                                 | Atividades Associadas                    | 
|-----------|--------|------|------------------------------------------|------------------------------------------|
| 12.11.24  | Terça  |  --- | **SEM AULA**                             | ---                                      |
| 14.11.24  | Quinta | 1    | [Introdução, admin](2024-11-14.md)       | Pesquisa inicial da disciplina (Google Classroom) | 
| 19.11.24  | Terça  | 2    | [Análise Léxica](2024-11-19.md)          |                                          | 
| 21.11.24  | Quinta | 3    | [Implementando e gerando Analisadores Léxicos](2024-11-21.md) | Exercício 1 - Análise Léxica         | 
| 26.11.24  | Terça  | 4    | [Análise Sintática _Top-Down_ - _Recursive Descent Parsing_](2024-11-26.md)               |                                          | 
| 28.11.24  | Quinta | 5    | [Análise Sintática _Top-Down_ - LL(1) _Parsing_](2024-11-28.md)               | ~~Exercício 2 - Recursive-descent parsing~~  |
| 03.12.24  | Terça  | 6    | [Análise Sintática Bottom-up - LR(0)](2024-12-03.md)              |                                          |
| 05.12.24  | Quinta | 7    | [Análise Sintática Bottom-up - LR(1)](2024-12-05.md)             | Exercício 2 - LL(1) parsing              |
| 10.12.24  | Terça  | 8    | [Análise Semântica - Intro e ASTs](2024-12-10.md) |                                          |
| 12.12.24  | Quinta | 9    | [Análise Semântica - Visitors](2024-12-12.md) | Exercício 3 - _Recursive-descent parsing_              |
| 17.12.24  | Terça  | 10   | [Análise Semântica - Tipos e Escopo](2024-12-17.md)                        |                                          |
| 19.12.24  | Quinta | 11   | [Análise Semântica - Tabelas de Símbolos e Type-Checking](2024-12-19.md)                        |                       |
| 22.12 a 26.01 | --- | --- | **RECESSO ESCOLAR**                      | ---                                      |
| 28.01.25  | Terça  | 12   | Revisão                                  |                                          |
| 30.01.25  | Quinta | 13   | **1 Exercício Escolar**                  |                                          |
| 04.02.25  | Terça  | 14   | [Representações Intermediárias de Código - Introdução](2025-02-04.md)  |                                          |
| 06.02.25  | Quinta | 15   | **Aula Suspensa - CHUVAS**               |                                          |
| 11.02.25  | Terça  | 16   | [Representações Intermediárias de Código - Código de 3 endereços](2025-02-11.md)    |                                          | 
| 13.02.25  | Quinta | 17   | [Representações Intermediárias de Código - Control-flow Graphs](2025-02-13.md)  |                                           | 
| 18.02.25  | Terça  | 18   | [Análise e Otimização de Código - Otimizações Locais](2025-02-18.md)           |                                          | 
| 20.02.25  | Quinta | 19   | **Aula Suspensa - Reunião ProPG e Professor sem voz**   |                    |
| 25.02.25  | Terça  | 20   | [Análise e Otimização de Código - Otimizações globais _forward-flow_](2025-02-25.md)           |                                          | 
| 27.02.25  | Quinta | 21   | [Análise e Otimização de Código - Otimizações globais _backward-flow_ ](2025-02-27.md)           |                                           | 
| 04.03.25  | Terça  | ---  | **Carnaval**                             | ---                                      |
| 06.03.25  | Quinta | ---  | **Data Magna de Pernambuco**             | ---                                      |
| 11.03.25  | Terça  | 22   | [Análise e Otimização de Código - _Dominance_](2025-03-11.md)                    |                                          | 
| 13.03.25  | Quinta | 23   | [Ambientes de Execução (Pilha)](2025-03-13.md)           |                                          | 
| 18.03.25  | Terça  | 24   | [APS - ANTLR](2025-03-18.md)             |                                          | 
| 20.03.25  | Quinta | 25   | Ambientes de Execução (Heap)             |                                          | 
| 25.03.25  | Terça  | 26   | Geração de Código                        |                                          | 
| 27.03.25  | Quinta | 27   | Geração de Código                        |                                          | 
| 01.04.25  | Terça  | 28   | Geração de Código                        |                                          | 
| 03.04.25  | Quinta | 29   | Revisão                                  |                                          | 
| 08.04.25  | Terça  | 30   | **2 Exercício Escolar**                  |                                          | 
| 10.04.25  | Quinta | 31   | **Segunda Chamada**                      |                                          | 
| 15.04.25  | Terça |  32   | **Prova Final**                          |                                          | 

