package com.example.springmongodb.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Data
@Document(collection = "Product")
@TypeAlias("objectId")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private ObjectId _id;
    private int productId;
    private String productName;
    private int quantityInShop;
    private double price;
}
