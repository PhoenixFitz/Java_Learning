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
	
	int planeX=250,planeY=250;
	@Override
		public void paint(Graphics g) {  //�Զ�������  g�൱��һֱ���ʣ�paint���������ǣ������������ڼ��ڲ�����
		super.paint(g);
		/*Color c = g.getColor();  //����֮ǰ�Ļ�����ɫ
		Font f=g.getFont();		//����ԭ����
		g.setColor(Color.BLUE);	//���Ļ�����ɫ
		g.drawLine(100, 100, 300, 300);//������㣨100��100������300��300����ֱ��
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 300);	//����Բ
		g.fillRect(100, 100, 40, 40);	//�����ο�
		g.setColor(Color.red);
		g.setFont(new Font("����",Font.BOLD,50));
		g.drawString("klaus", 200, 200);  */
		
		g.drawImage(bgImg,0, 0, null);     
		g.drawImage(planeImg,planeX, planeY, null);
		planeX++;   
		
		/*g.setColor(c);	//��ԭ��ɫ	
		g.setFont(f);	//��ԭ����  */
		
	
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
