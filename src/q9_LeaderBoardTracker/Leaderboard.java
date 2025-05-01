package q9_LeaderBoardTracker;

import java.util.*;

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player)) return false;
        Player other = (Player) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}

public class Leaderboard {
    public static void main(String[] args) {
        Comparator<Player> playerComparator = (a, b) -> {
            if (b.score != a.score) return Integer.compare(b.score, a.score);
            return a.name.compareTo(b.name);
        };

        TreeSet<Player> leaderboard = new TreeSet<>(playerComparator);

        addOrUpdatePlayer(leaderboard, new Player("Alice", 150));
        addOrUpdatePlayer(leaderboard, new Player("Bob", 200));
        addOrUpdatePlayer(leaderboard, new Player("Charlie", 180));

        addOrUpdatePlayer(leaderboard, new Player("Alice", 220)); // Alice score updated

        printLeaderboard(leaderboard);
    }

    // Add or update a player's score
    public static void addOrUpdatePlayer(TreeSet<Player> leaderboard, Player newPlayer) {
        // Find existing player
        Player existing = null;
        for (Player p : leaderboard) {
            if (p.name.equals(newPlayer.name)) {
                existing = p;
                break;
            }
        }
        if (existing != null) {
            leaderboard.remove(existing);  // Remove old entry
        }
        leaderboard.add(newPlayer);       // Add updated entry
    }

    public static void printLeaderboard(TreeSet<Player> leaderboard) {
        System.out.println("Leaderboard:");
        for (Player player : leaderboard) {
            System.out.println(player);
        }
    }
}