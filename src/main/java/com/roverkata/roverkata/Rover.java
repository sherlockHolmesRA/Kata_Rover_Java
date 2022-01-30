package com.roverkata.roverkata;

public class Rover {
	private Coordinates coordinates;
    public void setCoordinates(Coordinates value) {
        coordinates = value;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Rover(Coordinates coordinatesValue) {
        setCoordinates(coordinatesValue);
    }

    public void receiveCommands(String commands) throws Exception {
    		
        for (char command : commands.toCharArray()) {
        	
            if (!receiveSingleCommand(command)) {
                break;
            }
        }
    }

    public boolean receiveSingleCommand(char command) throws Exception {
        switch(Character.toUpperCase(command)) {
            case 'F':
            	//System.out.println("command = F");
                return getCoordinates().moveForward();
            case 'B':
            	//System.out.println("command = B");
                return getCoordinates().moveBackward();
            case 'L':
            	//System.out.println("command = L");
                getCoordinates().changeDirectionLeft();
                return true;
            case 'R':
            	//System.out.println("command = R");
                getCoordinates().changeDirectionRight();
                return true;
            default:
                throw new Exception("Command " + command + " is unknown.");
        }
    }

    public String getPosition() {
        return getCoordinates().toString();
    }

}
