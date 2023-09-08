package ru.javamv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player pyotr = new Player(1, "Пётр", 340);
    Player vassily = new Player(2, "Василий", 1000);
    Player sirgay = new Player(3, "Сергей", 180);
    Player valera = new Player(4, "Валерия", 9999);
    Player billy = new Player(5, "Билли", 1000);

    @Test
    public void ifFirstPlayerWin() {

        game.register(valera);
        game.register(sirgay);

        int expected = 1;
        int actual = game.round("Валерия", "Сергей");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ifSecondPlayerWin() {

        game.register(pyotr);
        game.register(vassily);

        int expected = 2;
        int actual = game.round("Пётр", "Василий");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifThereIsDraw() {

        game.register(billy);
        game.register(vassily);

        int expected = 0;
        int actual = game.round("Билли", "Василий");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ifFirstPlayerIsNotRegistered() {

        game.register(vassily);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Билли", "Василий"));
    }

    @Test
    public void ifSecondPlayerIsNotRegistered() {

        game.register(vassily);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Василий", "Порфирий"));
    }

    @Test
    public void ifBothPlayersAreNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Анастасий", "Павсекакий"));
    }
}
