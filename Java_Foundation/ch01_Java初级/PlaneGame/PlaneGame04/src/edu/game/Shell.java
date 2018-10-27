package edu.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 炮弹类
 * @author
 *
 */
public class Shell extends GameObject {
	
	double degree;
	public Shell() {   //构造方法
		x=200;
		y=200;
		width=10;
		height=10;
		speed=2;
		
		degree=Math.random()*Math.PI*2;
	}
	public void darw(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		
		g.fillOval((int)x, (int)y, width, height);
		
		//炮弹沿任意角度飞
		x +=speed*Math.cos(degree);
		y +=speed*Math.sin(degree);
		
		if(x<0||x>Constant.GAME_WIDTH-width) {
			degree =Math.PI-degree;
		}
		
		if(y<30||y>Constant.GAME_HEIGHT-height) {
			degree = -degree;
		}
		
		g.setColor(c);
		
	}
}
