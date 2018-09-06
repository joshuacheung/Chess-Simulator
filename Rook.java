// Cheung Joshua December 2017
// Rook.java

import java.lang.*;
class Rook extends ChessPiece
{
  int col;
  int row;
  char s;
  public Rook(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  boolean isAttacking(ChessPiece piece)
  {
    if((this.col == piece.col ||
    this.row == piece.row))
    return true;
    else
    return false;
  }
  boolean kingSpot(LinkedList list, ChessPiece king)
  {
    boolean clear = false;
    int colTemp = 0;
    boolean nextSpotOpen = true;
    int numMoves = 0;
    int rowTemp = 0;
    if(this.isAttacking(king))
    {
      colTemp = this.col;
      rowTemp = this.row;
      numMoves++;
      if(king.col > colTemp && king.row == rowTemp)
      {
        while(king.col != colTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp + 1, rowTemp, ' ');
          tempPiece = list.find(tempPiece);
          nextSpotOpen = true;
          numMoves++;
          if(tempPiece.color != ' ' && king.col == tempPiece.col)
          {
            clear = true;
            break;
          }
          else if(tempPiece.color != ' ' && king.col != tempPiece.col)
          {
            break;
          }
          else
          {
            colTemp++;
          }
        }
      }
      else if(king.col < colTemp && king.row == rowTemp)
      {
        while(king.col != colTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp - 1, rowTemp, ' ');
          tempPiece = list.find(tempPiece);
          nextSpotOpen = true;
          numMoves++;
          if(tempPiece.color != ' ' && king.col == tempPiece.col)
          {
            clear = true;
            break;
          }
          else if(tempPiece.color != ' ' && king.col != tempPiece.col)
          {
            break;
          }
          else
          {
            colTemp--;
          }
        }
      }
      else if(king.col == colTemp && king.row > rowTemp)
      {
        while(king.row != rowTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp, rowTemp + 1, ' ');
          nextSpotOpen = true;
          tempPiece = list.find(tempPiece);
          numMoves++;
          if(tempPiece.color != ' ' && king.row == tempPiece.row)
          {
            clear = true;
            break;
          }
          else if(tempPiece.color != ' ' && king.row != tempPiece.row)
          {
            break;
          }
          else
          {
            rowTemp++;
          }
        }
      }
      else if(king.col == colTemp && king.row < rowTemp)
      {
        while(king.row != rowTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp, rowTemp - 1, ' ');
          nextSpotOpen = true;
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && king.row == tempPiece.row)
          {
            clear = true;
            break;
          }
          else if(tempPiece.color != ' ' && king.row != tempPiece.row)
          {
            break;
          }
          else
          {
            rowTemp--;
          }
        }
      }
    }
    else
    {
      clear = false;
    }
    return clear;
  }

  boolean checkPath(LinkedList list, ChessPiece piece)
  {
    boolean clear = false;
    boolean nextSpotOpen = true;
    int numMoves = 0;
    if(this.isAttacking(piece))
    {
      if(piece.col > this.col && piece.row == this.row)
      {
        while(piece.col != this.col)
        {
          ChessPiece temp = new ChessPiece(this.col + 1, this.row, ' ');
          temp = list.find(temp);
          nextSpotOpen = true;
          if(temp.color != ' ')
          {
            if(this.col + 1 == piece.col)
            {
              if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
              {
                this.col++;
                ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
                temp2 = list.find(temp2);
                nextSpotOpen = true;
                numMoves++;
                list.replace(this, temp2);
                list.delete(piece);
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
            }
          }
          else
          {
            this.col++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            nextSpotOpen = true;
            list.replace(this, temp3);
          }
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          clear = true;
        }
      }
      else if(piece.col < this.col && piece.row == this.row)
      {
        while(piece.col != this.col)
        {
          ChessPiece temp = new ChessPiece(this.col - 1, this.row, ' ');
          temp = list.find(temp);
          nextSpotOpen = true;
          numMoves++;
          if(temp.color != ' ')
          {
            if(this.col - 1 == piece.col)
            {
              if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
              {
                this.col--;
                ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
                temp2 = list.find(temp2);
                numMoves++;
                list.replace(this, temp2);
                nextSpotOpen = true;
                list.delete(piece);
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
            }
          }
          else
          {
            this.col--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            nextSpotOpen = true;
            list.replace(this, temp3);
          }
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          clear = true;
        }
      }
      else if(piece.col == this.col && piece.row > this.row)
      {
        while(piece.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col, this.row + 1, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.row + 1 == piece.row)
            {
              if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
              {
                this.row++;
                ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
                temp2 = list.find(temp2);
                nextSpotOpen = true;
                numMoves++;
                list.replace(this, temp2);
                list.delete(piece);
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
            }
          }
          else
          {
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            nextSpotOpen = true;
            list.replace(this, temp3);
          }
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          clear = true;
        }
      }
      else if(piece.col == this.col && piece.row < this.row)
      {
        while(piece.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col, this.row - 1, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.row - 1 == piece.row)
            {
              if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
              {
                this.row--;
                ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
                temp2 = list.find(temp2);
                numMoves++;
                nextSpotOpen = true;
                list.replace(this, temp2);
                list.delete(piece);
                clear = true;
              }
              else
              {
                break;
              }
            }
            else
            {
              break;
            }
          }
          else
          {
            this.row--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            nextSpotOpen = true;
            list.replace(this, temp3);
          }
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          clear = true;
        }
      }
    }
    return clear;
  }
}
