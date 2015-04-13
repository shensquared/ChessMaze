package edu.mit.viral.shen.sockets.helper;
import java.util.Random;

public class Const {

	public static final String IP_ADD = "18.111.79.41"; 
	public static final String URL_WEBSOCKET = "ws://192.168.0.102:8080/WebMobileGroupChatServer/chat?name=";


	
	 public static final String IP_ADD_LOCAL = "192.168.0.102";

	static final Random r = new Random();
	public static final int sessionID=r.nextInt(1000) + 1;
}

