package net.pixeleon.khpi.vagonkadb.beans;

import java.io.Serializable;

public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int productId;
    private String productTypeName;
    private String woodTypeName;
    private String woodKindName;
    private String muAbbrv;

    public ProductInfo(String productTypeName, String woodTypeName, String woodKindName, String muAbbrv) {
        this.setProductTypeName(productTypeName);
        this.setWoodTypeName(woodTypeName);
        this.setWoodKindName(woodKindName);
        this.setMuAbbrv(muAbbrv);
    }

    public ProductInfo(int productId, String productTypeName, String woodTypeName, String woodKindName,
                       String muAbbrv) {
        this.setProductId(productId);
        this.setProductTypeName(productTypeName);
        this.setWoodTypeName(woodTypeName);
        this.setWoodKindName(woodKindName);
        this.setMuAbbrv(muAbbrv);
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
