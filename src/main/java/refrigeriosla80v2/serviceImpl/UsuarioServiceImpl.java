/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrigeriosla80v2.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import refrigeriosla80v2.dao.UsuarioDao;
import refrigeriosla80v2.entities.Usuario;
import refrigeriosla80v2.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioDao serviceDao;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

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

    //CORREOS
    public void sendEmailRegistro(Usuario usuario, String subject) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("svallejo878@misena.edu.co");
        helper.setTo(usuario.getCorreo());
        helper.setSubject(subject);
        //Envio plantilla
        Context context = new Context();
        context.setVariable("user", "dali"); //ACÁ SE ASIGNAN LAS VARIABLES, SE PUEDE PASAR EL OBJETO ENTERO PARA RECORRERLO Y EN LA PLANTILLA SE LLAMA NORMAL ${NOMBRE}
        context.setVariable("nombre",usuario.getNombre()+" "+usuario.getApellido());
        context.setVariable("correo",usuario.getCorreo());
        String emailContent = templateEngine.process("plantillaRegistro", context);
        helper.setText(emailContent, true);
        mailSender.send(message);
    }
}
