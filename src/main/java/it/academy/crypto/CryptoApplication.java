package it.academy.crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);

/*
		float totalEUR = 0F;
		CryptoService cService = new CryptoService(em);
		for (String coin : cService.getCoins()) {
			try {
				List<Transaction> transactions = cService.getTransactions(coin);

				double sum = transactions.stream().mapToDouble(a -> a.getTransactedQty()).sum();
				float quotation = cService.getQuotation(coin, "EUR");

				System.out.println("[" + coin + "]\t" + sum); // + " @ " + quotation + " ===> " + (sum * quotation) + " EUR");
				totalEUR += (sum * quotation);
			} catch (Exception ex) {
				System.out.println(ex.getLocalizedMessage());
			}
		}

		System.out.println("\n===============================\nTotal: " + totalEUR);
*/

	}

}
