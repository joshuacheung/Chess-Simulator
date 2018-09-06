// Cheung Joshua November 2017
// ChessPiece.java

import java.lang.*;
class ChessPiece
{
	int col;
	int row;
	char color;

	public ChessPiece(int c, int r, char p){
		this.col = c;
		this.row = r;
		this.color = p;
	}

  public int getRow(){
    return this.row;
  }

	boolean kingSpot(LinkedList list, ChessPiece piece){
		return false;
	}

  public int getCol(){
    return this.col;
  }

	boolean checkPath(LinkedList list, ChessPiece piece){
		return false;
	}

  public char getColor(){
    return this.color;
  }

  boolean isAttacking(ChessPiece piece){
		return false;
	}
}
