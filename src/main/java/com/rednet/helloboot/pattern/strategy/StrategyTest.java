package com.rednet.helloboot.pattern.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StrategyTest {

    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }


    public static void main(String[] args) throws IOException {
        while(!order.isClosed()) {
            int cost;
            String continueChoice;

            /**
             * 选择商品
             */
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine().trim());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            }while(continueChoice.equalsIgnoreCase("Y"));

            /**
             * 选择支付方式
             */
            if(strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - AliPay" + "\n" +
                        "2 - Use Credit Card Pay");
                String paymentMethod = reader.readLine();
                if (paymentMethod.equals("1")) {
                    strategy = new AliPay();
                } else {
                    strategy = new CreditCardPay();
                }
            }
            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");

            String process = reader.readLine();
            if("P".equalsIgnoreCase(process)) {
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("Fail! Please, check your data.");
                }
                order.setClosed();
            }

        }
    }



}
