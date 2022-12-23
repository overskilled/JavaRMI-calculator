import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Client_page extends JFrame {
	final private Font mainFont = new Font("sergoe print", Font.BOLD, 18);
    public JPanel mainPanel;
	public JTextField textInt1;
	public JTextField textInt2;
	public Calculator_interface calculator;
    public JTextArea textResult;
    
    public void initialize(){


		JComboBox operatorBox = new JComboBox();
		operatorBox.setModel(new DefaultComboBoxModel(new String[] {"Addition", "Multiplication", "Division", "Sustraction"}));
		operatorBox.setBounds(140, 42, 87, 31);
		
		//create button to process result
		JButton btnResult = new JButton("Result");
		//action to be performed whrn button is clicked
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
                int num2;
                int operator;
                int result;
				try {
					Registry regs = LocateRegistry.getRegistry("localhost", 1098);
					calculator = (Calculator_interface) regs.lookup("CalculatorService");
					
					num1 	 = Integer.parseInt(textInt1.getText());
					num2 	 = Integer.parseInt(textInt2.getText());
					operator = operatorBox.getSelectedIndex();
					
					result   = calculator.calculator(num1, num2, operator);
                    textResult.setText("\nResult ="+ result);
					
				}catch(Exception e1){
					System.out.println("There was an error :"+ e);
				}
			}
		});

		//Create text field for operands

		JLabel lbnum1 = new JLabel("First number");
		lbnum1.setFont(mainFont);

		textInt1 = new JTextField();
		textInt1.setBorder(new TitledBorder("Num 1"));
		textInt1.setOpaque(false);
		textInt1.setFont(mainFont);

		JLabel lbnum2 = new JLabel("Second number");
		lbnum2.setFont(mainFont);

		textInt2 = new JTextField();
		textInt2.setBorder(new TitledBorder("Num 2"));
		textInt2.setOpaque(false);
		textInt2.setFont(mainFont);

		JLabel lboperand = new JLabel("Operation");
		lboperand.setFont(mainFont);

		//panel for operands
		JPanel operantPanel = new JPanel();
		operantPanel.setLayout(new GridLayout(4,1,5,5));
		operantPanel.setOpaque(false);
		operantPanel.add(lbnum1);
		operantPanel.add(textInt1);
		operantPanel.add(lbnum2);
		operantPanel.add(textInt2);
		operantPanel.add(lboperand);
		operantPanel.add(operatorBox);

		//creat button panel and add checkbox ans result button to it
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(2,1,5,5));
		btnPanel.setOpaque(false);
		btnPanel.add(btnResult);

		//creat textarea to display the result of the operation
		textResult = new JTextArea();
		textResult.setOpaque(false);
		textResult.setFont(mainFont);

		JPanel resultPanel = new JPanel();
		resultPanel.add(textResult);

		

		//Main window panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		mainPanel.add(operantPanel, BorderLayout.NORTH);
		mainPanel.add(resultPanel, BorderLayout.CENTER);

		add(mainPanel);

		//Window settings
		setTitle("JavaRMI calculator");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(600,600);
		setMinimumSize(new Dimension(300,300));
		setVisible(true);
        
        }
    
        public static void main(String[] args) {
            Client_page mypage = new Client_page();
            mypage.initialize();
        }
}

