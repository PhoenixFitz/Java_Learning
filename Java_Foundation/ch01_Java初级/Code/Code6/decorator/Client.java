package com.klaus.decorator;

public class Client {

    public static void main(String[] args){
        Car car = new Car();
        car.move();
        System.out.println("----增加新的飞行功能-----");

        FlyCar flycar = new FlyCar(car);
        flycar.move();

        System.out.println("---增加新的功能，水里游----");
        WaterCar watercar = new WaterCar(car);
        watercar.move();

        System.out.println("---增加两个新功能,自动驾驶,水里游---");
        WaterCar watercar2 = new WaterCar(new AICar(car));
        watercar2.move();

        //		Reader r = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/a.txt"))));

    }
}
