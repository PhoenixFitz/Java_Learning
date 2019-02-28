package com.klaus.chainOfResp;

/**
 *公司里面，请假条的审批过程：
 * 如果请假天数小于3天，主任审批
 * 如果请假天数大于等于3天，小于10天，经理审批
 * 如果大于等于10天，小于30天，总经理审批
 * 如果大于等于30天，提示拒绝
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
