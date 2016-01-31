package quiz.ui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

class PromptTextField extends JTextField implements FocusListener {

	  private final String prompt;
	  private boolean showingPrompt;

	  public PromptTextField(final String prompt) {
	    super(prompt);
	    this.prompt = prompt;
	    this.showingPrompt = true;
	    super.addFocusListener(this);
	  }

	  @Override
	  public void focusGained(FocusEvent e) {
		super.setForeground(Color.BLACK);
	    if(this.getText().isEmpty()) {
	      super.setText("");
	      showingPrompt = false;
	    }
	  }
	  @Override
	  public void focusLost(FocusEvent e) {
	    if(this.getText().isEmpty()) {
		  super.setForeground(Color.lightGray);
	      super.setText(prompt);
	      showingPrompt = true;
	    }
	  }

	  @Override
	  public String getText() {
	    return showingPrompt ? "" : super.getText();
	  }
	}