/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entities.NhanVien;
import Tools.DocFile;
import Tools.GhiFile;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class NhanVienDAL {
    public static ArrayList<NhanVien> show(){
        try{
            ArrayList<NhanVien> a = new ArrayList<NhanVien>();
            a = DocFile.Doc_NhanVien_Tu_File();
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
    }
    
    public static String GetTenNV(String maNV){
        ArrayList<NhanVien> a = show();
        for(NhanVien item:a){
            if(item.getMaNV().equals(maNV))
                return item.getTenNV();
        }
        return "";
    }
    
    public static boolean insert(ArrayList<NhanVien> list, NhanVien a) throws IOException{
        if(a.getMaNV().equals("")){
            JOptionPane.showMessageDialog(null,"Mã nhân viên không được để trống");
            return false;
        }
        for(NhanVien item : list)
            if(a.getMaNV().equals(item.getMaNV())){
                JOptionPane.showMessageDialog(null,"Mã nhân viên đã tồn tại");
                return false;
            }
        int index = list.size();
        for(int i=0;i<list.size();i++){
            if(a.getMaNV().compareTo(list.get(i).getMaNV())>0)
                index = i+1;
        }
        list.add(index,a);
        GhiFile.ghi_NhanVien_Vao_File(list);
        return true;
    }
    
    public static boolean update(ArrayList<NhanVien> list, NhanVien a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaNV().equals(list.get(i).getMaNV())){
                index = i;
            }
        if(index != -1){
            list.set(index,a);
            GhiFile.ghi_NhanVien_Vao_File(list);
            return true;
        }
        return false;
        
    }
    
    public static boolean delete(ArrayList<NhanVien> list, NhanVien a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaNV().equals(list.get(i).getMaNV())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            GhiFile.ghi_NhanVien_Vao_File(list);
            return true;
        }
        else
        return false;
    }
}
