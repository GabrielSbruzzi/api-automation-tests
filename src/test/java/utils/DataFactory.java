package utils;

public class DataFactory {

    public static String createBookBody(int id) {
        return """
        {
            "id": %d,
            "title": "Livro %d",
            "description": "Descrição",
            "pageCount": 100,
            "excerpt": "Resumo",
            "publishDate": "2026-05-07T00:00:00.000Z"
        }
        """.formatted(id, id);
    }
}