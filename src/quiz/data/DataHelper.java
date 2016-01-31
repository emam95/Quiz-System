package quiz.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import quiz.application.FillInBlankQ;
import quiz.application.Question;
import quiz.application.Quiz;
import quiz.application.Score;
import quiz.application.ShortAnswerQ;
import quiz.application.TrueFalseQ;

public class DataHelper {
	
	private static int instances = 0;
	
	public DataHelper()
	{
		if(instances == 0)
		{
			Data.setSchema("quizsys");
			Data.startConnection();
		}
		instances++;
	}
	
	public void deleteHelper()
	{
		if(instances == 1)
			Data.closeConnection();
		instances--;
	}
	
	public int maxQuestions()
	{
		return Data.getMaxId("questions");
	}
	
	public int maxScores()
	{
		return Data.getMaxId("scores");
	}
	
	public Question getQuestion(int id)
	{
		Question q;
		if(Data.getIntCell("type", "questions", id) == 1)
			q = new ShortAnswerQ();
		else if(Data.getIntCell("type", "questions", id) == 2)
			q = new TrueFalseQ();
		else if(Data.getIntCell("type", "questions", id) == 3)
			q = new FillInBlankQ();
		else return null;
		
		q.setQues(Data.getStringCell("question", "questions", id));
		q.setAns(Data.getStringCell("answer", "questions", id));
		q.setId(id);
		return q;
	}
	
	public Quiz createQuiz(int n)
	{
		Quiz quiz = new Quiz(n);
		List<Question> allQuestions = this.getAllQuestions();
		Collections.shuffle(allQuestions);
		for(int i = 0; i < n; i++)
			quiz.add(allQuestions.get(i));
		return quiz;
	}
	
	public Quiz createQuiz()
	{
		Quiz quiz = new Quiz();
		List<Question> allQuestions = this.getAllQuestions();
		Collections.shuffle(allQuestions);
		for(int i = 0; i < quiz.getnQues(); i++)
			quiz.add(allQuestions.get(i));
		return quiz;
	}
	
	public List<Question> getAllQuestions()
	{
		List<Question> allQuestions = new ArrayList<Question>();
		for(int i = 1; i <= this.maxQuestions(); i++)
		{
			allQuestions.add(this.getQuestion(i));
		}
		return allQuestions;
	}
	
	public void addNewQuestion(String question, String answer, int type)
	{
		String values = type + " , " + "'" + question + "'" + " , " + "'" + answer + "'";
		Data.insert("questions", "type, question, answer" , values);
	}
	
	public void updateQuestion(int type,int id)
	{
		String value = String.valueOf(type);
		Data.update("questions", "type", value, id);
	}
	
	public void updateQuestion(String data ,boolean isQuestion,int id)
	{
		if(isQuestion)
			Data.update("questions", "question", "'" + "" + data + "'", id);
		else
			Data.update("questions", "answer", "'" + data +"'", id);
	}
	
	public void deleteQuestion(int id)
	{
		Data.delete("questions", id);
	}
	
	public boolean checkLogin(String user,String password,boolean instructor)
	{
		Map<String, String> userNames = Data.getCols("logininfo", "username","password");
		
		if(userNames.containsKey(user))
		{
			System.out.println(userNames.get(user));
			if(userNames.get(user).equals(password))
			{
				System.out.println(Data.getIntCell("instructor", "logininfo", "username", user));
				if((Data.getIntCell("instructor", "logininfo", "username", user) == 1) && instructor)
				{
					return true;
				}
				else if((Data.getIntCell("instructor", "logininfo", "username", user) == 0) && !instructor)
				{
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	public void addScore(int score,String name)
	{
		Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
		Data.insertPrepDate("scores", "date, score, student", currentTimestamp, score + "," + "'" + name + "'");
	}
	
	public Score getScore(String name)
	{
		Score s = new Score(name);
		for(int i = 1; i <= this.maxScores() ; i++)
		{
			s.addDate(Data.getDateCell("date", "scores", i));
			s.addScore(Data.getIntCell("score", "scores", i));
		}
		return s;
	}
}
