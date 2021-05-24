import axios from 'axios'

// Consome endpoint preço total dos itens no carrinho
const apiTotalPrice = axios.create({

    baseURL: 'http://localhost:8080/carrinho/total-value'
})

export default apiTotalPrice;