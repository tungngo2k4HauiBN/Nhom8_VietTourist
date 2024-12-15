/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.*;
import DAL.*;
import Entities.*;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class AdminUI extends javax.swing.JFrame {

    DefaultTableModel model;

    public AdminUI() {
        initComponents();

        show_NhanVien();
        show_KhachSan();
        show_Xe();
        show_TaiKhoanAdmin();
        show_TaiKhoanUser();
        show_Tour();
        show_Ve();
        show_Ve_Da_Dat();
    }
    //show table
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

    public void show_NhanVien() {
        model = (DefaultTableModel) tbNhanVien.getModel();
        tbNhanVien.setModel(NhanVienBLL.show());
        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbNhanVien.setDefaultRenderer(Object.class, renderer);
    }

    public void show_KhachSan() {
        model = (DefaultTableModel) tbKhachSan.getModel();
        tbKhachSan.setModel(KhachSanBLL.show());
        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbKhachSan.setDefaultRenderer(Object.class, renderer);
    }

    public void show_Xe() {
        model = (DefaultTableModel) tbXe.getModel();
        tbXe.setModel(XeBLL.show());
        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbXe.setDefaultRenderer(Object.class, renderer);
    }

    public void show_TaiKhoanAdmin() {
        tbTaiKhoan1.setModel(TaiKhoanBLL.show1());
        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbTaiKhoan1.setDefaultRenderer(Object.class, renderer);
    }

    public void show_TaiKhoanUser() {
        tbTaiKhoan2.setModel(TaiKhoanBLL.show2());
        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbTaiKhoan2.setDefaultRenderer(Object.class, renderer);
    }

    public void show_Tour() {
        model = (DefaultTableModel) tbTour.getModel();
        tbTour.setModel(TourBLL.show());

        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbTour.setDefaultRenderer(Object.class, renderer);

        cbMaXe.setModel(XeBLL.cbb_show());
        cbMaKS.setModel(KhachSanBLL.cbb_show());
    }

    public void show_Ve() {
        model = (DefaultTableModel) tbVe.getModel();
        tbVe.setModel(VeBLL.show());

        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbVe.setDefaultRenderer(Object.class, renderer);

        cbUser.setModel(TaiKhoanBLL.cbb_show());
        cbMaTour.setModel(TourBLL.cbb_show());
        cbMaNV.setModel(NhanVienBLL.cbb_show());
    }

    public void show_Ve_Da_Dat() {
        model = (DefaultTableModel) tbVeDaDat.getModel();
        tbVeDaDat.setModel(VeBLL.show());

        renderer.setHorizontalAlignment(JLabel.CENTER);
        tbVeDaDat.setDefaultRenderer(Object.class, renderer);

        sum.setText(String.valueOf(VeBLL.TongSoLuong()));
        totalRevenue.setText(String.valueOf(VeBLL.TongDoanhThu()));
    }

    //Select row
    public void show_Row_tbNhanVien() {
        int i = tbNhanVien.getSelectedRow();
        NhanVien s = NhanVienDAL.show().get(i);

        txtMaNV.setText(s.getMaNV());
        txtTenNV.setText(s.getTenNV());
        txtSDT_NV.setText(s.getSoDT());
        txtDiaChi.setText(s.getDiaChi());
        txtNgaySinh_NV.setText(s.getNgaySinh());
        txtGioiTinh_NV.setText(s.getGioiTinh());
        txtEmail_NV.setText(s.getEmail());
    }

    public void show_Row_tbKhachSan() {
        int i = tbKhachSan.getSelectedRow();
        KhachSan s = KhachSanDAL.show().get(i);

        txtMaKS.setText(s.getMaKS());
        txtTenKS.setText(s.getTenKS());
        txtDiaDiem_KS.setText(s.getDiaDiem());
    }

    public void show_Row_tbXe() {
        int i = tbXe.getSelectedRow();
        Xe s = XeDAL.show().get(i);

        txtMaXe.setText(s.getMaXe());
        txtBienSo.setText(s.getBienSo());
        txtLoaiXe.setText(s.getLoaiXe());
    }

    public void show_Row_tbTaiKhoanAdmin() {
        int i = tbTaiKhoan1.getSelectedRow();
        TaiKhoan s = TaiKhoanDAL.showAdmin().get(i);

        usernameAdmin.setText(s.getMaTaiKhoan());
        passwordAdmin.setText(s.getMatKhau());
    }

    public void show_Row_tbTaiKhoanUser() {
        int i = tbTaiKhoan2.getSelectedRow();
        TaiKhoan s = TaiKhoanDAL.showUser().get(i);

        usernameKH.setText(s.getMaTaiKhoan());
        passwordKH.setText(s.getMatKhau());
    }

    public void show_Row_tbTour() {
        int i = tbTour.getSelectedRow();
        Tour s = TourDAL.show().get(i);

        txtMaTour.setText((String) (tbTour.getValueAt(i, 0)));
        txtTenTour.setText((String) (tbTour.getValueAt(i, 1)));
        txtThoiGian_Tour.setText((String) (tbTour.getValueAt(i, 2)));
        txtDiaDiem_Tour.setText((String) (tbTour.getValueAt(i, 3)));
        cbMaXe.setSelectedItem((String) (tbTour.getValueAt(i, 4)));
        cbMaKS.setSelectedItem((String) (tbTour.getValueAt(i, 5)));
    }

    public void show_Row_tbVe() {
        int i = tbVe.getSelectedRow();
        Ve s = VeDAL.show().get(i);

        txtMaVe.setText((String) (tbVe.getValueAt(i, 0)));
        cbUser.setSelectedItem((String) (tbVe.getValueAt(i, 1)));
        cbMaTour.setSelectedItem((String) (tbVe.getValueAt(i, 2)));
        cbMaNV.setSelectedItem((String) (tbVe.getValueAt(i, 3)));
        txtThoiGian_Ve.setText((String) (tbVe.getValueAt(i, 4)));
        txtGiaVe.setText(String.valueOf(tbVe.getValueAt(i, 5)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AdminTabPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnXoaNV = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnSuaNV = new javax.swing.JButton();
        btnThemNV = new javax.swing.JButton();
        txtSDT_NV = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtNgaySinh_NV = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        jLabel64 = new javax.swing.JLabel();
        txtEmail_NV = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtGioiTinh_NV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtMaTour = new javax.swing.JTextField();
        txtTenTour = new javax.swing.JTextField();
        txtThoiGian_Tour = new javax.swing.JTextField();
        txtDiaDiem_Tour = new javax.swing.JTextField();
        btnThemTour = new javax.swing.JButton();
        btnSuaTour = new javax.swing.JButton();
        btnXoaTour = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbTour = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        cbMaXe = new javax.swing.JComboBox<>();
        cbMaKS = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtLoaiXe = new javax.swing.JTextField();
        txtBienSo = new javax.swing.JTextField();
        btnThemXe = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        txtSuaXe = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        txtXoaXe = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbXe = new javax.swing.JTable();
        txtMaXe = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtDiaDiem_KS = new javax.swing.JTextField();
        txtTenKS = new javax.swing.JTextField();
        btnThemKS = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        btnSuaKS = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        btnXoaKS = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbKhachSan = new javax.swing.JTable();
        txtMaKS = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbTaiKhoan2 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        usernameKH = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        delTkUser = new javax.swing.JButton();
        btnThemtkUser = new javax.swing.JButton();
        cboxShowPass = new javax.swing.JCheckBox();
        passwordKH = new javax.swing.JPasswordField();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbTaiKhoan1 = new javax.swing.JTable();
        btnThemTK = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        usernameAdmin = new javax.swing.JTextPane();
        jLabel21 = new javax.swing.JLabel();
        btnHuyTK = new javax.swing.JButton();
        btnSuaTK = new javax.swing.JButton();
        passwordAdmin = new javax.swing.JPasswordField();
        confirmPass = new javax.swing.JPasswordField();
        jLabel33 = new javax.swing.JLabel();
        cboxShowPass1 = new javax.swing.JCheckBox();
        cboxShowPass2 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txtGiaVe = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        btnSuaVe = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        btnXoaVe = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbVe = new javax.swing.JTable();
        txtMaVe = new javax.swing.JTextField();
        txtThoiGian_Ve = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        btnThemVe = new javax.swing.JButton();
        cbUser = new javax.swing.JComboBox<>();
        cbMaTour = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        cbMaNV = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbVeDaDat = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        sum = new javax.swing.JTextField();
        totalRevenue = new javax.swing.JTextField();
        btnTaiLai = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ DU LỊCH");

        AdminTabPane.setBackground(new java.awt.Color(255, 255, 153));

        jLabel44.setText("Địa chỉ");

        jLabel45.setText("Email");

        jLabel49.setText("Tên nhân viên");

        jLabel50.setText("Số điện thoại");

        btnXoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconDelete.jpg"))); // NOI18N
        btnXoaNV.setText("Xóa");
        btnXoaNV.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã nhân viên");

        btnSuaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconUpdate.jpg"))); // NOI18N
        btnSuaNV.setText("Sửa");
        btnSuaNV.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconAdd.jpg"))); // NOI18N
        btnThemNV.setText("Thêm");
        btnThemNV.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Địa chỉ", "Ngày sinh", "Giới tính", "Email"
            }
        ));
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbNhanVien);

        jLabel64.setText("Ngày sinh");

        jLabel67.setText("Giới tính");

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGioiTinh_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgaySinh_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDT_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNV)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNV)
                    .addComponent(txtSDT_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNV)
                    .addComponent(txtNgaySinh_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiTinh_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        AdminTabPane.addTab("Quản lý nhân viên", jPanel2);

        jLabel2.setText("Mã tour");

        jLabel37.setText("Thời gian");

        jLabel38.setText("Tên tour");

        jLabel39.setText("Địa điểm");

        txtDiaDiem_Tour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaDiem_TourActionPerformed(evt);
            }
        });

        btnThemTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconAdd.jpg"))); // NOI18N
        btnThemTour.setText("Thêm");
        btnThemTour.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnThemTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTourActionPerformed(evt);
            }
        });

        btnSuaTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconUpdate.jpg"))); // NOI18N
        btnSuaTour.setText("Sửa");
        btnSuaTour.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSuaTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTourActionPerformed(evt);
            }
        });

        btnXoaTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconDelete.jpg"))); // NOI18N
        btnXoaTour.setText("Xóa");
        btnXoaTour.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnXoaTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTourActionPerformed(evt);
            }
        });

        tbTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã tour", "Tên tour", "Thời gian", "Địa điểm", "Mã xe", "Mã khách sạn"
            }
        ));
        tbTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTourMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbTour);

        jLabel60.setText("Mã khách sạn");

        jLabel66.setText("Mã xe");

        cbMaXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMaKS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaKSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtThoiGian_Tour, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnThemTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSuaTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoaTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaKS, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaDiem_Tour, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemTour))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaTour)
                    .addComponent(txtThoiGian_Tour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaDiem_Tour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaTour)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaXe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaKS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        AdminTabPane.addTab("Quản lý tour", jPanel1);

        btnThemXe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconAdd.jpg"))); // NOI18N
        btnThemXe.setText("Thêm");
        btnThemXe.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnThemXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXeActionPerformed(evt);
            }
        });

        jLabel41.setText("Mã xe");

        txtSuaXe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconUpdate.jpg"))); // NOI18N
        txtSuaXe.setText("Sửa");
        txtSuaXe.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtSuaXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuaXeActionPerformed(evt);
            }
        });

        jLabel42.setText("Loại xe");

        txtXoaXe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconDelete.jpg"))); // NOI18N
        txtXoaXe.setText("Xóa");
        txtXoaXe.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtXoaXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXoaXeActionPerformed(evt);
            }
        });

        jLabel43.setText("Biển số");

        tbXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã xe", "Biển số", "Loại xe"
            }
        ));
        tbXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbXeMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbXe);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSuaXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtXoaXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemXe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBienSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuaXe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXoaXe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 157, Short.MAX_VALUE))
        );

        AdminTabPane.addTab("Quản lý xe", jPanel3);

        btnThemKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconAdd.jpg"))); // NOI18N
        btnThemKS.setText("Thêm");
        btnThemKS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnThemKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKSActionPerformed(evt);
            }
        });

        jLabel46.setText("Mã khách sạn");

        btnSuaKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconUpdate.jpg"))); // NOI18N
        btnSuaKS.setText("Sửa");
        btnSuaKS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSuaKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKSActionPerformed(evt);
            }
        });

        jLabel47.setText("Địa điểm");

        btnXoaKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconDelete.jpg"))); // NOI18N
        btnXoaKS.setText("Xóa");
        btnXoaKS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnXoaKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKSActionPerformed(evt);
            }
        });

        jLabel48.setText("Tên khách sạn");

        tbKhachSan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã khách sạn", "Tên khách sạn", "Địa điểm"
            }
        ));
        tbKhachSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachSanMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbKhachSan);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenKS, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaKS, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaDiem_KS, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemKS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaKS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaKS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaKS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaDiem_KS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 157, Short.MAX_VALUE))
        );

        AdminTabPane.addTab("Quản lý khách sạn", jPanel4);

        tbTaiKhoan2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên đăng nhập", "Mật khẩu"
            }
        ));
        tbTaiKhoan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTaiKhoan2MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tbTaiKhoan2);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Tài khoản khách hàng");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Tên đăng nhập:");

        usernameKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("Mật khẩu:");

        reset.setBackground(new java.awt.Color(153, 153, 255));
        reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 0, 0));
        reset.setText("Hủy bỏ");
        reset.setBorder(new javax.swing.border.MatteBorder(null));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        delTkUser.setBackground(new java.awt.Color(153, 153, 255));
        delTkUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delTkUser.setForeground(new java.awt.Color(255, 0, 0));
        delTkUser.setText("Xóa");
        delTkUser.setBorder(new javax.swing.border.MatteBorder(null));
        delTkUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delTkUserActionPerformed(evt);
            }
        });

        btnThemtkUser.setBackground(new java.awt.Color(153, 153, 255));
        btnThemtkUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemtkUser.setForeground(new java.awt.Color(255, 0, 0));
        btnThemtkUser.setText("Thêm");
        btnThemtkUser.setBorder(new javax.swing.border.MatteBorder(null));
        btnThemtkUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemtkUserActionPerformed(evt);
            }
        });

        cboxShowPass.setText("Hiện mật khẩu");
        cboxShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxShowPassActionPerformed(evt);
            }
        });

        passwordKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(delTkUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboxShowPass)
                            .addComponent(usernameKH, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(passwordKH))
                        .addContainerGap(87, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnThemtkUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(usernameKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(passwordKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboxShowPass)
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delTkUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemtkUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách hàng", jPanel15);

        tbTaiKhoan1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên đăng nhập", "Mật khẩu"
            }
        ));
        tbTaiKhoan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTaiKhoan1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbTaiKhoan1);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 162));
        jLabel19.setText("Tên tài khoản mới: ");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 162));
        jLabel20.setText("Mật khẩu mới:");

        jScrollPane13.setViewportView(usernameAdmin);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 162));
        jLabel21.setText("Xác nhận mật khẩu mới:");

        btnHuyTK.setBackground(new java.awt.Color(153, 153, 255));
        btnHuyTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuyTK.setForeground(new java.awt.Color(255, 0, 0));
        btnHuyTK.setText("Hủy");
        btnHuyTK.setBorder(new javax.swing.border.MatteBorder(null));
        btnHuyTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTKActionPerformed(evt);
            }
        });

        btnSuaTK.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaTK.setForeground(new java.awt.Color(255, 0, 0));
        btnSuaTK.setText("Lưu");
        btnSuaTK.setBorder(new javax.swing.border.MatteBorder(null));
        btnSuaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTKActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 51, 51));
        jLabel33.setText("Thay đổi thông tin tài khoản");

        cboxShowPass1.setText("Hiện mật khẩu");
        cboxShowPass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxShowPass1ActionPerformed(evt);
            }
        });

        cboxShowPass2.setText("Hiện xác nhận mật khẩu");
        cboxShowPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxShowPass2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnThemTKLayout = new javax.swing.GroupLayout(btnThemTK);
        btnThemTK.setLayout(btnThemTKLayout);
        btnThemTKLayout.setHorizontalGroup(
            btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemTKLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemTKLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxShowPass1)
                    .addGroup(btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane13)
                        .addComponent(passwordAdmin)
                        .addComponent(confirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .addComponent(cboxShowPass2))
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemTKLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnSuaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuyTK, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        btnThemTKLayout.setVerticalGroup(
            btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemTKLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(passwordAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cboxShowPass1)
                .addGap(29, 29, 29)
                .addGroup(btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(confirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cboxShowPass2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(btnThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyTK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(btnThemTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý", jPanel17);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AdminTabPane.addTab("Quản lý tài khoản", jPanel5);

        jLabel56.setText("Mã vé");

        txtGiaVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaVeActionPerformed(evt);
            }
        });

        jLabel57.setText("Mã tour");

        btnSuaVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconUpdate.jpg"))); // NOI18N
        btnSuaVe.setText("Sửa");
        btnSuaVe.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSuaVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVeActionPerformed(evt);
            }
        });

        jLabel58.setText("Người đặt");

        btnXoaVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconDelete.jpg"))); // NOI18N
        btnXoaVe.setText("Xóa");
        btnXoaVe.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnXoaVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVeActionPerformed(evt);
            }
        });

        tbVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã vé", "Người đặt", "Mã tour", "Mã nhân viên", "Thời gian", "Giá vé"
            }
        ));
        tbVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbVe);

        jLabel63.setText("Thời gian");

        jLabel65.setText("Giá vé");

        btnThemVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/IconAdd.jpg"))); // NOI18N
        btnThemVe.setText("Thêm");
        btnThemVe.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnThemVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVeActionPerformed(evt);
            }
        });

        cbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMaTour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel68.setText("Mã nhân viên");

        cbMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThoiGian_Ve, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemVe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaVe)
                    .addComponent(cbMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaVe)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGian_Ve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AdminTabPane.addTab("Quản lý vé", jPanel8);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Danh sách vé đã đặt");

        tbVeDaDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã vé", "Người đặt", "Mã tour", "Mã nhân viên", "Thời gian", "Giá vé"
            }
        ));
        tbVeDaDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeDaDatMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tbVeDaDat);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tổng tour đã đặt:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Tổng doanh thu:");

        sum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sum.setFocusable(false);

        totalRevenue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalRevenue.setFocusable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addGap(29, 29, 29)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(totalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        btnTaiLai.setText("Tải lại");
        btnTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 67, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaiLai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AdminTabPane.addTab("Thống kê vé", jPanel13);

        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.jpg"))); // NOI18N
        btnDoiMatKhau.setText("Admin");
        btnDoiMatKhau.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDangXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AdminTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDoiMatKhau)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnDangXuat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdminTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        AutomaticallyClosedMsgBox(2000, "Đang đăng xuất.\nXin hãy đợi...");
        this.dispose();
        DangNhapUI dn = new DangNhapUI("Quản lý du lịch");
        dn.showWindow();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
//        this.dispose();
//        DoiMatKhauUI doimk = new DoiMatKhauUI();
//        doimk.showWindow();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnXoaKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKSActionPerformed
        // TODO add your handling code here:
        try {
            if (tbKhachSan.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
            } else if (KhachSanDAL.show().size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
            } else {
                KhachSan delKS = new KhachSan();
                delKS.setMaKS(txtMaKS.getText());
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    KhachSanDAL.delete(KhachSanDAL.show(), delKS);
                    model = (DefaultTableModel) tbKhachSan.getModel();
                    model.setRowCount(0);
                    show_KhachSan();
                    delJtextFieldTbKhachSan();
                }

            }

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaKSActionPerformed

    private void btnThemKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKSActionPerformed
        // TODO add your handling code here:
        try {
            KhachSan newKS = new KhachSan();
            newKS.setMaKS(txtMaKS.getText());
            newKS.setTenKS(txtTenKS.getText());
            newKS.setDiaDiem(txtDiaDiem_KS.getText());

            if (KhachSanDAL.insert(KhachSanDAL.show(), newKS)) {
                JOptionPane.showMessageDialog(null, "Thêm khách sạn thành công!");
                show_KhachSan();
            }
            delJtextFieldTbKhachSan();

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemKSActionPerformed

    private void txtSuaXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuaXeActionPerformed
        // TODO add your handling code here:
        try {
            Xe setXe = new Xe();
            setXe.setMaXe(txtMaXe.getText());
            setXe.setBienSo(txtBienSo.getText());
            setXe.setLoaiXe(txtLoaiXe.getText());

            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if (XeDAL.update(XeDAL.show(), setXe)) {
                    JOptionPane.showMessageDialog(AdminTabPane, "Sửa xe thành công!");
                    show_Xe();
                } else {
                    JOptionPane.showMessageDialog(null, "Mã xe không tồn tại!");
                }
                delJtextFieldTbXe();
            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_txtSuaXeActionPerformed

    private void btnThemXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXeActionPerformed
        // TODO add your handling code here:
        try {
            Xe newXe = new Xe();
            newXe.setMaXe(txtMaXe.getText());
            newXe.setBienSo(txtBienSo.getText());
            newXe.setLoaiXe(txtLoaiXe.getText());

            if (XeDAL.insert(XeDAL.show(), newXe)) {
                JOptionPane.showMessageDialog(null, "Thêm xe thành công!");
                show_Xe();
            }
            delJtextFieldTbXe();

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemXeActionPerformed

    private void btnXoaTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTourActionPerformed
        // TODO add your handling code here:
        try {
            if (tbTour.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
            } else if (TourDAL.show().size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
            } else {
                Tour delTour = new Tour();
                delTour.setMaTour(txtMaTour.getText());
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    TourDAL.delete(TourDAL.show(), delTour);
                    model = (DefaultTableModel) tbTour.getModel();
                    model.setRowCount(0);
                    show_Tour();
                    delJtextFieldTbTour();
                }

            }

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaTourActionPerformed

    private void btnSuaTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTourActionPerformed
        // TODO add your handling code here:
        try {
            Tour setTour = new Tour();
            setTour.setMaTour(txtMaTour.getText());
            setTour.setTenTour(txtTenTour.getText());
            setTour.setThoiGian(txtThoiGian_Tour.getText());
            setTour.setDiaDiem(txtDiaDiem_Tour.getText());
            setTour.setMaXe(cbMaXe.getSelectedItem().toString());
            setTour.setMaKS(cbMaTour.getSelectedItem().toString());
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if (TourDAL.update(TourDAL.show(), setTour)) {
                    JOptionPane.showMessageDialog(null, "Sửa tour thành công!");
                    show_Tour();
                } else {
                    JOptionPane.showMessageDialog(null, "Mã tour không tồn tại!");
                }
                delJtextFieldTbTour();
            }

        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaTourActionPerformed

    private void btnThemTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTourActionPerformed
        // TODO add your handling code here:
        try {
            Tour newTour = new Tour();
            newTour.setMaTour(txtMaTour.getText());
            newTour.setTenTour(txtTenTour.getText());
            newTour.setThoiGian(txtThoiGian_Tour.getText());
            newTour.setDiaDiem(txtDiaDiem_Tour.getText());
            newTour.setMaXe(cbMaXe.getSelectedItem().toString());
            newTour.setMaKS(cbMaKS.getSelectedItem().toString());

            if (TourDAL.insert(TourDAL.show(), newTour)) {
                JOptionPane.showMessageDialog(null, "Thêm tour thành công!");
                show_Tour();
            }

            delJtextFieldTbTour();
        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemTourActionPerformed

    //Quản lý nhân viên    
    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        try {
            NhanVien newNV = new NhanVien();
            newNV.setMaNV(txtMaNV.getText());
            newNV.setTenNV(txtTenNV.getText());
            newNV.setSoDT(txtSDT_NV.getText());
            newNV.setDiaChi(txtDiaChi.getText());
            newNV.setNgaySinh(txtNgaySinh_NV.getText());
            newNV.setGioiTinh(txtGioiTinh_NV.getText());
            newNV.setEmail(txtEmail_NV.getText());

            if (NhanVienDAL.insert(NhanVienDAL.show(), newNV)) {
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
                show_NhanVien();
            }
            delJtextFieldTbNhanVien();

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        // TODO add your handling code here:
        try {
            NhanVien setNV = new NhanVien();
            setNV.setMaNV(txtMaNV.getText());
            setNV.setTenNV(txtTenNV.getText());
            setNV.setSoDT(txtSDT_NV.getText());
            setNV.setDiaChi(txtDiaChi.getText());
            setNV.setNgaySinh(txtNgaySinh_NV.getText());
            setNV.setGioiTinh(txtGioiTinh_NV.getText());
            setNV.setEmail(txtEmail_NV.getText());

            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if (NhanVienDAL.update(NhanVienDAL.show(), setNV)) {
                    JOptionPane.showMessageDialog(AdminTabPane, "Sửa nhân viên thành công!");
                    show_NhanVien();
                } else {
                    JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại!");
                }
                delJtextFieldTbNhanVien();
            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        // TODO add your handling code here:
        try {
            if (tbNhanVien.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
            } else if (NhanVienDAL.show().size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
            } else {
                NhanVien delNV = new NhanVien();
                delNV.setMaNV(txtMaNV.getText());
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    NhanVienDAL.delete(NhanVienDAL.show(), delNV);
                    model = (DefaultTableModel) tbNhanVien.getModel();
                    model.setRowCount(0);
                    show_NhanVien();
                    delJtextFieldTbNhanVien();
                }

            }

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void txtGiaVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaVeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaVeActionPerformed

    private void btnSuaVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVeActionPerformed
        // TODO add your handling code here:
        try {
            Ve setVe = new Ve();
            setVe.setMaVe(txtMaVe.getText());
            setVe.setTenUser(cbUser.getSelectedItem().toString());
            setVe.setMaTour(cbMaTour.getSelectedItem().toString());
            setVe.setMaNV(cbMaNV.getSelectedItem().toString());
            setVe.setThoiGian(txtThoiGian_Ve.getText());
            setVe.setGiaVe(Double.parseDouble(txtGiaVe.getText()));
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if (VeDAL.update(VeDAL.show(), setVe)) {
                    JOptionPane.showMessageDialog(null, "Sửa vé thành công!");
                    show_Ve();
                } else {
                    JOptionPane.showMessageDialog(null, "Mã vé không tồn tại!");
                }
                delJtextFieldTbTour();
            }

        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaVeActionPerformed

    private void btnXoaVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVeActionPerformed
        // TODO add your handling code here:
        try {
            if (tbVe.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
            } else if (VeDAL.show().size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
            } else {
                Ve delVe = new Ve();
                delVe.setMaVe(txtMaVe.getText());
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    VeDAL.delete(VeDAL.show(), delVe);
                    model = (DefaultTableModel) tbVe.getModel();
                    model.setRowCount(0);
                    show_Ve();
                    delJtextFieldTbVe();
                }
            }

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaVeActionPerformed

    private void btnThemVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVeActionPerformed
        // TODO add your handling code here:
        try {
            Ve newVe = new Ve();
            newVe.setMaVe(txtMaVe.getText());
            newVe.setTenUser(cbUser.getSelectedItem().toString());
            newVe.setMaTour(cbMaTour.getSelectedItem().toString());
            newVe.setMaNV(cbMaNV.getSelectedItem().toString());
            newVe.setThoiGian(txtThoiGian_Ve.getText());
            newVe.setGiaVe(Double.parseDouble(txtGiaVe.getText()));

            if (VeDAL.insert(VeDAL.show(), newVe)) {
                JOptionPane.showMessageDialog(null, "Thêm vé thành công!");
                show_Ve();
            }

            delJtextFieldTbTour();
        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemVeActionPerformed

    private void txtDiaDiem_TourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaDiem_TourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaDiem_TourActionPerformed

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        // TODO add your handling code here:
        show_Row_tbNhanVien();
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void cbMaKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaKSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaKSActionPerformed

    private void txtXoaXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXoaXeActionPerformed
        // TODO add your handling code here:
        try {
            if (tbXe.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
            } else if (XeDAL.show().size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
            } else {
                Xe delXe = new Xe();
                delXe.setMaXe(txtMaXe.getText());
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    XeDAL.delete(XeDAL.show(), delXe);
                    model = (DefaultTableModel) tbXe.getModel();
                    model.setRowCount(0);
                    show_Xe();
                    delJtextFieldTbXe();
                }
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_txtXoaXeActionPerformed

    private void tbXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbXeMouseClicked
        show_Row_tbXe();
    }//GEN-LAST:event_tbXeMouseClicked

    private void tbKhachSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachSanMouseClicked
        show_Row_tbKhachSan();
    }//GEN-LAST:event_tbKhachSanMouseClicked

    private void tbTourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTourMouseClicked
        show_Row_tbTour();
    }//GEN-LAST:event_tbTourMouseClicked

    private void tbVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeMouseClicked
        show_Row_tbVe();
    }//GEN-LAST:event_tbVeMouseClicked

    private void btnSuaKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKSActionPerformed
        try {
            KhachSan setKS = new KhachSan();
            setKS.setMaKS(txtMaKS.getText());
            setKS.setTenKS(txtTenKS.getText());
            setKS.setDiaDiem(txtDiaDiem_KS.getText());

            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if (KhachSanDAL.update(KhachSanDAL.show(), setKS)) {
                    JOptionPane.showMessageDialog(AdminTabPane, "Sửa khách sạn thành công!");
                    show_KhachSan();
                } else {
                    JOptionPane.showMessageDialog(null, "Mã khách sạn không tồn tại!");
                }
                delJtextFieldTbXe();
            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaKSActionPerformed

    private void tbTaiKhoan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaiKhoan2MouseClicked
        show_Row_tbTaiKhoanUser();
    }//GEN-LAST:event_tbTaiKhoan2MouseClicked

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        delJtextFieldTbTKUser();
    }//GEN-LAST:event_resetActionPerformed

    private void delTkUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delTkUserActionPerformed
        // TODO add your handling code here:
        try {
            if (tbTaiKhoan2.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa");
            } else if (TaiKhoanDAL.showUser().size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa");
            } else {
                TaiKhoan delTK = new TaiKhoan();
                delTK.setMaTaiKhoan(usernameKH.getText());
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    TaiKhoanDAL.delete(TaiKhoanDAL.show(), delTK);
                    model = (DefaultTableModel) tbTaiKhoan2.getModel();
                    model.setRowCount(0);
                    show_TaiKhoanUser();
                    delJtextFieldTbTKUser();
                }

            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_delTkUserActionPerformed

    private void btnThemtkUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemtkUserActionPerformed
        // TODO add your handling code here:
        try {
            TaiKhoan newTK = new TaiKhoan();
            newTK.setMaTaiKhoan(usernameKH.getText());
            char[] pf = passwordKH.getPassword();
            String value = new String(pf);
            newTK.setMatKhau(value);
            newTK.setVaiTro("User");
            if (TaiKhoanDAL.insert(TaiKhoanDAL.show(), newTK)) {
                JOptionPane.showMessageDialog(null, "Thêm tai khoản user thành công!");
                show_TaiKhoanUser();
            }
            delJtextFieldTbTKUser();

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemtkUserActionPerformed

    private void cboxShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxShowPassActionPerformed
        // TODO add your handling code here:
        if (cboxShowPass.isSelected()) {
            passwordKH.setEchoChar((char) 0);
        } else {
            passwordKH.setEchoChar('*');
        }
    }//GEN-LAST:event_cboxShowPassActionPerformed

    private void tbTaiKhoan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaiKhoan1MouseClicked
        // TODO add your handling code here:
        show_Row_tbTaiKhoanAdmin();
    }//GEN-LAST:event_tbTaiKhoan1MouseClicked

    private void btnHuyTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTKActionPerformed
        // TODO add your handling code here:
        delJtextFieldTbTKAmin();
    }//GEN-LAST:event_btnHuyTKActionPerformed

    private void btnSuaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTKActionPerformed
        // TODO add your handling code here:
        try {
            TaiKhoan setTK = new TaiKhoan();
            setTK.setMaTaiKhoan(usernameAdmin.getText());
            char[] pf = passwordAdmin.getPassword();
            String value = new String(pf);
            char[] confirmpf = confirmPass.getPassword();
            String confirmValue = new String(confirmpf);
            setTK.setMatKhau(value);
            setTK.setVaiTro("Admin");
            if (value.equals(confirmValue)) {
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);

                if (reply == JOptionPane.YES_OPTION) {
                    if (TaiKhoanDAL.update(TaiKhoanDAL.show(), setTK)) {
                        JOptionPane.showMessageDialog(AdminTabPane, "Sửa tài khoản thành công!");
                        show_TaiKhoanAdmin();
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã tài khoản không tồn tại!");
                    }
                }

                delJtextFieldTbTKAmin();
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không chính xác!");
            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaTKActionPerformed

    private void cboxShowPass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxShowPass1ActionPerformed
        // TODO add your handling code here:
        if (cboxShowPass1.isSelected()) {
            passwordAdmin.setEchoChar((char) 0);
        } else {
            passwordAdmin.setEchoChar('*');
        }
    }//GEN-LAST:event_cboxShowPass1ActionPerformed

    private void cboxShowPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxShowPass2ActionPerformed
        // TODO add your handling code here:
        if (cboxShowPass2.isSelected()) {
            confirmPass.setEchoChar((char) 0);
        } else {
            confirmPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cboxShowPass2ActionPerformed

    private void tbVeDaDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeDaDatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbVeDaDatMouseClicked

    private void btnTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLaiActionPerformed
        show_Ve_Da_Dat();
    }//GEN-LAST:event_btnTaiLaiActionPerformed

    // Tự động đóng thông báo
    public void AutomaticallyClosedMsgBox(long time, String text) { 
        JOptionPane jop = new JOptionPane();
        jop.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        jop.setMessage(text);
        JDialog dialog = jop.createDialog(null, "Thông báo");

        // Set timer
        new Thread(() -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            dialog.dispose();
        }).start();

        dialog.setVisible(true);
    }
    //reset textField
    public void delJtextFieldTbNhanVien() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtSDT_NV.setText("");
        txtDiaChi.setText("");
        txtNgaySinh_NV.setText("");
        txtGioiTinh_NV.setText("");
        txtEmail_NV.setText("");
    }

    public void delJtextFieldTbKhachSan() {
        txtMaKS.setText("");
        txtTenKS.setText("");
        txtDiaDiem_KS.setText("");
    }

    public void delJtextFieldTbXe() {
        txtMaXe.setText("");
        txtBienSo.setText("");
        txtLoaiXe.setText("");
    }

    public void delJtextFieldTbTKAmin() {
        usernameAdmin.setText("");
        passwordAdmin.setText("");
        confirmPass.setText("");
    }

    public void delJtextFieldTbTKUser() {
        usernameKH.setText("");
        passwordKH.setText("");
    }

    public void delJtextFieldTbTour() {
        txtMaTour.setText("");
        txtTenTour.setText("");
        txtThoiGian_Tour.setText("");
        txtDiaDiem_Tour.setText("");
        cbMaXe.setSelectedIndex(0);
        cbMaTour.setSelectedIndex(0);
    }

    public void delJtextFieldTbVe() {
        txtMaVe.setText("");
        cbUser.setSelectedIndex(0);
        cbMaTour.setSelectedIndex(0);
        cbMaNV.setSelectedIndex(0);
        txtThoiGian_Ve.setText("");
        txtGiaVe.setText("");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AdminTabPane;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHuyTK;
    private javax.swing.JButton btnSuaKS;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnSuaTK;
    private javax.swing.JButton btnSuaTour;
    private javax.swing.JButton btnSuaVe;
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JButton btnThemKS;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JPanel btnThemTK;
    private javax.swing.JButton btnThemTour;
    private javax.swing.JButton btnThemVe;
    private javax.swing.JButton btnThemXe;
    private javax.swing.JButton btnThemtkUser;
    private javax.swing.JButton btnXoaKS;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btnXoaTour;
    private javax.swing.JButton btnXoaVe;
    private javax.swing.JComboBox<String> cbMaKS;
    private javax.swing.JComboBox<String> cbMaNV;
    private javax.swing.JComboBox<String> cbMaTour;
    private javax.swing.JComboBox<String> cbMaXe;
    private javax.swing.JComboBox<String> cbUser;
    private javax.swing.JCheckBox cboxShowPass;
    private javax.swing.JCheckBox cboxShowPass1;
    private javax.swing.JCheckBox cboxShowPass2;
    private javax.swing.JPasswordField confirmPass;
    private javax.swing.JButton delTkUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField passwordAdmin;
    private javax.swing.JPasswordField passwordKH;
    private javax.swing.JButton reset;
    private javax.swing.JTextField sum;
    private javax.swing.JTable tbKhachSan;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTable tbTaiKhoan1;
    private javax.swing.JTable tbTaiKhoan2;
    private javax.swing.JTable tbTour;
    private javax.swing.JTable tbVe;
    private javax.swing.JTable tbVeDaDat;
    private javax.swing.JTable tbXe;
    private javax.swing.JTextField totalRevenue;
    private javax.swing.JTextField txtBienSo;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaDiem_KS;
    private javax.swing.JTextField txtDiaDiem_Tour;
    private javax.swing.JTextField txtEmail_NV;
    private javax.swing.JTextField txtGiaVe;
    private javax.swing.JTextField txtGioiTinh_NV;
    private javax.swing.JTextField txtLoaiXe;
    private javax.swing.JTextField txtMaKS;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaTour;
    private javax.swing.JTextField txtMaVe;
    private javax.swing.JTextField txtMaXe;
    private javax.swing.JTextField txtNgaySinh_NV;
    private javax.swing.JTextField txtSDT_NV;
    private javax.swing.JButton txtSuaXe;
    private javax.swing.JTextField txtTenKS;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenTour;
    private javax.swing.JTextField txtThoiGian_Tour;
    private javax.swing.JTextField txtThoiGian_Ve;
    private javax.swing.JButton txtXoaXe;
    private javax.swing.JTextPane usernameAdmin;
    private javax.swing.JTextField usernameKH;
    // End of variables declaration//GEN-END:variables
}
