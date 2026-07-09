import { useEffect, useState } from "react";

function App() {
  const [statusList, setStatusList] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/equipment/status")
      .then((res) => res.json())
      .then((data) => {
        setStatusList(data);
        setLoading(false);
      })
      .catch(() => {
        setError("데이터를 불러오지 못했습니다.");
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <div>로딩 중입니다...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div style={{ padding: "30px" }}>
      <h1>설비 상태 대시보드</h1>

      {statusList.length === 0 ? (
        <p>등록된 설비 상태가 없습니다.</p>
      ) : (
        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>설비 ID</th>
              <th>상태</th>
              <th>메시지</th>
            </tr>
          </thead>
          <tbody>
            {statusList.map((item, index) => (
              <tr key={index}>
                <td>{item.equipmentId}</td>
                <td>{item.state}</td>
                <td>{item.message}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default App;
