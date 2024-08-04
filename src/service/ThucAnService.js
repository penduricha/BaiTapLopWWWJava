import axios from 'axios';

const apiClient = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Content-Type': 'application/json'
    }
});

// Các hàm API khác
export default {
    getThucAns() {
        return apiClient.get('/thucans');
    },
    createThucAn(thucAn) {
        return apiClient.post('/thucans', thucAn);
    },
    getThucAnById(id) {
        return apiClient.get(`/thucans/${id}`);
    },
    putThucAnById(id, thucAn) {
        return apiClient.put(`/thucans/${id}`, thucAn);
    },
    deleteThucAnById(id) {
        return apiClient.delete(`/thucans/${id}`);
    }
};