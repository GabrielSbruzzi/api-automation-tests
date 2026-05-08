package schemas;
import java.util.HashMap;
import java.util.Map;

public class BookFactory {

    public static Map<String, Object> criarLivro() {

        Map<String, Object> book = new HashMap<>();

        book.put("ID", 999);
        book.put("title", "Livro Automacao");
        book.put("description", "Teste de API");
        book.put("pageCount", 200);
        book.put("excerpt", "Trecho teste");
        book.put("publishDate", "2024-01-01T00:00:00.000Z");

        return book;
    }

}