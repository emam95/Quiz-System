package quiz.ui;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import quiz.data.DataHelper;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class LoginPanel extends JPanel implements ActionListener{
	
	private DataHelper loginHelper;
	private JTextField userField;
	private JPasswordField passField;
	private JButton loginBtn;
	private JRadioButton rdBtnStd;
	private JRadioButton rdBtnIns;
	private JLabel wrongLabel;
	private String name;
	
	public LoginPanel()
	{
		
		loginHelper = new DataHelper();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{89, 153, 24, 21, 160, 76, 0};
		gridBagLayout.rowHeights = new int[]{157, 41, 21, 41, 29, 38, 57, 39, 39, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lbl1 = new JLabel("QUIZ SYSTEM");
		lbl1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.gridwidth = 4;
		gbc_lbl1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl1.gridx = 1;
		gbc_lbl1.gridy = 0;
		add(lbl1, gbc_lbl1);
		
		userField = new PromptTextField("USERNAME");
		userField.setForeground(Color.LIGHT_GRAY);
		userField.setColumns(10);
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.fill = GridBagConstraints.BOTH;
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.gridwidth = 4;
		gbc_userField.gridx = 1;
		gbc_userField.gridy = 1;
		add(userField, gbc_userField);
		
		passField = new PromptPassField("        ");
		passField.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_passField = new GridBagConstraints();
		gbc_passField.fill = GridBagConstraints.BOTH;
		gbc_passField.insets = new Insets(0, 0, 5, 5);
		gbc_passField.gridwidth = 4;
		gbc_passField.gridx = 1;
		gbc_passField.gridy = 3;
		add(passField, gbc_passField);
		
		rdBtnStd = new JRadioButton("Student");
		GridBagConstraints gbc_rdBtnStd = new GridBagConstraints();
		gbc_rdBtnStd.insets = new Insets(0, 0, 5, 5);
		gbc_rdBtnStd.gridx = 1;
		gbc_rdBtnStd.gridy = 4;
		add(rdBtnStd, gbc_rdBtnStd);
		
		rdBtnIns = new JRadioButton("Instructor");
		GridBagConstraints gbc_rdBtnIns = new GridBagConstraints();
		gbc_rdBtnIns.insets = new Insets(0, 0, 5, 5);
		gbc_rdBtnIns.gridx = 4;
		gbc_rdBtnIns.gridy = 4;
		add(rdBtnIns, gbc_rdBtnIns);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdBtnIns);
		bg.add(rdBtnStd);
		
		loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(this);
		
		wrongLabel = new JLabel("Wrong user name or password");
		wrongLabel.setForeground(Color.RED);
		wrongLabel.setVisible(false);
		GridBagConstraints gbc_wrongLabel = new GridBagConstraints();
		gbc_wrongLabel.gridwidth = 4;
		gbc_wrongLabel.insets = new Insets(0, 0, 5, 5);
		gbc_wrongLabel.gridx = 1;
		gbc_wrongLabel.gridy = 5;
		add(wrongLabel, gbc_wrongLabel);
		GridBagConstraints gbc_loginBtn = new GridBagConstraints();
		gbc_loginBtn.fill = GridBagConstraints.BOTH;
		gbc_loginBtn.insets = new Insets(0, 0, 5, 5);
		gbc_loginBtn.gridwidth = 4;
		gbc_loginBtn.gridx = 1;
		gbc_loginBtn.gridy = 6;
		add(loginBtn, gbc_loginBtn);
		
		JButton forgotBtn = new JButton("FORGOT?");
		forgotBtn.setOpaque(false);
		forgotBtn.setContentAreaFilled(false);
		forgotBtn.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		GridBagConstraints gbc_forgotBtn = new GridBagConstraints();
		gbc_forgotBtn.gridwidth = 2;
		gbc_forgotBtn.fill = GridBagConstraints.BOTH;
		gbc_forgotBtn.insets = new Insets(0, 0, 0, 5);
		gbc_forgotBtn.gridx = 1;
		gbc_forgotBtn.gridy = 8;
		add(forgotBtn, gbc_forgotBtn);
		
		JButton signUpBtn = new JButton("SIGN UP");
		signUpBtn.setOpaque(false);
		signUpBtn.setContentAreaFilled(false);
		signUpBtn.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.gray));
		GridBagConstraints gbc_signUpBtn = new GridBagConstraints();
		gbc_signUpBtn.gridwidth = 2;
		gbc_signUpBtn.insets = new Insets(0, 0, 0, 5);
		gbc_signUpBtn.fill = GridBagConstraints.BOTH;
		gbc_signUpBtn.gridx = 3;
		gbc_signUpBtn.gridy = 8;
		add(signUpBtn, gbc_signUpBtn);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==loginBtn)
		{
			String userName = userField.getText();
			String password = String.valueOf(passField.getPassword());
			//database
			if(loginHelper.checkLogin(userName, password,false) && rdBtnStd.isSelected())
			{
				MainFrame.name = userName;
				MainFrame.changePanel("student");
			}
			else if(loginHelper.checkLogin(userName, password,true) && rdBtnIns.isSelected())
			{
				MainFrame.changePanel("instructor");
			}
			else
				wrongLabel.setVisible(true);
		}
	}
	

}
