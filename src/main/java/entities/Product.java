package entities;

import java.util.Objects;

public class Product {
	private int productId;
	private String productName;
	private double price;
	private int quantityInShop;

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityInShop() {
		return quantityInShop;
	}
	public void setQuantityInShop(int quantityInShop) {
		this.quantityInShop = quantityInShop;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product( String productName, double price, int quantityInShop) {
		super();
		//this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantityInShop = quantityInShop;
		
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", quantityInShop=" + quantityInShop+"]" ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return productId == other.productId;
	}
	
}
