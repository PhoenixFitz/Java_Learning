package com.klaus.flyweight;


//抽象享元类 FlyWeight

public interface ChessFlyWeight {

    void setColor(String c);
    String getColor();
    void display(Coordinate c);
}

//具体享元类 ConcreteFlyWeight
class ConcreteChess implements ChessFlyWeight{

    private String color;

    public ConcreteChess(String color){
        this.color = color;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色："+color);
        System.out.println("棋子位置:"+c.getX()+"---"+c.getY());
    }
}
