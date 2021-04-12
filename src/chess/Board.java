package chess;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import chess.pieces.*;


@SuppressWarnings("serial")

public class Board extends JComponent {
    
    public int turnCounter = 0;
    private static Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

    private final int Square_Width = 65;
    public ArrayList<Piece> White_Pieces;
    public ArrayList<Piece> Black_Pieces;
    

    public ArrayList<DrawingShape> Static_Shapes;
    public ArrayList<DrawingShape> Piece_Graphics;

    public Piece Active_Piece;
    
    public boolean gameMode = true; //changes between UI and text based gameplay. UI is not tested because it requires mouse clicks!
    
    private final int rows = 8;
    private final int cols = 8;
    private Integer[][] BoardGrid;
    private String board_file_path = "images" + File.separator + "board.png";


    public void initGrid()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                BoardGrid[i][j] = 0;
            }
        }

      //============================FULL========================
        
        White_Pieces.add(new Pawn(0,1,true,"P.png",this));
        White_Pieces.add(new Pawn(1,1,true,"P.png",this));
        White_Pieces.add(new Pawn(2,1,true,"P.png",this));
        White_Pieces.add(new Pawn(3,1,true,"P.png",this));
        White_Pieces.add(new Pawn(4,1,true,"P.png",this));
        White_Pieces.add(new Pawn(5,1,true,"P.png",this));
        White_Pieces.add(new Pawn(6,1,true,"P.png",this));
        White_Pieces.add(new Pawn(7,1,true,"P.png",this));
        White_Pieces.add(new Rook(0,0,true,"R.png",this));
        White_Pieces.add(new Knight(1,0,true,"Kn.png",this));
        White_Pieces.add(new Bishop(2,0,true,"B.png",this));
        White_Pieces.add(new King(3,0,true,"K.png",this));
        White_Pieces.add(new Queen(4,0,true,"Q.png",this));
        White_Pieces.add(new Bishop(5,0,true,"B.png",this));
        White_Pieces.add(new Knight(6,0,true,"Kn.png",this));
        White_Pieces.add(new Rook(7,0,true,"R.png",this));
        Black_Pieces.add(new Pawn(0,6,false,"P.png",this));
        Black_Pieces.add(new Pawn(1,6,false,"P.png",this));
        Black_Pieces.add(new Pawn(2,6,false,"P.png",this));
        Black_Pieces.add(new Pawn(3,6,false,"P.png",this));
        Black_Pieces.add(new Pawn(4,6,false,"P.png",this));
        Black_Pieces.add(new Pawn(5,6,false,"P.png",this));
        Black_Pieces.add(new Pawn(6,6,false,"P.png",this));
        Black_Pieces.add(new Pawn(7,6,false,"P.png",this));
        Black_Pieces.add(new Rook(0,7,false,"R.png",this));
        Black_Pieces.add(new Knight(1,7,false,"Kn.png",this));
        Black_Pieces.add(new Bishop(2,7,false,"B.png",this));
        Black_Pieces.add(new King(3,7,false,"K.png",this));
        Black_Pieces.add(new Queen(4,7,false,"Q.png",this));
        Black_Pieces.add(new Bishop(5,7,false,"B.png",this));
        Black_Pieces.add(new Knight(6,7,false,"Kn.png",this));
        Black_Pieces.add(new Rook(7,7,false,"R.png",this));
        
        
      //============================PAWNS===========================
        
//        White_Pieces.add(new Pawn(0,1,true,"P.png",this));
//        White_Pieces.add(new Pawn(1,1,true,"P.png",this));
//        White_Pieces.add(new Pawn(2,1,true,"P.png",this));
//        White_Pieces.add(new Pawn(3,1,true,"P.png",this));
//        White_Pieces.add(new Pawn(4,1,true,"P.png",this));
//        White_Pieces.add(new Pawn(5,1,true,"P.png",this));
//        White_Pieces.add(new Pawn(6,1,true,"P.png",this));
//        White_Pieces.add(new Pawn(7,1,true,"P.png",this));
//        Black_Pieces.add(new Pawn(0,6,false,"P.png",this));
//        Black_Pieces.add(new Pawn(1,6,false,"P.png",this));
//        Black_Pieces.add(new Pawn(2,6,false,"P.png",this));
//        Black_Pieces.add(new Pawn(3,6,false,"P.png",this));
//        Black_Pieces.add(new Pawn(4,6,false,"P.png",this));
//        Black_Pieces.add(new Pawn(5,6,false,"P.png",this));
//        Black_Pieces.add(new Pawn(6,6,false,"P.png",this));
//        Black_Pieces.add(new Pawn(7,6,false,"P.png",this));
        
        
        //============================ROOKS==========================
        
//        White_Pieces.add(new Rook(0,0,true,"R.png",this));
//        White_Pieces.add(new Rook(7,0,true,"R.png",this));
//        Black_Pieces.add(new Rook(0,7,false,"R.png",this));
//        Black_Pieces.add(new Rook(7,7,false,"R.png",this));

        
        //============================KNIGHTS========================
        
//     	  White_Pieces.add(new Knight(1,0,true,"Kn.png",this));
//    	  White_Pieces.add(new Knight(6,0,true,"Kn.png",this));
//    	  Black_Pieces.add(new Knight(1,7,false,"Kn.png",this));
//    	  Black_Pieces.add(new Knight(6,7,false,"Kn.png",this));
        
        
        //============================BISHOPS========================
        
//    	  White_Pieces.add(new Bishop(2,0,true,"B.png",this));       
//     	  White_Pieces.add(new Bishop(5,0,true,"B.png",this));
//    	  Black_Pieces.add(new Bishop(2,7,false,"B.png",this));        
//     	  Black_Pieces.add(new Bishop(5,7,false,"B.png",this));
        
        
       //==========================KING+QUEEN========================
        
//        White_Pieces.add(new King(3,0,true,"K.png",this));
//        White_Pieces.add(new Queen(4,0,true,"Q.png",this));        
//        Black_Pieces.add(new King(3,7,false,"K.png",this));
//        Black_Pieces.add(new Queen(4,7,false,"Q.png",this));
    }

    public Board(boolean gameMode) {

        BoardGrid = new Integer[rows][cols];
        Static_Shapes = new ArrayList();
        Piece_Graphics = new ArrayList();
        White_Pieces = new ArrayList();
        Black_Pieces = new ArrayList();
        
        if(gameMode == true) {
        	this.gameMode = true;
        	initGrid();
        	this.addMouseListener(mouseAdapter);
        	this.setPreferredSize(new Dimension(520, 520));
        	drawBoard();
        }
        else {
        	this.gameMode = false;
        	initGrid();
        	//drawBoard();
        	//drawBoard();
        	this.setPreferredSize(new Dimension(520, 520));
        	while(true){
        	drawBoard();
        	gameLoop();
        }
        	//drawBoard();
        	
        }

        
        //this.addMouseListener(mouseAdapter);
    }
    
    public boolean getGamemode() {
    	return gameMode;
    }
    
    
    
    //REFRESHES BOARD IMAGES
    private void drawBoard()
    {
        Piece_Graphics.clear();
        Static_Shapes.clear();
        
        //STATIC BOARD IMAGE
        Image board = loadImage(board_file_path);
        Static_Shapes.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null))));
        
        //PAINT ACTIVE SQUARE IN CORRECT LOCATION
        if (Active_Piece != null)
        {
            Image activesquare = loadImage("images" + File.separator + "activesquare.png");
            Static_Shapes.add(new DrawingImage(activesquare, new Rectangle2D.Double(Square_Width*Active_Piece.getX(),Square_Width*Active_Piece.getY(), activesquare.getWidth(null), activesquare.getHeight(null))));
        }
        //PAINT THE PIECES ON THE BOARD IN CORRECT LOCATION
        //WHITE PIECES
        for (int i = 0; i < White_Pieces.size(); i++)
        {
            int COL = White_Pieces.get(i).getX();
            int ROW = White_Pieces.get(i).getY();
            Image piece = loadImage("images" + File.separator + "w_pieces" + File.separator + White_Pieces.get(i).getFilePath());  
            Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width*COL,Square_Width*ROW, piece.getWidth(null), piece.getHeight(null))));
        }
        //BLACK PIECES
        for (int i = 0; i < Black_Pieces.size(); i++)
        {
            int COL = Black_Pieces.get(i).getX();
            int ROW = Black_Pieces.get(i).getY();
            Image piece = loadImage("images" + File.separator + "b_pieces" + File.separator + Black_Pieces.get(i).getFilePath());  
            Piece_Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width*COL,Square_Width*ROW, piece.getWidth(null), piece.getHeight(null))));
        }
        this.repaint();
    }

    
    public Piece getPiece(int x, int y) {
        for (Piece p : White_Pieces)
        {
            if (p.getX() == x && p.getY() == y)
            {
                return p;
            }
        }
        for (Piece p : Black_Pieces)
        {
            if (p.getX() == x && p.getY() == y)
            {
                return p;
            }
        }
        return null;
    }
    
    //Main game loop revolves around player's click. When a valid move is made, the next player may click
    private MouseAdapter mouseAdapter = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {
        	boolean attackBoard[][] = new boolean[8][8];
        	//COORDINATES OF MOUSE CLICK
            int d_X = e.getX();
            int d_Y = e.getY();
            //VARIABLES FOR CALCULATION OF SQUARE CLICKED
            int Clicked_Row = d_Y / Square_Width;
            int Clicked_Column = d_X / Square_Width;
            //WHOSE TURN IS IT
            boolean is_whites_turn = true;
            Piece clicked_piece = getPiece(Clicked_Column, Clicked_Row);

            
            
            
            
            
            
            //boolean causesCheck = true;
            
            if (turnCounter%2 == 1)
            {
                is_whites_turn = false;
            }
                    
            
            
            //select piece on click
            if (Active_Piece == null && clicked_piece != null && 
                    ((is_whites_turn && clicked_piece.isWhite()) || (!is_whites_turn && clicked_piece.isBlack())))
            {
            	Active_Piece = clicked_piece;
            }
            //De-select piece on click
            else if (Active_Piece != null && Active_Piece.getX() == Clicked_Column && Active_Piece.getY() == Clicked_Row)
            {
                Active_Piece = null;
            }

            //if the piece is white on white's turn or black on black's turn and can move 
            else if (Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row)
                    && ((is_whites_turn && Active_Piece.isWhite()) || (!is_whites_turn && Active_Piece.isBlack())))
            {
            		Piece possRemoved = clicked_piece;
            		if (clicked_piece != null) {

            			if (clicked_piece.isWhite())
            			{
            				possRemoved = clicked_piece;
            				White_Pieces.remove(clicked_piece);
            			}
            			else
            			{
            				possRemoved = clicked_piece;
            				Black_Pieces.remove(clicked_piece);
            			}
            		}


                    int initialX=Active_Piece.getX();
                    int initialY=Active_Piece.getY();
            		// do move
            		Active_Piece.setX(Clicked_Column);
            		Active_Piece.setY(Clicked_Row);

            		if (Active_Piece.getClass().equals(Pawn.class))
            		{
            			Pawn castedPawn = (Pawn)(Active_Piece);
            			castedPawn.setHasMoved(true);
            		}
            		boolean check = false;
            		
            		
            		//THIS AWESOME CODE CHECKS IF THE KING IS IN CHECK AFTER THE SUGGESTED MOVE!!!!!!!!!!
            		if(is_whites_turn) {
                    	attackBoard = AttackedPieces.attackedFields(Black_Pieces);
                		int kingX = 0;
                		int kingY = 0;
                		for(Piece p: White_Pieces) {
                			if(p.getClass().equals(King.class)) {
                				kingX = p.getX();
                				kingY = p.getY();
                			}
                		}
                		if(attackBoard[kingY][kingX] == true) {
                			Active_Piece.setX(initialX);
                			Active_Piece.setY(initialY);
                			if(possRemoved != null) {
                				Black_Pieces.add(possRemoved);
                			}
                			check = true;
                		}
                	}
                	else {

                    	attackBoard = AttackedPieces.attackedFields(White_Pieces);
                		int kingX = 0;
                		int kingY = 0;
                		for(Piece p: Black_Pieces) {
                			if(p.getClass().equals(King.class)) {
                				kingX = p.getX();
                				kingY = p.getY();
                			}
                		}
                		if(attackBoard[kingY][kingX] == true) {
                			Active_Piece.setX(initialX);
                			Active_Piece.setY(initialY);
                			if(possRemoved != null) {
                				White_Pieces.add(possRemoved);
                			}
                			check = true;
                		}
            		
            	}
            	if(check == false) {
            		Active_Piece = null;
            		turnCounter++;
            	}
        
            }          
        drawBoard();
        }
    };
    
    
    
    
    public void gameLoop() {
    	initGrid();
    	Scanner scan = new Scanner(System.in);
    	boolean is_whites_turn = true;
    	boolean attackBoard[][] = new boolean[8][8];
    	System.out.println("It is white's turn: " + is_whites_turn);
    	
    	System.out.println("Enter square to select X: ");
        int Clicked_Row = scan.nextInt();
        System.out.println("Enter square to select Y: ");
        int Clicked_Column = scan.nextInt();
        //VARIABLES FOR CALCULATION OF SQUARE CLICKED
        
        
        //System.out.println("Enter location to move X: ");
        //int Clicked_Row = d_X;
        //System.out.println("Enter location to move Y: ");
        //int Clicked_Column = d_Y;
        //WHOSE TURN IS IT
        
        Piece clicked_piece = getPiece(Clicked_Column, Clicked_Row);
        
        
        
        
        
        
        
        //boolean causesCheck = true;
        
        if (turnCounter%2 == 1)
        {
            is_whites_turn = false;
        }
                
        
        
        //select piece on click
        if (Active_Piece == null && clicked_piece != null && 
                ((is_whites_turn && clicked_piece.isWhite()) || (!is_whites_turn && clicked_piece.isBlack())))
        {
        	Active_Piece = clicked_piece;
        }
        //De-select piece on click
        else if (Active_Piece != null && Active_Piece.getX() == Clicked_Column && Active_Piece.getY() == Clicked_Row)
        {
            Active_Piece = null;
        }

        //if the piece is white on white's turn or black on black's turn and can move 
        else if (Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row)
                && ((is_whites_turn && Active_Piece.isWhite()) || (!is_whites_turn && Active_Piece.isBlack())))
        {
        		Piece possRemoved = clicked_piece;
        		if (clicked_piece != null) {

        			if (clicked_piece.isWhite())
        			{
        				possRemoved = clicked_piece;
        				White_Pieces.remove(clicked_piece);
        			}
        			else
        			{
        				possRemoved = clicked_piece;
        				Black_Pieces.remove(clicked_piece);
        			}
        		}


                int initialX=Active_Piece.getX();
                int initialY=Active_Piece.getY();
        		// do move
        		Active_Piece.setX(Clicked_Column);
        		Active_Piece.setY(Clicked_Row);

        		if (Active_Piece.getClass().equals(Pawn.class))
        		{
        			Pawn castedPawn = (Pawn)(Active_Piece);
        			castedPawn.setHasMoved(true);
        		}
        		boolean check = false;
        		
        		
        		//THIS AWESOME CODE CHECKS IF THE KING IS IN CHECK AFTER THE SUGGESTED MOVE!!!!!!!!!!
        		if(is_whites_turn) {
                	attackBoard = AttackedPieces.attackedFields(Black_Pieces);
            		int kingX = 0;
            		int kingY = 0;
            		for(Piece p: White_Pieces) {
            			if(p.getClass().equals(King.class)) {
            				kingX = p.getX();
            				kingY = p.getY();
            			}
            		}
            		if(attackBoard[kingY][kingX] == true) {
            			Active_Piece.setX(initialX);
            			Active_Piece.setY(initialY);
            			if(possRemoved != null) {
            				Black_Pieces.add(possRemoved);
            			}
            			check = true;
            		}
            	}
            	else {

                	attackBoard = AttackedPieces.attackedFields(White_Pieces);
            		int kingX = 0;
            		int kingY = 0;
            		for(Piece p: Black_Pieces) {
            			if(p.getClass().equals(King.class)) {
            				kingX = p.getX();
            				kingY = p.getY();
            			}
            		}
            		if(attackBoard[kingY][kingX] == true) {
            			Active_Piece.setX(initialX);
            			Active_Piece.setY(initialY);
            			if(possRemoved != null) {
            				White_Pieces.add(possRemoved);
            			}
            			check = true;
            		}
        		
        	}
        	if(check == false) {
        		Active_Piece = null;
        		turnCounter++;
        	}
        }          
    drawBoard();
    }
    
    
    
    
    
    
    
    
        
        
      
    private Image loadImage(String imageFile) {
        try {
                return ImageIO.read(new File(imageFile));
        }
        catch (IOException e) {
                return NULL_IMAGE;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        drawBackground(g2);
        drawShapes(g2);
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(getBackground());
        g2.fillRect(0,  0, getWidth(), getHeight());
    }
       

    private void drawShapes(Graphics2D g2) {
        for (DrawingShape shape : Static_Shapes) {
            shape.draw(g2);
        }	
        for (DrawingShape shape : Piece_Graphics) {
            shape.draw(g2);
        }
    }

}



interface DrawingShape {
    boolean contains(Graphics2D g2, double x, double y);
    void adjustPosition(double dx, double dy);
    void draw(Graphics2D g2);
}


class DrawingImage implements DrawingShape {

    public Image image;
    public Rectangle2D rect;

    public DrawingImage(Image image, Rectangle2D rect) {
            this.image = image;
            this.rect = rect;
    }

    @Override
    public boolean contains(Graphics2D g2, double x, double y) {
            return rect.contains(x, y);
    }

    @Override
    public void adjustPosition(double dx, double dy) {
            rect.setRect(rect.getX() + dx, rect.getY() + dy, rect.getWidth(), rect.getHeight());	
    }

    @Override
    public void draw(Graphics2D g2) {
            Rectangle2D bounds = rect.getBounds2D();
            g2.drawImage(image, (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(),
                                            0, 0, image.getWidth(null), image.getHeight(null), null);
    }	
}




