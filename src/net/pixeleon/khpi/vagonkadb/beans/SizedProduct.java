package net.pixeleon.khpi.vagonkadb.beans;

import java.io.Serializable;

public class SizedProduct implements Serializable {
    private static final long serialVersionUID = -8866996182175229710L;

    private int sizedProductId;
    private int productId;
    private double lengthFrom;
    private double lengthTo;
    private double width;
    private double thickness;

    public SizedProduct() {
    }

    public SizedProduct(int sizedProductId, int productId, double lengthFrom,
                        double lengthTo, double width, double thickness) {
        this.sizedProductId = sizedProductId;
        this.productId = productId;
        this.lengthFrom = lengthFrom;
        this.lengthTo = lengthTo;
        this.width = width;
        this.thickness = thickness;
    }

    public int getSizedProductId() {
        return sizedProductId;
    }

    public void setSizedProductId(int sizedProductId) {
        this.sizedProductId = sizedProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getLengthFrom() {
        return lengthFrom;
    }

    public void setLengthFrom(double lengthFrom) {
        this.lengthFrom = lengthFrom;
    }

    public double getLengthTo() {
        return lengthTo;
    }

    public void setLengthTo(double lengthTo) {
        this.lengthTo = lengthTo;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}
