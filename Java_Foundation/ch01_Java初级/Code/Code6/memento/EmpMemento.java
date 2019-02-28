package com.klaus.memento;

/**
 * 备忘录类
 */
public class EmpMemento {

    private String ename;
    private int age;
    private double salary;





    public EmpMemento(Emp p){
        this.ename = p.getEname();
        this.age = p.getAge();
        this.salary = p.getSalary();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
