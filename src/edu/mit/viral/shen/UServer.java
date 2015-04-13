package edu.mit.viral.shen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class UServer extends Service {
	public static final String NOTIFICATION = "edu.mit.viral.shen";
	public class LocalBinder extends Binder
	{
		UServer getService()
		{
			return UServer.this;
		}
	}
	private final IBinder mBinder=new LocalBinder();	

	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	public void onListening(){
		new Thread(new Runnable() { 
		    @Override
		    public void run() {
		        Socket socket = null;
		        DataOutputStream dataOutputStream = null;
		        DataInputStream dataInputStream = null;
		        ServerSocket serverSocket = null;
		        try {
		            serverSocket = new ServerSocket(8889);
		            System.out.println("Listening :8889");
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        while(true){
		                try {
		                    socket = serverSocket.accept();
		                    dataInputStream = new DataInputStream(socket.getInputStream());
		                    String  recserv=dataInputStream.readUTF();
		                    System.out.println("received" + recserv);
		                    publishResults(recserv);
		                } catch (IOException e) {
		                    // TODO Auto-generated catch block
		                    e.printStackTrace();
		                }
		                finally{
		                    if( socket!= null){
		                        try {
		                            socket.close();
		                        } catch (IOException e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                    }
		                    
		                    if( dataInputStream!= null){
		                        try {
		                            dataInputStream.close();
		                        } catch (IOException e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                    }
		                    
		                    if( dataOutputStream!= null){
		                        try {
		                            dataOutputStream.close();
		                        } catch (IOException e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                    }
		                }
		            }
		}
		}).start();
	}

	    public void onCreate()
    {
    	super.onCreate();
    	onListening();
    	System.out.println("---onCreate---");
    }

    private void publishResults(String recserv) {
      Intent intent = new Intent(NOTIFICATION);
      intent.putExtra("receive", recserv);
      sendBroadcast(intent);
    }

}
