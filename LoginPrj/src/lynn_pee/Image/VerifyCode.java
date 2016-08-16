package lynn_pee.Image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCode {
	 private int width = 70;
	 private int height = 35;
	 private Random rand = new Random();
	 private String[] fontNames= {"宋体","华文楷体","黑体","微软雅黑","楷体_GB2312"};
	 private String codes = "23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
	 String myText;
	 private BufferedImage createImage()
	 {
		 BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		 return img;
	 }
	 private Color randomColor()
	 {
		 int r = rand.nextInt(160);
		 int g = rand.nextInt(160);
		 int b = rand.nextInt(160);
		 return new Color(r,g,b);
	 }
	 
	 private Font randomFont()
	 {
		 int fontIdx = rand.nextInt(fontNames.length);
		 String fontName = fontNames[fontIdx];
		 int style = rand.nextInt(4);//BOLD|ITALIC
		 int size = rand.nextInt(5) + 24;
		 return new Font(fontName, style, size);
	 }
	 private void drawLine(BufferedImage image)
	 {
		 int num = 3;
		 Graphics2D g2 = (Graphics2D)image.getGraphics();
		 
		 for (int i = 0; i < 3; i++)
		 {
			 int x1 = rand.nextInt(width);
			 int y1 = rand.nextInt(height);
			 
			 int x2 = rand.nextInt(width);
			 int y2 = rand.nextInt(height);
			 g2.setStroke(new BasicStroke(1.5F));
			 g2.setColor(Color.BLUE);
			 g2.drawLine(x1, y1, x2, y2);
		 }
	 }
	 private char randomChar()
	 {
		 int index = rand.nextInt(codes.length());
		 return codes.charAt(index);
	 }
	 
	 public BufferedImage getImage()
	 {
		 BufferedImage img = createImage();
		 Graphics2D g2 = (Graphics2D) img.getGraphics();
		 StringBuilder sb = new StringBuilder();
		 
		 for (int i = 0; i < 4; i++)
		 {
			 String s = randomChar()+" ";
			 sb.append(s);
			 float x = i*1.0F*width/4;
			 g2.setFont(randomFont());
			 g2.setColor(randomColor());
			 g2.drawString(s, x, height -5);
		 }
		 this.myText = sb.toString();
		 drawLine(img);
		 return img;
	 }
	 
	 public static void output (BufferedImage img, OutputStream out) throws IOException
	 {
		 ImageIO.write(img, "JPEG", out);
	 }
}
