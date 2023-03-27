package mini;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TeacherList extends JFrame implements ActionListener{

	public DataBase db;
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	
	
	
	public TeacherList(DataBase db) {
		
		this.db = db;
		
		String[] column = {"강사번호", "강사명", "휴대폰번호", "담당과목", "입사년도"};
		List<Teacher> teacherList = db.getTeacherList();
		Object[][] data = new Object[teacherList.size()][5];
		
		for (int i = 0; i < teacherList.size(); i++) {
			Teacher teacher = teacherList.get(i);
			data[i][0] = teacher.getId();
			data[i][1] = teacher.getName();
			data[i][2] = teacher.getPhone();
			data[i][3] = teacher.getSubject();
			data[i][4] = teacher.getHire();
		}
		
        tableModel = new DefaultTableModel(data, column);
        table = new JTable(tableModel);		
		
        
		//버튼
		JButton closeButton = new JButton("닫기");
		
		//액션리스너
		closeButton.addActionListener(this);
		
		JPanel mainJPanel = new JPanel();
		mainJPanel.setLayout(new BorderLayout());
		mainJPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		
        // 입력 필드들이 놓일 input 패널 생성
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        
        mainJPanel.add(inputPanel, BorderLayout.SOUTH);
		mainJPanel.add(closeButton, BorderLayout.SOUTH);
		
        setTitle("강사조회");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainJPanel);
        setLocationRelativeTo(null);
        setVisible(true);
       
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 창닫기
		this.dispose();

		// 이동해갈 메인 메뉴 생성
		MainMenu mainMenu = new MainMenu(db);

		// 메인 메뉴 보이기
		mainMenu.setVisible(true);
	}
	public static void main(String[] args) {
		DataBase db = new DataBase();
		new TeacherList(db);
	}
}
