import java.util.ArrayList;

public class Exam {
    private ArrayList<Question> questions = new ArrayList<>();
    private String name;
    private String description;

    public Exam(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String toString() {
        return name + ": " + description;
    }

    public void addQuestion() {

    }

}
