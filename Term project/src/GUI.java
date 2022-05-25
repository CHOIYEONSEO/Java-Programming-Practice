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
		Screen1 screen1 = new Screen1(); //�����ϱ� ������ ȭ��
		Screen2 screen2 = new Screen2(); //��������(����, Ÿ�̸�, ����) ȭ��
		Screen3 screen3 = new Screen3(); //������ ȭ��
		
		setTitle("Match3 game");
		setSize(1440, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		screen1.start.addActionListener(this);
		screen2.restart.addActionListener(this); // ���� ������ ���� �� �÷��̾��� Panel�� �����ϰ� ���� ���� ��Ȳ�� �°� �������� �ٽ� �׷��� �� �ֵ��� MouseListener �߰�
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
	Screen1 screen1 = new Screen1(); //�����ϱ� ������ ȭ��
	Screen2 screen2 = new Screen2(); //��������(����, Ÿ�̸�, ����) ȭ��
	Screen3 screen3 = new Screen3(); //������ ȭ��
	
	GUI() {
		setTitle("Match3 game");
		setSize(1440, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		screen1.start.addActionListener(this);
		screen2.restart.addActionListener(this); // ���� ������ ���� �� �÷��̾��� Panel�� �����ϰ� ���� ���� ��Ȳ�� �°� �������� �ٽ� �׷��� �� �ֵ��� MouseListener �߰�
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
		
		JLabel mainboard = new JLabel(""); //���� �̹���
		JLabel timer = new JLabel(""); //Ÿ�̸� �̹���
		JLabel score = new JLabel(""); //���� �̹���
		
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