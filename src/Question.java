import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> options = new ArrayList<>();
    private String answer;
    private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

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
        } else if (letter.equals("E")) {
            return options.get(4);
        } else if (letter.equals("F")) {
            return options.get(5);
        } else if (letter.equals("G")) {
            return options.get(6);
        } else if (letter.equals("H")) {
            return options.get(7);
        } else if (letter.equals("I")) {
            return options.get(8);
        } else if (letter.equals("J")) {
            return options.get(9);
        } else if (letter.equals("K")) {
            return options.get(10);
        } else if (letter.equals("L")) {
            return options.get(11);
        } else if (letter.equals("M")) {
            return options.get(12);
        } else if (letter.equals("N")) {
            return options.get(13);
        } else if (letter.equals("O")) {
            return options.get(14);
        } else if (letter.equals("P")) {
            return options.get(15);
        } else if (letter.equals("Q")) {
            return options.get(16);
        } else if (letter.equals("R")) {
            return options.get(17);
        } else if (letter.equals("S")) {
            return options.get(18);
        } else if (letter.equals("T")) {
            return options.get(19);
        } else if (letter.equals("U")) {
            return options.get(20);
        } else if (letter.equals("V")) {
            return options.get(21);
        } else if (letter.equals("W")) {
            return options.get(22);
        } else if (letter.equals("X")) {
            return options.get(23);
        } else if (letter.equals("Y")) {
            return options.get(24);
        } else if (letter.equals("Z")) {
            return options.get(25);
        }
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

    public boolean hasAnswer() {
        if (answer != null) {
            return true;
        }

        return false;
    }
}
