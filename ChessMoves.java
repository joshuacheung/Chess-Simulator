// Cheung Joshua November 2017
// ChessMoves.java
//
// The main class, to compile use the "make" command to run follow run format
// This code takes in a serious of boards in an input file and moves them according
// to the input file, determining whether or not the move is valid.

import java.util.*;
import java.io.*;
import java.lang.*;
class ChessMoves
{
  public static void main(String[] args) throws IOException
  {
    if(args.length < 2)
    {
      System.out.println("Usage: java -jar ChessMove.jar <input file> <output file>");
      System.exit(1);
    }
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new File(args[1]));
    while(in.hasNextLine())
    {
      LinkedList list = new LinkedList();
      String input = in.nextLine().trim();
      int numLines = 0;

      if(numLines != 0){
        numLines++;
      }

      input = input.replaceAll("\\s+","");
      boolean filePresent  = true;
      char[] board = new char[input.length()];

      for(int i = 0; i < input.length(); i++)
      board[i] = input.charAt(i);

      int i;
      for(i = 0; board[i] != ':'; i+=3)
      {
        if(board[i] == 'n' || board[i] == 'N')
        {
          int count = i;
          char piece = board[i];
          numLines++;
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          filePresent = false;
          ChessPiece chessPiece = new Knight(col, row, piece);
          list.insert(chessPiece);
        }
        if(board[i] == 'q' || board[i] == 'Q')
        {
          int count = i;
          char piece = board[i];
          numLines++;
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          filePresent = false;
          ChessPiece chessPiece = new Queen(col, row, piece);
          list.insert(chessPiece);
        }
        if(board[i] == 'r' || board[i] == 'R')
        {
          int count = i;
          char piece = board[i];
          numLines++;
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          filePresent = false;
          ChessPiece chessPiece = new Rook(col, row, piece);
          list.insert(chessPiece);
        }
        if(board[i] == 'k' || board[i] == 'K')
        {
          int count = i;
          char piece = board[i];
          numLines++;
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          filePresent = false;
          ChessPiece chessPiece = new King(col, row, piece);
          list.insert(chessPiece);
        }
        if(board[i] == 'b' || board[i] == 'B')
        {
          int count = i;
          char piece = board[i];
          numLines++;
          int col = Character.getNumericValue(board[++count]);
          int row = Character.getNumericValue(board[++count]);
          filePresent = false;
          ChessPiece chessPiece = new Bishop(col, row, piece);
          list.insert(chessPiece);
        }
      }
      i+=1;
      boolean legalMove = true;
      int numElements = 0;

      for(int j = i; j < board.length; j++){
        numElements+=j;
      }

      int moveCount = 1;
      boolean white = false;
      boolean prevWhite = false;

      while(i < board.length)
      {
        int colMove = Character.getNumericValue(board[i]);
        int rowMove = Character.getNumericValue(board[i + 1]);
        ChessPiece move = new ChessPiece(colMove, rowMove, ' ');

        int colDest = Character.getNumericValue(board[i + 2]);
        int rowDest = Character.getNumericValue(board[i + 3]);

        ChessPiece dest = new ChessPiece(colDest, rowDest, ' ');
        ChessPiece previous = new ChessPiece(colMove, rowMove, ' ');

        if(list.find(move).color != ' ')
        {
          move = list.find(move);
          dest = list.find(dest);
          if(moveCount == 1)
          {
            if(Character.isLowerCase(move.color))
            {
              white = true;
              boolean check = move.checkPath(list, dest);
              if(check)
              {
                ChessPiece king = kingAtSpot(list, white);
                if(!kingCheck(king, list))
                {
                  prevWhite = white;
                  moveCount++;
                }
                else
                {
                  out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                  numLines++;
                  legalMove = false;
                  numLines++;
                  break;
                }
              }
              else
              {
                out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                numLines++;
                legalMove = false;
                numLines++;
                break;
              }
            }
            else
            {
              numLines++;
              out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
              legalMove = false;
              numLines++;
              break;
            }
          }
          else if(moveCount > 1)
          {
            white = Character.isLowerCase(move.color);
            if(prevWhite != white)
            {
              if(move.checkPath(list, dest))
              {
                ChessPiece king = kingAtSpot(list, white);
                boolean checkM = kingCheck(king, list);
                if(!checkM)
                {
                  prevWhite = white;
                  moveCount++;
                }
                else
                {
                  numLines++;
                  out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                  legalMove = false;
                  numLines++;
                  break;
                }
              }
              else
              {

                out.println(previous.col + " " + previous.row + " " + dest.col + " " + dest.row + " " + "illegal");
                numLines++;
                legalMove = false;
                numLines++;
                break;
              }
            }
            else
            {
              out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
              numLines++;
              legalMove = false;
              numLines++;
              break;
            }
          }
        }
        else
        {
          out.println(move.col + " " + move.row + " " + dest.col + " " + dest.row + " " + "illegal");
          numLines++;
          numLines++;
          legalMove = false;
          break;
        }
        i += 4;
      }
      if(legalMove)
      {
        out.println("legal");
        numLines++;
      }
    }
    in.close();
    out.close();
  }

  public static ChessPiece kingAtSpot(LinkedList list, boolean white)
  {
    Node current = list.head;
    ChessPiece dummy = new ChessPiece(0, 0, ' ');
    while(current != null)
    {
      if(white)
      {
        if(current.val.color == 'k')
        dummy = current.val;
      }
      else
      {
        if(current.val.color == 'K')
        dummy = current.val;
      }
      current = current.next;
    }
    return dummy;
  }

  public static boolean kingCheck(ChessPiece king, LinkedList list)
  {
    Node current = list.head;
    boolean check = false;
    while(current != null)
    {
      if((Character.isLowerCase(current.val.color) != Character.isLowerCase(king.color)) && current.val.kingSpot(list, king))
      {
        check = true;
      }
      current = current.next;
    }
    return check;
  }


}
