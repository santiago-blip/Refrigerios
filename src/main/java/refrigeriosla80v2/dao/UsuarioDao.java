/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrigeriosla80v2.dao;

import org.springframework.data.repository.CrudRepository;
import refrigeriosla80v2.entities.Usuario;

/**
 *
 * @author santi
 */
public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

    public Usuario findByCorreo(String correo);
}
