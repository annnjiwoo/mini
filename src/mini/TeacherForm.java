package mini;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TeacherForm extends JFrame implements ActionListener{
	public DataBase db;
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	private JTextField idField;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField subjectFild;
	private JTextField hireField;
	
	public TeacherForm() {
		
	}
	
public TeacherForm(DataBase db) {
	
		this.db = db;
		
		idField = new JTextField(10);
		nameField = new JTextField(10);
		phoneField = new JTextField(10);
		subjectFild = new JTextField(10);
		hireField = new JTextField(10);
		
		JLabel idJLabel = new JLabel("강사ID : ");
		JLabel nameJLabel = new JLabel("이름 : ");
		JLabel phoneJLabel = new JLabel("휴대폰번호 : ");
		JLabel subjectJLabel = new JLabel("담당과목 : ");
		JLabel hireJLabel = new JLabel("입사년도 : ");
		
		
		JButton addButton = new JButton("추가");
		
		addButton.addActionListener(this);
		
		//패널에 올리기
		JPanel mainJPanel = new JPanel();
		mainJPanel.setLayout(new BorderLayout());
		mainJPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		//패널넣기
		JPanel inputJPanel = new JPanel();
		inputJPanel.setLayout(new GridLayout(5,2));
		
		inputJPanel.add(idJLabel);
		inputJPanel.add(idField);
		inputJPanel.add(nameJLabel);
		inputJPanel.add(nameField);
		inputJPanel.add(phoneJLabel);
		inputJPanel.add(phoneField);
		inputJPanel.add(subjectJLabel);
		inputJPanel.add(subjectFild);
		inputJPanel.add(hireJLabel);
		inputJPanel.add(hireField);
		
		mainJPanel.add(inputJPanel, BorderLayout.SOUTH);
		mainJPanel.add(addButton, BorderLayout.EAST);
			
		//타이틀 
		setTitle("강사정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainJPanel);
		pack();
		setLocationRelativeTo(null);	//정가운데
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String id = idField.getText();
		String name = nameField.getText();
		String phone = phoneField.getText();
		String subject = subjectFild.getText();
		int hire = Integer.parseInt(subjectFild.getText());
		
		
		for(Lesson lesson : db.lessonList) {
			if(lesson.getSubject().equals(subject)) {
				Teacher teacher = new Teacher(id, name, phone, subject, hire);
				db.teacherList.add(teacher);
				System.out.println("강사 등록이 완료되었습니다.");
				
				dispose();
				
				MainMenu instance = new MainMenu(db);
				instance.setVisible(true);
				return;
			}
		}
		
		JOptionPane.showMessageDialog(null, "과목명을 다시 입력해주세요.");
		this.dispose();
		
		this.dispose();
		// 이동해갈 메인 메뉴 생성
		MainMenu mainMenu = new MainMenu(db);
		// 메인 메뉴 보이기
		mainMenu.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TeacherForm();
	}
	

}
