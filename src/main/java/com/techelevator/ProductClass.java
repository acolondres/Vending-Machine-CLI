package com.techelevator;

public class ProductClass {

private String name;
private Double price;
private String type;
private String productSlot;
private Integer itemAmount = 5;
private Integer itemLimit = 5;







  public ProductClass(String productSlot, Double price, String type){
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

    public Integer itemAmount() {return itemAmount;}

    //Setter
    public void setType(String type) {
      this.type = type; }

    public void setItemAmount(Integer itemAmount) {
      this.itemAmount = itemAmount; }


    }



