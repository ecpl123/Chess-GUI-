package chess.pieces;

import chess.Board;

public class Piece {
    private int x;
    private int y;
    final private boolean is_white;
    private String file_path;
    public Board board;
    
    public Piece(int x, int y, boolean is_white, String file_path, Board board)
    {
        this.is_white = is_white;
        this.x = x;
        this.y = y;
        this.file_path = file_path;
        this.board = board;
    }
    
    public String getFilePath()
    {
        return file_path;
    }
    
    public void setFilePath(String path)
    {
        this.file_path = path;
    }
    
    public boolean isWhite()
    {
        return is_white;
    }
    
    public boolean isBlack()
    {
        return !is_white;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    //Can this piece move to the destination_x and destination_y? This will find out.
    public boolean canMove(int destination_x, int destination_y)
    {
        return false;
    }
    
    //This returns a simulated board with the positions attacked by the piece, for use in calculating king's moves, checks, and checkmates.
    public boolean[][] attackedSquares()
    {
    	return null;
    }
}
