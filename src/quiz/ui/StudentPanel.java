package quiz.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;

import quiz.application.Score;
import quiz.data.DataHelper;

import javax.swing.JButton;
import java.awt.Font;

public class StudentPanel extends JPanel implements ActionListener{
	private String name;
	private DataHelper studentHelper;
	private JTable table;
	private JButton btnQuiz;
	private JButton btnShowScores;
	private JButton btnBack;
	
	public StudentPanel() 
	{
		studentHelper = new DataHelper();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{97, 171, 177, 94, 0};
		gridBagLayout.rowHeights = new int[]{71, 292, 39, 82, 16, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.gridwidth = 2;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 3;
		gbc_btnBack.gridy = 0;
		add(btnBack, gbc_btnBack);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(table, gbc_table);
		add(new JScrollPane(table), gbc_table);
		
		btnQuiz = new JButton("New Quiz");
		btnQuiz.addActionListener(this);
		GridBagConstraints gbc_btnQuiz = new GridBagConstraints();
		gbc_btnQuiz.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuiz.gridx = 1;
		gbc_btnQuiz.gridy = 3;
		add(btnQuiz, gbc_btnQuiz);
		
		btnShowScores = new JButton("Show Scores");
		btnShowScores.addActionListener(this);
		GridBagConstraints gbc_btnShowScores = new GridBagConstraints();
		gbc_btnShowScores.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowScores.gridx = 2;
		gbc_btnShowScores.gridy = 3;
		add(btnShowScores, gbc_btnShowScores);
	}
	
	public void showTable()
	{
		name = MainFrame.name;
		System.out.println(name);
		
		Score s = studentHelper.getScore(name);
		
		ScoreTableModel tableModel = new ScoreTableModel(s.getScores(),s.getDates());
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == btnShowScores)
		{
			showTable();
		}
		if(ae.getSource() == btnQuiz)
		{
			MainFrame.changePanel("strtQuiz");
		}
		if(ae.getSource() == btnBack)
		{
			MainFrame.changePanel("login");
		}
	}

}
