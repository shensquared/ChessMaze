package edu.mit.viral.shen;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import edu.mit.viral.shen.sockets.helper.Const;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button1 = (Button)findViewById(R.id.MainButton1);
		//receive();
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), Thumbnails.class);
				startActivity(i);
				joinlist();
			}
		});

		
		Button button4 = (Button)findViewById(R.id.MainButton4);

		button4.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent i = new Intent(v.getContext(), Thumb4.class);
				
				startActivity(i);
			}
		});

}



private void joinlist() {
    new Thread(new Runnable() { 
        @Override
        public void run() {
            Socket socket = null;
            DataOutputStream dataOutputStream = null;
            DataInputStream dataInputStream = null;
            try {
            // String[] words = longfen.split(" ");
            // String fen=words[0];               
            socket = new Socket(Const.IP_ADD_LOCAL, 8890);
            dataOutputStream = new DataOutputStream(socket.getOutputStream()); 
            dataOutputStream.writeUTF("new_user"); 

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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
