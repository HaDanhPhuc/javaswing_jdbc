package GUI;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class giaodienChinh extends JFrame implements ActionListener {
	private JMenuBar menu;
	private CardLayout layout;
	private JMenu menuPhong, menuKH,menuHoaDon,menuTraphong,menuDatphong;
	private JMenuItem icapnhat,iThongkep,iCapNhatKH,iThongKekh,iCt,iThongkeHD,iDatP,iTraP;
	private JPanel pcen;
	private JLabel lbltitle;
	private PanelGiaodienchinh gdc;
	//private PanelKhachhang panelKH;
	public giaodienChinh() {
		super("Quản lý khách sạn");
		layout=new CardLayout();
		setLayout(layout);
		
		biuldUI();
		themaction();
		
		setSize(1300, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void biuldUI() {
	
		 taoMenuBar() ;
		taoCenter();
		
		setJMenuBar(menu);
		add(gdc);
		
		
	}

	private void taoCenter() {
		gdc=new PanelGiaodienchinh();
		
	}


private void taoMenuBar() {
		
		menu=new JMenuBar();
	
		
		taoMenuQLDat();
		taoMenuQLTra();
		taoMenuPhong();
		taoMenuKh();
		taoMenuHD();
		
		
		menu.add(menuDatphong);
		menu.add(menuTraphong);
		menu.add(menuPhong);
		menu.add(menuKH);
		//	menu.add(menuHoaDon);
		
	}


	private void taoMenuQLDat()
	{
		menuDatphong=new JMenu("Đặt phòng");
		menuDatphong.setPreferredSize(new Dimension(120,40));
		menuDatphong.setFont(new Font("arial", Font.BOLD, 22));
		
		iDatP=new JMenuItem("Đặt phòng");
		iDatP.setFont(new Font("arial", Font.BOLD, 15));
		
		menuDatphong.add(iDatP);
	}
	private void taoMenuQLTra() {
		menuTraphong=new JMenu("Trả phòng");
		menuTraphong.setPreferredSize(new Dimension(120,40));
		menuTraphong.setFont(new Font("arial", Font.BOLD, 22));
		
		iTraP=new JMenuItem("Trả phòng");
		iTraP.setFont(new Font("arial", Font.BOLD, 15));
		
		menuTraphong.add(iTraP);
	}
	private void taoMenuPhong() {
		menuPhong=new JMenu("Quản lý phòng");
		menuPhong.setPreferredSize(new Dimension(160,40));
		menuPhong.setFont(new Font("arial", Font.BOLD, 22));
		
		
		
		icapnhat=new JMenuItem("Cập nhật");
		icapnhat.setFont(new Font("arial", Font.BOLD, 15));
		
		iThongkep=new JMenuItem("Doanh thu phòng");
		iThongkep.setFont(new Font("arial", Font.BOLD, 15));
		

		
		menuPhong.add(icapnhat);
		
		menuPhong.add(iThongkep);
	}

	private void taoMenuKh() {
		menuKH=new JMenu("Khách hàng");
		menuKH.setPreferredSize(new Dimension(150,40));
		menuKH.setFont(new Font("arial", Font.BOLD, 22));
		
		
		iCapNhatKH=new JMenuItem("Cập nhật");
		iCapNhatKH.setFont(new Font("arial", Font.BOLD, 15));
		iThongKekh=new JMenuItem("Thống kê");
		iThongKekh.setFont(new Font("arial", Font.BOLD, 15));
		
		
		menuKH.add(iCapNhatKH);
		menuKH.add(iThongKekh);
		
		
	}

	private void taoMenuHD() {
		menuHoaDon=new JMenu("Hóa Đơn");
		menuHoaDon.setPreferredSize(new Dimension(100,40));
		menuHoaDon.setFont(new Font("arial", Font.BOLD, 22));
		
		iCt=new JMenuItem("Xem chi tiết");
		iCt.setFont(new Font("arial", Font.BOLD, 15));
		
		iThongkeHD=new JMenuItem("Thống kê");
		iThongkeHD.setFont(new Font("arial", Font.BOLD, 15));
		

		menuHoaDon.add(iCt);
		menuHoaDon.add(iThongkeHD);
	}

	private void themaction() {
		//panelGDC.getbtnDatPhong().addActionListener(this);
		//panelKH.getBtnTroVe().addActionListener(this);
		//panelKH.getBtnTiepTuc().addActionListener(this);
		
		iDatP.addActionListener(this);
		iTraP.addActionListener(this);
		
		icapnhat.addActionListener(this);
		iThongkep.addActionListener(this);
		
		iCapNhatKH.addActionListener(this);
		iThongKekh.addActionListener(this);
		
		iCt.addActionListener(this);
		iThongkeHD.addActionListener(this);
	}
	 private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
	        int nutbam = JOptionPane.showConfirmDialog(this, "bạn chắc chắn muốn thoát", "THOÁT", JOptionPane.OK_CANCEL_OPTION);
	        if (nutbam == JOptionPane.OK_OPTION) {
	            System.exit(0);
	        }
	        }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o= e.getSource();
		
		if(o.equals(iDatP)) {
			 this.dispose();
			new ThongTinKH().setVisible(true);
			 
		}
		else if(o.equals(iTraP)) {
			this.dispose();
			 new TraPhong().setVisible(true);
				
		}
		else if(o.equals(icapnhat)) {
			this.dispose();
			 new CapNhatP().setVisible(true);
				
		}
		
		else if(o.equals(iCapNhatKH)) {
			this.dispose();
			new CapNhatKH().setVisible(true);
		}
		
		/*else if(o.equals(iThongkep))
			  new DialogThongKeP(this).setVisible(true);*/
		//else if(o.equals(idoiP))
		 // new DialogDoiPhong(this).setVisible(true);
		else if(o.equals(iThongKekh))
				//this.dispose();
			  new ThongkeKH().setVisible(true);
		
	}

	public static void main(String[] args) {
		new giaodienChinh().setVisible(true);
	}

}
