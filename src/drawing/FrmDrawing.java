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
		btnSelect.setAlignmentX(0.5f); 
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = pnlDrawing.getSelected();
				if (index == -1) return;
				
				Shape shape = pnlDrawing.getShape(index);
				
				if (shape instanceof Point) {
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint((Point)shape);
					dlgPoint.setVisible(true);
					
					if(dlgPoint.getPoint() != null) {
						pnlDrawing.setShape(index, dlgPoint.getPoint());
						pnlDrawing.repaint();
					}
				} else if (shape instanceof Line) {
					DlgLine dlgLine = new DlgLine();
					dlgLine.setLine((Line)shape);
					dlgLine.setVisible(true);
					
					if(dlgLine.getLine() != null) {
						pnlDrawing.setShape(index, dlgLine.getLine());
						pnlDrawing.repaint();
					}
				} else if (shape instanceof Rectangle) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setRectangle((Rectangle)shape);
					dlgRectangle.setVisible(true);
					
					if(dlgRectangle.getRectangle() != null) {
						pnlDrawing.setShape(index, dlgRectangle.getRectangle());
						pnlDrawing.repaint();
					}
				
				}else if (shape instanceof Donut) {
						DlgDonut dlgDonut = new DlgDonut();
						dlgDonut.setDonut((Donut)shape);
						dlgDonut.setVisible(true);
						
						if(dlgDonut.getDonut() != null) {
							pnlDrawing.setShape(index, dlgDonut.getDonut());
							pnlDrawing.repaint();
						}
				} else if (shape instanceof Circle) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setCircle((Circle)shape);
					dlgCircle.setVisible(true);
					
					if(dlgCircle.getCircle() != null) {
						pnlDrawing.setShape(index, dlgCircle.getCircle());
						pnlDrawing.repaint();
					}
				} 
			}
		});
		btnModify.setEnabled(false);
		btnModify.setAlignmentX(0.5f);
		panel_3.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(null, "Do you really want to delete selected shape?", "Yes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) 
					pnlDrawing.removeSelected();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setAlignmentX(0.5f);
		panel_3.add(btnDelete);
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point clickPosition = new Point(e.getX(), e.getY());
				
				pnlDrawing.deselect();
				
				if (btnSelect.isSelected()) {
					if(pnlDrawing.select(clickPosition)) {
						btnModify.setEnabled(true);
						btnDelete.setEnabled(true);
					} else {
						btnModify.setEnabled(false);
						btnDelete.setEnabled(false);
					}
					return;
				}
				
				if(btnShapePoint.isSelected()) {
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint(clickPosition);
					dlgPoint.setColors(edgeColor);
					dlgPoint.setVisible(true);
					if(dlgPoint.getPoint() != null) {
					pnlDrawing.addShape(dlgPoint.getPoint());
					}
				}

				else if(btnShapeLine.isSelected()) {
					if(startPoint == null) {
						startPoint = clickPosition;
					} else {
						DlgLine dlgLine = new DlgLine();
						dlgLine.setLine(new Line(startPoint, clickPosition));
						dlgLine.setColors(edgeColor);
						dlgLine.setVisible(true);
						if(dlgLine.getLine() != null) {
							pnlDrawing.addShape(dlgLine.getLine());
						}
						startPoint = null;
					}
				}
				
				else if(btnShapeRectangle.isSelected()) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setPoint(clickPosition);
					dlgRectangle.setColors(edgeColor, innerColor);
					dlgRectangle.setVisible(true);
					if(dlgRectangle.getRectangle() != null) {
					pnlDrawing.addShape(dlgRectangle.getRectangle());
					}
					}
				
				else if(btnShapeCircle.isSelected()) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setPoint(clickPosition);
					dlgCircle.setColors(edgeColor, innerColor);
					dlgCircle.setVisible(true);
					if(dlgCircle.getCircle() != null) {
					pnlDrawing.addShape(dlgCircle.getCircle());
					}
					}
				
				else if(btnShapeDonut.isSelected()) {
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setPoint(clickPosition);
					dlgDonut.setColors(edgeColor, innerColor);
					dlgDonut.setVisible(true);
					if(dlgDonut.getDonut() != null) {
					pnlDrawing.addShape(dlgDonut.getDonut());
					}
					}


			}
		});
	}

}
		

	
			
	
					
	

