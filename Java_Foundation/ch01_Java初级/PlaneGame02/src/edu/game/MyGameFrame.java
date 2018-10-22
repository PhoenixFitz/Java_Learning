package edu.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * �ɻ���Ϸ��������
 * @author wakl2
 *
 */
public class MyGameFrame extends JFrame{
	
	//������ͼƬ��ɻ�ͼƬ����Ϊ��Ա����
	Image planeImg=GameUtil.getImage("images/plane.png");
	Image bgImg=GameUtil.getImage("images/bg.jpg");
	
	Plane plane=new Plane(planeImg,250,250);
	Plane plane2=new Plane(planeImg,300,300);
	Plane plane3=new Plane(planeImg,400,400);
	@Override
		public void paint(Graphics g) {  //�Զ�������  g�൱��һֱ���ʣ�paint���������ǣ������������ڼ��ڲ�����
		super.paint(g);
		g.drawImage(bgImg,0, 0, null);
		plane.drawSelf(g);  //���ɻ�
		plane2.drawSelf(g);
		plane3.drawSelf(g);
		
		
	
		}
	
	// �������Ƿ����ػ�����
	class PaintThread extends Thread{     //�����߳�PaintThread�ڲ���
		@Override
		public void run() {
			while(true) {
				repaint();  //�ػ�
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}     
				
			}
		}
	}
	

		
	//��ʼ������
	public void launchFrame() {
		this.setTitle("Niklaus program");
		this.setVisible(true);  //����Ĭ���ǲ��ɼ��ģ�������Ϊ�ɼ�
		this.setSize(500,500); //���ڴ�С
		this.setLocation(300, 300); //����λ��
		
		//���ӹرմ��ڼ����������û�������Ͻǹر�ͼ�꣬���Թر���Ϸ����
		this.addWindowListener(new WindowAdapter() {   //�����ڲ���
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}; 
			
		});
		
		new PaintThread().start(); //�����ػ��߳�
	}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}
