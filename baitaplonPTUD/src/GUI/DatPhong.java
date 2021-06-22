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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
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
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



import Dao.QLDatPhong;
import Dao.QLKhachHang;
import Dao.QLPhong;
import Dao.XuLyChung;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.Phong;
import Entity.ThuePhong;





	public class DatPhong extends JFrame implements ActionListener,MouseListener{
	
	
		private JPanel khung;
		private JLabel lblMathue;
		private JLabel lblMaKH;
		private JLabel lblTenKH;
		private JLabel lblMaP;
		private JLabel lblLoaiP;
		private JLabel lblGia;
		private JLabel lblTratruoc;
		private JLabel lblTimKiem;
		private JLabel lblNgaythue;
		private JLabel lblLuc;
		private JLabel lblGio;
		private JLabel lblPhut,lblPhutra;
		
		private Properties p;
		private UtilDateModel modelNT;
		private JDatePanelImpl pDateNT;
		private JDatePickerImpl DateNT;
		
		private UtilDateModel modelGio;
		private JDatePanelImpl pDateGio;
		private JDatePickerImpl DateGio;
		//private UtilDateModel modelSX;
		//private JDatePanelImpl pDateSX;
		//private JDatePickerImpl dateSX;
	
		
		//private JDatePanelImpl pDateHH;
		//private JDatePickerImpl dateHH;
		
		private JComboBox <String> combobox,combobox1,cbLoaiP;
		private JTextField txtMathue;
		private JTextField txtTenKH;
		private JTextField txtMaKH;
		private JTextField txtMaP;
		private JTextField txtTongTien;
		private JTextField txtLoaiP;
		private JTextField txtTimKiem;
		private JTextField txtNgayRa;
		private JTextField txtGia;
		private JTextField txtNgayVao;
		
		private JTable table;
		private DefaultTableModel tableModel;
		private JTable table1;
		private DefaultTableModel tableModel1;
		private JTable table3;
		private DefaultTableModel tableModel3;
		
		private JButton btnThem;
		private JButton btnXoaTrong;
		private JButton btnTimKiem;
		private JButton btnThoat;
		private JButton btnLuu;
		private JButton btnLammoi;
		private JComboBox<String> cbGiodat,cbPhutdat, cbngaydatyy, cbngaygiaodd, cbngaygiaomm, cbngaygiaoyy, cbngaychuyendd,
		cbngaychuyenmm, cbngaychuyenyy;

		//QuanLiSinhVienDP qlsvdp = new QuanLiSinhVienDP();
		//QuanLiPhongTro qlpt= new QuanLiPhongTro();
		public DatPhong() {
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
			
			JLabel lblQLSV = new JLabel("TIẾN HÀNH ĐẶT PHÒNG ");
			lblQLSV.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblQLSV.setForeground(new Color(0,0,0));
			lblQLSV.setBounds(370, 22, 600, 35);
			khung.add(lblQLSV);
			
			JPanel p1 = new JPanel();
			p1.setForeground(new Color(0,255,255));
			p1.setBackground(new Color(143,188,143));
			p1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin thuê phòng:",TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			p1.setBounds(0, 80, 430, 684);
			khung.add(p1);
			p1.setLayout(null);
			
			String[]headers1 = {"Mã thuê ","Mã phòng","Mã khách hàng","Tên khách hàng","Loại phòng","Giá","Ngày vào"};
			tableModel = new DefaultTableModel(headers1,0);
			JPanel pnTable= new JPanel();
			pnTable.setBounds(440, 435,840,220);
			pnTable.setBackground(new Color(204, 204, 204));
			pnTable.setBackground(new Color(204, 204, 204));
			pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng đã nhận Phòng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
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
			}));
			scroll.setBackground(new Color(102, 0, 102));
			table.setForeground(new Color(0, 0, 0));
			table.setBackground(new Color(204, 204, 204));
			table.setRowHeight(25);
			table.setAutoCreateRowSorter(true);
			scroll.setViewportView(table);
			*/
			String[]headers2 = {"Mã khách hàng","Tên khách hàng","Số CMND/Thẻ căn cước","Quê quán","Giới tính","Số điện thoại"};
			tableModel1 = new DefaultTableModel(headers2,0);
			JPanel pnTable1= new JPanel();
			pnTable1.setBounds(440,260 ,840,170);
			pnTable1.setBackground(new Color(204, 204, 204));
			pnTable1.setBackground(new Color(204, 204, 204));
			pnTable1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			pnTable1.setLayout(new GridLayout(1, 0, 0, 0));
			khung.add(pnTable1);
			JScrollPane scroll1;
			table1 = new JTable(tableModel1);
			table1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			pnTable1.add( scroll1 = new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
			/*pnTable1.add( scroll1 = new JScrollPane(table1 = new JTable(tableModel1) {
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
			}));
			scroll1.setBackground(new Color(102, 0, 102));
			table1.setForeground(new Color(0, 0, 0));
			table1.setBackground(new Color(204, 204, 204));
			table1.setRowHeight(25);
			table1.setAutoCreateRowSorter(true);
			scroll1.setViewportView(table1);
			*/
			String[]headers3 = {"Mã phòng","Tên phòng","Mã loại phòng","Trạng thái","Tình trạng","Ghi chú"};
			tableModel3 = new DefaultTableModel(headers3,0);
			JPanel pnTable2= new JPanel();
			pnTable2.setBounds(440, 85,840,170);
			pnTable2.setBackground(new Color(204, 204, 204));
			pnTable2.setBackground(new Color(204, 204, 204));
			pnTable2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách phòng trống", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			pnTable2.setLayout(new GridLayout(1, 0, 0, 0));
			khung.add(pnTable2);
			JScrollPane scroll3;
			table3 = new JTable(tableModel3);
			table3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			pnTable2.add( scroll3 = new JScrollPane(table3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
			
			
			lblMathue= new JLabel("Mã thuê phòng:");
			lblMathue .setBounds(10, 50, 120, 14);
			p1.add(lblMathue );		
			txtMathue  = new JTextField();
			txtMathue .setBounds(140, 47, 200, 20);
			p1.add(txtMathue );
			txtMathue .setColumns(10);
			
			lblMaP = new JLabel("Mã phòng:");
			lblMaP.setBounds(10, 100, 120, 14);
			p1.add(lblMaP);		
			txtMaP = new JTextField();
			txtMaP.setBounds(140, 97, 200, 20);
			p1.add(txtMaP );
			txtMaP .setColumns(10);
			
			lblMaKH = new JLabel("Mã khách hàng:");
			lblMaKH .setBounds(10, 150, 120, 14);
			p1.add(lblMaKH );		
			txtMaKH = new JTextField();
			txtMaKH.setBounds(140, 147, 200, 20);
			p1.add(txtMaKH);
			txtMaKH.setColumns(10);
			
			lblTenKH = new JLabel("Tên khách hàng:");
			lblTenKH.setBounds(10, 200, 120, 14);
			p1.add(lblTenKH );	
			txtTenKH = new JTextField();
			txtTenKH.setBounds(140, 197, 200, 20);
			p1.add(txtTenKH);
			txtTenKH.setColumns(10);
			
			lblLoaiP = new JLabel("Loại phòng:");
			lblLoaiP.setBounds(10, 250, 120, 14);
			p1.add(lblLoaiP );	
			txtLoaiP = new JTextField();
			txtLoaiP.setBounds(140, 247, 200, 20);
			p1.add(txtLoaiP);
			txtLoaiP.setColumns(10);
			//cbLoaiP.addItem("-  -");
			//cbLoaiP.addItem("Đôi");
			//cbLoaiP.addItem("Đơn");
			
			lblGia = new JLabel("Giá:");
			lblGia.setBounds(10, 300, 120, 14);
			p1.add(lblGia);
			txtGia= new JTextField();
			txtGia.setBounds(140, 297, 200, 20);
			p1.add(txtGia);
			txtGia.setColumns(10);
			
			
			lblNgaythue= new JLabel("Ngày thuê:");
			lblNgaythue.setBounds(10, 350, 200, 14);
			p1.add(lblNgaythue );
			p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			modelNT = new UtilDateModel();
			pDateNT = new JDatePanelImpl(modelNT, p);
			DateNT = new JDatePickerImpl(pDateNT, new DateLabelFormatter() );
			DateNT.setBounds(140, 347, 200, 20);
			DateNT.getJFormattedTextField().setBorder(null);
			p1.add(DateNT);
			//modelHH = new UtilDateModel();
			//pDateHH = new JDatePanelImpl(modelHH, p);
			//dateHH = new JDatePickerImpl(pDateHH, new DateLabelFormatter());
			/*lblLuc = new JLabel("Lúc:");
			lblLuc.setBounds(50, 400, 50, 20);
			p1.add(lblLuc);	
			p = new Properties();
			p.put("text.hours", "Hours");
			p.put("text.minute", "Minute");
			//p.put("text.year", "Year");
			modelGio = new UtilDateModel();
			pDateGio = new JDatePanelImpl(modelGio, p);
			DateGio = new JDatePickerImpl(pDateGio, new DateTime() );
			DateGio.setBounds(140, 397, 200, 20);
			DateGio.getJFormattedTextField().setBorder(null);
			p1.add(DateGio);
			*/
	
			
			btnThem = new JButton("Nhận phòng");
			btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			btnThem.setForeground(new Color(255, 255, 255));
			btnThem.setBackground(new Color(0,0,205));
			btnThem.setBounds(50, 470, 140, 40);
			p1.add(btnThem);
			
			btnXoaTrong = new JButton("Xóa trống");
			btnXoaTrong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnXoaTrong.setForeground(new Color(255, 255, 255));
			btnXoaTrong.setBackground(new Color(0,0,205));
			btnXoaTrong.setBounds(210,470, 140, 40);
			p1.add(btnXoaTrong);
			
			btnThoat = new JButton("Trở về");
			btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnThoat.setForeground(new Color(255, 255, 255));
			btnThoat.setBackground(new Color(0,0,205));
			btnThoat.setBounds(210,520, 140, 40);
			p1.add(btnThoat);
			btnLuu = new JButton("Lưu");
			btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			btnLuu.setForeground(new Color(255, 255, 255));
			btnLuu.setBackground(new Color(0,0,205));
			btnLuu.setBounds(50,520, 140, 40);
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
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					String search = txtTimKiem.getText();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
					table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(search));
				}
	        });
			//////////////////////////////////////////////////////////////////////////
			
			
			
		
			txtMathue.setEditable(false);
			txtTenKH.setEditable(false);
			txtMaKH.setEditable(false);
			//txtQueQuan.setEditable(false);
			//txtSoDienThoai.setEditable(false);
			//combobox.setEnabled(false);
			//txtGia.setEditable(false);
			//txtMaPhong.setEditable(false);		
			btnThem.addActionListener(this);
			btnXoaTrong.addActionListener(this);
			btnTimKiem.addActionListener(this);
			btnThoat.addActionListener(this);
			btnLuu.addActionListener(this);
			
			table.addMouseListener(this);
			table1.addMouseListener(this);
			table3.addMouseListener(this);
			
			updateKH();
			updateTP();
			updatePhongTrong();

		}
		
		public class DateLabelFormatter extends AbstractFormatter {

			private String datePattern = "dd-MM-yyyy";
			private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

			@Override
			public Object stringToValue(String text) throws ParseException {
				return dateFormatter.parseObject(text);
			}

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null) {
					Calendar cal = (Calendar) value;
					return dateFormatter.format(cal.getTime());
				}

				return "";
			}

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
			txtMathue.setEditable(false);
			txtMathue.setText(XuLyChung.layMaTP());
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
				XoaRong();
				capNhatTrangThai();
				
				
			}
			if(o.equals(btnXoaTrong))
			{
				XoaRong();
			}
			
			if(o.equals(btnThoat))
			{
				this.dispose();
				new ThongTinKH().setVisible(true);
				
			}	
			if(o.equals(btnLuu))
			{
				LuuThueP();
				
			}
			if(o.equals(btnLammoi)){
				
			}
			
		}
		public void XoaRong(){
			txtMathue.setText(XuLyChung.layMaTP());
			txtTenKH.setText("");
			txtMaP.setText("");
			txtMaKH.setText("");
			txtLoaiP.setText("");
			txtGia.setText("");		
			//txtNgayVao.setText("");
			//txtMaPhong.setText("");
		}
		public void capNhatTrangThai() {
			String map=txtMaP.getText().trim();
			QLPhong qlp=new QLPhong();
			QLDatPhong qldp=new QLDatPhong();
			if(qldp.updateTrangThai(map)) {
				tableModel3.getDataVector().removeAllElements();
				ArrayList<Phong> dspt = qlp.layDanhPhongTrong();
				String temp;
				for (Phong p : dspt) {
					temp = p.toString();
					tableModel3.addRow(temp.split(";"));
				}
			}
			
		}
		public void LuuThueP() {
			// TODO Auto-generated method stub
			double gia=Double.parseDouble( txtGia.getText().trim());
			String map=txtMaP.getText().trim();
			QLDatPhong qldp=new QLDatPhong();
			java.util.Date ngaythue = (java.util.Date)DateNT.getModel().getValue();
			Date ngay=new Date(ngaythue.getYear(), ngaythue.getMonth(), ngaythue.getDay());
			boolean res=qldp.themThueP(txtMathue.getText().trim(), map,txtMaKH.getText(),txtTenKH.getText().trim(),txtLoaiP.getText(),gia,ngay);
			if (kiemloi()) {
				if (res) {
					for (int i = table.getRowCount() - 1; i >= 0; i--) {
						table.remove(i);
					}
					
					
					updateTP();
					JOptionPane.showMessageDialog(this, "Lưu  thành công!!!");
					
					//restartKH();
					
				} else {
					JOptionPane.showMessageDialog(this, "Lưu không không thành công!!!");
				}
			}

		}
		public String changeDate(Date date) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			return formatter.format(date);
		}
		
		private boolean kiemloi(){
			//String map = txtMaP.getText().trim();
			//String tenkh = txtTenKH.getText().trim();
			//String mthue = txtMathue.getText().trim();
			//String gia = txtGia.getText().trim();
			//String makh = txtMaKH.getText().trim();
			//String lp=txtLoaiP.getText().trim();
			java.util.Date ngaythue = (java.util.Date)DateNT.getModel().getValue();
			LocalDate date = LocalDate.now();
			if(date.compareTo(LocalDate.of(ngaythue.getYear(), ngaythue.getMonth(), ngaythue.getDate()))<0) {
				JOptionPane.showMessageDialog(this," Ngày thuê phải là lớn hơn hoặc bằng ngày hiện tại");
				return false;
			}
			
			return true;
		}
	
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row  = table1.getSelectedRow();
			int row2  = table3.getSelectedRow();

			txtMaKH.setText(table1.getValueAt(row, 0).toString());
			txtTenKH.setText(table1.getValueAt(row, 1).toString());
					
			
			
			row2= table3.getSelectedRow();
			txtMaP.setText(table3.getValueAt(row2, 0).toString());
			txtLoaiP.setText(table3.getValueAt(row, 2).toString());
	
			

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


