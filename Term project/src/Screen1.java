import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen1 extends JPanel {
	BufferedImage background;
	
	JLabel title = new JLabel("Match3 game");
	
	JButton start = new JButton("START");
	
	Screen1() {
		setLayout(null);
		
		try {
			background = ImageIO.read(new File("image/배경.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		title.setBounds(385, 190, 800, 250);
		title.setForeground(new Color(255, 195, 35));
		title.setFont(new Font("HanS", Font.PLAIN, 150));
		
		start.setBounds(590, 550, 240, 80);
		title.setForeground(new Color(206, 124, 24));
		title.setFont(new Font("DX새날B", Font.PLAIN, 55));
		
		add(title);
		add(start);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, 1440, 800, null);
	}
}
