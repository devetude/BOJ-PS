package views;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainDialog extends Dialog {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 100;

	private static final String DIALOG_TITLE = "Notice";

	public MainDialog(Frame owner, String msg) {
		super(owner);

		this.setTitle(DIALOG_TITLE);
		this.setResizable(false);
		this.setLayout(null);
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((windowSize.width - WIDTH) / 2, (windowSize.height - HEIGHT) / 2, WIDTH, HEIGHT);

		Label msgLabel = new Label(msg);
		msgLabel.setBounds(25, 50, 250, 20);
		msgLabel.setFont(new Font(null, Font.PLAIN, 18));
		msgLabel.setAlignment(Label.CENTER);
		this.add(msgLabel);

		this.addWindowListener(new WindowListener() {
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
		});

		this.setVisible(true);
	}
}
