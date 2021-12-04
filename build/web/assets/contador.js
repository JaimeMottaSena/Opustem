/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var adf= document.getElementById('adf').value



function cambio(){
    if(adf=="Activar"){
        adf.classList.add('btn btn-danger')
        contador=1;
    }
    else{
        adf.classList.remove('btn btn-danger')
        contador=0;
    }
    
}
adf.addEventListener('click',cambio,true)
