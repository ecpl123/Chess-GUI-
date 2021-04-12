package chess.pieces;

import chess.Board;

public class Bishop extends Piece {

    public Bishop(int x, int y, boolean is_white, String file_path, Board board)
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

        

        //BISHOP MOVES DIAGONALLY ANY NUMBER OF SPACES
        
        int xchange = this.getX() - destination_x;
        int ychange = this.getY() - destination_y;
    
        if(Math.abs(xchange) != Math.abs(ychange)) {
        	return false;
        }
        
        
        
//        //CHECK IF ANYTHING IS IN THE WAY
        
        int dist = Math.abs(xchange);
        String direction = "";
        if(xchange > 0 && ychange > 0) {
        	direction = "northeast";
        	//System.out.println("northeast");
        }
        if(xchange < 0 && ychange > 0) {
        	direction = "northwest";
        	//System.out.println("northwest");
        }
        if(xchange > 0 && ychange < 0) {
        	direction = "southeast";
        	//System.out.println("southeast");
        }
        if(xchange < 0 && ychange < 0) {
        	direction = "southwest";
        	//System.out.println("southwest");
        }
        
        
        if(direction.equals("northwest")) {
        	for(int i = 1; i < dist; i++) {
        		Piece p = board.getPiece(this.getX() + i, this.getY() - i);
        		//System.out.println("northwest " +this.getX());
        		if (p != null) {
        			//System.out.println("Found piece at " + p.getX() + ", " + p.getY());
        			return false;
        		}
        	}
        }
        if(direction.equals( "northeast")) {
        	for(int i = 1; i < dist; i++) {
        		Piece p = board.getPiece(this.getX() - i, this.getY() - i);
        		//System.out.println("northeast " + this.getX());
        		if (p != null) {
        			//System.out.println("Found piece at " + p.getX() + ", " + p.getY());
        			return false;
        		}
        	}
        }
        if(direction.equals("southwest")) {
        	for(int i = 1; i < dist; i++) {
        		Piece p = board.getPiece(this.getX() + i, this.getY() + i);
        		//System.out.println("southwest " +this.getX());
        		if (p != null) {
        			//System.out.println("Found piece at " + p.getX() + ", " + p.getY());
        			return false;
        		}
        	}
        }
        if(direction.equals("southeast")) {
        	for(int i = 1; i < dist; i++) {
        		Piece p = board.getPiece(this.getX() - i, this.getY() + i);
        		//System.out.println("southeast " + this.getX());
        		if (p != null) {
//        			System.out.println("Found piece at " + p.getX() + ", " + p.getY());
        			return false;
        		}
        	}
        }
        
        return true;
    }
    
    
    @Override
    public boolean[][] attackedSquares()
    {
    	//INIT ATTACKBOARD
    	boolean[][] attackBoard = new boolean[8][8];
    	for(int y = 0; y < 8; y++) {
    		for(int x = 0; x<8; x++) {
    			attackBoard[y][x] = false;
    		}
    	}
    	
  
    	String direction = "northeast";
    	
    	//
    	int neCount = 1;
    	while(direction.equals("northeast")) {
    		if(this.getX() + neCount > 7 || this.getY() - neCount < 0) {
    			direction = "northwest";
    		}
    		else {
    			attackBoard[this.getY() - neCount][this.getX() + neCount] = true;
				Piece p = board.getPiece(this.getX() + neCount, this.getY() - neCount);
				if(p != null) {
					//System.out.println("NORTHEAST Piece found at X: " + p.getX() + " Y: " + p.getY());
					direction = "northwest";
				}
    			neCount++;
    		}
    		
    	}
    	
    	
    	//
    	int nwCount = 1;
    	while(direction.equals("northwest")) {
    		if(this.getX() - nwCount < 0 || this.getY() - nwCount < 0) {
    			direction = "southwest";
    		}
    		else {
    			attackBoard[this.getY() - nwCount][this.getX() - nwCount] = true;
				Piece p = board.getPiece(this.getX() - nwCount, this.getY() - nwCount);
				if(p != null) {
					//System.out.println("NORTHWEST Piece found at X: " + p.getX() + " Y: " + p.getY());
					direction = "southwest";
				}
    			nwCount++;
    		}
    		
    	}
    	
    	
    	//
    	int swCount = 1;
    	while(direction.equals("southwest")) {
    		if(this.getX() - swCount < 0 || this.getY() + swCount > 7) {
    			direction = "southeast";
    		}
    		else {

    			attackBoard[this.getY() + swCount][this.getX() - swCount] = true;
    			Piece p = board.getPiece(this.getX() - swCount, this.getY() + swCount);
    			if(p != null) {
    				//System.out.println("SOUTHWEST Piece found at X: " + p.getX() + " Y: " + p.getY());
    				direction = "southeast";
    			}
    			swCount++;
    			
    		}
    		
    	}
    	
    	int seCount = 1;
    	while(direction.equals("southeast")) {
    		if(this.getX() + seCount > 7 || this.getY() + seCount > 7) {
    			direction = "";
    		}
    		else {
    			attackBoard[this.getY() + seCount][this.getX() + seCount] = true;
				Piece p = board.getPiece(this.getX() + seCount, this.getY() + seCount);
				if(p != null) {
					//System.out.println("SOUTHEAST Piece found at X: " + p.getX() + " Y: " + p.getY());
					direction = "";
				}
    			seCount++;
    		}
    		
    	}
    	
    	//PRINT
    	
//    	for(int y = 0; y < 8; y++) {
//    		for(int x = 0; x<8; x++) {
//    			if(x == 7) {
//    				if(attackBoard[y][x] == true) {
//    					System.out.print("[ true] \n");
//    				}
//    				else
//    					System.out.print("[false] \n");
//    			}
//    			else {
//    				if(attackBoard[y][x] == true) {
//    					System.out.print("[ true] ");
//    				}
//    				else
//    					System.out.print("[false] ");
//    			}
//    		}
//    	}
    	
    	
//    	System.out.print("\n");
    	return attackBoard;
    }
}
