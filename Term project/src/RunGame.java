//package match3;

import java.util.Scanner;

public class RunGame { //swap������ ��ġ �ȵǸ� ���ڸ��� ���ư���, swap�ؼ� ��ġ�Ǵ°� ���������� ����ؼ� ����.

	public static void main(String[] args) {
		int count=0; //number of matches per move(swap)
		
		// Generate board
		Board game = new Board();
		
		while (true) { // make initial board with no matches
		game.CheckMatch();
		if (game.matchCount == 0) break;
		else game = new Board();
		}
		
		//while(time < 1 minute) {
		
		while (true) {
			count = 0;
			System.out.println("");
			game.printBoard();
			
			//get input
			int a_xpos, a_ypos, b_xpos, b_ypos;
			Tile a, b;
			
			Scanner scn1 = new Scanner(System.in);{		
				System.out.println("Input x, y for Tile a: (0~7)");  //���콺�� �޴°�. -> ���� �� �κ�.
				a_ypos = (scn1.nextInt());
			}
			
			Scanner scn2 = new Scanner(System.in);{
				a_xpos = (scn2.nextInt());
			}
			
			Scanner scn3 = new Scanner(System.in);{		
				System.out.println("Input x, y for Tile b: (0~7)");				
				b_ypos = (scn3.nextInt());
			}
			
			Scanner scn4 = new Scanner(System.in);{
				b_xpos = (scn4.nextInt());
			}
			
			game.matchCount = 0;
			a = game.board[a_xpos][a_ypos];
			b = game.board[b_xpos][b_ypos];
			
			game.swap(a, b);
			game.printBoard();
			game.matchCount = 0;
			for (int i = 0;i>0;i++) {
			game.CheckMatch();
			if (game.matchCount == 0) {
				if (count == 0) {
				game.swap(a, b);
				System.out.println("No matches, give new input"); //�ٵ� �����̽��� ���� �ȵǴ���.
				break;
				} else {
					System.out.println("matches found");
					game.fill();
					count++;
				}
				
			}
		}
			
	
	}

}
}

