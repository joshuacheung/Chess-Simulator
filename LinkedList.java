// Cheung Joshua December 2017
// LinkedList.java

class LinkedList
{
	Node head;
	public LinkedList()
	{
		head = null;
	}

	ChessPiece find(ChessPiece piece)
	{
		Node current = head;
		ChessPiece dest = piece;
		while(current != null)
		{
			if(current.val.col == piece.col && current.val.row == piece.row)
			{
				dest = current.val;
			}
			current = current.next;
		}
		return dest;
	}

	void traverse()
	{
		Node current = head;
		while(current != null)
		{
			current = current.next;
		}
	}

	void delete(ChessPiece piece)
	{
			Node prev = null;
			boolean present = false;
			Node temp = head;
			if(temp != null && temp.val == piece)
			{
				head = temp.next;
				return;
			}
			while(temp != null && temp.val != piece)
			{
				prev = temp;
				temp = temp.next;
			}
			if(temp == null)
				return;

			prev.next = temp.next;
	}

	void replace(ChessPiece original, ChessPiece replacement)
	{
		Node current = head;
		while(current != null)
		{
			if(current.val.col == original.col &&
				 current.val.row == original.row &&
				 current.val.color == original.color)
			{
				current.val.col = replacement.col;
				current.val.row = replacement.row;
				break;
			}
			current = current.next;
		}
	}

	void insert(ChessPiece newNode)
	{
		Node latest = new Node(newNode);
		latest.next = head;
		head = latest;
	}
}
