package boj_submitter.views;

import java.awt.Label;
import java.awt.Panel;

/**
 * 백준 온라인 저지 번 () 문제풀이
 *
 * @see https://www.acmicpc.net/problem/
 * @author devetude
 */
public class MainSpinnerPanel extends Panel {
	private Label msgLabel;

	public MainSpinnerPanel(int width, int height) {
		this.setLayout(null);
		this.setBounds(0, 0, width, height);

		msgLabel = new Label();
		msgLabel.setBounds(0, (height - 40) / 2, width, 40);
		msgLabel.setAlignment(Label.CENTER);
		msgLabel.setText("asdfasdfasdf");
	}
}