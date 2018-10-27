package edu.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 飞机游戏的主窗口
 * @author wakl2
 *
 */
public class MyGameFrame extends JFrame{
	
	//将背景图片与飞机图片定义为成员变量
	Image planeImg=GameUtil.getImage("images/plane.png");
	Image bgImg=GameUtil.getImage("images/bg.jpg");
	
	Plane plane=new Plane(planeImg,250,250);
	Plane plane2=new Plane(planeImg,300,300);
	Plane plane3=new Plane(planeImg,400,400);
	@Override
		public void paint(Graphics g) {  //自动被调用  g相当于一直画笔，paint方法作用是，画出整个窗口及内部内容
		super.paint(g);
		g.drawImage(bgImg,0, 0, null);
		plane.drawSelf(g);  //画飞机
		plane2.drawSelf(g);
		plane3.drawSelf(g);
		
		
	
		}
	
	// 帮助我们反复重画窗口
	class PaintThread extends Thread{     //增加线程PaintThread内部类
		@Override
		public void run() {
			while(true) {
				repaint();  //重画
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}     
				
			}
		}
	}
	

		
	//初始化窗口
	public void launchFrame() {
		this.setTitle("Niklaus program");
		this.setVisible(true);  //窗口默认是不可见的，这里设为可见
		this.setSize(500,500); //窗口大小
		this.setLocation(300, 300); //窗口位置
		
		//增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
		this.addWindowListener(new WindowAdapter() {   //匿名内部类
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}; 
			
		});
		
		new PaintThread().start(); //启动重画线程
	}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}
