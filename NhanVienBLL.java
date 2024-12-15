/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhanVienDAL;
import Entities.NhanVien;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author admin
 */
public class NhanVienBLL {
    public static TableModel show(){
        
        ArrayList<NhanVien> list= NhanVienDAL.show();
        String[] columnNames = {"Mã nhân viên","Tên nhân viên","Số điện thoại","Địa chỉ","Ngày sinh","Giới tính","Email"};
        Object[][] data = new Object[list.size()][columnNames.length];
        int row = 0;
        for(NhanVien c : list){
            data[row][0] = c.getMaNV();
            data[row][1] = c.getTenNV();
            data[row][2] = c.getSoDT();
            data[row][3] = c.getDiaChi();
            data[row][4] = c.getNgaySinh();
            data[row][5] = c.getGioiTinh();
            data[row][6] = c.getEmail();
            
            row++;
        }
        
        DefaultTableModel table = new DefaultTableModel(data,columnNames){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 1:return String.class;
                    case 2:return String.class;
                    case 3:return String.class;
                    case 4:return String.class;
                    case 5:return String.class;
                    case 6:return String.class;
                    default:return String.class;
                }
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            };
        };
        
       return table;
        
    }
    
    public static Object[] showControlWithCombobox(String cbbValue){
        ArrayList<NhanVien> list = NhanVienDAL.show();
        Object[] obj = new Object[7];
        for(NhanVien k :list){
            if(cbbValue.equals(k.getMaNV())){
                  obj[0]  = k.getMaNV();
                  obj[1]  = k.getTenNV();
                  obj[2]  = k.getSoDT();
                  obj[3]  = k.getDiaChi();
                  obj[4]  = k.getNgaySinh();
                  obj[5]  = k.getGioiTinh();
                  obj[6]  = k.getEmail();
            }
        }
        return obj;
    }
    
    public static ComboBoxModel cbb_show(){
        
        StringBuilder items = new StringBuilder();
        
        for(int i = 0;i<NhanVienDAL.show().size();i++){
            items.append(NhanVienDAL.show().get(i).getMaNV());
            items.append("#");
        }
        
        return new DefaultComboBoxModel(items.toString().split("#"));
    }
}
