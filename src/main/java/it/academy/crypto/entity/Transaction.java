package it.academy.crypto.entity;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.ParseException;


@Entity
@Table(name = "transactions")
public class Transaction {

/*
    Timestamp:  2020-12-22T18:50:02Z
    Transaction Type: Receive
    Asset: BTC
    Quantity Transacted: 0.0003152
    Spot Price Currency: EUR
    Spot Price at Transaction: 19279.52
    Subtotal: 96.16
    Total (inclusive of fees): 100.00
    Fees: 3.84
    Notes: Received 0.0003152 BTC from an external account
*/

    @Id
    @GeneratedValue
    private Long id;
    private String timestamp;
    private String transaction_type;
    private String asset;
    private Double quantity;
    private String currency;
    private Double transaction_price;
    private Double subtotal;
    private Double total;
    private Float fees;
    private String notes;
    private Double transacted_qty;

    public Double getTransactedQty() {
        double transactionQty = this.quantity;
        switch (transaction_type) {
            case "Convert":
            case "Send":
            case "Sell": transactionQty *= -1; break;
            default: break;
        }
        return transactionQty;
    }

    public void setTransactedQty(Double transactedQty) {
    }


    public Transaction() {
    }

    public Transaction(String timestamp, String transaction_type, String asset, Double quantity, String currency, Double transaction_price, Double subtotal, Double total, Float fees, String notes) {
        this.timestamp = timestamp;
        this.asset = asset;
        this.transaction_type = transaction_type;
        this.quantity = quantity;
        this.currency = currency;
        this.transaction_price = transaction_price;
        this.subtotal = subtotal;
        this.total = total;
        this.fees = fees;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransaction_type() { return transaction_type; }

    public void setTransaction_type(String transaction_type) { this.transaction_type = transaction_type; }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) { this.asset = asset; }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getTransaction_price() {
        return transaction_price;
    }

    public void setTransaction_price(Double transaction_price) {
        this.transaction_price = transaction_price;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Float getFees() {
        return fees;
    }

    public void setFees(Float fees) {
        this.fees = fees;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static Transaction parseTransaction(String line) throws Exception {
        // System.out.println("DEBUG - Received: '" + line + "'");

        Transaction result = null;

        String[] tokens = line.replace("\"\"", "").split(",");
        try {
            // String timestamp,
            // String transaction_type,
            // String asset,
            // Double quantity,
            // String currency,
            // Double transaction_price,
            // Double subtotal,
            // Double total,
            // Float fees,
            // String notes
            result = new Transaction(
                    tokens[0],
                    tokens[1],
                    tokens[2],
                    (!StringUtils.isEmpty(tokens[3]) ? Double.parseDouble(tokens[3].replace(',', '.')) : null) ,
                    tokens[4],
                    (!StringUtils.isEmpty(tokens[5]) ? Double.parseDouble(tokens[5]) : null) ,
                    (!StringUtils.isEmpty(tokens[6]) ? Double.parseDouble(tokens[6]) : null) ,
                    (!StringUtils.isEmpty(tokens[7]) ? Double.parseDouble(tokens[7]) : null) ,
                    (!StringUtils.isEmpty(tokens[8])? Float.parseFloat(tokens[8]) : null) ,
                    tokens[9]
            );
        } catch (Exception ex) {
            System.out.println("DEBUG - Line: '" + line + "'");
            System.out.println("DEBUG - Operation: '" + tokens[1] + "'");
            throw new Exception(ex.getLocalizedMessage());
        }
        return result;
    }

    @Override
    public String toString() {
        // return this.transaction_type + " " + this.asset + " => " + this.quantity;
        return this.notes;
    }
}
