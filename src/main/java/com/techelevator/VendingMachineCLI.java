package com.techelevator;

import com.techelevator.view.Menu;

import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};

    private Menu menu;


    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }


    public void run() {
        InventoryClass vendingMachine = new InventoryClass();
        LogKeep logger = new LogKeep();
        LogKeep moneyInLog = new LogKeep();
        vendingMachine.makeItemList();
        Wallet wallet = new Wallet();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern ("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String today = dtf.format(now);
        //String filePath = "C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-8\\log.txt";
        File log = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-8\\log.txt");
        try (PrintWriter logWriter = new PrintWriter(log)) {
            new FileOutputStream(log, true);
            if (!log.exists()){
                log.createNewFile();
            }
            while (true) {
                String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

                if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                    // display vending machine items
                    for (Map.Entry<String, ProductClass> product : vendingMachine.itemList.entrySet()) {
                        System.out.print("(" + product.getKey() + ") ");
                        System.out.print(product.getValue().getName() + " --> ");
                        if (product.getValue().getItemAmount() == 0) {
                            System.out.println("SOLD OUT");
                        } else {
                            System.out.print(product.getValue().getItemAmount() + " remaining --> ");
                            System.out.println(product.getValue().getPrice());

                        }
                    }
                } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");
                    System.out.print("(Select an option by entering 1, 2, or 3) --> ");
                    Scanner userInput = new Scanner(System.in);
                    String purchaseOption = userInput.nextLine();
                    if (purchaseOption.equals("1")) {
                        System.out.println("Wallet Balance: " + wallet.balance);
                        System.out.println("Machine only accepts $1, $2, and $5");
                        System.out.print("Insert money by typing number of bill amount --> ");
                        String billChoice = userInput.nextLine();
                        if (!billChoice.equals("1") && !billChoice.equals("2") && !billChoice.equals("5")) {
                            System.out.println("Sorry. Machine only accepts $1, $2, and $5");
                        } else {
                            if ((billChoice.equals("1"))) {
                                wallet.balance++;
                                logger.moneyInLog(billChoice, wallet.getBalance());


                                System.out.println("Wallet Balance: " + wallet.balance);
                            } else if (billChoice.equals("2")) {
                                wallet.balance += 2.00;
                                logger.moneyInLog(billChoice, wallet.getBalance());
                                System.out.println("Wallet Balance: " + wallet.balance);
                            } else if (billChoice.equals("5")) {
                                wallet.balance += 5.00;
                                logger.moneyInLog(billChoice, wallet.getBalance());
                                System.out.println("Wallet Balance: " + wallet.balance);
                            }
                        }


                        // do purchase
                    } else if (purchaseOption.equals("2")) {
                        for (Map.Entry<String, ProductClass> product : vendingMachine.itemList.entrySet()) {
                            System.out.print("(" + product.getKey() + ") ");
                            System.out.print(product.getValue().getName() + " --> ");
                            if (product.getValue().getItemAmount() == 0) {
                                System.out.println("SOLD OUT");
                            } else {
                                System.out.print(product.getValue().getItemAmount() + " remaining --> ");
                                System.out.println(product.getValue().getPrice());

                            }


                        }

                        System.out.print("Please enter single item code: ");
                        String inputItemCode = userInput.nextLine();
                        if (!vendingMachine.itemList.containsKey(inputItemCode)) {
                            System.out.println("Item code does not exist");
                        } else if (vendingMachine.itemList.get(inputItemCode).getItemAmount() == 0) {
                            System.out.println("SOLD OUT");
                        } else {
                            if (vendingMachine.itemList.get(inputItemCode).getPrice() > wallet.balance) {
                                System.out.println("Insufficient Funds");
                            } else {

                                System.out.println("Item Purchased: " + vendingMachine.itemList.get(inputItemCode).getName() + " " + vendingMachine.itemList.get(inputItemCode).getPrice());
                                wallet.balance -= vendingMachine.itemList.get(inputItemCode).getPrice();
                                vendingMachine.itemList.get(inputItemCode).setItemAmount(vendingMachine.itemList.get(inputItemCode).getItemAmount() - 1);
                                System.out.println("Balance Remaining: " + wallet.balance);
                                logger.purchaseMadeLog(vendingMachine.itemList.get(inputItemCode).getName() , inputItemCode, vendingMachine.itemList.get(inputItemCode).getPrice(), wallet.getBalance());
                                if (vendingMachine.itemList.get(inputItemCode).getType().equals("Chip")) {
                                    System.out.println("Crunch, Crunch, Crunch!");
                                } else if (vendingMachine.itemList.get(inputItemCode).getType().equals("Candy")) {
                                    System.out.println("Munch, Munch, Mmm-Good!");
                                } else if (vendingMachine.itemList.get(inputItemCode).getType().equals("Drink")) {
                                    System.out.println("Cheers, Glug, Glug!");
                                } else if (vendingMachine.itemList.get(inputItemCode).getType().equals("Gum")) {
                                    System.out.println("Chew, Chew, Pop!");
                                }

                            }

                        }
                    } else if (purchaseOption.equals("3")) {
                        logger.giveChangeLog(wallet.getBalance(), 0.00);
                        int quarterCounter = 0;
                        int dimeCounter = 0;
                        int nickleCounter = 0;
                        while (wallet.balance >= 0) {
                            if (wallet.balance > wallet.quarter) {
                                wallet.balance -= wallet.quarter;
                                quarterCounter++;
                            } else if (wallet.balance > wallet.dime) {
                                wallet.balance -= wallet.dime;
                                dimeCounter++;
                            } else {
                                wallet.balance -= wallet.nickle;
                                nickleCounter++;
                            }



                        }
                        System.out.println("Your change is:");
                        System.out.println(quarterCounter + " Quarter(s)");
                        System.out.println(dimeCounter + " Dimes(s)");
                        System.out.println(nickleCounter + " Nickle(s)");
                        System.out.println("Thanks for purchasing from Umbrella Corp.!");
                    }

                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Log not found");
        } catch (IOException ex) {
            System.out.println("Could not write to log.");
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}