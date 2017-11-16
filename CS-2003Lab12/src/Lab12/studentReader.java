package Lab12;
import BinaryTrees.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.regex.*;

public class studentReader {
	private File file = new File("students.in");
	BinarySearchTree<StudentGPA> tree = new BinarySearchTree<StudentGPA>();
	
	public void readIn() {
		Scanner scan;
		TreeIterator iter = new TreeIterator(tree);
		StudentGPA student;
		GraduateStudentGPA graduate;
		if(file.exists()) {
			System.out.println("file is good");
		}
		try {
			scan = new Scanner(file);
			String s;
			
			int id;
			String name;
			double GPA;
			String Advisor;
			while(scan.hasNextLine()) {
				s = scan.nextLine();
				String[] splitted = s.split(" ");
				id = Integer.parseInt(splitted[0]);
				name = splitted[1];
				GPA = Double.parseDouble(splitted[2]);
			if(!s.contains("BOSS")) {
				student = new StudentGPA(id,name,GPA);
				tree.insert(student);
			}
			else if(s.contains("BOSS")) {
				Advisor = splitted[3];
				graduate = new GraduateStudentGPA(id,name,GPA,Advisor);
				tree.insert(graduate);
			}
			
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e.printStackTrace();
		}
		iter.printInorder();
	}
	
	public static void main(String... args) {
		studentReader SR = new studentReader();
		SR.readIn();
	}
}
