import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanManagementSystem extends JFrame {
    private JTextField loanAmountField;
    private JTextField loanPeriodField;
    private JTextField interestRateField;
    private JTextField processingFeeField;
    private JTextField totalAmountField;
    private JTextField monthlyAmountField;

    public LoanManagementSystem() {
        setTitle("Loan Management System");
        setLayout(null);
        getContentPane().setBackground(new Color(153, 255, 204)); // Light green background

        JLabel Loan=new JLabel("LOAN MANAGMENT SYSTEM");
  
        Loan.setFont(Loan.getFont().deriveFont(24f));
        Loan.setHorizontalAlignment(SwingConstants.CENTER);
       Loan.setBounds(25,10,400,30);
        add(Loan);
        
        JLabel loanAmountLabel = new JLabel("LOAN AMOUNT:");
        loanAmountLabel.setBounds(10, 40, 200, 30);
        add(loanAmountLabel);

        loanAmountField = new JTextField();
        loanAmountField.setBounds(160, 40, 200, 30);
        add(loanAmountField);

        JLabel loanPeriodLabel = new JLabel("LOAN PERIOD:");
        loanPeriodLabel.setBounds(10, 80, 200, 30);
        add(loanPeriodLabel);

        loanPeriodField = new JTextField();
        loanPeriodField.setBounds(160, 80, 200, 30);
        add(loanPeriodField);

        JLabel interestRateLabel = new JLabel("INTEREST RATE IN %:");
        interestRateLabel.setBounds(10, 120, 200, 30);
        add(interestRateLabel);

        interestRateField = new JTextField();
        interestRateField.setBounds(160, 120, 200, 30);
        add(interestRateField);

        JLabel processingFeeLabel = new JLabel("PROCESSING FEE:");
        processingFeeLabel.setBounds(10, 160, 170, 30);
        add(processingFeeLabel);

        processingFeeField = new JTextField();
        processingFeeField.setBounds(160, 160, 200, 30);
        add(processingFeeField);

        JButton calculateTotalButton = new JButton("CALCULATE TOTAL AMOUNT TO BE PAID");
        calculateTotalButton.setBounds(10, 200, 280, 30);
        add(calculateTotalButton);
        
         totalAmountField = new JTextField();
        totalAmountField.setBounds(370, 200, 100, 30);
        totalAmountField.setEditable(false);
        add(totalAmountField);

        JButton calculateMonthlyButton = new JButton("CALCULATE AMOUNT TO BE PAID PER MONTH");
        calculateMonthlyButton.setBounds(10, 245, 300, 30);
        add(calculateMonthlyButton);

        monthlyAmountField = new JTextField();
        monthlyAmountField.setBounds(370, 245, 100, 30);
        monthlyAmountField.setEditable(false);
        add(monthlyAmountField);

        calculateTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double loanAmount = Double.parseDouble(loanAmountField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText());
                double processingFee = Double.parseDouble(processingFeeField.getText());

                double totalAmount = loanAmount + (loanAmount * interestRate / 100) + processingFee;
                totalAmountField.setText(String.valueOf(totalAmount));
            }
        });

        calculateMonthlyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double loanAmount = Double.parseDouble(loanAmountField.getText());
                double loanPeriod = Double.parseDouble(loanPeriodField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText());
                double processingFee = Double.parseDouble(processingFeeField.getText());

                double totalAmount = loanAmount + (loanAmount * interestRate / 100) + processingFee;
                double monthlyAmount = totalAmount / loanPeriod;
                monthlyAmountField.setText(String.valueOf(monthlyAmount));
            }
        });

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoanManagementSystem();
    }
}