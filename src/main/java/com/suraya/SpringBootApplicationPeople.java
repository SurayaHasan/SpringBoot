package com.suraya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
// add @RestController to you expose methods as REST services to clients
@RestController
public class SpringBootApplicationPeople {
// class -> only fields + methods
// create a static List of type person with few people inside
    static List<Person> getPerson = new ArrayList<>();
    // static list outside of the main

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationPeople.class, args);
        // person has to be inside of the main
        //person list objects below
        Person suraya = new Person(1, "Suraya", 24);
        Person alima = new Person(2,"Alima", 22);
        Person connie = new Person(3, "Connie", 22);
        Person robyn = new Person(4, "Robyn", 23);
        Person suad = new Person(5, "suad", 23);

        getPerson.add(suraya);
        getPerson.add(alima);
        getPerson.add(connie);
        getPerson.add(robyn);
        getPerson.add(suad);

    }

    // All your code should be inside this one class
    // create a class called Person with following properties: id, name, age
    static class Person {
        private int id;
        private String name;
        private Integer age;

        public Person(int id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

// implement getPersonById

        @GetMapping("people/{id}")
        public Person getPersonById(@PathVariable("id") Integer id) {
            // filter list and return person that matches id otherwise return null
            for (Person p : getPerson) {
                if (id == p.getId()) {
                    return p;
                }
            }
            return null;
        }

    // create another method that returns all people using @GetMapping("people")

    @GetMapping("people")
    // get mapping is a method that allows us to send request
    public List<Person> getEveryone() {
        return getPerson;
    }
    // can use the same path but use different method (below)
     //@PostMapping()
    // test your api using chrome
}
