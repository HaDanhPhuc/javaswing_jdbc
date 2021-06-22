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

import GUI.DatPhong.DateLabelFormatter;

public class ThongkeKH extends JFrame implements ActionListener,MouseListener {
		private JPanel khung;
		
		private JLabel lblNgay;	
		private JTable tableKH;
		private DefaultTableModel tableModelKH;
		private JButton btnXem;
		
		private Properties p;
		private UtilDateModel modelNT;
		private JDatePanelImpl pDateNT;
		private JDatePickerImpl DateNT;
		
		 public ThongkeKH() {
			setResizable(false);
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("HỆ THÔNG QUẢN LÝ KHÁCH SẠN");
			setBounds(300, 100, 900, 600);
			khung = new JPanel();
			khung.setBackground(new Color(100,149,237));
			khung.setForeground(new Color(173, 216, 230));
			khung.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(khung);
			khung.setLayout(null);
			
			JLabel lblQLSV = new JLabel("THỐNG KÊ KHÁCH TRONG NGÀY");
			lblQLSV.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblQLSV.setForeground(new Color(0,0,0));
			lblQLSV.setBounds(250, 20, 600, 35);
			khung.add(lblQLSV);
			
			/*JPanel p1 = new JPanel();
			khung.add(p1);
			p1.setLayout(null);*/
			
			String[]headers1 = {"Mã khách hàng","Tên khách hàng","CMND","Quê quán","Gioi Tính","Số điện thoại"};
			tableModelKH = new DefaultTableModel(headers1,0);
			JPanel pnTable= new JPanel();
			pnTable.setBounds(5, 100,880,440);
			pnTable.setBackground(new Color(204, 204, 204));
			pnTable.setBackground(new Color(204, 204, 204));
			pnTable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách Khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 51)));
			pnTable.setLayout(new GridLayout(1, 0, 0, 0));
			khung.add(pnTable);
			JScrollPane scroll;
			tableKH = new JTable(tableModelKH);
			tableKH.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			pnTable.add( scroll = new JScrollPane(tableKH, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
			
			DatPhong dp =new DatPhong();
			lblNgay= new JLabel("Chọn ngày:");
			lblNgay.setBounds(300, 60, 100, 35);
			khung.add(lblNgay );
			p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			modelNT = new UtilDateModel();
			pDateNT = new JDatePanelImpl(modelNT, p);
			DateNT = new JDatePickerImpl(pDateNT,dp.new DateLabelFormatter() );
			DateNT.setBounds(400,67, 200, 25);
			DateNT.getJFormattedTextField().setBorder(null);
			khung.add(DateNT);
			tableKH.addMouseListener(this);
			
			btnXem = new JButton("Xem");
			btnXem.setForeground(new Color(255, 255, 255));
			btnXem.setBackground(new Color(0,0,205));
			btnXem.setBounds(630, 67, 70, 25);
			khung.add(btnXem);
			
			btnXem.addActionListener(this);

}
		

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object o=e.getSource();
			if(o.equals(btnXem)){
				//ThemKH();
				
			}
		}
		
		
	}

