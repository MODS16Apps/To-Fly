package edu.fau.lasseter.tofly2016;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class IncorrectAnswer extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect_answer);

        View closeButton = findViewById(R.id.button2);
        closeButton.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.button2:
                finish();
                break;
        }

    }
}
