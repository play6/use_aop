package com.rednet.helloboot.pattern.strategy;

import java.io.IOException;

public interface PayStrategy {

    void collectPaymentDetails() throws IOException;

    boolean pay(int payAmount);

}
