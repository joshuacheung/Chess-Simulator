# Makefile
# Joshua Cheung November 2017
# Makefile

ChessMoves: ChessMoves.class ChessPiece.class LinkedList.class King.class Node.class Queen.class Rook.class Bishop.class Knight.class
	echo Main-class: ChessMoves > Manifest
	jar cvfm ChessMoves.jar Manifest ChessMoves.class ChessPiece.class Knight.class LinkedList.class King.class Node.class Queen.class Rook.class Bishop.class

ChessMoves.class: ChessMoves.java
	javac -Xlint ChessMoves.java

ChessPiece.class: ChessPiece.java
	javac -Xlint ChessPiece.java

King.class: King.java
	javac -Xlint King.java

LinkedList.class: LinkedList.java
	javac -Xlint LinkedList.java

Node.class: Node.java
	javac -Xlint Node.java

Queen.class: Queen.java
	javac -Xlint Queen.java

Rook.class: Rook.java
	javac -Xlint Rook.java

Bishop.class: Bishop.java
	javac -Xlint Bishop.java

Knight.class: Knight.java
	javac -Xlint Knight.java



clean:
	rm -f ChessMoves.jar ChessMoves.class Rook.class Queen.class Node.class LinkedList.class King.class ChessPiece.class Bishop.class Knight.class
