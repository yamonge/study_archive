import { useState } from "react";

const API_BASE_URL = "http://localhost:8080/api";

function RemoteControl() {
  const [sensorValue, setSensorValue] = useState(null);
  const [led1, setLed1] = useState(false);
  const [led2, setLed2] = useState(false);
  const [error, setError] = useState("");

  const request = async (path, method = "GET") => {
    const response = await fetch(`${API_BASE_URL}${path}`, {
      method,
    });

    if (!response.ok) {
      throw new Error(`API 요청 실패: ${response.status}`);
    }

    return response.text();
  };

  const readSensor = async () => {
    try {
      setError("");

      const text = await request("/sensor");

      // SENSOR_VALUE=123에서 123만 분리
      const value = text.split("=")[1];

      setSensorValue(Number(value));
    } catch (err) {
      setError(err.message);
    }
  };

  const clickButton1 = async () => {
    try {
      setError("");

      const text = await request("/remote/button1", "POST");

      setLed1(text === "LED1=ON");
    } catch (err) {
      setError(err.message);
    }
  };

  const clickButton2 = async () => {
    try {
      setError("");

      const text = await request("/remote/button2", "POST");

      setLed2(text === "LED2=ON");
    } catch (err) {
      setError(err.message);
    }
  };

  const clickPower = async () => {
    try {
      setError("");

      const text = await request("/remote/power", "POST");

      // 응답 예시: LED1=ON;LED2=ON
      const states = text.split(";");

      setLed1(states[0] === "LED1=ON");
      setLed2(states[1] === "LED2=ON");
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <main>
      <h1>가상 IR 리모컨</h1>

      <section>
        <h2>센서</h2>

        <p>
          센서 값: {sensorValue === null ? "아직 측정하지 않음" : sensorValue}
        </p>

        <button type="button" onClick={readSensor}>
          센서 값 읽기
        </button>
      </section>

      <section>
        <h2>리모컨</h2>

        <button type="button" onClick={clickButton1}>
          1번
        </button>

        <button type="button" onClick={clickButton2}>
          2번
        </button>

        <button type="button" onClick={clickPower}>
          전원
        </button>
      </section>

      <section>
        <h2>LED 상태</h2>

        <p>LED1: {led1 ? "켜짐" : "꺼짐"}</p>
        <p>LED2: {led2 ? "켜짐" : "꺼짐"}</p>
      </section>

      {error && <p>{error}</p>}
    </main>
  );
}

export default RemoteControl;
