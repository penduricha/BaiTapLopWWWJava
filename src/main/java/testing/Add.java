package testing;

import dao.Product_DAO;
import entities.*;
public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product_DAO product_DAO=new Product_DAO();
		Product productAdd=new Product("Lo vi song",100,10);
		if(product_DAO.addProduct(productAdd)) {
			System.out.println(product_DAO.getListProducts_ToString());
		}
	}

}
