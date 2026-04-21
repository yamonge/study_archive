import "./App.css";
import Exam2 from "./2026/04/21/Exam2";
import styled, { css } from "styled-components";

const Container = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

function App() {
  return (
    <Container>
      <Exam2 />
    </Container>
  );
}

export default App;
