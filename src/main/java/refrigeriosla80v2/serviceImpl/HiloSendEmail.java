/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrigeriosla80v2.serviceImpl;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refrigeriosla80v2.entities.Usuario;

public class HiloSendEmail extends Thread {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    private String nombreHilo;

    private String proceso;

    private Usuario usuario;

    public HiloSendEmail(String nombreHilo, String proceso, Usuario usuario) {
        super(nombreHilo);
        this.nombreHilo = nombreHilo;
        this.proceso = proceso;
        this.usuario = usuario;
    }

    @Override
    public void run() {
        switch (this.proceso) {
            case "Registro":
                    try {
                        this.usuarioService.sendEmailRegistro(this.usuario, "Registro exitoso");
                        System.out.println("Correo enviado con exito");
                        System.out.println("Nombre: "+this.usuario.getNombre() +" "+this.usuario.getApellido());
                        System.out.println("Correo: "+this.usuario.getCorreo());
                        System.out.println("Contraseña: "+this.usuario.getContrasena());
                    } catch (MessagingException e) {
                        System.out.println("No se pudo enviar el correo por: "+e);
                        System.out.println("Nombre: "+this.usuario.getNombre() +" "+this.usuario.getApellido());
                        System.out.println("Correo: "+this.usuario.getCorreo());
                        System.out.println("Contraseña: "+this.usuario.getContrasena());
                    }
            break;

            case "Pedido":
                 System.out.println("Pedido");
                break;
        }
    }

}
