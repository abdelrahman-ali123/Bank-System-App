import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Deposit implements ActionListener{

	JButton DoneButton;
	JButton CancelButton;
	JFrame frame;
	JTextField BalanceField;
	JLabel InvalidLabel;
	static ImageIcon image;
	static JLabel background;

	Deposit(){

		JLabel BalanceLabel = new JLabel();
		BalanceLabel.setText("Balance:");
		BalanceLabel.setBounds(300,250,200,30);
		BalanceLabel.setForeground(Color.white);
		BalanceLabel.setFont(new Font("Arial",Font.BOLD,25));

		BalanceField = new JTextField();
		BalanceField.setBounds(450,250,200,30);

		JLabel Title = new JLabel("Deposit");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setBackground(Color.white);
		Title.setForeground(Color.white);
		//Title.setBackground(new Color((60)));
		Title.setOpaque(false);
		Title.setBounds(0,0,700,100);

		InvalidLabel = new JLabel("Invalid Input!!");
		InvalidLabel.setFont(new Font("Comic Sans",Font.BOLD,25));
		InvalidLabel.setForeground(Color.red);
		InvalidLabel.setBounds(450,350,200,30);
		InvalidLabel.setVisible(false);

		DoneButton = new JButton();
		DoneButton.setText("Done");
		DoneButton.setBounds(550,450,100,40);
		DoneButton.setFocusable(false);
		DoneButton.setBackground(Color.white);
		DoneButton.setForeground(Color.white);
		DoneButton.setOpaque(false);
		//DoneButton.setBackground(Color.orange);
		DoneButton.setBorder(BorderFactory.createEtchedBorder());
		DoneButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		DoneButton.addActionListener(this);

		CancelButton = new JButton();
		CancelButton.setText("Cancel");
		CancelButton.setBounds(400,450,100,40);
		CancelButton.setFocusable(false);
		CancelButton.setBackground(Color.white);
		CancelButton.setForeground(Color.white);
		CancelButton.setOpaque(false);
		//CancelButton.setBackground(Color.orange);
		CancelButton.setBorder(BorderFactory.createEtchedBorder());
		CancelButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		CancelButton.addActionListener(this);

		frame = new JFrame("Bank Account System");
		frame.setSize(700,600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(330, 60);
		frame.getContentPane().setBackground(new Color(192,192,192));

		ImageIcon image =new ImageIcon("money.jpg");
		JLabel background =new JLabel();
		background.setIcon(image);
		background.setBounds(0,0,700,600);
		background.setLayout(null);

		frame.add(Title);
		frame.add(BalanceField);
		frame.add(BalanceLabel);
		frame.add(DoneButton);
		frame.add(CancelButton);
		frame.add(InvalidLabel);
		frame.add(background);

		ImageIcon icon = new ImageIcon("bank.png");
		frame.setIconImage(icon.getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == DoneButton) {
			try {
				if(login.Who == 1 && Integer.parseInt(BalanceField.getText()) <= 10000 && Integer.parseInt(BalanceField.getText()) >= 0) {
					MainAccount.Account1.Balance += Double.parseDouble(BalanceField.getText());
					new Operations();
					frame.dispose();
				}
				else if(login.Who == 2 && Integer.parseInt(BalanceField.getText()) <= 10000 && Integer.parseInt(BalanceField.getText()) >= 0) {
					MainAccount.Account2.Balance += Double.parseDouble(BalanceField.getText());
					new Operations();
					frame.dispose();
				}
				else if(login.Who == 3 && Integer.parseInt(BalanceField.getText()) >= 0) {
					MainAccount.VIPAccount.Balance += Double.parseDouble(BalanceField.getText());
					new Operations();
					frame.dispose();
				}
			}catch(Exception e1) {
				InvalidLabel.setVisible(true);
			}
		}
		if(e.getSource() == CancelButton) {
			new Operations();
			frame.dispose();
		}
	}
}