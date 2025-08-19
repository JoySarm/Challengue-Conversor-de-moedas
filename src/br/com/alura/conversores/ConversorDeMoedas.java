package br.com.alura.conversores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoedas {
    private String chaveApi;

    public ConversorDeMoedas(String chaveApi) {
        this.chaveApi = chaveApi;
    }

    public void converter(String moedaOrigem, String moedaDestino, double valor) {
        String endereco = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + moedaOrigem;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            if (jsonObject.has("conversion_rates")) {
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                if (conversionRates.has(moedaDestino)) {
                    double taxaCambio = conversionRates.get(moedaDestino).getAsDouble();
                    double valorConvertido = valor * taxaCambio;

                    System.out.printf("O valor de %.2f [%s] corresponde ao valor final de %.2f [%s]%n",
                            valor, moedaOrigem, valorConvertido, moedaDestino);
                } else {
                    System.out.println("Não foi possível encontrar a taxa de câmbio para a moeda de destino.");
                }
            } else {
                System.out.println("A resposta da API não contém as taxas de conversão.");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao obter a taxa de câmbio: " + e.getMessage());
        }
    }
}
