import styled, { css } from "styled-components";

export const Container = styled.div`
  height: ${(props) => props.h || "100%"};
  width: ${(props) => props.w || "100%"};
  padding: ${(props) => props.p || "0px"};
  margin: ${(props) => props.m || "0px"};
  border: ${(props) => props.b || "none"};
  border-radius: ${(props) => props.br || "0px"};
  display: flex;
  ${(props) =>
    props.$a1 &&
    css`
      justify-content: space-evenly;
    `}
`;

export const Form = styled.form`
  border: ${(props) => props.b || "none"};
  border-radius: ${(props) => props.br || "0px"};
  width: ${(props) => props.w || "100%"};
  height: ${(props) => props.h || "100%"};
  ${(props) =>
    props.$f1 &&
    css`
      display: flex;
      flex-direction: column;
      align-items: center;
    `}
`;

export const Button = styled.button`
  height: ${(props) => props.h};
  width: ${(props) => props.w};
  padding: ${(props) => props.p};
  margin: ${(props) => props.m};
  border: ${(props) => props.b};
  border-radius: ${(props) => props.br};
  background-color: ${(props) => props.bgc};
  color: ${(props) => props.fc};
`;
