
//С��ˮƽ�ƶ�

	import java.awt.*;
	import javax.swing.*;
	public class BallGame extends JFrame{
		
		Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
		Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
		
		double x=100; //С��ĺ�����
		double y=100;//С���������
		boolean right=true; //����
		
		//�����ڵķ���
		public void paint(Graphics g) {
			System.out.println("���ڻ�һ��");
			g.drawImage(desk, 0, 0, null);
			g.drawImage(ball, (int)x, (int)y, null);
			
			if(right) {
			x=x+10;
			}
			else {
				x=x-10;
			}
			if(x>856-40-30) { //856�Ǵ��ڿ�ȣ�40�����ӱ߿��ȣ�30��С��ֱ��
				right=false;
			}
			if(x<40) {
				right=true;
			}
		}
		
		//���ڼ���
		void launchFrame() {
			setSize(856,500);
			setLocation(50,50);
			setVisible(true);
			
			//�ػ�����,ÿ��25��
			while(true) {
				repaint();
				try {
					Thread.sleep(40); //40ms
				}catch(Exception e) {
					e.printStackTrace();
					
				}
				
				
			}
		}
	
	
	//main�����ǳ���ִ�е����
	public static void main(String[] args) {
		System.out.println("starting!");
		BallGame game=new BallGame();
		game.launchFrame();
	}
}
