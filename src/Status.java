import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Status implements ActionListener{

	JButton DoneButton;
	JButton ShowButton;
	JFrame frame;
	JLabel NameValue;
	JLabel IDValue;
	JLabel BalanceValue;
	JLabel StatusValue;
	JLabel TypeLabel;
	JLabel TypeValue;
	static ImageIcon image;
	static JLabel background;


	String Name;
	int ID;
	double Balance;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	Status(){

		JLabel NameLabel = new JLabel();
		NameLabel.setText("Name:");
		NameLabel.setBounds(325,100,200,30);
		NameLabel.setForeground(Color.white);
		NameLabel.setFont(new Font("Arial",Font.BOLD,25));

		JLabel TypeLabel =new JLabel();
		TypeLabel.setText("Type:");
		TypeLabel.setBounds(325,300,200,30);
		TypeLabel.setForeground(Color.white);
		TypeLabel.setFont(new Font("Arial",Font.BOLD,25));

		JLabel IDLabel = new JLabel();
		IDLabel.setText("ID:");
		IDLabel.setBounds(325,150,200,30);
		IDLabel.setForeground(Color.white);
		IDLabel.setFont(new Font("Arial",Font.BOLD,25));

		JLabel BalanceLabel = new JLabel();
		BalanceLabel.setText("Balance:");
		BalanceLabel.setBounds(325,200,200,30);
		BalanceLabel.setForeground(Color.white);
		BalanceLabel.setFont(new Font("Arial",Font.BOLD,25));

		JLabel StatusLabel = new JLabel();
		StatusLabel.setText("Current Status:");
		StatusLabel.setBounds(325,250,200,30);
		StatusLabel.setForeground(Color.white);
		StatusLabel.setFont(new Font("Arial",Font.BOLD,25));

		NameValue = new JLabel();
		NameValue.setBounds(550,100,200,30);
		NameValue.setForeground(Color.white);
		NameValue.setFont(new Font("Arial",Font.BOLD,25));

		IDValue = new JLabel();
		IDValue.setBounds(550,150,200,30);
		IDValue.setForeground(Color.white);
		IDValue.setFont(new Font("Arial",Font.BOLD,25));

		BalanceValue = new JLabel();
		BalanceValue.setBounds(550,200,200,30);
		BalanceValue.setForeground(Color.white);
		BalanceValue.setFont(new Font("Arial",Font.BOLD,25));

		StatusValue = new JLabel();
		StatusValue.setBounds(550,250,200,30);
		StatusValue.setForeground(Color.white);
		StatusValue.setFont(new Font("Arial",Font.BOLD,25));

		TypeValue = new JLabel();
		TypeValue.setBounds(550,300,200,30);
		TypeValue.setFont(new Font("Arial",Font.BOLD,25));
		TypeValue.setForeground(Color.white);

		JLabel Title = new JLabel("Status");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setBackground(new Color(0,51,102));
		Title.setForeground(Color.white);
		Title.setOpaque(false);
		Title.setBounds(0,0,700,100);

		ImageIcon image =new ImageIcon("money.jpg");
		JLabel background =new JLabel();
		background.setIcon(image);
		background.setBounds(0,0,700,600);
		background.setLayout(null);

		ShowButton = new JButton("Show");
		ShowButton.setBounds(400,450,100,40);
		ShowButton.setFocusable(false);
		ShowButton.setBackground(Color.white);
		ShowButton.setForeground(Color.white);
		ShowButton.setOpaque(false);
		ShowButton.setBorder(BorderFactory.createEtchedBorder());
		ShowButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		ShowButton.addActionListener(this);

		DoneButton = new JButton("Done");
		DoneButton.setBounds(550,450,100,40);
		DoneButton.setFocusable(false);
		DoneButton.setBackground(Color.white);
		DoneButton.setForeground(Color.white);
		DoneButton.setOpaque(false);
		DoneButton.setBorder(BorderFactory.createEtchedBorder());
		DoneButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		DoneButton.addActionListener(this);

		frame = new JFrame("Bank Account System");
		frame.setSize(700,600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(330, 60);
		frame.getContentPane().setBackground(new Color(192,192,192));

		frame.add(Title);
		frame.add(NameValue);
		frame.add(NameLabel);
		frame.add(IDValue);
		frame.add(IDLabel);
		frame.add(BalanceValue);
		frame.add(BalanceLabel);
		frame.add(StatusLabel);
		frame.add(StatusValue);
		frame.add(DoneButton);
		frame.add(ShowButton);
		frame.add(TypeLabel);
		frame.add(TypeValue);
		frame.add(background);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ShowButton) {
			if(login.Who == 1) {
				NameValue.setText(MainAccount.Account1.getName());
				IDValue.setText(MainAccount.Account1.getID());
				setBalance(MainAccount.Account1.getBalance());
				TypeValue.setText("Normal");
				BalanceValue.setText(Double.toString(MainAccount.Account1.Balance));
				if(Credit.Period1 > 60 && MainAccount.Account1.Balance<0) {
					StatusValue.setText(Credit.Dept1);
				}
			}
			if(login.Who == 2) {
				NameValue.setText(MainAccount.Account2.getName());
				IDValue.setText(MainAccount.Account2.getID());
				setBalance(MainAccount.Account2.getBalance());
				TypeValue.setText("Normal");
				BalanceValue.setText(Double.toString(MainAccount.Account2.Balance));
				if(Credit.Period2 > 60 && MainAccount.Account2.Balance<0) {
					StatusValue.setText(Credit.Dept2);
				}
			}
			if(login.Who == 3) {
				NameValue.setText(MainAccount.VIPAccount.getName());
				IDValue.setText(MainAccount.VIPAccount.getID());
				setBalance(MainAccount.VIPAccount.getBalance());
				TypeValue.setText("VIP");
				BalanceValue.setText(Double.toString(MainAccount.VIPAccount.Balance));
				if(Credit.Period3 > 90 && MainAccount.VIPAccount.Balance<0) {
					StatusValue.setText(Credit.Dept3);
				}
			}
		}
		if(e.getSource() == DoneButton) {

			frame.dispose();
			new Operations();
		}
	}
}
