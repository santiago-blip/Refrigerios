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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import refrigeriosla80v2.entities.Carrito;
import refrigeriosla80v2.entities.Rol;
import refrigeriosla80v2.entities.Usuario;
import refrigeriosla80v2.service.IUsuarioService;
import refrigeriosla80v2.serviceImpl.HiloSendEmail;
import refrigeriosla80v2.serviceImpl.UsuarioServiceImpl;

@Controller
public class AppController {

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private UsuarioServiceImpl usuarioServicePrueba;

    @RequestMapping(value = "/")
    public String index(Usuario usuario) {
        return "index";
    }

    @PostMapping("/registro")
    public String registro(Usuario usuario, RedirectAttributes flash) {
        if (usuarioService.buscarPorCorreo(usuario.getCorreo()) != null) {
            flash.addFlashAttribute("correoExiste", "Usuario ya registrado.");
            return "redirect:/";
        }
        Rol rol = new Rol();
        rol.setIdRol(2);
        if (usuario.getDireccion() == null) {
            usuario.setDireccion("");
        }
        usuario.setCodigo("");
        usuario.setIdRol(rol);
        Carrito carro = new Carrito();
        carro.setIdUsuario(usuario);
        usuario.setCarrito(carro);
        usuario.setContrasena(passwordEncode.encode(usuario.getContrasena()));
//        usuarioService.insertarUsuario(usuario);
        //Envio correo a través de un hilo.
        Thread hiloRegistro = new HiloSendEmail("Hilo registro", "Registro", usuario);
        hiloRegistro.start();
//        try {
//            usuarioServicePrueba.sendEmailRegistro(usuario, "Registro exitoso");
//            System.out.println("Correo enviado con exito");
//        } catch (Exception e) {
//            System.out.println("No se pudo enviar el correo por: " + e);
//        }
        flash.addFlashAttribute("registroExitoso", "Usuario ya registrado.");
        return "redirect:/";
    }
}
