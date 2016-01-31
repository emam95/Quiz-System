package quiz.application;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
	
	private int nQues = 10;
	private List<Question> questions;
	
	public Quiz()
	{
		questions = new ArrayList<Question>();
	}
	
	public Quiz(int n)
	{
		this.nQues = n;
		questions = new ArrayList<Question>();
	}
	
	public void add(Question q)
	{
		if(this.questions.size() < nQues)
			this.questions.add(q);
	}
	
	public Question getIndex(int index)
	{
		return this.questions.get(index);
	}
	
	public int length()
	{
		return this.questions.size();
	}
	
	public void clear()
	{
		this.questions.clear();
	}

	public int getnQues() {
		return nQues;
	}

	public void setnQues(int nQues) {
		this.nQues = nQues;
	}

}
