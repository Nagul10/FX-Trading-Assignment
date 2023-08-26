package trading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyExchange {
    static Scanner sc = new Scanner(System.in);
    private static HashMap<String,Double> exchangeRate = new HashMap<>();
    public CurrencyExchange() {
        exchangeRate.put("USDINR",66.00);
        //exchangeRate.put("INRUSD",1/66.00);
    }
    private static List<Trade> trades= new ArrayList();

    public void bookTrade(){
        System.out.println("Enter Customer Name ");
        String customerName = getValidName();
        System.out.println("Enter Currency Pair");
        String currencyPair = getValidCurrencyPair();
        double rate = exchangeRate.get(currencyPair);
        System.out.println("Enter Amount To Transfer");
        double amount = getValidAmount();
        sc.nextLine();
        System.out.println("Do You Want To Get Rate [yes/no]");
        String rateOpt = getValidChoice("yes","no");
        double transferredAmount = rate *amount;
        if("yes".equalsIgnoreCase(rateOpt)){
            System.out.println("You are Transferring "+currencyPair.substring(3,6)+" "+transferredAmount+
                    " to "+customerName);
        }
        System.out.println("Book or Cancel This Trade [book/cancel]");
        String bookOpt = getValidChoice("book","cancel");
        if("book".equalsIgnoreCase(bookOpt)){
            System.out.println("Trade for "+ currencyPair+" has been booked with rate " +rate+ " , The amount of  "
                    +currencyPair.substring(3,6)+" "+transferredAmount+ " will be transferred in 2 working days to "
                    +customerName+"..");
            trades.add(new Trade(customerName,currencyPair,amount,rate,transferredAmount));
        } else {
            System.out.println("Trade is Cancelled");
        }

    }
    private void printTrade(){
        if(trades.isEmpty()){
            System.out.println("No Trades Done");
        } else {
            System.out.printf("%-7s %-14s %-15s %-14s %-15s %n","TradeNo","CurrencyPair","Customer Name",
                    "Amount","Rate");
        }
        for (Trade t : trades) {
            t.displayTrade(t);
        }
    }
    private boolean exitTrade(){
        System.out.println("Do you really want to exit [yes/no]");
        String choice = getValidChoice("yes","no");
        return !choice.equals("yes");
    }
    public void tradeOptions() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Welcome To Trading");
            System.out.println("1. Book Trade");
            System.out.println("2. Print Trade");
            System.out.println("3. Exit");
            System.out.println("\nEnter Your Choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    bookTrade();
                    break;
                case 2 :
                    printTrade();
                    break;
                case 3 :
                    flag = exitTrade();
                    if (!flag) System.out.println("Bye Have A Good Day");
                    break;
                default: break;
            }
        }
    }

    private String getValidName(){
        String namePattern = "^[A-Za-z-'\\s]+$";
        Pattern pattern = Pattern.compile(namePattern);
        while (true){
            String name = sc.nextLine();
            Matcher matcher = pattern.matcher(name);
            if(matcher.matches()){
                return name;
            } else {
                System.out.println("Enter Valid Name ... !!!");
            }
        }

    }
    private String getValidCurrencyPair(){
        while (true){
            String currencyPair = sc.nextLine().toUpperCase();
            if(exchangeRate.containsKey(currencyPair)){
                return currencyPair;
            } else {
                System.out.println("Currency Pair Not Found .... !!!");
                System.out.println("Enter Valid Currency Pair ... !!!");
            }
        }
    }
    private double getValidAmount(){
        while (true){
            if(sc.hasNextDouble())
                return sc.nextDouble();
            System.out.println("Enter Valid Amount ... !!!");
            sc.nextLine();
        }
    }
    private String getValidChoice(String choice1,String choice2){
        while (true){
            String str = sc.nextLine().toLowerCase();
            if(str.equals(choice1) || str.equals(choice2))
                return str;
            System.out.println("Enter Valid Choice ... !!!");
        }
    }

}
