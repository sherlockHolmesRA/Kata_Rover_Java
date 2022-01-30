package com.roverkata.roverkata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoverkataApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RoverkataApplication.class, args);
		
    	Point p1 = new Point(1, 2);
    	Point p2 = new Point(3, 3);
    	Direction d = Direction.NORTH; 
    	
    	Coordinates coordinatesValue = new Coordinates(p1, p2, d);
		
		Rover rover = new Rover(coordinatesValue);

		rover.getPosition();
		
		File file = new File("input.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
    	
    	List<String> lines = reader.lines().collect(Collectors.toList());

		String str = lines.toString().substring(1, (lines.size()));
		rover.receiveCommands(str);
		
		//rover.getPosition();
    	System.out.println(rover.getPosition());
    	   	
    	//PrintStream output = new PrintStream("result.txt");
    	PrintStream output = new PrintStream(System.out);
    	
    	//IntStream.range(0, lines.size()).filter(n -> (n % 2) == 1).mapToObj(n -> lines.get(n)).forEach(output::println);
		reader.close();
		
		
	}

}
