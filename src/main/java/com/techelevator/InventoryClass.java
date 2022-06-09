package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryClass {








    List<ProductClass> itemName = new ArrayList<>();
    try(Scanner fileReader = new Scanner(new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-8\\vendingmachine.csv")))

    {
        while (fileReader.hasNextLine()) {
            String currentLine = fileReader.nextLine();
            String[] productList = currentLine.split("\|");
            String slot = productList[0];
            String name = productList[1];
            String price = productList[2];
            String type = productList[3];
            itemName.add(new ProductClass(slot, name, price, type));
        }

    } catch(FileNotFoundException ex) {
        System.out.println("Item list not available");
    }
}


/*while (fileReader.hasNextLine()) {
        String currentLine = fileReader.nextLine();
        String[] productList = currentLine.split("\|");
        String slot = productList[0];
        String name = productList[1];
        String price = productList[2];
        String type = productList[3];
        itemName.add(new ProductClass(slot, name, price, type));
