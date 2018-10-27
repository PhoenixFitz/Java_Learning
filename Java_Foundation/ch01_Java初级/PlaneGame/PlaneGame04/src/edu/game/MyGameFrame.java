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
 * �ɻ���Ϸ��������
 * @author wakl2
 *
 */
public class MyGameFrame extends Frame{
	
	//������ͼƬ��ɻ�ͼƬ����Ϊ��Ա����
	Image planeImg=GameUtil.getImage("images/plane.png");
	Image bgImg=GameUtil.getImage("images/bg.jpg");
	
	Plane plane=new Plane(planeImg,250,250);
//	Shell shell=new Shell();    	//һ���ڵ�
	Shell[]	shells=new Shell[50];
	@Override
		public void paint(Graphics g) {  //�Զ�������  g�൱��һֱ���ʣ�paint���������ǣ������������ڼ��ڲ�����
		super.paint(g);
		g.drawImage(bgImg,0, 0, null);
		plane.drawSelf(g); //���ɻ�
//		shell.darw(g);   //��һ���ڵ�
		for(int i=0;i<shells.length;i++) {   //�������е��ڵ�
			shells[i].darw(g);
			//�ɻ��������ڵ�����ľ��μ��
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			if(peng) {
				System.out.println("��ײ��");
				plane.live=false;
			}
		}
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
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT); //���ڴ�С
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
		
		//��ʼ����ʮ���ڵ�
		for(int i=0;i<shells.length;i++) {
			shells[i]=new Shell();
		}
	}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	
	
	//˫���弼�������˸����
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_HEIGHT,Constant.GAME_WIDTH);//������Ϸ���ڵĿ�Ⱥ͸߶�
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  


}
