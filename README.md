````markdown
# Automação de Testes API REST

Projeto de automação de testes desenvolvido em Java utilizando RestAssured, JUnit 5 e Gradle para validar operações CRUD de uma API REST.

## Tecnologias Utilizadas

- Java
- RestAssured
- JUnit 5
- Gradle

## Objetivo

Garantir o funcionamento das operações da API:

- Create
- Read
- Update
- Delete

Validando:

- Status Code HTTP
- Contrato da API (JSON Schema)
- Cenários positivos e negativos

## API Utilizada

API pública fake para testes:

```txt
https://fakerestapi.azurewebsites.net
````

## Cenários Automatizados

### Livros (Books)

* Buscar todos os livros
* Buscar livro por ID
* Buscar livro inexistente
* Criar livro
* Criar livro inválido
* Atualizar livro
* Atualizar livro inexistente
* Deletar livro
* Deletar livro inexistente
* Validar schema do livro

## Status Codes Validados

* 200 OK
* 400 Bad Request
* 404 Not Found

## Como Executar

Clone o projeto:

```bash
git clone https://github.com/SEU-USUARIO/api-automation-tests.git
```

Acesse a pasta:

```bash
cd api-automation-tests
```

Execute os testes:

```bash
./gradlew test
```

## Relatórios

Após a execução, o relatório HTML será gerado em:

```txt
build/reports/tests/test/index.html
```

## Observação

A API pública utilizada possui alguns comportamentos inconsistentes em cenários negativos, retornando status 200 em algumas situações onde seriam esperados erros 400 ou 404.

```
```
