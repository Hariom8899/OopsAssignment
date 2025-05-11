package CollectorsAndSummarization;

import java.util.*;
import java.util.stream.Collectors;

class Comment {
    private String user;
    private String content;

    public Comment(String user, String content) {
        this.user = user;
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}

public class q47_CommentCounter {

    public static void main(String[] args) {
        // Sample list of comments
        List<Comment> comments = Arrays.asList(
                new Comment("Alice", "This is a great post!"),
                new Comment("Bob", "I agree, very informative."),
                new Comment("Alice", "Thanks for sharing."),
                new Comment("Charlie", "Nice article!"),
                new Comment("Bob", "Looking forward to more posts."),
                new Comment("Alice", "I have a question about the topic.")
        );

        // Group comments by user and count the number of comments per user
        Map<String, Long> commentCountByUser = comments.stream()
                .collect(Collectors.groupingBy(
                        Comment::getUser, // Group by user
                        Collectors.counting() // Count the number of comments for each user
                ));

        // Print the number of comments for each user
        commentCountByUser.forEach((user, count) -> {
            System.out.println(user + " has " + count + " comment(s).");
        });
    }
}

