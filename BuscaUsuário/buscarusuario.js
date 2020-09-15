let userName = document.querySelector('input#username');
let btnBuscar = document.querySelector('button#btnbuscar');
let displayElement = document.querySelector('div#display')

btnBuscar.onclick = () => {
    let buscarUsuario =  () => {
        return new Promise( (resolve, reject) => {
            let xhr = new XMLHttpRequest(); // inicia o AJAX
            xhr.open('GET', `http://api.github.com/users/${userName.value}/repos`);
            xhr.send(null);
    
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4) {
                    let loadingInfo = () => {
                        let mensage = document.createElement('ul')
                        displayElement.appendChild(mensage)
                        let _mensage = document.createElement('li')
                        _mensage.innerHTML = 'Carregando...'
                        mensage.appendChild(_mensage)
                        mensage.setAttribute('id', 'loadTemp')
                        } 
                    loadingInfo()
                    if (xhr.status === 200) { 
                        
                        resolve(JSON.parse(xhr.responseText),); // Caso o resultado retorne true, vai chamar o .then
                        
                    } else if ( xhr.status === 404) {
                        reject('Usuário Não')
                    }else {
                        reject('Erro na Requisição'); // chama o método .cath 
                    }
                    
                }
            }
        });
    
    }
    

    buscarUsuario()
        .then(function (response) { // Envocado caso a requisição do resolve seja feita (status voltar verdadeiro)
           // console.log(response[1].full_name)
           setTimeout(() => {
            let repositorios = response
            let lista;
            let _lista = document.createElement('ul') 
            displayElement.appendChild(_lista)
            for (lista of repositorios){
                 let iten = document.createElement('li')
                 _lista.appendChild(iten)
                 iten.innerHTML = JSON.stringify(lista.full_name)
                 
            }
           },1000)
           setTimeout(() => {
            let paraDeletar = document.querySelector('ul#loadTemp')
            displayElement.removeChild(paraDeletar)
        },1000)
        

        }) //Não finalizar com ponto e virgula nesse trecho
        .catch(function (error) {
            console.warn(error)
        })
        
    let jsonElement = document.createElement('p')
    displayElement.append(jsonElement)
}  

