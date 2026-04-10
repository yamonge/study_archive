import "./App.css";
import MyMap from "./2026/04/09/MyMap";
function App() {
  return (
    <div
      style={{
        width: "100%",
        padding: "100px 100px",
      }}
    >
      <MyMap lat={37.52112} lng={127.1283636} />
    </div>
  );
}

export default App;
