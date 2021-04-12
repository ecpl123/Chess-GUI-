package chess.pieces;

import chess.Board;

public class Queen extends Piece {

    public Queen(int x, int y, boolean is_white, String file_path, Board board)
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

        
      		
        
        //QUEEN MOVES DIAGONALLY AND HORIZONTALLY ANY NUMBER OF SPACES WITHOUT JUMPING OVER PIECES
        int xchange = this.getX() - destination_x;
        int ychange = this.getY() - destination_y;

        if((this.getX() != destination_x && this.getY() != destination_y) && (Math.abs(xchange) != Math.abs(ychange))) {
     	   return false;
        }
        
        int dist = Math.abs(xchange);
        String direction = "";
        
        //DIAGONAL CASE
        if((Math.abs(xchange) == Math.abs(ychange))) {
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
            			//System.out.println("Found piece at " + p.getX() + ", " + p.getY());
            			return false;
            		}
            	}
            }
        }
        
        //HORIZONTAL CASE
        if((this.getX() == destination_x || this.getY() == destination_y)) {
        	if(destination_y > this.getY()) {
        		direction = "south";
        	}
        	if(destination_y < this.getY()) {
        		direction = "north";
        	}
        	if(destination_x > this.getX()) {
        		direction = "east";
        	}
        	if(destination_x < this.getX()) {
        		direction = "west";
        	}
        	
        	if(direction.equals("south")) {
          	   int spaces_to_move = Math.abs(destination_y - this.getY());
          	   for(int i = 1; i < spaces_to_move; i++) {
          		   Piece p = board.getPiece(this.getX(), this.getY()+i);
          		   if (p != null) {
          			   return false;
          		   }
          	   }
             }
             if(direction.equals("north")) {
          	   int spaces_to_move = Math.abs(destination_y - this.getY());
          	   for(int i = 1; i < spaces_to_move; i++) {
          		   Piece p = board.getPiece(this.getX(), this.getY() - i);
          		   if (p != null) {
          			   return false;
          		   }
          	   }
             }
             if(direction.equals("west")) {
          	   int spaces_to_move = Math.abs(destination_x - this.getX());
          	   for(int i = 1; i < spaces_to_move; i++) {
          		   Piece p = board.getPiece(this.getX() - i, this.getY());
          		   if (p != null) {
          			   return false;
          		   }
          	   }
             }
             if(direction.equals("east")) {
          	   int spaces_to_move = Math.abs(destination_x - this.getX());
          	   for(int i = 1; i < spaces_to_move; i++) {
          		   Piece p = board.getPiece(this.getX() + i, this.getY());
          		   if (p != null) {
          			   return false;
          		   }
          	   }
            }
        }

        return true;
        
    }
    
    @Override
    public boolean[][] attackedSquares()
    {
    	boolean[][] attackBoard = new boolean[8][8];
    	for(int y = 0; y < 8; y++) {
    		for(int x = 0; x<8; x++) {
    			attackBoard[y][x] = false;
    		}
    	}
    	
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
				direction = "northeast";
			}
			else {
			Piece p = board.getPiece(this.getX() + westCounter, this.getY());
			attackBoard[this.getY()][this.getX() + westCounter] = true;
			if(p != null) {
				//System.out.println("WEST Piece found at X: " + p.getX() + " Y: " + p.getY());
				direction = "northeast";
			}
			
			westCounter--;
			}
		}
		
		
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
		
//		System.out.println("\n");
		return attackBoard;
    }
}
