import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Container, Form } from "./Default_Css";

const Login = () => {
  const [email, setEmail] = useState("");
  const [pwd, setPwd] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    navigate(`/home`, {
      state: {
        email: email,
        pwd: pwd,
      },
    });
  };

  return (
    <>
      <Form onSubmit={handleSubmit} $f1={true}>
        <Container $a1={true} w={"40%"} p={"30px 0px"}>
          이메일:
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </Container>
        <Container $a1={true} w={"40%"} p={"30px 0px"}>
          비밀번호:{" "}
          <input
            type="password"
            value={pwd}
            onChange={(e) => setPwd(e.target.value)}
          />
        </Container>
        <Container $a1={true} w={"40%"} p={"30px 0px"}>
          <input type="submit" value="로그인" />
        </Container>
      </Form>
    </>
  );
};

export default Login;
