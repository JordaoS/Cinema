package br.ufc.qxd.vev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.vev.bean.Sessao;
import br.ufc.qxd.vev.repositories.SessaoRepository;

@Service("sessaoService")
public class SessaoService implements ISessaoService{
	
	@Autowired
	SessaoRepository sessaoRepositorio;
	
    private static final AtomicLong counter = new AtomicLong();
     
    public List<Sessao> findAllSessao() {
        return sessaoRepositorio.findAll();
    }
     
    public Sessao findById(long id) {
    	List<Sessao> sessoes = sessaoRepositorio.findAll();
        for(Sessao sessao: sessoes){
            if(sessao.getId() == id){
                return sessao;
            }
        }
        return null;
    }
     
//    public User findByName(String name) {
//        for(User user : users){
//            if(user.getName().equalsIgnoreCase(name)){
//                return user;
//            }
//        }
//        return null;
//    }
//     
    public void saveUser(Sessao sessao) {
        sessaoRepositorio.save(sessao);
    }
// 
//    public void updateUser(User user) {
//        int index = users.indexOf(user);
//        users.set(index, user);
//    }
// 
//    public void deleteUserById(long id) {
//         
//        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
//            User user = iterator.next();
//            if (user.getId() == id) {
//                iterator.remove();
//            }
//        }
//    }
// 
//    public boolean isUserExist(Sessao sessao) {
//        return findById(sessao.getId())!=null;
//    }
//    
//    public void deleteAllUsers(){
//        users.clear();
//    }
    
    public List<Sessao> getSessaoByFilme(long id){
    	List<Sessao> sessoes = sessaoRepositorio.findAll();
    	List<Sessao> result = new ArrayList<Sessao>();
        for(Sessao sessao: sessoes){
            if(sessao.getFilme() == id){
            	result.add(sessao);
            }
        }
        return result;
    }
    
    public List<Sessao> getSessaoBySala(long id){
    	List<Sessao> sessoes = sessaoRepositorio.findAll();
    	List<Sessao> result = new ArrayList<Sessao>();
        for(Sessao sessao: sessoes){
            if(sessao.getSala() == id){
            	result.add(sessao);
            }
        }
        return result;
    }
 
 
}
