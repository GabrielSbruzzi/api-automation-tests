package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BooksTest extends BaseTest {

    @Test
    void deveBuscarTodosOsLivros() {
        given()
                .when()
                .get("/api/v1/Books")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    void deveBuscarLivroPorId() {
        given()
                .when()
                .get("/api/v1/Books/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    void deveRetornar404AoBuscarLivroInexistente() {
        given()
                .when()
                .get("/api/v1/Books/999999")
                .then()
                .statusCode(404);
    }

    @Test
    void deveCriarLivro() {

        String body = """
    {
        "title": "Teste API",
        "description": "Descrição teste",
        "pageCount": 100,
        "excerpt": "Resumo",
        "publishDate": "2026-05-07T00:00:00.000Z"
    }
    """;

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/api/v1/Books")
                .then()
                .statusCode(200)
                .body("title", equalTo("Teste API"));
    }

    @Test
    void deveRetornar400AoCriarLivroInvalido() {

        String body = """
        {
            "title": "",
            "pageCount": -10
        }
        """;

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/api/v1/Books")
                .then()
                .statusCode(400);
    }

    @Test
    void deveAtualizarLivro() {

        String body = """
        {
            "id": 1,
            "title": "Atualizado",
            "description": "Atualizado",
            "pageCount": 200,
            "excerpt": "Atualizado",
            "publishDate": "2026-05-07T00:00:00.000Z"
        }
        """;

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .put("/api/v1/Books/1")
                .then()
                .statusCode(200);
    }

    @Test
    void deveRetornar404AoAtualizarLivroInexistente() {

        String body = """
        {
            "id": 999999,
            "title": "Teste",
            "description": "Teste",
            "pageCount": 100,
            "excerpt": "Teste",
            "publishDate": "2026-05-07T00:00:00.000Z"
        }
        """;

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .put("/api/v1/Books/999999")
                .then()
                .statusCode(404);
    }

    @Test
    void deveDeletarLivro() {
        given()
                .when()
                .delete("/api/v1/Books/1")
                .then()
                .statusCode(200);
    }

    @Test
    void deveRetornar404AoDeletarLivroInexistente() {
        given()
                .when()
                .delete("/api/v1/Books/999999")
                .then()
                .statusCode(404);
    }

    @Test
    void deveValidarSchemaDoLivro() {
        given()
                .when()
                .get("/api/v1/Books/1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/bookSchema.json"));
    }
}