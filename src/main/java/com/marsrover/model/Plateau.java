package com.marsrover.model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    static final int PLATEAU_INITIAL_LENGTH = 0;
    static final int PLATEAU_INITIAL_BREADTH = 0;

    private static Plateau plateau = null;
    private static int length;
    private static int breadth;
    private static List<Rover> rovers;

    private Plateau(int length, int breadth, List<Rover> rovers) {
        Plateau.length = length;
        Plateau.breadth = breadth;
        Plateau.rovers = rovers;
    }

    public static Plateau getInstance(int length, int breadth, ArrayList<Rover> rovers) {
        if (plateau == null) {
            plateau = new Plateau(length, breadth, rovers);
        }

        return plateau;
    }


    public static boolean checkRoverPosition(int XPosition, int YPosition) {
        return XPosition <= length
                && YPosition <= breadth
                && YPosition >= PLATEAU_INITIAL_BREADTH
                && XPosition >= PLATEAU_INITIAL_LENGTH;
    }

    public List<Rover> getRovers() {
        return rovers;
    }


}
