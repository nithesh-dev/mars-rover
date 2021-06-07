import com.marsrover.model.Directions;
import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;
import exceptions.RegionOutOFBoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {

    @Test
    @Disabled
    void shouldBeAbleToMoveAsPerTheCommands() throws RegionOutOFBoundException {

        Rover rover = new Rover(1, 2, Directions.N);
        Plateau plateau = Plateau.getInstance(5, 5, new ArrayList<>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "LMLMLMLMM";

        rover.move(commands);

        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        assertEquals(1, rover.getX());
    }

    @Test
    @Disabled
    void shouldBeAbleToMoveAsPerTheCommandsForMoreThan1Rover() throws RegionOutOFBoundException {

        Rover rover = new Rover(3, 3, Directions.E);
        Plateau plateau = Plateau.getInstance(5, 5, new ArrayList<>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "MMRMMRMRRM";

        rover.move(commands);

        Rover rover1 = new Rover(2, 1, Directions.W);
        rovers.add(rover1);

        String commandsRover1 = "MRMMLMRMRMMMRM";

        rover1.move(commandsRover1);

        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        System.out.println(rover1.getX() + " " + rover1.getY() + " " + rover1.getFacingDirection());

        assertEquals(5, rover.getX());
        assertEquals(3, rover1.getX());
        assertEquals(3, rover1.getY());
        assertEquals(Directions.S, rover1.getFacingDirection());
    }

    @Test
    @Disabled
    void shouldBeAbleToThrowExceptionIfRoverIsTryingToMoveOutsideThePlateau() {
        Rover rover = new Rover(2, 3, Directions.N);
        Plateau plateau = Plateau.getInstance(5, 5, new ArrayList<>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String instructions = "MMM";

        RegionOutOFBoundException regionOutOFBoundException = assertThrows(RegionOutOFBoundException.class, () -> rover.move(instructions));

        assertEquals("Rover cannot be moved as it reaches it boundary", regionOutOFBoundException.getMessage());
    }

    @Test
    @Disabled
    void shouldMoveRoverTillTheEastEdgeOfThePlateau() throws RegionOutOFBoundException {

        Rover rover = new Rover(4, 2, Directions.E);
        Plateau plateau = Plateau.getInstance(5, 2, new ArrayList<>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "M";

        rover.move(commands);

        System.out.println("->" + rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        assertEquals(5, rover.getX());
    }

    @Test
    @Disabled
    void shouldMoveRoverTillTheNorthEdgeOfThePlateau() throws RegionOutOFBoundException {

        Rover rover = new Rover(5, 1, Directions.N);
        Plateau plateau = Plateau.getInstance(5, 2, new ArrayList<>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "M";

        rover.move(commands);

        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        assertEquals(2, rover.getY());

    }

    @Test
    @Disabled
    void shouldMoveRoverTillTheSouthEdgeOfThePlateau() throws RegionOutOFBoundException {
        Rover rover = new Rover(5, 1, Directions.S);
        Plateau plateau = Plateau.getInstance(5, 2, new ArrayList<>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "M";

        rover.move(commands);

        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        assertEquals(0, rover.getY());
    }

    @Test
    @Disabled
    void shouldMoveRoverTillTheWestEdgeOfThePlateau() throws RegionOutOFBoundException {
        Rover rover = new Rover(1, 1, Directions.W);
        Plateau plateau = Plateau.getInstance(5, 2, new ArrayList<>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "M";

        rover.move(commands);

        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        assertEquals(0, rover.getX());
    }
}