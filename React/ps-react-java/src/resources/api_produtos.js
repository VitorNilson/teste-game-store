import axios from 'axios'

// Consome endpoint todos os produtos
const api = axios.create({

    baseURL: 'http://localhost:8080/produtos'
})

export default api;