// Cheung Joshua December 2017
// King.java

import java.lang.*;
class King extends ChessPiece
{
  int col;
  int row;
  char color;
  public King(int c, int r, char p)
  {
    super(c, r, p);
    this.col = c;
    this.row = r;
    this.color = p;
  }

  boolean checkPath(LinkedList list, ChessPiece piece)
  {
    boolean empty = false;
    boolean nextSpotOpen = true;
    if(this.isAttacking(piece))
    {
      if(piece.col > this.col && piece.row > this.row)
      {

        ChessPiece temp = new ChessPiece(this.col + 1, this.row + 1, ' ');
        temp = list.find(temp);
        if(temp.color != ' ')
        {
          if(this.col + 1 == piece.col && this.row + 1 == piece.row)
          {
            if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
            {
              this.col += 1;
              this.row += 1;
              nextSpotOpen = true;
              ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
              temp2 = list.find(temp2);
              list.replace(this, temp2);
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.col++;
          this.row++;
          nextSpotOpen = true;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          temp3 = list.find(temp3);
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
      else if(piece.col < this.col && piece.row > this.row)
      {

        ChessPiece temp = new ChessPiece(this.col - 1, this.row + 1, ' ');
        temp = list.find(temp);
        if(temp.color != ' ')
        {
          if(this.col - 1 == piece.col && this.row + 1 == piece.row)
          {
            if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
            {
              this.col--;
              this.row++;
              nextSpotOpen = true;
              ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
              temp2 = list.find(temp2);
              list.replace(this, temp2);
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.col--;
          this.row++;
          nextSpotOpen = true;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          temp3 = list.find(temp3);
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
      else if(piece.col > this.col && piece.row < this.row)
      {

        ChessPiece temp = new ChessPiece(this.col + 1, this.row - 1, ' ');
        temp = list.find(temp);
        if(temp.color != ' ')
        {
          if(this.col + 1 == piece.col && this.row - 1 == piece.row)
          {
            if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
            {
              this.col++;
              this.row--;
              nextSpotOpen = true;
              ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
              temp2 = list.find(temp2);
              list.replace(this, temp2);
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.col++;
          this.row--;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          temp3 = list.find(temp3);
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
      else if(piece.col < this.col && piece.row < this.row)
      {
        ChessPiece temp = new ChessPiece(this.col - 1, this.row - 1, ' ');
        temp = list.find(temp);
        if(temp.color != ' ')
        {
          if(this.col - 1 == piece.col && this.row - 1 == piece.row)
          {
            if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
            {
              this.col--;
              this.row--;

              ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
              temp2 = list.find(temp2);
              nextSpotOpen = true;
              list.replace(this, temp2);
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.col--;
          this.row--;
          nextSpotOpen = true;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          temp3 = list.find(temp3);
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
      else if(piece.col > this.col && piece.row == this.row)
      {

        ChessPiece temp = new ChessPiece(this.col + 1, this.row, ' ');
        temp = list.find(temp);
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
              list.replace(this, temp2);
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.col++;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          nextSpotOpen = true;
          temp3 = list.find(temp3);
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
      else if(piece.col < this.col && piece.row == this.row)
      {

        ChessPiece temp = new ChessPiece(this.col - 1, this.row, ' ');
        temp = list.find(temp);
        if(temp.color != ' ')
        {
          if(this.col - 1 == piece.col)
          {
            if(Character.isLowerCase(piece.color) != Character.isLowerCase(this.color))
            {
              this.col--;
              ChessPiece temp2 = new ChessPiece(piece.col, piece.row, ' ');
              temp2 = list.find(temp2);
              list.replace(this, temp2);
              nextSpotOpen = true;
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.col--;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          temp3 = list.find(temp3);
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
      else if(piece.col == this.col && piece.row > this.row)
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
              list.replace(this, temp2);
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.row++;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          temp3 = list.find(temp3);
          nextSpotOpen = true;
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
      else if(piece.col == this.col && piece.row < this.row)
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
              list.replace(this, temp2);
              list.delete(piece);
              empty = true;
            }
            else
            {
            }
          }
          else
          {
          }
        }
        else
        {
          this.row--;
          ChessPiece temp3 = new ChessPiece(this.col, this.row, ' ');
          temp3 = list.find(temp3);
          list.replace(this, temp3);
        }
        if(this.col == piece.col && this.row == piece.row)
        {
          empty = true;
        }
      }
    }
    return empty;
  }

  boolean isAttacking(ChessPiece piece)
  {
    boolean attack = false;
    if(((this.col == piece.col + 1 && this.row == piece.row) ||
    (this.col == piece.col - 1 && this.row == piece.row) ||
    (this.row == piece.row + 1 && this.col == piece.col) ||
    (this.row == piece.row - 1 && this.col == piece.col) ||
    (this.row == piece.row - 1 && this.col == piece.col - 1) ||
    (this.row == piece.row - 1 && this.col == piece.col + 1) ||
    (this.row == piece.row + 1 && this.col == piece.col - 1) ||
    (this.row == piece.row + 1 && this.col == piece.col + 1))
    && (this.color != piece.color))
    attack = true;
    return attack;
  }
}
