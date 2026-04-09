import styled, { css } from "styled-components";

export const Container = styled.div`
  padding: ${(props) => props.padding || "0px"};
  height: ${(props) => props.height};
  width: ${(props) => props.width};
  ${(props) =>
    props.$parents &&
    css`
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 20px;
    `}
  ${(props) =>
    props.$is_secDiv &&
    css`
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 20px;
    `}
  ${(props) =>
    props.$is_third_div &&
    css`
      border: 1px black solid;
      border-radius: 20px;
      background: ${(props) => props.background};
    `}
`;

export const Button = styled.button`
  flex: 1;
  padding: 15px 25px;
  color: white;
  background: ${(props) => props.background};
  cursor: pointer;
  border: none;
  & + button {
    margin-left: 15px;
  }
`;
