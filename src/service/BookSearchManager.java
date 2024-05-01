package service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BookSearchManager extends JFrame {
	
	// 기본 페이지 크기
	static final int PAGE_WIDTH = 800;
	static final int PAGE_HEIGHT = 600;
	static final int BTN_SIZE_W = 70;
	static final int BTN_SIZE_H = 30;
	
	// 페이지 사이즈
	Dimension frameSize;
	
	// 페이지 요소(패널)
	JPanel searchPanel;
	
	// 페이지 요소
	JButton loguotBtn;
	JButton searchBtn;
	JLabel searchLabel;
	JTextField searchField;
	
	public BookSearchManager() {
		setTitle("SearchPage");
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(PAGE_WIDTH, PAGE_HEIGHT);
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		repaint();
		
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		
		addSearchPanel();
	}
	
	void addSearchPanel() {
		searchPanel = new JPanel();
		
		searchPanel.setBounds(0, 0, frameSize.width, frameSize.height);
		searchPanel.setLayout(null);
		searchPanel.setVisible(true);
		
		addSearchLabel();
		addSearchField();
		addSearchButton();
		
		add(searchPanel);
	}
	
	void addSearchLabel() {
		searchLabel = new JLabel("Book Search: ");
		searchLabel.setBounds(60, 20, 100, 30);
		
		searchPanel.add(searchLabel);
	}
	
	void addSearchField() {
		searchField = new JTextField();
		
		searchField.setBounds(160, 20, 300, 30);
		
		searchPanel.add(searchField);
	}
	
	void addSearchButton() {
		searchBtn = new JButton("Search!");
		
		searchBtn.setBounds(460, 20, BTN_SIZE_W, BTN_SIZE_H);
		
		searchPanel.add(searchBtn);
		
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("testing!");
			}
		});
	}
}
