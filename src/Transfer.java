import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transfer implements ActionListener{

	JButton DoneButton;
	JButton CancelButton;
	JFrame frame;
	JTextField BalanceField;
	JTextField IDField;
	JLabel InvalidLabel;
	static ImageIcon image;
	static JLabel background;

	Transfer(){

		JLabel IDLabel = new JLabel();
		IDLabel.setText("Reciever's ID:");
		IDLabel.setBounds(275,200,200,30);
		IDLabel.setForeground(Color.white);
		IDLabel.setFont(new Font("Arial",Font.BOLD,25));

		JLabel BalanceLabel = new JLabel();
		BalanceLabel.setText("Balance:");
		BalanceLabel.setBounds(275,250,200,30);
		BalanceLabel.setForeground(Color.white);
		BalanceLabel.setFont(new Font("Arial",Font.BOLD,25));

		IDField = new JTextField();
		IDField.setBounds(450,200,200,30);

		BalanceField = new JTextField();
		BalanceField.setBounds(450,250,200,30);

		JLabel Title = new JLabel("Transfer");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setBackground(new Color(0,51,102));
		Title.setForeground(Color.white);
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
		DoneButton.setOpaque(false);
		DoneButton.setForeground(Color.white);
		DoneButton.setBorder(BorderFactory.createEtchedBorder());
		DoneButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		DoneButton.addActionListener(this);

		CancelButton = new JButton();
		CancelButton.setText("Cancel");
		CancelButton.setBounds(400,450,100,40);
		CancelButton.setFocusable(false);
		CancelButton.setBackground(Color.white);
		CancelButton.setOpaque(false);
		CancelButton.setForeground(Color.white);
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
		frame.add(IDField);
		frame.add(IDLabel);
		frame.add(BalanceField);
		frame.add(BalanceLabel);
		frame.add(DoneButton);
		frame.add(CancelButton);
		frame.add(InvalidLabel);
		frame.add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == DoneButton) {
			try {
				if(login.Who == 1 && MainAccount.Account1.Balance-Integer.parseInt(BalanceField.getText())>=0 && Integer.parseInt(BalanceField.getText()) >= 0) {
					if(Integer.parseInt(IDField.getText()) == Integer.parseInt(MainAccount.Account2.getID())){
						MainAccount.Account1.Balance -= Double.parseDouble(BalanceField.getText());
						MainAccount.Account2.Balance += Double.parseDouble(BalanceField.getText());
						new Operations();
						frame.dispose();
					}
					else if(Integer.parseInt(IDField.getText()) == Integer.parseInt(MainAccount.VIPAccount.getID())){
						MainAccount.Account1.Balance -= Double.parseDouble(BalanceField.getText());
						MainAccount.VIPAccount.Balance += Double.parseDouble(BalanceField.getText());
						new Operations();
						frame.dispose();
					}

				}
				else if(login.Who == 2 && MainAccount.Account2.Balance-Integer.parseInt(BalanceField.getText())>=0 && Integer.parseInt(BalanceField.getText()) >= 0) {
					if(Integer.parseInt(IDField.getText()) == Integer.parseInt(MainAccount.Account1.getID())){
						MainAccount.Account2.Balance -= Double.parseDouble(BalanceField.getText());
						MainAccount.Account1.Balance += Double.parseDouble(BalanceField.getText());
						new Operations();
						frame.dispose();
					}
					else if(Integer.parseInt(IDField.getText()) == Integer.parseInt(MainAccount.VIPAccount.getID()) ){
						MainAccount.Account2.Balance -= Double.parseDouble(BalanceField.getText());
						MainAccount.VIPAccount.Balance += Double.parseDouble(BalanceField.getText());
						new Operations();
						frame.dispose();
					}
				}
				else if(login.Who == 3 && MainAccount.VIPAccount.Balance-Integer.parseInt(BalanceField.getText())>=0 && Integer.parseInt(BalanceField.getText()) >= 0) {
					if(Integer.parseInt(IDField.getText()) == Integer.parseInt(MainAccount.Account2.getID())){
						MainAccount.VIPAccount.Balance -= Double.parseDouble(BalanceField.getText());
						MainAccount.Account2.Balance += Double.parseDouble(BalanceField.getText());
						new Operations();
						frame.dispose();
					}
					else if(Integer.parseInt(IDField.getText()) == Integer.parseInt(MainAccount.Account1.getID())){
						MainAccount.VIPAccount.Balance -= Double.parseDouble(BalanceField.getText());
						MainAccount.Account1.Balance += Double.parseDouble(BalanceField.getText());
						new Operations();
						frame.dispose();
					}
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