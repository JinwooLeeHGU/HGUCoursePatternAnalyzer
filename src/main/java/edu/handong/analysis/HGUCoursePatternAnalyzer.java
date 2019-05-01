package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;	
	private Student[] students;
	private Course[] courses; 
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		// System.out.println("1");
		students = initiateStudentArrayFromLines(lines);
		// System.out.println("1");
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			if(student.getName() == "0") continue;
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			if(course.getCourseName() == "0") continue;
			System.out.println(course.getCourseName());
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {  
		// TODO: implement this method
	
		Student[] students = new Student[lines.length];
	
		Student[] noDuplicates;
		noDuplicates= new Student[lines.length];
		
		for(int i=0; i<lines.length; i++) {
			students[i]=new Student("0");
		}
		// System.out.println("2");
		for (int i=0; i<lines.length;i++) {
			//a[i] = lines[i].trim().split(",")[1];
		}
		int d=0;
		for(int i=0; i<lines.length; i++) {
			noDuplicates[i] = new Student(lines[i].split(",")[1].trim());
			
			if(studentExist(students, noDuplicates[i])==false){
				students[d++] = noDuplicates[i];
			}
		}
		
	return students;
}
	
	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
	
		String [] a = new String[lines.length];
		

		String obj = student.getName();
		for(int i=0; i<lines.length; i++) {
			a[i]= students[i].getName();

		}
		
		for(int i=0; i<students.length; i++) {
			if(a[i].equals(obj)) {
				//System.out.println(true);
				return true;
			}
		}
		//System.out.println(false);
		return false;
		
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		Course[] courses = new Course[lines.length];
		
		Course[] noDuplicates;
		noDuplicates= new Course[lines.length];
		
		for(int i=0; i<lines.length; i++) {
			courses[i]= new Course("0");
		}
		//
		int d=0;
		for(int i=0; i<lines.length; i++) {
			noDuplicates[i] = new Course(lines[i].split(",")[2].trim());
			
			if(courseExist(courses, noDuplicates[i])==false){
				courses[d++] = noDuplicates[i];
			}
		}
		//students[i] = new String[studentNames.length];
		
	
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		String [] a = new String[lines.length];
		String obj = course.getCourseName();
		// courses = new Course[lines.length];
		
		for(int i=0; i<lines.length; i++) {
			a[i]= courses[i].getCourseName();
			//System.out.println(a[i]);
		}
		for(int i=0; i<students.length; i++) {
			if(a[i].equals(obj)) {
				//System.out.println(true);
				return true;
			}
		}
		//System.out.println(false);
		return false;
		
	}
}
