/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrigeriosla80v2.service;

import refrigeriosla80v2.entities.Usuario;

/**
 *
 * @author santi
 */
public interface IUsuarioService {
    
    public void insertarUsuario(Usuario usuario);
    public Usuario buscarPorCorreo(String correo);
    public Usuario buscarUsuario(Usuario usuario);
    
}
