package edu.mit.viral.shen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import edu.mit.viral.shen.R;

import edu.mit.viral.shen.sockets.helper.Const;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Thumb3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thumbnails);

		Button button1 = (Button) findViewById(R.id.ThumbnailButton1);
		Button button2 = (Button) findViewById(R.id.ThumbnailButton2);
		Button button3 = (Button) findViewById(R.id.ThumbnailButton3);
		Button button4 = (Button) findViewById(R.id.ThumbnailButton4);
		Button button5 = (Button) findViewById(R.id.ThumbnailButton5);
		Button button6 = (Button) findViewById(R.id.ThumbnailButton6);		
		Button button7 = (Button) findViewById(R.id.ThumbnailButton7);
		Button button8 = (Button) findViewById(R.id.ThumbnailButton8);
		Button button9 = (Button) findViewById(R.id.ThumbnailButton9);		
		Button button10 = (Button) findViewById(R.id.ThumbnailButton10);
		Button button11 = (Button) findViewById(R.id.ThumbnailButton11);
		Button button12 = (Button) findViewById(R.id.ThumbnailButton12);

		MainActivity.greenBackground(button1);
		MainActivity.greenBackground(button2);
		MainActivity.greenBackground(button3);
		MainActivity.greenBackground(button4);
		MainActivity.greenBackground(button5);
		MainActivity.greenBackground(button6);
		MainActivity.greenBackground(button7);
		MainActivity.greenBackground(button8);
		MainActivity.greenBackground(button9);
		MainActivity.greenBackground(button10);
		MainActivity.greenBackground(button11);
		MainActivity.greenBackground(button12);




		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Thumb3.this, DroidFish.class);
                i.putExtra("game_id", 1);                // Aug 13 
				startActivity(i);
				Button b=(Button) findViewById(R.id.ThumbnailButton1);
                b.setBackgroundColor(Color.RED);

				new Thread(new Runnable() { 
					@Override
					public void run() {
						Socket socket = null;
                DataOutputStream dataOutputStream = null;
                DataInputStream dataInputStream = null;
                try {               
                socket = new Socket(Const.IP_ADD, 8888);
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("button1"); 
              //  String  recserv=dataInputStream.readUTF();
               //System.out.println(recserv);

            }
            catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally{
            	if (socket != null){
            		try {
            			socket.close();
                        } 
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

			}
		});



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DroidFish.class);
                i.putExtra("game_id",2);                // Aug 13 
                startActivity(i);
                Button b=(Button) findViewById(R.id.ThumbnailButton2);
                b.setBackgroundColor(Color.RED);
            }
        }
        );

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DroidFish.class);
                i.putExtra("game_id",3);                // Aug 13 
                startActivity(i);
                Button b=(Button) findViewById(R.id.ThumbnailButton2);
                b.setBackgroundColor(Color.RED);
            }
        }
        );
    }

	private void receive(){
	new Thread(new Runnable() { 
            @Override
            public void run() {
            //	Looper.prepare();
              //  Looper.loop();     
                Socket socket = null;
                DataOutputStream dataOutputStream = null;
                DataInputStream dataInputStream = null;
                try {               
                socket = new Socket(Const.IP_ADD, 8888);
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("l0"); 
                String recserv = dataInputStream.readUTF();
                System.out.println(recserv);
                if(recserv.equals("hey1")){       
                	System.out.println(recserv);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Button b=(Button) findViewById(R.id.ThumbnailButton1);
                            b.setBackgroundColor(Color.RED);
}});



                }
                } 
          
                catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                }
                finally{
                    if (socket != null){
                        try {
                            socket.close();
                        } 
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
        }).start();
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
    


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thumbnails, menu);
		return true;
	}

}
