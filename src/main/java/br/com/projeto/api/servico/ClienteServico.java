package br.com.projeto.api.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.modelo.Cliente;
import br.com.projeto.api.repositorio.Repositorio;

@Repository
public class ClienteServico {

    @Autowired
    private Repositorio repositorio;
    
    public Cliente salvar(Cliente cliente){
        return repositorio.save(cliente);
    }
    
    public List<Cliente> listar() {
    	return repositorio.findAll();
    }
    
    public Cliente editar(Cliente cliente) {
    	return repositorio.save(cliente);
    }

    public void  deletar(Long codigo) {
    	repositorio.deleteById(codigo);
    }
}
