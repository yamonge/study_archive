import { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import AxiosApi from "../api/AxiosApi";

const Page = styled.div`
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  position: relative;
  background:
    radial-gradient(
      circle at 18% 15%,
      rgba(183, 109, 255, 0.2),
      transparent 34%
    ),
    radial-gradient(
      circle at 82% 80%,
      rgba(255, 176, 205, 0.14),
      transparent 32%
    ),
    #0b1326;
  color: #dae2fd;
  font-family: "Plus Jakarta Sans", "Segoe UI", sans-serif;
  padding: 32px 16px;

  * {
    box-sizing: border-box;
  }
`;

const Shell = styled.main`
  width: min(100%, 980px);
  display: grid;
  grid-template-columns: minmax(0, 0.95fr) minmax(360px, 440px);
  gap: 32px;
  align-items: stretch;

  @media (max-width: 860px) {
    grid-template-columns: 1fr;
  }
`;

const IntroPanel = styled.section`
  min-height: 560px;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  position: relative;
  overflow: hidden;
  border: 1px solid rgba(255, 255, 255, 0.08);
  border-radius: 24px;
  background:
    linear-gradient(180deg, rgba(11, 19, 38, 0.08), rgba(11, 19, 38, 0.92)),
    url("https://lh3.googleusercontent.com/aida-public/AB6AXuBeKgrASr67yZQnXb-VTY3rY0uR_eRxWiLcIdOBvQhIMGKJRnQwgiAfUN18ZxSiQpGDzIGcHzu_ju8jXZyr-9ug4hX3AILGEDRAZQs9cI9OOCmH7Xrjj-xSK4EvxK9UnNoOt1j465bpn4GyrrqKq6rh_bGY-6-KRSRqYCNZiP7inJYpe_aZzPw14TkexO-VEtzlLVlSHwbm86peaENLePIx2gJwp0ZL4eEnhOnx_dt6CcRvXhHLtbPhEnTi6qUmujrRpuugUk0tzwQO")
      center/cover;
  padding: 40px;
  box-shadow: 0 28px 80px rgba(0, 0, 0, 0.32);

  @media (max-width: 860px) {
    min-height: 320px;
  }

  @media (max-width: 520px) {
    display: none;
  }
`;

const Brand = styled.div`
  color: #ffb0cd;
  font-size: 20px;
  font-weight: 800;
  letter-spacing: 0.02em;
`;

const IntroTitle = styled.h1`
  max-width: 520px;
  margin: 18px 0 0;
  font-size: 44px;
  line-height: 1.12;
  font-weight: 800;
  letter-spacing: -0.02em;

  @media (max-width: 860px) {
    font-size: 34px;
  }
`;

const IntroCopy = styled.p`
  max-width: 470px;
  margin: 18px 0 0;
  color: #cfc2d6;
  font-size: 17px;
  line-height: 1.6;
`;

const Card = styled.section`
  position: relative;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 24px;
  background: rgba(23, 31, 51, 0.78);
  backdrop-filter: blur(22px);
  box-shadow: 0 0 44px rgba(221, 183, 255, 0.12);
  padding: 42px;

  @media (max-width: 520px) {
    padding: 28px 22px;
  }
`;

const Header = styled.div`
  margin-bottom: 28px;
`;

const MobileBrand = styled(Brand)`
  display: none;
  margin-bottom: 14px;

  @media (max-width: 520px) {
    display: block;
  }
`;

const Title = styled.h2`
  margin: 0;
  color: #dae2fd;
  font-size: 30px;
  line-height: 1.25;
  font-weight: 800;
`;

const SubTitle = styled.p`
  margin: 10px 0 0;
  color: #cfc2d6;
  font-size: 15px;
  line-height: 1.55;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: 18px;
`;

const Field = styled.label`
  display: flex;
  flex-direction: column;
  gap: 8px;
  color: #cfc2d6;
  font-size: 14px;
  font-weight: 700;
`;

const InputWrap = styled.div`
  position: relative;
`;

const Icon = styled.span`
  position: absolute;
  left: 16px;
  top: 50%;
  transform: translateY(-50%);
  color: #988d9f;
  font-family: "Material Symbols Outlined";
  font-size: 21px;
  line-height: 1;
  font-variation-settings:
    "FILL" 0,
    "wght" 400,
    "GRAD" 0,
    "opsz" 24;
`;

const Input = styled.input`
  width: 100%;
  height: 52px;
  border: 1px solid #4d4354;
  border-radius: 12px;
  background: rgba(45, 52, 73, 0.42);
  color: #dae2fd;
  font-size: 15px;
  outline: none;
  padding: 0 16px 0 48px;
  transition:
    border-color 0.18s ease,
    box-shadow 0.18s ease,
    background 0.18s ease;

  &::placeholder {
    color: rgba(152, 141, 159, 0.7);
  }

  &:focus {
    border-color: #ddb7ff;
    background: rgba(45, 52, 73, 0.62);
    box-shadow: 0 0 0 4px rgba(221, 183, 255, 0.14);
  }
`;

const SubmitButton = styled.button`
  height: 54px;
  border: 0;
  border-radius: 999px;
  background: linear-gradient(135deg, #b76dff 0%, #aa0266 100%);
  color: #ffffff;
  cursor: pointer;
  font-size: 15px;
  font-weight: 800;
  margin-top: 8px;
  transition:
    transform 0.2s ease,
    box-shadow 0.2s ease;
  box-shadow: 0 14px 30px rgba(183, 109, 255, 0.2);

  &:hover {
    transform: translateY(-2px);
    box-shadow: 0 18px 38px rgba(183, 109, 255, 0.3);
  }

  &:active {
    transform: translateY(0);
  }
`;

const FooterText = styled.p`
  margin: 22px 0 0;
  color: #988d9f;
  font-size: 14px;
  text-align: center;
`;

const LoginLink = styled.button`
  border: 0;
  background: transparent;
  color: #ffb0cd;
  cursor: pointer;
  font: inherit;
  font-weight: 800;
  padding: 0 0 0 6px;
`;

const SignUpPage = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    memberEmail: "",
    memberPwd: "",
    memberName: "",
    memberRole: "ROLE_USER",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await AxiosApi.signup(formData);
      alert("회원가입 성공! 환영합니다.");
      navigate("/login");
    } catch (error) {
      console.error("회원가입 실패:", error);
      alert("회원가입에 실패했습니다. 다시 시도해주세요.");
    }
  };

  return (
    <Page>
      <Shell>
        <IntroPanel>
          <Brand>FestaPick</Brand>
          <IntroTitle>
            취향에 맞는 축제를
            <br />더 빠르게 발견하세요
          </IntroTitle>
          <IntroCopy>
            계정을 만들면 관심 지역과 축제 취향을 기반으로 더 정교한 추천을 받을
            수 있습니다.
          </IntroCopy>
        </IntroPanel>

        <Card>
          <Header>
            <MobileBrand>FestaPick</MobileBrand>
            <Title>회원가입</Title>
            <SubTitle>페스타픽에서 나만의 축제 여정을 시작해 보세요.</SubTitle>
          </Header>

          <Form onSubmit={handleSubmit}>
            <Field>
              이메일
              <InputWrap>
                <Icon>mail</Icon>
                <Input
                  type="email"
                  name="memberEmail"
                  value={formData.memberEmail}
                  onChange={handleChange}
                  placeholder="example@festapick.com"
                  required
                />
              </InputWrap>
            </Field>

            <Field>
              비밀번호
              <InputWrap>
                <Icon>lock</Icon>
                <Input
                  type="password"
                  name="memberPwd"
                  value={formData.memberPwd}
                  onChange={handleChange}
                  placeholder="비밀번호를 입력하세요"
                  required
                />
              </InputWrap>
            </Field>

            <Field>
              이름
              <InputWrap>
                <Icon>person</Icon>
                <Input
                  type="text"
                  name="memberName"
                  value={formData.memberName}
                  onChange={handleChange}
                  placeholder="이름을 입력하세요"
                  required
                />
              </InputWrap>
            </Field>

            <SubmitButton type="submit">회원가입</SubmitButton>
          </Form>

          <FooterText>
            이미 계정이 있으신가요?
            <LoginLink type="button" onClick={() => navigate("/login")}>
              로그인
            </LoginLink>
          </FooterText>
        </Card>
      </Shell>
    </Page>
  );
};

export default SignUpPage;
