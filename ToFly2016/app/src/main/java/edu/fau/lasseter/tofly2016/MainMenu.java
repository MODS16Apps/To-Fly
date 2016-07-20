package edu.fau.lasseter.tofly2016;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;


public class MainMenu extends Activity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Sets view of activity_main_menu.xml
        setContentView(R.layout.activity_main_menu);
    }

    public void onClick(View v){}

    //Create menu for credits
    public void credits(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.inflate(R.menu.credits);
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.creditsSelect:
                Menu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void Menu() {
        //Start Credits activity
        Intent intent = new Intent(this, credits.class);
        startActivity(intent);
    }

    //Create buttons for the different activities
    public void chrono(View v){
        Toast.makeText(this,"This button will open the Timeline",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,chronology.class);
        startActivity(intent);
    }
    public void map(View v){
        Toast.makeText(this,"This button will open the Map",Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this, map.class);
        //startActivity(intent);
    }
    public void games(View v){
        CharSequence colors[] = new CharSequence[] {"Trivia", "Soarin' Planes"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
        builder.setTitle("Pick a Game");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    Toast.makeText(getBaseContext(),"This button will open Trivia",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(),"This button will open Soarin' Planes",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.show();
    }
    public void plane(View v){
        Toast.makeText(this,"This button will open the plane diagram", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this, plane.class);
        //startActivity(intent);
    }
    public void space(View v){
        Toast.makeText(this,"This button will open the Space info", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this, space.class);
        //startActivity(intent);
    }

}
