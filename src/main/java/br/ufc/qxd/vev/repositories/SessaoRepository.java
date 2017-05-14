package br.ufc.qxd.vev.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.vev.bean.Sessao;

@Repository
@Transactional
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{
	
	Sessao findById(long id);
    
    //Sessao findByName(String name);
     
//    void saveUser(Sessao sessao);
//     
//    void updateSessao(Sessao sessao);
//     
//    void deleteSessaoById(long id);
// 
     
    //void deleteAllSessao();
     
//    boolean isUserExist(Sessao sessao);
}
