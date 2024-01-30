/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.ThanhVienDTO;
import DataProvider.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level; 
import java.util.logging.Logger;

/**
 *
 * @author mizuk
 */
public class ThanhVienDAL {
    private List <ThanhVienDTO> listTV = new ArrayList <ThanhVienDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public ThanhVienDAL(){
    }

    public List<ThanhVienDTO> getData(){
        try{
            
            String query = "SELECT * FROM `thanh_vien` WHERE `trang_thai` = 1";
            ResultSet rs = dataProvider.excuteQuery(query);
            
            while(rs.next()){
                ThanhVienDTO data = new ThanhVienDTO(
                    rs.getString("ma_thanh_vien"),
                    rs.getString("mat_khau"),
                    rs.getString("ten_thanh_vien"),                    
                    rs.getDate("ngay_sinh"),
                    rs.getString("sdt"),
                    rs.getString("mail"),
                    rs.getInt("diem")
                );
                listTV.add(data);
            }
            dataProvider.closeConnect();
            return listTV;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO`thanh_vien`(`ma_thanh_vien`,`mat_khau`, `ten_thanh_vien`,`ngay_sinh`, `sdt`, `mail`, `diem`,`trang_thai`) "
                    + "VALUES ('"+arr[0]+"', '"+arr[1]+"', '"+arr[2]+"', '"+arr[3]+"', '"+arr[4]+"','"+arr[5]+"','"+arr[6]+"',1)";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception ex) {
            Logger.getLogger(ThanhVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delData(String ma_thanh_vien){
        try {
            String query = "Update `thanh_vien` Set `trang_thai` = 0 Where `ma_thanh_vien` = '"+ma_thanh_vien+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception e) {
            Logger.getLogger(ThanhVienDAL.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `thanh_vien` SET `ten_thanh_vien` = '"+arr[1]+"',`mat_khau` = '"+arr[2]+"'"
                    + " , `ngay_sinh` = '"+arr[3]+"', `sdt` = '"+arr[4]+"'"
                    + " , `mail` = '"+arr[5]+"' WHERE `ma_thanh_vien` = '"+arr[0]+"' and `trang_thai` = 1";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception ex) {
            Logger.getLogger(ThanhVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updatePoint(String []str){
        try {
            String query = "UPDATE `thanh_vien` SET `diem` = '"+str[1]+"' WHERE `ma_thanh_vien` = '"+str[0]+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception ex) {
            Logger.getLogger(ThanhVienDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getMaMax(){
        try{
            String query = "SELECT MAX(ma_thanh_vien) as ma_thanh_vien FROM `thanh_vien`";
            ResultSet rs =  dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                 ma = rs.getString("ma_thanh_vien");
            }
            dataProvider.closeConnect();
            return ma;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }    
    }
    
    public int getPointFromID(String ma_thanh_vien) {
        try {
            int point=0;
            String query = "Select `diem` from `thanh_vien` where `ma_thanh_vien` = '"+ma_thanh_vien+"'";
            ResultSet rs =  dataProvider.excuteQuery(query);
            if(rs.next()){
                 point = rs.getInt("diem");
            }
            
            dataProvider.closeConnect();
            return point;
//            dataProvider.ExecuteUpdate(query);
//            dataProvider.closeConnect();
        } catch (Exception ex) {
            Logger.getLogger(ThanhVienDAL.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
    

