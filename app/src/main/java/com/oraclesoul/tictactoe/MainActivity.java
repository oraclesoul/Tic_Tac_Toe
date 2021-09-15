package com.oraclesoul.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int[][] win_pos = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};

    int[][] old_values = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
//    boolean game_active = true;
    int turn = 0;

    public void cellTapped(View view)
    {
        TextView tvClicked = (TextView) findViewById(view.getId());

        String val = tvClicked.getText().toString();
        if(!val.equals(""))
        {
            Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(turn==0)
            {
                tvClicked.setText(R.string.turn0);
            }else
            {
                tvClicked.setText(R.string.turn1);
            }
            turn = 1-turn;

            boolean isWon = false;
            for(int i=0;i<win_pos.length;i++)
            {
                    String res1 = 'c' + Integer.toString(win_pos[i][0]);
                    String res2 = 'c' + Integer.toString(win_pos[i][1]);
                    String res3 = 'c' + Integer.toString(win_pos[i][2]);


                    int ri1 = this.getResources().getIdentifier("tv1",res1,this.getPackageName());
                    int ri2  = this.getResources().getIdentifier("tv2",res2,this.getPackageName());
                    int ri3 = this.getResources().getIdentifier("tv3",res3,this.getPackageName());
                    if(((TextView)findViewById(ri1)).getText()==((TextView) findViewById(ri2)).getText() && ((TextView)findViewById(ri1)).getText() == ((TextView)findViewById(ri3)).getText() )
                    {
                        Toast.makeText(this, "Player "+(1-turn)+" won", Toast.LENGTH_SHORT).show();
                    }
            }
        }


        
    }



}