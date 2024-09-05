// 1 
const userInfo = document.getElementById("userInfo")

async function fetchUser(){
const response = await fetch("https://randomuser.me/api/");
const data = await response.json();

const persona = data.results[0]

const nombre = persona.name.first +" "+ persona.name.last
const ubicacion = persona.location.city+", "+persona.location.state
const urlImagen = persona.picture.thumbnail

userInfo.innerHTML = '<p> Nombre: '+nombre+' </p> <p> Ubicacion: '+ubicacion+'</p> <img src='+urlImagen+' width=100/>'
}

 fetchUser();
