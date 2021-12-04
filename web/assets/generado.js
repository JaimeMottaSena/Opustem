/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function Generar(){
    var numero="1234567890" 
    var letras="abcdefjhijklopqrstuwxyz"
    
  
    var todo=numero + letras;
    var tam=10;
    var pass="";

    for( var i=0;i<tam; i++){
        var aleatorio= Math.floor(Math.random()*todo.length);
        pass += todo.substring(aleatorio,aleatorio+ 1);

    }
    document.getElementById('textClave').value=pass;
}

function Mostrar(){
                    var tipo= document.getElementById('textClave')
                    
                    if(tipo.type == 'password'){
                        tipo.type='text'
                    }else{
                        tipo.type='password'
                    }
                }