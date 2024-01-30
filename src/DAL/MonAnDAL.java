/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
 
import DTO.MonAnDTO;
import DataProvider.*;
import java.util.List;
import java.util.ArrayList; 
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JComboBox;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mizuk
 */
public class MonAnDAL {
    List <MonAnDTO> listFood = new ArrayList<MonAnDTO>();
    List <MonAnDTO> listFoodName = new ArrayList<MonAnDTO>();
    DataProvider dataProvider = new DataProvider();
    
    public List<MonAnDTO> getData(){
        try{
            String query = "SELECT * FROM `mon_an` WHERE `trang_thai` = 1 ORDER BY ma_mon ASC";
            
            ResultSet rs =  dataProvider.excuteQuery(query);
            while(rs.next()){
                listFood.add(new MonAnDTO(
                    rs.getString("ma_mon"),
                    rs.getString("ten_mon"),
                    rs.getInt("so_luong"),
                    rs.getInt("gia"),       
                    rs.getInt("gia_giam"),
                    rs.getString("ma_loai")                      
                ));
            }
            dataProvider.closeConnect();
            return listFood;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }
    public String getMaMax(){
        try {
            String query = "SELECT MAX(ma_mon) as ma_mon FROM `mon_an`";
            ResultSet rs = dataProvider.excuteQuery(query);
            String ma = null;
            while(rs.next()){
                ma = rs.getString("ma_mon");
            }
            dataProvider.closeConnect();
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
            
    }
    public void addData(String []arr){
        try {
            String query = "INSERT INTO `mon_an`(`ma_mon`, `ten_mon`, `so_luong`, `gia`,`gia_giam`, `ma_loai`,`trang_thai`) "
                + "VALUES ('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"',"+arr[3]+",'0','"+arr[4]+"',1)";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();
        } catch (Exception ex) {
            Logger.getLogger(MonAnDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delData(String ma_mon){
        try {
            String query = "Update `mon_an` set `trang_thai` = 0 where `ma_mon` = '"+ma_mon+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();       
        } catch (Exception ex) {
            Logger.getLogger(MonAnDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateData(String []arr){
        try {
            String query = "UPDATE `mon_an` "
                    + "SET `ten_mon`='"+arr[1]+"', `gia`='"+arr[2]+"', `ma_loai`='"+arr[3]+"'"
                    + "WHERE `ma_mon` = '"+arr[0]+"' and `trang_thai` = 1";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();       
        } catch (Exception ex) {
            Logger.getLogger(MonAnDAL.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    public void updatePriceFromData(String ma_mon,int gia_giam){
        try {
            String query = "UPDATE `mon_an` SET `gia_giam`="+gia_giam+" WHERE `ma_mon` = '"+ma_mon+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();       
        } catch (Exception ex) {
            Logger.getLogger(MonAnDAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void updateCountFromData(String ma_mon,int so_luong){
        try {
            String query = "UPDATE `mon_an` SET `so_luong`="+so_luong+" WHERE `ma_mon` = '"+ma_mon+"'";
            dataProvider.ExecuteUpdate(query);
            dataProvider.closeConnect();       
        } catch (Exception ex) {
            Logger.getLogger(MonAnDAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
