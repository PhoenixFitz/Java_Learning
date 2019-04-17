package test;


import pojo.User;
import preparedStatementImpl.UserDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * preparedStatement对象完成增加删除修改查找
 * jdbc的封装
 * jdbc的MVC思想(员工管理系统)
 * ------------------------------------
 * 问题:
 * 		使用Statement对象进行数据库操作的时候可能会出现sql注入的风险.
 * 解决:
 * 		使用preparedStatement
 * 使用:
 * 		声明集合或者实体类对象(可选-查询)      	声明集合或者实体类对象(可选-查询)
 * 		加载驱动							        加载驱动
 * 		获取连接对象						        获取连接对象
 * 										        创建sql命令
 * 		获取SQL命令对象(statement)			     获取SQL命令对象(preparedStatement)
 * 		创建sql命令						        给占位符赋值（？）（占位符从左到右角标从1开始）
 * 		执行sql命令						        执行sql命令
 * 		遍历结果(可选-查询)					    遍历结果(可选-查询)
 * 		关闭资源							        关闭资源
 * 		返回结果							        返回结果
 * 特点:
 * 		防止sql注入
 * 		提升sql语句的执行效率(preparedStatement有预编译的过程)
 *
 *
 *
 * @author MyPC
 *
 */
public class TestPs {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //创建Scanner对象
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String uname=sc.next();
        System.out.println("请输入密码:");
        String upwd=sc.next();
        System.out.println(uname+":"+upwd);

        //创建数据库操作对象
        UserDaoImpl ud=new UserDaoImpl();
        User u=ud.getUserInfo(uname, upwd);



        //判断返回值
        if(u!=null){
            System.out.println("用户登录成功");
        }else{
            System.out.println("用户名或密码错误,请重新登录");
        }

    }
}

