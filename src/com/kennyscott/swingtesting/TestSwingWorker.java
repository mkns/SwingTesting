package com.kennyscott.swingtesting;

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class TestSwingWorker extends SwingWorker<String, Object> {

	FrontEnd frontEnd;

	TestSwingWorker(FrontEnd frontEnd) {
		this.frontEnd = frontEnd;
	}

	@Override
	protected String doInBackground() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(4000);
		return "foo";
	}

	@Override
	protected void done() {
		try {
			frontEnd.updateWorkerLabel(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
