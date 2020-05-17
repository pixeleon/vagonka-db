package net.vadique.khpi.vagonkadb.beans;

import java.io.Serializable;

public class ProductPriceInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	String productTypeName;
	String woodTypeName;
	double price;
	String woodKindName;
	double lengthFrom;
	double lengthTo;
	double width;
	double thickness;
	String muAbbrv;
	
	public ProductPriceInfo(String productTypeName, String woodTypeName, double price, String woodKindName,
			double lengthFrom, double lengthTo, double width, double thickness, String muAbbrv) {
		this.productTypeName = productTypeName;
		this.woodTypeName = woodTypeName;
		this.price = price;
		this.woodKindName = woodKindName;
		this.lengthFrom = lengthFrom;
		this.lengthTo = lengthTo;
		this.width = width;
		this.thickness = thickness;
		this.muAbbrv = muAbbrv;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getWoodKindName() {
		return woodKindName;
	}
	public void setWoodKindName(String woodKindName) {
		this.woodKindName = woodKindName;
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
	public String getMuAbbrv() {
		return muAbbrv;
	}
	public void setMuAbbrv(String muAbbrv) {
		this.muAbbrv = muAbbrv;
	}
	
	
}
