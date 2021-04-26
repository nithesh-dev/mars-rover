import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;
import exceptions.RegionOutOFBoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void shouldBeAbleToMoveAsPerTheCommands() throws RegionOutOFBoundException {

        Rover rover = new Rover(1, 2, 'N');
        Plateau plateau = new Plateau(5, 5, new ArrayList<Rover>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "LMLMLMLMM";

        rover.takeStep(commands);

        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        assertEquals(1, rover.getX());
    }

    @Test
    void shouldBeAbleToMoveAsPerTheCommandsForMoreThan1Rover() throws RegionOutOFBoundException {

        Rover rover = new Rover(3, 3, 'E');
        Plateau plateau = new Plateau(5, 5, new ArrayList<Rover>());

        List<Rover> rovers = plateau.getRovers();
        rovers.add(rover);

        String commands = "MMRMMRMRRM";

        rover.takeStep(commands);

        Rover rover1 = new Rover(2, 1, 'W');
        rovers.add(rover1);

        String commandsRover1 = "MRMMLMRMRMMMRM";

        rover1.takeStep(commandsRover1);

        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getFacingDirection());
        System.out.println(rover1.getX() + " " + rover1.getY() + " " + rover1.getFacingDirection());

        assertEquals(5, rover.getX());
        assertEquals(3,rover1.getX());
        assertEquals(3, rover1.getY());
        assertEquals('S', rover1.getFacingDirection());
    }

    @Test
    void shouldBeAbleToThrowExceptionIfRoverIsTryingToMoveOutsideThePlateau() {
        Rover rover = new Rover(2, 3, 'N');
        Plateau plateau = new Plateau(5, 5, new ArrayList<Rover>());

        String instructions = "MMM";

        RegionOutOFBoundException regionOutOFBoundException = assertThrows(RegionOutOFBoundException.class, () -> rover.takeStep(instructions));

        assertEquals("Rover cannot be moved as it reaches it boundary", regionOutOFBoundException.getMessage());
    }
}