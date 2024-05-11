# APCSA Final Project - Exam Creation System

# Decomp

The name of this project is "Examination Creation System."

The program enables the user to create and save multiple-choice exams that are automatically graded once taken. The scores are saved and shown in a list along with exam names and descriptions. Additionally, the user can shuffle the answer choices for the questions to make cheating more difficult and can easily edit exams after they are already created.

## Classes

### `public class Exam`

### Variables

- `ArrayList<Question>` to store all the questions in the exam
- `String name` to store the exam's name
- `String description` to store the exam's description
- `int score` to store the latest score achieved on the exam

### Constructors

- `public Exam(String name, String description)`

### Methods

- `public String toString()` to return exam name and description
- `public void addQuestion(Question question)` to add a question to the exam
- `public void take()` to take the exam and get a score
- `public int getScore()` to return the score on the exam
- `public int getNumQuestions()` to get the number of questions on the exam
- `public void shuffleExam()` to shuffle the answer choices on each of the questions
- `public void printAllQuestions()` to print all the questions
- `public void printAllQuestionsAndAnswers()` to print all the questions and the answers
- `public Question getQuestion(int num)` to get the corresponding question to the question number

### `public class Question`

### Variables

- `String question` to store the question's text
- `ArrayList<String> options` to store the question's possible answers
- `String answer` to store the answer to the question
- `String[] letters` to store the possible answer choice letters

### Constructors

- `public Question(String question)`

### Methods

- `public void setQuestion(String text)` to set the question text
- `public void addChoice(String choice, boolean answer)` to add a choice to the question
- `public void clearChoices()` to delete the question's answer choices
- `public String getChoice(String letter)` to get the answer choice corresponding to the letter
- `public String toString()` to return the question and prompt for an answer
- `public String getAnswer()` to return the question's answer
- `public boolean hasAnswer()` to return whether a question has an answer or not
- `public void shuffleQuestion()` to shuffle the answer choices of an individual question
- `public void printQuestion()` to print the question with formatting

### `public class Main`

### Variables

- `ArrayList<Exam> examList` to store the created exams

### Constructors

- None because this is the main runner file

### Methods

- `public static void printMenu()` to print out the program's main menu
- `public static void createExam()` to create an exam to add to the exam list
- `public static void viewExams()` to show all created exams
- `public static void editExam(int num)` to allow the user to edit the exams
- `public static int getInput()` to get the user input with error handling

### `public class Demo`

### Variables

- Many `Question` variables and `Exam` variables to create some demo tests

### Constructors

- None because this simply creates sample/demo exams for the user to test out and run

### Methods

- None
