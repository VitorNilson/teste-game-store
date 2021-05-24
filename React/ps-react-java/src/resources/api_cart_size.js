import axios from 'axios'

// Consome endpoint total de itens no carrinho
const apiCartSize = axios.create({

    baseURL: 'http://localhost:8080/produtos/carrinho/size'
})

export default apiCartSize;