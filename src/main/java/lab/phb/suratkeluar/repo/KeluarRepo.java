/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.phb.suratkeluar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab.phb.suratkeluar.entity.Keluar;
/**
 *
 * @author User
 */
@Repository
public interface KeluarRepo extends JpaRepository<Keluar, String> {
	Keluar findOneById(String id);
    
    
}
