package quiz.ui;

import java.sql.Timestamp;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ScoreTableModel extends AbstractTableModel{
	
	private List<Integer> scores;
	private List<Timestamp> dates;
	
	public ScoreTableModel(List<Integer> scores,List<Timestamp> dates)
	{
		this.scores = scores;
		this.dates = dates;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return scores.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex == 0)
		{
			return scores.get(rowIndex);
		}
		else if(columnIndex == 1)
		{
			return dates.get(rowIndex);
		}
		else
			return null;
	}
	
	@Override
	public String getColumnName(int colIndex) {
		if(colIndex == 1)
			return "Date";
		return "Score";
	}
	
	

}
