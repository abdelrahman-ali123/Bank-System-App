import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home implements ActionListener{

	JButton ExistedAccountButton;
	JButton NewAccountButton;
	static JFrame frame;
	static JLabel background;
	static ImageIcon image;

	Home(){

		ExistedAccountButton = new JButton("Existed Account");
		ExistedAccountButton.setBounds(300, 200, 150, 50);
		ExistedAccountButton.setFocusable(false);
		ExistedAccountButton.setBackground(Color.white);
		ExistedAccountButton.setOpaque(false);
		ExistedAccountButton.setForeground(Color.white);
		ExistedAccountButton.setBorder(BorderFactory.createEtchedBorder());
		ExistedAccountButton.setFont(new Font("Comic Sans",Font.BOLD,15));
		ExistedAccountButton.addActionListener(this);

		NewAccountButton = new JButton("New Account");
		NewAccountButton.setBounds(500, 200, 150, 50);
		NewAccountButton.setFocusable(false);
		NewAccountButton.setBackground(Color.white);
		NewAccountButton.setOpaque(false);
		NewAccountButton.setForeground(Color.white);
		NewAccountButton.setBorder(BorderFactory.createEtchedBorder());
		NewAccountButton.setFont(new Font("Comic Sans",Font.BOLD,15));
		NewAccountButton.addActionListener(this);

		JLabel Title = new JLabel("S.M.A  BANK");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setForeground(Color.white);
		//Title.setBackground(new Color(0,51,102));
		//Title.setOpaque(true);
		Title.setBounds(0,0,700,100);

		ImageIcon image =new ImageIcon("money.jpg");
		JLabel background =new JLabel();
		background.setIcon(image);
		background.setBounds(0,0,700,600);
		background.setLayout(null);

		frame = new JFrame("Bank Account System");
		frame.setSize(700,600);
		frame.getContentPane().setBackground(new Color(192,192,192));
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(330, 60);

		frame.add(Title);
		frame.add(ExistedAccountButton);
		frame.add(NewAccountButton);
		frame.add(background);
		//background.add(Title);

		ImageIcon icon = new ImageIcon("bank.png");
		frame.setIconImage(icon.getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == NewAccountButton) {
			frame.dispose();
			MainAccount.Account1 = new MainAccount();
			MainAccount.Account1.Title.setText("Account 1");
			MainAccount.i++;

		}
		else if(e.getSource() == ExistedAccountButton) {
			frame.dispose();
			new login();
		}
	}

}