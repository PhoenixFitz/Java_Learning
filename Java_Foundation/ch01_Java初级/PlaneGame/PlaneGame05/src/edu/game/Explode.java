package edu.game;

/**
 * 爆炸类
 */
import java.awt.Graphics;
import java.awt.Image;

public class Explode {
	double x,y;
	//定义了Image[]来保存图片信息，并且使用了static代码块，也就是在类加载时就加载这些图片，
	//并且从属于类，不需要每次创建爆炸对象都加载图片，保证了运行的效率
	static Image[]	imgs=new Image[16];
	static {
		for(int i=0;i<16;i++) {
			imgs[i]=GameUtil.getImage("images/explode/e"+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	//通过计数器count来控制到底画哪个图片
	int count;
	
	public void draw(Graphics g) {
		if(count<=15) {
			g.drawImage(imgs[count], (int)x, (int)y,null);
			count++;
		}
	}
	
	public Explode(double x,double y) {
		this.x=x;
		this.y=y;
	}
}
