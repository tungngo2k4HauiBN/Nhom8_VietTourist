/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.TaiKhoanDAL;
import Entities.TaiKhoan;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author admin
 */
public class TaiKhoanBLL {
    public static TableModel show1(){
        
        ArrayList<TaiKhoan> list= TaiKhoanDAL.showAdmin();
        int row = 0;
        
        String[] columnNames = {"Tên đăng nhập","Mật khẩu"};
        Object[][] data = new Object[list.size()][columnNames.length];
        for(TaiKhoan c : list){
            data[row][0] = c.getMaTaiKhoan();
            data[row][1] = c.getMatKhau();
            row++;
        }
        
        DefaultTableModel table = new DefaultTableModel(data,columnNames){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0: return String.class;
                    default:return String.class;
                    
                }
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        
       return table;
        
    }
        
    public static TableModel show2(){
        
        ArrayList<TaiKhoan> list= TaiKhoanDAL.showUser();
        int row = 0;
        
        String[] columnNames = {"Tên đăng nhập","Mật khẩu"};
        Object[][] data = new Object[list.size()][columnNames.length];
        for(TaiKhoan c : list){
            data[row][0] = c.getMaTaiKhoan();
            data[row][1] = c.getMatKhau();
            row++;
        }
        DefaultTableModel table = new DefaultTableModel(data,columnNames){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0: return String.class;
                    default:return String.class;
                    
                }
            };
            
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        
       return table;
    }
    
    public static Object[] showControlWithCombobox(String cbbValue){
        ArrayList<TaiKhoan> list = TaiKhoanDAL.show();
        Object[] obj = new Object[3];
        for(TaiKhoan k :list){
            if(cbbValue.equals(k.getMaTaiKhoan())){
                  obj[0]  = k.getMaTaiKhoan();
                  obj[1]  = k.getMatKhau();
                  obj[2]  = k.getVaiTro();
            }
        }
        return obj;
    }
    
    public static ComboBoxModel cbb_show(){
        
        StringBuilder items = new StringBuilder();
        
        for(int i = 0;i<TaiKhoanDAL.show().size();i++){
            if(TaiKhoanDAL.show().get(i).getVaiTro().equals("User")) {
                items.append(TaiKhoanDAL.show().get(i).getMaTaiKhoan());
                items.append("#");
            }   
        }
        
        return new DefaultComboBoxModel(items.toString().split("#"));
    }
}
