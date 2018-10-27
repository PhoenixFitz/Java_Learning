package edu.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	
	@Override
		public void paint(Graphics g) {  //�Զ�������  g�൱��һֱ���ʣ�paint���������ǣ������������ڼ��ڲ�����
		super.paint(g);
		g.drawImage(bgImg,0, 0, null);
		plane.drawSelf(g); //���ɻ�
		
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
	
	//������̼Ӽ���     �ڲ��࣬���Է����ʹ���ⲿ�����ͨ����
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
		addKeyListener(new KeyMonitor());  //���Ӽ��̼��� 
	}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}
