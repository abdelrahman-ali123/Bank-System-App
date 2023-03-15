import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Credit implements ActionListener{

	JButton DoneButton;
	JButton CancelButton;
	JFrame frame;
	JTextField BalanceField;
	JTextField DayField;
	JTextField MonthField;
	JTextField YearField;
	JLabel InvalidLabel;
	static ImageIcon image;
	static JLabel background;

	int Day,Month,Year;
	static String Dept1,Dept2,Dept3;
	static int Period1,Period2,Period3;

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	Credit(){

		JLabel BalanceLabel = new JLabel();
		BalanceLabel.setText("Balance:");
		BalanceLabel.setBounds(325,150,200,30);
		BalanceLabel.setFont(new Font("Arial",Font.BOLD,25));
		BalanceLabel.setForeground(Color.white);

		JLabel DayLabel = new JLabel("Day:");
		DayLabel.setBounds(275,250,200,30);
		DayLabel.setFont(new Font("Arial",Font.BOLD,20));
		DayLabel.setForeground(Color.white);

		JLabel MonthLabel = new JLabel("Month:");
		MonthLabel.setBounds(400,250,200,30);
		MonthLabel.setFont(new Font("Arial",Font.BOLD,20));
		MonthLabel.setForeground(Color.white);

		JLabel YearLabel = new JLabel("Year:");
		YearLabel.setBounds(540,250,200,30);
		YearLabel.setFont(new Font("Arial",Font.BOLD,20));
		YearLabel.setForeground(Color.white);

		BalanceField = new JTextField();
		BalanceField.setBounds(450,150,200,30);

		DayField = new JTextField();
		DayField.setBounds(325,250,50,30);
		DayField.getDocument().addDocumentListener(new DocumentListener() {

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
					setDay(Integer.parseInt(DayField.getText()));
					int c = Integer.parseInt(BalanceField.getText());

				}catch(Exception e1) {

				}

			}
		});


		MonthField = new JTextField();
		MonthField.setBounds(475,250,50,30);
		MonthField.getDocument().addDocumentListener(new DocumentListener() {

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
					setMonth(Integer.parseInt(MonthField.getText()));
				}catch(Exception e1) {

				}

			}
		});

		YearField = new JTextField();
		YearField.setBounds(600,250,50,30);
		YearField.getDocument().addDocumentListener(new DocumentListener() {

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
					setYear(Integer.parseInt(YearField.getText()));
				}catch(Exception e1) {

				}
			}
		});

		JLabel Title = new JLabel("Credit Card");
		Title.setHorizontalAlignment(JLabel.CENTER);
		Title.setFont(new Font("Calibri",Font.BOLD,50));
		Title.setBackground(new Color(0,51,102));
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
		frame.add(DayField);
		frame.add(MonthField);
		frame.add(YearField);
		frame.add(BalanceLabel);
		frame.add(DayLabel);
		frame.add(MonthLabel);
		frame.add(YearLabel);
		frame.add(DoneButton);
		frame.add(CancelButton);
		frame.add(InvalidLabel);
		frame.add(background);

		setDay(Integer.parseInt(DayField.getText()));
		setMonth(Integer.parseInt(MonthField.getText()));
		setYear(Integer.parseInt(YearField.getText()));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == DoneButton) {
			try {
				if(getDay()<=31 && getMonth()<=12 && getYear()>=2000 && getDay()>0 && getMonth()>0) {
					if(login.Who == 1 && Double.parseDouble(BalanceField.getText()) >= 0 && Credit.Dept1 != "Debt") {
						MainAccount.Account1.Balance -= Double.parseDouble(BalanceField.getText());
						LocalDate CurrentDate1 = LocalDate.now();
						LocalDate DeptDate1 = LocalDate.of(getYear(),getMonth(),getDay());
						Period1 =(int) ChronoUnit.DAYS.between(DeptDate1, CurrentDate1);
						new Operations();
						frame.dispose();
					}
					else if(login.Who == 2 && Double.parseDouble(BalanceField.getText()) >= 0 && Credit.Dept1 != "Debt") {
						MainAccount.Account2.Balance -= Double.parseDouble(BalanceField.getText());
						LocalDate CurrentDate2 = LocalDate.now();
						LocalDate DeptDate2 = LocalDate.of(getYear(),getMonth(),getDay());
						Period2 =(int) ChronoUnit.DAYS.between(DeptDate2, CurrentDate2);
						new Operations();
						frame.dispose();
					}
					else if(login.Who == 3 && Double.parseDouble(BalanceField.getText()) >= 0 && Credit.Dept1 != "Debt") {
						MainAccount.VIPAccount.Balance -= Double.parseDouble(BalanceField.getText());
						LocalDate CurrentDate3 = LocalDate.now();
						LocalDate DeptDate3 = LocalDate.of(getYear(),getMonth(),getDay());
						Period3 =(int) ChronoUnit.DAYS.between(DeptDate3, CurrentDate3);
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