package GUI;

import Entities.*;
import Tools.DocFile;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class DangNhapUI extends JFrame{
	
	
	JTextField txtTaiKhoan,txtMatKhau;
	JButton btnDangNhap,btnThoat;
	public DangNhapUI(String title) {
		super(title);
		addControl();
		addEvents();	
	}

	private void addControl() {
            
		Container conn= getContentPane();
		JPanel pnMain=new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		conn.add(pnMain);
		JPanel pnTitle=new JPanel();
		pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTitle=new JLabel("Đăng nhập hệ thống ");
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle=new Font("arial", Font.BOLD, 18);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);
		
		JPanel pnDangNhap=new JPanel();
		pnDangNhap.setLayout(new BoxLayout(pnDangNhap, BoxLayout.Y_AXIS));
		pnMain.add(pnDangNhap);
		
		JPanel pnTaiKhoan=new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		JLabel lblTaiKhoan=new JLabel("Tài khoản");
		txtTaiKhoan=new JTextField(20);
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		pnDangNhap.add(pnTaiKhoan);
		
		JPanel pnMatKhau=new JPanel();
		pnMatKhau.setLayout(new FlowLayout());
		JLabel lblMatKhau=new JLabel("Mật Khẩu");
		txtMatKhau=new JPasswordField(20);
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(txtMatKhau);
		pnDangNhap.add(pnMatKhau);
		
		JPanel pnButton=new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnDangNhap= new JButton("Đăng nhập");
		btnThoat=new JButton("Thoát");
		pnButton.add(btnDangNhap);
		pnButton.add(btnThoat);
		pnDangNhap.add(pnButton);
                btnThoat.setPreferredSize(btnDangNhap.getPreferredSize());
		TitledBorder border=new TitledBorder(BorderFactory.createLineBorder(Color.red),
				"Thông tin đăng nhập ");
		pnDangNhap.setBorder(border);
	}

	private void addEvents() {
		btnDangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                            try {
                                xuLyDangNhap();
                            } catch (IOException ex) {
                                Logger.getLogger(DangNhapUI.class.getName()).log(Level.WARNING, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(DangNhapUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
                btnThoat.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
		
	}
        public static String username;
	protected void xuLyDangNhap() throws IOException, ClassNotFoundException   {
		
		
		if (txtTaiKhoan.getText().equals("")||txtMatKhau.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền toàn bộ thông tin");
		}else {
                    this.dispose();
                    String vaitro = "",isAdmin = "Admin";
                    ArrayList<TaiKhoan> listTK = DocFile.Doc_TaiKhoan_Tu_File();
                    for(TaiKhoan item : listTK){
                        if(item.getMaTaiKhoan().equals(txtTaiKhoan.getText())&&item.getMatKhau().equals(txtMatKhau.getText())){
                            vaitro = item.getVaiTro();
                            username = item.getMaTaiKhoan();
                            break;
                        }
                    }
                        if(!vaitro.equals("")){
                            
                            if (vaitro.equals(isAdmin)==false) {
                                
                                UserUI nv= new UserUI();
                                nv.setVisible(true);

                            }else{
                                AdminUI ql=new AdminUI();
                                ql.setVisible(true);

                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không tồn tại");
                            txtTaiKhoan.setText("");
                            txtMatKhau.setText("");
                            username = "";
                            DangNhapUI dn = new DangNhapUI("Vui lòng đăng nhập để tiếp tục");
                            dn.showWindow();
                        }
                    
		}
	}

	public void showWindow() {
		this.setSize(350, 250);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
    public static void main(String[] args) {
        DangNhapUI dn = new DangNhapUI("Vui lòng đăng nhập để tiếp tục");
        dn.showWindow();
    }
}
