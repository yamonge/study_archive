import styled, { css } from "styled-components";

const Container = styled.div`
  width: ${(props) => props.w || "100%"};
  height: ${(props) => props.h || "100%"};
  background-color: ${(props) => props.bgc || "#f5f5f5"};
  padding: ${(props) => props.p || "0px"};
  margin: ${(props) => props.m || "0px"};
  border: ${(props) => props.b || "none"};
  border-radius: ${(props) => props.br || "0px"};
  display: ${(props) => props.display || "flex"};
  justify-content: ${(props) => props.justify};
  align-items: ${(props) => props.align};
  ${(props) =>
    props.$a1 &&
    css`
      flex-direction: column;
      align-items: center;
    `}
  ${(props) =>
    props.$a2 &&
    css`
      flex-direction: row;
      gap: 10px;
      padding: 0 10px;
    `}
`;

const Card = styled.div`
  width: ${(props) => props.w || "100%"};
  height: ${(props) => props.h || "600px"};
  background-color: ${(props) => props.bgc || "white"};
  padding: ${(props) => props.p || "0px"};
  margin: ${(props) => props.m || "10px 0px"};
  border: ${(props) => props.b || "none"};
  border-radius: ${(props) => props.br || "0px"};
  display: flex;
  flex-direction: column;
  gap: 10px;
  align-items: center;
  text-align: center;
`;

const Img = styled.img`
  width: ${(props) => props.w || "100%"};
  height: ${(props) => props.h || "300px"};
  object-fit: cover;
`;

const P = styled.p`
  font-size: 1.5rem;
  font-weight: normal;
  color: ${(props) => props.color || "black"};
`;

const Strong = styled.strong`
  font-size: 1.5rem;
  font-weight: bold;
  color: ${(props) => props.color || "black"};
`;

const Exam2 = () => {
  return (
    <Container w={"1140px"} justify={"center"} $a1={true}>
      <Container m={"10px auto"} justify={"center"}>
        <P>네이버 기사 홈</P>
      </Container>
      <Container $a2={true}>
        <Card>
          <Img src="https://picsum.photos/300/300" alt="기사 이미지" />
          <P>LG U+, 국내 최대 ICT 전시회 '월드IT쇼'서 첫 단독 전시</P>
          <Strong color={"orange"}>머니투데이</Strong>
          <p>
            LG유플러스가 국내 대표 ICT(정보통신기술) 전시회인 '월드IT쇼(World IT
            Show)'에 처음으로 참가해 공식 단독 전시 부스를 운영하고, 정성권
            AX서비스개발그룹장이 기조연설에 나선다고 21일 밝혔다.
          </p>
        </Card>
        <Card>
          <Img src="https://picsum.photos/300/300" alt="기사 이미지" />
          <P>[AI픽] '제미나이 품은 크롬' 한국 출시…웹 탐색 'AI 통합'</P>
          <Strong color={"orange"}>연합뉴스</Strong>
          <p>
            이미지 변환까지 지원하는 AI 기반 크롬 서비스를 한국에 선보인다.
            웹페이지와 여러 탭을 오가며 온라인에서 진행하던 작업을 크롬 안에서
            더욱 직관적으로 처리하도록 돕는 것이 핵심이다. 구글이 검색 기능을
            넘어선 최신 AI 기능을 탑재한 크롬을 내놓으면서 국내 검색·앱 시장에
            어떤 변화를 가져올지도 주목된다.
          </p>
        </Card>
        <Card>
          <Img src="https://picsum.photos/300/300" alt="기사 이미지" />
          <P>경찰, ‘LG유플러스 해킹 은폐 의혹’ 관련 3명 입건</P>
          <Strong color={"orange"}>조선비즈</Strong>
          <p>
            경찰이 LG유플러스의 해킹 은폐 의혹과 관련해 3명을 피의자로 입건했다.
            박정보 서울경찰청장은 20일 정례 기자간담회에서 “LG유플러스
            마곡사옥과 관련자들에 대한 압수수색을 지난달 진행했다”며 이같이
            밝혔다. 입건된 피의자 3명 모두 LG유플러스 소속이다.
          </p>
        </Card>
      </Container>
    </Container>
  );
};

export default Exam2;
