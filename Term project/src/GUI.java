import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}

class MyFrame extends JFrame implements ActionListener {
	MyFrame() {
		Screen1 screen1 = new Screen1(); //시작하기 누르는 화면
		Screen2 screen2 = new Screen2(); //게임진행(보드, 타이머, 점수) 화면
		Screen3 screen3 = new Screen3(); //점수판 화면
		
		setTitle("Match3 game");
		setSize(1440, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		screen1.start.addActionListener(this);
		screen2.restart.addActionListener(this); // 게임 진행을 위한 각 플레이어의 Panel을 설정하고 게임 진행 상황에 맞게 게임판을 다시 그려줄 수 있도록 MouseListener 추가
		screen3.start.addActionListener(this);
		
		//Container c = getContentPane();
		
		add(screen1);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if (button == screen1.start) {
			settingScreen2();
			
			remove(screen1);
			add(screen2);
			revalidate();
			repaint();
		}
		
		if (button == screen2.restart) {
			remove(screen2);
			initScreen2();
			add(screen2);
			revalidate();
			repaint();
		}
		
		if (button == screen3.start) {
			remove(screen3);
			//add(screen3);
			revalidate();
			repaint();
		}
	}
	
	void settingScreen2() {
		screen2.
	}
}

/*
public class GUI extends JFrame implements ActionListener{
	Screen1 screen1 = new Screen1(); //시작하기 누르는 화면
	Screen2 screen2 = new Screen2(); //게임진행(보드, 타이머, 점수) 화면
	Screen3 screen3 = new Screen3(); //점수판 화면
	
	GUI() {
		setTitle("Match3 game");
		setSize(1440, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		screen1.start.addActionListener(this);
		screen2.restart.addActionListener(this); // 게임 진행을 위한 각 플레이어의 Panel을 설정하고 게임 진행 상황에 맞게 게임판을 다시 그려줄 수 있도록 MouseListener 추가
		screen3.start.addActionListener(this);
		
		add(screen1);
		
		setVisible(true);
	}
	
	
}
*/

class MyFrame extends JFrame {
	String id = "test";
	String password = "12345678"; // to compare
	JTextField textField1;
	JPasswordField textField2;
	
	MyFrame() {
		

		setResizable(false);
		
		setLayout(new GridLayout(3,1));
		
		// implement your code
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JLabel mainboard = new JLabel(""); //보드 이미지
		JLabel timer = new JLabel(""); //타이머 이미지
		JLabel score = new JLabel(""); //점수 이미지
		
		Container c = getContentPane();
		
		panel1.add(mainboard);
		
		panel2.add(timer);
		panel2.add(score);
		
		setLayout(new BorderLayout());
		
		c.add(panel1, BorderLayout.EAST);
		c.add(panel2, BorderLayout.WEST);
		
		pack();
		
		setVisible(true);
	}
}