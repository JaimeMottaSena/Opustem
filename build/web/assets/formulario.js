/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
	textUsuario: /^[a-zA-Z0-9\_\-]{4,10}$/, // Letras, numeros, guion y guion_bajo
	textNombre: /^[a-zA-ZÀ-ÿ\s]{4,15}$/,
	textApellido:/^[a-zA-ZÀ-ÿ\s]{4,15}$/,
	textCorreo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, // Letras y espacios, pueden llevar acentos.
	textClave: /^.{4,20}$/, 
	textDireccion:/^[A-Za-z-0-99999999'\d{1,5}\s\w.\s(\b\w*\b\s){1,2}\w*\.]{4,15}$/,// 
	textDocumento:/^\d{10}$/, 
	textTelefono: /^\d{7,10}$/ //  10 numeros.
}

const campos = {
	textUsuario:  false,
	textNombre: false,
	textApellido: false,
	textCorreo: false,
	textClave: false,
	textDireccion:false,
	textDocumento:false,
	textTelefono:false,
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "textUsuario":
			validarCampo(expresiones.textUsuario, e.target, 'usuario');
		break;
		case "textNombre":
			validarCampo(expresiones.textNombre, e.target, 'nombre');
		break;
		case "textApellido":
			validarCampo(expresiones.textApellido, e.target, 'apellido');
			validarPassword2();
		break;
		
		case "textCorreo":
			validarCampo(expresiones.textCorreo, e.target, 'correo');
		break;
		case "textClave":
			validarCampo(expresiones.textClave, e.target, 'password');
		break;

		case "textDocumento":
			validarCampo(expresiones.textDocumento, e.target, 'numerodoc');
		break;

		case "textDireccion":
			validarCampo(expresiones.textDireccion, e.target, 'direccion');
		break;

		case "textTelefono":
			validarCampo(expresiones.textTelefono, e.target, 'telefono');
		break;
	}
}

const validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value)){
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos[campo] = true;
	} else {
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos[campo] = false;
	}
}

inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

formulario.addEventListener('submit', (e) => {
	

	const terminos = document.getElementById('terminos');
	if(campos.textUsuario && campos.textNombre && campos.textApellido && campos.textCorreo && campos.textClave  &&  campos.textDireccion&& campos.textDocumento&&campos.textTelefono&& terminos.checked ){
		formulario.reset();

		
	} 
}); 