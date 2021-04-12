package chess;

import java.util.ArrayList;

import chess.pieces.Piece;

public class AttackedPieces {

	public static boolean[][] attackedFields(ArrayList<Piece> Pieces){
		boolean attackBoard[][] = new boolean[8][8];
		Pieces.forEach((piece) -> {
				boolean currentAttackBoard[][] = piece.attackedSquares();
				
				for(int y = 0; y < 8; y++) {
					for(int x = 0; x < 8; x++) {
						if(currentAttackBoard[y][x] == true) {
							attackBoard[y][x] = true;
						}
					}
				}
		});
		
		return attackBoard;
	}
	
//	public void print() {
//		this.attackedFields();
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
//		System.out.print("\n=================================================================\n");
//	}
}
