let listElement = document.querySelector('div#app ul');
let inputElement = document.querySelector('div#app input');
let btnElement = document.querySelector('div#app button');

let todos =  JSON.parse(localStorage.getItem('lista_todos')) || [] ;

let renderTodos = () => {
    listElement.innerHTML ='';

    for (todo of todos) {
        let todoElement = document.createElement('li');
        let todoText = document.createTextNode(todo);
        let linkElement = document.createElement('a');

        linkElement.setAttribute('href', '#');
        let linkText = document.createTextNode(' Excluir');
        let pos = todos.indexOf(todo)
        linkElement.setAttribute('onclick', 'deleteTodo(' + pos + ')')

        linkElement.appendChild(linkText);
        todoElement.appendChild(todoText);
        todoElement.appendChild(linkElement);
        listElement.appendChild(todoElement);
        
    }
}

renderTodos();

let addTodo = () => {
    let todoText = inputElement.value
    todos.push(todoText);
    inputElement.value = ''
    renderTodos()
    saveToStorage();
}

btnElement.onclick = addTodo

let deleteTodo = (pos) => {
    todos.splice(pos, 1);
    renderTodos();
    saveToStorage();
}

let saveToStorage = () => {
    localStorage.setItem('lista_todos', JSON.stringify(todos));
}