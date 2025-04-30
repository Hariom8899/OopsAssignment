package q12_VotingSystem;

import java.util.*;
import java.util.stream.Collectors;

public class VotingSystem {
    public static void main(String[] args) {
        // Map to store candidate names and their vote counts
        Map<String, Integer> votes = new HashMap<>();

        // Simulate voting
        castVote(votes, "Alice");
        castVote(votes, "Bob");
        castVote(votes, "Alice");
        castVote(votes, "Charlie");
        castVote(votes, "Bob");
        castVote(votes, "Bob");

        // Display sorted vote counts
        displaySortedVotes(votes);
    }

    // Cast a vote for a candidate (increment the vote count)
    public static void castVote(Map<String, Integer> votes, String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    // Display candidates sorted by vote count in descending order
    public static void displaySortedVotes(Map<String, Integer> votes) {
        // Sort the candidates by vote count in descending order
        List<Map.Entry<String, Integer>> sortedVotes = votes.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Sort descending
                .collect(Collectors.toList());

        // Display sorted results
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedVotes) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
