/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entities.KhachSan;
import Tools.DocFile;
import Tools.GhiFile;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class KhachSanDAL {
    public static ArrayList<KhachSan> show(){
        try{
            ArrayList<KhachSan> a = new ArrayList<KhachSan>();
            a = DocFile.Doc_KhachSan_Tu_File();
            return a;
        }
        catch(IOException e){
            return null;
        }
        catch(ClassNotFoundException e){
            return null;
        }
        
    }
    
    public static String GetTenKhachSan(String maKS){
        ArrayList<KhachSan> a = KhachSanDAL.show();
        for(KhachSan item:a){
            if(item.getMaKS().equals(maKS))
                return item.getTenKS();
        }
        return "";
    }
    
    public static boolean insert(ArrayList<KhachSan> list, KhachSan a) throws IOException{
        if(a.getMaKS().equals("")){
            JOptionPane.showMessageDialog(null,"Mã khách sạn không được để trống");
            return false;
        }
        for(KhachSan item : list)
            if(a.getMaKS().equals(item.getMaKS())){
                JOptionPane.showMessageDialog(null,"Mã khách sạn đã tồn tại");
                return false;
            }
        int index = list.size();
        for(int i=0;i<list.size();i++){
            if(a.getMaKS().compareTo(list.get(i).getMaKS())>0)
                index = i+1;
        }
        list.add(index,a);
        GhiFile.ghi_KhachSan_Vao_File(list);
        return true;
    }
    
    public static boolean update(ArrayList<KhachSan> list, KhachSan a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaKS().equals(list.get(i).getMaKS())){
                index = i;
            }
        if(index != -1){
            list.set(index,a);
            GhiFile.ghi_KhachSan_Vao_File(list);
            return true;
        }
        return false;
        
    }
    
    public static boolean delete(ArrayList<KhachSan> list, KhachSan a) throws IOException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaKS().equals(list.get(i).getMaKS())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            GhiFile.ghi_KhachSan_Vao_File(list);
            return true;
        }
        else
        return false;
    }
}
