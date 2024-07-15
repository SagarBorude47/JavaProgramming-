package aptitudeproject;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;

class MainPanel extends JPanel
{
	Image img;
	
	MainPanel(Image img)
	{
		try
		{
			this.img=img;
			repaint();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
	}
	public void setImage(Image img)
	{
		this.img=img;
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,0,0,this);
	}
}
