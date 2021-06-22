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

import Dao.QLDatPhong;
import Dao.QLKhachHang;
import Dao.QLPhong;
import Dao.XuLyChung;
import Entity.KhachHang;
import Entity.Phong;

public class ThongTinKH extends JFrame implements ActionListener,MouseListener{
private JPanel khung;
	
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel lblCmnd;
	private JLabel lblQueQuan;
	private JLabel lblPhai;
	private JLabel lblTimKiem;
	private JLabel lblsdt;

	private JComboBox <String> combobox,combobox1,cbgiamgia;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtCmnd;
	private JTextField txtTimKiem;
	private JTextField txtsdt,txtquequan;
	
	private JTable tableP;
	private DefaultTableModel tableModel1;
	private JTable tableKH;
	private DefaultTableModel tableModel3;
	
	private JButton btnThem;
	private JButton btnTimKiem;
	private JButton btnThoat;
	private JButton btnLuu;
	private JButton btnLammoi;
	private CapNhatKH capNhatKH;
	//QuanLiSinhVienDP qlsvdp = new QuanLiSinhVienDP();
	//QuanLiPhongTro qlpt= new QuanLiPhongTro();
	public ThongTinKH() {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HỆ THÔNG QUẢN LÝ KHÁCH SẠN");
		setBounds(300, 100, 1300, 700);
		khung = new JPanel();
		khung.setBackground(new Color(100,149,237));
		khung.setForeground(new Color(173, 216, 230));
		khung.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(khung);
		khung.setLayout(null);
		
		JLabel lblQLSV = new JLabel("THÊM THÔNG TIN KHÁCH HÀNG ");
		lblQLSV.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQLSV.setForeground(new Color(0,0,0));
		lblQLSV.setBounds(370, 22, 600, 35);
		khung.add(lblQLSV);
		
		JPanel p1 = new JPanel();
		p1.setForeground(new Color(0,255,255));
		p1.setBackground(new Color(143,188,143));
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin khách hàng:",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		p1.setBounds(0, 80, 430, 684);
		khung.add(p1);
		p1.setLayout(null);
	
		String[]headers2 = {"Mã khách hàng","Tên khách hàng","Số CMND/Thẻ căn cước","Quê quán","Giới tính","Số điện thoại"};
		tableModel1 = new DefaultTableModel(headers2,0);
		JPanel pnTable1= new JPanel();
		pnTable1.setBounds(440,390 ,840,270);
		pnTable1.setBackground(new Color(204, 204, 204));
		pnTable1.setBackground(new Color(204, 204, 204));
		pnTable1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable1.setLayout(new GridLayout(1, 0, 0, 0));
		khung.add(pnTable1);
		JScrollPane scroll1;
		/*pnTable1.add( scroll1 = new JScrollPane(tableP = new JTable(tableModel1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		}));
		scroll1.setBackground(new Color(102, 0, 102));
		tableP.setForeground(new Color(0, 0, 0));
		tableP.setBackground(new Color(204, 204, 204));
		tableP.setRowHeight(25);
		tableP.setAutoCreateRowSorter(true);
		scroll1.setViewportView(tableP);*/
		tableKH = new JTable(tableModel1);
		tableKH.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		pnTable1.add( scroll1 = new JScrollPane(tableKH, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		String[]headers3 = {"Mã phòng","Tên phòng","Mã loại phòng","Trạng thái","Tình trạng","Ghi chú"};
		tableModel3 = new DefaultTableModel(headers3,0);
		JPanel pnTable2= new JPanel();
		pnTable2.setBounds(440, 85,840,300);
		pnTable2.setBackground(new Color(204, 204, 204));
		pnTable2.setBackground(new Color(204, 204, 204));
		pnTable2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách phòng trống", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable2.setLayout(new GridLayout(1, 0, 0, 0));
		khung.add(pnTable2);
		
		JScrollPane scroll3;
		tableP = new JTable(tableModel3);
		tableP.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		pnTable2.add( scroll3 = new JScrollPane(tableP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		//KetNoiDatabase.getInstance().Connect();
		//updateDataBang2();
		//updateDataBang1();
		//updateDataBang3();
		
		
		lblMaKH= new JLabel("Mã Khách hàng:");
		lblMaKH .setBounds(10, 50, 120, 14);
		p1.add(lblMaKH );		
		txtMaKH  = new JTextField();
		txtMaKH .setBounds(140, 47, 200, 20);
		p1.add(txtMaKH );
		txtMaKH .setColumns(10);
		
		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH .setBounds(10, 100, 120, 14);
		p1.add(lblTenKH);		
		txtTenKH  = new JTextField();
		txtTenKH .setBounds(140, 97, 200, 20);
		p1.add(txtTenKH );
		txtTenKH .setColumns(10);
		
		lblCmnd = new JLabel("Số CMND:");
		lblCmnd .setBounds(10, 150, 120, 14);
		p1.add(lblCmnd );		
		txtCmnd  = new JTextField();
		txtCmnd.setBounds(140, 147, 200, 20);
		p1.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		lblQueQuan = new JLabel("Quê quán:");
		lblQueQuan.setBounds(10, 200, 120, 14);
		p1.add(lblQueQuan );
		txtquequan  = new JTextField();
		txtquequan.setBounds(140, 197, 200, 20);
		p1.add(txtquequan);
		txtquequan.setColumns(10);
		
	/*	combobox1 = new JComboBox();
		combobox1.setBounds(140, 197, 200, 20);
		p1.add(combobox1);
		combobox1.addItem("-   -");
		combobox1.addItem("An Giang");
		combobox1.addItem("Bà Rịa - Vũng Tàu");
		combobox1.addItem("Bắc Giang");
		combobox1.addItem("Bắc Kạn");
		combobox1.addItem("Bạc Liêu");
		combobox1.addItem("Bắc Ninh");
		combobox1.addItem("Bến Tre");
		combobox1.addItem("Bình Định");
		combobox1.addItem("Bình Dương");
		combobox1.addItem("Bình Phước");
		combobox1.addItem("Bình Thuận");
		combobox1.addItem("Cà Mau");
		combobox1.addItem("Cần Thơ");
		combobox1.addItem("Cao Bằng");
		combobox1.addItem("Đà Nẵng");
		combobox1.addItem("Đắk Lắk");
		combobox1.addItem("Đắk Nông");
		combobox1.addItem("Điện Biên");
		combobox1.addItem("Đồng Nai");
		combobox1.addItem("Đồng Tháp");
		combobox1.addItem("Gia Lai");
		combobox1.addItem("Hà Giang");
		combobox1.addItem("Hà Nam");
		combobox1.addItem("Hà Nội");
		combobox1.addItem("Hà Tĩnh");
		combobox1.addItem("Hải Dương");
		combobox1.addItem("Hải Phòng");
		combobox1.addItem("Hậu Giang");
		combobox1.addItem("Hòa Bình");
		combobox1.addItem("Hưng Yên");
		combobox1.addItem("Khánh Hòa");
		combobox1.addItem("Kiên Giang");
		combobox1.addItem("Kon Tum");
		combobox1.addItem("Lai Châu");
		combobox1.addItem("Lâm Đồng");
		combobox1.addItem("Lạng Sơn");
		combobox1.addItem("Lào Cai");
		combobox1.addItem("Long An");
		combobox1.addItem("Nam Định");
		combobox1.addItem("Nghệ An");
		combobox1.addItem("Ninh Bình");
		combobox1.addItem("Ninh Thuận");
		combobox1.addItem("Phú Thọ");
		combobox1.addItem("Phú Yên");
		combobox1.addItem("Quảng Bình");
		combobox1.addItem("Quảng Nam");
		combobox1.addItem("Quảng Ngãi");
		combobox1.addItem("Quảng Ninh");
		combobox1.addItem("Quảng Trị");
		combobox1.addItem("Sóc Trăng");
		combobox1.addItem("Sơn La");
		combobox1.addItem("Tây Ninh");
		combobox1.addItem("Thái Bình");
		combobox1.addItem("Thái Nguyên");
		combobox1.addItem("Thanh Hóa");
		combobox1.addItem("Thừa Thiên Huế");
		combobox1.addItem("Tiền Giang");
		combobox1.addItem("Thành phố Hồ Chí Minh");
		combobox1.addItem("Trà Vinh");
		combobox1.addItem("Tuyên Quang");
		combobox1.addItem("Vĩnh Long");
		combobox1.addItem("Vĩnh Phúc");
		combobox1.addItem("Yên Bái");
*/
		
		lblPhai = new JLabel("Giới tính:");
		lblPhai.setBounds(10, 250, 120, 14);
		p1.add(lblPhai);
		combobox = new JComboBox();
		combobox.
		setBounds(140, 247, 200, 20);
		p1.add(combobox);
		combobox.addItem("Nam");
		combobox.addItem("Nu");
		
		
		lblsdt = new JLabel("Số điện thoại:");
		lblsdt .setBounds(10, 300, 200, 14);
		p1.add(lblsdt );		
		txtsdt  = new JTextField();
		txtsdt .setBounds(140, 297, 200, 20);
		p1.add(txtsdt );
		txtsdt.setColumns(10);
		
		
		
		
		btnThem = new JButton("Đặt phòng");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0,0,205));
		btnThem.setBounds(40, 400, 120, 40);
		p1.add(btnThem);
		
		btnLammoi = new JButton("Làm mới");
		btnLammoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLammoi.setForeground(new Color(255, 255, 255));
		btnLammoi.setBackground(new Color(0,0,205));
		btnLammoi.setBounds(180,400, 120, 40);
		p1.add(btnLammoi);
		
		btnThoat = new JButton("Trở về");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(0,0,205));
		btnThoat.setBounds(180,470, 120, 40);
		p1.add(btnThoat);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLuu.setForeground(new Color(255, 255, 255));
		btnLuu.setBackground(new Color(0,0,205));
		btnLuu.setBounds(40,470, 120, 40);
		p1.add(btnLuu);
		
		lblTimKiem= new JLabel("Nhập thông tin cần tìm:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(850, 45, 340, 35);
		khung.add(lblTimKiem);
		txtTimKiem= new JTextField();
		txtTimKiem.setBounds(1050,50, 150, 25);
		khung.add(txtTimKiem);
		btnTimKiem = new JButton("Tìm");
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(0,0,205));
		btnTimKiem.setBounds(1210, 51, 70, 25);
		khung.add(btnTimKiem);
		/////////////Xử Lý Tìm Kiếm///////////////////////////////////
		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimKiemKeyRelease(evt);
            }
            
			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)tableKH.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				tableKH.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
        });
		txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimKiemKeyRelease(evt);
            }
            
			private void TimKiemKeyRelease(KeyEvent evt) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = (DefaultTableModel)tableP.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				tableP.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
        });
		//////////////////////////////////////////////////////////////////////////
		
		
		
	
		txtMaKH.setEditable(false);
			
		btnThem.addActionListener(this);
		btnLammoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLuu.addActionListener(this);
		
		tableP.addMouseListener(this);	
		tableKH.addMouseListener(this);
		
		updateKH();
		updatePhongTrong();
		
	}
	public void updateKH() {
		QLKhachHang qlkh=new QLKhachHang();
		tableModel1.getDataVector().removeAllElements();
		ArrayList<KhachHang> dskh = qlkh.layDanhSachKH();
		String temp;
		for (KhachHang kh : dskh) {
			temp = kh.toString();
			tableModel1.addRow(temp.split(";"));
		}
		txtMaKH.setEditable(false);
		txtMaKH.setText(XuLyChung.layMaKH());
	}
	
	public void updatePhongTrong() {
		QLPhong qlp=new QLPhong();
		tableModel3.getDataVector().removeAllElements();
		ArrayList<Phong> dspt = qlp.layDanhPhongTrong();
		String temp;
		for (Phong p : dspt) {
			temp = p.toString();
			tableModel3.addRow(temp.split(";"));
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnThem)){
			LamMoi();
			this .dispose();
			new DatPhong().setVisible(true);
			
		}
		if(o.equals(btnLuu)) {
			ThemKH();
		}
		
		if(o.equals(btnThoat))
		{
			this.dispose();
			new giaodienChinh().setVisible(true);
			
		}	
		
		if(o.equals(btnLammoi)){
			LamMoi();
		}
		
	}
	public void LamMoi() {
		txtMaKH.setText(XuLyChung.layMaKH());
		txtTenKH.setText("");
		txtsdt.setText("");
		txtCmnd.setText("");
		combobox.setSelectedIndex(0);
		//combobox1.setSelectedIndex(0);
		txtTimKiem.setText("");
		txtTimKiem.requestFocus();
		
	}
	public void layFrom() {
		DatPhong dp=new DatPhong();
		
	}
	public void ThemKH() {
		// TODO Auto-generated method stub
		QLKhachHang qlkh=new QLKhachHang();
		
		if (kiemloi()) {
			if (qlkh.themkhachhanh(txtMaKH.getText(),txtTenKH.getText(),txtCmnd.getText(), txtquequan.getText(),combobox.getSelectedItem().toString(),  txtsdt.getText() )) {
				/*for (int i = tableKH.getRowCount() - 1; i >= 0; i--) {
					tableKH.remove(i);
				}*/
				
				JOptionPane.showMessageDialog(this, "Thêm thành công!!!");
				updateKH();;
				LamMoi();
				//restartKH();
				
			} else {
				JOptionPane.showMessageDialog(this, "Trùng mã!!!");
			}
		}

	}
	private boolean kiemloi(){
		String maKH = txtMaKH.getText().trim();
		String tenkh = txtTenKH.getText().trim();
		String Cmnd = txtCmnd.getText().trim();
		
		String sdt = txtsdt.getText().trim();
		if (!(maKH.length() > 0 && XuLyChung.kiemTraMaKhachHang(maKH))) {
			JOptionPane.showMessageDialog(this, "Mã khach hang phải theo mẫu:^KH[0-9]{1,8}$");
			return false;
		}
		if (!(tenkh.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên khach hang không được rỗng!!!");
			return false;
		}
		if (!(XuLyChung.kiemTraCMND(Cmnd))) {
			JOptionPane.showMessageDialog(this, "Số chứng minh thẻ căn cước phải dạng số ");
			return false;
			
		}
		
		if (!(XuLyChung.kiemTraSoDT(sdt))) {
			JOptionPane.showMessageDialog(this, "Số điện thoại theo mẫu:(^0[0-9]{9}$)|(^01[0-9]{11}$)");
			return false;
			
		}
		

		return true;
	
	
		/*if(!(ngayVao.length()>0 && ngayVao.matches("^\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}$"))){

		JOptionPane.showMessageDialog(this, "Nhập ngày Vào theo định dạng 0000-00-00 , Năm-Tháng-Ngày< ngày hiện tại ");
		txtNgayVao.requestFocus();
			return false;
			}
	/*	if(!(maPhong.length()>0 && maPhong.matches("[A-Z]\\d{2,3}"))) {
			JOptionPane.showMessageDialog(this, "Mã Phòng có định dạng [A-Z]\\d{3}");
			txtMaPhong.requestFocus();
			return false;
		}
		if(!(SoDienThoai.length()>0 && SoDienThoai.matches("^0[0-9]{8}$")))
		{
			JOptionPane.showMessageDialog(this, "Số Điện thoại theo mẫu ^0[0-9]{8}$");
			txtSoDienThoai.requestFocus();
			return false;
		}*/
		
	}
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
		int row  = tableKH.getSelectedRow();
		txtMaKH.setText(tableKH.getValueAt(row, 0).toString());
		txtTenKH.setText(tableKH.getValueAt(row, 1).toString());
		txtCmnd.setText(tableKH.getValueAt(row, 2).toString());
		//combobox.setSelectedItem(tableKH.getValueAt(row,3).toString());	
		txtquequan.setText(tableKH.getValueAt(row, 3).toString());
		combobox.setSelectedItem(tableKH.getValueAt(row,4).toString());	
		txtsdt.setText(tableKH.getValueAt(row, 5).toString());
		
		

		
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
