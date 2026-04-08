import React, { useState } from "react";

const DropDown = () => {
  const [val, setVal] = useState("");

  return (
    <>
      <h2>드롭다운 예제</h2>
      <select value={val} onChange={(e) => setVal(e.target.value)}>
        <option value="" disabled>
          과일을 선택 하세요.
        </option>
        <option value="apple">사과</option>
        <option value="banana">바나나</option>
        <option value="grape">포도</option>
        <option value="watermelon">수박</option>
      </select>
      <h3>선택된 과일 : {val}</h3>
    </>
  );
};

export default DropDown;
