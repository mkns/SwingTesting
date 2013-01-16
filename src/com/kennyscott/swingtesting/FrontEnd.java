package com.kennyscott.swingtesting;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.util.concurrent.ExecutionException;
import java.awt.FlowLayout;

public class FrontEnd extends JFrame {

	private static final long serialVersionUID = 1935238500289454070L;
	private JPanel contentPane;
	JLabel workerLabel;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontEnd frame = new FrontEnd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrontEnd() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open...");
		mnFile.add(mntmOpen);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About...");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblStatusBar = new JLabel("Status Bar");
		panel.add(lblStatusBar);

		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.WEST);

		JButton btnUpdatePanel = new JButton("Update Panel");
		btnUpdatePanel.addActionListener(new ButtonPressActionListener(this));
		panel_1.add(btnUpdatePanel);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		workerLabel = new JLabel("");
		panel_2.add(workerLabel);
	}

	void updateWorkerLabel(TestSwingWorker tsw) throws InterruptedException, ExecutionException {
		workerLabel.setText(tsw.get());
	}

	public void installNewPanel() {
		getContentPane().add(new NewPanel(), BorderLayout.CENTER);
		((JComponent) getContentPane()).revalidate();
	}

}
