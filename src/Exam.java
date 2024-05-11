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

    public Exam(String name) {
        this.name = name;
        this.description = "";
    }

    public String toString() { // return string of the exam's name and description
        return name + ": " + description;
    }

    public void addQuestion(Question question) { // add a question by inserting question into question arraylist
        questions.add(question);
    }

    public void take() { // take the exam
        Scanner scan = new Scanner(System.in); // create input scanner

        if (questions.size() == 0) { // if the exam is empty, simply print empty exam
            System.out.println("Empty exam!");
        } else { // if not empty, take the exam
            score = 0; // set score to 0
            for (Question question : questions) { // iterate through questions and print each one
                System.out.println(question); // utilizing toString method in Question.java
                String input = scan.nextLine(); // read input from the next line
                boolean error = false;
                try {
                    question.getChoice(input.toUpperCase());
                    error = false;
                } catch (Exception e) {
                    error = true;
                }
                while (input == "" || error || question.getChoice(input.toUpperCase()).equals("")) { // ensure that the
                                                                                                     // input is not
                                                                                                     // blank
                    System.out.println("Invalid input!");
                    input = scan.nextLine();
                    try {
                        question.getChoice(input.toUpperCase());
                        error = false;
                    } catch (Exception e) {
                        error = true;
                    }
                }

                if (question.getAnswer().equals(question.getChoice(input.toUpperCase()))) { // if answer is correct,
                                                                                            // increase score
                    score++;
                }
            }

            System.out.println("\nTest Complete!\n"); // show that test is complete

            System.out.println("Your score was: " + score + "/" + questions.size()); // print out score
            System.out.println("Would you like to view the correct answers to the exam? (Y/N)"); // ask if user wants to
                                                                                                 // see correct
                                                                                                 // responses
            String response = "";

            try {
                response = scan.nextLine(); // get response
            } catch (Exception e) {

            }

            if (response.toUpperCase().equals("Y")) { // if yes, print all the questions and answers
                printAllQuestionsAndAnswers();
            }
        }
        Main.viewExams(); // go back to main class viewing exams

        scan.close(); // close the scanner

    }

    public int getScore() { // get the exam score
        return score;
    }

    public int getNumQuestions() { // get the number of questions on the exam
        return questions.size();
    }

    public void shuffleExam() { // shuffle the answers to each question on the exam
        for (Question question : questions) { // iterate through the questions
            question.shuffleQuestion(); // shuffle the answer choices of the question
        }
    }

    public void printAllQuestions() { // print all the questions
        int i = 1;
        for (Question question : questions) { // iterate through the questions
            System.out.print(i + ". "); // print the question number
            question.printQuestion(); // print the rest of the question
            i++; // increment the question number
        }
    }

    public void printAllQuestionsAndAnswers() { // print all the questions and answers on the test
        int i = 1; // question number
        for (Question question : questions) { // iterate through the questions
            System.out.print(i + ". "); // same as previous method, print the question
            question.printQuestion();
            System.out.println("Answer: " + question.getAnswer()); // also print the correct answer to the question
            System.out.println();
            i++; // increment question number
        }
    }

    public Question getQuestion(int num) { // return the text of the question
        return questions.get(num);
    }

}
