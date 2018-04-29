import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyServer {
	static int port = 40011;

	static ServerSocket serverSocket = null;

	// 定义保存所有Socket的ArrayList
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();

	public static void main(String[] args) throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("开启服务器...");
		while (true) {
			// 此行代码会阻塞，将一直等待别人的连接
			Socket s = serverSocket.accept();
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			System.out.println(sdf.format(new Date()) + "客户端" + s + "已经连接！");
			socketList.add(s);
			System.out.println(sdf.format(new Date()) + "当前在线客户端列表=" + socketList);
			// 每当客户端连接后启动一条ServerThread线程为该客户端服务
			ServerThread severThread = new ServerThread(s);
			new Thread(severThread).start();
		}
	}

}
