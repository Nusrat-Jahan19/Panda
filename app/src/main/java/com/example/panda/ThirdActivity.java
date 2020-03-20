package com.example.panda;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Button[][] buttons=new Button[3][3];
    boolean player1Turn=true;
    int roundCounts=0;
    int player1Points=0;
    int player2Points=0;
    TextView textViewPlayer1;
    TextView textViewPlayer2;
    Button reset_button;
    Button gotoinviteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toast.makeText(ThirdActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        textViewPlayer1=(TextView) findViewById(R.id.text_view_player1);
        textViewPlayer2=(TextView) findViewById(R.id.text_view_player2);
        gotoinviteButton=(Button) findViewById(R.id.invite_button);
        gotoinviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inviteIntent = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(inviteIntent);

            }
        });
        reset_button=(Button) findViewById(R.id.button_reset);
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        buttons[0][0]=(Button) findViewById(R.id.button_00);
        buttons[0][1]=(Button) findViewById(R.id.button_01);
        buttons[0][2]=(Button) findViewById(R.id.button_02);
        buttons[1][0]=(Button) findViewById(R.id.button_10);
        buttons[1][1]=(Button) findViewById(R.id.button_11);
        buttons[1][2]=(Button) findViewById(R.id.button_12);
        buttons[2][0]=(Button) findViewById(R.id.button_20);
        buttons[2][1]=(Button) findViewById(R.id.button_21);
        buttons[2][2]=(Button) findViewById(R.id.button_22);

        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                buttons [i][j].setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Button b=(Button)v;
        if(!b.getText().toString().equals(""))
        {
            return;
        }
        if(player1Turn)
        {
            b.setText("X");
        }
        else
        {
            b.setText("O");
        }
        roundCounts++;

        if(checkForWin())
        {
            if(player1Turn)
            {
                player1Wins();
            }
            else
            {
                player2Wins();
            }
        }
        else
        if(roundCounts==9)
        {
            draw();
        }
        else
        {
            player1Turn=!player1Turn;
        }
    }

    public void draw() {
        Toast.makeText(this,"Draw!",Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    public void player1Wins() {
        player1Points++;
        Toast.makeText(this,"Player 1 Wins",Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }
    public void player2Wins() {
        player2Points++;
        Toast.makeText(this,"Player 2 Wins",Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }

    public  void  updatePointText()
    {
        textViewPlayer1.setText("Player 1 :"+player1Points);
        textViewPlayer2.setText("Player 2 :"+player2Points);
    }

    public  void resetBoard()
    {

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                buttons[i][j].setText("");

        roundCounts=0;
        player1Turn=true;
    }
    public void resetGame()
    {
        player1Points=0;
        player2Points=0;
        updatePointText();
        resetBoard();
    }

    public boolean checkForWin()
    {
        String[][] field=new String[3][3];

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                field[i][j]=buttons[i][j].getText().toString();

        for(int i=0;i<3;i++)
        {
            if(field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("") )
            {
                return true;
            }

        }
        for(int i=0;i<3;i++)
        {
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals(""))
            {
                return true;
            }
        }
        if(field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) &&  !field[0][0].equals("") )
        {
            return true;
        }
        if(field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) &&  !field[0][2].equals("") )
        {
            return true;
        }

        return false;

    }
}
