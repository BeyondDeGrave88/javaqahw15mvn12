import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    // Метод регистрации игрока
    public void register(Player player) {
        players.add(player);
    }

    // Метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }


        // Определяем победителя
        if (player1.getStrength() > player2.getStrength()) {
            return 1; // Победа первого игрока
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2; // Победа второго игрока
        } else {
            return 0; // Ничья
        }
    }

    private Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

}