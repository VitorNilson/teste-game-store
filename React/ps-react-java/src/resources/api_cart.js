import axios from 'axios'

// Consome endpoint produtos no carrinho
const apiCart = axios.create({

    baseURL: 'http://localhost:8080/produtos/carrinho'
})

export default apiCart;