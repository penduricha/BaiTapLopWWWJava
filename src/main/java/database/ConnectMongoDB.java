package database;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.MongoClientException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDB {
	/*
	 * MongoClient clients=MongoClients.create();
	 * 
	 * MongoDatabase database=clients.getDatabase("Entity_Java");
	 * 
	 * MongoCollection<Document> collection=database.getCollection("Person");
	 */
	private MongoClient clients;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	private String dbsName, collectionName;
	private Document document;
	private Gson gson;
	private ObjectId objectId;

	public String getDbsName() {
		return dbsName;
	}

	public void setDbsName(String dbsName) {
		this.dbsName = dbsName;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public MongoClient getClients() {
		return clients;
	}

	public void setClients(MongoClient clients) {
		this.clients = clients;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}

	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public ConnectMongoDB(String dbsName, String collectionName) {
		super();
		// TODO Auto-generated constructor stub
		setClients(MongoClients.create());
		setDatabase(clients.getDatabase(dbsName));
		setCollection(database.getCollection(collectionName));
		setDbsName(dbsName);
		setCollectionName(collectionName);
		setDocument(new Document());
		setGson(new Gson());
		setObjectId(new ObjectId());
	}

	public FindIterable<Document> getFindAll()throws MongoClientException {
		return collection.find(document);
	}
	public void close()throws MongoClientException
	{
		clients.close();
	}
}
