package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import Dao.KetNoiSQL;
import Dao.QLNhanVien;
public class DangNhap  extends JFrame implements MouseListener{
	private JButton btnDn;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	
     ImageIcon iconnen=new ImageIcon("hinhanh/hinhnendau.png");
      JLabel l1=new JLabel(iconnen);

     
     ImageIcon icon1=new ImageIcon("hinhanh/icon2.png");
     ImageIcon icon2=new ImageIcon("hinhanh/left.png");
     JLabel licon1=new JLabel(icon1);
     JLabel lqt=new JLabel("Quản Trị");
     JLabel left=new JLabel(icon2);
     
     ImageIcon icon3=new ImageIcon("hinhanh/icon3.png");
     JLabel licon3=new JLabel(icon3);
     JLabel lnhanvien=new JLabel("Nhân Viên");
     
     //ImageIcon icon4=new ImageIcon("hinhanh/icon4.png");
    // JLabel licon4=new JLabel(icon4);
     //JLabel lkhachhang=new JLabel("Khách Hàng");
     
     ImageIcon ks=new ImageIcon("hinhanh/39.jpg");
     JLabel lks=new JLabel(ks);
     ImageIcon ip3=new ImageIcon("hinhanh/nen.png");
     JLabel lnen=new JLabel(ip3);
     
     ImageIcon usericon=new ImageIcon("hinhanh/user.png");
     ImageIcon passwordlabel=new ImageIcon("hinhanh/passwordlabel.png");
     JLabel luser=new JLabel(usericon);
     JLabel lpass=new JLabel(passwordlabel);
     
     
     ImageIcon icondn=new ImageIcon("hinhanh/nutdangnhap.png");
     //JButton btndn=new JButton("Đăng nhập");
     //JButton btndn=new JButton(icondn);
     JLabel ldangnhap=new JLabel(icondn);
     
     JTextField tkdn=new JTextField(20);
     JPasswordField mkdn=new JPasswordField(20);
     
     public static String tkdnqt;
      static String tkdnnv;
     
     JLabel ltkdn=new JLabel("Tài Khoản");
     JLabel lmkdn=new JLabel("Mật Khẩu");
     
     ImageIcon ip4=new ImageIcon("hinhanh/nen.png");
     JLabel lnen1=new JLabel(ip4);
     ImageIcon iconuser=new ImageIcon("hinhanh/user.png");
     JLabel userl1=new JLabel(iconuser);
     ImageIcon iconpass=new ImageIcon("hinhanh/passwordlabel.png");
     JLabel passl1=new JLabel(iconpass);
     
    // JButton btndnnv=new JButton("Đăng nhập");
     ImageIcon icondn1=new ImageIcon("hinhanh/dnnv.png");
     JLabel ldn1=new JLabel(icondn1);
     //JLabel ldn1=new JLabel();
    //JButton btndn=new JButton(icondn1);
     
     
     ImageIcon huhu=new ImageIcon("hinhanh/huhu.jpg");
     JLabel lhuhu=new JLabel(huhu);
     
     JTextField tkdn1=new JTextField(20);
     JPasswordField mkdn1=new JPasswordField(20);
     
    // Statement stm;
 	//ResultSet rs;
 	
	public DangNhap(String title)
	{
		super(title);
		this.setSize(1000, 600);
		this.setLayout(null);
		//p.setBackground(Color.lightGray);
		this.add(p1);
		p1.setBounds(0, 0, 200, 600);
		p1.setBackground(Color.GRAY);
		this.p1();
		this.add(p2);
		p2.setBounds(200, 0, 800, 600);
		//p2.setBorder(new BevelBorder(BevelBorder.RAISED));
		p2.setBackground(Color.lightGray);
		this.p2();
		
		this.add(p3);
		p3.setBounds(200, 0, 800, 600);
		p3.setVisible(false);
		this.p3();
		tkdn.setVisible(false);
		mkdn.setVisible(false);
		
		this.add(p4);
		p4.setBounds(200, 0, 800, 600);
		p4.setVisible(false);
		this.p4();
		
		tkdn1.setVisible(false);
		mkdn1.setVisible(false);
	}
	public void p1()
	{
	   p1.setLayout(null);
	   p1.add(licon1);
	   p1.add(licon3);
	   p1.add(lqt);
	   p1.add(lnhanvien);
	   //p1.add(licon4);
	   //p1.add(lkhachhang);
	   lqt.setBounds(80, 100, 100, 50);
	   lqt.setForeground(Color.WHITE);
	   p1.add(left);
	   left.setBounds(0, 0, 200, 550);
	   licon1.setBounds(0, 10, 200, 100);
	  
	   licon3.setBounds(0, 150, 200, 100);
	   lnhanvien.setBounds(80, 250, 200, 50);
	   lnhanvien.setForeground(Color.WHITE);
	   
	  // licon4.setBounds(0, 300, 200, 100);
	   //lkhachhang.setBounds(70, 400, 200, 50);
	  // lkhachhang.setForeground(Color.white);
	   
	   licon1.addMouseListener(this);
	   licon3.addMouseListener(this);
	 //  licon4.addMouseListener(this);
	  // ldn1.addActionListener((ActionListener) this);
	}
	public void p2()
	{
		p2.setLayout(null);
		JLabel lchao=new JLabel("Phần Mềm Quản Lý Khách Sạn");
		p2.add(lchao);
		lchao.setBounds(200, 0, 600, 50);
		lchao.setFont(new Font("SansSerif", Font.ITALIC, 29));
		p2.add(lks);
		lks.setBounds(0, 50, 800, 600);
		
	}
	public void p3()
	{
		p3.setLayout(null);
		JLabel lchao=new JLabel("Bạn Đang Nhập Quyền Quản Trị");
		lchao.setFont(new Font("SansSerif", Font.ITALIC, 29));
		p3.add(lchao);
		lchao.setBounds(100, 20, 500, 100);
		p3.add(luser);
		p3.add(ltkdn);
		luser.setBounds(200, 100, 300, 100);
		ltkdn.setBounds(150, 120, 200, 50);
		
		p3.add(lpass);
		p3.add(lmkdn);
		lmkdn.setBounds(150, 220, 200, 50);
		lpass.setBounds(200, 200, 300, 100);
		
		p3.add(ldangnhap);
		ldangnhap.setBounds(200, 300, 300, 100);
		
		p3.add(tkdn);
		tkdn.setBounds(250, 120, 300, 50);
		tkdn.setBorder(new BevelBorder(BevelBorder.LOWERED));
		p3.add(mkdn);
		mkdn.setBounds(250, 220, 300, 50);
		mkdn.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		p3.add(lnen);
		lnen.setBounds(0, 0, 800, 600);
		
		tkdn.addMouseListener(this);
		mkdn.addMouseListener(this);
		luser.addMouseListener(this);
		lpass.addMouseListener(this);
		ldangnhap.addMouseListener(this);
		//btndn.addActionListener((ActionListener) this);
		ldn1.addMouseListener(this);
		
	}
	public void p4()
	{
		p4.setLayout(null);
		JLabel lchao1=new JLabel("Bạn Đang Nhập Quyền Nhân Viên");
		lchao1.setFont(new Font("SansSerif", Font.ITALIC, 29));
		
		JLabel ltkdn1=new JLabel("Tài Khoản");
		JLabel lmkdn1=new JLabel("Mật Khẩu");
		
		p4.add(lchao1);
		lchao1.setBounds(100, 20, 500, 100);
		p4.add(userl1);
		userl1.setBounds(200, 100, 300, 100);
		p4.add(passl1);
		passl1.setBounds(200, 200, 300, 100);
		
		ldn1.setBounds(200, 300, 60, 30);
		p4.add(ldn1);
		
	//	p4.add(ldn1);
		//p4.add(btndn);
		//btndn.setBounds(200, 300, 300, 100);
		p4.add(ltkdn1);
		ltkdn1.setBounds(150, 120, 200, 50);
		p4.add(lmkdn1);
		lmkdn1.setBounds(150, 220, 200, 50);
		p4.add(tkdn1);
		tkdn1.setBounds(250, 120, 300, 50);
		p4.add(mkdn1);
		mkdn1.setBounds(250, 220, 300, 50);
		
		p4.add(lnen1);
		lnen1.setBounds(0, 0, 800, 600);
		
		
		tkdn1.addMouseListener(this);
		mkdn1.addMouseListener(this);
		userl1.addMouseListener(this);
		passl1.addMouseListener(this);
		//btndnnv.addMouseListener(this);
		ldn1.addMouseListener(this);
		//btndn.addActionListener((ActionListener) this);
		//btndn.addMouseListener(this);
		//btndnnv.addActionListener((ActionListener) this);
	}
	
	/*public void kiemtradnqt()
	{
		KetNoi kn=new KetNoi();
		String tk=tkdn.getText();
		String mk=mkdn.getText();
		String sql="select taikhoan,matkhau from loginquantri where taikhoan='"+tk+"' and matkhau='"+mk+"'";
		try {
			stm=kn.con.createStatement();
			rs=stm.executeQuery(sql);
			int dem=0;
			while(rs.next())
			{
				dem++;
			}
			if(dem==1)
			{
				
					QuanTri qt=new QuanTri("QUẢN TRỊ");
					qt.setVisible(true);
					qt.setLocationRelativeTo(null);
				
				  this.setVisible(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Bạn Nhập Chưa Đúng Tài Khoản Hoặc Mật Khẩu");
			}
			
		} catch (SQLException e) {
			System.out.println("khong the");
		}
	}*/
	public void kiemtradnnv() throws ClassNotFoundException
	{
		
		String tk=tkdn1.getText();
		String mk=mkdn1.getText();
		String sql="select TenNV,MatKhau from NhanVien where MaNV='"+tk+"' and Matkhau='"+mk+"'";
		
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			int dem=0;
			while(resultSet.next())
			{
				dem++;
			}
			if(dem==1)
			{
				giaodienChinh gdc=new giaodienChinh();
				gdc.setVisible(true);
				this.setVisible(false);
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Bạn Nhập Chưa Đúng Tài Khoản Hoặc Mật Khẩu");
			}
			
			
		} catch (SQLException e) {
			System.out.println("khong the");
		}
	}
	
	public static void main(String[]args)
	{
		
		DangNhap gd=new DangNhap("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
		gd.setVisible(true);
		gd.setLocationRelativeTo(null);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==licon1)
		{
			p2.setVisible(false);
			p3.setVisible(true);
		}
		else if(e.getSource()==licon3)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(true);
		}
		else if(e.getSource()==ldn1)
		{
			try{
				
				kiemtradnnv();
				tkdnnv=tkdn1.getText();
			}catch(Exception b)
			{
				
			}
		}
		/*else if(e.getSource()==licon4)
		{
			GiaodienKH gdkh=new GiaodienKH();
			   gdkh.setVisible(true);
			   gdkh.setLocationRelativeTo(null);
			   this.setVisible(false);
		}
		else if(e.getSource()==ldangnhap)
		{
			try{
				kiemtradnqt();
				tkdnqt=tkdn.getText();
				
			}catch(Exception b)
			{
				
			}
		}*/
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==licon1)
		{
			licon1.setBounds(0, 15, 200, 100);
		}
		else if(e.getSource()==licon3)
		{
			licon3.setBounds(0, 160, 200, 100);
		}
		/*else if(e.getSource()==licon4)
		{
			licon4.setBounds(0, 310, 200, 100);
		}*/
		else if(e.getSource()==luser)
		{
			tkdn.setVisible(true);
			
			luser.setVisible(false);
			
		}
		else if(e.getSource()==lpass)
		{
			mkdn.setVisible(true);
			lpass.setVisible(false);
		}
		else if(e.getSource()==userl1)
		{
			tkdn1.setVisible(true);
			userl1.setVisible(false);
		}
		else if(e.getSource()==passl1)
		{
			mkdn1.setVisible(true);
			passl1.setVisible(false);
		}
		else if(e.getSource()==ldangnhap)
		{
			ldangnhap.setBounds(200, 310, 300, 100);
		}
	
		else if(e.getSource()==ldn1)
		{
			ldn1.setBounds(200, 310, 300, 100);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		licon1.setBounds(0, 10, 200, 100);
		licon3.setBounds(0, 150, 200, 100);
		//licon4.setBounds(0, 300, 200, 100);
		ldangnhap.setBounds(200, 300, 300, 100);
		ldn1.setBounds(200, 300, 300, 100);
	
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
