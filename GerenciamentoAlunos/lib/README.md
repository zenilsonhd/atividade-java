
# Sistema de Gerenciamento de Alunos

Este projeto implementa um sistema simples de gerenciamento de alunos utilizando Java e banco de dados SQLite. O sistema permite operações básicas de CRUD (Create, Read, Update, Delete) via console.

---

## Estrutura do projeto

- `Aluno.java` — Classe que representa o modelo Aluno com atributos e métodos.
- `AlunoDAO.java` — Classe responsável pela conexão e operações no banco SQLite.
- `Main.java` — Classe principal que contém o menu interativo no console.
- `lib/sqlite-jdbc-3.49.1.0.jar` — Biblioteca JDBC para conexão com SQLite.

---

## Requisitos

- Java JDK 8 ou superior instalado.
- SQLite JDBC driver (`sqlite-jdbc-3.49.1.0.jar`) dentro da pasta `lib`.

---

## Como compilar e executar

1. Abra o terminal na pasta `src` do projeto.

2. Compile as classes com o comando:

```bash
javac -cp ".;../lib/sqlite-jdbc-3.49.1.0.jar" *.java
```

*(No Linux/macOS use `:` ao invés de `;` para separar o classpath.)*

3. Execute o programa com:

```bash
java -cp ".;../lib/sqlite-jdbc-3.49.1.0.jar" Main
```

4. O programa vai abrir um menu no console para você:

- Inserir aluno
- Listar todos os alunos
- Buscar aluno por ID
- Atualizar aluno
- Deletar aluno
- Sair

---

## Banco de Dados

O banco SQLite será criado automaticamente na raiz do projeto com o nome `alunos.db`. Você pode visualizar esse banco com ferramentas como:

- [DB Browser for SQLite](https://sqlitebrowser.org/)
- Extensões SQLite no VS Code

---

## Observações

- Cada aluno deve ter um `id` único.
- O sistema usa POO (Programação Orientada a Objetos) e JDBC para conexão com SQLite.
- Código simples para fins acadêmicos.

---

## Autor

Seu Nome Aqui

---

Qualquer dúvida, estou à disposição!
