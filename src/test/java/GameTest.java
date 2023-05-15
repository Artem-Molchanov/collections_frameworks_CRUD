import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {


    Game game = new Game();

    @Test
    public void testWhenFirstPlayerWins() {

        Player firstPlayer = new Player(1, "Firstplayer", 10);
        Player secondPlayer = new Player(2, "Secondplayer", 5);

        game.register(firstPlayer);
        game.register(secondPlayer);

        int actual = game.round("Firstplayer", "Secondplayer");
        int expected = 1;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void testWhenSecondPlayerWins() {

        Player firstPlayer = new Player(1, "Firstplayer", 5);
        Player secondPlayer = new Player(2, "Secondplayer", 10);

        game.register(firstPlayer);
        game.register(secondPlayer);

        int actual = game.round("Firstplayer", "Secondplayer");
        int expected = 2;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void testWhenBothPlayerStrEquals() {

        Player firstPlayer = new Player(1, "Firstplayer", 10);
        Player secondPlayer = new Player(2, "Secondplayer", 10);

        game.register(firstPlayer);
        game.register(secondPlayer);

        int actual = game.round("Firstplayer", "Secondplayer");
        int expected = 0;

        Assertions.assertEquals(actual, expected);

    }


    @Test
    public void testWhenUnregisteredFirstPlayerTryPlay() {

        Player firstPlayer = new Player(1, "Firstplayer", 5);
        Player secondPlayer = new Player(2, "Secondplayer", 10);

        game.register(firstPlayer);
        game.register(secondPlayer);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Thirdplayer", "Firstplayer")
        );


    }


    @Test
    public void testWhenUnregisteredSecondPlayerTryPlay() {

        Player firstPlayer = new Player(1, "Firstplayer", 5);
        Player secondPlayer = new Player(2, "Secondplayer", 10);

        game.register(firstPlayer);
        game.register(secondPlayer);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Secondplayer", "Thirdplayer")
        );


    }
}
