package com.klaus.command;

/**
 *  某个市场人员接到单后的报价策略(CRM系统中常见问题)。报价策略
 * 很复杂，可以简单作如下分类：
 * • 普通客户小批量报价
 * • 普通客户大批量报价
 * • 老客户小批量报价
 * • 老客户大批量报价
 */
public class Client {

    public static void main(String[] args){
        Command c = new ConcreteCommand(new Receiver());

        Invoke i = new Invoke(c);

        i.call();
    }
}
