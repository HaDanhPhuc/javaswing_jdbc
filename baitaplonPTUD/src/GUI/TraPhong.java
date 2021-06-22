package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Dao.QLDatPhong;
import Dao.XuLyChung;
import Entity.ThuePhong;
import GUI.DatPhong.DateLabelFormatter;

public class TraPhong extends JFrame implements ActionListener,MouseListener{
	private JPanel khung;
	
	private JComboBox<String >cbGiamgia;
	private JLabel lblTenPhong,lblGia;
	private JLabel lblTenNguoiTra;
	private JLabel lblMaHD;
	private JLabel lblMaTp;
	private JLabel lblTimKiem;
	private JLabel lblTongTien;
	private JLabel lblNgayVao,lblThoiGianVao;
	private JLabel lblGiamgia;
	private JLabel lblNgayRa,lblThoiGianRa;
	
	
	private JTextField txtTenPhong,txtGia;
	private JTextField txtTenNguoiTra;
	private JTextField txtMaHD,txtMaTp;
	private JTextField txtTongTien;
	private JTextField txtGiamGia;
	private JTextField txtTimKiem;
	private JTextField txtThoiGianVao;
	private JTextField txtThoiGianRa;
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JTable table1;
	private DefaultTableModel tableModel1;
	private JTable table3;
	private DefaultTableModel tableModel3;
	
	private Properties p;
	private UtilDateModel modelNT;
	private JDatePanelImpl pDateNT;
	private JDatePickerImpl DateNT;
	
	private UtilDateModel modelNR;
	private JDatePanelImpl pDateNR;
	private JDatePickerImpl DateNR;
	
	private JButton btnThem;
	private JButton btnXoaTrong;
	private JButton btnTimKiem;
	private JButton btnThoat;
	private JButton btnLuu;
	private JButton btnLammoi;
	

	//QuanLiSinhVienDP qlsvdp = new QuanLiSinhVienDP();
	//QuanLiPhongTro qlpt= new QuanLiPhongTro();
	public TraPhong() {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HỆ THÔNG QUẢN LÝ KHÁCH SẠN");
		setBounds(300, 100, 1300, 750);
		khung = new JPanel();
		khung.setBackground(new Color(100,149,237));
		khung.setForeground(new Color(173, 216, 230));
		khung.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(khung);
		khung.setLayout(null);
		
		JLabel lblQLSV = new JLabel("TIẾN HÀNH TRẢ PHÒNG ");
		lblQLSV.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQLSV.setForeground(new Color(0,0,0));
		lblQLSV.setBounds(370, 22, 600, 35);
		khung.add(lblQLSV);
		
		JPanel p1 = new JPanel();
		p1.setForeground(new Color(0,255,255));
		p1.setBackground(new Color(143,188,143));
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hóa đơn trả phòng",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		p1.setBounds(0, 80, 430, 684);
		khung.add(p1);
		p1.setLayout(null);
		
		
		
		String[]headers1 = {"Mã thuê ","Mã phòng","Mã khách hàng","Tên khách hàng","Loại phòng","Giá","Ngày vào","Giờ vào"};
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBounds(440, 90,840,310);
		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng đã thuê phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable.setLayout(new GridLayout(1, 0, 0, 0));
		
		khung.add(pnTable);
		JScrollPane scroll;
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		pnTable.add( scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		/*pnTable.add( scroll = new JScrollPane(table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));*/
		String[]headers2 = {"Mã hóa đơn","Mã thuê phòng","Phòng","Người trả","Ngày vào","Thời gian vào","Ngày ra","Thời gian ra","Giảm giá","Tổng tiền"};
		tableModel1 = new DefaultTableModel(headers1,0);
		JPanel pnTable1= new JPanel();
		pnTable1.setBounds(440, 405,840,300);
		pnTable1.setBackground(new Color(204, 204, 204));
		pnTable1.setBackground(new Color(204, 204, 204));
		pnTable1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hóa đơn trả phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable1.setLayout(new GridLayout(1, 0, 0, 0));
		
		khung.add(pnTable1);
		JScrollPane scroll1;
		table1 = new JTable(tableModel1);
		table1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		pnTable1.add( scroll1 = new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		
		
		
		//KetNoiDatabase.getInstance().Connect();
		//updateDataBang2();
		//updateDataBang1();
		//updateDataBang3();
		
		
		lblMaHD = new JLabel("Mã hóa đơn:");
		lblMaHD .setBounds(10, 50, 120, 14);
		p1.add(lblMaHD );		
		txtMaHD  = new JTextField();
		txtMaHD .setBounds(140, 47, 200, 20);
		p1.add(txtMaHD );
		txtMaHD .setColumns(10);
		
		lblMaTp = new JLabel("Mã thuê phòng:");
		lblMaTp.setBounds(10, 90, 120, 14);
		p1.add(lblMaTp );		
		txtMaTp  = new JTextField();
		txtMaTp.setBounds(140, 87, 200, 20);
		p1.add(txtMaTp );
		txtMaTp .setColumns(10);
		

		lblTenPhong = new JLabel("Phòng:");
		lblTenPhong.setBounds(10, 130, 120, 14);
		p1.add(lblTenPhong );
		txtTenPhong  = new JTextField();
		txtTenPhong.setBounds(140, 127, 200, 20);
		p1.add(txtTenPhong );
		txtTenPhong .setColumns(10);
		
		lblTenNguoiTra= new JLabel("Người trả:");
		lblTenNguoiTra.setBounds(10, 170, 120, 14);
		p1.add(lblTenNguoiTra );
		txtTenNguoiTra = new JTextField();
		txtTenNguoiTra.setBounds(140, 167, 200, 20);
		p1.add(txtTenNguoiTra );
		txtTenNguoiTra .setColumns(10);
		
		DatPhong dp =new DatPhong();
		lblNgayVao= new JLabel("Ngày thuê:");
		lblNgayVao.setBounds(10, 210, 120, 14);
		p1.add(lblNgayVao );
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		modelNT = new UtilDateModel();
		pDateNT = new JDatePanelImpl(modelNT, p);
		DateNT = new JDatePickerImpl(pDateNT,dp. new DateLabelFormatter() );
		DateNT.setBounds(140, 207, 200, 20);
		DateNT.getJFormattedTextField().setBorder(null);
		p1.add(DateNT);

		/*lblThoiGianVao= new JLabel("Thời gian vào:");
		lblThoiGianVao.setBounds(10, 250, 120, 14);
		p1.add(lblThoiGianVao );
		txtThoiGianVao = new JTextField();
		txtThoiGianVao.setBounds(140, 247, 200, 20);
		p1.add(txtThoiGianVao );
		txtThoiGianVao .setColumns(10);*/
		
		lblNgayRa= new JLabel("Ngày ra:");
		lblNgayRa.setBounds(10, 250, 120, 14);
		p1.add(lblNgayRa );
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		modelNR = new UtilDateModel();
		pDateNR = new JDatePanelImpl(modelNR, p);
		DateNR = new JDatePickerImpl(pDateNR, dp.new DateLabelFormatter() );
		DateNR.setBounds(140, 247, 200, 20);
		DateNR.getJFormattedTextField().setBorder(null);
		p1.add(DateNR);
		
		
		lblGia= new JLabel("Giá phòng:");
		lblGia.setBounds(10, 290, 120, 14);
		p1.add(lblGia );
		txtGia = new JTextField();
		txtGia.setBounds(140, 307, 200, 20);
		p1.add(txtGia );
		txtGia .setColumns(10);
		
		
		
		lblGiamgia = new JLabel("Giảm giá:");
		lblGiamgia.setBounds(10, 370, 120, 14);
		p1.add(lblGiamgia );
		cbGiamgia = new JComboBox();
		cbGiamgia.setBounds(140, 367, 200, 20);
		p1.add(cbGiamgia);
		cbGiamgia.addItem("-  -");
		cbGiamgia.addItem("10%");
		cbGiamgia.addItem("30%");
		
		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setBounds(10, 410, 120, 14);
		p1.add(lblTongTien );		
		txtTongTien = new JTextField();
		txtTongTien .setBounds(140, 407, 200, 20);
		p1.add(txtTongTien );
		txtTongTien.setColumns(10);
		
		
		btnThem = new JButton("Trả Phòng");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0,0,205));
		btnThem.setBounds(40, 500, 120, 40);
		p1.add(btnThem);
		
		btnXoaTrong = new JButton("Xóa trống");
		btnXoaTrong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoaTrong.setForeground(new Color(255, 255, 255));
		btnXoaTrong.setBackground(new Color(0,0,205));
		btnXoaTrong.setBounds(180,500, 120, 40);
		p1.add(btnXoaTrong);
		
		btnThoat = new JButton("Trở về");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(0,0,205));
		btnThoat.setBounds(180,550, 120, 40);
		p1.add(btnThoat);
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setBackground(new Color(0,0,205));
		btnLuu.setBounds(40,550, 120, 40);
		p1.add(btnLuu);
		
		/*btnLammoi = new JButton("Refresh");
		btnLammoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLammoi.setForeground(new Color(255, 255, 255));
		btnLammoi.setBackground(new Color(0,0,205));
		btnLammoi.setBounds(100,20, 120, 40);
		khung.add(btnLammoi);
		btnLammoi.addActionListener(this);
		*/
		lblTimKiem= new JLabel("Nhập thông tin cần tìm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(800, 45, 340, 35);
		khung.add(lblTimKiem);
		txtTimKiem= new JTextField();
		txtTimKiem.setBounds(1000,50, 150, 25);
		khung.add(txtTimKiem);
		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(0,0,205));
		btnTimKiem.setBounds(1170, 51, 70, 25);
		khung.add(btnTimKiem);
		/////////////Xử Lý Tìm Kiếm///////////////////////////////////
		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimKiemKeyRelease(evt);
            }
            
			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
        });
		//////////////////////////////////////////////////////////////////////////
		
		
		
		txtMaHD.setText(XuLyChung.layMaHoaDon());
		txtMaHD.setEditable(false);
		txtMaTp.setEditable(false);
		txtTenPhong.setEditable(false);
		//txtQueQuan.setEditable(false);
		//combobox1.setEditable(false);
		//combobox.setEnabled(false);
		DateNT.setEnabled(false);
		//txtTenPhong.setEditable(false);	
		
		
		btnThem.addActionListener(this);
		btnXoaTrong.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		
		updateTP();

	}
	public void updateTP() {
		QLDatPhong qldp=new QLDatPhong();
		tableModel.getDataVector().removeAllElements();
		ArrayList<ThuePhong> dsdp = qldp.layDanhSachTP();
		String temp;
		for (ThuePhong tp : dsdp) {
			temp = tp.toString();
			tableModel.addRow(temp.split(";"));
		}
		//txtMathue.setEditable(false);
		//txtMathue.setText(XuLyChung.layMaTP());
	}
	/*private void updateDataBang1() {
		QuanLiSinhVienDP qlsvdp  = new QuanLiSinhVienDP();
		List<SinhVienDP>list = qlsvdp.docTuBangSinhVienDP();
		for(SinhVienDP s : list) {
			String[] rowdata = {s.getMaSV(),s.getTenSinhVien(),s.getGioiTinh(),s.getSoDienThoai(),s.getCmnd(),s.getQueQuan(),s.getNgayVaoPhong(),s.getMaPhong()+""};
			tableModel.addRow(rowdata);
		}
		table.setModel(tableModel);
	}
	private void updateDataBang2() {
		QuanLiPhongTro qlpt = new QuanLiPhongTro();
		List<PhongTro>list = qlpt.docbangPhongTrong();
		for(PhongTro s : list) {
			String[] rowdata = {s.getMaPhong(),s.getTrangThai(),s.getSoNguoi(),s.getDiaChi(),s.getTenChuTro(),s.getSdt()+""};
			tableModel1.addRow(rowdata);
		}
		table1.setModel(tableModel1);
	}
	private void updateDataBang3() {
		QuanLiPhongTro qlpt = new QuanLiPhongTro();
		List<PhongTro>list = qlpt.docbangPhongdadat();
		for(PhongTro s : list) {
			String[] rowdata = {s.getMaPhong(),s.getTrangThai(),s.getSoNguoi(),s.getDiaChi(),s.getTenChuTro(),s.getSdt()+""};
			tableModel3.addRow(rowdata);
		}
		table3.setModel(tableModel3);
	}
	public static void main(String[] args) {
		/////////////Phải Theo mẫu///////////////////////
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienDatPhong().setVisible(true);
            }
        });
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnThem)){
			XoaRong();
			
			
		}
		if(o.equals(btnXoaTrong))
		{
			XoaRong();
		}
		
		if(o.equals(btnThoat))
		{
			this.dispose();
			new giaodienChinh().setVisible(true);
			
		}	
		/*if(o.equals(btnLuu))
		{
			themSinhVienDP();
			KetNoiDatabase.getInstance().Connect();
			updateDataBang2();
			updateDataBang1();
			updateDataBang3();
			
		}*/
		if(o.equals(btnLammoi)){
			
		}
		
	}
	public void XoaRong(){

		txtTenPhong.setText("");
		txtTenNguoiTra.setText("");
		txtTongTien.setText("");
		txtMaTp.setText("");
		txtThoiGianVao.setText("");		
		txtThoiGianRa.setText("");
		//txtNgayRa.setText("");
	}
	
	/*private boolean kiemloi(){
		String tensv = txtTenSinhVien.getText().trim();
		String Mssv = txtMaSinhVien.getText().trim();
		String Cmnd = txtCmnd.getText().trim();
		String ngayVao = txtNgayVao.getText().trim();
		String SoDienThoai = txtSoDienThoai.getText().trim();
		String maPhong = txtMaPhong.getText().trim();
		if(!(tensv.length()>0 ))
		{
			JOptionPane.showMessageDialog(this, "Tên nhập không được nhập số");
			txtTenSinhVien.requestFocus();
			return false;
		}
		if(!(Mssv.length()>0 && Mssv.matches("[SV]{2}\\d{2,3}")))
		{

			JOptionPane.showMessageDialog(this, "Mã Số Sinh viên theo định dạng [SV]{2}\\d{2,3}");
			txtMaSinhVien.requestFocus();
			return false;
		}
		if(!(Cmnd.length()>0 && Cmnd.matches("\\d{9}"))){
			JOptionPane.showMessageDialog(this, "Số Chứng Minh Nhân dân gồm 9 số từ 0-9");
			txtCmnd.requestFocus();
			return false;
		}
		if(!(ngayVao.length()>0 && ngayVao.matches("^\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}$"))){

		JOptionPane.showMessageDialog(this, "Nhập ngày Vào theo định dạng 0000-00-00 , Năm-Tháng-Ngày< ngày hiện tại ");
		txtNgayVao.requestFocus();
			return false;
			}
		if(!(maPhong.length()>0 && maPhong.matches("[A-Z]\\d{2,3}"))) {
			JOptionPane.showMessageDialog(this, "Mã Phòng có định dạng [A-Z]\\d{3}");
			txtMaPhong.requestFocus();
			return false;
		}
		if(!(SoDienThoai.length()>0 && SoDienThoai.matches("^0[0-9]{8}$")))
		{
			JOptionPane.showMessageDialog(this, "Số Điện thoại theo mẫu ^0[0-9]{8}$");
			txtSoDienThoai.requestFocus();
			return false;
		}
		return true;
	}*/
	/*public void themSinhVienDP() {

		if(kiemloi())
	{

			if(qlsvdp.ThemSinhVienDP(txtMaSinhVien.getText(), txtTenSinhVien.getText(), 
					combobox.getSelectedItem().toString(), txtSoDienThoai.getText(),txtCmnd.getText(), 
					combobox1.getSelectedItem().toString(), txtNgayVao.getText(), txtMaPhong.getText())){	

				Object[]rowdata = {txtMaSinhVien.getText(), txtTenSinhVien.getText(), 
						combobox.getSelectedItem().toString(), txtSoDienThoai.getText(),txtCmnd.getText(), 
						combobox1.getSelectedItem().toString(), txtNgayVao.getText(), txtMaPhong.getText()};
				tableModel.addRow(rowdata);
					XoaRong();
				//xoadongphongtrong();
				JOptionPane.showMessageDialog(this, "Đặt Trọ Thành Công");
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Mã Sinh Viên  Trùng Hoặc Mã Phòng Không Tồn Tại");
			}
		}

	}*/
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row  = table.getSelectedRow();
		txtMaTp.setText(table.getValueAt(row, 0).toString());
		txtTenPhong.setText(table.getValueAt(row, 1).toString());
		txtTenNguoiTra.setText(table.getValueAt(row, 3).toString());	
		//DateNT.setda(table.getValueAt(row, 5).toString());
		txtGia.setText(table.getValueAt(row, 5).toString());
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
