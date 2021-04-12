package chess;

import chess.pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.BorderLayout;
import java.awt.Component;

import org.junit.jupiter.api.Test;

class BoardTest {
	
	
	@Test
	void testBoardFrame() {
		BoardFrame boardframe = new BoardFrame(true, true, true);
		
		assertEquals(javax.swing.WindowConstants.DISPOSE_ON_CLOSE, boardframe.getDefaultCloseOperation());
		assertTrue(boardframe.getResizeable());
		assertEquals(700, boardframe.getX());
		assertEquals(200, boardframe.getY());
		assertTrue(boardframe.getVisible());
		try {
			Component c = new Board(true);
			boardframe.add(c, BorderLayout.CENTER);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testPawn() {
		BoardFrame boardframe = new BoardFrame(true, true, true);
		
	}
	
	
	

}
