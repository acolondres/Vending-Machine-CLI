package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class LogKeep {
    private String billUsed;
    private Double balance;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();
    private File logFile = new File("Log.txt");
    private String purchaseSlot;
    private Double emptyWallet = 0.00;

    public LogKeep() {
    }


    public void moneyInLog(String billUsed, Double balance) {
        try (PrintWriter logOutput = new PrintWriter(
                new FileOutputStream(
                        logFile, true
                )
        )) {
            logOutput.println(dateTimeFormatter.format(now) + " FEED MONEY " + " Currency in = $" + billUsed + " " + "Updated Balance = $" + balance);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    public void purchaseMadeLog(String snackName, String snackSlot, Double snackPrice, Double balance) {
        try (PrintWriter logOutput = new PrintWriter(
                new FileOutputStream(
                        logFile, true
                )
        )) {
            logOutput.println(dateTimeFormatter.format(now) + " " + snackName  + " " + snackSlot + " Item Price = $" + snackPrice + " Updated Balance = $" + balance );
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
    public void giveChangeLog(Double balance, Double emptyWallet) {
        try (PrintWriter logOutput = new PrintWriter(
                new FileOutputStream(
                        logFile, true
                )
        )) {
            logOutput.println(dateTimeFormatter.format(now) + " GIVE CHANGE: $" + balance + " $" + emptyWallet);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

    }
    }




