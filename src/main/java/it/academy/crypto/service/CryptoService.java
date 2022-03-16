package it.academy.crypto.service;

import it.academy.crypto.entity.Transaction;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CryptoService {

    private EntityManager em;

    public CryptoService(EntityManager em) {
        this.em = em;
    }


    public List<String> getCoins() {
        Query query = this.em.createQuery("select distinct asset from Transaction order by asset", String.class);
        return query.getResultList();
    }


    public List<Transaction> getTransactions(String symbol) {
        Query query = this.em.createQuery("from Transaction where asset = :symbol", Transaction.class);
        query.setParameter("symbol", symbol);
        return query.getResultList();
    }


    public Float getQuotation(String symbol, String currency) throws Exception {
        Query query = this.em.createQuery("select quote from Coin where symbol = :symbol and currency = :currency", Float.class);
        query.setParameter("symbol", symbol);
        query.setParameter("currency", currency);
        if (query.getResultList().size() > 0)
            return (Float) query.getResultList().get(0);
        else {
            throw new Exception("[" + symbol + "] Quotation not found (" + currency + ")");
        }
    }

}
