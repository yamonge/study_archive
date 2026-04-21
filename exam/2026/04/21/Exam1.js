import React from "react";
import styled, { css } from "styled-components";

const Container = styled.div`
  width: ${(props) => props.w || "100%"};
  height: ${(props) => props.h || "100%"};
  background-color: ${(props) => props.bgc || "white"};
  padding: ${(props) => props.p || "0px"};
  margin: ${(props) => props.m || "0px"};
  border: ${(props) => props.b || "none"};
  border-radius: ${(props) => props.br || "0px"};
  display: ${(props) => props.display || "flex"};
  justify-content: ${(props) => props.justify};
  align-items: ${(props) => props.align};
  ${(props) =>
    props.$main &&
    css`
      flex-direction: column;
      width: 100%;
    `}
  ${(props) =>
    props.$a1 &&
    css`
      flex-direction: row;
      justify-content: space-evenly;
      width: 100%;
    `}
  ${(props) =>
    props.$a2 &&
    css`
      flex-direction: column;
      width: 50%;
      margin: auto 0;
    `}
    ${(props) =>
    props.$a3 &&
    css`
      flex-direction: column;
    `}
    ${(props) =>
    props.$a4 &&
    css`
      border-left: 5px solid skyblue;
      margin-top: 5px;
      padding-left: 10px;
    `}
`;

const Strong = styled.strong`
  font-size: 2.5rem;
  font-weight: bold;
`;

const Exam1 = () => {
  return (
    <>
      <Container w={"1140px"} justify={"center"} $main={true}>
        <Container p={"10px 20px"} $a1={true}>
          <Container $a2={true}>
            {/* TODO: 기사 제목 예시 */}
            <Strong>
              [속보] 코스피, 장중 이란 전쟁 전 전고점 돌파… 6355.16
            </Strong>
            <p>
              미국과 이란의 불확실한 종전 협상 등에도 21일 코스피가 장 중
              6350선을 돌파하며 사상 최고치를 경신했다. 이날 오전 9시 13분 기준
              코스피는 전장 대비 136.07포인트(2.19%) 급등한 6355.16에 거래되고
              있다.
            </p>
          </Container>
          <Container w={"fit-content"}>
            <img src="https://picsum.photos/500/300" alt="기사 이미지" />
          </Container>
        </Container>
        <Container p={"10px 20px"} $a1={true}>
          <Container w={"500px"} $a3={true}>
            <img src="https://picsum.photos/500/200" alt="기사 이미지" />
            <Container $a4={true}>
              <Strong>
                벤츠 첫 전기 C-클래스, 한국서 세계 첫선 [가봤어요]
              </Strong>
            </Container>
          </Container>
          <Container $a2={true}>
            {/* TODO: 기사 제목 예시 */}
            <p>
              [이코노미스트 박세진 기자] 메르세데스-벤츠의 ‘디 올-뉴 일렉트릭
              C-클래스’(이하 일렉트릭 C-클래스)가 세계 최초로 공개됐다. 공개
              무대는 한국이다. 브랜드 역사상 처음으로 한국에서 열린 월드
              프리미어(세계 최초 공개)다. C-클래스 최초의 전동화 모델이라는
              점에서, 벤츠가 한국 시장을 얼마나 중요하게 보는지 엿볼 수 있는
              대목이다. 벤츠는 20일 서울 압구정동 안다즈 서울 강남에서 일렉트릭
              C-클래스 프리뷰 행사를 열었다. 행사는 야외에서 진행됐다. 흐린 날씨
              속에서도, 눈앞에 선 백색 차량은 단번에 시선을 압도했다. 특히
              전면부를 채운 1050개의 발광 도트가 강한 인상을 남겼다. 시동이
              걸리자 그릴 전체가 빛을 내며, 마치 운전자를 맞이하듯 존재감을
              드러냈다.
            </p>
          </Container>
        </Container>
      </Container>
    </>
  );
};

export default Exam1;
