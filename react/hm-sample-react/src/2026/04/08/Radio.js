import React, { useState } from "react";

const Radio = () => {
  const [val, setVal] = useState("");

  return (
    <>
      <div>
        <label htmlFor="apple">
          <input
            type="radio"
            name="fruits"
            id="apple"
            value="apple"
            onChange={(e) => setVal(e.target.value)}
          />
          사과
        </label>
        <label htmlFor="orange">
          <input
            type="radio"
            name="fruits"
            id="orange"
            value="orange"
            onChange={(e) => setVal(e.target.value)}
          />
          오렌지
        </label>
        <label htmlFor="melon">
          <input
            type="radio"
            name="fruits"
            id="melon"
            value="melon"
            onChange={(e) => setVal(e.target.value)}
          />
          멜론
        </label>
      </div>
      <div>선택된 과일: {val}</div>
    </>
  );
};

export default Radio;
