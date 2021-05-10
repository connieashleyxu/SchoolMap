import java.time.LocalDate;

/**
* Person class
*
 * @author Connie Xu
 * @version April 12, 2021
 * ITP 265, Spring 2021, Coffee Section
 * Email: caxu@usc.edu
 * Homework 08
*/

public class Person implements Comparable<Person> , Drawable{
	private String name;
	private LocalDate bday;
	protected int sleepiness;
	private final String email;
	private String password;
	

	public Person(String name, LocalDate bday, String email, String password) {
		this.name = name;
		this.bday = bday;
		sleepiness = 50;
		this.email = email;
		this.password = password;
	}
	
	public Person(String name, LocalDate bday) {
		this.name = name;
		this.bday = bday;
		sleepiness = 50;
		email = "default@usc.edu";
		password = "password";
	}
	
	public Person(String name, int year, int month, int day) {
		this(name, LocalDate.of(year, month, day));		
	}
	
	public void eatFood() {
		System.out.println(name + " is eating pizza");
	
	}
	public void increaseSleepiness() {
		sleepiness++;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the bday
	 */
	public LocalDate getBday() {
		return bday;
	}
	/**
	 * @param bday the bday to set
	 */
	public void setBday(LocalDate bday) {
		this.bday = bday;
	}
	@Override
	public String toString() {
		String message = "name= " + name + ", bday= " + bday + ", email= " + email + ", password= ";
		for (int i = 0; i < password.length(); i++)
			message += "*";
		return message;
	}
	
	//OVERLOAD
	/*public boolean equals(Person other) {
		return this.name.equalsIgnoreCase(other.name)
				&& this.bday.equals(other.bday);
	}*/

	@Override
	public   boolean equals(Object other) {
		if(this == other) { //strictest ddefinition of equals
			return true;
		}
		if(other == null) { //compare something to nothing
			return false;
		}
		//Can only compare a person to another person (OR subclass of person)
		if( ! (other.getClass() == this.getClass())) {
			return false;
		}
		//Two people objects to compare....
		//other IS-A person
		Person p = (Person)other;
		
		
		return this.name.equalsIgnoreCase(p.name)
				&& this.bday.equals(p.bday);
		
	}
	//@Override
	public int compareTo(Person o) {
		if(this.equals(o)) return 0;
		// otherwise compare variables in order. Our natural ordering is age first
		int num =  this.bday.compareTo(o.bday);
		System.out.println("Compared bdays, got: " + num);
		if(num == 0) { //bdays were the same....
			// then look at names
			num = this.name.compareTo(o.name);
		}
		return num;
	}

	@Override
	public void drawInAscii() {
		System.out.println("o-|-<     <--- this is " + name);
		
	}

	/**
	 * return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * make sure password is correct
	 */
	public boolean checkPassword(String password) {
		if (password.equals(this.password))
			return true;
		else
			return false;
	}
}