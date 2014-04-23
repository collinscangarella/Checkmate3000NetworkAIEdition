package edu.mccc.cos210.fp2014.cm.menu;

import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * The class from which all menus extend from.
 * Includes common elements like closure behavior, background, etc.
 */
public abstract class SettingsView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected Checkmate myCheckmate;
	/**
	 * Constructor stores main JFrame so the View can be easily changed.
	 */
	public SettingsView(Checkmate c) {
		super();
		myCheckmate = c;
		setLayout(null);
		setBackground(new Color(137, 207, 240));
	}
}
