import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    private ArrayList<Question> questions = new ArrayList<>(); // create list of questions on the exam
    private String name; // name of the exam
    private String description; // exam description
    private int score = -1; // initialize exam score, which is -1 until the exam is taken

    public Exam(String name, String description) { // create Exam with title and description
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
        Scanner scan = new Scanner(System.in);

        if (questions.size() == 0) {
            System.out.println("Empty exam!");
        } else {
            score = 0;
            for (Question question : questions) {
                System.out.println(question);
                String input = scan.nextLine();
                while (input == "") {
                    input = scan.nextLine();
                }
                if (question.getAnswer().equals(question.getChoice(input.toUpperCase()))) {
                    score++;
                }
            }

            System.out.println("\nTest Complete!\n");

            System.out.println("Your score was: " + score + "/" + questions.size());
            System.out.println("Would you like to view the correct answers to the exam? (Y/N)");
            String response = scan.nextLine();
            if (response.toUpperCase().equals("Y")) {
                printAllQuestionsAndAnswers();
            }
        }
        Main.viewExams();

        scan.close();

    }

    public int getScore() {
        return score;
    }

    public int getNumQuestions() {
        return questions.size();
    }

    public void shuffleExam() {
        for (Question question : questions) {
            question.shuffleQuestion();
        }
    }

    public void printAllQuestions() {
        int i = 1;
        for (Question question : questions) {
            System.out.print(i + ". ");
            question.printQuestion();
            i++;
        }
    }

    public void printAllQuestionsAndAnswers() {
        int i = 1;
        for (Question question : questions) {
            System.out.print(i + ". ");
            question.printQuestion();
            System.out.println("Answer: " + question.getAnswer());
            System.out.println();
            i++;
        }
    }

    public Question getQuestion(int num) {
        return questions.get(num);
    }

}
