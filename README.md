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

| Data     | Dia da Semana | Conteúdo Programático | Atividades Associadas |
|----------|---------------|-----------------------|-----------------------|
| 06.05.25 | terça         | [Introdução, admin](2025-05-06.md)       | Pesquisa inicial da disciplina (Google Classroom) | 
| 08.05.25 | quinta        | [Análise Léxica](2025-05-08.md)                      |                       |
| 13.05.25 | terça         | Implementando Analisadores Léxicos                      | Exercício 1 - Análise Léxica |
| 15.05.25 | quinta        | Análise Sintática                   |                       |
| 20.05.25 | terça         | Análise Sintática                   | Exercício 2 - Recursive-descent parsing                      |
| 22.05.25 | quinta        | Análise Sintática                   |                       |
| 27.05.25 | terça         | Análise Sintática                   | Exercício 3 - LL(1) parsing                      |
| 29.05.25 | quinta        | Análise Semântica                   |                       |
| 03.06.25 | terça         | APS - Análise Sintática (ANTLR)                   | Exercício 4 - ANTLR                      |
| 05.06.25 | quinta        | Análise Semântica                   |                       |
| 10.06.25 | terça         | Análise Semântica                   |                       |
| 12.06.25 | quinta        | Análise Semântica                      |                       |
| 17.06.25 | terça         | 1 Exercício Escolar                      | Exercício 5 - Type-Checking                      |
| 19.06.25 | quinta        | **Corpus Christi**        |                       |
| 24.06.25 | terça         | **São João**              |                       |
| 26.06.25 | quinta        | Representações Intermediárias de Código                      |                       |
| 01.07.25 | terça         | Representações Intermediárias de Código                      |                       |
| 03.07.25 | quinta        | Representações Intermediárias de Código                      | Exercício 6 - Interpretador                      |
| 08.07.25 | terça         | Análise e Otimização de Código                      |                       |
| 10.07.25 | quinta        | Análise e Otimização de Código                      |                       |
| 15.07.25 | terça         | Análise e Otimização de Código                      |                       |
| 17.07.25 | quinta        | Análise e Otimização de Código                      | Exercício 7                      |
| 22.07.25 | terça         | APS                      |                       |
| 24.07.25 | quinta        | Ambientes de Execução                      |                       |
| 29.07.25 | terça         | Ambientes de Execução                      |                       |
| 31.07.25 | quinta        | Geração de Código                      | Exercício 8                      |
| 05.08.25 | terça         | Geração de Código                      |                       |
| 07.08.25 | quinta        | Geração de Código                      |                       |
| 12.08.25 | terça         | **2 Exercício Escolar**                      |                       |
| 14.08.25 | quinta        | **Segunda Chamada**                      |                       | 
| 19.08.25 | terça         | **Prova final**                      |                       |
