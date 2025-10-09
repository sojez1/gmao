import axios from 'axios';

export const gmaoApi = axios.create({
    baseURL: 'http://localhost:8085',
    headers: {
        'Content-Type': 'application/json',
    }
});


