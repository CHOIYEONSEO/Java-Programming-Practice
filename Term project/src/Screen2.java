
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;

public class Screen2 extends JPanel implements MouseListener{
	BufferedImage background;
	
	Board board = new Board();
	
	static JPanel score = new JPanel();
	
	JButton start = new JButton("START!");
	static JButton restart = new JButton();
	
	static Timer timer;
	
	
	Screen2() {
		setLayout(null);
		score.setLayout(null);
		
		try {
			background = ImageIO.read(new File("image/배경.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		board.setBounds(345,12,750,750); //보드 위치와 크기 설정
		
	}
	
}
