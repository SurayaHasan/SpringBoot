package com.suraya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

//framework
@SpringBootApplication
@RestController

public class HelloSpringBootApplication {
	static List<Person> allPeople = new ArrayList<>();
	private boolean person;

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
		Person suraya = new Person("Suraya",24, true, List.of("pizza", "burger"));
		Person maryam = new Person("maryam",23, true, List.of("pizza", "pasta"));

		allPeople.add(suraya);
		allPeople.add(maryam);
		
	}
	// localhost:8080
	@GetMapping
	//method 1
	String greet() {
		return "Hello Suraya";
	}

	//Method 3
	@GetMapping(params = "name")
	String greetName(@RequestParam("name") String name) {
		return "Hello Suraya" + name + " how are you today";
	}


	// localhost:8080/ping
	// cant duplicate same path
	@GetMapping(path = "ping")
	//method 2
	String ping() {
		return "pong";
	}

	@GetMapping(path = "allpeople")
	List<Person> getPerson() {
		return List.of(

		);

		//@PostMapping(path = "allpeople")
		//void addPerson(Person person) {
		//	System.out.println(person);
		//}

		//didnt add postmappin


	}

	static class Person {
		private String name;
		private Integer age;
		private Boolean isAdult;
		private List<String> favouriteFood;

		Person(String name, Integer age, Boolean isAdult, List<String> favouriteFood) {
			this.name = name;
			this.age = age;
			this.isAdult = isAdult;
			this.favouriteFood = favouriteFood;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Boolean getAdult() {
			return isAdult;
		}

		public void setAdult(Boolean adult) {
			isAdult = adult;
		}

		public List<String> getFavouriteFood() {
			return favouriteFood;
		}

		public void setFavouriteFood(List<String> favouriteFood) {
			this.favouriteFood = favouriteFood;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Person)) return false;
			Person person = (Person) o;
			return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(isAdult, person.isAdult) && Objects.equals(favouriteFood, person.favouriteFood);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, age, isAdult, favouriteFood);
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					", isAdult=" + isAdult +
					", favouriteFood=" + favouriteFood +
					'}';
		}
	}
}
