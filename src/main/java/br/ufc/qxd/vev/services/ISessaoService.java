package br.ufc.qxd.vev.services;

import java.util.List;

import br.ufc.qxd.vev.bean.Sessao;

public interface ISessaoService {
	Sessao findById(long id);
    
    //Sessao findByName(String name);
     
    void saveUser(Sessao sessao);
//     
//    void updateSessao(Sessao sessao);
//     
//    void deleteSessaoById(long id);
// 
	List<Sessao> findAllSessao();
     
    //void deleteAllSessao();
     
//    boolean isUserExist(Sessao sessao);
	
	List<Sessao> getSessaoByFilme(long id);
	List<Sessao> getSessaoBySala(long id);

}
