import java.awt.Component;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HolderPanel extends JPanel {
	
	private static List<PieceComponent> pieces;
	
	public HolderPanel(List<PieceComponent> pieces) {
		this.pieces = pieces;
	}	
	
	public void initialize() {
		for (PieceComponent p : pieces) {
			this.add(p);
		}
	}
	
	
	public void addToPanel(PieceComponent p) {
		pieces.add(p);
		this.add(p);
		this.repaint();
		this.revalidate();
	}
	
	public void removeFromPanel(PieceComponent p) {
		for (int i = 0; i < pieces.size(); i++) {
			if (pieces.get(i).equals(p)) {
				pieces.remove(i);
			}
		}
		this.remove(p);
		this.repaint();
	}
	
	public void reset() {
		for (PieceComponent pieceComp : this.pieces) {
			for (int i = pieceComp.getOrientation(); i < 4; i++) {
				pieceComp.rotateClockwise();
			}
		}
		this.removeAll();
		this.sort();
		for (PieceComponent p : pieces) {
			this.add(p);
		}
		this.revalidate();
		this.repaint();
	}
	
	public void sort() {
		for (int fixedIndex = 0; fixedIndex < pieces.size(); fixedIndex++){
			int smallestIndex = fixedIndex;
			
			for (int checkIndex = fixedIndex + 1; checkIndex < pieces.size(); checkIndex++){
				if (pieces.get(smallestIndex).getOrder() != fixedIndex) {
					smallestIndex = checkIndex;
				}
			}
			PieceComponent temp = pieces.set(fixedIndex, pieces.get(smallestIndex));
			pieces.set(smallestIndex, temp);
		}
	}
	
	public void randomize() {
		this.removeAll();
		for (int i = 0; i < pieces.size(); i++) {
			int randInt = (int)(Math.random() * pieces.size()) ;
			PieceComponent temp = pieces.get(i);
			pieces.set(i, pieces.get(randInt));
			pieces.set(randInt, temp);
		}
		for (PieceComponent p : pieces) {
			this.add(p);
		}
		this.revalidate();
		this.repaint();
	}
	
	public boolean isFull() {
		return (pieces.size() == 9);
	}

}
