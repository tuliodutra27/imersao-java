import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // fazer a conexão HTTP, pegar os dados e salvar em uma string

        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereco = URI.create(url);
        
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);

        // extrair alguns dados (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> lista_de_filmes = parser.parse(body);
        //System.out.println(lista_de_filmes.get(0));

        //exibir os dados 

        for (Map<String,String> filme : lista_de_filmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
        }
    }
}
