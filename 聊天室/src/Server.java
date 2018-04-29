import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.TextArea;
import javax.swing.SwingConstants;
import java.awt.Font;


public class Server {

	private JFrame frame;
	private JTextField textField;
	private JTextField port;
	@SuppressWarnings("rawtypes")
	private JList user_list;
	private TextArea content;
	private JTextArea msg;
	private boolean isStart=false;
	private ServerSocket  serverSocket;
	private ServerThread  serverThread;
	private ArrayList<ClientThread> clients;
	private JButton btn_send,btn_start,btn_stop;
	@SuppressWarnings("rawtypes")
	private DefaultListModel listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame("服务器");
		frame.setBounds(100, 100,600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new TitledBorder(null, "\u914D\u7F6E\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		northPanel.setToolTipText("");
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);
		//关闭窗口时事件  
        frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                if (isStart) {  
                    closeServer();// 关闭服务器  
                }  
                System.exit(0);// 退出程序  
            }  
        });  
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("端口号");
		textField.setEditable(false);
		northPanel.add(textField);
		textField.setColumns(6);
		
		port = new JTextField();
		northPanel.add(port);
		port.setColumns(10);
		
		btn_start = new JButton("启动");

		northPanel.add(btn_start);
		
		btn_stop = new JButton("停止");
		btn_stop.setEnabled(false);
		btn_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isStart==false){
					JOptionPane.showMessageDialog(frame, "服务器未启动,无需关闭",  "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				btn_start.setEnabled(true);    
                port.setEnabled(true);  
                btn_stop.setEnabled(false); 
				content.append("服务器成功停止\n");
			    closeServer();
			}
		});
		northPanel.add(btn_stop);
		
		JPanel southPanel = new JPanel();
		southPanel.setBorder(new TitledBorder(null, "\u53D1\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		msg = new JTextArea();
		msg.setRows(2);
		msg.setColumns(40);
		southPanel.add(msg);
		
		btn_send = new JButton("发送");
		btn_send.setFont(new Font("宋体", Font.PLAIN, 18));
	
		southPanel.add(btn_send);
		
		JScrollPane westPanel = new JScrollPane();
		westPanel.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5728\u7EBF\u5217\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(westPanel, BorderLayout.WEST);
		listModel = new DefaultListModel(); 
		user_list = new JList(listModel);
		westPanel.setViewportView(user_list);
		
		JScrollPane eastPanel = new JScrollPane();
		eastPanel.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6D88\u606F\u663E\u793A\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(eastPanel, BorderLayout.CENTER);
		
		content = new TextArea();
		eastPanel.setViewportView(content);
		
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//执行消息发送
				send();
			}

			
		});
		
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isStart==true){
					 JOptionPane.showMessageDialog(frame, "服务器已处于启动状态，不要重复启动！",  
	                            "错误", JOptionPane.ERROR_MESSAGE);
					 return ;
				}
				
				if(port.getText().toString().trim().length()==0){
					 JOptionPane.showMessageDialog(frame, "端口号为能为空",  
	                            "错误", JOptionPane.ERROR_MESSAGE);
					 return ;
				
				}
				
				try{
					 Integer.parseInt(port.getText().toString().trim());
				}catch(Exception e1){
					e1.printStackTrace();
					//如果发生错误直接返回
					 JOptionPane.showMessageDialog(frame, "端口号必须为正整数",  
	                            "错误", JOptionPane.ERROR_MESSAGE);
					return ;
					
				}
				 content.append("服务器已成功启动! 端口号:"+port.getText().toString());
				 content.append("\n");
				 btn_start.setEnabled(false);    
                 port.setEnabled(false);  
                 btn_stop.setEnabled(true); 
				 serverStart();
		
			}
		});
	}
	
	
	//启动服务器
	protected void serverStart() {
		// TODO Auto-generated method stub
		try{
			clients=new ArrayList<ClientThread>();
			serverSocket=new ServerSocket(Integer.parseInt(port.getText().toString()));
			serverThread=new ServerThread(serverSocket);
			serverThread.start();
			isStart=true;
		}catch(BindException e){
			e.printStackTrace();
			btn_start.setEnabled(true);
			port.setEnabled(true);
			btn_stop.setEnabled(false);
			isStart=false;
			content.setText("");
			content.append("端口号已被占用，请换一个！\n");
			System.out.println("端口号已被占用，请换一个！");
		}catch(Exception e){
			e.printStackTrace();
			btn_start.setEnabled(true);
			port.setEnabled(true);
			btn_stop.setEnabled(false);
			isStart=false;
			content.setText("");
			content.append("启动服务器异常！\n");
			System.out.println("启动服务器异常！");
		}
		
		
	}

	//发送消息
	private void send(){
		
		if(isStart==false){
			JOptionPane.showMessageDialog(frame,"服务器还未启动，不能发送消息","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(clients.size()==0){
			JOptionPane.showMessageDialog(frame,"没有用户在线","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(msg.getText().toString().trim().length()==0){
			JOptionPane.showMessageDialog(frame,"消息不能为空","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		content.append("服务器说:"+msg.getText().toString()+"\n");
		//发送服务器广播消息
		System.out.println("服务器要广播的消息="+msg.getText().toString().trim());
		sendServerMsg(msg.getText().toString().trim());
		msg.setText("");
		
	}
	
	//群发服务器的消息
	private void sendServerMsg(String message){
		for(int i=clients.size()-1;i>=0;i--){
			clients.get(i).getWriter().println("服务器说:"+message+"(多人发送)");
			clients.get(i).getWriter().flush();
		}
	}
	
	//关闭服务器
	@SuppressWarnings("deprecation") 
	private void closeServer(){
		if(serverThread!=null){
			serverThread.stop();//停止服务器进程
		}
		
		//给所有在线用户发送关闭指令
		for(int i=clients.size()-1;i>=0;i--){
			clients.get(i).getWriter().println("CLOSE");
			clients.get(i).getWriter().flush();
			//释放资源
				try {
					clients.get(i).bf.close();
					clients.get(i).writer.close();
					clients.get(i).socket.close();
					clients.remove(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		if(serverSocket!=null){
			try {
				serverSocket.close();
				//清空在线列表
				listModel.removeAllElements();
				isStart=false;
				content.append("服务器关闭成功!\n");
				JOptionPane.showMessageDialog(frame, "服务器关闭成功！");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isStart=true;
				content.append("服务器关闭失败!\n");
				JOptionPane.showMessageDialog(frame, "服务器关闭失败！",  
                        "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
	
	//开始线程等待客户端连接
	class ServerThread extends Thread{
		private ServerSocket serverSocket;
		public ServerThread(ServerSocket serverSocket){
			this.serverSocket=serverSocket;
			
		}
		 //死循环 一直等待客户端连接
		@SuppressWarnings("unchecked")
		public void run(){
			while(true){
				//客户端连接上来了 
				try {
					Socket socket=serverSocket.accept();
					System.out.println("连接上来的客户端"+socket);
					ClientThread client=new ClientThread(socket);
					client.start();
					//注意我是先开启服务客户端线程的，再把当前服务该用户的线程加入到服务客户线程集合中
					clients.add(client);
					System.out.println("2.clients.size="+clients.size());
					listModel.addElement(client.getUser().getName()+client.getUser().getIp());
					content.append(client.getUser().getName()+client.getUser().getIp()+"已经上线!\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//开始服务线程，给客户端进行服务
			}
		}
	}
	
	class ClientThread extends Thread{
		//连接上来的客户端socket
		private Socket socket;
		//缓冲输入流
		private BufferedReader bf;
		private PrintWriter  writer;
		private User user;
		
		public BufferedReader getReader() {  
            return bf;  
        }  
  
        public PrintWriter getWriter() {  
            return writer;  
        }  
  
        public User getUser() {  
            return user;  
        } 
		
		//收到客户端的ip 是有/的 比如:/100.64.105.108
		public ClientThread(Socket socket){
			this.socket=socket;
			try {
				System.out.println("1.clients.size="+clients.size());
				bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer=new PrintWriter(socket.getOutputStream());
				//接收客户端基本信息
				String data=bf.readLine();
				System.out.println("服务器接收到客户端的data="+data);
				//分析一个字符串并且将字符串分解成可被单独使用的单词
				StringTokenizer fenxi=new StringTokenizer(data,"@");
				user=new User(fenxi.nextToken(),fenxi.nextToken());
				System.out.println("服务器分隔客户端传来的基础信息,分隔结果 "+"name="+user.getName()+" ip="+user.getIp());
				//反馈连接成功信息 给客户端
				writer.println(user.getName()+user.getIp()+"与服务器连接成功！");
				//flush输出流的缓冲
				writer.flush();
				//反馈当前在线用户信息
				if(clients.size()>0){
					System.out.println("在线的用户有="+String.valueOf(clients.size()-1));
					String temp="";
					for(int i=clients.size()-1;i>=0;i--){
						temp+=(clients.get(i).getUser().getName()+clients.get(i).getUser().getIp()+"@");
					}
					
					writer.println("USERLIST@"+clients.size()+"@"+temp);
					writer.flush();
				}
				
				//给所有在线用户发送该用户上线消息
				for(int i=clients.size()-1;i>=0;i--){
					clients.get(i).getWriter().println("ADD@"+user.getName()+user.getIp());
					clients.get(i).getWriter().flush();
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//接收客户端的消息
		@SuppressWarnings("deprecation") 
		public void run(){
			String message=null;
			
			while(true){
				try {
					System.out.println("3.clients.size="+clients.size());
					message=bf.readLine();
					StringTokenizer fenxi=new StringTokenizer(message,"@");
					String command=fenxi.nextToken();
					//如果收到客户端下线命令
					if(message.equals("CLOSE")){
						content.append(this.user.getName()+this.user.getIp()+"已经下线\n");
						//断开连接 释放资源
						bf.close();
						writer.close();
						socket.close();
						//在线列表更新， 移除断开连接的的客户信息
						listModel.removeElement(this.user.getName()+this.user.getIp());
						//向所有在线的用户发送该用户下线的命令
						for(int i=clients.size()-1;i>=0;i--){
							clients.get(i).getWriter().println("DELETE@"+user.getName()+user.getIp());
							clients.get(i).getWriter().flush();
						}
						//删除此客户端服务器进程
						for(int i=clients.size()-1;i>=0;i--){
							if(clients.get(i).getUser().equals(this.user)){
								clients.remove(i);
								 this.stop();
								 //停止这一条服务进程
								 //clients.get(i).stop(); 
								//删除此用户的服务进程
								return ;
							}
						}
					}else if(command.equals("PRIVATE")){
						String from=fenxi.nextToken();
						String to=fenxi.nextToken();
						String msg=fenxi.nextToken();
						for(int i=clients.size()-1;i>=0;i--){
							if(clients.get(i).getUser().getName().equals(to)){
								clients.get(i).getWriter().println("PRIVATE@"+from+"@"+msg);
								clients.get(i).getWriter().flush();
							}
						}
					}else{
						//群聊转发信息
						dispatchMessage(message);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//转发消息
		public void dispatchMessage(String message){
			System.out.println("要转发给每个客户端的消息="+message);
			StringTokenizer fenxi=new StringTokenizer(message,"@");
			String source=fenxi.nextToken();  //对应着客户端的name
			String owner=fenxi.nextToken();   //对应着 ALL  群聊的标志
			String msg=fenxi.nextToken();     //对应着消息内容
			message=source+"说:"+msg;
			//消息显示区
			content.append(message+"\n");
			//群发
			if(owner.equals("ALL")){
				for(int i=clients.size()-1;i>=0;i--){
					clients.get(i).getWriter().println(message+"(多人发送)");
					//不要掉了这一句话，否则客户端和客户端之间收不到彼此消息
					clients.get(i).getWriter().flush();//缓冲输出流
				}
			}
			
		}
			
	}
}
