import { useEffect, useState } from "react";

function App() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/products")
      .then(response => response.json())
      .then(data => setProducts(data))
      .catch(error => console.error("Erro ao buscar produtos:", error));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Produtos</h1>

      <ul>
        {products.map(product => (
          <li key={product.id}>
            {product.name} — {product.price}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
