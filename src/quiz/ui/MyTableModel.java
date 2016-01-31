package quiz.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import quiz.application.Question;

public class MyTableModel extends AbstractTableModel{
	
	private List<Question> questions;
	private String[] colNames = {"Id" , "Question" , "Answer" , "Type"};
	
	public MyTableModel(List<Question> questions)
	{
		this.questions = questions;
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public int getRowCount() {
		return questions.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Question question = questions.get(rowIndex);
		switch(columnIndex)
		{
			case 0:
				return question.getId();
			case 1:
				return question.getQues();
			case 2:
				return question.getAns();
			case 3:
				return question.getType();
			case -1:
				return question;
		}
		return null;
	}
	
	@Override
	public String getColumnName(int colIndex) {
		return colNames[colIndex];
	}
}
