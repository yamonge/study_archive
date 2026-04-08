import React from "react";
import styles from "./JsxBaisc.module.css";

const JsxBasic = () => {
  // api 로 얻어옴
  const name = "홍길동";
  const addr = "충남 천안시";
  const gender = "남성";
  const age = 30;
  const loding = false;

  const users = {
    name: name,
    addr: addr,
    gender: gender,
    age: age,
    loding: loding,
  };

  return (
    <>
      <h2>JSX 기본 문법 공부</h2>
      <h4 className={styles.username}>{name}</h4>
      <h4>{users["addr"]}</h4>
      {users["age"] > 20 ? <h4>true</h4> : <h4>false</h4>}
    </>
  );
};

export default JsxBasic;
