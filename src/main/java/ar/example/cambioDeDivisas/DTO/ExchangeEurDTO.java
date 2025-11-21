package ar.example.cambioDeDivisas.DTO;

import java.util.Map;

public class ExchangeEurDTO {
	private Double brl;
	private Double chf;
	private Double mxn;
	private Double usd;
	
	public ExchangeEurDTO(Map<String, Double> rates) {
		this.brl = rates.get("BRL");
		this.chf = rates.get("CHF");
		this.mxn = rates.get("MXN");
		this.usd = rates.get("USD");
	}

	public Double getBrl() {
		return brl;
	}

	public Double getChf() {
		return chf;
	}

	public Double getMxn() {
		return mxn;
	}

	public Double getUsd() {
		return usd;
	}

	@Override
	public String toString() {
		return "Cambio de divisas con base de 1 EUR: " +
			"BRL=" + brl +
			", CHF=" + chf +
			", MXN=" + mxn +
			", USD=" + usd;
	}

}