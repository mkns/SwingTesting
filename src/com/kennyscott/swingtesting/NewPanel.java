package com.kennyscott.swingtesting;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.Color;

public class NewPanel extends JPanel {

	private static final long serialVersionUID = 5506155969250117670L;

	public NewPanel() {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextPane txtpnIAmThe = new JTextPane();
		txtpnIAmThe.setText("I am the new JPanel!");
		add(txtpnIAmThe);

	}

}
