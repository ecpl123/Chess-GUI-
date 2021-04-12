package chess;

public class Chess {
    
    public BoardFrame boardframe;
    public static void main(String[] args) {
        Chess c = new Chess();
        c.boardframe = new BoardFrame(true, true, true);
        c.boardframe.setVisible(true);
        
    }
}
