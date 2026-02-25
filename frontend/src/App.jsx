import { useEffect, useState } from "react";

function App() {
  const [products, setProducts] = useState([]);
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [editingProduct, setEditingProduct] = useState(null);
  const [message, setMessage] = useState("");

  const fetchProducts = () => {
    fetch("http://localhost:8080/products")
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((err) => console.error("Erro:", err));
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  const addProduct = () => {
    fetch("http://localhost:8080/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name,
        price: parseFloat(price),
      }),
    }).then(() => {
      setMessage("Produto salvo com sucesso!");
      fetchProducts();
    });
  };

  const updateProduct = (product) => {
    fetch(`http://localhost:8080/products/${product.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(product),
    }).then(() => {
      setMessage("Produto salvo com sucesso!");
      fetchProducts();
    });
  };

  const deleteProduct = (id) => {
    fetch(`http://localhost:8080/products/${id}`, {
      method: "DELETE",
    }).then(() => {
      setMessage("Produto excluído com sucesso!");
      fetchProducts();
    });
  };

  return (
    <div>
      <h1>Produtos</h1>

      {message && <p>{message}</p>}

      <h3>Adicionar Produto</h3>
      <input
        placeholder="Nome"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        placeholder="Preço"
        value={price}
        onChange={(e) => setPrice(e.target.value)}
      />
      <button onClick={addProduct}>Salvar</button>

      <ul>
        {products.map((p) => (
          <li key={p.id}>
            {p.name} — R$ {p.price}
            <button onClick={() => setEditingProduct(p)}>Editar</button>
            <button onClick={() => deleteProduct(p.id)}>Deletar</button>
          </li>
        ))}
        {editingProduct && (
          <div>
            <h3>Editar produto</h3>

            <input
              value={editingProduct.name}
              onChange={(e) =>
                setEditingProduct({ ...editingProduct, name: e.target.value })
              }
            />

            <input
              type="number"
              value={editingProduct.price}
              onChange={(e) =>
                setEditingProduct({ ...editingProduct, price: e.target.value })
              }
            />

            <button onClick={() => updateProduct(editingProduct)}>
              Salvar
            </button>
          </div>
        )}
      </ul>
    </div>
  );
}

export default App;
