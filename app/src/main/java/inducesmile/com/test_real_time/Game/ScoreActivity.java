package inducesmile.com.test_real_time.Game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import inducesmile.com.test_real_time.AppNav.MenuActivity;
import inducesmile.com.test_real_time.Helper.QuestionsHandler;
import inducesmile.com.test_real_time.R;

public class ScoreActivity extends AppCompatActivity {
    private int correct_answer;
    private int user_answer;
    private int user_score;
    QuestionsHandler handler = QuestionsHandler.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        user_answer=getIntent().getIntExtra("user_answer",0);
        correct_answer=getIntent().getIntExtra("correct_answer",0);
        user_score=getIntent().getIntExtra("question_score",0);
        TextView userScoreTv = findViewById(R.id.userScore_tv);
        userScoreTv.setText(Integer.toString(user_score));

        TextView userAnswerTv = findViewById(R.id.userAnswer_TV);
        userAnswerTv.setText(Integer.toString(user_answer));

        TextView correctAnswerTv = findViewById(R.id.correctAnswer_tv);
        correctAnswerTv.setText(Integer.toString(correct_answer));

        handler.updateUserScore(user_score);

        TextView userTotalScoreTv = findViewById(R.id.totalScore_tv);
        userTotalScoreTv.setText(Integer.toString(handler.getUserScore()));

    }

    //O more questions verifica se o utilizador está na ultima pergunta ou não, se estiver volta ao menu principal, se n carrega a proxima pergunta
    public void nextQuestion(View v){
        Intent intent;
        if ( handler.moreQuestions() ) {
            intent = new Intent(this, Question_Activity.class);
        }
        else{
            intent = new Intent(this, MenuActivity.class);
        }
        startActivity(intent);
        finish();
    }





}
