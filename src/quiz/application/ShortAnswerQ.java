package quiz.application;

public class ShortAnswerQ extends Question{
	
	public ShortAnswerQ()
	{
		this.type = 1;
	}

	@Override
	public String getQues() {
		return this.ques + "\nAnswer the question";
	}

	@Override
	public String getType() {
		return "Short Answer";
	}
	
	
	

}
