import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.Random;

public class test {
	private JTextArea decipherText, clearText, cipherText;
	private JFrame frame;
	private JTextField p;
	private JTextField txtp;
	private JTextField txtq;
	private JTextField q;
	private JTextField textField_2;
	private JTextField publicKey;
	private JTextField textField_4;
	private JTextField privateKey;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private int mPrivateKey;
	private int mPublicKey;
	private int n, n1;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 435, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		p = new JTextField();
		p.setBounds(66, 10, 346, 21);
		frame.getContentPane().add(p);
		p.setColumns(10);

		txtp = new JTextField();
		txtp.setEditable(false);
		txtp.setFont(new Font("宋体", Font.PLAIN, 12));
		txtp.setText("质数P");
		txtp.setBounds(10, 10, 38, 21);
		frame.getContentPane().add(txtp);
		txtp.setColumns(10);

		txtq = new JTextField();
		txtq.setText("质数Q");
		txtq.setFont(new Font("宋体", Font.PLAIN, 12));
		txtq.setEditable(false);
		txtq.setColumns(10);
		txtq.setBounds(10, 41, 38, 21);
		frame.getContentPane().add(txtq);

		q = new JTextField();
		q.setColumns(10);
		q.setBounds(66, 41, 346, 21);
		frame.getContentPane().add(q);

		textField_2 = new JTextField();
		textField_2.setText("公钥");
		textField_2.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 77, 38, 21);
		frame.getContentPane().add(textField_2);

		publicKey = new JTextField();
		publicKey.setColumns(10);
		publicKey.setBounds(66, 77, 346, 21);
		frame.getContentPane().add(publicKey);

		textField_4 = new JTextField();
		textField_4.setText("私钥");
		textField_4.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 108, 38, 21);
		frame.getContentPane().add(textField_4);

		privateKey = new JTextField();
		privateKey.setColumns(10);
		privateKey.setBounds(66, 108, 346, 21);
		frame.getContentPane().add(privateKey);
		textField_6 = new JTextField();
		textField_6.setText("输入明文");
		textField_6.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(10, 146, 56, 21);
		frame.getContentPane().add(textField_6);
		textField_7 = new JTextField();
		textField_7.setText("生成密文");
		textField_7.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(10, 247, 56, 21);
		frame.getContentPane().add(textField_7);
		textField_8 = new JTextField();
		textField_8.setText("解密后的明文");
		textField_8.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(10, 359, 81, 21);
		frame.getContentPane().add(textField_8);
		decipherText = new JTextArea();
		decipherText.setBounds(97, 355, 307, 97);
		frame.getContentPane().add(decipherText);
		cipherText = new JTextArea();
		cipherText.setBounds(97, 242, 307, 97);
		frame.getContentPane().add(cipherText);
		clearText = new JTextArea();
		clearText.setBounds(97, 139, 307, 97);
		frame.getContentPane().add(clearText);
		JButton generatePQ = new JButton("生成质数P和Q");
		generatePQ.setBounds(10, 469, 117, 33);
		frame.getContentPane().add(generatePQ);
		JButton generateKey = new JButton("生成公钥和私钥");
		generateKey.setBounds(135, 469, 127, 33);
		frame.getContentPane().add(generateKey);
		JButton encrypt = new JButton("加密");
		encrypt.setBounds(268, 469, 70, 33);
		frame.getContentPane().add(encrypt);
		JButton decipher = new JButton("解密");
		decipher.setBounds(342, 469, 70, 33);
		frame.getContentPane().add(decipher);
		generatePQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPrime(p);
				setPrime(q);
			}

		});

		generateKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPublicKey();
				setPrivateKey();
			}
		});

		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				encryText();
			}
		});

		decipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decipherText();
			}
		});
	}

	protected void decipherText() {
		// TODO Auto-generated method stub
		BigInteger mCipherText = new BigInteger(cipherText.getText().toString());
		BigInteger mDecipherText = mCipherText.pow(mPrivateKey).mod(new BigInteger(String.valueOf(n)));
		decipherText.setText(mDecipherText + "");

	}

	protected void encryText() {
		// TODO Auto-generated method stub
		int mClearText = Integer.parseInt(clearText.getText().toString().trim());
		int mCipherText = (int) ((Math.pow(mClearText, mPublicKey)) % n);
		cipherText.setText(mCipherText + "");

	}

	protected void setPublicKey() {
		// TODO Auto-generated method stub
		Random random = new Random();
		do {
			mPublicKey = 2 + random.nextInt(100);
		} while (isPrime(mPublicKey) == false);

		publicKey.setText(mPublicKey + "");

	}

	protected void setPrivateKey() {
		// TODO Auto-generated method stub
		int mp = 0, mq = 0;
		mPublicKey = 0;
		mPrivateKey = 0;
		mPublicKey = Integer.parseInt(publicKey.getText().toString().trim());
		mp = Integer.parseInt(p.getText().toString().trim());
		mq = Integer.parseInt(q.getText().toString().trim());
		n = mp * mq;
		n1 = (mp - 1) * (mq - 1);
		for (int i = 0; i < n1; i++) {
			mPrivateKey++;
			if ((mPublicKey * mPrivateKey) % n1 == 1) {
				break;
			}
		}

		clearText.setText("明文要小于" + n);
		privateKey.setText(mPrivateKey + "");
	}

	private void setPrime(JTextField x) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int prime = 0;
		do {
			prime = 2 + random.nextInt(5000);
			x.setText(prime + "");
		} while (isPrime(prime) == false);

	}

	private boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				System.out.println(number + "不是质数");
				return false;
			}
		}
		System.out.println(number + "是质数");
		return true;
	}
}
