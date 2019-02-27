package com.klaus.chainOfResp;

/**
 *
 */
public class Client {

    public static void main(String[] args){
        Leader a = new Director("klaus");
        Leader b = new Manager("Snow");
        Leader c = new GeneralManager("Eya");
        Leader f = new ViceGeneralManager("Mount");

        //组织责任链对象的关系
        a.setNextLeader(b);
        b.setNextLeader(f);
        f.setNextLeader(c);

        //请假操作
        LeaveRequest req1 = new LeaveRequest("TOM", 10, "回家结婚");
        a.handleRequest(req1);

    }
}
