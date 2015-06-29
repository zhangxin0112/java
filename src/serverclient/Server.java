package serverclient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		int port = 8899;
		ServerSocket server = new ServerSocket(port);
		while(true){
			Socket socket = server.accept();
			Reader reader = new InputStreamReader(socket.getInputStream());
			StringBuilder strb = new StringBuilder();
			int len;
			char chars[] = new char[64];
			while((len=reader.read(chars))!=-1){
				strb.append(new String(chars,0,len));
			}
			System.out.println("from client's message:"+strb);
		}
	}
}
