// Cheung Joshua December 2017
// Queen.java

import java.lang.*;
class Queen extends ChessPiece
{
  int col;
  int row;
  char s;
  public Queen(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.s = p;
  }
  public boolean isAttacking(ChessPiece piece)
  {
    if(this.col == piece.col || this.row == piece.row)
    {
      return true;
    }
    else if((Math.abs(this.col - piece.col) == Math.abs(this.row - piece.row)))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  boolean kingSpot(LinkedList list, ChessPiece king)
  {
    boolean empty = false;
    int colTemp = 0;
    int numMoves = 0;
    boolean nextSpotOpen = false;
    int rowTemp = 0;
    if(this.isAttacking(king))
    {
      colTemp = this.col;
      rowTemp = this.row;
      if(king.col > colTemp && king.row > rowTemp)
      {
        while(king.col != colTemp && king.row != rowTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp + 1, rowTemp + 1, ' ');
          tempPiece = list.find(tempPiece);
          nextSpotOpen = false;
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
            nextSpotOpen = false;
            colTemp++;
            rowTemp++;
          }
        }
      }
      else if(king.col < colTemp && king.row > rowTemp)
      {
        while(king.col != colTemp && king.row != rowTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp - 1, rowTemp + 1, ' ');
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && tempPiece.col == king.col && tempPiece.row == king.row)
          {
            nextSpotOpen = false;
            empty = true;
            break;
          }
          else if(tempPiece.color != ' ' && tempPiece.col != king.col && tempPiece.row != king.row)
          {
            break;
          }
          else
          {
            nextSpotOpen = false;
            colTemp--;
            rowTemp++;
          }
        }
      }
      else if(king.col > colTemp && king.row < rowTemp)
      {

        while(king.col != colTemp && king.row != rowTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp + 1, rowTemp - 1, ' ');
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && tempPiece.col == king.col && tempPiece.row == king.row)
          {
            empty = true;
            nextSpotOpen = false;
            break;
          }
          else if(tempPiece.color != ' ' && tempPiece.col != king.col && tempPiece.row != king.row)
          {
            break;
          }
          else
          {
            colTemp++;
            nextSpotOpen = false;
            rowTemp--;
          }
        }
      }
      else if(king.col < colTemp && king.row < rowTemp)
      {

        while(king.col != colTemp && king.row != rowTemp)
        {

          ChessPiece tempPiece = new ChessPiece(colTemp - 1, rowTemp - 1, ' ');
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
            colTemp--;
            nextSpotOpen = false;
            rowTemp--;
          }
        }
      }
      else if(king.col > colTemp && king.row == rowTemp)
      {
        while(king.col != colTemp)
        {
          ChessPiece tempPiece = new ChessPiece(colTemp + 1, rowTemp, ' ');
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && king.col == tempPiece.col)
          {
            empty = true;
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
          if(tempPiece.color != ' ' && king.col == tempPiece.col)
          {
            empty = true;
            nextSpotOpen = false;
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
          tempPiece = list.find(tempPiece);
          if(tempPiece.color != ' ' && king.row == tempPiece.row)
          {
            empty = true;
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
          tempPiece = list.find(tempPiece);
          nextSpotOpen = false;
          if(tempPiece.color != ' ' && king.row == tempPiece.row)
          {
            empty = true;
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
      empty = false;
    }
    return empty;
  }

  boolean checkPath(LinkedList list, ChessPiece n)
  {
    boolean empty = false;
    boolean nextSpotOpen =false;
    int numMoves = 0;
    if(this.isAttacking(n))
    {
      if(n.col > this.col && n.row > this.row)
      {
        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col + 1, this.row + 1, ' ');
          temp = list.find(temp);
          numMoves++;
          if(temp.color != ' ')
          {
            if(this.col + 1 == n.col && this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.col += 1;
                this.row += 1;
                numMoves++;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                numMoves++;
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
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            list.replace(this, temp3);
          }
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
                ChessPiece temp2 = new ChessPiece(this.col, this.row, ' ');
                temp2 = list.find(temp2);
                numMoves++;
                list.replace(this, temp2);
                list.delete(n);
                numMoves++;
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
            this.row++;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            list.replace(this, temp3);
          }
        }
      }
      else if(n.col > this.col && n.row < this.row)
      {

        while(n.col != this.col && n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col + 1, this.row - 1, ' ');
          temp = list.find(temp);
          numMoves++;
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
                numMoves++;
                list.replace(this, temp2);
                numMoves++;
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
            this.row--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            numMoves++;
            temp3 = list.find(temp3);
            list.replace(this, temp3);
            list.traverse();
          }
        }
        if(this.col == n.col && this.row == n.row)
        {
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
                numMoves++;
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
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            list.replace(this, temp3);
          }
        }
        if(this.col == n.col && this.row == n.row)
        {
          list.traverse();
          empty = true;
        }
      }
      else if(n.col > this.col && n.row == this.row)
      {
        while(n.col != this.col)
        {
          ChessPiece temp = new ChessPiece(this.col + 1, this.row, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.col + 1 == n.col)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                list.traverse();
                this.col++;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                numMoves++;
                list.delete(n);
                list.traverse();
                list.traverse();
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
      else if(n.col < this.col && n.row == this.row)
      {
        while(n.col != this.col)
        {
          ChessPiece temp = new ChessPiece(this.col - 1, this.row, ' ');
          temp = list.find(temp);
          if(temp.color != ' ') //if there's a piece in the next spot this current piece is trying to move to
          {
            if(this.col - 1 == n.col)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                //System.out.println("before deleting: ");
                //list.traverse();
                this.col--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                list.delete(n);
                list.traverse();
                list.traverse();
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
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            list.replace(this, temp3);
            numMoves++;
          }
        }
        if(this.col == n.col && this.row == n.row)
        {
          empty = true;
        }
      }
      else if(n.col == this.col && n.row > this.row)
      {
        while(n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col, this.row + 1, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.row + 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.row++;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                numMoves++;
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
      else if(n.col == this.col && n.row < this.row)
      {
        while(n.row != this.row)
        {
          ChessPiece temp = new ChessPiece(this.col, this.row - 1, ' ');
          temp = list.find(temp);
          if(temp.color != ' ')
          {
            if(this.row - 1 == n.row)
            {
              if(Character.isLowerCase(n.color) != Character.isLowerCase(this.color))
              {
                this.row--;
                ChessPiece temp2 = new ChessPiece(n.col, n.row, ' ');
                temp2 = list.find(temp2);
                list.replace(this, temp2);
                numMoves++;
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
            this.row--;
            ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
            temp3 = list.find(temp3);
            numMoves++;
            list.replace(this, temp3);
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
