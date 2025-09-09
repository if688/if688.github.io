# Explorando Representações Intermediárias com LLVM IR

## **Objetivo**

Compreender na prática o conceito de **representação intermediária (IR)** no processo de compilação, utilizando o **LLVM IR** para observar como um código em C é transformado em uma representação abstrata independente de máquina. Esta atividade permite também visualizar o uso de variáveis SSA, blocos básicos, instruções de controle e otimizações no nível de IR.

## **Material Esperado para Entrega**

O aluno deve enviar os arquivos abaixo via Google Classroom (não envie um `.zip`, mas suba os arquivos separadamente):

- `operacoes.c` – código-fonte original
- `operacoes.ll` – IR gerado da versão original
- `operacoes_mod.c` – código-fonte modificado
- `operacoes_mod.ll` – IR da versão modificada
- `operacoes_opt.ll` – IR otimizado com `opt -O2`
- `respostas.md` ou `respostas.pdf` – respostas às perguntas da atividade

## **Instruções**

### 1. **Preparação do Ambiente**

Verifique se `clang` e `opt` estão instalados:

```bash
clang --version
opt --version
```

Se necessário, instale no Linux com:

```bash
sudo apt install clang llvm
```

Para outros SOs, vide https://llvm.org. 

### 2. Código C e Geração de IR

* Crie o arquivo `operacoes.c` com o seguinte conteúdo:

```c
#include <stdio.h>

int soma(int a, int b) {
    return a + b;
}

int multiplica(int x, int y) {
    return x * y;
}

int calcula(int valor) {
    if (valor > 10) {
        return multiplica(valor, 2);
    } else {
        return soma(valor, 5);
    }
}

int main() {
    int resultado = calcula(7);
    printf("Resultado: %d\n", resultado);
    return 0;
}
```

* Gere o arquivo no formato LLVM IR:

```bash
clang -S -emit-llvm operacoes.c -o operacoes.ll
```

* Abra `operacoes.ll` e responda às perguntas a seguir em um arquivo `respostas.md` ou `respostas.pdf`.

#### Perguntas:

* Como estão representadas as funções `soma`, `multiplica` e `calcula` em IR?
* O que aparece no IR que representa a condição `if (valor > 10)`?
* Como são representadas as chamadas às funções auxiliares em IR?

### 3. Modificação do Código

* Crie um novo arquivo `operacoes_mod.c` com alterações. Por exemplo (apenas para dar uma ideia, faça alterações como desejar, exceto na função `calcula`):

```c
#include <stdio.h>

int soma(int a, int b) {
    return a + b;
}

int multiplica(int x, int y) {
    return x * y;
}

int divide(int x, int y) {
    if (y == 0) return 0;
    return x / y;
}

int calcula(int valor) {
    int temp = soma(valor, 3);
    if (temp % 2 == 0) {
        return multiplica(temp, 4);
    } else {
        return divide(temp, 2);
    }
}

int main() {
    int resultado = calcula(5);
    printf("Resultado: %d\n", resultado);
    return 0;
}
```

* Gere o arquivo no formato LLVM IR:

```bash
clang -S -emit-llvm operacoes_mod.c -o operacoes_mod.ll
```

* Compare com `operacoes.ll` e responda as questões abaixo. 

#### Perguntas

* Como o `if (temp % 2 == 0)` aparece no IR?
* Como o operador `%` (módulo) é representado no LLVM IR?
* Quais são os blocos básicos criados pela nova lógica condicional?

### 4. Otimização com `opt`

* Aplique otimizações no IR original:

```bash
opt -O2 operacoes.ll -S -o operacoes_opt.ll
```

* Analise e responda as questões abaixo. 

#### Perguntas

* Que mudanças ocorreram na função `main` após a otimização?
* Alguma função foi *inlined* (inserida diretamente)? Como identificar?
* Alguma variável intermediária foi eliminada? Por quê?

### 5. Visualizando o Grafo de Fluxo de Controle (CFG)

Nesta etapa, você irá gerar uma representação gráfica do **fluxo de controle** da função `calcula` usando o `opt` com a opção `-dot-cfg`. Esse recurso gera arquivos `.dot` que podem ser visualizados.

* Gere os arquivos `.dot`:

```bash
opt -dot-cfg operacoes_mod.ll -disable-output
```

* Isso criará arquivos `.dot` (um por função) com nomes como `cfg.calcula.dot`. Para visualizar, use ferramentas como `xdot` (no Linux) ou converta para imagem com `Graphviz`.

#### Perguntas

* Quantos blocos básicos você consegue identificar na função `calcula`?
* Quais são os caminhos possíveis a partir da condição `if (temp % 2 == 0)`?
* O fluxo de controle inclui **blocos de erro** ou **casos não triviais** (e.g., retorno precoce)?
* Há blocos com apenas instruções de salto? O que você imagina que isso indica?

# Recursos de Apoio

* [LLVM Language Reference Manual](https://llvm.org/docs/LangRef.html)
* [Clang Command Line Reference](https://clang.llvm.org/docs/CommandGuide/index.html)
* [opt - LLVM Optimizer](https://llvm.org/docs/CommandGuide/opt.html)
* [Compiler Explorer (godbolt.org)](https://godbolt.org/)
* [A Gentle Introduction to LLVM IR](https://mcyoung.xyz/2023/08/01/llvm-ir/)
* [LLVM in 100 Seconds](https://www.youtube.com/watch?v=BT2Cv-Tjq7Q)
* [An introduction to LLVM IR](https://www.youtube.com/watch?v=CDKuH7SIgdM)