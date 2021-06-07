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

    public void move(String commands) throws RegionOutOFBoundException {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L': turnLeft(this);
                case 'R': turnRight(this);
                case 'M': move(this);
            }
        }
    }

    private void move(Rover rover) throws RegionOutOFBoundException {
        Directions facingDirection = rover.facingDirection;
        switch (facingDirection) {
            case N: moveNorth(rover.X, rover.Y);
            case S: moveSouth(rover.X, rover.Y);
            case E: moveEast(rover.X, rover.Y);
            case W: moveWest(rover.X, rover.Y);
            default: throw new IllegalStateException("Unexpected value: " + facingDirection);
        }
    }


    private void moveWest(int XPosition, int YPosition) throws RegionOutOFBoundException {
        int positionToBeMoved = XPosition - 1;
        moveRoverPosition(positionToBeMoved, YPosition);
    }

    private void moveEast(int XPosition, int YPosition) throws RegionOutOFBoundException {
        int positionToBeMoved = XPosition + 1;
        moveRoverPosition(positionToBeMoved, YPosition);
    }

    private void moveSouth(int XPosition, int YPosition) throws RegionOutOFBoundException {
        int positionToBeMoved = YPosition - 1;
        moveRoverPosition(XPosition, positionToBeMoved);
    }

    private void moveNorth(int XPosition, int YPosition) throws RegionOutOFBoundException {
        int positionToBeMoved = YPosition + 1;
        moveRoverPosition(XPosition, positionToBeMoved);
    }

    private void turnRight(Rover rover) {
        if (rover.facingDirection == Directions.N) {
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


    private void moveRoverPosition(int XPosition, int YPosition) throws RegionOutOFBoundException {

        if (Plateau.checkRoverPosition(XPosition, YPosition)) {
            this.X = XPosition;
            this.Y = YPosition;
        } else {
            throw new RegionOutOFBoundException("Rover cannot be moved as it reaches it boundary");
        }
    }
}


// Parameters in methods

// More usage of enums

// don't pass whole obj when everything is not in use
