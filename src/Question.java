import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> options = new ArrayList<>();
    private String answer;
    private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P" };

    public Question(String question) {
        this.question = question;
    }

    public void addChoice(String choice, boolean answer) {
        options.add(choice);
        if (answer) {
            this.answer = choice;
        }
    }

    public String getChoice(String letter) {
        if (letter.equals("A")) {
            return options.get(0);
        } else if (letter.equals("B")) {
            return options.get(1);
        } else if (letter.equals("C")) {
            return options.get(2);
        } else if (letter.equals("D")) {
            return options.get(3);
        } // TODO: Complete for other answer choices
        return "";
    }

    public String toString() {
        String output = "\n";

        output += question + "\n";

        for (int i = 0; i < options.size(); i++) {
            output += letters[i] + " - " + options.get(i) + "\n";
        }

        output += "Enter letter of answer choice:";

        return output;
    }

    public String getAnswer() {
        return answer;
    }
}
