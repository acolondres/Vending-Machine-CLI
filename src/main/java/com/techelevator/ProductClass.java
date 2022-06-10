package com.techelevator;

public class ProductClass {
    private String slot;
    private String name;
    private Double price;
    private String type;
    private Integer itemAmount = 5;
    private Integer itemLimit = 5;

// Constructors

    public ProductClass(String name, Double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

//Getters

        public String getName () {
            return name;
        }
        public Double getPrice () {
            return price;
        }
        public String getType () {
            return type;
        }
        public Integer getItemAmount () {
            return itemAmount;
        }
        public Integer getItemLimit () {
            return itemLimit;
        }
        public String getSlot () {
        return slot;
        }
//Setters
        public void setType (String type){
            this.type = type;
        }

        public void setItemAmount (Integer itemAmount){
            this.itemAmount = itemAmount;
        }

    }


