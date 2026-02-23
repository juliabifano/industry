import axios from "axios";

const API_URL = "http://localhost:8080/products";

export const getProducts = () => axios.get(API_URL);
export const createProduct = (data) => axios.post(API_URL, data);
