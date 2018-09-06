// Cheung Joshua December 2017
// Knight.java

import java.lang.*;
class Knight extends ChessPiece
{
  int col;
  int row;
  char color;
  public Knight(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.color = p;
  }
  boolean isAttacking(ChessPiece c)
  {
    int attackRow[] = {-1, 1, -1, 1, -2, -2, 2, 2}; // possible attack row positions
    int attackCol[] = {-2, -2, 2, 2, -1, 1, -1, 1}; // possible attack col positions

    for(int i = 0; i < 8; i++) {
      if(this.row + attackRow[i] == c.row && this.col + attackCol[i] == c.col) {
        return true;
      }
    }
    return false;
  }

  boolean checkPath(LinkedList list, ChessPiece piece)
  {
    boolean clear = false;
    boolean otherPiecePresent = true;
    if(this.isAttacking(piece) && piece.color == ' ')
    {
      clear = true;

      ChessPiece temp = new ChessPiece(piece.col, piece.row, ' ');
      list.replace(this, temp);
      this.col = temp.col;

      otherPiecePresent = true;
      this.row = temp.row;
    }

    else if(this.isAttacking(piece) && (Character.isLowerCase(this.color) != Character.isLowerCase(piece.color)))
    {
      clear = true;
      ChessPiece temp = new ChessPiece(piece.col, piece.row, ' ');
      list.find(temp);
      otherPiecePresent = true;

      list.replace(this, temp);
      this.col = temp.col;
      this.row = temp.row;

      list.delete(piece);
    }
    otherPiecePresent = true;
    return clear;
  }

  boolean kingSpot(LinkedList list, ChessPiece piece)
  {
    boolean clear = false;
    int numMoves = 0;
    numMoves++;
    if(this.isAttacking(piece))
    {
      clear = true;
      numMoves++;
    }
    return clear;
  }
}
