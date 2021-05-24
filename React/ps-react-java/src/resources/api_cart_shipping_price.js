import axios from 'axios'

// Consome endpoint preço total frete
const apiTotalShipping = axios.create({

    baseURL: 'http://localhost:8080/carrinho/total-frete'
})

export default apiTotalShipping;