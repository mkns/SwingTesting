package com.kennyscott.swingtesting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPressActionListener implements ActionListener {

	FrontEnd frontEnd;

	public ButtonPressActionListener(FrontEnd frontEnd) {
		this.frontEnd = frontEnd;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frontEnd.installNewPanel();
		TestSwingWorker tsw = new TestSwingWorker(frontEnd);
		tsw.execute();
	}

}
