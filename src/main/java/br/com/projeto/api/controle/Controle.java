package br.com.projeto.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Cliente;
import br.com.projeto.api.servico.ClienteServico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*") //Anotação que evita conflitos de portas no navegador durante o consumo da api. 
public class Controle {
    
    @Autowired
    private ClienteServico clienteServico;

    @GetMapping("/")
    public Iterable<Cliente> selecionar(){
        return clienteServico.listar();
    }

    @PostMapping("/")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteServico.salvar(cliente);
    }
    
    @PutMapping("/")
    public Cliente editarCliente(@RequestBody Cliente cliente) {
    	return clienteServico.editar(cliente);
    }
    
    @DeleteMapping("/{codigo}")
    public void deletarCliente(@PathVariable Long codigo) {
    	clienteServico.deletar(codigo);
    }
    
    
    

}
