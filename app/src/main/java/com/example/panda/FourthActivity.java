package com.example.panda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;


public class FourthActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean table_flg=false;
    Button enterExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        enterExitButton=(Button) findViewById(R.id.exit_button);
        enterExitButton.setOnClickListener(this);
    }

    public void collapseTable(View view){

        TableLayout table = findViewById(R.id.table);
        Button switchbutton = findViewById(R.id.switchbutton);

        table.setColumnCollapsed(1,table_flg );
        table.setColumnCollapsed(2,table_flg );

        if(table_flg)
        {
            table_flg = false;
            switchbutton.setText("Show Details");
        }
        else
        {
            table_flg = true;
            switchbutton.setText("Hide Details");
        }

    }


    @Override
    public void onClick(View v) {
        Intent exitIntent = new Intent(FourthActivity.this,ThirdActivity.class);
        startActivity( exitIntent);

    }
}