package GUI;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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

import Dao.QLKhachHang;
import Dao.QLPhong;
import Dao.XuLyChung;
import Entity.KhachHang;
import Entity.Phong;





public class CapNhatP extends JFrame implements ActionListener,MouseListener{
	private JPanel khung;
	
	private JLabel lblTenPhong;
	private JLabel lblMaPhong,lblMaLP;
	private JLabel lblTrangThai;
	private JLabel lblTinhTrang;
	private JLabel lblGhiChu,lblgia,lblTimkiem,lblthongbao;
	

	private JComboBox <String> cbTrangThai,cbgiamgia;
	private JTextField txtMaPhong;
	private JTextField txtTenPhong;
	private JTextField txtMaLP;
	private JTextField txtTinhTrang;
	private JTextField txtGhiChu;
	private JTextField txtTimKiem,txtGia;
	
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JTable table1;
	private DefaultTableModel tableModel1;
	private JTable table3;
	private DefaultTableModel tableModel3;
	
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;
	private JButton btnThoat;
	private JButton btnThem;
	private JButton btnLammoi;
	
	//QuanLiSinhVienDP qlsvdp = new QuanLiSinhVienDP();
	//QuanLiPhongTro qlpt= new QuanLiPhongTro();
	public CapNhatP() {
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
		
		JLabel lblQLSV = new JLabel("TIẾN HÀNH CẬP NHẬT PHÒNG");
		lblQLSV.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQLSV.setForeground(new Color(0,0,0));
		lblQLSV.setBounds(370, 22, 600, 35);
		khung.add(lblQLSV);
		
		JPanel p1 = new JPanel();
		p1.setForeground(new Color(0,255,255));
		p1.setBackground(new Color(143,188,143));
		p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin phòng:",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		p1.setBounds(0, 80, 430, 684);
		khung.add(p1);
		p1.setLayout(null);
		
		String[]headers1 = {"Mã phòng","Tên Phòng","Mã loại phòng","Trạng thái","Tình trạng","Ghi chú"};
		tableModel = new DefaultTableModel(headers1,0);
		JPanel pnTable= new JPanel();
		pnTable.setBounds(450, 90,800,570);
		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBackground(new Color(204, 204, 204));
		pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách Phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
		pnTable.setLayout(new GridLayout(1, 0, 0, 0));
		khung.add(pnTable);
		JScrollPane scroll;
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		pnTable.add( scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		
		//KetNoiDatabase.getInstance().Connect();
		//updateDataBang2();
		//updateDataBang1();
		//updateDataBang3();
		
		
		lblMaPhong= new JLabel("Mã phòng:");
		lblMaPhong .setBounds(10, 50, 120, 14);
		p1.add(lblMaPhong );		
		txtMaPhong  = new JTextField();
		txtMaPhong .setBounds(140, 47, 200, 20);
		p1.add(txtMaPhong );
		txtMaPhong .setColumns(10);
		
		lblTenPhong = new JLabel("Tên phòng:");
		lblTenPhong .setBounds(10, 100, 120, 14);
		p1.add(lblTenPhong);		
		txtTenPhong  = new JTextField();
		txtTenPhong .setBounds(140, 97, 200, 20);
		p1.add(txtTenPhong );
		txtTenPhong.setColumns(10);
		
		lblMaLP = new JLabel("Mã loại phòng:");
		lblMaLP.setBounds(10, 150, 120, 14);
		p1.add(lblMaLP );	
		txtMaLP = new JTextField();
		txtMaLP.setBounds(140, 147, 200, 20);
		p1.add(txtMaLP);
		txtMaLP.setColumns(10);
				
		lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setBounds(10, 210, 120, 14);
		p1.add(lblTrangThai);
		cbTrangThai = new JComboBox();
		cbTrangThai.setBounds(140, 207, 200, 20);
		p1.add(cbTrangThai);
		cbTrangThai.addItem("Trống");
		cbTrangThai.addItem("Đã thuê");
		
		
		
		lblTinhTrang= new JLabel("Tình trạng:");
		lblTinhTrang .setBounds(10, 270, 200, 14);
		p1.add(lblTinhTrang );	
		txtTinhTrang  = new JTextField();
		txtTinhTrang .setBounds(140, 267, 200, 20);		
		p1.add(txtTinhTrang );
		
		lblGhiChu= new JLabel("Ghi chú:");
		lblGhiChu .setBounds(10, 330, 120, 14);
		p1.add(lblGhiChu );		
		txtGhiChu  = new JTextField();
		txtGhiChu .setBounds(140, 327, 200, 20);
		p1.add(txtGhiChu);
		txtGhiChu.setColumns(10);
	
		//p1.add(lblthongbao);
		//lblthongbao.setBounds(70,357,300,20);
		
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0,0,205));
		btnThem.setBounds(20, 400, 100, 40);
		p1.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(0,0,205));
		btnXoa.setBounds(130,400, 100, 40);
		p1.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(0,0,205));
		btnSua.setBounds(240,400, 100, 40);
		p1.add(btnSua);
		
		btnLammoi = new JButton("Làm mới");
		btnLammoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLammoi.setForeground(new Color(255, 255, 255));
		btnLammoi.setBackground(new Color(0,0,205));
		btnLammoi.setBounds(40,470, 120, 40);
		p1.add(btnLammoi);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(0,0,205));
		btnThoat.setBounds(170,470, 120, 40);
		p1.add(btnThoat);
		
		
		lblTimkiem= new JLabel("Nhập thông tin cần tìm:");
		lblTimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimkiem.setBounds(850, 45, 340, 35);
		khung.add(lblTimkiem);
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
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				String search = txtTimKiem.getText();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
        });
		//////////////////////////////////////////////////////////////////////////
		
		
		
	
		txtMaPhong.setEditable(false);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		
		btnThem.addActionListener(this);
		btnLammoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		
		table.addMouseListener(this);	
		
		capNhatTableData();
	}
	public void capNhatTableData() {
		QLPhong qlp=new QLPhong();
		tableModel.getDataVector().removeAllElements();
		ArrayList<Phong> dsp = qlp.layDanhPhong();
		String temp;
		for (Phong p : dsp) {
			temp = p.toString();
			tableModel.addRow(temp.split(";"));
		}
		txtMaPhong.setEditable(false);
		txtMaPhong.setText(XuLyChung.layMaPhong());
		
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
			ThemP();
		}
		if(o.equals(btnXoa)) {
			xoaPhong();
		}
		if(o.equals(btnSua)) {
			xuLySua();
			
		}
		
		if(o.equals(btnThoat))
		{
			new giaodienChinh().setVisible(true);
			this.dispose();
		}	
		if(o.equals(btnLammoi)){
			LamMoi();
		}
		
		
	}
	public void LamMoi() {
		txtTenPhong.setText("");
		txtGhiChu.setText("");
		txtMaLP.setText("");	
		txtTinhTrang.setText("");
		txtMaPhong.setText(XuLyChung.layMaPhong());
	}
	public boolean kiemtraP() {
	// TODO Auto-generated method stub
	String map = txtMaPhong.getText().trim();
	String ten = txtTenPhong.getText().trim();
	String maloai=txtMaLP.getText().trim();
	String trangthai=cbTrangThai.getSelectedItem().toString();
	String ghichu = txtGhiChu.getText().trim();
	if (!(map.length() > 0 && XuLyChung.kiemTraMaPhong(map))) {
		JOptionPane.showMessageDialog(this, "Mã phòng phải có dạng \"^P[0-9]{1,8}$\"");
		return false;
	}
	if (!(ten.length() > 0)) {
		JOptionPane.showMessageDialog(this, "Tên phòng không được rỗng!!!");
		return false;
	}
	
	if (!(maloai.length()>0 && XuLyChung.kiemTraMaLoai(maloai))) {
		JOptionPane.showMessageDialog(this, "Mã loai phòng theo mẫu:(^LP[0-9]{1,8}$)");
		return false;	
	}	

	return true;
	}
	
	public void ThemP() {
		// TODO Auto-generated method stub
		QLPhong qlp=new QLPhong();
		//Phong p =new Phong(txtMaPhong.getText(),txtTenPhong.getText(),txtMaLP.getText(), cbTrangThai.getSelectedItem().toString(),txtTinhTrang.getText(),  txtGhiChu.getText() );
		if (kiemtraP()) {
			if (qlp.themPhong(txtMaPhong.getText(),txtTenPhong.getText(),txtMaLP.getText(), cbTrangThai.getSelectedItem().toString(),txtTinhTrang.getText(),  txtGhiChu.getText())) {
				for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}
				
				JOptionPane.showMessageDialog(this, "Thêm thành công!!!");
				capNhatTableData();
				LamMoi();
				//restartKH();
				
			} else {
				JOptionPane.showMessageDialog(this, "Trùng mã!!!");
			}
		}

	}
	public void xuLySua() {
		QLPhong qlp=new QLPhong();
		//KhachHang a = qlkh.timTheoMa(txtMaKH.getText());
		if (kiemtraP()) {
			//if (a != null) {
				int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn Sửa", "Chú ý!!!",
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					qlp.suaPhong(txtMaPhong.getText(), txtTenPhong.getText(),txtMaLP.getText(),cbTrangThai.getSelectedItem().toString(),txtTinhTrang.getText(),txtGhiChu.getText() );
					for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
						tableModel.removeRow(i);
					}
					JOptionPane.showMessageDialog(this, "Sửa thành công!!!");
					LamMoi();
					capNhatTableData();
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);

				}

			} else {
				JOptionPane.showMessageDialog(this, "Sửa không thành công , sai mã!!!");
			}
		}
	
	public void xoaPhong() {
		// TODO Auto-generated method stub
		QLPhong qlp=new QLPhong();
				int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xóa");
			return;
		} else {
			int hoi = JOptionPane.showConfirmDialog(this, "Ban co chac chan xoa khong?", "Chu y",
					JOptionPane.YES_NO_OPTION);
			if (hoi == JOptionPane.YES_OPTION) {
				 qlp.xoaPhong(table.getValueAt(row, 0).toString());
				tableModel.removeRow(row);
				LamMoi();
				capNhatTableData();
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
			}
		}
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row  = table.getSelectedRow();
		txtMaPhong.setText(table.getValueAt(row, 0).toString());
		txtTenPhong.setText(table.getValueAt(row, 1).toString());
		txtMaLP.setText(table.getValueAt(row, 2).toString());
		cbTrangThai.setSelectedItem(table.getValueAt(row,3).toString());
		txtTinhTrang.setText(table.getValueAt(row, 4).toString());
		txtGhiChu.setText(table.getValueAt(row, 5).toString());
		
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
	
}



