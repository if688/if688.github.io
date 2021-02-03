# IF688 - Teoria e Implementação de Linguagens Computacionais

## Ciência da Computação, [Centro de Informática](http://www.cin.ufpe.br), ([UFPE](http://www.ufpe.br))

### Instrutores

* **Professor** 
  * Leopoldo Motta Teixeira ([@leopoldomt](https://github.com/leopoldomt) --- lmt@cin)
* **Monitores** 
  * Guilherme Gouveia Figueiredo Lima ([@Gui-Lima](https://github.com/Gui-Lima) --- ggfl@cin)
  * Lucas Barros de Almeida Machado ([@lucasbarross](https://github.com/lucasbarross) --- lbam@cin)
  * Lucas Cardoso Coelho Alves de Oliveira ([@Lucas-CardosoO](https://github.com/Lucas-CardosoO) --- lccao@cin)
  * Matheus Borba Alves ([@mlbas](https://github.com/mlbas) --- mlbas@cin)
  
### Horário e Local de Aulas

* Terça (8h-10h), aula assíncrona
* Sexta (10h-12h), aula síncrona (google meet)

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
- [iudex.io](https://iudex.io/group/join/i8hXCJG)

### Avaliação

* `Nota` = (`Participacao` x 1,5 + `Listas` x 2,5 + `Atividades` x 6,0) / 10 
  * `Participacao` = Participação nas aulas, resposta a quizzes lançados no classroom
  * `Listas` = Listas de exercício
  * `Atividades` = Atividades de programação
* `Final`: Chamada oral

- Observações:
  - Entrega fora do prazo: **redutor de 1 ponto por dia de atraso**. 
  - Atraso máximo: **1 (uma) semana**. Após esse prazo, será dada nota **zero** para a respectiva atividade de avaliação.
  - Trabalhos **“CTRL-C + CTRL-V”** terão nota **zero** (vale tanto para cópia de colegas, como para trabalhos copiados da internet).

### Plano de Ensino

**Atenção!** 
*Este plano de ensino está sujeito a alterações durante o semestre, visite frequentemente a página para obter a versão mais atualizada, ou acompanhe os updates no repositório.*

| Data | Assunto | Tipo de Aula | Atividades |
|:----:|:----------------------:|:----------------------:|:----------------------|
| 26.01.21 (ter) | **Sem atividade** | Assíncrona | --- |
| 29.01.21 (sex) | [Introdução, admin](2021-01-29.md) | Síncrona | --- |
| 02.02.21 (ter) | [Análise Léxica](2021-02-02.md) | Assíncrona | --- |
| 05.02.21 (sex) | Implementando Analisadores Léxicos | Síncrona | [*Atividade 1 lançada*] |
| 09.02.21 (ter) | Análise Sintática e Top-Down Parsing | Assíncrona | --- |
| 12.02.21 (sex) | Gramáticas LL(1) | Síncrona | [*Atividade 2 lançada*] |
| 16.02.21 (ter) | Bottom-up parsing e LR(0) | Assíncrona | --- |
| 18.02.21 (qui) | *Deadline para entrega da Atividade 1* | --- | --- |
| 19.02.21 (sex) | Gramáticas LR(1) | Síncrona | --- |
| 23.02.21 (ter) | *Parser generators* | Assíncrona | --- |
| 25.02.21 (qui) | *Deadline para entrega da Atividade 2* | --- | --- |
| 26.02.21 (sex) | Análise Semântica | Síncrona | [*Atividade 3 lançada*] |
| 02.03.21 (ter) | Análise Semântica | Assíncrona | --- |
| 05.03.21 (sex) | Análise Semântica | Síncrona | --- |
| 09.03.21 (ter) | Representações Intermediárias de código | Assíncrona | --- |
| 11.03.21 (qui) | *Deadline para entrega da Atividade 3* | --- | --- |
| 12.03.21 (sex) | Representações Intermediárias de código | Síncrona | [*Atividade 4 lançada*] |
| 16.03.21 (ter) | Representações Intermediárias de código | Assíncrona | --- |
| 19.03.21 (sex) | Representações Intermediárias de código | Síncrona | --- |
| 23.03.21 (ter) | Análise e Otimização de Código | Assíncrona | --- |
| 25.03.21 (qui) | *Deadline para entrega da Atividade 4* | --- | --- |
| 26.03.21 (sex) | Análise e Otimização de Código | Síncrona | [*Atividade 5 lançada*] |
| 30.03.21 (ter) | Análise e Otimização de Código | Assíncrona | --- |
| 02.04.21 (sex) | **Páscoa** | --- | --- |
| 06.04.21 (ter) | Análise e Otimização de Código | Assíncrona | --- |
| 25.03.21 (qui) | *Deadline para entrega da Atividade 5* | --- | --- |
| 09.04.21 (sex) | Análise e Otimização de Código | Síncrona | [*Atividade 6 lançada*] |
| 13.04.21 (ter) | Ambientes de Execução | Assíncrona | --- |
| 16.04.21 (sex) | Ambientes de Execução | Síncrona | --- |
| 20.04.21 (ter) | Geração de Código | Assíncrona | --- |
| 25.03.21 (qui) | *Deadline para entrega da Atividade 6* | --- | --- |
| 23.04.21 (sex) | Geração de Código | Síncrona | --- |
| 27.04.21 (ter) | Geração de Código | Assíncrona | --- |
| 30.04.21 (sex) | Geração de Código | Síncrona | --- |
| 04.05.21 (ter) | **Prova Final** | Síncrona | --- |