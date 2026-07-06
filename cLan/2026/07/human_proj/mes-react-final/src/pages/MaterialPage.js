import React, { useState, useEffect } from "react";
import MesApi from "../api/MesApi";
import styled from "styled-components";

const Container = styled.div`
  padding: 30px;
  background: white;
  border-radius: 10px;
`;
const InputGroup = styled.div`
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
`;
const Input = styled.input`
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
  flex: 1;
`;
const Button = styled.button`
  padding: 10px 20px;
  background: #27ae60;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
`;
const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
  th,
  td {
    padding: 12px;
    border-bottom: 1px solid #eee;
  }
  th {
    background: #f8f9fa;
    text-align: left;
  }
`;

const MaterialPage = () => {
  const [materials, setMaterials] = useState([]);
  const [form, setForm] = useState({ code: "", name: "", amount: 0 });

  const fetchMaterials = async () => {
    try {
      const res = await MesApi.getMaterials();
      setMaterials(res.data);
    } catch (e) {
      console.error(e);
    }
  };

  useEffect(() => {
    fetchMaterials();
  }, []);

  const handleInbound = async () => {
    if (!form.code || form.amount <= 0) return alert("입력 값을 확인하세요.");
    try {
      await MesApi.inboundMaterial(form);
      alert(`✅ ${form.name} ${form.amount}개 입고 완료`);
      fetchMaterials();
      setForm({ ...form, amount: 0 });
    } catch (e) {
      alert("입고 실패");
    }
  };

  return (
    <Container>
      <h2>📦 자재 입고 (Warehousing)</h2>
      <InputGroup>
        <Input
          placeholder="자재코드 (예: MAT-SCREW)"
          value={form.code}
          onChange={(e) => setForm({ ...form, code: e.target.value })}
        />
        <Input
          placeholder="자재명 (예: 티타늄 나사)"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
        />
        <Input
          type="number"
          placeholder="수량"
          value={form.amount}
          onChange={(e) =>
            setForm({ ...form, amount: parseInt(e.target.value) || 0 })
          }
        />
        <Button onClick={handleInbound}>입고 처리</Button>
      </InputGroup>

      <h3>재고 현황표</h3>
      <Table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Code</th>
            <th>Name</th>
            <th>Stock</th>
          </tr>
        </thead>
        <tbody>
          {materials.map((m) => (
            <tr key={m.id}>
              <td>{m.id}</td>
              <td>{m.code}</td>
              <td>{m.name}</td>
              <td
                style={{
                  color: m.currentStock < 10 ? "red" : "green",
                  fontWeight: "bold",
                }}
              >
                {m.currentStock} EA
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};
export default MaterialPage;
