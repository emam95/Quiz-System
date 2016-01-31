package quiz.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JTextField;

import quiz.application.Quiz;
import quiz.data.DataHelper;

import javax.swing.JButton;
import java.awt.Font;

public class StartQuiz extends JPanel implements ActionListener{
	
	private DataHelper quizHelper;
	private JTextField answerField;
	private JButton btnNext;
	private JButton btnDone;
	private JTextArea questionArea;
	private int i = 0;
	private int score = 0;
	private Quiz q;
	
	public StartQuiz() 
	{
		quizHelper = new DataHelper();
		q = quizHelper.createQuiz();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{102, 170, 170, 98, 0};
		gridBagLayout.rowHeights = new int[]{63, 220, 48, 83, 66, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("QUIZ");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		questionArea = new JTextArea();
		questionArea.setLineWrap(true);
		questionArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		questionArea.setEditable(false);
		GridBagConstraints gbc_questionArea = new GridBagConstraints();
		gbc_questionArea.gridwidth = 2;
		gbc_questionArea.insets = new Insets(0, 0, 5, 5);
		gbc_questionArea.fill = GridBagConstraints.BOTH;
		gbc_questionArea.gridx = 1;
		gbc_questionArea.gridy = 1;
		questionArea.setText(q.getIndex(i).getQues());
		add(questionArea, gbc_questionArea);
		
		answerField = new JTextField();
		GridBagConstraints gbc_answerField = new GridBagConstraints();
		gbc_answerField.gridwidth = 2;
		gbc_answerField.insets = new Insets(0, 0, 5, 5);
		gbc_answerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_answerField.gridx = 1;
		gbc_answerField.gridy = 3;
		add(answerField, gbc_answerField);
		answerField.setColumns(10);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 5);
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 4;
		add(btnNext, gbc_btnNext);
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(this);
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.insets = new Insets(0, 0, 5, 5);
		gbc_btnDone.gridx = 2;
		gbc_btnDone.gridy = 4;
		add(btnDone, gbc_btnDone);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == btnNext)
		{
			q.getIndex(i).setStudentAns(answerField.getText());
			if(q.getIndex(i).checkAnswer())
			{
				score++;
			}
			if(i < 9)
			{
				i++;
				questionArea.setText(q.getIndex(i).getQues());
			}
		}
		else if(ae.getSource() == btnDone)
		{
			quizHelper.addScore(score, MainFrame.name);
			MainFrame.changePanel("student");
		}
		
	}
	
	

}
