package praktikum.Core2.APIexample;

import java.util.ArrayList;
import java.util.List;

public class Post {
    int id;
    String text;
    List<Comment> commentaries = new ArrayList<>();

    private Post() {
    }

    public Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public void addComment(Comment comment) {
        commentaries.add(comment);
    }

    public List<Comment> getCommentaries() {
        return commentaries;
    }

    public int getId() {
        return id;
    }

}
