import React, { useState, useEffect } from "react";

const EffectInfo = () => {
  const [name, setName] = useState("");
  const [nickname, setNickname] = useState("");

  useEffect(() => {
    console.log("렌더링이 완료되었습니다.");
    console.log(`${name} ${nickname}`);
  });

  return (
    <>
      <div>
        <input
          type="text"
          onChange={(e) => setName(e.target.value)}
          value={name}
        />
        <br />
        <input
          type="text"
          onChange={(e) => setNickname(e.target.value)}
          value={nickname}
        />
      </div>
      <div>
        <p>이름 : {name}</p>
        <p>닉네임 : {nickname}</p>
      </div>
    </>
  );
};

export default EffectInfo;
