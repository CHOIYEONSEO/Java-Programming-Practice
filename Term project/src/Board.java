//package match3;
import java.util.Scanner;
import java.io.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel implements Game, MouseListener, MouseMotionListener{
	
	static Tile[][] board;
	static int score;
	int matchCount, tileCount;
	
	
	//make new board
	public Board(){
		
		score = 0;
		matchCount = 0;
		tileCount = 0;
		board = new Tile[12][12]; 
		//8-by-8 board; rows and columns bigger than 8 are empty tiles 
		//to prevent ArrayIndexOutOfBoundsException
		
		setSize(750, 750);
		setBackground(new Color(255, 207, 165));
		
		for (int i=0; i<10; i++) {
			for (int j=0;j<10;j++) {
				board[i][j] = new Tile();
				board[i][j].type = 5; //5가 빈거고
			}
		}
		
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				board[i][j] = new Tile(); //0~4까지가 블록.
			}
		}
		
		
	}
	
	
	public void printBoard() {
				
		for (int i = 0; i < 8; i++) {
			for (int j = 0;j<8;j++) {
				System.out.print(board[i][j].type);
			}
			System.out.println();
		}
	
	}
	/*
	public void getInput() {
		int a_xpos, a_ypos, b_xpos, b_ypos;
		
		Scanner scn1 = new Scanner(System.in);{		
			System.out.println("Input x, y for Tile a: (0~7)");
			a_xpos = (scn1.nextInt());
		}
		
		Scanner scn2 = new Scanner(System.in);{
			a_ypos = (scn2.nextInt());
		}
		
		Scanner scn3 = new Scanner(System.in);{		
			System.out.println("Input x, y for Tile b: (0~7)");				
			a_xpos = (scn3.nextInt());
		}
		
		Scanner scn4 = new Scanner(System.in);{
			a_ypos = (scn4.nextInt());
		}
	}
	*/
	
	public void swap(Tile a, Tile b) {
		Tile temp = new Tile();
		temp.type = a.type;
		a.type = b.type;
		b.type = temp.type;
	}
	
	public void fill() {
		int curType;
		int i, j;

		for (i=7;i>0;i--) {	
			for (j=0;j<8;j++) {
			
				curType = board[i][j].type;
				if (curType == 5) {
					board[i][j].type = board[i-1][j].type;
					board[i-1][j].type = 5;
				}
			}
		}
		
		for (i = 7; i>=0; i--) {
			for (j = 0; j<8; j++) {
				curType = board[i][j].type;
				
				if (curType == 5) {
					board[i][j] = new Tile();
				}
				
			}
		}
	}
	
	public boolean isFinish() { //타이머 1분이 되면 끝나도록.
		return false;
	}
	
	public void CheckMatch(){
		
		int curType;
		matchCount = 0;
		tileCount = 0;
		
		//check for horizontal matches
		
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j<8; j++) {
				curType = board[i][j].type;
				
				if (curType != 5) {
				
				if (curType == board[i][j+1].type && curType == board[i][j+2].type) {
					if (curType == board[i][j+3].type) {
						if (curType == board[i][j+4].type) {
							//5match
							matchCount++;
							tileCount += 5;
							board[i][j].type = 5;
							board[i][j+1].type = 5;
							board[i][j+2].type = 5;
							board[i][j+3].type = 5;
							board[i][j+4].type = 5;
						} else {
							//4match
							matchCount++;
							tileCount += 4;
							board[i][j].type = 5;
							board[i][j+1].type = 5;
							board[i][j+2].type = 5;
							board[i][j+3].type = 5;
						}
					} else {
						//3 match 
						matchCount++;
						tileCount += 3;
						board[i][j].type = 5;
						board[i][j+1].type = 5;
						board[i][j+2].type = 5;
						
					}
				}
			}
		}
		}
		
		
		
		//check for vertical matches
		
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j<8; j++) {
				curType = board[i][j].type;
				
				if (curType != 5) {
				if (curType == board[i+1][j].type && curType == board[i+2][j].type) {
					if (curType == board[i+3][j].type) {
						if (curType == board[i+4][j].type) {
							//5match
							matchCount++;
							tileCount+=5;
							board[i][j].type = 5;
							board[i+1][j].type = 5;
							board[i+2][j].type = 5;
							board[i+3][j].type = 5;
							board[i+4][j].type = 5;
							
						} else {
							//4match 
							matchCount++;
							tileCount+=4;
							board[i][j].type = 5;
							board[i+1][j].type = 5;
							board[i+2][j].type = 5;
							board[i+3][j].type = 5;
						}
					} else {
						//3match 
						matchCount++;
						tileCount+=3;
						board[i][j].type = 5;
						board[i+1][j].type = 5;
						board[i+2][j].type = 5;
						board[i+3][j].type = 5;
					}
				}
			}
			}
		}
			
		score = score + 100 * tileCount * matchCount;
		
		System.out.println(matchCount + " matches, " + tileCount + " tiles, score: " + score);

}
}
