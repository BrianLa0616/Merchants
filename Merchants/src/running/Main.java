package running;

import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import screens.ScreenHandler;

/**
 * @author Eylam, Brian, Ansen
 *
 *         Runs the program from its starting point
 */
public class Main {
	public static void main(String args[]) {
		ScreenHandler drawing = new ScreenHandler();
		PApplet.runSketch(new String[] { "" }, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setBounds(400, 0, 1100, 1030);
		window.setMinimumSize(new Dimension(0, 0));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();

	}
}
