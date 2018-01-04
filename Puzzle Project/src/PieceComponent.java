
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PieceComponent extends JLabel{

	private Piece piece;
	private BufferedImage buffImage;
	private Image image;
	private int currentScale = 121;
	private int orientation;
	private int order;
	
	
	public PieceComponent(String imageFile, Piece piece, int order) {
		try {
		    this.buffImage = ImageIO.read(new File(imageFile));
		    this.image = buffImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.piece = piece;
		this.orientation = 0;
		this.order = order;
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(this.image,0,0,null);
	}
	
	public void rotateClockwise() {
		piece.rotateClockwise();
		rotateGraphicsClockwise();
	}
	
	public void rotateCounterClockwise() {
		piece.rotateCounterClockwise();
		rotateGraphicsCounterClockwise();
	}
	
	public void rotateGraphicsClockwise() {
		orientation = (orientation + 1) % 4;
		AffineTransform tx = new AffineTransform();
	    tx.rotate(Math.PI / 2, this.buffImage.getWidth() / 2, this.buffImage.getHeight() / 2);

	    AffineTransformOp op = new AffineTransformOp(tx,
	        AffineTransformOp.TYPE_BILINEAR);
	    this.buffImage = op.filter(this.buffImage, null);
	    image = Toolkit.getDefaultToolkit().createImage(buffImage.getSource());
	    scaleImage(currentScale);
	    this.repaint();
	}
	
	public void rotateGraphicsCounterClockwise() {
		orientation = (orientation + 3) % 4;
		AffineTransform tx = new AffineTransform();
	    tx.rotate(-Math.PI / 2, this.buffImage.getWidth() / 2, this.buffImage.getHeight() / 2);

	    AffineTransformOp op = new AffineTransformOp(tx,
	        AffineTransformOp.TYPE_BILINEAR);
	    this.buffImage = op.filter(this.buffImage, null);
	    image = Toolkit.getDefaultToolkit().createImage(buffImage.getSource());
	    scaleImage(currentScale);
	    this.repaint();
	}
	
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void scaleImage(int n) {
		this.currentScale = n;
		this.setSize(n, n);
		image = image.getScaledInstance(n,n,Image.SCALE_REPLICATE);
	}
	
	public String toString() {
		return piece.toString();
	}
	
	public int getOrientation() {
		return this.orientation;
	}
	
	public int getOrder() {
		return order;
	}

}
