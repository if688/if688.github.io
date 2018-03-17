# IF688 - Teoria e Implementação de Linguagens Computacionais

## Atividade 1 - Análise Léxica

Este exercício visa trabalhar os conceitos de análise léxica vistos em sala de aula. A ideia é implementar um analisador léxico para a linguagem MiniJava, que consiste em um subconjunto de Java, cujos elementos léxicos são descritos mais abaixo. 

Utilize o gerador de analisadores léxicos [JFlex](http://jflex.de) para implementar o analisador. Para simplificar o processo de configuração do ambiente, é fornecido aqui um esqueleto do projeto, bem como alguns testes para verificar a corretude da sua implementação. Os detalhes de como configurar o projeto seguem mais abaixo.

O único arquivo que deve ser enviado no Google Classroom é o arquivo fonte .jflex, e o nome do arquivo deve ser o seu login. Então, no meu caso seria lmt.jflex. Como sugestão, também indico você usar algum sistema de controle de versão online, como GitHub ou BitBucket, para ir desenvolvendo o analisador. Caso utilize, também inclua o link para o repositório como parte da sua resposta, além do arquivo submetido. 

## Elementos Léxicos de MiniJava

- *Whitespace:* espaços em branco, quebra de linha, tabulação e carriage return (`\n` `\t` `\r` `\f`);
- *Comentários:* os dois tipos de comentário são possíveis, comentários de linha, iniciando com `//` e indo até o final da linha, e comentários de múltiplas linhas, que consistem de qualquer texto entre `/*` e `*/`, sem considerar aninhamento;
- *Palavras reservadas:* `boolean`, `class`, `public`, `extends`, `static`, `void`, `main`, `String`, `int`, `while`, `if`, `else`, `return`, `length`, `true`, `false`, `this`, `new`, `System.out.println`; 
  - (_Por simplicidade e para facilitar a implementação do compilador, MiniJava trata `System.out.println` como uma palavra reservada, não como uma expressão que representa a chamada do método `println`._)
- *Operadores:* `&&`, `<`, `==`, `!=`, `+`, `-`, `*`, `!`; 
  - (_não há operador de divisão, por enquanto_)
- *Delimitadores e pontuação:*  `;` `.` `,` `=` `(` `)` `{` `}` `[` `]`
- *Identificadores:* um identificador começa com uma letra ou _underline_ e é seguido por qualquer quantidade de letras, _underline_ e dígitos. Apenas letras entre A/a e Z/z são permitidos, há diferença entre maiúscula e minúscula. Palavras-chave não são identificadores;
- *Literais Inteiros:* uma sequência de dígitos iniciada com qualquer um dos dígitos entre 1 e 9 e seguida por qualquer número de dígitos entre 0 e 9. O dígito 0 também é um inteiro. 
- Comentários e whitespace não tem significado algum, exceto para separar os tokens.

## ATENÇÃO!

Você _não precisa_, *nem deve*, alterar nada do esqueleto de projeto dado além do arquivo `exemplo.jflex` que conterá a sua implementação das suas regras léxicas e da classe Minijava que contém apenas sua "assinatura" e cuja implementação será gerada a partir de seu arquivo .jflex.

Para mais detalhes de como começar a execução da atividade, observe o texto a seguir que contém o passo-a-passo de como configurar, implementar e testar seu analisador léxico. 

### Importando o Projeto
- Faça o download deste projeto;
- Importe o projeto no Eclipse;
- `File` > `Import` > `Maven` > `Existing Maven Projects` e use a pasta onde está o projeto;
- Com o projeto já extraído, vá até a pasta `src/main/resources` e implemente o seu lexer, usando apenas a parte dedicada do arquivo para tanto.

### Testando seu Projeto
- Após implementar o seu lexer, vá até a classe `Gerador` e rode-a normalmente como aplicação Java. 
- Um arquivo minijava.java será gerado na pasta resources (Caso não apareça, dê um refresh). Sobrescreva o arquivo minijava.java genérico já presente no pacote atividade1, pelo que você acabou de gerar;
- Clique com o botão direito sobre o seu projeto e vá até `Run as` > `Maven Build`;
- Na janela que abre, preencha o campo _Goals_ com _package_ e clique em Run.
- O Maven irá empacotar, rodar e testar a sua aplicação. Os resultados serão apresentados no Console. 

### Erros Comuns - Compilation Error Build Failure
Caso ocorra o erro denotado acima, faça o seguinte passo-a-passo.
- No menu do Eclipse: `Window` > `Preferences` > `Java` > `Installed JREs` > `Add` > `Standard VM`. Em JRE home, aponte para o caminho da sua JDK.
- Deixe apenas a sua JDK marcada em vez da JRE, clique em Apply and Close e tente rodar novamente.