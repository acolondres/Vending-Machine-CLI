package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InventoryClass {

    File inputFile = new File("vendingmachine.csv");
    List<String> itemSlot = new ArrayList<>();
    List<String> itemNames = new ArrayList<>();
    List<Double> itemPrices = new ArrayList<>();
    List<String> itemTypes = new ArrayList<>();
    List<ProductClass> ourProductList = new ArrayList<>();
    Map<String, ProductClass> itemList = new LinkedHashMap<>();
    int counter = 0;

    public InventoryClass() {}

    public List<ProductClass> getOurProductList() {
        return ourProductList;
    }


    public Map<String, ProductClass> makeItemList() {
        try (Scanner fileReader = new Scanner(inputFile)) {

            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();
                String[] splitString = currentLine.split("\\|");
                itemSlot.add(splitString[0]);
                itemNames.add(splitString[1]);
                itemPrices.add(Double.parseDouble(splitString[2]));
                itemTypes.add(splitString[3]);


            }

        } catch (FileNotFoundException ex) {
            System.out.println("Item list not available");
        }
        ourProductList = new ArrayList<>();
        for (int i = 0; i < itemSlot.size(); i++) {
            ProductClass product = new ProductClass(itemNames.get(i), itemPrices.get(i), itemTypes.get(i));
            ourProductList.add(product);
        }

       itemList = new LinkedHashMap<>();
        for (int i = 0; i < itemSlot.size(); i++) {
            itemList.put(itemSlot.get(i), ourProductList.get(i));

        } return itemList;
    }





    }