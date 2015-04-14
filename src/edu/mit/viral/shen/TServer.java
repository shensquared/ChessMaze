package edu.mit.viral.shen;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import edu.mit.viral.shen.R;

import edu.mit.viral.shen.sockets.helper.Const;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class TServer extends Service {

	private SocketChannel client=null;
	private InetSocketAddress isa=null;
	private int NOTIFICATION = R.string.local_service_connected;

	//private String msg="";
    public void onCreate()
    {
    	super.onCreate();
    	connectToServer();
    	startServerListener();
    	System.out.println("---onCreate--- TServer");
    }

	public void onDestroy()
    {
    	super.onDestroy();
    	disConnectToServer();
    	System.out.println("---onDestory---");
    }
	public void onStart(Intent intent,int startId)
	{
		super.onStart(intent, startId);
		String msg=intent.getStringExtra("msg");
		if(msg.length()>0)
		{
			sendMessageToServerOld(msg);
		}
		System.out.println("message is comming:"+msg);
		System.out.println("---onStart---");

	}
	
	private void startServerListener() {
		// TODO Auto-generated method stub
		ServerListener a=new ServerListener();
		a.start();
		System.out.println("start listen");
	}
    //Á´½Ó·þÎñ¶Ë
	public void connectToServer() {



				new Thread(new Runnable() { 
					@Override
					public void run() {
try{
			
			client=SocketChannel.open();
			isa=new InetSocketAddress(Const.IP_ADD_LOCAL,8700);
			client.connect(isa);
			//client.configureBlocking(false);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
            }
        }).start();
		
    }
	//¶Ï¿ª·þÎñ¶Ë
	private void disConnectToServer() {




				new Thread(new Runnable() { 
					@Override
					public void run() {
try
		{
			client.close();
		}
		catch(IOException e){ e.printStackTrace();}
            }
        }).start();
		// TODO Auto-generated method stub
		
	}
	
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
        //String msg=intent.getStringExtra("msg");
		//System.out.println("°ó¶¨µÄÊý¾Ý"+msg);	
		return mBinder;
	}
	
	public class LocalBinder extends Binder
	{
		TServer getService()
		{
			return TServer.this;
		}
	}

	private final IBinder mBinder=new LocalBinder();

	private void sendMessageToServerOld(final String msg2){

					new Thread(new Runnable() { 
						@Override
						public void run() {
			try
		{
			ByteBuffer bytebuf=ByteBuffer.allocate(1024);
			bytebuf=ByteBuffer.wrap(msg2.getBytes("UTF-8"));
			client.write(bytebuf);
			bytebuf.flip();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	            
	        }).start();}




		// TODO Auto-generated method stub



	public void shownotification(String tab)
	{
		NotificationManager barmanager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		Notification msg2=new Notification(android.R.drawable.stat_notify_chat,"Teammate played Game 1",System.currentTimeMillis());
		PendingIntent contentIntent =PendingIntent.getActivity(this, 0,new Intent(this,Thumbnails.class),PendingIntent.FLAG_ONE_SHOT);
		msg2.setLatestEventInfo(this,"Viral Chess",tab, contentIntent);
		barmanager.notify(NOTIFICATION,msg2);
		//Toast.makeText(ReceiveMessage.this, tab,Toast.LENGTH_SHORT).show();
		//System.out.println(tab);
	}

	public class ServerListener extends Thread
	{
		public void run()
		{
				new Thread(new Runnable() { 
					@Override
					public void run() {


			try
			{
				while(true)
				{
					ByteBuffer buf=ByteBuffer.allocate(1024);
					client.read(buf);
					buf.flip();
					Charset charset=Charset.forName("UTF-8");
					CharsetDecoder decoder=charset.newDecoder();
					CharBuffer charbuffer;
					charbuffer=decoder.decode(buf);
					String result=charbuffer.toString();
					if(result.length()>0)
					{
						shownotification(result);
					}
				}
			}
			catch(CharacterCodingException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
						
            }
        }).start();
			




		}
	}

}
