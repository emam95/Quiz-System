package quiz.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import quiz.application.Question;
import quiz.data.DataHelper;

import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class EditQuestion extends JPanel implements ActionListener
{
	private JTextField textField;
	private JTextArea questionArea;
	private JButton btnQ;
	private JButton btnSave;
	private JButton btnBack;
	private DataHelper editHelper;
	private JRadioButton rdbtnTrueOrFalse;
	private JRadioButton rdbtnFillInBlanks;
	private JRadioButton rdbtnShortAnswer;
	private Question ques;
	
	public EditQuestion() 
	{
		editHelper = new DataHelper();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{113, 95, 105, 107, 111, 0};
		gridBagLayout.rowHeights = new int[]{57, 0, 137, 141, 46, 55, 45, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Edit Question");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
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
		
		rdbtnTrueOrFalse = new JRadioButton("True or False");
		GridBagConstraints gbc_rdbtnTrueOrFalse = new GridBagConstraints();
		gbc_rdbtnTrueOrFalse.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTrueOrFalse.gridx = 1;
		gbc_rdbtnTrueOrFalse.gridy = 1;
		add(rdbtnTrueOrFalse, gbc_rdbtnTrueOrFalse);
		
		rdbtnFillInBlanks = new JRadioButton("Fill in Blanks");
		GridBagConstraints gbc_rdbtnFillInBlanks = new GridBagConstraints();
		gbc_rdbtnFillInBlanks.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFillInBlanks.gridx = 2;
		gbc_rdbtnFillInBlanks.gridy = 1;
		add(rdbtnFillInBlanks, gbc_rdbtnFillInBlanks);
		
		rdbtnShortAnswer = new JRadioButton("Short Answer");
		GridBagConstraints gbc_rdbtnShortAnswer = new GridBagConstraints();
		gbc_rdbtnShortAnswer.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnShortAnswer.gridx = 3;
		gbc_rdbtnShortAnswer.gridy = 1;
		add(rdbtnShortAnswer, gbc_rdbtnShortAnswer);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnShortAnswer);
		bg.add(rdbtnFillInBlanks);
		bg.add(rdbtnTrueOrFalse);
		
		questionArea = new JTextArea();
		questionArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_questionArea = new GridBagConstraints();
		gbc_questionArea.gridheight = 2;
		gbc_questionArea.gridwidth = 3;
		gbc_questionArea.insets = new Insets(0, 0, 5, 5);
		gbc_questionArea.fill = GridBagConstraints.BOTH;
		gbc_questionArea.gridx = 1;
		gbc_questionArea.gridy = 2;
		add(questionArea, gbc_questionArea);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 2;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnQ = new JButton("Question");
		btnQ.addActionListener(this);
		GridBagConstraints gbc_btnQ = new GridBagConstraints();
		gbc_btnQ.insets = new Insets(0, 0, 5, 5);
		gbc_btnQ.gridx = 1;
		gbc_btnQ.gridy = 6;
		add(btnQ, gbc_btnQ);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 6;
		add(btnSave, gbc_btnSave);
	}
	
	public void EditQuestion()
	{
		ques = MainFrame.q;
		questionArea.setText(ques.getQues());
		textField.setText(ques.getAns());
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnQ)
		{
			this.EditQuestion();
		}
		else if(ae.getSource() == btnSave)
		{
			int type;
			if(rdbtnFillInBlanks.isSelected())
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
			editHelper.updateQuestion(type, ques.getId());
			editHelper.updateQuestion(questionArea.getText(), true, ques.getId());
			editHelper.updateQuestion(textField.getText(), false, ques.getId());
		}
		else if(ae.getSource() == btnBack)
		{
			MainFrame.changePanel("instructor");
		}
		
	}

}
