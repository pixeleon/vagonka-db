package net.pixeleon.khpi.vagonkadb.beans;

import java.io.Serializable;
import java.util.Date;

public class SizedProductPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    int sizedProductId;
    Date priceDate;
    Double price;
    int amount;

    public SizedProductPrice(int sizedProductId, Double price, int amount) {
        this.sizedProductId = sizedProductId;
        this.price = price;
        this.amount = amount;
    }

    public SizedProductPrice(int sizedProductId, Date priceDate, double price, int amount) {
        this.sizedProductId = sizedProductId;
        this.priceDate = priceDate;
        this.price = price;
        this.amount = amount;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSizedProductId() {
        return sizedProductId;
    }

    public void setSizedProductId(int sizedProductId) {
        this.sizedProductId = sizedProductId;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
