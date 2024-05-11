import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Exam> examList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        printMenu();

    }

    public static void printMenu() {

        int selection = -1;
        System.out.println();
        System.out.println("Welcome to your exam dashboard!");
        System.out.println("Please enter the number corresponding to the option you want to select:");
        System.out.println("0 - Exit");
        System.out.println("1 - View all exams");
        System.out.println("2 - Create new exam");

        try {
            selection = scanner.nextInt();
        } catch (Exception e) {
            printMenu();
        }

        scanner.nextLine();

        if (selection == 1) {
            viewExams();
        } else if (selection == 2) {
            createExam();
        }
    }

    public static void createExam() {
        System.out.println();
        System.out.println("Creating new exam!");
        System.out.println("Please enter exam name:");

        String name = scanner.nextLine();
        System.out.println("Please enter exam description:");
        String description = scanner.nextLine();
        try {
            Exam test = new Exam(name, description);
            examList.add(test);
            System.out.println("Successfully created exam " + test);
        } catch (Exception e) {
            System.out.println("Error: " + e + ". Exam not created!");
        }

        System.out.println("Would you like to create another exam? (Y/N)");
        String answer = scanner.nextLine();

        if (answer.toUpperCase().equals("Y")) {
            createExam();
        } else {
            printMenu();
        }

    }

    public static void viewExams() {
        System.out.println();
        System.out.println("Here are your exams:");
        for (int i = 0; i < examList.size(); i++) {
            if (examList.get(i).getScore() != -1) {
                System.out.println(i + " - " + examList.get(i) + "\tScore: " + examList.get(i).getScore() + "/"
                        + examList.get(i).getNumQuestions());
            } else {
                System.out.println(i + " - " + examList.get(i));
            }

        }

        System.out.println("Would you like to (1) Edit an exam, (2) take an exam or (3) return to dashboard?");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Enter the number of the exam:");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num >= 0 && num < examList.size()) {
                editExam(num);
            } else {
                System.out.println("Invalid exam number!");
                viewExams();
            }
        } else if (choice == 2) {
            System.out.println("Enter the number of the exam:");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num >= 0 && num < examList.size()) {
                examList.get(num).take();

            } else {
                System.out.println("Invalid exam number!");
                viewExams();
            }
        } else {
            printMenu();
        }
    }

    public static void editExam(int num) {
        System.out.println();
        System.out.println("Now editing exam " + examList.get(num));
        examList.get(num).printAllQuestions();
        System.out.println();
        System.out.println("(1) Add question, (2) Edit previous question, (3) Shuffle answer choices, (4) Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice == 1 || choice == 2 || choice == 3) {
            if (choice == 1) {
                System.out.println("Enter question text.");
                String text = scanner.nextLine();
                Question question = new Question(text);

                System.out.println(
                        "Now enter the answer choices, with each choice on a separate line. If the choice is the correct answer, type \"*\" in front of the choice. When done, type \"DONE\"");
                String answer = scanner.nextLine();
                while (!answer.equals("DONE") || !question.hasAnswer()) {
                    if (!question.hasAnswer() && answer.equals("DONE")) {
                        System.out.println("You must enter an answer by typing \"*\" and the answer!");
                    }
                    if (!answer.equals("DONE")) {
                        if (answer.indexOf("*") == 0) {
                            question.addChoice(answer.substring(1), true);
                        } else {
                            question.addChoice(answer, false);
                        }
                    }
                    answer = scanner.nextLine();
                }

                examList.get(num).addQuestion(question);
                System.out.println("Question with answer \"" + question.getAnswer() + "\" added");
            } else if (choice == 2) {
                System.out.println("Question number to edit?");
                int number = scanner.nextInt();
                scanner.nextLine();
                number--;
                while (!(number >= 0 && number < examList.get(num).getNumQuestions())) {
                    System.out.println("Invalid number! Enter valid number.");
                    number = scanner.nextInt();
                    scanner.nextLine();
                }
                Question q = examList.get(num).getQuestion(number);
                q.printQuestion();
                System.out.println("(1) Edit question text, (2) Edit answer choices, (3) Cancel");
                int selection = scanner.nextInt();
                scanner.nextLine();

                if (selection == 1) {
                    System.out.println("Enter new question text:");
                    String text = scanner.nextLine();
                    q.setQuestion(text);
                } else if (selection == 2) {
                    q.clearChoices();
                    System.out.println(
                            "Enter the answer choices, with each choice on a separate line. If the choice is the correct answer, type \"*\" in front of the choice. When done, type \"DONE\"");
                    String answer = scanner.nextLine();
                    while (!answer.equals("DONE") || !q.hasAnswer()) {
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

                    System.out.println("Question with new answer \"" + q.getAnswer() + "\" edited");
                }

            } else if (choice == 3) {
                examList.get(num).shuffleExam();
            }

            System.out.println();
            System.out.println("Exam preview:");
            examList.get(num).printAllQuestions();

            System.out.println("(1) Add question, (2) Edit previous question, (3) Shuffle answer choices, (4) Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

        }

        viewExams();
    }
}
