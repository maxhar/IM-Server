import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class main {
	static ServerSocket server;
	static Socket client;
	static BufferedReader br;
	static BufferedWriter bw;
	static int port;
	
	public static void init()
	{
		port = 44444;
		try {
			server = new ServerSocket(port);
			client = server.accept();
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			System.out.println("Server Started \n Listening at Port No # "+port);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception, Server could not be instantiated!");
		}
	}
	public static void main(String[]args)
	{ 	
		init();
		String str;
		while (true)
		{
			try {
				str = br.readLine();
				System.out.println("Client : "+str);
				if (str.equals("END"))
				{
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO Exception, 'br.readLine()' Failed!");
				break;
			}
		}
	}

}
