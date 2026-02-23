import { useEffect, useState } from "react";
import { getProducts } from "../services/productService";

export default function Products() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    getProducts().then((response) => {
      setProducts(response.data);
    });
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Produtos</h1>

      <ul>
        {products.map((p) => (
          <li key={p.id}>
            {p.name} — R$ {p.price}
          </li>
        ))}
      </ul>
    </div>
  );
}
