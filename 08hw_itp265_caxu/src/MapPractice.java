import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

/**
 * map practice class
 *
 * @author Connie Xu
 * @version Apr 12, 2021
 * ITP 265, Spring 2021, Coffee Section
 * Email: caxu@usc.edu
 * Homework 08
 *
 */

public class MapPractice {
	
	private BFF sc;
	
	//declare map
	private Map<String, List<Person>> allPeople;
	
	//constructor
	public MapPractice() {
		sc = new BFF();
		List<Person> people =  Factory.makePeople();
		allPeople = new HashMap<>(people.size() + 10);
		Person p = new Person("Kendra Walther", LocalDate.of(1985, 01, 01), "kwalther@usc.edu", "ILoveITP");
		people.add(p);
		for (Person person: people) {
			List<Person> p1 = new ArrayList<Person>();
			p1.add(person);
			allPeople.put(person.getEmail(), p1);
		}
	
		}
	
	//email check where
	public boolean emailCheck() {
		String key = sc.inputWord("What email would you like to see?");
		if (allPeople.containsKey(key)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//person check where
	public boolean personCheck(Person x) {
		if (allPeople.containsValue(x)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//check empty
		public boolean isEmpty() {
			return allPeople.isEmpty();
			
		}
		
	//size print
	public void printSize() {
		System.out.println(allPeople.size());
		
	}
	
	//values print
	public void printValues() {
		System.out.println(allPeople.values());
	}
	
	//print keys
		public void printKeys() {
			System.out.println(allPeople.keySet());
			
		}
	
	//print key and value
	public void entrySet() {
		System.out.println(Arrays.asList(allPeople));
		
	}
	
	//check for email
	public void getPerson(String emailAddress) {
		if (allPeople.containsKey(emailAddress)) {
			Person p = allPeople.get(emailAddress).get(0);
			String password = sc.inputLine("Input user password:");
			if (p.checkPassword(password) == true) {
				System.out.println("Welcome " + p.getName() + "!");
			}
			else {
				System.out.println("Sorry, your password isn't correct.");
			}
		}
		else {
			System.out.print("Sorry, no matching email address found.");
		}
	}
	
	Map<String, String> mapName = new HashMap<String, String>();
	
	//user input data
	public void enterData() {
		boolean repeat = true;
		while (repeat) {
			String classWord = sc.inputWord("What class would you like to create? (Person, Student, StudentTA, CEO, Faculty): ");
				String name = sc.inputLine("Please enter the person's name");
				int birthYear = sc.inputInt("Please enter " + name + "'s birth year", 0, 2020);
				int birthMonth = sc.inputInt("Please enter " + name + "'s birth month", 1, 12);
				int birthDay = sc.inputInt("Please enter " + name + "'s birth day", 1, 31);
				LocalDate bday = LocalDate.of(birthYear, birthMonth, birthDay);
				String email = sc.inputWord("Please enter " + name + "'s email address");
				String password = sc.inputWord("Please enter " + name + "'s password");
				if (classWord.equalsIgnoreCase("Person")) {
					Person p = new Person(name, bday, email, password);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				} 
				if (classWord.equalsIgnoreCase("Student")) {
					double gpa = sc.inputDouble("Please enter GPA: ");
					String major = sc.inputLine("Please enter major: ");
					Student p = new Student(name, bday, gpa, major);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
				else if (classWord.equalsIgnoreCase("StudentTA")){
					double gpa = sc.inputDouble("Please enter GPA: ");
					String major = sc.inputLine("Please enter major: ");
					String course = sc.inputLine("Course");
					StudentTA p = new StudentTA(name, bday, gpa, major, course);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
				else if (classWord.equalsIgnoreCase("CEO")){
					double netWorth = sc.inputDouble("Please enter netWorth: ");
					CEO p = new CEO(name, bday, email, password, netWorth);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
				else if (classWord.equalsIgnoreCase("Faculty")){
					String officeLocation = sc.inputLine("Enter office location: ");
					Faculty p = new Faculty(name, bday, officeLocation);
					List<Person> people = new ArrayList<Person>();
					people.add(p);
					allPeople.put(email, people);
					entrySet();
				}
			String xCheck = sc.inputLine("Would you like to continue (y/n)");
			if (xCheck.equalsIgnoreCase("n")) {
				repeat = false;
			}
		}
	}
	
	public static void main(String[] args) {
		
		MapPractice MapPractice = new MapPractice();
		MapPractice.enterData();
		MapPractice.printSize();
		System.out.println(MapPractice.emailCheck());
		MapPractice.getPerson("caxu@usc.edu");
		System.out.println(MapPractice.isEmpty());
		MapPractice.printKeys();
		MapPractice.printValues();
		MapPractice.enterData();
	}
}
