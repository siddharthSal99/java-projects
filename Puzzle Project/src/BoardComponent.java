

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class BoardComponent extends JComponent {

	private Puzzle puzzle;
	private HolderPanel holderPanel;
	private PieceComponent[][] pieces = new PieceComponent[3][3];


	public BoardComponent(Puzzle puzzle, HolderPanel holderPanel){
		this.puzzle = puzzle;
		this.holderPanel = holderPanel;
	}

	public void paintComponent(Graphics g){


		int width = this.getWidth();
		int height = this.getHeight();

		int leftX = width / 3;
		int rightX = 2 * width / 3;
		int topY = height / 3;
		int bottomY = 2 * height / 3;


		Graphics2D g2 = (Graphics2D) g; 

		g2.drawRect(0,0,width-1, height-1);

		// drawing horizontal lines
		g2.drawLine(0,topY, width,topY);
		g2.drawLine(0,bottomY,width,bottomY);

		// drawing vertical lines
		g2.drawLine(leftX,0,leftX,height);
		g2.drawLine(rightX,0,rightX,height);

	}


	public boolean doesFit(PieceComponent piece, int row, int col) {
		return ((row > -1 && col > -1) 
				&& puzzle.doesFit(piece.getPiece(), row, col) 
				&& pieces[row][col] == null);
	}


	public PieceComponent setPieceComp(PieceComponent pieceComp, int row, int col) {
		puzzle.setPiece(pieceComp.getPiece(), row, col);
		pieces[row][col] = pieceComp;
		return pieceComp;
	}

	public PieceComponent getPieceComp(int row, int col) {
		return pieces[row][col];
	}

	public PieceComponent removePieceComp(int row, int col) {
		puzzle.removePiece(row, col);
		PieceComponent tempPiece = pieces[row][col];
		pieces[row][col] = null;
		return tempPiece;
	}

	public void reset() {
		puzzle.reset();
		for (int row = 0; row < pieces.length; row++) {
			for (int col = 0; col < pieces[0].length; col++) {
				PieceComponent pieceComp = getPieceComp(row,col);
				if (pieceComp != null) {
					Container c = pieceComp.getParent();
					c.remove(pieces[row][col]);
					pieceComp.scaleImage(121);
					removePieceComp(row,col);
					holderPanel.addToPanel(pieceComp);
					c.repaint();
				}
			}
		}
	}


	public boolean isSolved() {
		return puzzle.isSolved();
	}


	/*
	 * Solves the puzzle:
	 *  - The Puzzle now holds all the Piece Objects in the right spots
	 *  - BoardComponent now holds the PieceComponent equivalents in 
	 *  the correct spots
	 */
	public void solve() {
		List<PieceComponent> pieceCompList = Display.pieceComps;
		puzzle.solve();

		for (int row = 0; row < pieces.length; row++) {
			for (int col = 0; col < pieces[0].length; col++) {
				boolean fits = false;	
				for (int i = 0; !fits && i < pieceCompList.size(); i++) {
					PieceComponent pieceComp = pieceCompList.get(i);
					if (areEqual(puzzle.getPiece(row, col),pieceComp)){
						setPieceComp(pieceComp, row, col);
						holderPanel.removeFromPanel(pieceComp);
						fits = true;
					}
				}
			}
		}
	}
	
	
	/*
	 * Checks if a Piece object and a PieceComponent has that same Piece
	 */
	public static boolean areEqual(Piece piece, PieceComponent pieceComp) {
		boolean areEqual = false;
		if (pieceComp.getPiece().equals(piece)) {
			areEqual = true;
			for (int i = pieceComp.getOrientation(); i < piece.getOrientation(); i++) {
				pieceComp.rotateGraphicsClockwise();
			}
		}
		return areEqual;
	}

	
	
	public static void main(String[] args) {
//		
//		ArrayList<PieceComponent> pieces = new ArrayList<PieceComponent>();
//
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_1.png", new Piece(Side.CLUBOUT, Side.HEARTOUT, Side.DIAMONDIN, Side.CLUBIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_2.png", new Piece(Side.SPADEOUT, Side.DIAMONDOUT, Side.SPADEIN, Side.HEARTIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_3.png", new Piece(Side.HEARTOUT, Side.SPADEOUT, Side.HEARTIN, Side.CLUBIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_4.png", new Piece(Side.HEARTOUT, Side.DIAMONDOUT, Side.CLUBIN, Side.CLUBIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_5.png", new Piece(Side.SPADEOUT, Side.SPADEOUT, Side.HEARTIN, Side.CLUBIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_6.png", new Piece(Side.HEARTOUT, Side.DIAMONDOUT, Side.DIAMONDIN, Side.HEARTIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_7.png", new Piece(Side.SPADEOUT, Side.DIAMONDOUT, Side.HEARTIN, Side.DIAMONDIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_8.png", new Piece(Side.CLUBOUT, Side.HEARTOUT, Side.SPADEIN, Side.HEARTIN)));
//		pieces.add(new PieceComponent("resources\\puzzle pieces\\piece_9.png", new Piece(Side.DIAMONDOUT, Side.CLUBOUT, Side.CLUBIN, Side.DIAMONDIN)));
//
//		
//		Piece piece = new Piece(Side.CLUBOUT, Side.HEARTOUT, Side.DIAMONDIN, Side.CLUBIN);
//		System.out.println(areEqual(piece,pieces.get(1)));
//		ArrayList<Piece> x = new ArrayList<Piece>();
//		x.add(new Piece(Side.CLUB_OUT, Side.HEART_OUT, Side.DIAMOND_IN, Side.CLUB_IN));
//		x.add(new Piece(Side.SPADE_OUT, Side.DIAMOND_OUT, Side.SPADE_IN, Side.HEART_IN));
//		x.add(new Piece(Side.HEART_OUT, Side.SPADE_OUT, Side.SPADE_IN, Side.CLUB_IN));
//		x.add(new Piece(Side.HEART_OUT, Side.DIAMOND_OUT, Side.CLUB_IN, Side.CLUB_IN));
//		x.add(new Piece(Side.SPADE_OUT, Side.SPADE_OUT, Side.HEART_IN, Side.CLUB_IN));
//		x.add(new Piece(Side.HEART_OUT, Side.DIAMOND_OUT, Side.DIAMOND_IN, Side.HEART_IN));
//		x.add(new Piece(Side.SPADE_OUT, Side.DIAMOND_OUT, Side.HEART_IN, Side.DIAMOND_IN));
//		x.add(new Piece(Side.CLUB_OUT, Side.HEART_OUT, Side.SPADE_IN, Side.HEART_IN));
//		x.add(new Piece(Side.DIAMOND_OUT, Side.CLUB_OUT, Side.CLUB_IN, Side.DIAMOND_IN));
//		Puzzle p = new Puzzle(3, 3, x);
//		for(int row =0; row< p.getRows();row++){
//			for(int col = 0; col < p.getCols(); col++){
//				System.out.println(p.getPiece(row, col));
//			}
//		}
//		p.solve();
//		for(int row =0; row< p.getRows();row++){
//			for(int col = 0; col < p.getCols(); col++){
//				System.out.println(p.getPiece(row, col));
//			}
//		}
//		System.out.println(p);
	}







}
