/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import Entities.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class GhiFile {
    public static void ghi_NhanVien_Vao_File(ArrayList<NhanVien> list) throws IOException{
        try{
            FileOutputStream fout=new FileOutputStream("NhanVien.DAT");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(list);
            out.flush();
            //closing the stream
            out.close();
        }
        catch(FileNotFoundException e){
            Logger.getLogger("NhanVien.DAT", e.getMessage());
        }
    }
    
    public static void ghi_TaiKhoan_Vao_File(ArrayList<TaiKhoan> list) throws IOException{
        try{
            FileOutputStream fout=new FileOutputStream("TaiKhoan.DAT");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(list);
            out.flush();
            //closing the stream
            out.close();
        }
        catch(FileNotFoundException e){
            Logger.getLogger("TaiKhoan.DAT", e.getMessage());
        }
    }
    
    public static void ghi_KhachSan_Vao_File(ArrayList<KhachSan> list) throws IOException{
        try{
            FileOutputStream fout=new FileOutputStream("KhachSan.DAT");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(list);
            out.flush();
            //closing the stream
            out.close();
        }
        catch(FileNotFoundException e){
            Logger.getLogger("KhachSan.DAT", e.getMessage());
        }
    }
    
    public static void ghi_Tour_Vao_File(ArrayList<Tour> list) throws IOException{
        try{
            FileOutputStream fout=new FileOutputStream("Tour.DAT");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(list);
            out.flush();
            //closing the stream
            out.close();
        }
        catch(FileNotFoundException e){
            Logger.getLogger("Tour.DAT", e.getMessage());
        }
    }
    
    public static void ghi_Ve_Vao_File(ArrayList<Ve> list) throws IOException{
        try{
            FileOutputStream fout=new FileOutputStream("Ve.DAT");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(list);
            out.flush();
            //closing the stream
            out.close();
        }
        catch(FileNotFoundException e){
            Logger.getLogger("Ve.DAT", e.getMessage());
        }
    }
    
    public static void ghi_Xe_Vao_File(ArrayList<Xe> list) throws IOException{
        try{
            FileOutputStream fout=new FileOutputStream("Xe.DAT");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(list);
            out.flush();
            //closing the stream
            out.close();
        }
        catch(FileNotFoundException e){
            Logger.getLogger("Xe.DAT", e.getMessage());
        }
    }
    
    public static void ghi_TourDaDat_Vao_File(ArrayList<TourDaDat> list) throws IOException{
        try{
            FileOutputStream fout=new FileOutputStream("TourDaDat.DAT");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(list);
            out.flush();
            //closing the stream
            out.close();
        }
        catch(FileNotFoundException e){
            Logger.getLogger("TourDaDat.DAT", e.getMessage());
        }
    }
}
