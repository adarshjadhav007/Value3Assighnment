package com.value3.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotService {

	
public List<Object> InitialPlace(String input, int x, int y, String side, int MaxBoxSizeX,int MaxBoxSizeY, int MinBoxSize) {
		
		try {
			String S[] = input.split(",");
			x = Integer.parseInt(S[0]);
			y = Integer.parseInt(S[1]);
			side = S[2];
			
			if(x<MaxBoxSizeX && y<MaxBoxSizeY && x>=MinBoxSize && y>=MinBoxSize) {
				return Arrays.asList(x,y,side,true);
					
			} else {
				System.out.println("Initial POsition is out of the Box");
				//System.out.println("");
				return Arrays.asList(x,y,side,false);
			}
		} catch (Exception e) {
			System.out.println("Please enter valid initial place");
			//System.out.println("");
			return Arrays.asList(x,y,side,false);
		}
	}
	
	public List<Integer> Move(int x, int y, String dir){
		
			//System.out.println(dir);
			if(dir.toUpperCase().equals("NORTH"))
					y = y + 1;
				else if (dir.toUpperCase().equals("EAST")) 
					x = x + 1;
				else if (dir.toUpperCase().equals("SOUTH")) 
					y = y - 1;
				else if (dir.toUpperCase().equals("WEST")) 
					x = x - 1;	
	
		
		return Arrays.asList(x,y);
		
	}
	
	public String changeDirection(List<String> directions, String side, String input){
		
		Map<String, List<String>> diractionMap = new HashMap<>();
		diractionMap.put("NORTH",Arrays.asList("WEST", "EAST"));
		diractionMap.put("EAST",Arrays.asList("NORTH", "SOUTH"));
		diractionMap.put("WEST",Arrays.asList("SOUTH", "NORTH"));
		diractionMap.put("SOUTH",Arrays.asList("EAST", "WEST"));
		side = diractionMap.get(side).get(directions.indexOf(input.toUpperCase()));
		
		
		return side;
		
	}
	
	public void report(int x, int y, String side)
	{
		System.out.println(x + "," + y + "," +side );
	}

}
