package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private JToggleButton btnShapePoint;
	private JToggleButton btnShapeLine;
	private JToggleButton btnShapeRectangle;
	private JToggleButton btnShapeDonut;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Point startPoint = null;
	private Color edgeColor = Color.black;
	private Color innerColor = Color.white;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(1100, 700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		PnlDrawing pnlDrawing = new PnlDrawing();
		
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToggleButton btnShapePoint = new JToggleButton("Point");
		buttonGroup.add(btnShapePoint);
		btnShapePoint.setEnabled(true);
		btnShapePoint.setAlignmentX(0.5f);
		panel_4.add(btnShapePoint);
		
		JToggleButton btnShapeLine = new JToggleButton("Line");
		buttonGroup.add(btnShapeLine);
		btnShapeLine.setEnabled(true);
		btnShapeLine.setAlignmentX(0.5f);
		panel_4.add(btnShapeLine);
		
		JToggleButton btnShapeRectangle = new JToggleButton("Rectangle");
		buttonGroup.add(btnShapeRectangle);
		btnShapeRectangle.setEnabled(true);
		btnShapeRectangle.setAlignmentX(0.5f);
		panel_4.add(btnShapeRectangle);
		
		JToggleButton btnShapeCircle = new JToggleButton("Circle");
		buttonGroup.add(btnShapeCircle);
		btnShapeCircle.setEnabled(true);
		btnShapeCircle.setAlignmentX(0.5f);
		panel_4.add(btnShapeCircle);
		
		JToggleButton btnShapeDonut = new JToggleButton("Donut");
		buttonGroup.add(btnShapeDonut);
		btnShapeDonut.setEnabled(true);
		btnShapeDonut.setAlignmentX(0.5f);
		panel_4.add(btnShapeDonut);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JToggleButton btnSelect = new JToggleButton("Select");
		panel_3.add(btnSelect);
		btnSelect.setAlignmentX(0.5f); }}