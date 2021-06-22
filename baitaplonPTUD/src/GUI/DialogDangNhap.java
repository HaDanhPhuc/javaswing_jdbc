package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class DialogDangNhap extends JDialog implements ActionListener {
	//private NhanVien nhanVien;

	private JPanel pNorth,pWest,pleft,pright,psou,pnou;
	private JLabel lblTitle, lblMaNV, lblMatKhau, lblThongBao;
	private JTextField txtMaNV;
	private JSplitPane slip;
	private JPasswordField passMatKhau;
	private JButton btnDangNhap, btnThoat, btnXoaTrang;

	public DialogDangNhap(Frame nn) {
		super();
		
		setTitle("Đăng nhập");
		buildUI();
		themActionListenr();

		setSize(900, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void buildUI() {
		taoNorthPanel();
		taoCenterPanel();
		
		add(pNorth, BorderLayout.NORTH);
		add(slip, BorderLayout.CENTER);
	
		
	}
	public void taoNorthPanel() {
		pNorth = new JPanel();
		pNorth.setBackground(Color.cyan);
		lblTitle = new JLabel("Đăng nhập");
		lblTitle.setForeground(Color.blue);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
		pNorth.add(lblTitle);
	}
	
	public void taoCenterPanel() {
		taoCenterLeftPanel();
		taoCenterRightPanel();
		slip=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pleft,pright);
		slip.setDividerSize(0);
	}
	

private void taoCenterRightPanel() {
	pright=new JPanel();
		Box b=Box.createVerticalBox();
		Box b1,b2,b3,b4,b5;
		b.add(Box.createVerticalStrut(100));
		b.add(b1=Box.createVerticalBox());
		b1.add(lblMaNV=new JLabel("Mã nhân viên:"));
		b1.add(Box.createVerticalStrut(5));
		b1.add(txtMaNV=new JTextField(30));
		b1.add(Box.createVerticalStrut(15));
		
		b.add(b2=Box.createVerticalBox());
		b2.add(lblMatKhau=new JLabel("Mật khẩu:"));
		b2.add(Box.createVerticalStrut(5));
		b2.add(passMatKhau=new JPasswordField(30));
		b2.add(Box.createVerticalStrut(30));
		
		Box b0=Box.createHorizontalBox();
		b0.add(b3=Box.createHorizontalBox());
		b3.add(btnDangNhap=new JButton("Đăng nhập"));
		b3.add(Box.createHorizontalStrut(15));
		
		b0.add(b4=Box.createHorizontalBox());
		b4.add(btnXoaTrang=new JButton("Xóa trắng"));
		b4.add(Box.createHorizontalStrut(10));
		
		b0.add(b5=Box.createHorizontalBox());
		b5.add(btnThoat=new JButton("Thoát"));
		
		
		pright.add(b);
		pright.add(b0);
		
	}

/*private void taoCenterRightPanel() {
		pright = new JPanel();
		pright.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 2;
		c.ipady = 2;
		c.insets = new Insets(5, 5, 5, 5);

		lblMaNV = new JLabel("Mã nhân viên:");
		lblMatKhau = new JLabel("Mật khẩu:");
		lblThongBao = new JLabel();
		txtMaNV = new JTextField(20);
		passMatKhau = new JPasswordField(20);

		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		pright.add(lblMaNV, c);
		c.weightx = 0.5;
		c.gridx = 1;
		pright.add(txtMaNV, c);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		pright.add(lblMatKhau, c);
		c.weightx = 0.5;
		c.gridx = 1;
		pright.add(passMatKhau, c);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 4;
		pright.add(lblThongBao, c);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnXoaTrang = new JButton("Xóa trắng");
		btnThoat = new JButton("Thoát");

		pright.add(btnDangNhap);
		pright.add(btnXoaTrang);
		pright.add(btnThoat);
		
	}*/
	public void taoCenterLeftPanel(){
		pleft=new JPanel();
		
		try {
			BufferedImage  mypicture = ImageIO.read(new File("hinh/ks.jfif"));
			ImageIcon icon=new ImageIcon(mypicture.getScaledInstance(450, 600, mypicture.SCALE_SMOOTH));
			JLabel picLabel=new JLabel(icon);
			//Container pwest = null;
			pleft.add(picLabel);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void themActionListenr() {
		btnThoat.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnDangNhap.addActionListener(this);
		txtMaNV.addActionListener(this);
		passMatKhau.addActionListener(this);
		themWindowListener();
	}

	public void themWindowListener() {
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang))
			xoaTrangAction();
		else if (o.equals(btnThoat))
			thoatAction();
		
	}

	private void xoaTrangAction() {
		txtMaNV.setText("");
		txtMaNV.requestFocus();
		passMatKhau.setText("");
		lblThongBao.setText("");
	}

	private void thoatAction() {
		System.exit(0);
	}

	
public static void main(String[] args) {
	new DialogDangNhap(null).setVisible(true);
}
}
