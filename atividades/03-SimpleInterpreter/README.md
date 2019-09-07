# IF688 - Teoria e Implementação de Linguagens Computacionais

## Atividade 3 - Usando Visitors para extrair informações e interpretar ASTs

O objetivo deste exercício é consolidar os conceitos de ASTs e _Visitors_. Portanto, a ideia é implementar um interpretador e um extrator de informações por meio de _visitors_. 

Usando o projeto disponível aqui no repositório, faça a implementação das seguintes funcionalidades por meio de visitors:
- `MaxArgsVisitor`, onde deve ser recebido um programa representado com os nós da AST disponíveis (ver exemplos na classe `Prog`) e deve ser retornado o número máximo de argumentos passados em algum comando `PrintStm` do programa (retornar apenas 1 valor numérico);
- `InterpreterVisitor`, onde também será recebido um programa representado com os nós da AST e você deve "interpretar" o código usando Java, utilizando as classes `Table` e `IntAndTable` como tabelas de símbolos auxiliares.

O código que deve ser implementado já está disponível nas classes `br.ufpe.cin.if688.visitor.MaxArgsVisitor`, `br.ufpe.cin.if688.visitor.Interpreter`, e `br.ufpe.cin.if688.visitor.IntAndTableVisitor`. Estas classes já tem o esqueleto dos _visitors_ que devem ser implementados com os tipos específicos (`void` e `int`) usando o mecanismo de _Generics_ de Java.

Para você ter mais evidências de que seu código está correto, rode os testes disponíveis no projeto.


