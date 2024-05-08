import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    private ArrayList<Question> questions = new ArrayList<>();
    private String name;
    private String description;
    private int score;

    public Exam(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String toString() {
        return name + ": " + description;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void take() {
        Scanner scanner = new Scanner(System.in);
        score = 0;

        for (Question question : questions) {
            System.out.println(question);
            String input = scanner.nextLine();
            while (input == "") {
                input = scanner.nextLine();
            }
            if (question.getAnswer().equals(question.getChoice(input.toUpperCase()))) {
                score++;
            }
        }

        System.out.println("\nTest Complete!\n");

        System.out.println("Your score was: " + score + "/" + questions.size());

        scanner.close();
    }

}
