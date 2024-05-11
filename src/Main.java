//Rishi Rai

import java.util.ArrayList;
import java.util.Scanner;

public class Main { // runner
    static ArrayList<Exam> examList = new ArrayList<>(); // create list of exams
    static Scanner scanner = new Scanner(System.in); // get input

    public static void main(String[] args) {
        Demo.main(args); // run demo to get demo exams, can be deleted if no demo exams wanted
        printMenu(); // print the menu options

    }

    public static void printMenu() { // print menu options

        int selection = -1;
        System.out.println();
        System.out.println("Welcome to your exam dashboard!");
        System.out.println("Please enter the number corresponding to the option you want to select:");
        System.out.println("0 - Exit");
        System.out.println("1 - View all exams");
        System.out.println("2 - Create new exam");

        selection = getInput(); // get selection input

        if (selection == 1) { // create or view exams
            viewExams();
        } else if (selection == 2) {
            createExam();
        }
    }

    public static void createExam() {
        System.out.println();
        System.out.println("Creating new exam!");
        System.out.println("Please enter exam name:");

        String name = scanner.nextLine(); // get exam name
        System.out.println("Please enter exam description:");
        String description = scanner.nextLine(); // get exam description
        try {
            Exam test = new Exam(name, description);
            examList.add(test); // add exam
            System.out.println("Successfully created exam " + test);
        } catch (Exception e) { // if error, do not create exam
            System.out.println("Error: " + e + ". Exam not created!");
        }

        System.out.println("Would you like to create another exam? (Y/N)"); // ask if another exam wanted
        String answer = scanner.nextLine();

        if (answer.toUpperCase().equals("Y")) { // if yes, repeat creating exam
            createExam();
        } else {
            printMenu(); // otherwise, print menu again
        }

    }

    public static void viewExams() {
        System.out.println();
        System.out.println("Here are your exams:");
        for (int i = 0; i < examList.size(); i++) { // iterate through exams and print them
            if (examList.get(i).getScore() != -1) { // if exam has score, print that too
                System.out.println(i + " - " + examList.get(i) + "\tScore: " + examList.get(i).getScore() + "/"
                        + examList.get(i).getNumQuestions());
            } else { // otherwise, do not print the last taken score
                System.out.println(i + " - " + examList.get(i));
            }

        }

        System.out.println("Would you like to (1) Edit an exam, (2) take an exam or (3) return to dashboard?");
        int choice = getInput(); // get input

        if (choice == 1) { // if edit exam
            System.out.println("Enter the number of the exam:");
            int num = getInput(); // get exam number
            if (num >= 0 && num < examList.size()) {
                editExam(num); // run editing method
            } else {
                System.out.println("Invalid exam number!");
                viewExams(); // or else go back to viewing exams
            }
        } else if (choice == 2) { // if taking an exam
            System.out.println("Enter the number of the exam:");
            int num = getInput();
            if (num >= 0 && num < examList.size()) {
                examList.get(num).take(); // take the exam wanted

            } else {
                System.out.println("Invalid exam number!");
                viewExams(); // if invalid exam number, go back to viewing exams
            }
        } else {
            printMenu(); // print the menu otherwise
        }
    }

    public static void editExam(int num) { // edit the exam
        System.out.println();
        System.out.println("Now editing exam " + examList.get(num)); // tell name of exam being edited
        examList.get(num).printAllQuestions(); // print the exam
        System.out.println();
        System.out.println("(1) Add question, (2) Edit previous question, (3) Shuffle answer choices, (4) Exit");

        int choice = getInput();

        while (choice == 1 || choice == 2 || choice == 3) { // ensure choice is valid
            if (choice == 1) {
                System.out.println("Enter question text."); // ask for question text
                String text = scanner.nextLine();
                Question question = new Question(text); // create a new question with text

                System.out.println(
                        "Now enter the answer choices, with each choice on a separate line. If the choice is the correct answer, type \"*\" in front of the choice. When done, type \"DONE\"");
                String answer = scanner.nextLine(); // get answer chouces
                while (!answer.equals("DONE") || !question.hasAnswer()) { // add answer choices to question
                    if (!question.hasAnswer() && answer.equals("DONE")) { // ensure that each question had an answer
                        System.out.println("You must enter an answer by typing \"*\" and the answer!");
                    }
                    if (!answer.equals("DONE")) {
                        if (answer.indexOf("*") == 0) { // if choice marked as answer, add as answer
                            question.addChoice(answer.substring(1), true);
                        } else { // or else, do not add as answer
                            question.addChoice(answer, false);
                        }
                    }
                    answer = scanner.nextLine();
                }

                examList.get(num).addQuestion(question); // add the question to the exam
                System.out.println("Question with answer \"" + question.getAnswer() + "\" added");
            } else if (choice == 2) { // else if editing a question
                System.out.println("Question number to edit?");
                int number = getInput(); // get the question number
                number--;
                while (!(number >= 0 && number < examList.get(num).getNumQuestions())) { // ensure that question number
                                                                                         // is valid
                    System.out.println("Invalid number! Enter valid number.");
                    number = getInput();
                }
                Question q = examList.get(num).getQuestion(number); // get the question reference and store it
                q.printQuestion(); // print the question
                System.out.println("(1) Edit question text, (2) Edit answer choices, (3) Cancel");
                int selection = getInput(); // get input

                if (selection == 1) {
                    System.out.println("Enter new question text:");
                    String text = scanner.nextLine();
                    q.setQuestion(text); // change the question text
                } else if (selection == 2) {
                    q.clearChoices(); // remove all answer choices and ask user to enter new ones
                    System.out.println(
                            "Enter the answer choices, with each choice on a separate line. If the choice is the correct answer, type \"*\" in front of the choice. When done, type \"DONE\"");
                    String answer = scanner.nextLine();
                    while (!answer.equals("DONE") || !q.hasAnswer()) { // same as adding answers as seen previously
                        if (!q.hasAnswer() && answer.equals("DONE")) {
                            System.out.println("You must enter an answer by typing \"*\" and the answer!");
                        }
                        if (!answer.equals("DONE")) {
                            if (answer.indexOf("*") == 0) {
                                q.addChoice(answer.substring(1), true);
                            } else {
                                q.addChoice(answer, false);
                            }
                        }
                        answer = scanner.nextLine();
                    }

                    System.out.println("Question with new answer \"" + q.getAnswer() + "\" edited"); // tell which
                                                                                                     // question edited
                }

            } else if (choice == 3) { // if wanting to shuffle answer choices, shuffle them
                examList.get(num).shuffleExam();
            }

            System.out.println();
            System.out.println("Exam preview:"); // provide preview of the entire exam
            examList.get(num).printAllQuestions();

            System.out.println("(1) Add question, (2) Edit previous question, (3) Shuffle answer choices, (4) Exit");
            choice = getInput();

        }

        viewExams(); // show all exams
    }

    public static int getInput() { // get input method validates input and handles error when a number is not typed
                                   // in
        int number = -1;

        while (number == -1) {
            try {
                number = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                scanner.nextLine();
            }
        }

        scanner.nextLine();
        return number;
    }
}
