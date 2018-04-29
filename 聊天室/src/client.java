import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.TextField;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JList;
import java.awt.List;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.awt.TextArea;
import javax.swing.JCheckBox;


public class client {

	private JFrame frame;
	private JTextField textField;
	private JTextField port;
	private JTextField txtip;
	private JTextField host;
	private JTextField textField_2;
	private JTextField name;
	private JButton btn_connect;
	private JButton btn_disconnect;
	private JButton btn_send;
	private JTextArea msg;
	private JScrollPane westPanel;
	@SuppressWarnings("rawtypes")
	private JList user_list;
	@SuppressWarnings("rawtypes")
	private DefaultListModel listModel;
	private JScrollPane centerPanel;
	private boolean isConnect=false;
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader bf;
	//负责接收消息的线程
	private MessageThread messageThread;
	//所有在线用户
	private Map<String,User> onLineUser=new HashMap<String,User>();
	private TextArea content;
	private JCheckBox isSingle;
	private JTextField textField_1;
	private JTextField privateChat;
	//用于记录复选框的选中
	private boolean flag=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client window = new client();
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
	public client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame("客户端");
		frame.setBounds(100, 100,750,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(204, 255, 255));
		northPanel.setBorder(new TitledBorder(null, "\u8FDE\u63A5\u914D\u7F6E", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 255, 255));
		textField.setText("端口");
		textField.setEditable(false);
		northPanel.add(textField);
		textField.setColumns(5);
		
		port = new JTextField();
		northPanel.add(port);
		port.setColumns(10);
		
		txtip = new JTextField();
		txtip.setBackground(new Color(204, 255, 255));
		txtip.setHorizontalAlignment(SwingConstants.CENTER);
		txtip.setText("服务器IP");
		txtip.setEditable(false);
		northPanel.add(txtip);
		txtip.setColumns(9);
		
		host = new JTextField();
		northPanel.add(host);
		host.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(204, 255, 255));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("姓名");
		textField_2.setEditable(false);
		northPanel.add(textField_2);
		textField_2.setColumns(4);
		
		name = new JTextField();
		northPanel.add(name);
		name.setColumns(10);
		
		btn_connect = new JButton("连接");
		btn_connect.setBackground(new Color(204, 255, 255));
		northPanel.add(btn_connect);
		
		btn_disconnect = new JButton("断开");
		btn_disconnect.setEnabled(false);
		btn_disconnect.setBackground(new Color(204, 255, 255));
		northPanel.add(btn_disconnect);
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(204, 255, 255));
		southPanel.setBorder(new TitledBorder(null, "\u53D1\u6D88\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		isSingle = new JCheckBox("是否私聊");
		isSingle.setSelected(true);
		southPanel.add(isSingle);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("私聊对象");
		southPanel.add(textField_1);
		textField_1.setColumns(8);
		
		privateChat = new JTextField();
		privateChat.setFont(new Font("宋体", Font.PLAIN, 14));
		southPanel.add(privateChat);
		privateChat.setColumns(10);
		
		msg = new JTextArea();
		msg.setColumns(20);
		msg.setTabSize(12);
		msg.setRows(2);
		southPanel.add(msg);
		
		btn_send = new JButton("发送");
		btn_send.setFont(new Font("宋体", Font.PLAIN, 18));
		southPanel.add(btn_send);
		
		westPanel = new JScrollPane();
		westPanel.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5728\u7EBF\u7528\u6237", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(westPanel, BorderLayout.WEST);
		listModel=new DefaultListModel();
		user_list = new JList(listModel);
		westPanel.setViewportView(user_list);
		
		centerPanel = new JScrollPane();
		centerPanel.setViewportBorder(new TitledBorder(null, "\u6D88\u606F\u663E\u793A\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		content = new TextArea();
		centerPanel.setViewportView(content);
		
		//点窗口 X的按钮
		// 关闭窗口时事件  
        frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                if (isConnect) {  
                    closeConnection();// 关闭连接  
                }  
                System.exit(0);// 退出程序  
            }  
        });  
		
		//单击连接按钮
		btn_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isConnect==true){
					JOptionPane.showMessageDialog(frame, "已处于连接上状态，不要重复连接!",  
                            "错误", JOptionPane.ERROR_MESSAGE);  
                    return;
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
				
				
				if(host.getText().toString().trim().equals("")&&host.getText().toString().trim().length()==0){
					JOptionPane.showMessageDialog(frame, "服务器地址不能为空",  
                            "错误", JOptionPane.ERROR_MESSAGE);  
                    return;
				}
				
				if(name.getText().toString().trim().equals("")&&name.getText().toString().trim().length()==0){
					JOptionPane.showMessageDialog(frame, "姓名不能为空",  
                            "错误", JOptionPane.ERROR_MESSAGE);  
                    return;
				}
				
				boolean flag=connectServer(Integer.parseInt(port.getText().toString().trim()),host.getText().toString().trim(),name.getText().toString().trim());
				if(flag){
					frame.setTitle(name.getText().toString().trim()+"已经连接服务器");
					connect_success_UI_state();
					content.append("客户端已经成功连接服务器!\n");
				}else{
					connect_fail_UI_state();
					JOptionPane.showMessageDialog(frame, "服务器连接失败",  
                            "错误", JOptionPane.ERROR_MESSAGE);
					content.append("服务器连接失败!\n");
				}
				
				
			}
		});
		
		//点击断开连接按钮
		btn_disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isConnect==false){
					JOptionPane.showMessageDialog(frame, "已经处于断开连接，请勿重复操作",  
                            "错误", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				
				try{
					
					boolean flag=closeConnection();
					if(flag){
						connect_fail_UI_state();
						content.append("客户端断开连接成功！\n");
						JOptionPane.showMessageDialog(frame, "客户端断开连接成功！");
						frame.setTitle(name.getText().toString().trim()+"已经与服务器断开");
					}else{
						connect_success_UI_state();
						content.append("客户端断开连接失败！\n");
						JOptionPane.showMessageDialog(frame, "客户端断开连接失败！",  
		                        "错误", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		
		
		//发送消息
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		
		//复选框点击事件
		isSingle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				flag=!flag;
				isSingle.setSelected(flag);
				System.out.println("复选框的选中状态="+isSingle.isSelected());
			}
		});
	}
	

	private void send(){
		if(isConnect==false){
			JOptionPane.showMessageDialog(frame, "还没有连接服务器不能发送消息",  
                    "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(msg.getText().toString().trim().length()==0){
			JOptionPane.showMessageDialog(frame, "发送消息不能为空",  
                    "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		//如果选中 那么就是私聊
		if(isSingle.isSelected()==true){
			if(privateChat.getText().toString().trim().length()==0){
				JOptionPane.showMessageDialog(frame, "私聊对象不能为空!",  
	                    "错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			content.append("我说:"+msg.getText().toString().trim()+"\n");
			sendMessage("PRIVATE"+"@"+name.getText().toString().trim()+"@"+privateChat.getText().toString().trim()+"@"+msg.getText().toString().trim());
			
		}else{
			//是群聊
			content.append("我说:"+msg.getText().toString().trim()+"\n");
			//向客户端发送消息 这是群聊
			sendMessage(name.getText().toString().trim()+"@"+"ALL"+"@"+msg.getText().toString().trim());
			msg.setText("");
		}
	}
	
	
	//客户端主动关闭连接  这里一个线程只能来一个 慢慢排序
	@SuppressWarnings("deprecation")
	private synchronized boolean closeConnection(){
		//客户端主动发送断开请求，向服务器发送
		sendMessage("CLOSE");
		//停止接收信息线程
		messageThread.stop();
		try{
			//清空用户在线列表
			if(bf!=null){
				bf.close();
			}
			
			if(writer!=null){
				writer.close();
			}
			
			if(socket!=null){
			
				socket.close();
				
			}
			//修改状态
			isConnect=false;
			//清空自己的在线列表
			listModel.removeAllElements();
			return true;
			}catch(Exception e){
				e.printStackTrace();
				isConnect=true;
				return false;
				
			}
		
		
		
	}
	
//连接后组件的状态
	private void connect_success_UI_state(){
		btn_connect.setEnabled(false);
		btn_disconnect.setEnabled(true);
		host.setEnabled(false);
		name.setEnabled(false);
		port.setEnabled(false);
		
	}

	//连接之前组件的状态
	private void connect_fail_UI_state(){
		btn_connect.setEnabled(true);
		btn_disconnect.setEnabled(false);
		host.setEnabled(true);
		name.setEnabled(true);
		port.setEnabled(true);
		
	}
	public  boolean connectServer(int  port,String host,String name){
		try{
		//与服务器建立连接
		socket=new Socket(host,port);
		writer=new PrintWriter(socket.getOutputStream());
		bf=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
		//发送客户端用户基本信息 name+ip
		sendMessage(name+"@"+socket.getLocalAddress().toString());
		//开启接收消息的线程
		messageThread=new MessageThread(bf);
		messageThread.start();
		isConnect=true;
		return true;
		}catch(Exception e){
			e.printStackTrace();
			content.append(" IP地址为："+host+ "与端口号为：" + port+"的服务器连接失败!\n");
			isConnect=false;
			return false;
		}
	}
	class MessageThread extends Thread{
		private BufferedReader bf=null;
		public MessageThread(BufferedReader bf){
			this.bf=bf;
		}
		//被动关闭  //线程只能一个一个的来
		public synchronized void closeCon(){
			try{
			//清空用户在线列表
			if(bf!=null){
				bf.close();
			}
			if(writer!=null){
				writer.close();
			}
			if(socket!=null){
				socket.close();
			}
			//修改状态
			isConnect=false;
			connect_fail_UI_state();
			content.append("客户端断开连接成功！\n");
			JOptionPane.showMessageDialog(frame, "客户端断开连接成功！");
			//清空自己的列表
			listModel.removeAllElements();
			}catch(Exception e){
				e.printStackTrace();
				isConnect=true;
				connect_success_UI_state();
				content.append("客户端断开连接失败！\n");
				JOptionPane.showMessageDialog(frame, "客户端断开连接失败！",  
                        "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
		@SuppressWarnings("unchecked")
		public void run(){
			String message;
			while(true){
				try {
					message=bf.readLine();
					System.out.println("客户端接收到服务器的消息="+message);
					StringTokenizer fenxi=new StringTokenizer(message,"@/");
					//获得服务器发给客户端的关闭命令
					String command=fenxi.nextToken();
					System.out.println("nextToken后的信息="+command);
					if(command.equals("CLOSE")){
							content.append("服务器已经关闭了!\n");
							//被动关闭客户端
							closeCon();
							//结束线程
							return ;
					//有用户上线，更新列表
					}else if(command.equals("ADD")){
						String user_name=null;
						String user_ip=null;
						if((user_name=fenxi.nextToken())!=null&&(user_ip=fenxi.nextToken())!=null){
							User user=new User(user_name,user_ip);
							System.out.println("有用户上线----客户端分隔服务器传来的消息，分隔结果 : name="+user.getName()+"ip="+user_ip);
							//客户端显示上线的
							content.append(user_name+user_ip+"上线啦！！！\n");
							onLineUser.put(user_name,user);
							listModel.addElement(user.getName()+user.getIp());
						
						}
					//有用户下线，更新列表
					}else if(command.equals("DELETE")){
							String user_name_1=fenxi.nextToken();
							String user_ip_11=fenxi.nextToken();
							System.out.println("有用户下线，分隔结果 : name="+user_name_1+" ip="+user_ip_11);
							//客户端显示下线
							content.append(user_name_1+user_ip_11+"下线了！！！\n");
							User user=(User)onLineUser.get(user_name_1);
							onLineUser.remove(user);
							listModel.removeElement(user_name_1+user_ip_11);
					}
				   //自己第一次上线了，肯定要加载在线列表
					else if(command.equals("USERLIST")){
							int size=Integer.parseInt(fenxi.nextToken());
							System.out.println("size="+size);
							for(int i=0;i<size;i++){
								String user_name_2=fenxi.nextToken();
								String user_ip_2=fenxi.nextToken();
								System.out.println("加载上线列表，分隔结果:name="+user_name_2+"ip="+user_ip_2);
								User user=new User(user_name_2,user_ip_2);
								onLineUser.put(user_name_2, user);
								listModel.addElement(user_name_2+user_ip_2);
							}
					}else if(command.equals("PRIVATE")){
						//私聊
						String from=fenxi.nextToken();
						String msg=fenxi.nextToken();
						content.append(from+"对你私聊，说:"+msg+"\n");
					}
					//普通消息
					else {
						System.out.println("message="+message);
						content.append(message+"\n");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	//向客户端发送自己的基本信息和消息
	private void sendMessage(String message){
		writer.println(message);
		writer.flush();
	}

}
