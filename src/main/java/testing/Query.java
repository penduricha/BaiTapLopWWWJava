package testing;

import dao.Product_DAO;

public class Query {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product_DAO product_DAO=new Product_DAO();
		System.out.println("List Product");
		System.out.println(product_DAO.getListProducts_ToString());
	}

}
