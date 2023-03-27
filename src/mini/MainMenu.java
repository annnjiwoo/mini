package mini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
/*
* 초기화면 - 메인 메뉴
*  - 프로그램 구동후 가장 먼저 보여지는 화면
*  - 여기에서 다른 화면으로 이동함.
*  */


public class MainMenu extends JFrame implements ActionListener{
	
	public DataBase db;
	
	 private JLabel titleLabel;
	 
	 private JButton memcomeButton;
	 private JButton memRegisterButton;
	 private JButton memListButton;
	 private JButton termButton;
	 private JButton teaRegisterButton;
	 private JButton teaListButton;
	 private JButton lessonButton;
	 private JButton lessonListButton;
	 private JButton exitButton;
	 
	 
	 // 기본생성자
	 public MainMenu() {
		 db = new DataBase();
		 System.out.println("여기는 기본생성자");
	 }
	 
	 
	 public MainMenu(DataBase db) {
		 this.db = db;
		 
		 setTitle("Swim Center");
		 setLayout(new GridLayout(10,1));
		 setLocationRelativeTo(null);
		 setSize(300,400);
		 
		 //titleLabel
		 titleLabel = new JLabel("수영장 관리 시스템");
		 titleLabel.setHorizontalAlignment(JLabel.CENTER);
		 add(titleLabel);
		 
		 
		//memcomeButton
		 memcomeButton = new JButton("회원입장");
		 memcomeButton.addActionListener(this);
		 add(memcomeButton);
		 
		 //memRegisterButton
		 memRegisterButton = new JButton("회원등록");
		 memRegisterButton.addActionListener(this);
		 add(memRegisterButton);
		 
		 //memListButton
		 memListButton = new JButton("회원조회");
		 memListButton.addActionListener(this);
		 add(memListButton);
		 
		//termButton
		 termButton = new JButton("기간연장");
		 termButton.addActionListener(this);
		 add(termButton);
		 
		//teaRegisterButton
		 teaRegisterButton = new JButton("강사등록");
		 teaRegisterButton.addActionListener(this);
		 add(teaRegisterButton);
		 
		//teaListButton
		 teaListButton = new JButton("강사조회");
		 teaListButton.addActionListener(this);
		 add(teaListButton);
		 
		 //lessonButton
		 lessonButton = new JButton("강좌개설");
		 lessonButton.addActionListener(this);
		 add(lessonButton);
		 
		 lessonListButton = new JButton("강좌조회");
		 lessonListButton.addActionListener(this);
		 add(lessonListButton);
		 
		 //exitButton
		 exitButton = new JButton("종료");
		 exitButton.addActionListener(this);
		 add(exitButton);
		 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
	 }


	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼핸들링
		 if (e.getSource() == memRegisterButton) {
			System.out.println("회원등록");              
            this.dispose();
			MemberForm memberForm = new MemberForm(db);
			memberForm.setVisible(true);

		} else if (e.getSource() == memcomeButton) {
			System.out.println("회원입장");
			 this.dispose();
			 ComeInForm comeIn = new ComeInForm(db);
			 comeIn.setVisible(true);

		} else if (e.getSource() == memListButton) {
			System.out.println("회원조회");
			 this.dispose();
			 MemberList memberList = new MemberList(db);
			 memberList.setVisible(true);
		}
		
		else if (e.getSource() == termButton) {
			System.out.println("기간연장");
			this.dispose();
			TermForm termForm = new TermForm(db);
			termForm.setVisible(true);

		} else if (e.getSource() == teaRegisterButton) {
			System.out.println("강사등록");
			this.dispose();
			TeacherForm teacherForm = new TeacherForm(db);
			teacherForm.setVisible(true); 
			
		}else if (e.getSource() == teaListButton) {
			System.out.println("강사조회");
			this.dispose();
			TeacherList teacherList = new TeacherList(db);
			teacherList.setVisible(true);

		}else if (e.getSource() == lessonButton) {
			System.out.println("강좌개설");
			 this.dispose();
			 LessonForm lessonForm = new LessonForm(db);
			 lessonForm.setVisible(true);
			
		}else if (e.getSource() == lessonListButton) {
			System.out.println("강좌개설");
			 this.dispose();
			 LessonList lessonList = new LessonList(db);
			 lessonList.setVisible(true);
			
		}else if (e.getSource() == exitButton) {
			System.out.println("종료");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		  new MainMenu(new DataBase());
	}
	 
}