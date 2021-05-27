var formulario = document.getElementById("formularioRegistro");
if (formulario !== null) {
    formulario.addEventListener("submit", function (e) {
        e.preventDefault();
        /*REGISTRO*/
        var correo = document.getElementById("correoRegistro").value;
        var correoErr = document.getElementById("lblcorreoErr");
        const emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
        if (emailRegex.test(correo)) {
            if (correoErr.classList.contains("spanMostrar")) {
                correoErr.classList.toggle("spanMostrar");
            }
        } else {
            if (!correoErr.classList.contains("spanMostrar")) {
                correoErr.classList.toggle("spanMostrar");
            }
            return false;
        }

        var nombre = document.getElementById("inputNombreR").value;
        var nombreErr1 = document.getElementById("lblNombreErr1");
        var nombreErr2 = document.getElementById("lblNombreErr2");
        const numberRegex = /^[a-zA-Z\ ]+$/;

        if (nombre.length <= 2) {
            if (!nombreErr1.classList.contains("spanMostrar")) {
                nombreErr1.classList.toggle("spanMostrar");
            }
            return false;
        } else {
            if (nombreErr1.classList.contains("spanMostrar")) {
                nombreErr1.classList.toggle("spanMostrar");
            }
        }
        if (numberRegex.test(nombre)) {
            if (nombreErr2.classList.contains("spanMostrar")) {
                nombreErr2.classList.toggle("spanMostrar");
            }
        } else {
            if (!nombreErr2.classList.contains("spanMostrar")) {
                nombreErr2.classList.toggle("spanMostrar");
            }
            return false;
        }

        ////////////////////////////////////
        var apellido = document.getElementById("apellidoRegistro").value;
        var apellidoErr1 = document.getElementById("lblApellidoErr1");
        var apellidoErr2 = document.getElementById("lblApellidoErr2");
        if (apellido.length <= 2) {
            if (!apellidoErr1.classList.contains("spanMostrar")) {
                apellidoErr1.classList.toggle("spanMostrar");
            }
            return false;
        } else {
            if (apellidoErr1.classList.contains("spanMostrar")) {
                apellidoErr1.classList.toggle("spanMostrar");
            }
        }
        if (numberRegex.test(apellido)) {
            if (apellidoErr2.classList.contains("spanMostrar")) {
                apellidoErr2.classList.toggle("spanMostrar");
            }
        } else {
            if (!apellidoErr2.classList.contains("spanMostrar")) {
                apellidoErr2.classList.toggle("spanMostrar");
            }
            return false;
        }
        //////////////////CONTRASEÑA//////////
        var pass = document.getElementById("pass2").value;
        var passErr1 = document.getElementById("lblpass2Err1");
        var passErr2 = document.getElementById("lblpass2Err2");
        if (numberRegex.test(pass)) {
            if (!passErr2.classList.contains("spanMostrar")) {
                passErr2.classList.toggle("spanMostrar");
            }
            return false;
        } else {
            if (passErr2.classList.contains("spanMostrar")) {
                passErr2.classList.toggle("spanMostrar");
            }
        }
        if (pass.length <= 2) {
            if (!passErr1.classList.contains("spanMostrar")) {
                passErr1.classList.toggle("spanMostrar");
            }
            return false;
        } else {
            if (passErr1.classList.contains("spanMostrar")) {
                passErr1.classList.toggle("spanMostrar");
            }
        }


        /*REGISTRO*/
        this.submit();
    });
}
//RECUPERAR CONTRASEÑA
var formulario = document.getElementById("formRecup");
if (formulario !== null) {
    formulario.addEventListener("submit", function (e) {
        e.preventDefault();
        var correo = document.getElementById("inpRecuperar").value;
        var correoErr = document.getElementById("correoRecup");
        const emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
        if (emailRegex.test(correo)) {
            if (correoErr.classList.contains("spanMostrar")) {
                correoErr.classList.toggle("spanMostrar");
            }
        } else {
            if (!correoErr.classList.contains("spanMostrar")) {
                correoErr.classList.toggle("spanMostrar");
            }
            return false;
        }
        this.submit();
    });
}


