package testing;

import dao.Product_DAO;

public class Delete {
	public static void main(String[] args) {
		Product_DAO product_DAO=new Product_DAO();
		System.out.println("List Product");
		System.out.println(product_DAO.getListProducts_ToString());
		if(product_DAO.deleteProduct(16)) {
			System.out.println("List Product after deleted");
			System.out.println(product_DAO.getListProducts_ToString());
		}
	}
}
