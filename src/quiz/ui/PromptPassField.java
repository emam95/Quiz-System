package quiz.ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;

public class PromptPassField extends JPasswordField implements FocusListener {

	  private final String prompt;
	  private boolean showingPrompt;

	  public PromptPassField(final String prompt) {
	    super(prompt);
	    this.prompt = prompt;
	    this.showingPrompt = true;
	    super.addFocusListener(this);
	  }

	  @Override
	  public void focusGained(FocusEvent e) {
		super.setForeground(Color.BLACK);
	    if(this.getPassword().length == 0) {
	      super.setText("");
	      showingPrompt = false;
	    }
	  }
	  @Override
	  public void focusLost(FocusEvent e) {
	    if(this.getPassword().length == 0) {
	      super.setForeground(Color.lightGray);
	      super.setText(prompt);
	      showingPrompt = true;
	    }
	  }

	  @Override
	  public char[] getPassword() {
	    return showingPrompt ? new char[0] : super.getPassword();
	  }
	}