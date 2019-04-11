package com.shaangroups.practice.main;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExploreStreams {

	public static void main(String[] args) {
		
		Person p1 = new Person("Gautham", 32, 'M', Arrays.asList("Tamil", "English", "Hindi", "Kannada", "Malayalam", "German", "Telugu"));
		Person p2 = new Person("Sreerag", 31, 'M', Arrays.asList("Tamil", "English", "Hindi", "Kannada", "Malayalam"));
		Person p3 = new Person("Mayuree", 33, 'F', Arrays.asList("Gujarathi", "English", "Hindi"));
		Person p4 = new Person("Vandana", 29, 'F', Arrays.asList("Rajasthani", "English", "Hindi"));
		
		List<Person> personList = Arrays.asList(p1, p2, p3, p4);

		List<String> names = personList.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		System.out.println(names);
		
		List<String> females = personList.stream()
				.filter(p -> p.getGender() == 'F')
				.map(Person::getName)
				.collect(Collectors.toList());
		System.out.println(females);

		List<String> distinctLanguages = personList.stream()
				.map(Person::getKnownLanguages)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
		System.out.println(distinctLanguages);

		long countOfDistinctLanguages = personList.stream()
				.map(Person::getKnownLanguages)
				.flatMap(List::stream)
				.distinct()
				.count();
		System.out.println(countOfDistinctLanguages);

		Map<String, Long> groupResult = personList.stream()
				.map(Person::getKnownLanguages)
				.flatMap(List::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(groupResult);

		// TODO - to implement later
		/*-
		Map<String, Integer> groupResultInt = personList.stream()
				.map(Person::getKnownLanguages)
				.flatMap(l -> l.stream())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(mapper)));
		System.out.println(groupResult);
		*/
		
		// sorting the above result
		Map<String, Long> groupResultSorted = new LinkedHashMap<>();
		groupResult.entrySet().stream()
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.forEachOrdered(e -> groupResultSorted.put(e.getKey(), e.getValue()));
		System.out.println(groupResultSorted);
		
		/*-
		// sorting the above result
		Map<String, Long> groupResultSortedByKey = new LinkedHashMap<>();
		groupResult.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey().reversed())
		.forEachOrdered(e -> groupResultSorted.put(e.getKey(), e.getValue()));
		System.out.println(groupResultSortedByKey);
		*/
	}
}

class Person {

	private String name;
	private Integer age;
	private char gender;
	private List<String> knownLanguages;

	public Person(String name, Integer age, char gender, List<String> knownLanguages) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.knownLanguages = knownLanguages;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public List<String> getKnownLanguages() {
		return knownLanguages;
	}

	public void setKnownLanguages(List<String> knownLanguages) {
		this.knownLanguages = knownLanguages;
	}

}