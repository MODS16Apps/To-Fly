package edu.fau.lasseter.tofly2016;

import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity implements View.OnClickListener{
    //initialize variables
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    RadioButton answer;
    RadioGroup grp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }
    @Override
    protected void onStart() {
        super.onStart();
        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        if(qid!=10){
            currentQ = quesList.get(qid);
        }
        txtQuestion = (TextView) findViewById(R.id.textView1);
        rda = (RadioButton) findViewById(R.id.radio0);
        rdb = (RadioButton) findViewById(R.id.radio1);
        rdc = (RadioButton) findViewById(R.id.radio2);
        if (qid==10) {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        } else {
            currentQ = quesList.get(qid);
            setQuestionView();
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        qid++;
    }

    //resets the radio clicks and changes the question/answers
    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rda.setChecked(false);
        rdb.setChecked(false);
        rdc.setChecked(false);
    }

    //displays the "correct" screen
    public void displayCorrect() {
        Intent i = new Intent(this, correctanswer.class);
        startActivity(i);
    }

    //displays the "incorrect" screen
    public void displayIncorrect() {
        Intent i = new Intent(this, IncorrectAnswer.class);
        startActivity(i);
    }

    //implements View.onClickListener for the "next" button
    public void onClick(View v){}

    //decides what to do when the next button is clicked
    public void next(View v){
        grp = (RadioGroup) findViewById(R.id.radioGroup1);
        answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
        if (answer == null) {
            Toast.makeText(QuizActivity.this, "Make a selection", Toast.LENGTH_LONG).show();
        } else if (currentQ.getANSWER().equals(answer.getText())) {
            score++;
            grp.clearCheck();
            displayCorrect();
        } else if (!(currentQ.getANSWER().equals(answer.getText()))) {
            grp.clearCheck();
            displayIncorrect();
        }
    }
}
