package com.aplicacao.servico;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.aplicacao.dto.EnderecoDto;;

public class ApiServico {

    EnderecoDto enderecoDto = new EnderecoDto();
    public EnderecoDto getEndereco(String cep){
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest chamada = HttpRequest.newBuilder()
            .uri(URI.create("https://viacep.com.br/ws/"+ cep +"/json/")).build();
            HttpResponse<String> response = cliente.send(chamada, HttpResponse.BodyHandlers.ofString());

            
            ObjectMapper mapper = new ObjectMapper();
            enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);
        } catch (Exception e) {
            System.err.println("IH laia deu erro de novo uai que que deu ai zé?");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return enderecoDto;
    }
}

