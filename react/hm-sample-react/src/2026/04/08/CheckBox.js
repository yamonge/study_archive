import React, { useState } from "react";

const CheckBox = () => {
  const [val, setVal] = useState([]);
  const handleCheck = (e) => {
    const { value, checked } = e.target;

    setVal((prev) => {
      if (checked) {
        return [...prev, value];
      } else {
        return prev.filter((item) => item !== value);
      }
    });
  };

  return (
    <>
      <input
        type="checkbox"
        name="fruits"
        value="apple"
        onClick={handleCheck}
      />
      사과
      <input
        type="checkbox"
        name="fruits"
        value="banana"
        onClick={handleCheck}
      />
      바나나
      <input
        type="checkbox"
        name="fruits"
        value="melon"
        onClick={handleCheck}
      />
      멜론
      <div>선택된 과일들 : {val.join(", ")}</div>
    </>
  );
};

export default CheckBox;
