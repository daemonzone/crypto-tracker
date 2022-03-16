package it.academy.crypto.service;

import it.academy.crypto.models.AssetWithQuantity;
import it.academy.crypto.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {

    @Autowired
    private CryptoRepository cryptoRepository;

    @Override
    public List<String> getAssets() {
        return cryptoRepository.getAssets();
    }

    @Override
    public List<AssetWithQuantity> getAssetsWithQuantity() {
        return cryptoRepository.getAssetsWithQuantity();
    }


/*     public List<Transaction> getTransactions(String symbol) {
        Query query = this.em.createQuery("from Transaction where asset = :symbol", Transaction.class);
        query.setParameter("symbol", symbol);
        return query.getResultList();
    }
*/
/*
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
*/
}
