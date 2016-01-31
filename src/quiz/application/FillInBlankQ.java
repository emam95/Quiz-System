package quiz.application;

public class FillInBlankQ extends Question{
	
	
	public FillInBlankQ()
	{
		this.type = 3;
	}

	@Override
	public String getQues() {
		return this.ques + "\nFill in the Blank";
	}

	@Override
	public String getType() {
		return "Fill In the Blank";
	}
		
}
