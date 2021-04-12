package chess.pieces;

import chess.Board;

public class Pawn extends Piece {

    private boolean already_moved;
    
    public Pawn(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
        already_moved = false;
    }
    
    public boolean getHasMoved()
    {
        return already_moved;
    }
    
    public void setHasMoved(boolean has_moved)
    {
        this.already_moved = has_moved;
    }
   
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
    	Piece possiblePiece = board.getPiece(destination_x, destination_y);
    	
    	
    	String direction = "not front";
    	if(destination_x == this.getX()) {
    		direction = "front";
    	}
    	else {
    		direction = "not front";
    	}
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
    	if(direction == "front" && possiblePiece != null && possiblePiece.getY() == destination_y) { 
    		return false; 
    	}
		
    	//CANT TAKE KING

    	
    			
    	
    	
    	//BLACK PAWN MOVES UP
    	//WHITE PAWN MOVES DOWN
    	//IF PAWN IS AT START IT CAN MOVE 2 SPACES IF NOT BLOCKED
    	
    	//CASE FOR WHITE
    	if(this.isWhite()) {
    		
    		if(Math.abs(this.getY()-destination_y) > 2) {
    			return false;
    		}
    		if(this.already_moved && Math.abs(this.getY()-destination_y) == 2) {
    			return false;
    		}
    		if(!(this.already_moved) && Math.abs(this.getY()-destination_y) == 2 && direction != "front") {
    			return false;
    		}
    		if(this.getY() > destination_y) {
    			return false;
    		}
    		Piece attackedPieceLeft = board.getPiece(this.getX() - 1, this.getY() + 1);
    		Piece attackedPieceRight = board.getPiece(this.getX() + 1, this.getY() + 1);
    		if(attackedPieceLeft == null && attackedPieceRight == null && this.getX() != destination_x) {
    			return false;
    		}
    		if(attackedPieceLeft != null && attackedPieceRight == null && destination_x == this.getX() + 1) {
    			return false;
    		}
    		if(attackedPieceLeft == null && attackedPieceRight != null && destination_x == this.getX() - 1) {
    			return false;
    		}
    	}
    	//CASE FOR BLACK
    	else {
    		
    		if(Math.abs(this.getY()-destination_y) > 2) {
    			return false;
    		}
    		if(this.already_moved && Math.abs(this.getY()-destination_y) == 2) {
    			return false;
    		}
    		if(!(this.already_moved) && Math.abs(this.getY()-destination_y) == 2 && direction != "front") {
    			return false;
    		}
    		if(this.getY() < destination_y) {
    			return false;
    		}
    		Piece attackedPieceLeft = board.getPiece(this.getX() + 1, this.getY() - 1);
    		Piece attackedPieceRight = board.getPiece(this.getX() - 1, this.getY() - 1);
    		
    		if(attackedPieceLeft == null && attackedPieceRight == null && this.getX() != destination_x) {
    			return false;
    		}
    		if(attackedPieceLeft != null && attackedPieceRight == null && destination_x == this.getX() - 1) {
    			return false;
    		}
    		if(attackedPieceLeft == null && attackedPieceRight != null && destination_x == this.getX() + 1) {
    			return false;
    		}
    		
    	}
    	
        return true;
    }
    
    @Override
    public boolean[][] attackedSquares()
    {
    	boolean[][] attackBoard = new boolean[8][8];
		//IF WHITE
    	
    	if(this.isWhite()) {
			//IF PAWN IS AT EDGE OF BOARD
			if(this.getX() == 0) {
				attackBoard[this.getY() + 1][this.getX() + 1] = true;
			}
			else if(this.getX() == 7) {
				attackBoard[this.getY() + 1][this.getX() - 1] = true;
			}
			else if(this.getY() == 7) {
			
			}
			//NORMAL CASE
			else {
				attackBoard[this.getY() + 1][this.getX() + 1] = true;
				attackBoard[this.getY() + 1][this.getX() - 1] = true;
			}
		}
		//IF BLACK
		else {
			//IF PAWN IS AT EDGE OF BOARD
			if(this.getX() == 0) {
				attackBoard[this.getY() - 1][this.getX() + 1] = true;
			}
			else if(this.getX() == 7) {
				attackBoard[this.getY() - 1][this.getX() - 1] = true;
			}
			else if(this.getY() == 0) {
				
			}
			//NORMAL CASE
			else {
				attackBoard[this.getY() - 1][this.getX() + 1] = true;
				attackBoard[this.getY() - 1][this.getX() - 1] = true;


				
    	
			}
		}
    	
    	
//    	for(int y = 0; y<8;y++) {
//			for(int x = 0; x<8;x++) {
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
//    	System.out.print("\n");
    	return attackBoard;
    }
}
