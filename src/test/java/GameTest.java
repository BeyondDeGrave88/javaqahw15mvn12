import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player Barbarian = new Player(1, "Barbarian", 120);
        Player Druid = new Player(2, "Druid", 110);
        Game game = new Game();

        game.register(Barbarian);
        game.register(Druid);

        int actual = game.round("Barbarian", "Druid");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void testWhenSecondPlayerWin() {
        Player Barbarian = new Player(1, "Barbarian", 100);
        Player Druid = new Player(2, "Druid", 110);
        Game game = new Game();

        game.register(Barbarian);
        game.register(Druid);

        int actual = game.round("Barbarian", "Druid");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenDraw() {
        Player Barbarian = new Player(1, "Barbarian", 100);
        Player Druid = new Player(2, "Druid", 100);
        Game game = new Game();

        game.register(Barbarian);
        game.register(Druid);

        int actual = game.round("Barbarian", "Druid");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenFirstPlayerNotExist() {
        Player Barbarian = new Player(1, "Druid", 100);
        Game game = new Game();

        game.register(Barbarian);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Barbarian", "Spiritborn")
        );

    }
    @Test
    public void testWhenSecondPlayerNotExist() {
        Player Barbarian = new Player(1, "Barbarian", 100);
        Game game = new Game();

        game.register(Barbarian);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Barbarian", "Necromancer")
        );

    }

}