package it.academy.crypto.service;

import it.academy.crypto.models.AssetWithQuantity;

import java.util.List;

public interface CryptoService {

    public abstract List<String> getAssets();
    public abstract List<AssetWithQuantity> getAssetsWithQuantity();
}
