import { useState } from "react";
import { useNavigate } from "react-router-dom";
import AxiosApi from "../api/AxiosApi";
import Common from "../utils/Commons";

const LoginPage = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    memberEmail: "",
    memberPwd: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await AxiosApi.login(formData);
      const { accessToken, refreshToken } = response.data.data;
      Common.setAccessToken(accessToken);
      Common.setRefreshToken(refreshToken);
      navigate("/", {
        state: { memberEmail: formData.memberEmail },
      });
    } catch (error) {
      console.error("로그인 실패:", error);
      alert("로그인에 실패했습니다. 다시 시도해주세요.");
    }
  };

  return (
    <>
      <h2>로그인</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>아이디:</label>
          <input
            type="text"
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
        <button type="submit">로그인</button>
      </form>
    </>
  );
};

export default LoginPage;
