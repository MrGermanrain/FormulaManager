package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import game.MainClass;
import racers.Drivers;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	static DefaultTableModel model;
	private static JTable table;
	private static JScrollPane scrollPane;
	
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
		scrollPane.setBounds(30, 11, 655, 315);
		panel.add(scrollPane);
		
		table = new JTable();
		addTableRow("Driver","Race Wins","Overall","Podiums","Top 10s", "Points");
		
		JButton btnNextRace = new JButton("Next Race");
		btnNextRace.setBounds(566, 387, 119, 45);
		panel.add(btnNextRace);
		btnNextRace.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainClass.nextRace();
			}
			
		});
	}
	
	public static void addTableRow(String driver, String raceWins, String overall, String podiums, String top10s, String points) {
		
		model = new DefaultTableModel();
		Object[] column = {"Driver","Race Wins","Overall","Podiums","Top 10s", "Points"};
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
	}
}
