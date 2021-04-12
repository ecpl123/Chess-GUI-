package chess;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;

public class BoardFrame extends JFrame {
    public Component c;
    private boolean resizeable;
    private boolean visible;
//    public BoardFrame()
//    {
//    	c = new Board();
//        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        this.setResizable(false);
//        this.add(c, BorderLayout.CENTER);
//        this.pack();
//        this.setLocation(700, 200);
//        //this.setVisible(true);
//    }
    public BoardFrame(boolean resizeable, boolean visible, boolean gameMode)
    {
    	c = new Board(gameMode);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(resizeable);
        this.resizeable = resizeable;
        this.visible = visible;
        this.add(c, BorderLayout.CENTER);
        this.pack();
        this.setLocation(700, 200);
        this.setVisible(visible);
    }
    public boolean getResizeable() {
    	return this.resizeable;
    }
    public boolean getVisible() {
    	return this.visible;
    }
}
