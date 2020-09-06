package net.pixeleon.khpi.vagonkadb.beans;

import java.io.Serializable;

public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    int productId;
    String productTypeName;
    String woodTypeName;
    String woodKindName;
    String muAbbrv;

    public ProductInfo(String productTypeName, String woodTypeName, String woodKindName, String muAbbrv) {
        this.productTypeName = productTypeName;
        this.woodTypeName = woodTypeName;
        this.woodKindName = woodKindName;
        this.muAbbrv = muAbbrv;
    }

    public ProductInfo(int productId, String productTypeName, String woodTypeName, String woodKindName,
                       String muAbbrv) {
        this.productId = productId;
        this.productTypeName = productTypeName;
        this.woodTypeName = woodTypeName;
        this.woodKindName = woodKindName;
        this.muAbbrv = muAbbrv;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getWoodTypeName() {
        return woodTypeName;
    }

    public void setWoodTypeName(String woodTypeName) {
        this.woodTypeName = woodTypeName;
    }

    public String getWoodKindName() {
        return woodKindName;
    }

    public void setWoodKindName(String woodKindName) {
        this.woodKindName = woodKindName;
    }

    public String getMuAbbrv() {
        return muAbbrv;
    }

    public void setMuAbbrv(String muAbbrv) {
        this.muAbbrv = muAbbrv;
    }


}
