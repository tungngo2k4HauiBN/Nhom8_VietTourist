/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Tools.DocFile;
import Tools.GhiFile;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class KhachSan implements Serializable{
    private String maKS;
    private String tenKS;
    private String diaDiem;

    public KhachSan() {
    }

    public KhachSan(String maKS, String tenKS, String diaDiem) {
        this.maKS = maKS;
        this.tenKS = tenKS;
        this.diaDiem = diaDiem;
    }

    public String getMaKS() {
        return maKS;
    }

    public void setMaKS(String maKS) {
        this.maKS = maKS;
    }

    public String getTenKS() {
        return tenKS;
    }

    public void setTenKS(String tenKS) {
        this.tenKS = tenKS;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
    
    @Override
    public String toString() {
        return "KhachSan{" + "MaKS=" + maKS + ", TenKS=" + tenKS + ", DiaDiem=" + diaDiem + '}';
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        ArrayList<KhachSan> a = DocFile.Doc_KhachSan_Tu_File();
        
          //Tạo khách sạn file
//          ArrayList<KhachSan> s = new ArrayList<>();     
//          KhachSan n1 = new KhachSan("KS01","Hải Âu","Phú Quốc");
//          KhachSan n2 = new KhachSan("KS02","Gió Hotel","Tam Đảo");
//          KhachSan n3 = new KhachSan("KS03","JW Mariot","Đà Nẵng");
//          KhachSan n4 = new KhachSan("KS04","SunShine","Đà Lạt");
//          KhachSan n5 = new KhachSan("KS05","Halong Resort","Hạ Long");
//          s.add(n1);
//          s.add(n2);
//          s.add(n3);
//          s.add(n4);
//          s.add(n5);
//          GhiFile.ghi_KhachSan_Vao_File(s);
    }
}
