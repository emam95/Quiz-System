package quiz.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import quiz.application.Question;
import quiz.data.DataHelper;

import javax.swing.JButton;
import javax.swing.JSpinner;

public class InstructorPanel extends JPanel implements ActionListener{
	
	private JTable table;
	private DataHelper instructorData;
	private JButton btnAddQues;
	private JButton btnEditQuestion;
	private JButton btnBack;
	
	public InstructorPanel() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{69, 159, 158, 117, 75, 0};
		gridBagLayout.rowHeights = new int[]{54, 52, 55, 36, 65, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Welcome Instructor");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		instructorData = new DataHelper();
		
		MyTableModel tableModel = new MyTableModel(instructorData.getAllQuestions());
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 4;
		gbc_btnBack.gridy = 0;
		add(btnBack, gbc_btnBack);
		table = new JTable(tableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 2;
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		add(table, gbc_table);
		
		btnAddQues = new JButton("Add Question");
		btnAddQues.addActionListener(this);
		GridBagConstraints gbc_btnAddQues = new GridBagConstraints();
		gbc_btnAddQues.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddQues.gridx = 1;
		gbc_btnAddQues.gridy = 4;
		add(btnAddQues, gbc_btnAddQues);
		
		btnEditQuestion = new JButton("Edit Question");
		btnEditQuestion.addActionListener(this);
		GridBagConstraints gbc_btnEditQuestion = new GridBagConstraints();
		gbc_btnEditQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditQuestion.gridx = 3;
		gbc_btnEditQuestion.gridy = 4;
		add(btnEditQuestion, gbc_btnEditQuestion);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		int row = table.getSelectedRow();
		if(ae.getSource() == btnAddQues)
			MainFrame.changePanel("newQues");
		if(ae.getSource() == btnEditQuestion)
		{
			if(row >= 0)
			{
				MainFrame.q = (Question) table.getValueAt(row, -1);
				MainFrame.changePanel("edit");
			}
		}
		else if(ae.getSource() == btnBack)
		{
			MainFrame.changePanel("login");
		}
		
	}

}
