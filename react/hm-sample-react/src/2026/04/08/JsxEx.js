import React, { useEffect, useState } from "react";
import Welcome from "./Welcome";
const JsxEx = (props) => {
  const style = {
    color: "white",
    background: "black",
    borderRadius: "5px",
    margin: "5px 30px",
    padding: "10px",
  };
  return (
    <>
      {props.members.length > 0 ? (
        props.members.map((item, index) => {
          const { name, job } = item;
          return (
            <>
              <h4>이름: {name}</h4>
              <h4>직업: {job}</h4>
              <Welcome name={name} />
            </>
          );
        })
      ) : (
        <h4>배열이 없습니다.</h4>
      )}
    </>
  );
};

export default JsxEx;
