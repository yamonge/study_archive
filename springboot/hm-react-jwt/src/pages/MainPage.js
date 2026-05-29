import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import AxiosApi from "../api/AxiosApi";

const MainPage = () => {
  const navigate = useNavigate();
  const { memberEmail } = useParams();
  const [message, setMessage] = useState("메인 페이지에 오신 것을 환영합니다!");
  const { resMemberEmail, setResMemberEmail } = useParams();
  const { resMemberName, setResMemberName } = useParams();

  const handleLogout = () => {
    localStorage.clear();
    alert("로그아웃 되었습니다.");
    navigate("/login");
  };

  // 로그인시 멤버 정보 표기 없으면 빈 내용 표시
  useEffect(() => {
    const fetchMemberInfo = async () => {
      try {
        const response = await AxiosApi.getMember(memberEmail);
        setResMemberName(response.data.data.memberName);
        setResMemberEmail(response.data.data.memberEmail);
        setMessage(`환영합니다, ${response.data.data.memberName}님!`);
      } catch (error) {
        console.error("멤버 정보 조회 실패:", error);
        setMessage("메인 페이지에 오신 것을 환영합니다!");
      }
    };

    fetchMemberInfo();
  }, []);

  return (
    <div>
      <h1>{message}</h1>
      <button onClick={handleLogout}>로그아웃</button>
      <div>{resMemberEmail}</div>
      <div>{resMemberName}</div>
    </div>
  );
};

export default MainPage;
