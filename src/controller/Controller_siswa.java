/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.sql.SQLException;
import view.Form_siswa;

/**
 *
 * @author lotso
 */
public interface Controller_siswa {

    public void Simpan(Form_siswa siswa) throws SQLException;

    public void Ubah(Form_siswa siswa) throws SQLException;

    public void Hapus(Form_siswa siswa) throws SQLException;

    public void Tampil(Form_siswa siswa) throws SQLException;

    public void Baru(Form_siswa siswa) throws SQLException;

    public void KlikTabel(Form_siswa siswa) throws SQLException;

}
