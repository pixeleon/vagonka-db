package net.pixeleon.khpi.vagonkadb.beans;

import java.io.Serializable;
import java.util.Date;

public class ProductPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    String sizedProductId;
    Date priceDate;
    Double price;

    public ProductPrice(String sizedProductId, Double price) {
        this.sizedProductId = sizedProductId;
        this.price = price;
    }

    public ProductPrice(String sizedProductId, Date priceDate, Double price) {
        this.sizedProductId = sizedProductId;
        this.priceDate = priceDate;
        this.price = price;
    }

    public String getSizedProductId() {
        return sizedProductId;
    }

    public void setSizedProductId(String sizedProductId) {
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
