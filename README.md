# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação & Engenharia da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutor

* **Professor:** Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)
  
### Horário e Local de Aulas

* Terça (10h-12h), Sala E233
* Quinta (8h-10h), Sala E233

### Ementa

Este curso explora os princípios, algoritmos, e estruturas de dados envolvidos na teoria e implementação de compiladores. 
O conteúdo planejado inclui uma introdução aos princípios e técnicas de construção de compiladores, conceitos básicos da teoria de linguagens, análise léxica, análise sintática, análise semântica, representação de código intermediário, ambientes de execução, análise estática, otimização de código, geração de código.

### Bibliografia Sugerida

- [Keith Cooper & Linda Torczon. Engineering a Compiler. 2nd Edition, Morgan Kaufmann, 2012](https://www.elsevier.com/books/engineering-a-compiler/cooper/978-0-12-088478-0)
- [Robert Nystrom. Crafting interpreters. Genever Benning, 2021.](https://craftinginterpreters.com/)
- [Jeremy G. Siek. Essentials of Compilation: An Incremental Approach in Racket/Python. 1st Edition, MIT Press, 2023](https://mitpress.mit.edu/9780262048248/essentials-of-compilation/)
- [Dick Grune, Kees Van Reeuwijk, Henri E. Bal, Ceriel J. H. Jacobs, and Koen Langendoen. Modern Compiler Design. 2nd Edition, Springer, 2012](https://dickgrune.com/Books/MCD_2nd_Edition/)

### Bibliografia Complementar
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

- [Discord](https://discord.gg/QGTDeSVH)
- [Google Classroom](https://classroom.google.com/c/NTU0MjM5MDUwODI1?cjc=qshjvmw)
- Github Classroom - Ver instruções no Google Classroom


### Avaliação

* `Nota` = (`Participacao` x 1 + `Atividades` x 4,5 + `Provas` x 4,5) / 10 
  * `Participacao` = Participação nas aulas e respostas a quizzes lançados no google classroom
  * `Atividades` = Atividades de programação
  * `Provas` = Exercícios escolares
* `Final`

- Observações:
  - Entrega fora do prazo: **redutor de 1 ponto por dia de atraso**. 
  - Atraso máximo: **1 (uma) semana**. Após esse prazo, será dada nota **zero** para a respectiva atividade de avaliação.
  - Trabalhos **“CTRL-C + CTRL-V”** terão nota **zero** (vale tanto para cópia de colegas, como para trabalhos copiados da internet).

### Plano de Ensino

*Este plano de ensino está sujeito a alterações durante o semestre, visite frequentemente a página para obter a versão mais atualizada, ou acompanhe os updates no repositório.*


| Data | Dia | Conteúdo Programático | Atividades Associadas |
|-----------------|---------------|-----------------------|----------------------|
| 30.05.23        | Terça         |  Introdução, admin                                |                      |
| 01.06.23        | Quinta        | Conceitos Básicos e Análise Léxica                |                      |
| 06.06.23        | Terça         | Implementando Analisadores Léxicos                |                      |
| 08.06.23        | Quinta        | **Corpus Christi – Ponto facultativo**            | ---                  |
| 13.06.23        | Terça         | Introdução à Análise Sintática e Top-Down Parsing |                      |
| 15.06.23        | Quinta        | Análise Sintática - Top-Down parsing - LL(1) |                      |
| 20.06.23        | Terça         | Análise Sintática - Bottom-up parsing |                      |
| 22.06.23        | Quinta        | Análise Sintática - Bottom-up parsing - LR(1) |                      |
| 27.06.23        | Terça         | Análise Semântica     |                      |
| 29.06.23        | Quinta        | Análise Semântica     |                      |
| 04.07.23        | Terça         | Análise Semântica     |                      |
| 06.07.23        | Quinta        | Análise Semântica     |                      |
| 11.07.23        | Terça         | Análise Semântica     |                      |
| 13.07.23        | Quinta        | **1 Exercício Escolar**     |                      |
| 18.07.23        | Terça         | Representações Intermediárias de Código |                      |
| 20.07.23        | Quinta        | Representações Intermediárias de Código |                      |
| 25.07.23        | Terça         | Representações Intermediárias de Código |                      |
| 27.07.23        | Quinta        | Representações Intermediárias de Código |                      |
| 01.08.23        | Terça         | Análise e Otimização de Código |                      |
| 03.08.23        | Quinta        | Análise e Otimização de Código |                      |
| 08.08.23        | Terça         | Análise e Otimização de Código |                      |
| 10.08.23        | Quinta        | Análise e Otimização de Código |                      |
| 15.08.23        | Terça         | Ambientes de Execução |                      |
| 17.08.23        | Quinta        | Ambientes de Execução |                      |
| 22.08.23        | Terça         | Geração de Código |                      |
| 24.08.23        | Quinta        | Geração de Código |                      |
| 29.08.23        | Terça         | Geração de Código |                      |
| 31.08.23        | Quinta        | Geração de Código |                      |
| 05.09.23        | Terça         | **2 Exercício Escolar**     |                      |
| *07.09.23*      | Quinta        | **Independência do Brasil** |                      |
| 12.09.23        | Terça         | **2a Chamada**     |                      |
| 14.09.23        | Quinta        | Tira dúvidas |                      |
| 19.09.23        | Terça         | **Prova Final**     |                      |
| 21.09.23        | Quinta        | *Buffer*                      |                      |
| 26.09.23        | Terça         | *Buffer*                      |                      |
| 28.09.23        | Quinta        | *Buffer*                      |                      |