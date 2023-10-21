package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel message;
	private JLabel nameUser;
	private JTextField inputNameUser;
	private JLabel level;
	private JComboBox<String> levelOption;
	private JButton start;
	private JButton exit;
	private JLabel tempEmpty;

	public Login(ActionListener listener) {
		this.setSize(getMaximumSize());
		this.setVisible(true);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		zeroLine(gbc, listener);
		firstLine(gbc, listener);
		secondLine(gbc, listener);
		thirdLine(gbc, listener);
	}

	private void zeroLine(GridBagConstraints gbc, ActionListener listener) {
		message = new JLabel("Welcome Player");
		message.setFont(new Font("Arial", Font.BOLD, 30));
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(message, gbc);
	}

	private void firstLine(GridBagConstraints gbc, ActionListener listener) {
		nameUser = new JLabel("User namer");
		nameUser.setFont(new Font("Arial", Font.BOLD, 12));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(30, 0, 0, 20);
		this.add(nameUser, gbc);

		inputNameUser = new JTextField(20);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(inputNameUser, gbc);

	}

	private void secondLine(GridBagConstraints gbc, ActionListener listener) {
		level = new JLabel("Nivel");
		level.setFont(new Font("Arial", Font.BOLD, 12));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(15, 0, 0, 20);
		this.add(level, gbc);

		levelOption = new JComboBox<String>();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(levelOption, gbc);
	}

	private void thirdLine(GridBagConstraints gbc, ActionListener listener) {
		tempEmpty = new JLabel();
		gbc.gridwidth = GridBagConstraints.WEST;
		this.add(tempEmpty, gbc);

		start = new JButton("Start");
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(30, 10, 0, 0);
		start.setActionCommand("Start");
		start.addActionListener(listener);
		this.add(start, gbc);

		exit = new JButton("Exit");
		gbc.gridwidth = 3;
		exit.setActionCommand("Exit");
		exit.addActionListener(listener);
		this.add(exit, gbc);

		tempEmpty = new JLabel();
		gbc.gridwidth = GridBagConstraints.EAST;
		this.add(tempEmpty, gbc);
	}

	public void loadComboBox(ArrayList<Object> items) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Select level");
		for (Object object : items) {
			model.addElement(object.toString());

		}
		levelOption.setModel(model);
	}

	public String getInputNameUser() {
		return inputNameUser.getText();
	}

	public String getLevelOption() {
		return levelOption.getSelectedItem().toString();
	}

	public void verifactionEmptyName() {
		if (!getInputNameUser().isEmpty()) {
			inputNameUser.setEnabled(false);
		}

	}

}
