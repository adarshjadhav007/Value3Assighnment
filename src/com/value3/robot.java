package com.value3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class robot {
	
	public static void main(String[] args) {
		if(args.length>0) {
			try {
				if(args[0].contains("PLACE")) {
					String[] input = args[1].split(","); 
					int x= Integer.parseInt(input[0].trim());
					int y= Integer.parseInt(input[1].trim());
					
						if(x<4 && y<4 && x>=0 && y>=0) {
						Map<String, List<String>> diractionMap = new HashMap<>();
						diractionMap.put("NORTH",Arrays.asList("WEST", "EAST"));
						diractionMap.put("EAST",Arrays.asList("NORTH", "SOUTH"));
						diractionMap.put("WEST",Arrays.asList("SOUTH", "NORTH"));
						diractionMap.put("SOUTH",Arrays.asList("EAST", "WEST"));
						
						String dir = "";
						if(diractionMap.get(input[2].trim())!=null) {
							dir = input[2];
						} else {
							System.out.println("Initial Direction is invalid");
							System.exit(0);
						}
						
						List<String> sides = Arrays.asList("LEFT", "RIGHT");
						
						for(int i=2; i<args.length ; i++) {
							
							if(args[i].toUpperCase().equals("REPORT")) {
								System.out.println(x + "," + y + "," +dir );
								break;
							}
							
							if(args[i].toUpperCase().equals("MOVE")) {
								if(x<4 && y<4 && x>=0 && y>=0) {
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
								if(sides.contains(args[i].toUpperCase())) {
									dir = diractionMap.get(dir).get(sides.indexOf(args[i].toUpperCase()));
								}else {
									System.out.println("Pleas enter valid Input");
									System.exit(0);
								}
							} 
						}
					}else {
						System.out.println("initial position is misplaced");
					}	
				} else {
					System.out.println("'PLACE' Command is missing!");
				}
			}
			catch (Exception e) {
				System.out.println("Please Enter Valid input");
			}
		} else {
			System.out.println("Please Enter Input");
		}
	}	
	
}

