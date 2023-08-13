import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Converter extends JFrame {

	private JPanel contentPane;
	private JComboBox options;
	private JTextField amountIng;
	private JButton convertButton;
	private JLabel result;
	private JButton exitButton;
	private JComboBox optionsTwo;
	private double mxn = 1;
	private double usd = 17.01;
	private double gbp = 21.59;
	private double euro = 18.66;
	private double cad = 12.65;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Converter frame = new Converter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Converter() {
		setTitle("CURRENCY Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 22));
		lblNewLabel.setBounds(36, 10, 159, 32);
		contentPane.add(lblNewLabel);
		
		options = new JComboBox();
		options.setModel(new DefaultComboBoxModel(new String[] {"MXN - Mexican Peso", "USD  - US Dollar", "GBP - British Pound", "Euro ", "CAD - Canadian Dollar"}));
		options.setBounds(62, 142, 142, 21);
		contentPane.add(options);
		
		optionsTwo = new JComboBox();
		optionsTwo.setModel(new DefaultComboBoxModel(new String[] {"MXN - Mexican Peso", "USD - US Dollar", "GBP - British Pound", "Euro ", "CAD - Canadian Dollar"}));
		optionsTwo.setBounds(241, 142, 142, 21);
		contentPane.add(optionsTwo);
		
		JLabel amountButton = new JLabel("amount:");
		amountButton.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 25));
		amountButton.setBounds(153, 271, 63, 21);
		contentPane.add(amountButton);
		
		
		convertButton = new JButton("CONVERT");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountSelect = amountIng.getText();
				double newAmount = Double.parseDouble(amountSelect);
				
				
				double finalAmount = 0;
				
				DecimalFormat reset = new DecimalFormat("0.00");
				
				if (options.getSelectedIndex() == 0 && optionsTwo.getSelectedIndex() == 0) {
					System.out.println(newAmount);
					result.setText("$ " + newAmount + " MXN");
				}else if(options.getSelectedIndex() == 0 && optionsTwo.getSelectedIndex() == 1){
					finalAmount = (newAmount / usd);
					System.out.println(finalAmount);
					result.setText("$ " + reset.format(finalAmount) + " USD");
				}else if (options.getSelectedIndex() == 0 && optionsTwo.getSelectedIndex() == 2) {
					finalAmount = (newAmount /gbp);
					result.setText("$ " + reset.format(finalAmount) + " GBP");
				} 
			
			}
		});
		convertButton.setBounds(153, 342, 108, 21);
		contentPane.add(convertButton);
		
		exitButton = new JButton("exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(363, 532, 63, 21);
		contentPane.add(exitButton);
		
		result = new JLabel("");
		result.setFont(new Font("Book Antiqua", Font.PLAIN, 23));
		result.setBounds(153, 436, 167, 32);
		contentPane.add(result);
		
		amountIng = new JTextField();
		amountIng.setBounds(214, 276, 96, 19);
		contentPane.add(amountIng);
		amountIng.setColumns(10);
	}
}
