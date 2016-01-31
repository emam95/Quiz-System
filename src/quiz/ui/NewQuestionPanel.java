package quiz.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import quiz.application.Question;
import quiz.data.DataHelper;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;

public class NewQuestionPanel extends JPanel implements ActionListener{
	
	private DataHelper newQuesHelper;
	private JTextField answerField;
	private JButton btnSave;
	private JButton btnClear;
	private JTextArea questionArea;
	private JRadioButton rdbtnShortAnswer;
	private JRadioButton rdbtnTrueOrFalse;
	private JRadioButton rdbtnFillInblank;
	private JButton btnBack;
	
	public NewQuestionPanel() {
		
		newQuesHelper = new DataHelper();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 325, 325, 325, 113, 0};
		gridBagLayout.rowHeights = new int[]{54, 55, 182, 51, 57, 41, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Add New Question");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 4;
		gbc_btnBack.gridy = 0;
		add(btnBack, gbc_btnBack);
		
		rdbtnShortAnswer = new JRadioButton("Short Answer");
		GridBagConstraints gbc_rdbtnShortAnswer = new GridBagConstraints();
		gbc_rdbtnShortAnswer.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnShortAnswer.gridx = 1;
		gbc_rdbtnShortAnswer.gridy = 1;
		add(rdbtnShortAnswer, gbc_rdbtnShortAnswer);
		
		rdbtnTrueOrFalse = new JRadioButton("True or False");
		GridBagConstraints gbc_rdbtnTrueOrFalse = new GridBagConstraints();
		gbc_rdbtnTrueOrFalse.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTrueOrFalse.gridx = 2;
		gbc_rdbtnTrueOrFalse.gridy = 1;
		add(rdbtnTrueOrFalse, gbc_rdbtnTrueOrFalse);
		
		rdbtnFillInblank = new JRadioButton("Fill In Blank");
		GridBagConstraints gbc_rdbtnFillInblank = new GridBagConstraints();
		gbc_rdbtnFillInblank.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFillInblank.gridx = 3;
		gbc_rdbtnFillInblank.gridy = 1;
		add(rdbtnFillInblank, gbc_rdbtnFillInblank);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnShortAnswer);
		bg.add(rdbtnFillInblank);
		bg.add(rdbtnTrueOrFalse);
		
		questionArea = new JTextArea();
		questionArea.setLineWrap(true);
		questionArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		GridBagConstraints gbc_questionArea = new GridBagConstraints();
		gbc_questionArea.gridwidth = 3;
		gbc_questionArea.insets = new Insets(0, 0, 5, 5);
		gbc_questionArea.fill = GridBagConstraints.BOTH;
		gbc_questionArea.gridx = 1;
		gbc_questionArea.gridy = 2;
		add(questionArea, gbc_questionArea);
		//add(new JScrollPane(questionArea), gbc_questionArea);
		
		answerField = new JTextField();
		GridBagConstraints gbc_answerField = new GridBagConstraints();
		gbc_answerField.gridwidth = 3;
		gbc_answerField.insets = new Insets(0, 0, 5, 5);
		gbc_answerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_answerField.gridx = 1;
		gbc_answerField.gridy = 3;
		add(answerField, gbc_answerField);
		answerField.setColumns(10);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 1;
		gbc_btnClear.gridy = 4;
		add(btnClear, gbc_btnClear);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 4;
		add(btnSave, gbc_btnSave);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnSave)
		{
			int type;
			if(rdbtnFillInblank.isSelected())
			{
				type = 3;
			}
			else if(rdbtnShortAnswer.isSelected())
			{
				type = 1;
			}
			else if(rdbtnTrueOrFalse.isSelected())
			{
				type = 2;
			}
			else
				return;
			newQuesHelper.addNewQuestion(questionArea.getText(), answerField.getText(), type);
		}
		if(ae.getSource() == btnClear)
		{
			questionArea.setText("");
			answerField.setText("");
		}
		if(ae.getSource() == btnBack)
		{
			MainFrame.changePanel("instructor");
		}
	}

}
