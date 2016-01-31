package quiz.application;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Score {
	
	private String studentName;
	private List<Integer> scores;
	private List<Timestamp> dates;
	
	public Score(String name)
	{
		this.studentName = name;
		this.scores = new ArrayList<Integer>();
		this.dates = new ArrayList<Timestamp>();
	}
	
	public void addScore(int score)
	{
		this.scores.add(score);
	}
	
	public void addDate(Timestamp date)
	{
		this.dates.add(date);
	}
	
	public int length()
	{
		return this.scores.size();
	}
	
	public List<Integer> getScores()
	{
		return this.scores;
	}
	
	public List<Timestamp> getDates()
	{
		return this.dates;
	}
	
}
