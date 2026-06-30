package service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import model.Endereco;
import model.Cotacao;

public class ApiClient {

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Endereco buscarEndereco(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = gson.fromJson(response.body(), JsonObject.class);

        // Se o CEP não existir, o ViaCEP retorna um campo "erro": true
        if (json.has("erro")) {
            throw new RuntimeException("CEP não encontrado: " + cep);
        }

        return new Endereco(
                json.get("cep").getAsString(),
                json.get("logradouro").getAsString(),
                json.get("bairro").getAsString(),
                json.get("localidade").getAsString(),
                json.get("uf").getAsString()
        );
    }

    public Cotacao buscarCotacaoDolar(String dataMMDDYYYY) throws Exception {
        String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao=%27"
                + dataMMDDYYYY + "%27&$format=json";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        JsonArray valores = json.getAsJsonArray("value");

        if (valores.isEmpty()) {
            throw new RuntimeException("Cotação não disponível para a data: " + dataMMDDYYYY);
        }

        JsonObject cotacaoJson = valores.get(0).getAsJsonObject();

        return new Cotacao(
                cotacaoJson.get("cotacaoCompra").getAsDouble(),
                cotacaoJson.get("cotacaoVenda").getAsDouble(),
                cotacaoJson.get("dataHoraCotacao").getAsString()
        );
    }
}