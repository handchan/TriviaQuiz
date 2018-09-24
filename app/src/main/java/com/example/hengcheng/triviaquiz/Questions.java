/**
 * By: Hengcheng Yu
 *
 * Date: May 31, 2017
 *
 * Description: This Questions class defines the questions object which is used in the
 * QuizActivity. It holds the questions, choices to the question, and answers to the questions.
 * It also contains various methods used to run the quiz.
 */
package com.example.hengcheng.triviaquiz;

public class Questions {
    //This array holds the questions.
    private String questions[]={
    "How long is the gestation period of an African Elephant?",
    "Which animal is known to nest at the University of Waterloo?",
    "What is a group of flamingos known as?",
    "What is an ogdoad?",
    "Which of the following roughly means 'good'?",
    "How many letters are there in the Greek alphabet?",
    "What is the most common blood type in humans? ",
    "What is a group of whales called?",
    "What is the national animal of Scotland?",
    "The use of chopsticks originated in what country?"
    };
    //This nested array holds the choices for each question.
    private String choices[][]={
    {"6 months","14 months","22 months","36 months"},
    {"White tailed deer","painted turtles", "Canada geese","nerds"},
    {"flock","herd","school","flamboyance"},
    {"A group of eight","a constant in math","an odd dude","Mr.Rao's first name"},
    {"monkey's uncle","the bee's knees","dank meme","kappa"},
    {"12","23","24","26"},
    {"A","B","AB","O"},
    {"a cluster","a school","a pod","a flock"},
    {"horse","eagle","unicorn","turtle"},
    {"China","Japan","Canada","Russia"}
    };

    //This array holds the correct answers.
    private String correctAnswers[] = {
     "22 months",
     "Canada geese",
     "flamboyance",
     "A group of eight",
     "the bee's knees",
     "24",
     "O",
     "a pod",
     "unicorn",
     "China"
    };
    //This method accepts a question number index and returns the question.
    public String getQuestions(int index){
        String question = questions[index];
        return question;
    }
    //This method accepts an index and returns the choice for button 1.
    public String getChoice1(int index){
        String choice0=choices[index][0];
        return choice0;
    }
    //This method accepts an index and returns the choice for button 2.
    public String getChoice2(int index){
        String choice1=choices[index][1];
        return choice1;
    }
    //This method accepts an index and returns the choice for button 3.
    public String getChoice3(int index){
        String choice2=choices[index][2];
        return choice2;
    }
    //This method accepts an index and returns the choice for button 4.
    public String getChoice4(int index){
        String choice3=choices[index][3];
        return choice3;
    }
    //This method accepts an index and returns the correct answer.
    public String getCorrectAnswer(int index){
        String answer=correctAnswers[index];
        return answer;
    }
}
