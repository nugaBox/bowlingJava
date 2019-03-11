package main;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;;

public class FrontView extends JFrame {

	JPanel titlePanel, firstPanel, inputPanel, scorePanel;
	JButton btnNewGame, btnPreviousGame, btnInput, btnScoreView, btnClose;
	JTextField inputScoreText;

	FrontView() {
		setTitle("볼링 스코어 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container frontPane = getContentPane();
		frontPane.setLayout(null);
		this.setResizable(false);

		titlePanel = new JPanel();
		firstPanel = new JPanel();
		inputPanel = new JPanel();
		scorePanel = new JPanel();

		frontPane.add(titlePanel);
		frontPane.add(firstPanel);
		frontPane.add(inputPanel);
		frontPane.add(scorePanel);

		titlePanel.setVisible(true);
		firstPanel.setVisible(true);
		inputPanel.setVisible(false);
		scorePanel.setVisible(false);

		// titlePanel
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setBounds(40, 10, 400, 70);
		JLabel titleText = new JLabel("볼링 스코어 게임");
		titlePanel.add(titleText);

		// firstPanel
		firstPanel.setLayout(new FlowLayout());
		firstPanel.setBounds(40, 100, 400, 550);

		btnNewGame = new JButton("새 게임");
		btnPreviousGame = new JButton("이전 게임 이어하기");
		firstPanel.add(btnNewGame);
		firstPanel.add(btnPreviousGame);

		btnNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstPanel.setVisible(false);
				inputPanel.setVisible(true);
			}
		});

		// inputPanel
		inputPanel.setLayout(new FlowLayout());
		inputPanel.setBounds(40, 100, 400, 550);
		inputPanel.add(new JLabel("점수를 입력하세요"));
		inputScoreText = new JTextField("0",6);
		inputPanel.add(inputScoreText);
		
		btnScoreView = new JButton("점수판 보기");
		inputPanel.add(btnScoreView);

		btnScoreView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputPanel.setVisible(false);
				scorePanel.setVisible(true);
			}
		});
		
		// scorePanel
		scorePanel.setLayout(new FlowLayout());
		scorePanel.setBounds(40, 100, 400, 550);
		
		int numberOfPlayer = 0;
		for (int i = 0; i < numberOfPlayer; i++) {
			scorePanel.add(new JLabel("플레이어" + "의 스코어"));
			scorePanel.add(new JLabel("======================================"));
			scorePanel.add(new JLabel("프레임\t"));
			scorePanel.add(new JLabel("======================================"));
		}

		btnClose = new JButton("종료");
		scorePanel.add(btnClose);

		setSize(500, 900);
		setVisible(true);
	}
}
