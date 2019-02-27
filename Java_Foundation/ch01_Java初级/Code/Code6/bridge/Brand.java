package com.klaus.bridge;

/**
 * 电脑品牌维度
 */
public interface Brand {

    void sale();
}

class Lenovo implements Brand{
    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}


class Dell implements Brand{
    @Override
    public void sale() {
        System.out.println("销售DELL电脑");
    }
}

class Shenzhou implements Brand{

    @Override
    public void sale() {
        System.out.println("销售神州电脑");
    }
}
