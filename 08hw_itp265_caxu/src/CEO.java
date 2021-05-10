import java.time.LocalDate;

/**
 * CEO class
 *
 * @author Connie Xu
 * @version Apr 12, 2021
 * ITP 265, Spring 2021, Coffee Section
 * Email: caxu@usc.edu
 * Homework 08
 *
 */

public class CEO extends Person {

	private double netWorth;
	
	//consturctor full
	public CEO(String name, LocalDate bday, String email, String password, double netWorth) {
		super(name, bday, email, password);
		this.netWorth = netWorth;
	}
	
	//constructor
	public CEO(String name, int year, int month, int day) {
		super(name, year, month, day);
	}

	/**
	 * inc sleepiness x3
	 */
	@Override
	public void increaseSleepiness() {
		super.increaseSleepiness();
		super.increaseSleepiness();
		super.increaseSleepiness();
	}

	@Override
	public String toString() {
		return super.toString() + ", Net Worth= " + netWorth;
	}

	@Override
	public boolean equals(Object other) {
		return super.equals(other);
	}

	@Override
	public int compareTo(Person o) {
		return super.compareTo(o);
	}
}
