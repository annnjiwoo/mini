package mini;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LessonForm extends JFrame implements ActionListener{
	
	public DataBase db;
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	private JTextField subjectField;
	
	
	public LessonForm() {
		
	}
	
	public LessonForm(DataBase db) {
		
		this.db = db;

		subjectField = new JTextField(10);
		
		JLabel subjectJLabel = new JLabel("과목명 : ");
		
		JButton addButton = new JButton("추가");
		
		addButton.addActionListener(this);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel inputJPanel = new JPanel();
		inputJPanel.setLayout(new GridLayout(1,2));
		
		inputJPanel.add(subjectJLabel);
		inputJPanel.add(subjectField);
		
		mainpanel.add(inputJPanel, BorderLayout.SOUTH);
		mainpanel.add(addButton, BorderLayout.EAST);
		
		setTitle("강좌개설");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainpanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LessonForm();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String subject = subjectField.getText();
		
		Lesson lesson = new Lesson(subject);
		
		this.db.addLesson(lesson);
		for (int i = 0; i < db.lessonList.size(); i++) {
			System.out.println(db.lessonList.get(i).toString());
		}
		
		this.dispose();
		
		MainMenu mainMenu = new MainMenu(db);
		
		mainMenu.setVisible(true);
	}
	
	

}
