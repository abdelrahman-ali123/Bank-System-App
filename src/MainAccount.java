import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainAccount implements ActionListener {

	static int i=0;

	static MainAccount Account1;
	static MainAccount Account2;
	static MainAccount VIPAccount;
	JFrame frame;
	static ImageIcon image;
	static JLabel background;

	JLabel Title;
	JLabel NameLabel;
	JLabel IDLabel;
	JLabel PasswordLabel;
	JLabel BalanceLabel;
	JLabel InvalidLabel;

	JButton DoneButton;
	JButton AddAccountButton;

	JTextField NameField;
	JTextField IDField;
	JTextField PasswordField;
	JTextField BalanceField;

	String Name;
	double Balance = 0;
	String Password;
	String ID;

	{
		frame = new JFrame();

		Title = new JLabel();

		NameLabel = new JLabel();
		IDLabel = new JLabel();
		PasswordLabel = new JLabel();

		DoneButton = new JButton();
		AddAccountButton = new JButton();

		NameField = new JTextField();

		IDField = new JTextField();

		PasswordField = new JTextField();

		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setForeground(Color.white);
		//Title.setBackground(new Color(0,51,102));
		Title.setOpaque(false);
		Title.setBounds(0,0,700,100);

		NameLabel.setText("Name:");
		NameLabel.setBounds(300,150,200,30);
		NameLabel.setForeground(Color.white);
		//NameLabel.setOpaque(false);
		NameLabel.setFont(new Font("Arial",Font.BOLD,25));

		IDLabel.setText("ID:");
		IDLabel.setBounds(300,200,200,30);
		IDLabel.setForeground(Color.white);
		IDLabel.setFont(new Font("Arial",Font.BOLD,25));

		PasswordLabel.setText("Password:");
		PasswordLabel.setBounds(300,250,200,30);
		PasswordLabel.setForeground(Color.white);
		PasswordLabel.setFont(new Font("Arial",Font.BOLD,25));

		NameField.setBounds(500,150,150,30);
		NameField.getDocument().addDocumentListener(new DocumentListener() {

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
				setName(NameField.getText());
			}
		});

		IDField.setBounds(500,200,150,30);
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
				setID(IDField.getText());
			}
		});

		PasswordField.setBounds(500,250,150,30);
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
				setPassword(PasswordField.getText());
			}
		});


		InvalidLabel = new JLabel("Invalid Input!!");
		InvalidLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
		InvalidLabel.setForeground(Color.red);
		InvalidLabel.setBounds(400,350,200,30);
		InvalidLabel.setVisible(false);

		DoneButton.setText("Done");
		DoneButton.setBounds(575,450,75,40);
		DoneButton.setFocusable(false);
		DoneButton.setBackground(Color.white);
		DoneButton.setOpaque(false);
		DoneButton.setForeground(Color.white);
		DoneButton.setBorder(BorderFactory.createEtchedBorder());
		DoneButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		DoneButton.addActionListener(this);

		AddAccountButton.setText("Add Account");
		AddAccountButton.setBounds(500,400,150,40);
		AddAccountButton.setFocusable(false);
		AddAccountButton.setOpaque(false);;
		AddAccountButton.setBackground(Color.white);
		AddAccountButton.setForeground(Color.white);
		AddAccountButton.setBorder(BorderFactory.createEtchedBorder());
		AddAccountButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		AddAccountButton.addActionListener(this);

		frame.setTitle("Bank Account System");
		frame.getContentPane().setBackground(new Color(192,192,192));
		frame.setSize(700,600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(330, 60);

		ImageIcon image =new ImageIcon("money.jpg");
		JLabel background =new JLabel();
		background.setIcon(image);
		background.setBounds(0,0,700,600);
		background.setLayout(null);

		frame.add(Title);
		frame.add(InvalidLabel);
		frame.add(NameLabel);
		frame.add(IDLabel);
		frame.add(PasswordLabel);
		frame.add(NameField);
		frame.add(IDField);
		frame.add(PasswordField);
		frame.add(DoneButton);
		frame.add(AddAccountButton);
		frame.add(background);

		ImageIcon icon = new ImageIcon("bank.png");
		frame.setIconImage(icon.getImage());

	}
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPassword() {
		return this.Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getID() {
		return this.ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	public double getBalance() {
		return this.Balance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == AddAccountButton) {
			try {
				int a = Integer.parseInt(Password);
				int b = Integer.parseInt(ID);
				if(i==1) {
					frame.dispose();
					Account2 = new MainAccount();
					Account2.Title.setText("Account 2");
					i++;
				}
				else if(i==2) {
					frame.dispose();
					MainAccount.VIPAccount = new MainAccount();
					MainAccount.VIPAccount.Title.setText("VIP Account");
					MainAccount.VIPAccount.AddAccountButton.setVisible(false);
					i++;
				}
			}catch(Exception e1) {
				InvalidLabel.setVisible(true);
			}
		}

		if (e.getSource() == DoneButton) {
			try {
				int a = Integer.parseInt(Password);
				int b = Integer.parseInt(ID);
				frame.dispose();
				new login();
			}catch(Exception e1) {
				InvalidLabel.setVisible(true);
			}
		}
	}
}