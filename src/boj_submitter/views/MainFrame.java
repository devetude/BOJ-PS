package boj_submitter.views;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import boj_submitter.controllers.Process;
import boj_submitter.res.User;

public class MainFrame extends Frame {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 270;

	private static final String FRAME_TITLE = "BOJ Submitter";
	private static final String PROBLEM_ID_LABEL = "Problem ID";
	private static final String BOJ_ID_LABEL = "BOJ ID";
	private static final String BOJ_PW_LABEL = "BOJ PW";
	private static final String SUBMIT_BUTTON = "Submit";

	private static final String FAIL_TO_READ_CODE = "Fail to read code.";
	private static final String FAIL_TO_LOGIN_BOJ = "Fail to login boj.";
	private static final String FAIL_TO_SUBMIT = "Fail to submit.";
	private static final String SUBMIT_SUCCESS = "Submit success.";

	private TextField problemIDTextField;
	private TextField bojIDTextField;
	private TextField bojPasswordTextField;

	private MainSpinnerPanel mainSpinnerPanel;

	public MainFrame() {
		this.setTitle(FRAME_TITLE);
		this.setResizable(false);
		this.setLayout(null);
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((windowSize.width - WIDTH) / 2, (windowSize.height - HEIGHT) / 2, WIDTH, HEIGHT);

		Label problemIDLabel = new Label(PROBLEM_ID_LABEL);
		problemIDLabel.setBounds(25, 50, 90, 20);
		problemIDLabel.setFont(new Font(null, Font.PLAIN, 18));
		this.add(problemIDLabel);

		problemIDTextField = new TextField();
		problemIDTextField.setBounds(130, 50, 145, 20);
		this.add(problemIDTextField);

		Label bojIDLabel = new Label(BOJ_ID_LABEL);
		bojIDLabel.setBounds(25, 100, 90, 20);
		bojIDLabel.setFont(new Font(null, Font.PLAIN, 18));
		this.add(bojIDLabel);

		bojIDTextField = new TextField(User.BOJ_ID);
		bojIDTextField.setBounds(130, 100, 145, 20);
		this.add(bojIDTextField);

		Label bojPasswordLabel = new Label(BOJ_PW_LABEL);
		bojPasswordLabel.setBounds(25, 150, 90, 20);
		bojPasswordLabel.setFont(new Font(null, Font.PLAIN, 18));
		this.add(bojPasswordLabel);

		bojPasswordTextField = new TextField(User.BOJ_PASSWORD);
		bojPasswordTextField.setEchoChar('*');
		bojPasswordTextField.setBounds(130, 150, 145, 20);
		this.add(bojPasswordTextField);

		Button submitButton = new Button(SUBMIT_BUTTON);
		submitButton.setBounds(75, 200, 150, 40);
		submitButton.addActionListener(new SubmitButtonActionListener(this));
		this.add(submitButton);

		this.addWindowListener(new MainWindowListener());

		mainSpinnerPanel = new MainSpinnerPanel(WIDTH, HEIGHT);
		this.add(mainSpinnerPanel);

		this.setVisible(true);
	}

	private class MainWindowListener implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}
	}

	private class SubmitButtonActionListener implements ActionListener {
		private MainFrame mainFrame;

		public SubmitButtonActionListener(MainFrame mainFrame) {
			this.mainFrame = mainFrame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			mainSpinnerPanel.setVisible(true);

			String problemID = problemIDTextField.getText();
			String source = Process.getSource(problemID);

			if (source == null) {
				new MainDialog(mainFrame, FAIL_TO_READ_CODE);
			}

			else if (!Process.signIn(bojIDTextField.getText(), bojPasswordTextField.getText())) {
				new MainDialog(mainFrame, FAIL_TO_LOGIN_BOJ);
			}

			else if (!Process.submit(problemID, source)) {
				new MainDialog(mainFrame, FAIL_TO_SUBMIT);
			}

			else {
				new MainDialog(mainFrame, SUBMIT_SUCCESS);
			}
		}
	}
}