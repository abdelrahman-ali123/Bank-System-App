import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class login implements ActionListener{

	static int Who;

	String LoginName;
	double LoginID,LoginPassword;
	double LoginBalance;

	JButton loginButton;
	static JFrame LoginFrame;
	static JPasswordField PasswordField;
	static JTextField IDField;
	JButton HomeButton;
	static JLabel InvalidLabel;
	static ImageIcon image;
	static JLabel background;


	public double getLoginID() {
		return this.LoginID;
	}

	public void setLoginID(int loginID) {
		this.LoginID = loginID;
	}

	public double getLoginPassword() {
		return this.LoginPassword;
	}

	public void setLoginPassword(int loginPassword) {
		this.LoginPassword = loginPassword;
	}

	login(){
		ImageIcon image =new ImageIcon("money.jpg");
		JLabel background =new JLabel();
		background.setIcon(image);
		background.setBounds(0,0,700,600);
		background.setLayout(null);

		JLabel IDLabel = new JLabel();
		IDLabel.setText("ID:");
		IDLabel.setBounds(300,150,200,30);
		IDLabel.setForeground(Color.white);
		IDLabel.setFont(new Font("Arial",Font.BOLD,25));

		JLabel PasswordLabel = new JLabel();
		PasswordLabel.setText("Password:");
		PasswordLabel.setBounds(300,250,200,30);
		PasswordLabel.setForeground(Color.white);
		PasswordLabel.setFont(new Font("Arial",Font.BOLD,25));

		IDField = new JTextField();
		IDField.setBounds(450,150,200,30);
		IDField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changedUpdate(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changedUpdate(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					setLoginID(Integer.parseInt(IDField.getText()));
				}catch(Exception e1) {

				}
			}
		});


		PasswordField = new JPasswordField();
		PasswordField.setBounds(450,250,200,30);
		PasswordField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changedUpdate(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changedUpdate(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					setLoginPassword(Integer.parseInt(PasswordField.getText()));
				}catch(Exception e1) {

				}
			}
		});

		JLabel Title = new JLabel("Login");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setForeground(Color.white);
		//Title.setBackground(new Color(0,51,102));
		Title.setOpaque(false);
		Title.setBounds(0,0,700,100);

		InvalidLabel = new JLabel("Invalid Input!!");
		InvalidLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
		InvalidLabel.setForeground(Color.red);
		InvalidLabel.setBounds(450,350,200,30);
		InvalidLabel.setVisible(false);

		HomeButton = new JButton("Home");
		HomeButton.setBounds(400,440,100,40);
		HomeButton.setFocusable(false);
		HomeButton.setBackground(Color.white);
		HomeButton.setOpaque(false);
		HomeButton.setForeground(Color.white);
		HomeButton.setBorder(BorderFactory.createEtchedBorder());
		HomeButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		HomeButton.addActionListener(this);

		loginButton = new JButton("login");
		loginButton.setBounds(550,440,100,40);
		loginButton.setFocusable(false);
		loginButton.setBackground(Color.white);
		loginButton.setForeground(Color.white);
		loginButton.setOpaque(false);
		loginButton.setBorder(BorderFactory.createEtchedBorder());
		loginButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		loginButton.addActionListener(this);

		LoginFrame = new JFrame("Bank Account System");
		LoginFrame.setSize(700,600);
		LoginFrame.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
		LoginFrame.setVisible(true);
		LoginFrame.setResizable(false);
		LoginFrame.setLayout(null);
		LoginFrame.setLocation(330, 60);
		LoginFrame.getContentPane().setBackground(new Color(192,192,192));

		LoginFrame.add(Title);
		LoginFrame.add(IDField);
		LoginFrame.add(IDLabel);
		LoginFrame.add(PasswordField);
		LoginFrame.add(PasswordLabel);
		LoginFrame.add(loginButton);
		LoginFrame.add(HomeButton);
		LoginFrame.add(InvalidLabel);
		LoginFrame.add(background);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == loginButton) {
			try {
				int b = Integer.parseInt(IDField.getText());

				if(getLoginID() == Integer.parseInt(MainAccount.Account1.getID())) {
					if (getLoginPassword() == Integer.parseInt(MainAccount.Account1.getPassword())) {
						login.Who = 1;
						LoginFrame.dispose();
						LoginBalance = MainAccount.Account1.Balance;
						new Operations();
					} 
				}

				if(getLoginID() == Integer.parseInt(MainAccount.Account2.getID())) {
					if (getLoginPassword() == Integer.parseInt(MainAccount.Account2.getPassword())) {
						login.Who = 2;
						LoginFrame.dispose();
						LoginBalance = MainAccount.Account2.Balance;
						new Operations();
					} 
				}
				else if(getLoginID() == Integer.parseInt(MainAccount.VIPAccount.getID())) {
					if (getLoginPassword() == Integer.parseInt(MainAccount.VIPAccount.getPassword())) {
						login.Who = 3;
						LoginFrame.dispose();
						LoginBalance = MainAccount.VIPAccount.Balance;
						new Operations();
					} 
				}
			}catch(Exception e1) {
				InvalidLabel.setVisible(true);
			}
		}
		if(e.getSource() == HomeButton) {
			LoginFrame.dispose();
			new Home();


		}
	}
}