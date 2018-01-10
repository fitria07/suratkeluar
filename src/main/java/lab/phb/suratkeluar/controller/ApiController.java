package lab.phb.suratkeluar.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.phb.suratkeluar.entity.Keluar;
import lab.phb.suratkeluar.repo.KeluarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


@RestController
public class ApiController {

	@RequestMapping("/get-nama")
	public Map<String, Object> getNama(){
		Map<String, Object> result = new HashMap();
		result.put("nama", "Fina");

		return result;
	}
        @Autowired
        private KeluarRepo keluarRepo;

	//-- aplikasi keluar 
	@RequestMapping("/daftar-suratkeluar")
        public List<Keluar> ambilDaftarkeluar(){
            return keluarRepo.findAll();
        }

    @RequestMapping(value = "/tambah-klr", method = RequestMethod.POST)
    public void tambahData(@RequestBody Keluar klr){
    	//System.out.println("id : " + klr.getId());
    	//System.out.println("nama : " + klr.getNama());
    	//System.out.println("jurusan : " + klr.getJurusan());
    	keluarRepo.save(klr);
    }

    @RequestMapping("/get-klr-by-id/{id}")
    public Keluar getKlrById(@PathVariable("id") String id) {
    	return keluarRepo.findOneById(id);
    }

    @RequestMapping(value = "/hapus-data/{id}", method = RequestMethod.DELETE)
    public void hapusData(@PathVariable("id") String id){
        keluarRepo.delete(id);
    }


    @RequestMapping("/keluar")
    public void keluar(HttpServletRequest req, 
        HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder
            .getContext().getAuthentication();
        new SecurityContextLogoutHandler()
            .logout(req, resp, auth);
    }


}