var iniciarSesion = document.getElementById("iniciarSesion");
var registrarse = document.getElementById("registrarse");
var iniciarSesionRegistro = document.getElementById("iniciarSesionRegistro");
var recuperar = document.getElementById("recuperar");
var iniciarRecuperar = document.getElementById("iniciarRecuperar");
var registrarseRecuperar = document.getElementById("registrarseRecuperar");


//MODALES
var contenedorModal = document.getElementById("contenedorModal");
var modalSesion = document.getElementById("modalSesion");
var modalRegistro = document.getElementById("modalRegistro");
var modalRecuperar = document.getElementById("modalRecuperar");

if (iniciarSesion !== null) {
    iniciarSesion.addEventListener("click", function () {
        if (modalRegistro.classList.contains("modalVisible")) {
            modalRegistro.classList.toggle("modalVisible");
        }
        contenedorModal.classList.toggle("contenedorModalesMostrar");
        modalSesion.classList.toggle("modalVisible");
    });
}
if (registrarse !== null) {
    registrarse.addEventListener("click", function () {
        if (modalSesion.classList.contains("modalVisible")) {
            modalSesion.classList.toggle("modalVisible");
        }
        modalRegistro.classList.toggle("modalVisible");
    });
}
if (iniciarSesionRegistro !== null) {
    iniciarSesionRegistro.addEventListener("click", function () {
        if (modalRegistro.classList.contains("modalVisible")) {
            modalRegistro.classList.toggle("modalVisible");
        }
        modalSesion.classList.toggle("modalVisible");
    });
}
if (recuperar !== null) {
    recuperar.addEventListener("click", function () {
        if (modalSesion.classList.contains("modalVisible")) {
            modalSesion.classList.toggle("modalVisible");
        }
        modalRecuperar.classList.toggle("modalVisible");
    });
}
if (iniciarRecuperar !== null) {
    iniciarRecuperar.addEventListener("click", function () {
        if (modalRecuperar.classList.contains("modalVisible")) {
            modalRecuperar.classList.toggle("modalVisible");
        }
        modalSesion.classList.toggle("modalVisible");
    });
}
if (registrarseRecuperar !== null) {
    registrarseRecuperar.addEventListener("click", function () {
        if (modalRecuperar.classList.contains("modalVisible")) {
            modalRecuperar.classList.toggle("modalVisible");
        }
        modalRegistro.classList.toggle("modalVisible");
    });
}
window.addEventListener("click", function (e) {
    if (e.target == contenedorModal) {
        if (modalSesion.classList.contains("modalVisible")) {
            modalSesion.classList.toggle("modalVisible");
        } else if (modalRegistro.classList.contains("modalVisible")) {
            modalRegistro.classList.toggle("modalVisible");
        } else if (modalRecuperar.classList.contains("modalVisible")) {
            modalRecuperar.classList.toggle("modalVisible");
        }
        contenedorModal.classList.toggle("contenedorModalesMostrar");
    }
});

//EFECTO DE VISUALIZACIÓN DE CONTRASEÑA
//inputs
var inputSesion = document.getElementById("pass");
var inputRegistro = document.getElementById("pass2");
//Checks
var visualizarSesion = document.getElementById("eyeUpS");
var visualizarRegistro = document.getElementById("eyeUp");
if (visualizarSesion !== null) {
    visualizarSesion.addEventListener("click", function () {
        if (visualizarSesion.classList.contains("fa-eye-slash")) {
            inputSesion.type = "password";
        } else {
            inputSesion.type = "text";
        }
        visualizarSesion.classList.toggle("fa-eye-slash");
    });
}
if (visualizarRegistro !== null) {
    visualizarRegistro.addEventListener("click", function () {
        if (visualizarRegistro.classList.contains("fa-eye-slash")) {
            inputRegistro.type = "password";
        } else {
            inputRegistro.type = "text";
        }
        visualizarRegistro.classList.toggle("fa-eye-slash");
    });
}