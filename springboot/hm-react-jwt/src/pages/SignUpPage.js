import { useState } from "react";
import { useNavigate } from "react-router-dom";
import AxiosApi from "../api/AxiosApi";

const SignUpPage = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    memberEmail: "",
    memberPwd: "",
    memberName: "",
    authorities: "ROLE_USER",
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
    <>
      <h2>회원가입</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>이메일:</label>
          <input
            type="email"
            name="memberEmail"
            value={formData.memberEmail}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>비밀번호:</label>
          <input
            type="password"
            name="memberPwd"
            value={formData.memberPwd}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>이름:</label>
          <input
            type="text"
            name="memberName"
            value={formData.memberName}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">회원가입</button>
      </form>
    </>
  );
};

export default SignUpPage;
