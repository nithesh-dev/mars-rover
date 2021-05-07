package com.marsrover.model;

import exceptions.RegionOutOFBoundException;

public class Rover {

    private int X;
    private int Y;
    private Directions facingDirection;

    public Rover(int X, int Y, Directions facingDirection) {
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

    public Directions getFacingDirection() {
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
        Directions facingDirection = rover.facingDirection;
        RegionOutOFBoundException regionOutOFBoundException = new RegionOutOFBoundException("Rover cannot be moved as it reaches it boundary");
        switch (facingDirection) {
            case N -> moveStepNorth(rover, regionOutOFBoundException);
            case S -> moveStepSouth(rover, regionOutOFBoundException);
            case E -> moveStepEast(rover, regionOutOFBoundException);
            case W -> moveStepWest(rover, regionOutOFBoundException);
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
        if (rover.facingDirection == Directions.N ) {
            rover.facingDirection = Directions.E;
        } else if (rover.facingDirection == Directions.S) {
            rover.facingDirection = Directions.W;
        } else if (rover.facingDirection == Directions.E) {
            rover.facingDirection = Directions.S;
        } else if (rover.facingDirection == Directions.W) {
            rover.facingDirection = Directions.N;
        }
    }

    private void turnLeft(Rover rover) {
        if (rover.facingDirection == Directions.N) {
            rover.facingDirection = Directions.W;
        } else if (rover.facingDirection == Directions.S) {
            rover.facingDirection = Directions.E;
        } else if (rover.facingDirection == Directions.E) {
            rover.facingDirection = Directions.N;
        } else if (rover.facingDirection == Directions.W) {
            rover.facingDirection = Directions.S;
        }
    }
}
