package org.example.ApiConversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCambio {

    public static CambioDeMoneda consultarTipoDeCambio(){

        String apiKey = "fe060fed5e44c55575c2238f";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();

            CambioDeMoneda cambioDeMoneda = gson.fromJson(json, CambioDeMoneda.class);

            if (!cambioDeMoneda.getResult().equalsIgnoreCase("success")){
                throw new RuntimeException("La solicitud a la Api, no fue exitosa, consulte la respuesta del body: \n" + json);
            }

            return  cambioDeMoneda;
         }catch (IOException | InterruptedException e ){
            throw new RuntimeException("Error en ejecución de la API, no se puede continuar con el programa");
        }
    }
}
