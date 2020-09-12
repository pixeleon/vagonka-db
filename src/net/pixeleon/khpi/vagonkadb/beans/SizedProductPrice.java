package net.pixeleon.khpi.vagonkadb.beans;

import java.io.Serializable;
import java.util.Date;

public class SizedProductPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    int sizedProductId;
    Date updateDate;
    Double price;
    int amount;

    public SizedProductPrice(int sizedProductId, Double price, int amount) {
        this.sizedProductId = sizedProductId;
        this.price = price;
        this.amount = amount;
    }

    public SizedProductPrice(int sizedProductId, Date updateDate, double price, int amount) {
        this.sizedProductId = sizedProductId;
        this.updateDate = updateDate;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
