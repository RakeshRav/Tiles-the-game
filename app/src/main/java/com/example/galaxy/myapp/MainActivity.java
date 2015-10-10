package com.example.galaxy.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    Button start;


    TextView red, yellow, green, blue;
    TextView score,gameScore;
    LinearLayout game;
    int current =0;
    int count = 0;
    Random r;

    int check = -1;

    FrameLayout msgbox;
    TimerTask task;



    Timer t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        red = (TextView) findViewById(R.id.red);
        yellow = (TextView) findViewById(R.id.yellow);
        green = (TextView) findViewById(R.id.green);
        blue = (TextView) findViewById(R.id.blue);

        msgbox = (FrameLayout) findViewById(R.id.msgBox);
        gameScore = (TextView) findViewById(R.id.gamescore);

        game = (LinearLayout) findViewById(R.id.game);
        score = (TextView) findViewById(R.id.score);

        start = (Button) findViewById(R.id.restart);
        r = new Random();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start.getText().toString().equals("Start")) {
//                    Toast.makeText(MainActivity.this, "hai bhai", Toast.LENGTH_SHORT).show();
                    start.setText("Restart");
                    game.setVisibility(View.VISIBLE);
                    msgbox.setVisibility(View.GONE);
                    count = 0;
                    check = -1;

                } else {
//                    Toast.makeText(MainActivity.this, "hai to sari", Toast.LENGTH_SHORT).show();
                    start.setText("Start");
                    game.setVisibility(View.VISIBLE);
                    msgbox.setVisibility(View.GONE);
                    count = 0;
                    check = -1;
                }

                t = new Timer();

                task = new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (check == count) {
                                    t.cancel();
                                    t.purge();
                                    setColor();
                                    score.setText("Game Over");
                                    gameScore.setText("Game Over Your Score : " + count);
                                    msgbox.setVisibility(View.VISIBLE);

                                } else {

                                    int position = changeColor();
                                    check++;
                                    Log.i("check", "" + check);
                                    if (position == 0) {
                                        red.setBackgroundColor(getResources().getColor(R.color.grey));
                                        yellow.setBackgroundColor(getResources().getColor(R.color.yellow));
                                        green.setBackgroundColor(getResources().getColor(R.color.green));
                                        blue.setBackgroundColor(getResources().getColor(R.color.blue));

                                        red.setText("grey");
                                        yellow.setText("yellow");
                                        green.setText("green");
                                        blue.setText("blue");

                                    } else if (position == 1) {
                                        yellow.setBackgroundColor(getResources().getColor(R.color.grey));

                                        red.setBackgroundColor(getResources().getColor(R.color.red));
                                        green.setBackgroundColor(getResources().getColor(R.color.green));
                                        blue.setBackgroundColor(getResources().getColor(R.color.blue));

                                        red.setText("red");
                                        yellow.setText("grey");
                                        green.setText("green");
                                        blue.setText("blue");

                                    } else if (position == 2) {
                                        green.setBackgroundColor(getResources().getColor(R.color.grey));

                                        yellow.setBackgroundColor(getResources().getColor(R.color.yellow));
                                        red.setBackgroundColor(getResources().getColor(R.color.red));
                                        blue.setBackgroundColor(getResources().getColor(R.color.blue));

                                        red.setText("red");
                                        yellow.setText("yellow");
                                        green.setText("grey");
                                        blue.setText("blue");

                                    } else if (position == 3) {
                                        blue.setBackgroundColor(getResources().getColor(R.color.grey));

                                        yellow.setBackgroundColor(getResources().getColor(R.color.yellow));
                                        green.setBackgroundColor(getResources().getColor(R.color.green));
                                        red.setBackgroundColor(getResources().getColor(R.color.red));

                                        red.setText("red");
                                        yellow.setText("yellow");
                                        green.setText("green");
                                        blue.setText("grey");

                                    }
                                }

                            }
                        });
                    }
                };

                t.scheduleAtFixedRate(task, 1000, 1000);

                red.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (red.getText().toString().equals("grey")) {
                            count++;
//                   check++;

                            score.setText("Score : " + count);
                        } else {

                            setColor();
                            t.cancel();
                            score.setText("Game Over");
                            gameScore.setText("Game Over Your Score : " + count);
                            msgbox.setVisibility(View.VISIBLE);

                        }

                        return false;
                    }
                });

                yellow.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (yellow.getText().toString().equals("grey")) {
                            count++;
//                    check++;

                            score.setText("Score : " + count);
                        } else {
                            t.cancel();

                            setColor();
                            score.setText("Game Over");
                            gameScore.setText("Game Over Your Score : " + count);
                            msgbox.setVisibility(View.VISIBLE);

                        }

                        return false;
                    }
                });

                green.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (green.getText().toString().equals("grey")) {
                            count++;
//                    check++;

                            score.setText("Score : " + count);
                        } else {
                            t.cancel();

                            setColor();
                            score.setText("Game Over");
                            gameScore.setText("Game Over Your Score : " + count);
                            msgbox.setVisibility(View.VISIBLE);

                        }

                        return false;
                    }
                });

                blue.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (blue.getText().toString().equals("grey")) {
                            count++;
//                    check++;

                            score.setText("Score : " + count);
                        } else {
                            t.cancel();
                            t.purge();
                            setColor();
                            score.setText("Game Over");
                            gameScore.setText("Game Over Your Score : " + count);
                            msgbox.setVisibility(View.VISIBLE);


                        }

                        return false;
                    }
                });


            }
        });

    }

    public void setColor()
    {

        red.setBackgroundColor(getResources().getColor(R.color.red));
        yellow.setBackgroundColor(getResources().getColor(R.color.yellow));
        green.setBackgroundColor(getResources().getColor(R.color.green));
        blue.setBackgroundColor(getResources().getColor(R.color.blue));

        red.setText("red");
        yellow.setText("yellow");
        green.setText("green");
        blue.setText("blue");
    }

    public int changeColor()
    {

        int i = 0;

        i = r.nextInt(4);

//        Log.i("i123","current "+current);
//        Log.i("i123",""+i);

        while (i < 0 || i == current)
        {
            i = r.nextInt(4);
        }

        current = i;

//        Toast.makeText(getApplicationContext(),""+i,Toast.LENGTH_LONG).show();
        return i;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
