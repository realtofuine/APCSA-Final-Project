import java.util.ArrayList;

public class Question { // Question object for exams
    private String question; // question text
    private ArrayList<String> options = new ArrayList<>(); // answer choice list
    private String answer; // correct answer choice text
    private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }; // letters list to print with answer choices to make it
                                                           // easier when typing answers; since only 26 letters are
                                                           // available, each question is limited to 26 answer choices

    public Question(String question) { // create question by adding the question text
        this.question = question;
    }

    public void setQuestion(String text) { // set question text, helpful when editing the exam
        question = text;
    }

    public void addChoice(String choice, boolean answer) { // add an answer choice to the question
        options.add(choice); // add answer choice to list
        if (answer) { // if the answer choice is marked as an answer, set answer to that choice
            this.answer = choice;
        }
    }

    public void clearChoices() { // remove/delete all answer choices
        options.clear();
    }

    public String getChoice(String letter) { // get the number of the choice corresponding to the letter entered
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
        return ""; // return empty string if input is not one of these letters
    }

    public String toString() { // print out question and ask for answer
        String output = "\n"; // create output string

        output += question + "\n";

        for (int i = 0; i < options.size(); i++) {
            output += "\t" + letters[i] + " - " + options.get(i) + "\n"; // add each answer choice with corresponding
                                                                         // letter
        }

        output += "Enter letter of answer choice:"; // ask for input

        return output;
    }

    public String getAnswer() { // return the string of the answer
        return answer;
    }

    public boolean hasAnswer() { // check if user has added an answer to the question
        if (answer != null) { // if answer is null, then user has not yet entered an answer
            return true;
        }

        return false;
    }

    public void shuffleQuestion() { // shuffle the question's answer choices
        for (int i = 0; i < options.size(); i++) {
            options.add((int) (Math.random() * options.size()), options.remove(i)); // for each answer choice, remove it
                                                                                    // and add it into a random index in
                                                                                    // the answer choice list
        }
    }

    public void printQuestion() { // print the question
        System.out.println(question); // print question text
        for (int i = 0; i < options.size(); i++) {
            System.out.println("\t" + letters[i] + " - " + options.get(i)); // print each answer choice
        }
    }
}
