# Sistema de Controle Financeiro

Projeto desenvolvido em Java com foco em controle financeiro no terminal, permitindo o gerenciamento de receitas e despesas com validações, tratamento de exceções personalizadas e cálculo de saldo.

---

## Funcionalidades

- Adicionar receitas
- Adicionar despesas
- Listar transações
- Remover transações por ID
- Calcular saldo total
- Validação de entradas
- Tratamento de exceções personalizadas

---

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Collections Framework (`HashMap`)
- Exceptions
- Enum
- Scanner

---

## Estrutura do projeto

```txt
src/
├── exceptions/
│   ├── ControleFinanceiroException.java
│   ├── DescricaoVaziaException.java
│   ├── IdInvalidoException.java
│   └── ValorInvalidoException.java
│
├── model/
│   ├── TipoTransacao.java
│   └── Transacao.java
│
├── service/
│   └── ControleFinanceiro.java
│
└── Main.java
```

---

## Conceitos aplicados

- Encapsulamento
- Enumerações (`enum`)
- Tratamento de exceções
- Validação de dados
- Estruturação em camadas
- Manipulação de Collections
- Separação de responsabilidades

---

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/BryanGabr/Sistema-De-Controle-Financeiro.git
```

### 2. Acesse a pasta do projeto

```bash
cd Sistema-De-Controle-Financeiro
```

### 3. Compile o projeto

```bash
javac Main.java
```

### 4. Execute o programa

```bash
java Main
```

---

## Exemplo de uso

```txt
1 - Adicionar receita
2 - Adicionar despesa
3 - Listar
4 - Saldo
5 - Remover
0 - Sair
```

---


## Autor

Desenvolvido por Bryan Gabriel.