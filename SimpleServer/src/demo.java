import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class demo {
	public static void main(String[] args) {
		ServerThread severThread = new ServerThread();
		severThread.start();

	}

	static class ServerThread extends Thread {
		private static final int port = 20002;
		ServerSocket severSocket = null;

		public void run() {
			try {
				System.out.println("开始服务器");
				// 创建一个ServerSocket,用于监听客户端Socket的连接请求
				severSocket = new ServerSocket(port);
				// 采用循环不断接收来自客户端的请求
				while (true) {
					// 每当接收到客户端Socket的请求时，服务端也对应产生一个Socket
					Socket s = severSocket.accept();
					OutputStream os = s.getOutputStream();
					os.write("您好，您收到了服务器的offer！\n".getBytes("utf-8"));
					// 关闭输出流,关闭Socket
					os.close();
					s.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					severSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
