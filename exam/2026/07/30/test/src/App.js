import { useEffect, useState } from "react";

function App() {
  const [equipmentList, setEquipmentList] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    const apiUrl = process.env.REACT_APP_API_URL;

    fetch(`${apiUrl}/api/equipment`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("설비 데이터 조회 실패");
        }

        return response.json();
      })
      .then((data) => {
        setEquipmentList(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []);

  return (
    <main>
      <h1>MES 설비 현황</h1>

      {error && <p>{error}</p>}

      <table border="1">
        <thead>
          <tr>
            <th>설비 번호</th>
            <th>설비명</th>
            <th>상태</th>
            <th>생산수량</th>
          </tr>
        </thead>

        <tbody>
          {equipmentList.map((equipment) => (
            <tr key={equipment.id}>
              <td>{equipment.id}</td>
              <td>{equipment.equipmentName}</td>
              <td>{equipment.status}</td>
              <td>{equipment.productionCount}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </main>
  );
}

export default App;
