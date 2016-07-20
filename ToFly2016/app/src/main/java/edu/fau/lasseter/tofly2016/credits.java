package edu.fau.lasseter.tofly2016;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

/**
 * Created by Kenny Lasseter on 7/19/2016.
 */
public class credits extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        RelativeLayout rlay = (RelativeLayout)findViewById(R.id.rlay);
        Animation translate= AnimationUtils.loadAnimation(this, R.anim.animationfile);
        rlay.startAnimation(translate);
    }

}
