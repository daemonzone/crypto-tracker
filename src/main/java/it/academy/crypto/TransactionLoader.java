package it.academy.crypto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.academy.crypto.entity.Transaction;
import it.academy.crypto.utils.Utilities;
import java.util.ArrayList;
import java.util.List;

public class TransactionLoader {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();

		Utilities utils = new Utilities();
		List<Transaction> operations = new ArrayList<Transaction>();

		int lineNum = 1;
		for(String line : utils.loadFile("/Users/davide/Desktop/AGM Academy/Crypto Academy/Coinbase-TransactionsHistoryReport.csv")) {
 			try
			{
				if (lineNum == 1) { lineNum++; continue; }	// Skips first line (header)

				Transaction transaction = Transaction.parseTransaction(line);

				if (transaction != null) {
					// operations.add(transaction);
					em.getTransaction().begin();
					em.persist(transaction);
					em.getTransaction().commit();
				}
			} catch (Exception ex) {
				 System.out.println("ERROR - Line #" + lineNum + ": " + ex.getLocalizedMessage());
			}
			lineNum++;
		}

		em.close();;
		emf.close();

		for(Transaction operation : operations) {
			System.out.println(operation.toString());
		}

		System.out.println("Loaded Transactions: " + operations.size());
		/*
		Transaction p = new Transaction();

		EntityManagerFactory factory = new Persistence().createEntityManagerFactory("connessione_db");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();

		manager.close();
		*/
		
	}

}
