package ar.example.cambioDeDivisas.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ar.example.cambioDeDivisas.DTO.ExchageUsdDTO;
import ar.example.cambioDeDivisas.DTO.ExchangeEurDTO;
import ar.example.cambioDeDivisas.entity.Exchange;

public class AppController {
	private static final String BASE_URL = "https://api.frankfurter.app";
	private final Client client;
	private final Gson gson;
	
	public AppController() {
		this.client = ClientBuilder.newClient();
		this.gson = new Gson();
	}
	
	private Exchange callApiLatestBaseEUR() {
	    WebTarget target = client.target(BASE_URL);
	    try (Response response = target.path("latest").request().get()) {
	        if (response.getStatus() != 200) {
	            throw new RuntimeException("Error HTTP: " + response.getStatus());
	        }
	        String jsonResponse = response.readEntity(String.class);
	        return gson.fromJson(jsonResponse, Exchange.class);
	    }
	}
	
	private Exchange callApiLatestBaseUSD() {
	    WebTarget target = client.target(BASE_URL);
	    try (Response response = target.path("latest").queryParam("base", "USD").request().get()) {
	        if (response.getStatus() != 200) {
	            throw new RuntimeException("Error HTTP: " + response.getStatus());
	        }
	        String jsonResponse = response.readEntity(String.class);
	        return gson.fromJson(jsonResponse, Exchange.class);
	    }
	}

	public ExchangeEurDTO getExchangeRatesBaseEur() {
	    Exchange exchange = callApiLatestBaseEUR();
	    return new ExchangeEurDTO(exchange.getRates());
	}
	
	public ExchageUsdDTO getExchangeRatesBaseUsd() {
	    Exchange exchange = callApiLatestBaseUSD();
	    return new ExchageUsdDTO(exchange.getRates());
	}
	
}