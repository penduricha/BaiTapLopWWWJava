package testing;

import dao.Product_DAO;
import entities.*;
public class Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product_DAO product_DAO=new Product_DAO();
		System.out.println("List Product");
		System.out.println(product_DAO.getListProducts_ToString());
		Product product=new Product("Chao dau", 10, 10);
		product.setProductId(14);
		product_DAO.updateProduct(product);
		System.out.println("List Product after updated");
		System.out.println(product_DAO.getListProducts_ToString());
		
	}

}
