package it.academy.crypto;

import it.academy.crypto.entity.Transaction;
import it.academy.crypto.service.CryptoService;
import it.academy.crypto.utils.Utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CryptoApplication {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();

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

		em.close();;
		emf.close();

	}

}
