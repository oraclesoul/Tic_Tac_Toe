package com.oraclesoul.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[][] win_pos = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};

    int turn = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int sId = this.getResources().getIdentifier("status","id",this.getPackageName());
        TextView sTv = (TextView)findViewById(sId);
        sTv.setText("Player O turn "  );
    }



    void gameEnd(int turn)
    {
         AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
         if(turn==-1)
         {
             alertDialog.setMessage("Game Draw");
         }else
         {
             alertDialog.setMessage("Player " + (turn==0?"O":"X") + " Won");
         }
         alertDialog.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 finish();
                 startActivity(getIntent());
             }
         });
         alertDialog.setCancelable(false);
         alertDialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 finish();
             }
         });
         alertDialog.show();
    }





    public void cellTapped(View view)
    {
        int sId = this.getResources().getIdentifier("status","id",this.getPackageName());
        TextView sTv = (TextView)findViewById(sId);

        TextView tvClicked = (TextView) findViewById(view.getId());

        String val = tvClicked.getText().toString();
        if(!val.equals(""))
        {
//            Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
            sTv.setText("Invalid Move");
        }
        else
        {   count++;
            if(turn==0)
            {
                tvClicked.setText(R.string.turn0);
            }else
            {
                tvClicked.setText(R.string.turn1);
            }



            for(int i=0;i<win_pos.length;i++)
            {
                    String res1 = 'c' + Integer.toString(win_pos[i][0]);
                    String res2 = 'c' + Integer.toString(win_pos[i][1]);
                    String res3 = 'c' + Integer.toString(win_pos[i][2]);


                    int ri1 = this.getResources().getIdentifier(res1,"id",this.getPackageName());
                    int ri2  = this.getResources().getIdentifier(res2,"id",this.getPackageName());
                    int ri3 = this.getResources().getIdentifier(res3,"id",this.getPackageName());
                    String s1 = ((TextView)findViewById(ri1)).getText().toString();
                    String s2 = ((TextView)findViewById(ri2)).getText().toString();
                    String s3 = ((TextView)findViewById(ri3)).getText().toString();
                    if(!s1.equals("") && s1.equals(s2) && s2.equals(s3))
                    {
//                        Toast.makeText(this, "Player "+ turn +" won", Toast.LENGTH_SHORT).show();
                        sTv.setText("Player " + turn + " Won");
                        gameEnd(turn);
                    }
            }
            if(count==9)
            {
                sTv.setText("Game Draw");
                gameEnd(-1);
            }

            turn = 1-turn;
            if(turn==0)
            {
                sTv.setText("Player O turn" );
            }else
            {
                sTv.setText("Player X turn");
            }
        }


        
    }



}