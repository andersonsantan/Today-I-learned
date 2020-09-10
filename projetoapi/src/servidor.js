const porta = 3003 

const express = require('express')
const app = express()
const bodyParser = require('body-parser')
const bancoDeDados = require('./bancoDeDados')

app.use(bodyParser.urlencoded({ extended: true }))// qualquer requisição que receber vai 
//transformar dados urlencoded em JSON

app.get('/produtos', (req, res, next) => {//Função Middlay
    res.send(bancoDeDados.getProdutos()) // O método send converte para o formato JSON
})

app.get('/produtos/:id', (req, res, next) => { // parans é o parametro 'id'
    res.send(bancoDeDados.getProduto(req.params.id))
})

app.post('/produtos', (req, res, next) =>{
    const produto = bancoDeDados.salvarProduto ({
        nome: req.body.nome,
        preco: req.body.preco
    })
    res.send(produto) // Enviaresposta no formato JSON
})

app.delete ('/produtos/:id', (req, res, next) => {
    const produto = bancoDeDados.excluirProduto(req.params.id)
    res.send(produto)
})

app.listen(porta, () => {// listem faz o servidor ficar escutando a porta todo o tempo
    console.log(`Servidor excutando na porta ${porta}`);//Função Callback para retornar se o funcionamento está ok
})


