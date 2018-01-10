/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.phb.suratkeluar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author User
 */
@Entity
public class Keluar {
    
    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String tgl_surat;
    
    @Column @Getter @Setter
    private String judul;
    
    @Column @Getter @Setter
    private String tujuan;
    
}
