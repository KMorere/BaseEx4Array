package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;

public class BaseEx4Array {

	//static HashMap<String, int[]> students = new HashMap<>();
	static TreeMap<String, int[]> students = new TreeMap<>();
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		while(students.size() < 3) {
			SetName(reader);
			System.out.println();
		}
		
		reader.close();
	}
	
	/// Sorts an array from lowest int to max int.
	private static void SortArray(int[] _array) {
		int temp = 0;
		
		for (int i = 0; i < _array.length; i++) {
			for (int j = 1; j < (_array.length - i); j++) {
				if (_array[j - 1] > _array[j]) {
					temp = _array[j - 1];
					_array[j - 1] = _array[j];
					_array[j] = temp;
				}
			}
		}
	}
	
	private static void SortStudents() {
		
	}
	
	/// Gives the average grade from a number array.
	private static float GetMedian(int[] _array) {
		float sum = 0;
		
		for (int i = 0; i < _array.length; i++) {
			sum += _array[i];
		}
		
		sum /= _array.length;
		return sum;
	}
	
	/// Check if a student exists.
	private static boolean GetStudent(String _name) {
		if(students.containsKey(_name)) {
			if(students.get(_name).length > 0)
				System.out.println(_name + " " + 
						GetMedian(students.get(_name)) + " " + 
						students.get(_name));
			else
				return false;
		}
		return true;
	}
	
	/// Set a student's name, grades and returns the name and median.
	private static String SetName(Scanner _scanner) {
		System.out.println("Insert the student's name and surname in a single line :");
		String name = _scanner.nextLine();
		
		if(!GetStudent(name)) {
			int[] grades = SetGrade(_scanner, name);
			
			System.out.println(name + " " + GetMedian(grades));
			students.put(name, grades);
		}
		
		return name;
	}
	
	/// Set a student's grades.
	private static int[] SetGrade(Scanner _scanner, String _name) {
		System.out.println(String.format("Insert %s's grades in a single line :", _name));
		String[] gradesStr = _scanner.nextLine().split(" ");
		
		int[] grades = Arrays.stream(gradesStr)
				.mapToInt(Integer::parseInt)
				.toArray();
		
		students.put(_name, grades);
		
		return grades;
	}
}
