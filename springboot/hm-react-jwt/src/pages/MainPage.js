import { useState, useEffect } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import styled, { css } from "styled-components";
import AxiosApi from "../api/AxiosApi";

const heroImage =
  "https://lh3.googleusercontent.com/aida-public/AB6AXuBeKgrASr67yZQnXb-VTY3rY0uR_eRxWiLcIdOBvQhIMGKJRnQwgiAfUN18ZxSiQpGDzIGcHzu_ju8jXZyr-9ug4hX3AILGEDRAZQs9cI9OOCmH7Xrjj-xSK4EvxK9UnNoOt1j465bpn4GyrrqKq6rh_bGY-6-KRSRqYCNZiP7inJYpe_aZzPw14TkexO-VEtzlLVlSHwbm86peaENLePIx2gJwp0ZL4eEnhOnx_dt6CcRvXhHLtbPhEnTi6qUmujrRpuugUk0tzwQO";

const trendingFestivals = [
  {
    title: "석촌호수 벚꽃축제",
    location: "서울 송파구",
    date: "04.05 - 04.12",
    likes: "1.2k likes",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuAJrVyr_LxGLWH-q_sGSdSSyPNAGPfv4RT6EzR7-2Tn7zGtGTznq7syAaf6VvORPpU8Dn6RgkXaysp37JO5op12j6wFZhwNPylW2RtiBNaO_GJKmKGMD9AZxSnWJwYjn7jllRHnt-Dwgbyd5elGF5_JWShcF9m_VzGmuNqtQUiPH2Gu3sfJ6vf90d1EciC2rhb0ornSVlCAmu_uMxO-03nI-_yuc_3RsKW5TY8ri5s4I2GEcFAJ4ZjqaU2meVQ4AIAXJ2LNoix2C6uz",
  },
  {
    title: "서울 재즈 페스티벌",
    location: "서울 송파구",
    date: "05.20 - 05.22",
    likes: "2.3k likes",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuCKMIY4alknrxBsKZfNbK3QVdjQDxEDafc43gs2QAmdOeTT9KcIXSsuQGXko0m-XQ9mmT8u-x2E_wA-Esr2yVQxMVN_joCNEd79Ds6A6FGPuJxag37OYGbw2ImLZtoM_4Q_5MdyAkbtzoNhBrhVQ7tLFKFu899ts2ZZDAF6zlkNXrCZlAYuM-5RqkShyksitvIwvkfjmcQSq1gMWvLiMBMRnA1S5VE4aKySL8QUr1jMiL02n9GS1xnB93abPuTXFDKdqZmVhZjExQTN",
  },
  {
    title: "K-푸드 페스타",
    location: "서울 중구",
    date: "04.15 - 04.20",
    likes: "890 likes",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuDodKOK2n4wGHAfrt_Je1pGx_2J0C-cFcUY1-7jnWpnQ0bHI-s0FFjE7YAGl7EAg2Q4I25KvQUrQXBbcrS5vIhbXntbUFAKcw-SiD3j19fzdVqIFrzIUTBpvZ_8mjmIE9qSZb7qDU8_04ZfcSAolmlbXZ0ZPIVvH823YzlLOmf1hEgHHD186DIky89wh9k8Z-VjNmCpp6xsBNWSsuP3Fn6M9FjuP4dDseyXTOT6JoYrM7zQrKhtZYCCxJapBHOCbNjKSV7z1ZB6ZQEe",
  },
  {
    title: "삼척 장미축제",
    location: "강원 삼척시",
    date: "05.03 - 05.08",
    likes: "2.1k likes",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuBvunqAoHaDzfTkxdFGffLnCtEiNrwit7HyIuJcuIvrHaPUOT6K2A-HcfOzvi6oanqSIkqTLmeSj9ZT_QHzmb3L9TUeovQlmnWBhLlYyeRrZQl-Bnsm7_3ugfctfU8Q7-j-LlPOvVbeMh_xfg80y67q5mDMvnQu3yS5GS0_RpcZXSYfozd8h8LJQ8stEzbcmVp-6WQ34KeYs4G3C7q3qO-Pw_NCNwtezcgJ7qS0AjqxuJvXY9-eLt7FkWFCSIxCXOkS-s3XFt3HOTl8",
  },
];

const aiFestivals = [
  {
    title: "한강 락 페스티벌",
    date: "05.12 - 05.14",
    note: "당신이 선호하는 야외 공연 스타일입니다",
    tone: "primary",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuC1VcKktPj3jWWOF3HJtfAvxfNxZzBu3EtUL3RlsJTdZIqzT_fCJEWSjI6BNlUgldNK7CbH-ADyQsKs2dJjRIw9SjM3P1eO5K-ZYfnQ1tkyUEwfYuzr1Jj7yBJrGF983pvyVQY0sUIMABoH6jRN283glSN9BEDtwo-c_JxCr_jxdOuiKM9hcHfDZY5ODyo_MUbfgnVEWeo4qnrDgUeAk5Q7vJL_vtrw3YSPBG0glPMYMmu8X-Qgu2mLpY5ZWWa_Em8ZbFoROIq6NYio",
  },
  {
    title: "부산 파인다이닝 위크",
    date: "04.28 - 05.03",
    note: "지난번에 방문하신 푸드 축제와 유사해요",
    tone: "secondary",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuAVeHa0EDvb0UT1Df3kdxKDTJNkbas5WM25cbXI76TPMzDMuwRkFKDK1zTtxMxa5R8OgsmUMIYUmEPYMg5InHI9KfmHRH4Efc7QjXd_TUMVYssCxqFEaZfB9FQbooOk9pN21M3EvQqTzP30cwwA3Klevtg9-91Vs7adiypgd7Mxc7qpdStHKbG84NG5cTwnmYjzgFjiRd-FCVNi94mN5xQsOLYpj9OJEbxoPp5FtKnD1RJXg1SDwEJNgm27bswWinIqbtiRMoBOkvoF",
  },
  {
    title: "하이서울 페스티벌",
    date: "05.01 - 05.05",
    note: "친구들이 많이 북마크한 축제입니다",
    tone: "primary",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuDwcyYplxNF6AMLTbP8Ovikc5WgqjBTJUyigU2ThSrhp2KPPNaDv5inEsrbQYsef7xviWjwlQC76u5PK1FnzR2wJ001uwcT_YOHIEP9hJh5JVQoJvN0s_6AfLR6juXBUybELLmbrejJjWLi9cA04y3RnbNU87bqA-FQZ2CAuaUBeSxpQ404u02avpd_uPu7KEsbrvdc4S0l295t7g-1h6bKzl-cnp6iBEB_DyEw3dCMU5nQxjInj4oViE8aKHaBZ6SXnzwDGGUNEhxt",
  },
];

const monthlyFestivals = [
  {
    title: "고양 국제 꽃 박람회",
    location: "경기 고양시",
    date: "04.26-05.08",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuBSGNfZMsBNp0nzcfdqJbQUvkRvYuJQBhUdtg913fmbw7mGnzv0nohxnqKn_mn93P5MpxgQBWAMNCP4mFqC_y70-VrIzdG5FPuvSYLJOiK7FjZXkxtChT3ZrjEjtKxxd3dGnLw8DByTAVU8pJcvKRIdqRF2cMlbMwnKykPBI9JHS6kF6_9iUPv4RiBzN7LgvGvIG9HAXgQAs2KNZivViC6vuPIPi1TgNTb2EytXBH4h4TMQCsu_7-G9AqTva2ehGX3P3nv1w0B1l-ac",
  },
  {
    title: "담양 대나무 축제",
    location: "전남 담양군",
    date: "04.29-05.04",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuBqUA4G7_HtGpCsP3KxnFRYx0n16THtgM2L0BU0PTYSwBvH13nc0mkKtEjQC4PBz63MNTVf6kIX4pk8t0ybr0X-vpivRV7e_d-e-BTE9DPSUnX69xMaWQ22t0D5DXEag7YKM-7rrBIcNY0qiOc1F3NZWDN7TSBroK4dwAZC9LfAYgGbTZq3ljzUe1eVgiiGWACaWowOvTvhYAzic3FWkOC_fWWIdHru3sNw3L8E_menouCwVnh7-_LtFF6kM7j0ZjQ_UnHdfqJUqAwK",
  },
  {
    title: "여주 도자기 축제",
    location: "경기 여주시",
    date: "04.15-05.02",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuD5hjEEhy2_GSOifc2w367Y62DdIBUvsuXa0fMfrctegm56ZTF8WeZBH9_92lN0_li8aZQU-lc220mX2K8XX3QJlW4ZPhG4KABP-QVT0enRkxcVSGbgzVcAWkChKsccUExtdxVNXXDI1SS6SJcMda9nH-WzWgeZx7batCW9E2caAfbQ3nnsA1fTnVhR2wbo4GF9YmF1NGdWH45T-4IdVGCXY4uhzntzgcacFyaE9nl11BJpPJE6xqWPqV8h8BeJ43clb0e0omvtqMED",
  },
  {
    title: "가평 펜션 뮤직 페스타",
    location: "경기 가평군",
    date: "04.24-04.25",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuCSzlIToqtdsDl0llAJpofOoVoiMr_Scxv6iYr90L0pGZd2p1teRa6DIj42ZSFz2hwxkZGmEHqiuiSp6j8F80X4eIa6C_pDr9rY8YHVC_7EXPOGxLb8xnG_kjytoSLcfWyM0_ktGU9PgbIICxmyFgBQKUNB0ApZB1hjlwSMhnKRQnmOPUyankqDtRSN9SCdaVmR1xhZa_28pujNq66DssfDEqZRe_nUGUqpc8puiKRoJfN1Mpj7Bq5p5hEIXYnoaTVN1EPrS_NyqoA1",
  },
  {
    title: "제주 유채꽃 축제",
    location: "제주 서귀포시",
    date: "04.01-04.10",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuDg48nZOQeJKZJd15_koR6eD3VxMLY7IV3uEYvQ8bN4UsBbhK1PxML8CDPD6-V3lGM8HlCycWs-o_UI3IFMURO2P9Wwok34T6bXwEf1fE_P8GeS_YNP5zqZr7DzYRJDDtVmeTyHm-Dd6mHkX7yu9lRv32MGZ-y2sGl7vdE2GAT0m11go172Ru1KrLNwAVv5AHWjGAy6REE_bvyZ-8HSp76HqmnrPkugxfXCU4YmAlkdSOavIomYjYZ6_NwBunZGlKkZ53oJOBTIytH9",
  },
  {
    title: "대구 풍등 날리기",
    location: "대구 달서구",
    date: "04.25-04.25",
    image:
      "https://lh3.googleusercontent.com/aida-public/AB6AXuA9tm8KBTlcQ_z4qxK4DWxu8DMMoxhr0sEw5AfbJY4AXF0aUh_exSI6AiWxfURCpFpm7yZjHfHxhKUMkJSd_fnQznFxwJRR2hOR1muoKgW1ugRDkAtFTLdxEHMv_2ZaTH66rH5AVNR2wd7G94XAS5VeU6_LLLMl6IiJ92BYlHHEcxiy4lVebX6ilIew1OFWBRcITbJDsnu8PFWNaZRqXZ-HmUrIBeJOEXO_owFRHNpOOkjSA5dnh6j9aoh5FQKry-lOUdnk-0uRX9O8",
  },
];

const glassCard = css`
  background: rgba(255, 255, 255, 0.03);
  border: 1px solid rgba(255, 255, 255, 0.08);
  backdrop-filter: blur(12px);
`;

const Page = styled.div`
  min-height: 100vh;
  background: #0b1326;
  color: #dae2fd;
  font-family: "Plus Jakarta Sans", "Segoe UI", sans-serif;
  overflow-x: hidden;

  * {
    box-sizing: border-box;
  }

  button,
  a {
    font-family: inherit;
  }
`;

const Shell = styled.div`
  width: min(100%, 1280px);
  margin: 0 auto;
  padding: 0 40px;

  @media (max-width: 960px) {
    padding: 0 16px;
  }
`;

const Nav = styled.header`
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 50;
  background: rgba(11, 19, 38, 0.82);
  border-bottom: 1px solid rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(18px);
  box-shadow: 0 8px 30px rgba(0, 0, 0, 0.24);
`;

const NavInner = styled(Shell)`
  height: 64px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 24px;
`;

const Brand = styled.a`
  color: #ffb0cd;
  font-size: 24px;
  font-weight: 800;
  text-decoration: none;
`;

const NavLeft = styled.div`
  display: flex;
  align-items: center;
  gap: 48px;
`;

const Menu = styled.nav`
  display: flex;
  align-items: center;
  gap: 30px;

  a {
    color: #cfc2d6;
    font-size: 14px;
    font-weight: 700;
    letter-spacing: 0.04em;
    text-decoration: none;
    transition: color 0.2s ease;
  }

  a:first-child {
    color: #ddb7ff;
    border-bottom: 2px solid #ddb7ff;
    padding-bottom: 6px;
  }

  a:hover {
    color: #ddb7ff;
  }

  @media (max-width: 960px) {
    display: none;
  }
`;

const NavRight = styled.div`
  display: flex;
  align-items: center;
  gap: 20px;

  @media (max-width: 640px) {
    gap: 8px;
  }
`;

const MaterialIcon = styled.span`
  font-family: "Material Symbols Outlined";
  font-weight: normal;
  font-style: normal;
  font-size: ${(p) => p.$size || "24px"};
  line-height: 1;
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
  word-wrap: normal;
  direction: ltr;
  -webkit-font-smoothing: antialiased;
  font-variation-settings: ${(p) =>
    p.$filled
      ? "'FILL' 1, 'wght' 400, 'GRAD' 0, 'opsz' 24"
      : "'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24"};
`;

const SearchLabel = styled.label`
  position: relative;
  display: flex;
  align-items: center;

  @media (max-width: 960px) {
    display: none;
  }
`;

const SearchIcon = styled(MaterialIcon)`
  position: absolute;
  left: 15px;
  color: #988d9f;
`;

const SearchInput = styled.input`
  width: 256px;
  border: 0;
  border-radius: 999px;
  background: #222a3d;
  color: #dae2fd;
  font-size: 15px;
  outline: 0;
  padding: 11px 18px 11px 44px;

  &::placeholder {
    color: #988d9f;
  }
`;

const IconButton = styled.button`
  width: 40px;
  height: 40px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  border: 0;
  border-radius: 999px;
  background: transparent;
  color: #cfc2d6;
  cursor: pointer;

  @media (max-width: 640px) {
    display: none;
  }
`;

const AuthButton = styled.button`
  border: 0;
  border-radius: 999px;
  background: #aa0266;
  color: #ffffff;
  cursor: pointer;
  font-size: 14px;
  font-weight: 700;
  padding: 10px 22px;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
  white-space: nowrap;

  &:hover {
    transform: translateY(-1px);
    box-shadow: 0 8px 22px rgba(170, 2, 102, 0.28);
  }
`;

const Main = styled.main`
  width: min(100% - 32px, 1024px);
  margin: 0 auto;
  padding: 88px 0 96px;

  @media (max-width: 640px) {
    width: min(100% - 24px, 1024px);
    padding-top: 80px;
  }
`;

const MemberStrip = styled.div`
  ${glassCard}
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 16px;
  margin: 24px 0 -20px;
  border-radius: 16px;
  padding: 14px 18px;

  strong {
    display: block;
    font-size: 15px;
  }

  span {
    color: #cfc2d6;
    font-size: 12px;
  }

  @media (max-width: 640px) {
    align-items: flex-start;
    flex-direction: column;
  }
`;

const Hero = styled.section`
  min-height: 400px;
  aspect-ratio: 21 / 9;
  position: relative;
  overflow: hidden;
  border-radius: 32px;
  isolation: isolate;
  box-shadow: 0 30px 80px rgba(0, 0, 0, 0.35);

  &::after {
    content: "";
    position: absolute;
    inset: 0;
    background: linear-gradient(
      180deg,
      rgba(11, 19, 38, 0) 18%,
      rgba(11, 19, 38, 0.92) 100%
    );
    z-index: -1;
  }

  @media (max-width: 640px) {
    min-height: 460px;
    aspect-ratio: auto;
    border-radius: 24px;
  }
`;

const HeroImage = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
  position: absolute;
  inset: 0;
  filter: brightness(0.7);
  z-index: -2;
`;

const HeroContent = styled.div`
  position: absolute;
  left: 48px;
  right: 48px;
  bottom: 48px;
  max-width: 690px;

  @media (max-width: 640px) {
    left: 24px;
    right: 24px;
    bottom: 34px;
  }
`;

const HeroTitle = styled.h1`
  margin: 0;
  font-size: 48px;
  line-height: 1.15;
  font-weight: 800;
  letter-spacing: -0.02em;

  @media (max-width: 640px) {
    font-size: 34px;
  }
`;

const HeroCopy = styled.p`
  margin: 16px 0 0;
  color: #cfc2d6;
  font-size: 18px;
  line-height: 1.55;
`;

const GradientButton = styled.button`
  display: inline-flex;
  align-items: center;
  gap: 10px;
  border: 0;
  border-radius: 999px;
  background: linear-gradient(135deg, #b76dff 0%, #aa0266 100%);
  color: #ffffff;
  cursor: pointer;
  font-size: 22px;
  font-weight: 700;
  margin-top: 28px;
  padding: 16px 30px;
  transition: transform 0.25s ease, box-shadow 0.25s ease;
  box-shadow: 0 16px 36px rgba(183, 109, 255, 0.18);

  &:hover {
    transform: scale(1.03);
    box-shadow: 0 20px 44px rgba(183, 109, 255, 0.28);
  }

  @media (max-width: 640px) {
    width: 100%;
    justify-content: center;
    font-size: 18px;
    padding: 15px 18px;
  }
`;

const Dots = styled.div`
  position: absolute;
  right: 32px;
  bottom: 26px;
  display: flex;
  gap: 8px;
`;

const Dot = styled.span`
  width: ${(p) => (p.$active ? "48px" : "8px")};
  height: 4px;
  border-radius: 999px;
  background: ${(p) => (p.$active ? "#ffffff" : "rgba(255, 255, 255, 0.35)")};
`;

const Section = styled.section`
  margin-top: 48px;
`;

const SectionHead = styled.div`
  display: flex;
  align-items: end;
  justify-content: space-between;
  gap: 16px;
  margin-bottom: 24px;

  @media (max-width: 640px) {
    align-items: flex-start;
    flex-direction: column;
  }
`;

const Eyebrow = styled.span`
  color: #ffb0cd;
  font-size: 14px;
  font-weight: 800;
  letter-spacing: 0.16em;
`;

const SectionTitle = styled.h2`
  margin: 4px 0 0;
  font-size: 32px;
  line-height: 1.25;

  @media (max-width: 640px) {
    font-size: 26px;
  }
`;

const MoreLink = styled.a`
  display: inline-flex;
  align-items: center;
  gap: 4px;
  color: #cfc2d6;
  font-size: 14px;
  font-weight: 700;
  text-decoration: none;
`;

const TrendingGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  gap: 24px;

  @media (max-width: 960px) {
    grid-template-columns: repeat(2, minmax(0, 1fr));
  }

  @media (max-width: 640px) {
    grid-template-columns: 1fr;
  }
`;

const Card = styled.article`
  ${glassCard}
  position: relative;
  overflow: hidden;
  border-radius: 20px;
  transition: transform 0.25s ease, border-color 0.25s ease, background 0.25s ease;

  &:hover {
    transform: translateY(-8px);
    background: rgba(255, 255, 255, 0.055);
  }

  &:hover img {
    transform: scale(1.08);
  }
`;

const CardImage = styled.div`
  position: relative;
  aspect-ratio: 3 / 4;
  overflow: hidden;
`;

const FillImage = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
  transition: transform 0.45s ease;
`;

const DatePill = styled.div`
  position: absolute;
  top: 12px;
  left: 12px;
  border-radius: 999px;
  background: rgba(0, 0, 0, 0.42);
  color: #ffffff;
  backdrop-filter: blur(10px);
  font-size: 10px;
  font-weight: 800;
  padding: 6px 10px;
`;

const HeartButton = styled.button`
  position: absolute;
  top: 12px;
  right: 12px;
  width: 32px;
  height: 32px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  border: 0;
  border-radius: 999px;
  background: rgba(0, 0, 0, 0.24);
  color: rgba(255, 255, 255, 0.82);
  cursor: pointer;
  backdrop-filter: blur(10px);

  &:hover {
    color: #f87171;
  }
`;

const CardBody = styled.div`
  padding: 16px;
`;

const ItemTitle = styled.h3`
  margin: 0;
  color: #dae2fd;
  font-size: 24px;
  line-height: 1.25;
  font-weight: 700;

  @media (max-width: 640px) {
    font-size: 21px;
  }
`;

const CardTitle = styled(ItemTitle)`
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
`;

const Meta = styled.div`
  display: flex;
  align-items: center;
  gap: 4px;
  color: #cfc2d6;
  font-size: 12px;
  font-weight: 600;
  margin-top: 10px;
`;

const CardBottom = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 14px;
`;

const LikeRow = styled.div`
  display: flex;
  align-items: center;
  gap: 4px;
  color: #f87171;
  font-size: 12px;
  font-weight: 700;
`;

const AiSection = styled(Section)`
  background: #131b2e;
  border-radius: 28px;
  padding: 48px;

  @media (max-width: 960px) {
    padding: 28px;
  }
`;

const TitleRow = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;
  margin-bottom: 24px;
`;

const AiGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(3, minmax(0, 1fr));
  gap: 24px;

  @media (max-width: 960px) {
    grid-template-columns: 1fr;
  }
`;

const AiCard = styled.article`
  ${glassCard}
  position: relative;
  overflow: hidden;
  border-radius: 24px;
  transition: transform 0.25s ease, border-color 0.25s ease;
  box-shadow: ${(p) =>
    p.$tone === "secondary"
      ? "0 0 20px rgba(255, 176, 205, 0.15)"
      : "0 0 20px rgba(221, 183, 255, 0.15)"};
  border-color: ${(p) =>
    p.$tone === "secondary"
      ? "rgba(255, 176, 205, 0.2)"
      : "rgba(221, 183, 255, 0.2)"};

  &:hover {
    transform: translateY(-4px);
    border-color: ${(p) =>
      p.$tone === "secondary"
        ? "rgba(255, 176, 205, 0.7)"
        : "rgba(221, 183, 255, 0.7)"};
  }

  &:hover img {
    transform: scale(1.08);
  }
`;

const AiImage = styled.div`
  position: relative;
  height: 192px;
  overflow: hidden;

  &::after {
    content: "";
    position: absolute;
    inset: 0;
    background: linear-gradient(180deg, rgba(19, 27, 46, 0) 10%, #131b2e 100%);
  }
`;

const AiPill = styled.div`
  position: absolute;
  top: 12px;
  left: 12px;
  z-index: 1;
  display: inline-flex;
  align-items: center;
  gap: 4px;
  border-radius: 999px;
  color: ${(p) => (p.$tone === "secondary" ? "#640039" : "#490080")};
  background: ${(p) => (p.$tone === "secondary" ? "#ffb0cd" : "#ddb7ff")};
  font-size: 10px;
  font-weight: 800;
  padding: 6px 10px;
`;

const AiBody = styled.div`
  padding: 16px;
`;

const AiNote = styled.p`
  margin: 14px 0;
  border-radius: 12px;
  background: rgba(255, 255, 255, 0.05);
  color: #cfc2d6;
  font-size: 14px;
  font-style: italic;
  font-weight: 600;
  line-height: 1.45;
  padding: 12px;
`;

const FilterRow = styled.div`
  display: flex;
  gap: 8px;
`;

const FilterButton = styled.button`
  border: 0;
  border-radius: 999px;
  background: ${(p) => (p.$active ? "#aa0266" : "#222a3d")};
  color: ${(p) => (p.$active ? "#ffffff" : "#cfc2d6")};
  cursor: pointer;
  font-size: 12px;
  font-weight: 700;
  padding: 7px 16px;
`;

const MonthlyGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 24px;

  @media (max-width: 960px) {
    grid-template-columns: repeat(2, minmax(0, 1fr));
  }

  @media (max-width: 640px) {
    grid-template-columns: 1fr;
  }
`;

const ListItem = styled.article`
  ${glassCard}
  display: flex;
  gap: 16px;
  border-radius: 20px;
  padding: 16px;
  transition: background 0.2s ease;

  &:hover {
    background: rgba(255, 255, 255, 0.05);
  }
`;

const ListImage = styled.div`
  width: 128px;
  height: 128px;
  flex: 0 0 128px;
  overflow: hidden;
  border-radius: 14px;

  @media (max-width: 640px) {
    width: 104px;
    height: 104px;
    flex-basis: 104px;
  }
`;

const ListBody = styled.div`
  display: flex;
  flex: 1;
  min-width: 0;
  flex-direction: column;
  justify-content: space-between;
  padding: 4px 0;

  p {
    margin: 8px 0 0;
    color: #cfc2d6;
    font-size: 12px;
    font-weight: 600;
  }
`;

const ListDate = styled.div`
  color: #ffb0cd;
  font-size: 14px;
  font-weight: 800;
  text-align: right;
`;

const Footer = styled.footer`
  background: #060e20;
  border-top: 1px solid rgba(255, 255, 255, 0.05);
  padding: 48px 0;
`;

const FooterGrid = styled(Shell)`
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 24px;

  @media (max-width: 960px) {
    grid-template-columns: 1fr;
  }
`;

const FooterCopy = styled.p`
  max-width: 360px;
  color: #cfc2d6;
  font-size: 16px;
  line-height: 1.5;
  margin: 16px 0 0;
`;

const Socials = styled.div`
  display: flex;
  gap: 16px;
  margin-top: 22px;
`;

const SocialButton = styled.button`
  width: 40px;
  height: 40px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  border-radius: 999px;
  border: 1px solid rgba(255, 255, 255, 0.1);
  background: transparent;
  color: #cfc2d6;
  cursor: pointer;
`;

const FooterLinks = styled.div`
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 32px;

  h4 {
    margin: 0 0 16px;
    font-size: 14px;
  }

  ul {
    list-style: none;
    margin: 0;
    padding: 0;
  }

  li + li {
    margin-top: 10px;
  }

  a {
    color: #cfc2d6;
    font-size: 12px;
    font-weight: 600;
    text-decoration: none;
  }

  @media (max-width: 640px) {
    grid-template-columns: 1fr;
  }
`;

const MainPage = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const { memberEmail: memberEmailParam } = useParams();
  const memberEmail = memberEmailParam || location.state?.memberEmail || "";
  const [message, setMessage] = useState("메인 페이지에 오신 것을 환영합니다!");
  const [memberInfo, setMemberInfo] = useState({
    memberEmail: memberEmail,
    memberName: "",
  });
  const isLoggedIn = Boolean(localStorage.getItem("accessToken"));

  const handleLogout = () => {
    localStorage.clear();
    alert("로그아웃 되었습니다.");
    navigate("/login");
  };

  const handleLogin = () => {
    navigate("/login");
  };

  useEffect(() => {
    if (!memberEmail) return;

    const fetchMemberInfo = async () => {
      try {
        const response = await AxiosApi.getMember(memberEmail);
        const data = response.data.data;

        setMemberInfo({
          memberName: data.memberName,
          memberEmail: data.memberEmail,
        });
        setMessage(`환영합니다, ${data.memberName}님!`);
      } catch (error) {
        console.error("멤버 정보 조회 실패:", error);
        setMessage("메인 페이지에 오신 것을 환영합니다!");
      }
    };

    fetchMemberInfo();
  }, [memberEmail]);

  return (
    <Page>
      <Nav>
        <NavInner>
          <NavLeft>
            <Brand href="/">FestaPick</Brand>
            <Menu aria-label="주요 메뉴">
              <a href="/">축제 탐색</a>
              <a href="/">내 주변</a>
              <a href="/">캘린더</a>
              <a href="/">커뮤니티</a>
            </Menu>
          </NavLeft>

          <NavRight>
            <SearchLabel>
              <SearchIcon $size="21px">search</SearchIcon>
              <SearchInput placeholder="어떤 축제를 찾으세요?" type="search" />
            </SearchLabel>
            <IconButton type="button" aria-label="알림">
              <MaterialIcon>notifications</MaterialIcon>
            </IconButton>
            <AuthButton
              type="button"
              onClick={isLoggedIn ? handleLogout : handleLogin}
            >
              {isLoggedIn ? "Logout" : "Login"}
            </AuthButton>
          </NavRight>
        </NavInner>
      </Nav>

      <Main>
        {isLoggedIn && (
          <MemberStrip>
            <div>
              <strong>{message}</strong>
              <span>{memberInfo.memberEmail}</span>
            </div>
          </MemberStrip>
        )}

        <Hero>
          <HeroImage
            src={heroImage}
            alt="밤하늘의 화려한 불꽃과 축제 인파가 보이는 야간 페스티벌"
          />
          <HeroContent>
            <HeroTitle>
              세상의 모든 즐거움,
              <br />
              페스타픽에서 만나보세요
            </HeroTitle>
            <HeroCopy>실시간 현장 정보부터 AI 추천까지 완벽하게</HeroCopy>
            <GradientButton type="button">
              <MaterialIcon $filled>auto_awesome</MaterialIcon>
              나를 위한 추천 시작
            </GradientButton>
          </HeroContent>
          <Dots aria-hidden="true">
            <Dot $active />
            <Dot />
            <Dot />
          </Dots>
        </Hero>

        <Section>
          <SectionHead>
            <div>
              <Eyebrow>TOP TRENDING</Eyebrow>
              <SectionTitle>지금 가장 인기 있는 축제</SectionTitle>
            </div>
            <MoreLink href="/">
              전체보기
              <MaterialIcon>chevron_right</MaterialIcon>
            </MoreLink>
          </SectionHead>

          <TrendingGrid>
            {trendingFestivals.map((festival) => (
              <Card key={festival.title}>
                <CardImage>
                  <FillImage src={festival.image} alt={festival.title} />
                  <DatePill>{festival.date}</DatePill>
                  <HeartButton
                    type="button"
                    aria-label={`${festival.title} 관심 등록`}
                  >
                    <MaterialIcon>favorite</MaterialIcon>
                  </HeartButton>
                </CardImage>
                <CardBody>
                  <CardTitle>{festival.title}</CardTitle>
                  <Meta>
                    <MaterialIcon $size="12px">location_on</MaterialIcon>
                    {festival.location}
                  </Meta>
                  <CardBottom>
                    <LikeRow>
                      <MaterialIcon $filled $size="12px">
                        favorite
                      </MaterialIcon>
                      {festival.likes}
                    </LikeRow>
                    <MaterialIcon $size="18px">share</MaterialIcon>
                  </CardBottom>
                </CardBody>
              </Card>
            ))}
          </TrendingGrid>
        </Section>

        <AiSection>
          <TitleRow>
            <MaterialIcon $filled $size="34px">
              auto_awesome
            </MaterialIcon>
            <SectionTitle>AI가 추천하는 맞춤 축제</SectionTitle>
          </TitleRow>

          <AiGrid>
            {aiFestivals.map((festival) => (
              <AiCard $tone={festival.tone} key={festival.title}>
                <AiImage>
                  <FillImage src={festival.image} alt={festival.title} />
                  <AiPill $tone={festival.tone}>
                    <MaterialIcon $filled $size="12px">
                      colors_spark
                    </MaterialIcon>
                    AI Recommendation
                  </AiPill>
                </AiImage>
                <AiBody>
                  <ItemTitle>{festival.title}</ItemTitle>
                  <AiNote>"{festival.note}"</AiNote>
                  <Meta>
                    <MaterialIcon $size="12px">calendar_month</MaterialIcon>
                    {festival.date}
                  </Meta>
                </AiBody>
              </AiCard>
            ))}
          </AiGrid>
        </AiSection>

        <Section>
          <SectionHead>
            <SectionTitle>4월의 추천 축제</SectionTitle>
            <FilterRow aria-label="축제 카테고리 필터">
              <FilterButton $active type="button">
                전체
              </FilterButton>
              <FilterButton type="button">음악</FilterButton>
              <FilterButton type="button">음식</FilterButton>
            </FilterRow>
          </SectionHead>

          <MonthlyGrid>
            {monthlyFestivals.map((festival) => (
              <ListItem key={festival.title}>
                <ListImage>
                  <FillImage src={festival.image} alt={festival.title} />
                </ListImage>
                <ListBody>
                  <div>
                    <ItemTitle>{festival.title}</ItemTitle>
                    <p>{festival.location}</p>
                  </div>
                  <ListDate>{festival.date}</ListDate>
                </ListBody>
              </ListItem>
            ))}
          </MonthlyGrid>
        </Section>
      </Main>

      <Footer>
        <FooterGrid>
          <div>
            <Brand href="/">FestaPick</Brand>
            <FooterCopy>
              © 2024 FestaPick. Celebrating kinetic energy and local culture.
            </FooterCopy>
            <Socials>
              <SocialButton type="button" aria-label="공유">
                <MaterialIcon $size="18px">share</MaterialIcon>
              </SocialButton>
              <SocialButton type="button" aria-label="웹사이트">
                <MaterialIcon $size="18px">public</MaterialIcon>
              </SocialButton>
            </Socials>
          </div>
          <FooterLinks>
            <div>
              <h4>Menu</h4>
              <ul>
                <li>
                  <a href="/">About Us</a>
                </li>
                <li>
                  <a href="/">Terms of Service</a>
                </li>
                <li>
                  <a href="/">Privacy Policy</a>
                </li>
              </ul>
            </div>
            <div>
              <h4>Support</h4>
              <ul>
                <li>
                  <a href="/">Customer Center</a>
                </li>
                <li>
                  <a href="/">Q&amp;A</a>
                </li>
                <li>
                  <a href="/">Contact</a>
                </li>
              </ul>
            </div>
          </FooterLinks>
        </FooterGrid>
      </Footer>
    </Page>
  );
};

export default MainPage;
