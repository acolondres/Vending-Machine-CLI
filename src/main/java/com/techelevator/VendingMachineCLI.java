package com.techelevator;

import com.techelevator.view.Menu;

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
        vendingMachine.makeItemList();
        Wallet wallet = new Wallet();
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
                if(purchaseOption.equals("1")) {
                    System.out.println("Machine only accepts $1, $2, and $5");
                    System.out.print("Insert money by typing number of bill amount --> ");
                    String billChoice = userInput.nextLine();
                    if (!(billChoice.equals("1")) && !(billChoice.equals("2")) && !(billChoice.equals("5"))) {
                    System.out.println("Sorry. Machine only accepts $1, $2, and $5");
                } else {
                    if ((billChoice.equals("1"))) {
                        wallet.balance++;
                    }

                    }
                }





                // do purchase
            }

			 /* if (itemList.get(inputItemSlot).getType().equals("Chip")) {
				System.out.println("Crunch Crunch"); */
        }
    }


    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
