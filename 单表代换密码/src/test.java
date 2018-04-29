import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;


public class test extends Kaesar{

	private JFrame frame;
	private JTextField message;
	private final static String upperLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    private final static String lowerLetter = "abcdefghijklmnopqrstuvwxyz"; 
    private JButton crack;
    private JTextArea result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		super(upperLetter);
		initialize();
	}
	
	
	@Override
	public void setTable(String table) {
		// TODO Auto-generated method stub
		super.setTable(table);
	}

	@Override
	public String decrypt(String text, int num) {
		checkTextTypeAndSetTable(text);
		// TODO Auto-generated method stub
		return super.decrypt(text, num);
	}
	
	
	@Override
	public String encrypt(String text, int num) {
		checkTextTypeAndSetTable(text);
		// TODO Auto-generated method stub
		return super.encrypt(text, num);
	}

	
	
	@Override
	public String crack(String text) {
		checkTextTypeAndSetTable(text);
		// TODO Auto-generated method stub
		return super.crack(text);
	}

	@Override
	public String encryptText(String text, int num) {
		// TODO Auto-generated method stub
		int len=table.length();
		StringBuffer result=new StringBuffer();
		for(int i=0;i<text.length();i++){
			char curChar=text.charAt(i);
			int idx=table.indexOf(curChar);
			if(idx==-1){
				result.append(curChar);
				continue;
			}
			
			idx=((idx+num)%len);
			result.append(table.charAt(idx));
		}
		return result.toString();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 450, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		message = new JTextField();
		message.setFont(new Font("宋体", Font.PLAIN, 15));
		message.setBounds(36, 10, 375, 40);
		frame.getContentPane().add(message);
		message.setColumns(200);
		JButton encrypt = new JButton("encrypt");
		encrypt.setBounds(46, 60, 100, 40);
		frame.getContentPane().add(encrypt);
		JButton deciphering = new JButton("deciphering");
		deciphering.setBounds(156, 60, 100, 40);
		frame.getContentPane().add(deciphering);
		
		crack = new JButton("crack");
	
		crack.setBounds(266, 60, 100, 40);
		frame.getContentPane().add(crack);
		
		result = new JTextArea();
		result.setRows(26);
		result.setColumns(30);
		result.setFont(new Font("黑体", Font.PLAIN, 15));
		result.setBounds(26, 110, 375, 481);
		frame.getContentPane().add(result);
		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String encodeStr=encrypt(message.getText().toString().trim(),3);
				result.setText(encodeStr);
			}
		});
		deciphering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String decodeStr=decrypt(message.getText().toString().trim(),3);
				result.setText(decodeStr);
			}
		});
		
		crack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String crackStr=crack(message.getText().toString().trim());
				result.setText(crackStr);
			}
		});
	}
	
	private void checkTextTypeAndSetTable(String text){
		char curChar=text.charAt(0);
		if(Character.isUpperCase(curChar)){
			setTable(upperLetter);
		}else{
			setTable(lowerLetter);
		}
	}
}
