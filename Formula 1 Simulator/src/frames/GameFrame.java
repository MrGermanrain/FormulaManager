package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import game.MainClass;
import racers.Drivers;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static DefaultTableModel model;
	private static JTable table;
	private static JScrollPane scrollPane;
	static JLabel lblRaceCounter;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		MainClass.gameSetup();

	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setTitle("FormulaManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 718, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 11, 426, 311);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		addTableRow("","","","","", "");
		
		JButton btnNextRace = new JButton("Next Race");
		btnNextRace.setBounds(566, 387, 119, 45);
		panel.add(btnNextRace);
		
		lblRaceCounter = new JLabel("Race Counter: 0");
		lblRaceCounter.setBounds(30, 404, 138, 28);
		panel.add(lblRaceCounter);
		btnNextRace.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainClass.nextRace();
			}
			
		});
	}
	
	public static void addTableRow(String driver, String raceWins, String overall, String podiums, String top10s, String points) {
		
		model = new DefaultTableModel();
		Object[] column = {"Driver","Wins","Overall","Podiums","Top 10s", "Points"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		for(int i = 0; i < Drivers.driver.length; i++) {
			Object[] row = {driver, raceWins, overall, podiums, top10s, points};
			model.addRow(row);
		}
	}
	
	public static void editTableRow(int line, String driver, int raceWins, int overall, int podiums, int top10s, int points) {		
		model.setValueAt(driver, line, 0);
		model.setValueAt(raceWins, line, 1);
		model.setValueAt(overall, line, 2);
		model.setValueAt(podiums, line, 3);
		model.setValueAt(top10s, line, 4);
		model.setValueAt(points, line, 5);
		resizeColumnWidth(table);
	}
	
	public static void editRaceCount(int amount) {
		lblRaceCounter.setText("Race Counter: " + amount);
	}
	
	public static void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 10; // Min width
	        for (int row = 0; row < 1; row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +40 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
}
