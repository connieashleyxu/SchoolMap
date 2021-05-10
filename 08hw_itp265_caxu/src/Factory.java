import java.util.*;
import java.time.LocalDate;

/**
 * Factory class
 *
 * @author Connie Xu
 * @version Apr 12, 2021
 * ITP 265, Spring 2021, Coffee Section
 * Email: caxu@usc.edu
 * Homework 08
 *
 */

public class Factory {
	public static List<Person> makePeople(){
		List<Person> p = new ArrayList<Person>();
		p.add(new Person("Connie Xu", LocalDate.of(2002, 01, 11), "caxu@usc.edu", "Arts, Tech, Business of Innovation"));
		p.add(new Person("Karen Shin", LocalDate.of(1999, 02, 02), "kshin@usc.edu", "Computer Science"));
		return p;
	}
	
	public static void print(List<Person> people) {
		for (Person p: people)
			System.out.println(p);
	}
	
	public static void main(String[] args) {
		List<Person> people = makePeople();
		print(people);
	}
}
