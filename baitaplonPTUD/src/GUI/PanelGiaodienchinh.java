package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

//import GUI.DialogDangNhap;
/*import Model.KhachHangVip;
import Model.LinhKien;
import Model.NhanVienGioi;
import ketNoiVoiSQl.QuanLyChiTietHoaDon;
import ketNoiVoiSQl.QuanLyLinhKien;
import xuLyChung.XuLyChung;
*/
public class PanelGiaodienchinh extends JPanel implements ActionListener {

	private JPanel pNorth, pCenter, picon;
	private JSplitPane splitPane;
	private JLabel lblTieuDe;
	private JButton btnDatHang, btnThoat;

	public PanelGiaodienchinh() {
		setLayout(new BorderLayout());
		
		buildUI();
		//setSize(1300, 800);
		///setResizable(false);
		//themActionListener();
	}

	public void buildUI() {
		taoNorthPanel();
		taoCenterPane();

		add(pNorth, BorderLayout.NORTH);
		add(pCenter,BorderLayout.CENTER);
		
	}

	private void taoCenterPane() {
		
		pCenter = new JPanel();
		try {
			BufferedImage image = ImageIO.read(new File("hinhanh/5sao.jpg"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(1280, 780, image.SCALE_SMOOTH));
			JLabel backGroud = new JLabel(icon);
			pCenter.add(backGroud);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void taoNorthPanel() {
		pNorth = new JPanel();
		pNorth.setBackground(Color.cyan);
		pNorth.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		taoTieuDeLabel();

		pNorth.add(lblTieuDe);
	}

	public void taoTieuDeLabel() {
		lblTieuDe = new JLabel("QUẢN LÝ KHÁCH SẠN", JLabel.CENTER);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 38));
		lblTieuDe.setForeground(Color.blue);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}