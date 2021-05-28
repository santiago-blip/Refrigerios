/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrigeriosla80v2.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refrigeriosla80v2.dao.UsuarioDao;
import refrigeriosla80v2.entities.Usuario;
import refrigeriosla80v2.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    
    @Autowired
    private UsuarioDao serviceDao;

    @Override
    public void insertarUsuario(Usuario usuario) {
        serviceDao.save(usuario);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return serviceDao.findByCorreo(correo);
    }

    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        return serviceDao.findById(usuario.getIdUsuario()).orElse(null);
    }
    
}
