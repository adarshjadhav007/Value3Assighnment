package com.value3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.value3.service.RobotService;



public class robot {
	
	public static void main(String[] args) {
		
		int MaxBoxSizeX = 5;
		int MaxBoxSizeY = 5;
		int MinBoxSize = 0;
		int x = 0;
		int y = 0;
		String side = "";
		Boolean start = false;
		List<String> directions = Arrays.asList("LEFT", "RIGHT");
		
		RobotService service = new RobotService();
		
		for(int i=0; i<args.length ; i++) {
			if(args[i].toUpperCase().equals("PLACE")) {
				
				List<Object> initialPosition = service.InitialPlace(args[i+1], x, y, side, MaxBoxSizeY, MaxBoxSizeY, MinBoxSize);
				x = (int) initialPosition.get(0);
				y = (int) initialPosition.get(1);
				side = initialPosition.get(2).toString().toUpperCase();
				start = (Boolean) initialPosition.get(3);
				i=i+1;
				
			} else {
				if(start) {
					if(args[i].toUpperCase().equals("MOVE")) {
						List<Integer> move = service.Move(x, y, side);
						if(move.get(0)<MaxBoxSizeX && move.get(1)<MaxBoxSizeY && move.get(0)>=MinBoxSize && move.get(1)>=MinBoxSize) {
							x = move.get(0);
							y = move.get(1);
						}
					}else if ( directions.contains(args[i].toUpperCase())) {
						side = service.changeDirection(directions, side, args[i].toUpperCase());
					} else if (args[i].toUpperCase().equals("REPORT")) {	
						service.report(x, y, side);	
					}else {
						System.out.println(args[i] + " is not valid command");
					}
						
				}
			}
		}
		
		
	}	
	
}

