package trading;

public class Trade {
    private static int tradeCount = 1;
    private int tradeNo;
    private String customerName;
    private String currencyPair;
    private double amount;
    private double rate;
    private double transferredAmount;

    public Trade(String customerName, String currencyPair, double amount, double rate, double transferredAmount) {
        this.tradeNo = tradeCount++;
        this.customerName = customerName;
        this.currencyPair = currencyPair;
        this.amount = amount;
        this.rate = rate;
        this.transferredAmount = transferredAmount;
    }
    public void displayTrade(Trade trade){
        System.out.printf("%-7s %-14s %-15s %-14s %-15s %n", trade.tradeNo,trade.currencyPair,trade.customerName,
                trade.currencyPair.substring(3,6)+" "+trade.transferredAmount, trade.rate);
    }
}
