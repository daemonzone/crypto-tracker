package it.academy.crypto.repository;

import it.academy.crypto.entity.Transaction;
import it.academy.crypto.models.AssetWithQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptoRepository extends JpaRepository<Transaction, Long> {

    @Query("select distinct asset from Transaction order by asset")
    public List<String> getAssets();

    @Query(value = "select new it.academy.crypto.models.AssetWithQuantity(t.asset, sum(t.transacted_quantity)) from Transaction t group by t.asset order by t.asset", nativeQuery = false)
    List<AssetWithQuantity> getAssetsWithQuantity();
}