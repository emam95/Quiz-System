package quiz.application;

public class TrueFalseQ extends Question{
	
	public TrueFalseQ()
	{
		this.type = 2;
	}

	@Override
	public String getQues() {
		return this.ques + "\nIs the Statement true or false?";
	}

	@Override
	public String getType() {
		return "True or False";
	}
	
}
