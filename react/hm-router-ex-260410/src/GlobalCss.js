import styled, { createGlobalStyle, css } from "styled-components";

export const Global = createGlobalStyle`
  *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  body{
    background-color: #f5f5f5;
  }

  a{
    text-decoration: none;
    color: inherit;
  }

  button{
    cursor: pointer;
    border: none;
  }
`;
