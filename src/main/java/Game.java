import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    // Метод регистрации игрока
    public void register(Player player) {
        players.put(player.getName(), player);
    }

    // Метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

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
}