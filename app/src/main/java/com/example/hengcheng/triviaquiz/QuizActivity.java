/**
 * By: Hengcheng Yu
 *
 * Date: May 31, 2017
 *
 * Description: This class the mainline logic of my quiz app. The app asks question in a
 * multiple choice format and keeps track of their score. It also contains a timer. There are
 * various helper methods and innerclass event handling to run the app.
 */
package com.example.hengcheng.triviaquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import java.text.NumberFormat;
import android.os.SystemClock;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Chronometer;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;


public class QuizActivity extends Activity {
    // Instantiates variables.
    private Questions questions = new Questions();
    private TextView questionView;
    private TextView scoreView;
    private Button answerButton1;
    private Button answerButton2;
    private Button answerButton3;
    private Button answerButton4;
    private Chronometer timer;
    private SharedPreferences savedPrefs;
    private String answer;
    private int score = 0;
    private int questionNumber = 0;
    private long timeWhenStopped = 0;

    //This method initializes the activity and variables.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        timer = (Chronometer) findViewById(R.id.timer);
        questionView = (TextView) findViewById(R.id.questionView);
        scoreView = (TextView) findViewById(R.id.scoreView);
        answerButton1 = (Button) findViewById(R.id.answerButton1);
        answerButton2 = (Button) findViewById(R.id.answerButton2);
        answerButton3 = (Button) findViewById(R.id.answerButton3);
        answerButton4 = (Button) findViewById(R.id.answerButton4);
        updateScore(score);
        updateQuestion();
        timer.start(); // start a chronometer
        savedPrefs = getSharedPreferences( "TipCalcPrefs", MODE_PRIVATE );

        answerButton1.setOnClickListener( new answerButton1Listener() );
        answerButton2.setOnClickListener( new answerButton2Listener() );
        answerButton3.setOnClickListener( new answerButton3Listener() );
        answerButton4.setOnClickListener( new answerButton4Listener() );


    }
     //This method update the question, all button values, correct answer and keeps track
    // of the question number and resets after questions run out.
     private void updateQuestion(){
         if (questionNumber > 9){
             questionNumber=0;
         }
        questionView.setText(questions.getQuestions(questionNumber));
        answerButton1.setText(questions.getChoice1(questionNumber));
        answerButton2.setText(questions.getChoice2(questionNumber));
        answerButton3.setText(questions.getChoice3(questionNumber));
        answerButton4.setText(questions.getChoice4(questionNumber));
        answer = questions.getCorrectAnswer(questionNumber);
        questionNumber++ ;
    }
    //This method updates the score on the score view.
    private void updateScore(int score){
        scoreView.setText(""+score);
    }
    //Inner class for event handling of button 1
    class answerButton1Listener implements OnClickListener{
        //This method is called when the button is clicked and determines if they answered correctly.
        @Override
        public void onClick(View view) {
            if (answerButton1.getText() != answer) {
                score-=1;
                updateScore(score);
                updateQuestion();
                Toast.makeText( getApplicationContext(), "Boo!",
                        Toast.LENGTH_SHORT).show();

            }
            else if (answerButton1.getText() == answer) {
                score+=1;
                updateScore(score);
                updateQuestion();
                Toast.makeText( getApplicationContext(), "Yay!",
                Toast.LENGTH_SHORT).show();

            }
        }


    }
    //Inner class for event handling of button 2
    class answerButton2Listener implements OnClickListener{
        //This method is called when the button is clicked and determines if they answered correctly.
        @Override
        public void onClick(View view) {
            if (answerButton2.getText() != answer) {
                score-=1;
                updateScore(score);
                updateQuestion();
                Toast.makeText( getApplicationContext(), "Rip...",
                        Toast.LENGTH_SHORT).show();
            }
            else if (answerButton2.getText() == answer) {
                score+=1;
                updateScore(score);
                updateQuestion();Toast.makeText( getApplicationContext(), "You is Smart :)",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    //Inner class for event handling of button 3
    class answerButton3Listener implements OnClickListener{
        //This method is called when the button is clicked and determines if they answered correctly.
        @Override
        public void onClick(View view) {
            if (answerButton3.getText() != answer) {
                score-=1;
                updateScore(score);
                updateQuestion();
                Toast.makeText( getApplicationContext(), "That's not right...",
                        Toast.LENGTH_SHORT).show();

            }
            else if (answerButton3.getText() == answer) {
                score+=1;
                updateScore(score);
                updateQuestion();
                Toast.makeText( getApplicationContext(), "That's my boy",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
    //Inner class for event handling of button 4
    class answerButton4Listener implements OnClickListener{
        //This method is called when the button is clicked and determines if they answered correctly.
        @Override
        public void onClick(View view) {
            if (answerButton4.getText() != answer) {
                score-=1;
                updateScore(score);
                updateQuestion();
                Toast.makeText( getApplicationContext(), "errr..Awkward..",
                        Toast.LENGTH_SHORT).show();

            }
            else if (answerButton4.getText() == answer) {
                score+=1;
                updateScore(score);
                updateQuestion();
                Toast.makeText( getApplicationContext(), "You got this!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    //This called when the app is minimized and saves the current time.
    @Override
    public void onPause() {
        // Save the score instance variable
        Editor prefsEditor = savedPrefs.edit();
        timeWhenStopped = timer.getBase() - SystemClock.elapsedRealtime();
        timer.stop();
        prefsEditor.commit();

        // Calling the parent onPause() must be done LAST
        super.onPause();
    }
    //This method is called when the app is opened and resumes the time since minimized.
    @Override
    public void onResume() {

        super.onResume();
        timer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        timer.start();

    }
}

