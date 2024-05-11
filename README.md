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
- `public Exam(String name)`

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

# Write-Up

1. What was the goal of your project: What is the general problem addressed by your project? Are you trying something new? Are you designing a game for a particular niche?

   The goal of my project was to create a simple interface for creating exams and taking them. It can be used as a helpful study aid to review difficult questions and track improvement over previous scores. Also, quizzes can be easily shared through files similar to the Demo.java file included in the program. Although online examination systems exist online, most of these systems have paid features or require an internet connection while this program can be run entirely offline for free.

2. Besides grades, what was your motivation: Will your program be useful to you or others? Did you just want to make something fun?

   I was motivated to make this as a possible study aid to prepare for some of my exams. When I come across difficult multiple choice questions that I get wrong on practice exams, I can copy them into the program and separate them by subject. Then, I can retake them while reviewing to ensure that I have understood the concepts thoroughly.

3. What was your design and architecture: Describe how the parts of your system fit together. What classes are you implementing and why?

   I had to create a separate Question and Exam class, with each exam being composed of a list of questions. I also had to separate the answer choices and the question text of each question to create a sort of "modularity" that allowed for rearranging objects and only changing parts of the question rather than the entire thing. I also created a main runner file where the user adds and edits exams as well as takes them. The Demo class is used as an example of the capabilities of the program and a starting point for the user to understand how to use the program effectively.

4. What were some implementation challenges: What were the tricky problems you had to overcome, and how did you solve them?

   Editing the exam was the trickiest part of my program. The ability to rearrange questions' options as well as only change specific parts of the question required me to separate the Question class's answer choices and question text. I also had to force the user to have an answer for each question (or else the questions would be unanswerable), so I had to continuously monitor whether the question already had an answer through a boolean value.

5. Your conclusion or final paragraph: How well did you achieve your goals? Were you on task for the majority of the allotted time? Are you proud of your final product?

   I achieved most of the goals I had initially set for this project. I was able to create an exam system that could store various tests and answers as well as automatically grade exams. I had initially hoped to create a method to save all the exam data in a file so that the data would be stored even after the program ended, but I was unable to implement it due to time constraints and lack of knowledge on save objects in a file. I was on task for almost all of the allotted time, and I am proud of my final project.
