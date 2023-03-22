package com.rednet.helloboot.pattern.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 信用卡支付
 */
public class CreditCardPay implements PayStrategy {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    @Override
    public void collectPaymentDetails() throws IOException {
        System.out.print("Enter your card number: ");
        String number = READER.readLine();
        System.out.print("Enter your card expiration date 'mm/yy': ");
        String date = READER.readLine();
        System.out.print("Enter the CVV code: ");
        String cvv = READER.readLine();
        card = new CreditCard(number, date, cvv);
    }

    @Override
    public boolean pay(int payAmount) {
        return card != null;
    }
}
