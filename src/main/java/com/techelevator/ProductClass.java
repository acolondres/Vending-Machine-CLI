package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductClass {

private String name;
private Double price;
private String type;
private String productSlot;



  public ProductClass(String productSlot, String name, Double price, String type){
      this.productSlot = productSlot;
      this.name = name;
      this.type = type;
      this.price = price;


  }

    public String getName() {
        return name;
    }

    public String getProductSlot() {
      return productSlot;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    List<ProductClass> products = new ArrayList<>();
  try(Scanner fileReader = new Scanner(new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-8\\vendingmachine.csv"))){
      while(fileReader.hasNextLine()){

      }
    }









}
