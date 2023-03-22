package com.rednet.helloboot.pattern.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式--支付宝支付
 * 需要账号和密码正确
 */
public class AliPay implements PayStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String username;

    private String password;

    /**
     * 账号密码是否匹配
     */
    private boolean signedIn;

    /**
     * 初始化密码和账户
     */
    static {
        DATA_BASE.put("aman&da1985", "amanda");
        DATA_BASE.put("key.159236", "coolJohn66");
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    /**
     * 验证账号密码是否匹配
     *
     * @return
     */
    private boolean verify() {
        setSignedIn(username.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    @Override
    public void collectPaymentDetails() throws IOException {
        while (!signedIn) {
            System.out.print("Please enter your userName: ");
            username = reader.readLine();
            System.out.print("Please enter your password: ");
            password = reader.readLine();

            if (verify()) {
                System.out.println("Data verification has been successful.");
            } else {
                System.out.println("Wrong username or password.");
            }

        }
    }

    @Override
    public boolean pay(int payAmount) {
        if (signedIn) {
            System.out.println("Pay " + payAmount + " using PayPal.");
            return true;
        }
        return false;
    }
}
