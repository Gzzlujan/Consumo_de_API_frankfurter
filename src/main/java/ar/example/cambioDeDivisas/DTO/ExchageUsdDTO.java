package ar.example.cambioDeDivisas.DTO;

import java.util.Map;

public class ExchageUsdDTO {
	private Double brl;
	private Double chf;
	private Double mxn;
	private Double eur;
	
	public ExchageUsdDTO(Map<String, Double> rates) {
		this.brl = rates.get("BRL");
		this.chf = rates.get("CHF");
		this.mxn = rates.get("MXN");
		this.eur = rates.get("EUR");
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

	public Double getEur() {
		return eur;
	}

	@Override
	public String toString() {
		return "Cambio de divisas con base de 1 USD:" +
			"BRL=" + brl +
			", CHF=" + chf +
			", MXN=" + mxn +
			", EUR=" + eur ;
	}


}
