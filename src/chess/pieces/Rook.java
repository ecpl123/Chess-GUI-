package chess.pieces;

import chess.Board;

public class Rook extends Piece {

	public Rook(int x, int y, boolean is_white, String file_path, Board board)
	{
		super(x,y,is_white,file_path, board);
	}

	@Override
	public boolean canMove(int destination_x, int destination_y)
	{
		
		
		
		//CHECK IF TRYING TO TAKE OWN PIECE:
		Piece possiblePiece = board.getPiece(destination_x, destination_y);

		if(possiblePiece != null) {
			if(possiblePiece.isWhite() && this.isWhite()) {
				return false;
			}
			if(possiblePiece.isBlack() && this.isBlack()) {
				return false;
			}
			if(possiblePiece.getClass().equals(King.class)) {
				return false;
			}
		}
		//CANT TAKE KING
		
		
		

		//ROOK MOVES HORIZONTALLY:
		if(this.getX() != destination_x && this.getY() != destination_y) {
			return false;
		}

		//MAKE SURE NOTHING IS IN THE WAY:
		String direction = "";
		if(destination_y > this.getY()) {
			direction = "down";
		}
		if(destination_y < this.getY()) {
			direction = "up";
		}
		if(destination_x > this.getX()) {
			direction = "right";
		}
		if(destination_x < this.getX()) {
			direction = "left";
		}

		if(direction.equals("down")) {
			int spaces_to_move = Math.abs(destination_y - this.getY());
			for(int i = 1; i < spaces_to_move; i++) {
				Piece p = board.getPiece(this.getX(), this.getY()+i);
				if (p != null) {
					return false;
				}
			}
		}
		if(direction.equals("up")) {
			int spaces_to_move = Math.abs(destination_y - this.getY());
			for(int i = 1; i < spaces_to_move; i++) {
				Piece p = board.getPiece(this.getX(), this.getY() - i);
				if (p != null) {
					return false;
				}
			}
		}
		if(direction.equals("left")) {
			int spaces_to_move = Math.abs(destination_x - this.getX());
			for(int i = 1; i < spaces_to_move; i++) {
				Piece p = board.getPiece(this.getX() - i, this.getY());
				if (p != null) {
					return false;
				}
			}
		}
		if(direction.equals("right")) {
			int spaces_to_move = Math.abs(destination_x - this.getX());
			for(int i = 1; i < spaces_to_move; i++) {
				Piece p = board.getPiece(this.getX() + i, this.getY());
				if (p != null) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean[][] attackedSquares()
	{
		//NEED TO KNOW LIMITS: THE EDGES THAT THE ROOK CAN REACH OR THE PIECES WHICH IT ATTACKS
		//CAN USE SAME AS canMove? EXCEPT WITH PHONY DESTINATION AT EACH EDGE SO: x == this.getX(), y == 0 to go up etc.
		
		
		//INIT ATTACKBOARD
		boolean[][] attackBoard = new boolean[8][8];
//		for(int y = 0; y < 8; y++) {
//			for(int x = 0; x<8; x++) {
//				attackBoard[y][x] = false;
//			}
//		}
		
		
		String direction = "north";
		
		//FIND ATTACKED SQUARES NORTH
		int northCounter = -1;
		while(direction.equals("north")) {

			if(this.getY() + northCounter < 0) {
				direction = "south";
			}
			else {
				attackBoard[this.getY() + northCounter][this.getX()] = true;
				Piece p = board.getPiece(this.getX(), this.getY() + northCounter);
				if(p != null) {
					//System.out.println("NORTH Piece found at X: " + p.getX() + " Y: " + p.getY());
					direction = "south";
				}
			
				northCounter--;
			}
		}
		
		//FIND ATTACKED SQUARES SOUTH
		int southCounter = 1;
		while(direction.equals("south")) {
			if(this.getY() + southCounter > 7) {
				direction = "east";
			}
			else {
			attackBoard[this.getY() + southCounter][this.getX()] = true;
			Piece p = board.getPiece(this.getX(), this.getY() + southCounter);
			if(p != null) {
				//System.out.println("SOUTH Piece found at X: " + p.getX() + " Y: " + p.getY());
				direction = "east";
			}
			
			southCounter++;
			}
		}
		
		//FIND ATTACKED SQUARES EAST
		int eastCounter = 1;
		while(direction.equals("east")) {
			if(this.getX() + eastCounter > 7) {
				direction = "west";
			}
			else {
			Piece p = board.getPiece(this.getX() + eastCounter, this.getY());
			attackBoard[this.getY()][this.getX() + eastCounter] = true;
			if(p != null) {
				//System.out.println("EAST Piece found at X: " + p.getX() + " Y: " + p.getY());
				direction = "west";
			}
			
			eastCounter++;
			}
		}
		
		//FIND ATTACKED SQUARES WEST
		int westCounter = -1;
		while(direction.equals("west")) {
			if(this.getX() + westCounter < 0) {
				direction = "";
			}
			else {
			Piece p = board.getPiece(this.getX() + westCounter, this.getY());
			attackBoard[this.getY()][this.getX() + westCounter] = true;
			if(p != null) {
				//System.out.println("WEST Piece found at X: " + p.getX() + " Y: " + p.getY());
				direction = "";
			}
			
			westCounter--;
			}
		}
		
		//PRINT
//		for(int y = 0; y < 8; y++) {
//			for(int x = 0; x<8; x++) {
//				if(x == 7) {
//					if(attackBoard[y][x] == true) {
//						System.out.print("[ true] \n");
//					}
//					else
//						System.out.print("[false] \n");
//				}
//				else {
//					if(attackBoard[y][x] == true) {
//						System.out.print("[ true] ");
//					}
//					else
//						System.out.print("[false] ");
//				}
//			}
//		}
		System.out.println("\n");
		return attackBoard;
	}
}
