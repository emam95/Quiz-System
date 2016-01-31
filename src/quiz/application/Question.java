package quiz.application;

public abstract class Question {
	
	protected String ques;
	protected String ans;
	protected int type;
	protected int id;
	protected String studentAns;
	
	public abstract String getQues();
	
	public abstract String getType();
	
	public void setQues(String ques) {
		this.ques = ques;
	}
	
	public void setAns(String ans) {
		this.ans = ans;
	}

	public void setStudentAns(String studentAns) {
		this.studentAns = studentAns;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getAns()
	{
		return this.ans;
	}

	public boolean checkAnswer()
	{
		if(this.ans.equalsIgnoreCase(studentAns))
			return true;
		return false;
	}

}
