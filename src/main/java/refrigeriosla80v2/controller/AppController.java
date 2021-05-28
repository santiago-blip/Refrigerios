/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrigeriosla80v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import refrigeriosla80v2.entities.Rol;
import refrigeriosla80v2.entities.Usuario;

@Controller
public class AppController {

    @Autowired
    private BCryptPasswordEncoder passwordEncode;
    
    @RequestMapping(value = "/")
    public String index(Usuario usuario) {
        return "index";
    }

    @PostMapping("/registro")
    public String registro(Usuario usuario) {
        Rol rol = new Rol();
        rol.setIdRol(2);
        System.out.println("Correo: ".concat(usuario.getCorreo()));
        System.out.println("Nombre: ".concat(usuario.getNombre()));
        System.out.println("Apellido: ".concat(usuario.getApellido()));
        System.out.println("Contraseña: ".concat(passwordEncode.encode(usuario.getContrasena())));
        if (usuario.getDireccion() == null) {
            usuario.setDireccion("");
            System.out.println("Dirección: ".concat(usuario.getDireccion()));
        } else {
            System.out.println("Dirección: ".concat(usuario.getDireccion()));
        }
        usuario.setCodigo("");
        System.out.println("Código: ".concat(usuario.getCodigo()));
        usuario.setIdRol(rol);
        System.out.println("Rol: ".concat(String.valueOf(usuario.getIdRol().getIdRol())));
        return "redirect:/";
    }
}
