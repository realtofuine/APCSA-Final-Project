public class Demo { // this file adds two demo tests for the user to try out
    public static void main(String[] args) {
        Exam demo1 = new Exam("Demo Exam 1", "Mathematics"); // create new math demo exam
        Question question1 = new Question("3 * 3 = ?"); // create first question
        question1.addChoice("4", false); // add answer choices to the question
        question1.addChoice("7", false);
        question1.addChoice("9", true);
        question1.addChoice("2", false);
        demo1.addQuestion(question1);
        Question question2 = new Question("23 - 17 = ?"); // create other questions to add to the exam
        question2.addChoice("6", true);
        question2.addChoice("2", false);
        question2.addChoice("1", false);
        question2.addChoice("23", false);
        demo1.addQuestion(question2);
        Question question3 = new Question("33 / 22 = ?");
        question3.addChoice("1.5", true);
        question3.addChoice("2.3", false);
        question3.addChoice("1.4", false);
        question3.addChoice("7.4", false);
        demo1.addQuestion(question3);
        Question question4 = new Question("Is every even number greater than 2 the sum of 2 primes?");
        question4.addChoice("Yes, it is trivial to prove.", false);
        question4.addChoice("Yes, but it is nontrivial to prove.", false);
        question4.addChoice("No, it has been proven false.", false);
        question4.addChoice("Nobody knows.", true);
        demo1.addQuestion(question4);
        demo1.shuffleExam(); // shuffle all the answer choices so that the answers appear in a random order
                             // for each question

        Exam demo2 = new Exam("Demo Exam 2", "Science"); // create new science demo exam
        Question question5 = new Question("What is the primary function of red blood cells in the human body?"); // create
                                                                                                                 // question
                                                                                                                 // for
                                                                                                                 // the
                                                                                                                 // exam
        question5.addChoice("Transporting oxygen", true); // add answer choices to the question
        question5.addChoice("Fighting infections", false);
        question5.addChoice("Producing hormones", false);
        question5.addChoice("Regulating body temperature", false);
        demo2.addQuestion(question5); // create other questions
        Question question6 = new Question("What is the chemical symbol for sodium?");
        question6.addChoice("So", false);
        question6.addChoice("Na", true);
        question6.addChoice("Sd", false);
        question6.addChoice("Nt", false);
        demo2.addQuestion(question6);
        Question question7 = new Question("Which of the following is a vector quantity?");
        question7.addChoice("Temperature", false);
        question7.addChoice("Speed", false);
        question7.addChoice("Mass", false);
        question7.addChoice("Velocity", true);
        demo2.addQuestion(question7);
        Question question8 = new Question(
                "What is the process by which rocks are broken down into smaller particles over time?");
        question8.addChoice("Subduction", false);
        question8.addChoice("Erosion", true);
        question8.addChoice("Deposition", false);
        question8.addChoice("Volcanism", false);
        demo2.addQuestion(question8);
        Question question9 = new Question(
                "Which of the following statements about quantum mechanics is true?");
        question9.addChoice("Quantum entanglement allows for instantaneous communication over any distance.", false);
        question9.addChoice(
                "The double-slit experiment proves that particles can exist in multiple states simultaneously.", true);
        question9.addChoice(
                "Heisenberg's uncertainty principle states that the position and momentum of a particle can be precisely known simultaneously.",
                false);
        question9.addChoice(
                "Schrödinger's cat is a thought experiment demonstrating the deterministic nature of quantum systems.",
                false);
        demo2.addQuestion(question9);
        demo2.shuffleExam(); // shuffle answer choices for this test too

        Main.examList.add(demo1); // add the exams to the ArrayList in main, which is possible because the list is
                                  // public
        Main.examList.add(demo2);
    }
}
