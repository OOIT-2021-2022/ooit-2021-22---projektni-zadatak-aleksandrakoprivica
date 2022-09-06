package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private JPanel contentPane;
	
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setTitle("Aleksandra Koprivica IT1-2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList<Circle> stackList = new JList<Circle>();
		scrollPane.setViewportView(stackList);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogStack dialogStack = new DialogStack();
				dialogStack.setVisible(true);
				if (dialogStack.getCircle() != null) {
					dlm.add(0, dialogStack.getCircle());
				}
			}
		});
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogStack dialogStack = new DialogStack();
					dialogStack.setCircle(dlm.get(0));
					dialogStack.setVisible(true);
					if (dialogStack.getCircle() != null) {
						dlm.remove(0);
					}
				} catch (ArrayIndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}				
			}
		});
		panel.add(btnDelete);
		
		stackList.setModel(dlm);
	}

}

