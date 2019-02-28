package com.klaus.mediator;

public class Development implements Department {

    private Mediator m ;

    public Development(Mediator m ){
        this.m = m;
        m.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心学习，自我提升");
    }

    @Override
    public void outAction() {
        System.out.println("想总经理汇报工作");
    }
}
