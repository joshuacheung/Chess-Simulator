// Cheung Joshua December 2017
// Bishop.java

import java.lang.*;
class Bishop extends ChessPiece
{
  int col;
  int row;
  char color;
  Bishop(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.color = p;
  }
  
  boolean isAttacking(ChessPiece piece)
  {
    if(Math.abs(this.col - piece.col) == Math.abs(this.row - piece.row)){
      return true;
    }else{
      return false;
    }
  }

  boolean kingSpot(LinkedList list, ChessPiece king)
  {
    boolean empty = false;
    boolean kingPlaced = false;
    boolean piecePresent = false;
    int numSteps = 0;
    int piecesLeft = 0;
    int rowPiece = 0;
    int colPiece = 0;

    if(this.isAttacking(king))
    {
      colPiece = this.col;
      rowPiece = this.row;
      if(king.col > colPiece && king.row > rowPiece)
      {
        kingPlaced = true;
        piecesLeft = 0;
        while(king.col != colPiece && king.row != rowPiece)
        {
          ChessPiece tempPiece = new ChessPiece(colPiece + 1, rowPiece + 1, ' ');
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && tempPiece.col == king.col && tempPiece.row == king.row)
          {
            kingPlaced = true;
            empty = true;
            break;
          }
          else if(tempPiece.color != ' ' && tempPiece.col != king.col && tempPiece.row != king.row)
          {
            break;
          }
          else
          {
            kingPlaced = true;
            colPiece++;
            piecesLeft = 0;
            rowPiece++;
          }
        }
      }
      else if(king.col < colPiece && king.row > rowPiece)
      {

        while(king.col != colPiece && king.row != rowPiece)
        {
          ChessPiece tempPiece = new ChessPiece(colPiece - 1, rowPiece + 1, ' ');
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && tempPiece.col == king.col && tempPiece.row == king.row)
          {
            piecesLeft = 0;
            empty = true;
            break;
          }
          else if(tempPiece.color != ' ' && tempPiece.col != king.col && tempPiece.row != king.row)
          {
            break;
          }
          else
          {
            kingPlaced = true;
            colPiece--;
            rowPiece++;
          }
        }
      }
      else if(king.col > colPiece && king.row < rowPiece)
      {
        while(king.col != colPiece && king.row != rowPiece)
        {
          ChessPiece tempPiece = new ChessPiece(colPiece + 1, rowPiece - 1, ' ');
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && tempPiece.col == king.col && tempPiece.row == king.row)
          {
            empty = true;
            break;
          }
          else if(tempPiece.color != ' ' && tempPiece.col != king.col && tempPiece.row != king.row)
          {
            break;
          }
          else
          {
            piecesLeft = 0;
            colPiece++;
            kingPlaced = true;
            rowPiece--;
          }
        }
      }
      else if(king.col < colPiece && king.row < rowPiece)
      {

        while(king.col != colPiece && king.row != rowPiece)
        {

          ChessPiece tempPiece = new ChessPiece(colPiece - 1, rowPiece - 1, ' ');
          tempPiece = list.find(tempPiece);
          piecesLeft = 0;
          if(tempPiece.color != ' ' && tempPiece.col == king.col && tempPiece.row == king.row)
          {
            empty = true;
            break;
          }
          else if(tempPiece.color != ' ' && tempPiece.col != king.col && tempPiece.row != king.row)
          {
            break;
          }
          else
          {
            piecesLeft = 0;
            colPiece--;
            kingPlaced = true;
            rowPiece--;
          }
        }
      }
    }
    else
    {
      empty = false;
    }
    return empty;
  }
  boolean checkPath(LinkedList list, ChessPiece n)
  {
    int piecesLeft = 0;
    boolean kingPlaced = false;
    boolean empty = false;
    if(this.isAttacking(n))
    {
      if(n.col > this.col && n.row > this.row)
      {
        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col + 1, this.row + 1, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.col + 1 == n.col && this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                piecesLeft = 0;
                this.col += 1;
                this.row += 1;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                list.delete(n);
                empty = true;
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
            piecesLeft = 0;
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            list.replace(this, temp3);
          }
        }
        if(this.col == n.col && this.row == n.row)
        {
          empty = true;
          kingPlaced = true;
        }
      }
      else if(n.col < this.col && n.row > this.row)
      {
        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col - 1, this.row + 1, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.col - 1 == n.col && this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col--;
                this.row++;
                piecesLeft = 0;
                ChessPiece temp2 = new ChessPiece(this.col, this.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                list.delete(n);
                empty = true;
                kingPlaced = true;
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
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            list.replace(this, temp3);
          }
        }
        if(this.col == n.col && this.row == n.row)
        {
          empty = true;
        }
      }
      else if(n.col > this.col && n.row < this.row)
      {

        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col + 1, this.row - 1, ' ');
          kingPlaced = true;
          temp = list.find(temp);
          piecesLeft = 0;
          if(temp.color != ' ')
          {

            if(this.col + 1 == n.col && this.row - 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col++;
                this.row--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                list.delete(n);
                empty = true;
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
            piecesLeft = 0;
            this.row--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            list.replace(this, temp3);
          }
        }
        if(this.col == n.col && this.row == n.row)
        {
          kingPlaced = true;
          empty = true;
        }
      }
      else if(n.col < this.col && n.row < this.row)
      {
        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col - 1, this.row - 1, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.col - 1 == n.col && this.row - 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                n.col--;
                n.row--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                list.delete(n);
                empty = true;
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
            this.row--;
            piecesLeft = 0;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            list.replace(this, temp3);
            kingPlaced = true;
          }
        }
        if(this.col == n.col && this.row == n.row)
        {
          empty = true;
        }
      }
    }
    return empty;
  }
}
