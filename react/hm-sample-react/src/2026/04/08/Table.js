// 이름 , 전화번호, 나이,  직업으로 구성된 10개의 배열을 생성
// table 형태로 구성 해 출력
// map사용

import React, { useState, useEffect } from "react";

const data = {
  name: "",
  phone: "",
  age: 0,
  job: "",
};

const Table = () => {
  const handleTableRowClick = (member) => {
    alert(`${member.name} 이 눌러졌습니다.`);
  };

  const [userList, setUserList] = useState([]);

  useEffect(() => {
    const makeUser = () => {
      const newUsers = Array.from({ length: 10 }, (_, i) => {
        return {
          ...data,
          name: `테스트유저${i + 1}`,
          phone: `010-1111-222${i}`,
          age: 25 + i,
          job: `직업${i}`,
        };
      });
      setUserList(newUsers);
    };

    makeUser();
  }, []);

  return (
    <>
      <table border={1}>
        <thead>
          <tr>
            <th>이름</th>
            <th>전화번호</th>
            <th>나이</th>
            <th>직업</th>
          </tr>
        </thead>
        <tbody>
          {userList.map((user, index) => {
            return (
              <tr key={index} onClick={() => handleTableRowClick(user)}>
                <td>{user.name}</td>
                <td>{user.phone}</td>
                <td>{user.age}</td>
                <td>{user.job}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </>
  );
};

export default Table;
