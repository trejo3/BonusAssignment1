import java.util.Scanner;
import java.util.ArrayList;

public class BonusAssignment1 
{
	public static void main(String[] args)
	{
		String name, gender, major, state;
		double grade, sum, sumM, sumF;
		int numM, numF;
		
		sum = 0.0;
		sumM = 0.0;
		sumF = 0.0;
		
		numM = 0;
		numF = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Double> grades = new ArrayList<Double>();
		ArrayList<String> genders = new ArrayList<String>();
		ArrayList<String> majors = new ArrayList<String>();
		ArrayList<String> states = new ArrayList<String>();
		
		System.out.println("Note: Please type \"exit\" to exit the program.");
		System.out.println(" ");
		
		
		System.out.println("Student Name: ");
		name = keyboard.next();		
		
		
		while (!name.equals("exit"))
		{	
			names.add(name);
			
			System.out.println("Grade: ");
			grade = LetterToGPA(keyboard.next());
			grades.add(grade);
			sum += grade;
			
			
			System.out.println("Gender: ");
			gender = keyboard.next();
			gender.toUpperCase();
			
			if (gender.equals("M")){ sumM += grade; numM++;}
			if (gender.equals("F")){ sumF += grade; numF++;}
			genders.add(gender);
			
			
			System.out.println("Major: ");
			major = keyboard.next();
			majors.add(major);
			
			System.out.println("State of Origin:");
			state = keyboard.next();
			states.add(state);
			
			System.out.println(" ");
			
			System.out.println("Student Name: ");
			name = keyboard.next();	
					
		}
		
		System.out.println("\n ================== \n");
		
		System.out.println("Overall Average: " + (sum/grades.size()));
		
		System.out.println("Average by Gender: ");
		System.out.println(" Males: " + (sumM / numM));
		System.out.println(" Females: " + (sumF / numF));
		
		System.out.println("Average by Major: ");
		averageBy(majors, grades);
		
		System.out.println("Average by State: ");
		averageBy(states, grades);
		
		
	}
	
	static double LetterToGPA(String grade)
	{
		grade.toUpperCase();
		char letter = grade.charAt(0);
		if (letter == 'A') return 4.0;
		else if (letter == 'B') return 3.0;
		else if (letter == 'C') return 2.0;
		else if (letter == 'D') return 1.0;
		else if (letter == 'F') return 0.0;
		else return -1.0;
	}
	
	
	
	
	static void averageBy(ArrayList<String> avgBy, ArrayList<Double> grades)
	{
		String curr = "";
		for (int i = 0; i < avgBy.size(); i++)
		{
			if (avgBy.get(i).equals("-"))
			{
				continue;
			}
			int div = 0;
			double sum = 0.0;
			curr = avgBy.get(i).toString();
			avgBy.set(i,  "-");
			sum += grades.get(i);
			div++;
			
			for (int j = i+1; j < avgBy.size(); j++)
			{
				if (!avgBy.get(j).equals("-") && avgBy.get(j).equals(curr))
				{
					avgBy.set(j, "-");
					sum += grades.get(j);
					div++;
				}
			}
			System.out.println(" " + curr + ": " + (sum/div));
		}
	}
}
