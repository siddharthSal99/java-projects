import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class DragListener extends MouseInputAdapter {

	private PieceComponent piece;
	private HolderPanel holderPanel;
	private JLayeredPane layeredPane;
	private JPanel puzzlePanel;
	private BoardComponent boardComponent;
	private TimerPanel timerPanel;
	
	private int boardStartX = 407;
	private int boardStartY = 74;
	
	private final int xGap = 150;
	private final int yGap = 150;
	
	private final int placeShiftX = 307;
	private final int placeShiftY = 24;

	private int clickShiftX;
	private int clickShiftY;

	private int scale = 252;

	private boolean isPressed = false;
	private boolean pickedUpFromBoard = false;
	
	private boolean solver = false;

	public DragListener(JLayeredPane layeredPane,
			HolderPanel holderPanel, 
			JPanel puzzlePanel,
			BoardComponent boardComponent,
			TimerPanel timerPanel) {
		this.layeredPane = layeredPane;
		this.holderPanel = holderPanel;
		this.puzzlePanel = puzzlePanel;
		this.boardComponent = boardComponent;
		this.timerPanel = timerPanel;
		

	}






	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 * 
	 * MOUSE PRESSED
	 * 
	 */
	public void mousePressed(MouseEvent e)
	{
		if (solver) return;
		if (SwingUtilities.isRightMouseButton(e)) {
			if (piece != null) {
				piece.rotateClockwise();
				return;
			}
			Component c = e.getComponent();
			if (c instanceof HolderPanel) {
				c =  c.getComponentAt(e.getX(), e.getY());
				if (c instanceof PieceComponent) {
					piece = (PieceComponent)c;
					piece.rotateClockwise();
					pickedUpFromBoard = false;
					piece = null;
				}
				return;
			}
			else {
				return;
			}
		} 
		if (!isPressed) {
			isPressed = true;
			piece = null;
			
			// Gets the PieceComponent from the holder and sends to Drag Layer
			Component c =  e.getComponent();
			if (c instanceof HolderPanel) {
				c = holderPanel.getComponentAt(e.getX(),e.getY());
				if (c instanceof PieceComponent) {
					clickShiftX = -57;
					clickShiftY = -32;
					piece = (PieceComponent)c;
					
					holderPanel.removeFromPanel(piece);
					piece.setLocation(e.getX() + clickShiftX, e.getY() + clickShiftY);
					layeredPane.add(piece, JLayeredPane.DRAG_LAYER);
				}
				return;
			}

			// Gets the PieceComponent from the BoardComponent to drag around
			if (c instanceof JPanel) {
				c = boardComponent.getComponentAt(e.getX(), e.getY());
				
				Point rowCol = toRowCol(e.getPoint(),false);
				int row = rowCol.x;
				int col = rowCol.y;
				clickShiftX = 135;
				clickShiftY = -120;

				if (row > -1 && col > -1) {
					
					piece = boardComponent.getPieceComp(row, col);
					if (piece == null) return;
					pickedUpFromBoard = true;
					boardComponent.removePieceComp(row,col);

					puzzlePanel.remove(piece);
					puzzlePanel.validate();
					puzzlePanel.repaint();
					
					piece.setLocation(e.getX() + clickShiftX, e.getY() + clickShiftY);
					layeredPane.add(piece, JLayeredPane.DRAG_LAYER);
				}
				return;
			}


		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent me)
	{
		if (piece == null || solver) return;

		int x = me.getX() + clickShiftX;
		int xMax = layeredPane.getWidth() - piece.getWidth();
		x = Math.min(x, xMax);
		x = Math.max(x, 0);

		int y = me.getY() + clickShiftY;
		int yMax = layeredPane.getHeight() - piece.getHeight();
		y = Math.min(y, yMax);
		y = Math.max(y, 0);

		piece.setLocation(x, y);
	}

	public void mouseReleased(MouseEvent e)
	{
		if (SwingUtilities.isRightMouseButton(e) || solver) {
			return;
		}
		if (isPressed) {
			isPressed = false;
			if (piece == null) return;

			piece.setVisible(false);
			layeredPane.remove(piece);
			piece.setVisible(true);
			layeredPane.repaint();
			layeredPane.revalidate();


			int xMax = layeredPane.getWidth() - piece.getWidth();
			int x = Math.min(e.getX(), xMax);
			if (pickedUpFromBoard) x += 260;
			x = Math.max(x, 0);

			int yMax = layeredPane.getHeight() - piece.getHeight();
			int y = Math.min(e.getY(), yMax);
			if (pickedUpFromBoard) y -= 23;
			y = Math.max(y, 0);

			
			toBoard(piece,toRowCol(new Point(x,y),true));
			pickedUpFromBoard = false;
			piece = null;
			if (boardComponent.isSolved()) {
				Display.solved();
			}
			
		}
	}
	
	
	/*
	 * Displays the image for a PieceComponent at a row and col.
	 */
	public void displayImage(PieceComponent pieceComp, Point rowCol) {
		pieceComp.scaleImage(scale);
		Point xYCoords = toXY(rowCol);
		pieceComp.setLocation(xYCoords.x,xYCoords.y);
		puzzlePanel.add(pieceComp);
		puzzlePanel.setComponentZOrder(pieceComp, 0);
	}
	
	/*
	 * Updates the image onto the screen for each of the 
	 * PieceComponents stored on the BoardComponent.
	 */
	public void updateBoardComponent() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				PieceComponent pieceComp = boardComponent.getPieceComp(row, col);
				if (pieceComp != null) {
					displayImage(pieceComp,new Point(row,col));
				}
			}
		}
		puzzlePanel.revalidate();
		puzzlePanel.repaint();
	}
	
	
	
	
	
	

	/*
	 * Adds the PieceComponent to the holderPanel on the side
	 */
	public void toHolder(PieceComponent piece) {
		piece.scaleImage(121);
		holderPanel.addToPanel(piece);
	}


	/*
	 * Converts an xy point into rows and colums. If the 
	 * PieceComponent was taken from the boardComponent, then
	 * re-added, the flag should be true, and the location is shifted.
	 */
	public Point toRowCol(Point xYPoint, boolean isPlaceOnBoard) {
		int boardStartX;
		int boardStartY;
		
		if (!isPlaceOnBoard) {
			boardStartX = 150;
			boardStartY = 100;
		} else {
			boardStartX = this.boardStartX;
			boardStartY = this.boardStartY;
		}
		int xPos = xYPoint.x;
		int yPos = xYPoint.y;

		if (yPos < boardStartY || yPos > boardStartY + 3*yGap) return new Point(-1,-1);
		if (xPos < boardStartX || xPos > boardStartX + 3*xGap) return new Point(-1,-1);

		if (yPos < boardStartY + yGap) {
			if (xPos < boardStartX + xGap) return new Point(0,0);
			else if (xPos < boardStartX + (2*xGap)) return new Point(0,1);
			else return new Point(0,2);
		}
		else if (yPos < boardStartY + 2*yGap) {
			if (xPos < boardStartX + xGap) return new Point(1,0);
			else if (xPos < boardStartX + (2*xGap)) return new Point(1,1);
			else return new Point(1,2);
		}
		else {
			if (xPos < boardStartX + xGap) return new Point(2,0);
			else if (xPos < boardStartX + (2*xGap)) return new Point(2,1);
			else return new Point(2,2);
		}
	}

	/*
	 * Converts a row(x) and column(y) point to xy(on the puzzlePanel) coordinates
	 */
	public Point toXY(Point rowCol) {	
		int row = rowCol.x;
		int col = rowCol.y;

		if (row == 0) {
			if (col == 0) return new Point(boardStartX - placeShiftX, boardStartY - placeShiftY);
			else if (col == 1) return new Point(boardStartX + xGap - placeShiftX, boardStartY - placeShiftY);
			else return new Point(boardStartX + 2*xGap - placeShiftX, boardStartY - placeShiftY);
		}
		else if (row == 1) {
			if (col == 0) return new Point(boardStartX - placeShiftX, boardStartY + yGap - placeShiftY);
			else if (col == 1) return new Point(boardStartX + xGap - placeShiftX, boardStartY + yGap - placeShiftY);
			else return new Point(boardStartX + 2*xGap - placeShiftX, boardStartY + yGap - placeShiftY);
		}
		else {
			if (col == 0) return new Point(boardStartX - placeShiftX, boardStartY + 2*yGap - placeShiftY);
			else if (col == 1) return new Point(boardStartX + xGap - placeShiftX, boardStartY + 2*yGap - placeShiftY);
			else if (col == 2) return new Point(boardStartX + 2*xGap - placeShiftX, boardStartY + 2*yGap - placeShiftY);
			return new Point(-2,-2);
		}
	}
		

	/*
	 * Tries to add a PieceComponent to the BoardComponent,
	 * if it doesnt fit, it gets stored back in the holder.
	 */
	public void toBoard(PieceComponent piece, Point rowCol) {
		if (boardComponent.doesFit(piece, rowCol.x, rowCol.y)) {
			displayImage(piece, rowCol);
			boardComponent.setPieceComp(piece, rowCol.x, rowCol.y);
			piece = null;
			if (!timerPanel.isRunning()) {
				timerPanel.setVisible(false);
			}
		}
		else {
			toHolder(piece);
			if (holderPanel.isFull()) {
				timerPanel.updateVisible(true);
			}
		}
	}






	/**
	 * @param solver the solver to set
	 */
	public void setSolver(boolean solver) {
		this.solver = solver;
	}








}
