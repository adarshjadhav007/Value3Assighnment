package com.value3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class robot {
	public static void main(String[] args) {

		String[] input = args[0].split(","); 
		int x= Integer.parseInt(input[0].trim());
		int y= Integer.parseInt(input[1].trim());
		String dir = input[2];
		
		Map<String, List<String>> diractionMap = new HashMap<>();
		diractionMap.put("NORTH",Arrays.asList("WEST", "EAST"));
		diractionMap.put("EAST",Arrays.asList("NORTH", "SOUTH"));
		diractionMap.put("WEST",Arrays.asList("SOUTH", "NORTH"));
		diractionMap.put("SOUTH",Arrays.asList("EAST", "WEST"));
		
		List<String> sides = Arrays.asList("LEFT", "RIGHT");
		
		
		
		for(int i=1; i<args.length ; i++) {
			
			if(args[i].toUpperCase().equals("REPORT")) {
				System.out.println(x + "," + y + "," +dir );
				break;
			}
			
			if(args[i].toUpperCase().equals("MOVE")) {
				if(x<5 && y<5) {
					if(dir.toUpperCase().equals("NORTH"))
							y = y + 1;
						else if (dir.toUpperCase().equals("EAST")) 
							x = x + 1;
						else if (dir.toUpperCase().equals("SOUTH")) 
							y = y - 1;
						else if (dir.toUpperCase().equals("WEST")) 
							x = x - 1;	
				}
						
			} else {
				try {
					dir = diractionMap.get(dir).get(sides.indexOf(args[i]));
				} catch (Exception e) {
					System.out.println("Please Enter Valid input");
				}
			}
		}	
	}
}
