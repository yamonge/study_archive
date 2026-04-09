import { Button, Container } from "./Style_Ex1_1";
import React, { useState } from "react";

const Style_Ex1 = () => {
  const [color, setColor] = useState("");

  const handleClick = (color) => {
    setColor(color);
  };

  return (
    <>
      <Container $parents={true} padding={"0px"} width={"100%"}>
        <Container $is_secDiv={true} padding={"0px"} width={"60%"}>
          <Button background={"green"} onClick={() => handleClick("green")}>
            Green
          </Button>
          <Button background={"orange"} onClick={() => handleClick("orange")}>
            Orange
          </Button>
          <Button background={"purple"} onClick={() => handleClick("purple")}>
            Purple
          </Button>
        </Container>
        <Container
          $is_third_div={true}
          padding={"0px"}
          height={"500px"}
          width={"60%"}
          background={color}
        ></Container>
      </Container>
    </>
  );
};

export default Style_Ex1;
