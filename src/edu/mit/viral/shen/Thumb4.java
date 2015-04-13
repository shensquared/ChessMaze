package edu.mit.viral.shen;

import edu.mit.viral.shen.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Thumb4 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thumb4);

		Button button37 = (Button) findViewById(R.id.ThumbnailButton37);
		Button button38 = (Button) findViewById(R.id.ThumbnailButton38);
		Button button39 = (Button) findViewById(R.id.ThumbnailButton39);
		Button button40 = (Button) findViewById(R.id.ThumbnailButton40);
		Button button41 = (Button) findViewById(R.id.ThumbnailButton41);
		Button button42 = (Button) findViewById(R.id.ThumbnailButton42);		
		Button button43 = (Button) findViewById(R.id.ThumbnailButton43);
		Button button44 = (Button) findViewById(R.id.ThumbnailButton44);
		Button button45 = (Button) findViewById(R.id.ThumbnailButton45);		
		Button button46 = (Button) findViewById(R.id.ThumbnailButton46);
		Button button47 = (Button) findViewById(R.id.ThumbnailButton47);
		Button button48 = (Button) findViewById(R.id.ThumbnailButton48);
/*
		MainActivity.greenBackground(button37);
		MainActivity.greenBackground(button38);
		MainActivity.greenBackground(button39);
		MainActivity.greenBackground(button40);
		MainActivity.greenBackground(button41);
		MainActivity.greenBackground(button42);
		MainActivity.greenBackground(button43);
		MainActivity.greenBackground(button44);
		MainActivity.greenBackground(button45);
		MainActivity.greenBackground(button46);
		MainActivity.greenBackground(button47);
		MainActivity.greenBackground(button48);

*/

        button37.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {				
            	Intent i = new Intent(Thumb4.this, DroidFish.class);
                i.putExtra("game_id", 37);                // Aug 13 
				startActivity(i);

            }
        });
       


        button38.setOnClickListener(new OnClickListener(){
                    @Override
                    public void onClick(View v) {				
                    	Intent i = new Intent(Thumb4.this, DroidFish.class);
                        i.putExtra("game_id", 38);                // Aug 13 
        				startActivity(i);

                    }
        });


	}



    public static void changeColor(int r, int g, int b, Button button){
        int color = Color.argb(225, r, g, b);
        button.setBackgroundColor(color);
    }
    public static void greenBackground(Button b){
        changeColor(0,0,225, b);
    }
    
    public static void redBackground(Button b){
        changeColor(225,0,0, b);
    }
    


}
