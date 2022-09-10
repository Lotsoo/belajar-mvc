/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.Form_siswa;
import controller.Controller_siswa;
import koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SpringLayout;

/**
 *
 * @author lotso
 */
public class Model_siswa implements controller.Controller_siswa {
    
    String jk;
    
    @Override
    public void Simpan(Form_siswa siswa) throws SQLException {
        if (siswa.rbLaki.isSelected()) {
            jk = "Laki-Laki";
        } else {
            jk = "Perempuan";
        }
        try {
            Connection con = Koneksi.getcon();
            String sql = "insert into siswa values (?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, siswa.txtNIS.getText());
            prepare.setString(2, siswa.txtNama.getText());
            prepare.setString(3, jk);
            prepare.setString(4, (String) siswa.cbJurusan.getSelectedItem());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            prepare.close();
            Baru(siswa);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(siswa);
            siswa.setLebarKolom();
        }
    }
    
    @Override
    public void Ubah(Form_siswa siswa) throws SQLException {
        if (siswa.rbLaki.isSelected()) {
            jk = "Laki-Laki";
        } else {
            jk = "Perempuan";
        }
        try {
            Connection con = Koneksi.getcon();
            String sql = "update siswa set nama=?, jenis_kelamin=?," + "jurusan=? where nis=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(4, siswa.txtNIS.getText());
            prepare.setString(1, siswa.txtNama.getText());
            prepare.setString(2, jk);
            prepare.setString(3, (String) siswa.cbJurusan.getSelectedItem());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(siswa);
            Baru(siswa);
        }
    }
    
    @Override
    public void Hapus(Form_siswa siswa) throws SQLException {
        try {
            Connection con = Koneksi.getcon();
            String sql = "delete from siswa where nis=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, siswa.txtNIS.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            prepare.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Tampil(siswa);
            siswa.setLebarKolom();
            Baru(siswa);
        }
    }
    
    @Override
    public void Tampil(Form_siswa siswa) throws SQLException {
//        siswa.tblmodel.getDataVector().removeAllElements();
//        siswa.tblmodel.fireTableDataChanged();
//        try {
//            Connection con = Koneksi.getcon();
//            Statement stt = con.createStatement();
//            //query menampilkan semua data pada tabel siswa dengan urutan NIS dari kecil ke besar
//            String sql = "select * from siswa order by nis asc";
//            ResultSet rs = stt.executeQuery(sql);
//            while (rs.next()) {
//                Object[] ob = new Object[8];
//                ob[0] = rs.getString(1);
//                ob[1] = rs.getString(2);
//                ob[2] = rs.getString(3);
//                ob[3] = rs.getString(4);
//                siswa.tblmodel.addRow(ob);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
    
    @Override
    public void Baru(Form_siswa siswa) throws SQLException {
        siswa.txtNIS.setText("");
        siswa.txtNama.setText("");
        siswa.rbLaki.setSelected(true);
        siswa.cbJurusan.setSelectedIndex(0);
    }
    
    @Override
    public void KlikTabel(Form_siswa siswa) throws SQLException {
//        try {
//            int pilih = siswa.tabel.getSelectedRow();
//            if (pilih == -1) {
//                return;
//            }
//            siswa.txtNIS.setText(siswa.tblmodel.getValueAt(pilih, 0).toString());
//            siswa.txtNama.setText(siswa.tblmodel.getValueAt(pilih, 1).toString());
//            siswa.cbJurusan.setSelectedItem(siswa.tblmodel.getValueAt(pilih, 3).toString());
//            jk = String.valueOf(siswa.tblmodel.getValueAt(pilih, 2));
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        if (siswa.rbLaki.getText().equals(jk)) {
//            siswa.rbLaki.setSelected(true);
//        } else {
//            siswa.rbPerempuan.setSelected(true);
//        }
    }
    
}
