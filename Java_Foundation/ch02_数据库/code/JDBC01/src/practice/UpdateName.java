package practice;


import daolmpl.StudentDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * 需求:
 * 		更新用户昵称,使用控制台获取新的用户昵称,跟新成功后提示更新成功.
 * 分析:
 * 		java+jdbc
 * 使用:
 * 		创建java类
 * 		创建main方法
 * 		创建Scanner对象获取控制台数据
 * 		使用JDBC将数据更新到数据库中
 * 		提示更新成功
 * 问题:
 * 		不同的用户数据使用相同的数据库操作.
 * 解决:
 * 	  	将数据操作代码单独进行封装.
 * 优点:
 * 	   	避免代码的冗余
 * 封装:
 *
 */
public class UpdateName {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入新的昵称：");
        String newName = scanner.nextLine();
        StudentDaoImpl sd=new StudentDaoImpl();
        int i=sd.updateSname(newName);
        //判断
        if(i>0){
            System.out.println("更改成功");
        }else{
            System.out.println("更改失败");
        }
    }

}
