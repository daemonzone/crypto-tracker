package it.academy.crypto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coins")
public class Coin {
	
	private Long id;
	private String symbol;
	private String currency;
	private Float quote;
	private String timestamp;
	public Coin() {
	}	public Coin(String symbol, String currency, Float quote, String timestamp) {
		this.symbol = symbol;
		this.currency = currency;
		this.quote = quote;
		this.timestamp = timestamp;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) { this.id = id; }

	public String getSymbol() { return symbol; }
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getQuote() {
		return quote;
	}
	public void setQuote(Float quote) {
		this.quote = quote;
	}

	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
