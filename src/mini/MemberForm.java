package mini;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MemberForm extends JFrame implements ActionListener {
	
	public DataBase db;
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	private JTextField idField;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField lessonField;
	private JTextField monthField;
	
	public MemberForm() {
		// TODO Auto-generated constructor stub
	}
	
	//생성자
	public MemberForm(DataBase db) {
		
		this.db = db;
		
		
		idField = new JTextField(10);
		nameField = new JTextField(10);
		phoneField = new JTextField(10);
		lessonField = new JTextField(10);
		monthField = new JTextField(10);
		
		JLabel idJLabel = new JLabel("회원번호int :");
		JLabel nameJLabel = new JLabel("회원명 :");
		JLabel phoneJLabel = new JLabel("휴대폰번호 :");
		JLabel homeJLabel = new JLabel("강좌명 :");
		JLabel monthJLabel = new JLabel("등록개월수int :");
		
		//버튼
		JButton addButton = new JButton("추가");
		
		//액션리스너
		addButton.addActionListener(this);
		
		
		//패널위에올리기
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		//패널에 넣기
		JPanel inputJPanel = new JPanel();
		inputJPanel.setLayout(new GridLayout(5, 2));
		
		inputJPanel.add(idJLabel);
		inputJPanel.add(idField);
		inputJPanel.add(nameJLabel);
		inputJPanel.add(nameField);
		inputJPanel.add(phoneJLabel);
		inputJPanel.add(phoneField);
		inputJPanel.add(homeJLabel);
		inputJPanel.add(lessonField);
		inputJPanel.add(monthJLabel);
		inputJPanel.add(monthField);

		mainpanel.add(inputJPanel, BorderLayout.SOUTH);
		mainpanel.add(addButton, BorderLayout.EAST);

		// 타이틀
		setTitle("수영장 회원");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainpanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}



	public static void main(String[] args) {
		new MemberForm();
	}
	
	//액션리스터호출
	public void actionPerformed(ActionEvent e) {
		
		
		String id = idField.getText();
		String name = nameField.getText();
		String phone = phoneField.getText();
		String home = lessonField.getText();
		int month = Integer.parseInt(monthField.getText());
		
		// 입력 데이터로 회원 객체 생성
		Member member = new Member(id, name, phone, home, month);
		
		//db에넣기
		this.db.addMember(member);
		
		//창닫기    
		this.dispose();
		
	      // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
        
     // 메인 메뉴 보이기
        mainMenu.setVisible(true);
		
	}

}

