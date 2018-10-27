package edu.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 飞机游戏的主窗口
 * @author wakl2
 *
 */
public class MyGameFrame extends Frame{
	
	//将背景图片与飞机图片定义为成员变量
	Image planeImg=GameUtil.getImage("images/plane.png");
	Image bgImg=GameUtil.getImage("images/bg.jpg");
	
	Plane plane=new Plane(planeImg,250,250);
//	Shell shell=new Shell();    	//一个炮弹
	Shell[]	shells=new Shell[50];
	@Override
		public void paint(Graphics g) {  //自动被调用  g相当于一直画笔，paint方法作用是，画出整个窗口及内部内容
		super.paint(g);
		g.drawImage(bgImg,0, 0, null);
		plane.drawSelf(g); //画飞机
//		shell.darw(g);   //画一个炮弹
		for(int i=0;i<shells.length;i++) {   //画出所有的炮弹
			shells[i].darw(g);
			//飞机和所有炮弹对象的矩形检测
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				System.out.println("相撞了");
				plane.live=false;
			}
		}
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
	
	//定义键盘加监听     内部类，可以方便的使用外部类的普通属性
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
	
		
	//初始化窗口
	public void launchFrame() {
		this.setTitle("Niklaus program");
		this.setVisible(true);  //窗口默认是不可见的，这里设为可见
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT); //窗口大小
		this.setLocation(300, 300); //窗口位置
		
		//增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
		this.addWindowListener(new WindowAdapter() {   //匿名内部类
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}; 
			
		});
		
		new PaintThread().start(); //启动重画线程
		addKeyListener(new KeyMonitor());  //增加键盘监听 
		
		//初始化五十个炮弹
		for(int i=0;i<shells.length;i++) {
			shells[i]=new Shell();
		}
	}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	
	
	//双缓冲技术解决闪烁问题
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_HEIGHT,Constant.GAME_WIDTH);//这是游戏窗口的宽度和高度
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  


}
