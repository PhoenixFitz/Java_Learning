package com.klaus.io;


import java.io.*;
import java.util.Date;


/**
 * 对象流：
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有的对象都可以序列化，需要有Serializable 接口才可以
 *
 */
public class ObjectTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出---序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //操作数据类型+数据
        oos.writeUTF("别嗑瓜子了！ 烦死了！！！");
        oos.writeInt(18);
        oos.writeBoolean(false);
        oos.writeChar('k');
        oos.writeObject("离开请关门关窗");
        oos.writeObject(new Date());
        Employee emp = new Employee("马云",400);
        oos.writeObject(emp);
        oos.flush();

        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        //读取---反序列化
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
        String msg = ois.readUTF();
        int age = ois.readInt();
        boolean flag =ois.readBoolean();
        char ch = ois.readChar();
        System.out.println(flag);
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();

        if(str instanceof String){
            String strObj = (String) str;
            System.out.println(strObj);
        }
        if(date instanceof Date){
            Date dataObj = (Date) date;
            System.out.println(dataObj);
        }
        if(employee instanceof Employee){
            Employee empObj = (Employee) employee;
            System.out.println(empObj.getName()+"-->"+empObj.getSalary());
        }

    }
}

class Employee implements java.io.Serializable{    //需要实现java.io.Serializable接口
    private transient String name;   //transient 代表该数据不需要序列化
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}