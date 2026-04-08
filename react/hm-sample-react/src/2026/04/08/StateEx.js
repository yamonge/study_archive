// 이름, 회사, 주소, 이메일 입력 받아 제출 버튼을 누르면 정보를 화면에 표시 하기

import React, { useState } from "react";

const StateEx = () => {
  const data = {
    name: "",
    company: "",
    addr: "",
    email: "",
  };
  const [userInfo, setUserInfo] = useState(data);
  const [userList, setUserList] = useState([]);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserInfo((prev) => ({ ...prev, [name]: value }));
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    setUserList((prevList) => [...prevList, userInfo]);
    setUserInfo(data);
  };

  return (
    <>
      {userList.map((unit, index) => {
        return <pre>{JSON.stringify(unit, null, 2)}</pre>;
      })}
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          value={userInfo.name}
          onChange={handleChange}
          placeholder="이름을 입력해주세요."
        ></input>
        <br />
        <input
          type="text"
          name="company"
          value={userInfo.company}
          onChange={handleChange}
          placeholder="회사를 입력해주세요."
        ></input>
        <br />
        <input
          type="text"
          name="addr"
          value={userInfo.addr}
          onChange={handleChange}
          placeholder="주소를를 입력해주세요."
        ></input>
        <br />
        <input
          type="email"
          name="email"
          value={userInfo.email}
          onChange={handleChange}
          placeholder="이메일을 입력해주세요."
        ></input>
        <br />
        <input type="submit"></input>
      </form>
    </>
  );
};

export default StateEx;
