package com.marsrover.model;

import java.util.List;

public class Plateau {

    static final int PLATEAU_INITIAL_LENGTH = 0;
    static final int PLATEAU_INITIAL_BREADTH = 0;

    private static int length;
    private static int breadth;
    private List<Rover> rovers;

    public Plateau(int length, int breadth, List<Rover> rovers) {
        Plateau.length = length;
        Plateau.breadth = breadth;
        this.rovers = rovers;
    }

    public static int getLength() {
        return length;
    }

    public static int getBreadth() {
        return breadth;
    }

    public static boolean checkRoverPosition(int positionToBeMoved) {
        return positionToBeMoved <= getBreadth()
                && positionToBeMoved <= getLength()
                && positionToBeMoved >= PLATEAU_INITIAL_BREADTH
                && positionToBeMoved >= PLATEAU_INITIAL_LENGTH;
    }

    public List<Rover> getRovers() {
        return rovers;
    }


}
