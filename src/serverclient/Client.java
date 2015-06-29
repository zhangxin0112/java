package serverclient;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String ip = "127.0.0.1";
		int port = 8899;
		Socket client = new Socket(ip,port);
		Writer writer = new OutputStreamWriter(client.getOutputStream());
//		writer.write("hello server!");
		writer.write("hello server!i am the client ,the new line.");
		writer.flush();
		writer.close();
		client.close();
	}
}
