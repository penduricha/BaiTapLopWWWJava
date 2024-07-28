package dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;

import database.ConnectMongoDB;

import entities.Product;
import i_dao.I_Product_DAO;

public class Product_DAO implements I_Product_DAO {
	ConnectMongoDB connect_MongoDB = new ConnectMongoDB("ShopNhat", "Product");

	public Product_DAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getListProducts() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		FindIterable<Document> findAll = connect_MongoDB.getCollection().find(connect_MongoDB.getDocument());
		try {
			for (Document document : findAll) {
				int productId = document.getInteger("productId");
				String productName = document.getString("productName");
				double price = document.getDouble("price");
				int quantityInShop = document.getInteger("quantityInShop");
				Product product = new Product(productName, price, quantityInShop);
				product.setProductId(productId);
				products.add(product);
			}
		} catch (MongoClientException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return products;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		if (findProduct(product.getProductId()) != null) {
			System.out.println("Product is exist.");
			return false;
		} else {
			/*
			 * public Airport(String iata, String name, String city, String state, String
			 * country, double latitude,double longitude)
			 */
			try {
				Document insert = new Document("_id", connect_MongoDB.getObjectId())
						.append("productId", getProductIdMax() + 1).append("productName", product.getProductName())
						.append("price", product.getPrice()).append("quantityInShop", product.getQuantityInShop());
				connect_MongoDB.getCollection().insertOne(insert);
				System.out.println("Added Successfully.");
				connect_MongoDB.close();
				return true;
			} catch (MongoClientException e) {
				e.printStackTrace();
				System.out.println(e);
				return false;
			}
		}
	}

	@Override
	public boolean deleteProduct(int productId) throws MongoClientException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (findProduct(productId) != null) {
			BasicDBObject filter = new BasicDBObject("productId", productId);
			connect_MongoDB.getCollection().deleteOne(filter);
			System.out.println("Delete Successfull.");
			return true;
		} else {
			System.out.println("Airport is not exist.");
			return false;
		}
	}

	@Override
	public void updateProduct(Product product) throws MongoClientException{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// public Airport(String iata, String name, String city, String state, String
		// country, double latitude,double longitude)
		if (findProduct(product.getProductId()) != null) {
			Document filter = new Document("productId", product.getProductId());
			Document update = new Document("$set",
					new Document("productName", product.getProductName())
					.append("price", product.getPrice())
					.append("quantityInShop", product.getQuantityInShop()));
			/*
			 * .append("productName", product.getProductName())
						.append("price", product.getPrice()).append("quantityInShop", product.getQuantityInShop());
			 */
			UpdateResult result = connect_MongoDB.getCollection().updateOne(filter, update);
			System.out.println("Update Successfull.");
			System.out.println("Số tài liệu được cập nhật: " + result.getModifiedCount());
	
		} else {
			System.out.println("Is not exist.");
		}
	}

	@Override
	public Product findProduct(int productId) {
		// TODO Auto-generated method stub
		for (Product product : getListProducts()) {
			if (product.getProductId() == productId)
				return product;
		}
		return null;
	}

	@Override
	public int getProductIdMax() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int maxProductId = Integer.MIN_VALUE;
		if (getListProducts().size() == 0) {
			return 0;
		}

		for (Product product : getListProducts()) {
			if (product.getProductId() > maxProductId)
				maxProductId = product.getProductId();
		}
		return maxProductId;
	}

	@Override
	public String getListProducts_ToString() {
		// TODO Auto-generated method stub
		String s = "";
		for (Product product : getListProducts()) {
			s += product + "\n";
		}
		return s;
	}

}
