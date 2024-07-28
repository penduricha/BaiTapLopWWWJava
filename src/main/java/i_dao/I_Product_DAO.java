package i_dao;

import java.util.List;

import entities.Product;

public interface I_Product_DAO {
	public List<Product> getListProducts();
	public String getListProducts_ToString();
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public void updateProduct(Product product);
	public Product findProduct(int productId);
	public int getProductIdMax();
	
}
