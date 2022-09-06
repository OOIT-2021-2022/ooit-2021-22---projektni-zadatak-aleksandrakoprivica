package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblX;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	
	private Circle circle = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogStack dialog = new DialogStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		textFieldX.setText("" + circle.getCenter().getX());
		textFieldY.setText("" + circle.getCenter().getY());
		textFieldRadius.setText("" + circle.getRadius());
	}

	/**
	 * Create the dialog.
	 */
	public DialogStack() {
		setModal(true);
		setResizable(false);
		setTitle("Circle");
		setBounds(100, 100, 389, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(15, 15, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{81, 220, 0};
		gbl_contentPanel.rowHeights = new int[]{22, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblX = new JLabel("X coordinates:");
			lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.NORTH;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
		}
		
		textFieldX = new JTextField();
		textFieldX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textFieldX = new GridBagConstraints();
		gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldX.gridx = 1;
		gbc_textFieldX.gridy = 0;
		contentPanel.add(textFieldX, gbc_textFieldX);
		textFieldX.setColumns(10);
		{
			JLabel lblY = new JLabel("Y coordinates:");
			lblY.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.NORTH;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldY = new JTextField();
			textFieldY.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 1;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			lblRadius.setHorizontalAlignment(SwingConstants.LEFT);
			lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			textFieldRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 2;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());
							int radius = Integer.parseInt(textFieldRadius.getText());
							
							circle = new Circle(new Point(x, y), radius);
							dispose();
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(null, "Values must be numeric!", "Error", JOptionPane.ERROR_MESSAGE);
						} catch (IllegalArgumentException exception) {
							JOptionPane.showMessageDialog(null, "Values must be positive!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
