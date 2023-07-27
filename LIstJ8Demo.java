package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LIstJ8Demo {

	public static void main(String[] args) {

		//Find even numbers using stream
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
		System.out.println("Even numbers =  "+ list.stream().filter(p -> p % 2 == 0).collect(Collectors.toList()));
		
		//Find numbers starts with 1
		List<Integer> list1 = Arrays.asList(10,11,51,19,35,17);
		System.out.println("Starts with 1 = " + list1.stream().map(p -> p + "").filter(p -> p.startsWith("1")).collect(Collectors.toList()));
		
		//Find duplicate elements
		List<Integer> list2 = Arrays.asList(10,11,10,19,11,17);
		Set<Integer> hs = new HashSet<>();
		System.out.println(list2.stream().filter(p -> !hs.add(p)).collect(Collectors.toList()));
		
		//Find first element
		List<Integer> list3 = Arrays.asList(10,11,10,19,11,17);
		System.out.println("First element = "+list3.stream().findFirst());
		
		//Find the total no. of elements in list
		List<Integer> list4 = Arrays.asList(10,11,10,19,11,17);
		System.out.println("Total no. of elements = "+list4.stream().count());
		
		//Find the max. value in list
		List<Integer> list5 = Arrays.asList(10,11,10,19,11,17);
		System.out.println("Max number = "+list5.stream().max(Integer::compare).get());
		
		//First non-repeated char in a String
		String str = "Wow";
		str = str.toLowerCase();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character chart : str.toCharArray()) {
			map.put(chart, map.containsKey(chart)? map.get(chart) + 1: 1);
		}
		System.out.println(map.entrySet().stream().filter(p -> p.getValue() == 1 ).findFirst().get().getKey());
		
		// First repeated char in a String
		String str1 = "hello world";
		str1 = str1.toLowerCase();
		Map<Character, Integer> map1 = new LinkedHashMap<Character, Integer>();
		for (Character chart1 : str1.toCharArray()) {
			map1.put(chart1, map1.containsKey(chart1) ? map1.get(chart1) + 1 : 1);
		}
		System.out.println(map1.entrySet().stream().filter(p -> p.getValue() > 1).findFirst().get().getKey());
		
		//Natural sort using stream
		List<Integer> list6 = Arrays.asList(10,11,10,19,11,17);
		System.out.println(list6.stream().sorted().collect(Collectors.toList()));
		
		//Sort in descending order using stream
		List<Integer> list7 = Arrays.asList(10,11,10,19,11,17);
		System.out.println(list7.parallelStream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
		
		//Check duplicate elements in array and return true else return false
		int[] arr = {1,3,5,6,3,1,8,9,5};
		List<Integer> listOfArr =  Arrays.stream(arr).boxed().collect(Collectors.toList());
		Set<Integer> setOfArr = new HashSet<Integer>(listOfArr);
		if (listOfArr.size() == setOfArr.size()) {
			System.out.println("No dublicate elements");
		}else {
			System.out.println("Dublicate elements are presenet in array");
		}
		
		//Get the current date and time using Java 8 Date and Time API
		System.out.println("Current local date = "+java.time.LocalDate.now());
		System.out.println("Current local time = "+ java.time.LocalTime.now());
		System.out.println("Current local date and time = "+ java.time.LocalDateTime.now());
		
		//Concatenate two streams
		List<String> list8 = Arrays.asList("Hello", "Java");
        List<String> list9 = Arrays.asList("8", "stream", "program");
        Stream<String> concatStream = Stream.concat(list8.stream(), list9.stream());
        concatStream.forEach(p -> System.out.print(p + " "));
        System.out.println();
        
        //Perform cube on list elements and filter numbers greater than 50
        List<Integer> list10 = Arrays.asList(4,5,6,7,1,2,3);
        System.out.println("Cube and elements greater than 50 = " + list10.stream().map(i -> i*i*i).filter(p -> p> 50).collect(Collectors.toList()));
        
        //Sort an array and then convert the sorted array into Stream
        int arr1[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr1);
        Arrays.stream(arr1).forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        //Convert object into upper case in Java 8
        List<String> names = Arrays.asList("aa", "bb", "aa", "cc");
        List<String> namesList = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(namesList);
        
        //Convert a List of objects into a Map by considering duplicated keys and store them in sorted order
        List<MyClassForMapDemo> listMyClass = new ArrayList<MyClassForMapDemo>();
        listMyClass.add(new MyClassForMapDemo(1, "Name1", 10));
		listMyClass.add(new MyClassForMapDemo(2, "Name2", 11));
		listMyClass.add(new MyClassForMapDemo(3, "Name3", 12));
		listMyClass.add(new MyClassForMapDemo(4, "Name4", 13));
		listMyClass.add(new MyClassForMapDemo(5, "Name5", 14) );
		Map<String, Long> notesRecords = listMyClass.stream()
		.sorted(Comparator.comparingLong(MyClassForMapDemo::getRollNo)
				.reversed())
		.collect(Collectors.toMap(MyClassForMapDemo::getName, MyClassForMapDemo::getRollNo, (oldValue, newValue) -> oldValue,LinkedHashMap::new));
		System.out.println(notesRecords);
		
		// Count each element/word from the String ArrayList
		// Output: {CC=1, BB=1, AA=2}
		List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC");
		Map<String, Integer> names1Map = new HashMap<String, Integer>();
		for (String string : names1) {

			names1Map.put(string, names1Map.containsKey(string) ? names1Map.get(string) + 1 : 1);

		}
		
		names1Map.entrySet().stream().forEach(p -> System.out.print(p.getKey()+" = "+ p.getValue()+" "));
		
	}

}
