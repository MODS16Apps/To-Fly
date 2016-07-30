package edu.fau.lasseter.tofly2016;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.view.View.OnClickListener;


public class correctanswer extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correctanswer);

        View closeButton = findViewById(R.id.button);
        closeButton.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.button:
                finish();
                break;
        }
    }

}
