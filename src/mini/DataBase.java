package mini;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

	public List<Member> memberList;
	public List<Lesson> lessonList;
	public List<Teacher> teacherList;
	public List<Term> termList;
	public List<ComeIn> comeInList;

	public DataBase() {

		memberList = new ArrayList<Member>();
		lessonList = new ArrayList<Lesson>();
		teacherList = new ArrayList<Teacher>();
		termList = new ArrayList<Term>();
		comeInList = new ArrayList<ComeIn>();

	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public List<Lesson> getLessonList() {
		return lessonList;
	}

	public void setLessonList(List<Lesson> lessonList) {
		this.lessonList = lessonList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<Term> getTermList() {
		return termList;
	}

	public void setTermList(List<Term> termList) {
		this.termList = termList;
	}

	public List<ComeIn> getComeInList() {
		return comeInList;
	}

	public void setComeInList(List<ComeIn> comeInList) {
		this.comeInList = comeInList;
	}

	// 회원추가
	public void addMember(Member member) {
		this.memberList.add(member);
	}

	// 강사추가
	public void addTeacher(Teacher teacher) {
		this.teacherList.add(teacher);
	}

	// 기간 추가
	public void addTerm(Term term) {
		this.termList.add(term);
	}

	// 강좌 추가
	public void addLesson(Lesson lesson) {
		this.lessonList.add(lesson);
	}

//회원입장
	public void addComeIn(ComeIn comeIn) {
		this.comeInList.add(comeIn);
	}

}
