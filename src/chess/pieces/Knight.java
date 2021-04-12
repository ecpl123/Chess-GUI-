package chess.pieces;

import chess.Board;

public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
    	
    	//DO NOT TAKE OWN PIECES
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

        
        //KNIGHT MOVES IN L'S AND HOPS OVER PIECES
        if(!(  (destination_y == this.getY() - 2 && destination_x == this.getX() + 1)
        	|| (destination_y == this.getY() - 2 && destination_x == this.getX() - 1)
        	|| (destination_y == this.getY() + 2 && destination_x == this.getX() + 1)
        	|| (destination_y == this.getY() + 2 && destination_x == this.getX() - 1)
        	|| (destination_y == this.getY() + 1 && destination_x == this.getX() - 2)
        	|| (destination_y == this.getY() - 1 && destination_x == this.getX() - 2)
        	|| (destination_y == this.getY() + 1 && destination_x == this.getX() + 2)
        	|| (destination_y == this.getY() - 1 && destination_x == this.getX() + 2)
          )) {
        	return false;
        }
        return true;
    }
    
    @Override
    public boolean[][] attackedSquares(){
    	boolean[][] attackBoard = new boolean[8][8];
    	for(int y = 0; y < 8; y++) {
    		for(int x = 0; x<8; x++) {
    			//attackBoard[y][x] = false;
    			if((y == this.getY() - 2 && x == this.getX() + 1)
    			|| (y == this.getY() - 2 && x == this.getX() - 1)
    			|| (y == this.getY() + 2 && x == this.getX() + 1)
    			|| (y == this.getY() + 2 && x == this.getX() - 1)
    			|| (y == this.getY() + 1 && x == this.getX() - 2)
    			|| (y == this.getY() - 1 && x == this.getX() - 2)
    			|| (y == this.getY() + 1 && x == this.getX() + 2)
    			|| (y == this.getY() - 1 && x == this.getX() + 2)){
    				attackBoard[y][x] = true;
    			}
    			
    			//PRINT
//    			if(x == 7) {
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
    			
    		}
    	}
    	
//    	System.out.println("\n");
    	
    	return attackBoard;
    }
}
