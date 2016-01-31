package quiz.ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import quiz.application.Question;

public class MainFrame extends JFrame{
	
	private static CardLayout cardLayout;
	private static LoginPanel loginPanel;
	private static JPanel mainPanel;
	private static StudentPanel student;
	private static InstructorPanel instructor;
	private static NewQuestionPanel newQues;
	private static StartQuiz strtQuiz;
	private static EditQuestion edit;
	public static String name;
	public static Question q;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(700, 200, 550, 561);
		
		setTitle("Quiz System");
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		cardLayout = new CardLayout(0, 0);
		getContentPane().setLayout(cardLayout);
		
		loginPanel = new LoginPanel();
		getContentPane().add(loginPanel, "login");
		
		student = new StudentPanel();
		getContentPane().add(student, "student");
		
		instructor = new InstructorPanel();
		getContentPane().add(instructor, "instructor");
		
		newQues = new NewQuestionPanel();
		getContentPane().add(newQues,"newQues");
		
		strtQuiz = new StartQuiz();
		getContentPane().add(strtQuiz, "strtQuiz");
		
		edit = new EditQuestion();
		getContentPane().add(edit, "edit");
	}
	
	public static void changePanel(String panel)
	{
		cardLayout.show(mainPanel, panel);
	}
	
}
