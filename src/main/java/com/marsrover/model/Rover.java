package com.marsrover.model;

import exceptions.RegionOutOFBoundException;

public class Rover {

    private int X;
    private int Y;
    private char facingDirection;

    public Rover(int X, int Y, char facingDirection) {
        this.X = X;
        this.Y = Y;
        this.facingDirection = facingDirection;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public char getFacingDirection() {
        return facingDirection;
    }

    public void takeStep(String commands) throws RegionOutOFBoundException {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> turnLeft(this);
                case 'R' -> turnRight(this);
                case 'M' -> takeStep(this);
            }
        }
    }

    private void takeStep(Rover rover) throws RegionOutOFBoundException {
        char facingDirection = rover.facingDirection;
        RegionOutOFBoundException regionOutOFBoundException = new RegionOutOFBoundException("Rover cannot be moved as it reaches it boundary");
        switch (facingDirection) {
            case 'N' -> moveStepNorth(rover, regionOutOFBoundException);
            case 'S' -> moveStepSouth(rover, regionOutOFBoundException);
            case 'E' -> moveStepEast(rover, regionOutOFBoundException);
            case 'W' -> moveStepWest(rover, regionOutOFBoundException);
        }
    }


    private void moveStepWest(Rover rover, RegionOutOFBoundException regionOutOFBoundException) throws RegionOutOFBoundException {
        int positionToBeMoved = rover.X - 1;
        if (Plateau.checkRoverPosition( positionToBeMoved)) {
            rover.X = positionToBeMoved;
        } else {
            throw regionOutOFBoundException;
        }
    }

    private void moveStepEast(Rover rover, RegionOutOFBoundException regionOutOFBoundException) throws RegionOutOFBoundException {
        int positionToBeMoved = rover.X + 1;
        if (Plateau.checkRoverPosition( positionToBeMoved)) {
            rover.X = positionToBeMoved;
        } else {
            throw regionOutOFBoundException;
        }
    }

    private void moveStepSouth(Rover rover, RegionOutOFBoundException regionOutOFBoundException) throws RegionOutOFBoundException {
        int positionToBeMoved = rover.Y - 1;
        if (Plateau.checkRoverPosition(positionToBeMoved)) {
            rover.Y = positionToBeMoved;
        } else {
            throw regionOutOFBoundException;
        }
    }

    private void moveStepNorth(Rover rover, RegionOutOFBoundException regionOutOFBoundException) throws RegionOutOFBoundException {
        int positionToBeMoved = rover.Y + 1;
        if (Plateau.checkRoverPosition(positionToBeMoved)) {
            rover.Y = positionToBeMoved;
        } else {
            throw regionOutOFBoundException;
        }
    }

    private void turnRight(Rover rover) {
        if (rover.facingDirection == 'N') {
            rover.facingDirection = 'E';
        } else if (rover.facingDirection == 'S') {
            rover.facingDirection = 'W';
        } else if (rover.facingDirection == 'E') {
            rover.facingDirection = 'S';
        } else if (rover.facingDirection == 'W') {
            rover.facingDirection = 'N';
        }
    }

    private void turnLeft(Rover rover) {
        if (rover.facingDirection == 'N') {
            rover.facingDirection = 'W';
        } else if (rover.facingDirection == 'S') {
            rover.facingDirection = 'E';
        } else if (rover.facingDirection == 'E') {
            rover.facingDirection = 'N';
        } else if (rover.facingDirection == 'W') {
            rover.facingDirection = 'S';
        }
    }
}
