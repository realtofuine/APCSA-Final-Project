public class Testing {
    public static void main(String[] args) {
        Exam test = new Exam("Exam 1", "First Testing Exam");
        System.out.println(test);
        Question question1 = new Question("What is the meaning of life?");
        question1.addChoice("option 1", false);
        question1.addChoice("option 2", true);
        question1.addChoice("option 3", false);
        question1.addChoice("option 4", false);
        test.addQuestion(question1);
        test.take();

    }
}
