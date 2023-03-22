package com.rednet.helloboot.pattern.strategy;

public class CreditCard {

    // 额度
    private int amount;
    // 卡号
    private String number;
    // 有效期至
    private String date;
    // 签名
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
