package it.academy.crypto.models;

public class AssetWithQuantity {

    private String asset;
    private Double quantity;

    public AssetWithQuantity(String asset, Double quantity) {
        this.asset = asset;
        this.quantity = quantity;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
