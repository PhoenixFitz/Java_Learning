package com.klaus.strategy;

public class Client {
    public static void main(String[] args) {

        Strategy s1 = new OldCustomerManyStrategy();
        Strategy s2 = new OldCustomerFewStrategy();
        Context ctx = new Context(s1);
        ctx.printPrcie(998);
        ctx.setStrategy(s2);
        ctx.printPrcie(998);

    }
}
