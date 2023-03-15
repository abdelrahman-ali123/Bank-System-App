import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Operations implements ActionListener{
	JButton DepositButton;
	JButton WithdrawButton;
	JButton StatusButton;
	JButton TransferButton;
	JFrame frame;
	JButton HomeButton;
	JButton CreditButton;
	static ImageIcon image;
	static JLabel background;

	Operations(){

		DepositButton = new JButton("Deposit");
		WithdrawButton = new JButton("Withdraw");
		CreditButton = new JButton("Credit Card");
		StatusButton = new JButton("Status");
		TransferButton = new JButton("Transfer");
		HomeButton = new JButton("Home");
		frame = new JFrame("Bank");

		HomeButton.setBounds(425,400,100,40);
		HomeButton.setFocusable(false);

		HomeButton.setBackground(Color.white);
		HomeButton.setForeground(Color.white);
		HomeButton.setBorder(BorderFactory.createEtchedBorder());
		HomeButton.setOpaque(false);
		HomeButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		HomeButton.addActionListener(this);

		DepositButton.setBounds(325, 125, 125, 50);
		DepositButton.setFocusable(false);
		DepositButton.setBackground(Color.white);
		DepositButton.setForeground(Color.white);
		DepositButton.setBorder(BorderFactory.createEtchedBorder());
		DepositButton.setOpaque(false);
		DepositButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		DepositButton.addActionListener(this);

		WithdrawButton.setBounds(525, 125, 125, 50);
		WithdrawButton.setFocusable(false);
		WithdrawButton.setBackground(Color.white);
		WithdrawButton.setForeground(Color.white);
		WithdrawButton.setBorder(BorderFactory.createEtchedBorder());
		WithdrawButton.setOpaque(false);
		WithdrawButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		WithdrawButton.addActionListener(this);

		CreditButton.setBounds(425, 200, 125, 50);
		CreditButton.setFocusable(false);
		CreditButton.setBackground(Color.white);
		CreditButton.setForeground(Color.white);
		CreditButton.setBorder(BorderFactory.createEtchedBorder());
		CreditButton.setOpaque(false);
		CreditButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		CreditButton.addActionListener(this);

		StatusButton.setBounds(325, 275, 125, 50);
		StatusButton.setFocusable(false);
		StatusButton.setBackground(Color.white);
		StatusButton.setForeground(Color.white);
		StatusButton.setBorder(BorderFactory.createEtchedBorder());
		StatusButton.setOpaque(false);
		StatusButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		StatusButton.addActionListener(this);

		TransferButton.setBounds(525, 275, 125, 50);
		TransferButton.setFocusable(false);
		TransferButton.setBackground(Color.white);
		TransferButton.setForeground(Color.white);
		TransferButton.setBorder(BorderFactory.createEtchedBorder());
		TransferButton.setOpaque(false);
		TransferButton.setFont(new Font("Comic Sans",Font.BOLD,20));
		TransferButton.addActionListener(this);

		JLabel Title = new JLabel("Operations");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setForeground(Color.white);
		Title.setBackground(new Color(0,51,102));
		Title.setOpaque(false);
		Title.setBounds(0,0,700,100);

		frame.setTitle("Bank Account System");
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
		frame.add(HomeButton);
		frame.add(DepositButton);
		frame.add(WithdrawButton);
		frame.add(StatusButton);
		frame.add(CreditButton);
		frame.add(TransferButton);
		frame.add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == DepositButton) {
			frame.dispose();
			new Deposit();
		}
		else if(e.getSource() == WithdrawButton) {
			frame.dispose();
			new Withdraw();
		}
		else if(e.getSource() == StatusButton) {
			if(Credit.Period1 > 60 && MainAccount.Account1.Balance<0) {
				Credit.Dept1 ="Debt";
			}
			if(Credit.Period2 > 60 && MainAccount.Account2.Balance<0) {
				Credit.Dept2 ="Debt";
			}
			if(Credit.Period3 > 90 && MainAccount.VIPAccount.Balance<0) {
				Credit.Dept3 ="Debt";
			}
			frame.dispose();
			new Status();
		}
		if(e.getSource() == TransferButton) {
			frame.dispose();
			new Transfer();
		}
		if(e.getSource() == HomeButton) {
			new Home();
			frame.dispose();
		}
		if(e.getSource() == CreditButton) {
			try {
				frame.dispose();
				new Credit();

			}catch(Exception e1) {
			}
		}
	}
}