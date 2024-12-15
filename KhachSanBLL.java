/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.KhachSanDAL;
import Entities.KhachSan;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author admin
 */
public class KhachSanBLL {
    public static TableModel show(){
        
        ArrayList<KhachSan> list= KhachSanDAL.show();
        String[] columnNames = {"Mã khách sạn","Tên khách sạn","Địa điểm"};
        Object[][] data = new Object[list.size()][columnNames.length];
        int row = 0;
        for(KhachSan c : list){
            data[row][0] = c.getMaKS();
            data[row][1] = c.getTenKS();
            data[row][2] = c.getDiaDiem();
            row++;
        }
        
        DefaultTableModel table = new DefaultTableModel(data,columnNames){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 1:return String.class;
                    case 2:return String.class;
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
        ArrayList<KhachSan> list = KhachSanDAL.show();
        Object[] obj = new Object[3];
        for(KhachSan k :list){
            if(cbbValue.equals(k.getMaKS())){
                  obj[0]  = k.getMaKS();
                  obj[1]  = k.getTenKS();
                  obj[2]  = k.getDiaDiem();
            }
        }
        return obj;
    }
    
    public static ComboBoxModel cbb_show(){
        
        StringBuilder items = new StringBuilder();
        
        for(int i = 0;i<KhachSanDAL.show().size();i++){
            items.append(KhachSanDAL.show().get(i).getMaKS());
            items.append("#");
        }
        
        return new DefaultComboBoxModel(items.toString().split("#"));
    }
}
