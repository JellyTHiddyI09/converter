import java.awt.Color;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	private double usdusd = .78;
	private double gbpusd = 1.26;
	private double eurousd= 1.09;
	private double cadusd = .58;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;

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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Night Mode");
		mnNewMenu.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.gray);
			}
		});
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Gray");
		mntmNewMenuItem.setFont(new Font("Nirmala UI", Font.PLAIN, 10));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.gray);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("White");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.white);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Nirmala UI", Font.PLAIN, 10));
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please select your exchange currencies");
		lblNewLabel.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 22));
		lblNewLabel.setBounds(35, 23, 294, 32);
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
		convertButton.setFont(new Font("Nirmala UI", Font.BOLD, 10));
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountSelect = amountIng.getText();
				double newAmount = Double.parseDouble(amountSelect);
				
				
				double finalAmount = 0;
				
				DecimalFormat reset = new DecimalFormat("0.000");
				// M X N 
				if (options.getSelectedIndex() == 0 && optionsTwo.getSelectedIndex() == 0) {
					result.setText("$ " + newAmount + " MXN");
				}else if(options.getSelectedIndex() == 0 && optionsTwo.getSelectedIndex() == 1){
					finalAmount = (newAmount / usd);
					result.setText("$ " + reset.format(finalAmount) + " USD");
				}else if (options.getSelectedIndex() == 0 && optionsTwo.getSelectedIndex() == 2) {
					finalAmount = (newAmount /gbp);
					result.setText("$ " + reset.format(finalAmount) + " GBP");
				} else if (options.getSelectedIndex()== 0 && optionsTwo.getSelectedIndex()==3) {
					finalAmount = (newAmount / euro);
					result.setText("$ " + reset.format(finalAmount) + " Euros");
				} else if (options.getSelectedIndex() == 0 && optionsTwo.getSelectedIndex()== 4) {
					finalAmount = (newAmount / cad);
					result.setText("$ " + reset.format(finalAmount) + " CAD");
					
					// U S D
				}else if (options.getSelectedIndex()==1 && optionsTwo.getSelectedIndex()==0) {
					finalAmount = (newAmount * usd);
					result.setText("$ " + reset.format(finalAmount) + " MXN");
				} else if(options.getSelectedIndex()==1 && optionsTwo.getSelectedIndex()==1) {
					result.setText("$ " + reset.format(newAmount) + " USD");
				}
				else if (options.getSelectedIndex()== 1 && optionsTwo.getSelectedIndex()==2) {
					finalAmount = (newAmount / gbpusd);
					result.setText("$ " + reset.format(finalAmount) + " GBP");
				}else if (options.getSelectedIndex() == 1 && optionsTwo.getSelectedIndex()==3){
					finalAmount = (newAmount/ eurousd );
					result.setText("$ " + reset.format(finalAmount) + " Euros");
				} else if (options.getSelectedIndex()==1 && optionsTwo.getSelectedIndex() == 4) {
					finalAmount = (newAmount / cadusd);
					result.setText("$ " + reset.format(finalAmount) + " CAD");
				
					//GBP
				}else if (options.getSelectedIndex() == 2 && optionsTwo.getSelectedIndex() == 0) {
					finalAmount = (newAmount * gbp);
					result.setText("$ " + reset.format(finalAmount) + "MXN");
				}else if (options.getSelectedIndex() ==2 && optionsTwo.getSelectedIndex() == 1) {
					finalAmount = (newAmount / usdusd);
					result.setText("$ " + reset.format(finalAmount) + " USD");
				}else if (options.getSelectedIndex() == 2 && optionsTwo.getSelectedIndex() == 2) {
					result.setText("$ " + reset.format(newAmount) + " GBP");
				}else if (options.getSelectedIndex() == 2 && optionsTwo.getSelectedIndex() == 3) {
					finalAmount = (newAmount / eurousd);
					result.setText("$ " + reset.format(finalAmount) + " Euros");
				}else if (options.getSelectedIndex() == 2 && optionsTwo.getSelectedIndex() == 4) {
					finalAmount = (newAmount / cadusd);
					result.setText("$ " + reset.format(finalAmount) + " CAD");
				
				//E U R O
				}else if (options.getSelectedIndex() == 3 && optionsTwo.getSelectedIndex() == 0) {
					finalAmount = (newAmount * euro);
					result.setText("$ " + reset.format(finalAmount) + " MXN");
				}else if (options.getSelectedIndex() == 3 && optionsTwo.getSelectedIndex() ==1) {
					finalAmount = (newAmount /usdusd);
					result.setText("$ " + reset.format(finalAmount) + " USD");
				}else if (options.getSelectedIndex() == 3 && optionsTwo.getSelectedIndex() == 2) {
					finalAmount = (newAmount / gbpusd);
					result.setText("$ " + reset.format(finalAmount) + " GBP");
				}else if (options.getSelectedIndex() == 3 && optionsTwo.getSelectedIndex() == 3) {
					result.setText("$ " + reset.format(newAmount) + " Euros");
				}else if (options.getSelectedIndex() == 3 && optionsTwo.getSelectedIndex() == 4) {
					finalAmount = (newAmount / cadusd);
					result.setText("$ " + reset.format(finalAmount) + " CAD");
				}
				
				//C A D
				else if (options.getSelectedIndex() == 4 && optionsTwo.getSelectedIndex() == 0) {
					finalAmount = (newAmount * cad);
					result.setText("$ " + reset.format(finalAmount) + " MXN");
				}else if (options.getSelectedIndex() == 4 && optionsTwo.getSelectedIndex() == 1) {
					finalAmount = (newAmount / usdusd);
					result.setText("$ " + reset.format(finalAmount) + " USD");
				}else if (options.getSelectedIndex() == 4 && optionsTwo.getSelectedIndex() == 2) {
					finalAmount = (newAmount / gbpusd);
					result.setText("$ " + reset.format(finalAmount) + " GBP");
				}else if (options.getSelectedIndex() == 4 && optionsTwo.getSelectedIndex() == 3) {
					finalAmount = (newAmount / eurousd);
					result.setText("$ " + reset.format(finalAmount) + " Euros");
				}else if (options.getSelectedIndex() == 4 && optionsTwo.getSelectedIndex() == 4) {
					result.setText("$ " + reset.format(newAmount) + " CAD");
				}
				
				
			
			}
		});
		convertButton.setBounds(153, 342, 108, 21);
		contentPane.add(convertButton);
		
		exitButton = new JButton("exit");
		exitButton.setFont(new Font("Nirmala UI", Font.PLAIN, 10));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(363, 510, 63, 21);
		contentPane.add(exitButton);
		
		result = new JLabel("");
		result.setFont(new Font("Book Antiqua", Font.PLAIN, 23));
		result.setBounds(142, 436, 241, 32);
		contentPane.add(result);
		
		amountIng = new JTextField();
		amountIng.setBounds(214, 276, 96, 19);
		contentPane.add(amountIng);
		amountIng.setColumns(10);
	}
}
