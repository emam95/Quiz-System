package quiz.application;

import java.awt.EventQueue;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import quiz.ui.MainFrame;
import quiz.data.Data;
import quiz.data.DataHelper;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//DataHelper datahelp = new DataHelper();
		//datahelp.updateQuestion(3, 2);
		//datahelp.updateQuestion("Earlier name of Java Programming language was", true, 2);
		//datahelp.updateQuestion("OAK", false, 2);
		
		//datahelp.addScore(6, "mohamed");
		
		/*Score s = datahelp.getScore("mohamed");
		List<Integer> x = s.getScores();
		List<Timestamp> t = s.getDates();
		
		for(int i = 0; i < x.size(); i++)
			System.out.println("score: " + x.get(i) + "date: " + t.get(i));
		
		datahelp.deleteHelper();*/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
