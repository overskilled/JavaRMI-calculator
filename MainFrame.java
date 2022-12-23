import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("sergoe print", Font.BOLD, 18);
    JTextField tfFirstName;
    JTextField tfLastName;
    JLabel lbWelcome;

    
    public void initialize() {

        /************Form Panel *************/
      
        JLabel lbFirstName = new JLabel("Firstname");
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Lastname");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Addition", "Multiplication", "Division", "Sustraction"}));
		comboBox.setBounds(140, 42, 87, 31);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5,5));
        formPanel.setOpaque(false);
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);
        formPanel.add(comboBox);
        
        
        /********** Welcome Label **********/
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        /********* Button Panel ************/
        //ok button
        JButton btnOk = new JButton("OK");
        btnOk.setFont(mainFont);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String firstname = tfFirstName.getText();
                String lastname  = tfLastName.getText();
                lbWelcome.setText("Hello "+firstname+" "+lastname);

            }
        });

        
        //Clear button
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
              tfFirstName.setText("");
              tfLastName.setText("");
              lbWelcome.setText("");

            }
            
        });

        //creat buttons panel and add them to it 
        JPanel btPanel = new JPanel();
        btPanel.setLayout(new GridLayout(2,2,2,2));
        btPanel.setOpaque(false);
        btPanel.add(btnOk);
        btPanel.add(btnClear);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(btPanel, BorderLayout.SOUTH);


        add(mainPanel);

        setTitle("JavaRMI Calculator");
        setSize(500,600);
        setMinimumSize(new Dimension(200,300)); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize(); 
    }

}