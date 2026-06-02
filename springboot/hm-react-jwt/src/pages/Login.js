import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import AxiosApi from "../api/AxiosApi";
import Common from "../utils/Commons";
import { useAuth } from "../context/AuthContext";

const LoginPage = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    memberEmail: "",
    memberPwd: "",
  });
  const { login } = useAuth();

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

      // 로그인 상태 업데이트
      const responseMe = await AxiosApi.authMe();
      const userData = responseMe.data.data;
      login(userData);

      console.log("로그인 성공:", userData);

      navigate("/", {
        state: { memberEmail: formData.memberEmail },
      });
    } catch (error) {
      console.error("로그인 실패:", error);
      alert("로그인에 실패했습니다. 다시 시도해주세요.");
    }
  };

  const handleSocialLogin = (provider) => {
    alert(`${provider}로 로그인하기는 아직 구현되지 않았습니다.`);
  };

  // Interactive background light follow effect
  useEffect(() => {
    const handleMouseMove = (e) => {
      const bgElements = document.querySelectorAll(".floating-bg");
      if (bgElements.length === 0) return;

      const x = e.clientX;
      const y = e.clientY;

      // Move subtle background lights slightly based on mouse
      const xMove = (x - window.innerWidth / 2) / 20;
      const yMove = (y - window.innerHeight / 2) / 20;

      bgElements.forEach((bg, index) => {
        const multiplier = index === 0 ? 1 : -1;
        bg.style.transform = `translate(${xMove * multiplier}px, ${yMove * multiplier}px)`;
      });
    };

    const handleInputFocus = (e) => {
      if (e.target.tagName === "INPUT") {
        const label = e.target
          .closest(".flex.flex-col.gap-unit-xs")
          ?.querySelector("label");
        if (label) label.classList.add("text-primary");
      }
    };

    const handleInputBlur = (e) => {
      if (e.target.tagName === "INPUT") {
        const label = e.target
          .closest(".flex.flex-col.gap-unit-xs")
          ?.querySelector("label");
        if (label) label.classList.remove("text-primary");
      }
    };

    document.addEventListener("mousemove", handleMouseMove);
    document.addEventListener("focusin", handleInputFocus);
    document.addEventListener("focusout", handleInputBlur);

    return () => {
      document.removeEventListener("mousemove", handleMouseMove);
      document.removeEventListener("focusin", handleInputFocus);
      document.removeEventListener("focusout", handleInputBlur);
    };
  }, []);

  return (
    <div className="dark">
      <style>{`
        body {
          font-family: 'Plus Jakarta Sans', sans-serif;
          background-color: #0b1326;
          margin: 0;
          padding: 0;
          overflow-x: hidden;
        }
        .glass-card {
          background: rgba(23, 31, 51, 0.7);
          backdrop-filter: blur(20px);
          border: 1px solid rgba(255, 255, 255, 0.1);
          box-shadow: 0 0 40px rgba(221, 183, 255, 0.1);
        }
        .neon-glow {
          box-shadow: 0 0 20px rgba(183, 109, 255, 0.4);
        }
        .gradient-button {
          background: linear-gradient(135deg, #b76dff 0%, #ffb0cd 100%);
          transition: all 0.3s ease;
          color: white;
          border: none;
          cursor: pointer;
        }
        .gradient-button:hover {
          transform: translateY(-2px);
          box-shadow: 0 8px 25px rgba(183, 109, 255, 0.5);
        }
        .floating-bg {
          position: absolute;
          width: 500px;
          height: 500px;
          border-radius: 50%;
          background: radial-gradient(circle, rgba(183, 109, 255, 0.15) 0%, rgba(11, 19, 38, 0) 70%);
          filter: blur(60px);
          z-index: -1;
        }
        .material-symbols-outlined {
          font-family: 'Material Symbols Outlined';
          font-weight: normal;
          font-style: normal;
          font-size: 24px;
          display: inline-block;
          line-height: 1;
          text-transform: none;
          letter-spacing: normal;
          word-wrap: normal;
          white-space: nowrap;
          direction: ltr;
        }
      `}</style>

      <div className="bg-[#0b1326] text-[#dae2fd] min-h-screen flex flex-col justify-center items-center relative p-4 overflow-hidden">
        {/* Animated background elements */}
        <div className="floating-bg top-[-100px] left-[-100px]"></div>
        <div
          className="floating-bg bottom-[-100px] right-[-100px]"
          style={{
            background:
              "radial-gradient(circle, rgba(255, 176, 205, 0.1) 0%, rgba(11, 19, 38, 0) 70%)",
          }}
        ></div>

        <main className="w-full max-w-[1024px] flex justify-center items-center py-12">
          <div className="glass-card w-full max-w-[440px] rounded-xl p-12 flex flex-col gap-6 animate-in fade-in zoom-in duration-700">
            {/* Brand Identity */}
            <div className="flex flex-col items-center gap-2">
              <div className="text-[#ddb7ff] font-bold text-5xl tracking-tight select-none drop-shadow-[0_0_10px_rgba(183,109,255,0.6)]">
                FestaPick
              </div>
              <div className="flex flex-col items-center">
                <h1 className="font-bold text-2xl text-[#dae2fd]">로그인</h1>
                <p className="font-normal text-base text-[#cfc2d6] text-center mt-2">
                  세상의 모든 축제, 페스타픽에서 만나보세요.
                </p>
              </div>
            </div>

            {/* Login Form */}
            <form className="flex flex-col gap-4" onSubmit={handleSubmit}>
              <div className="flex flex-col gap-2">
                <label className="font-semibold text-sm text-[#cfc2d6] ml-1">
                  이메일
                </label>
                <div className="relative">
                  <span className="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-[#988d9f] text-[20px]">
                    mail
                  </span>
                  <input
                    className="w-full bg-[#2d3449]/30 border border-[#4d4354] rounded-lg py-4 pl-12 pr-4 text-[#dae2fd] font-base focus:ring-2 focus:ring-[#ddb7ff] focus:border-transparent transition-all outline-none placeholder:text-[#988d9f]/50"
                    placeholder="example@festapick.com"
                    type="email"
                    name="memberEmail"
                    value={formData.memberEmail}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>

              <div className="flex flex-col gap-2">
                <label className="font-semibold text-sm text-[#cfc2d6] ml-1">
                  비밀번호
                </label>
                <div className="relative">
                  <span className="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-[#988d9f] text-[20px]">
                    lock
                  </span>
                  <input
                    className="w-full bg-[#2d3449]/30 border border-[#4d4354] rounded-lg py-4 pl-12 pr-4 text-[#dae2fd] font-base focus:ring-2 focus:ring-[#ddb7ff] focus:border-transparent transition-all outline-none placeholder:text-[#988d9f]/50"
                    placeholder="비밀번호를 입력하세요"
                    type="password"
                    name="memberPwd"
                    value={formData.memberPwd}
                    onChange={handleChange}
                    required
                  />
                </div>
              </div>

              <button
                type="submit"
                className="gradient-button w-full py-4 rounded-full text-white font-semibold text-sm mt-2 shadow-lg"
              >
                로그인
              </button>
            </form>

            {/* Social Logins */}
            <div className="flex flex-col gap-3">
              <div className="relative flex items-center py-2">
                <div className="flex-grow border-t border-[#4d4354]/30"></div>
                <span className="flex-shrink mx-4 text-[#988d9f] font-medium text-xs uppercase tracking-widest">
                  or
                </span>
                <div className="flex-grow border-t border-[#4d4354]/30"></div>
              </div>

              <div className="flex flex-col gap-3">
                <button
                  type="button"
                  onClick={() => handleSocialLogin("Google")}
                  className="flex items-center justify-center gap-3 w-full py-3.5 px-6 rounded-full border border-[#4d4354] bg-[#131b2e] hover:bg-[#171f33] transition-colors duration-200"
                >
                  <svg className="w-5 h-5" viewBox="0 0 24 24">
                    <path
                      d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z"
                      fill="#4285F4"
                    ></path>
                    <path
                      d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z"
                      fill="#34A853"
                    ></path>
                    <path
                      d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l3.66-2.84z"
                      fill="#FBBC05"
                    ></path>
                    <path
                      d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53z"
                      fill="#EA4335"
                    ></path>
                  </svg>
                  <span className="font-semibold text-sm text-[#dae2fd]">
                    Google로 계속하기
                  </span>
                </button>

                <button
                  type="button"
                  onClick={() => handleSocialLogin("Kakao")}
                  className="flex items-center justify-center gap-3 w-full py-3.5 px-6 rounded-full bg-[#FEE500] hover:bg-[#FEE500]/90 transition-opacity duration-200"
                >
                  <svg className="w-5 h-5" fill="#3C1E1E" viewBox="0 0 24 24">
                    <path d="M12 3c-4.97 0-9 3.18-9 7.11 0 2.55 1.7 4.79 4.26 6.06l-.82 3.01c-.05.18.06.37.24.42.06.02.12.01.18-.01l3.52-2.34c.54.06 1.1.09 1.62.09 4.97 0 9-3.18 9-7.11 0-3.93-4.03-7.22-9-7.22z"></path>
                  </svg>
                  <span className="font-semibold text-sm text-[#3C1E1E]">
                    Kakao로 계속하기
                  </span>
                </button>
              </div>
            </div>

            {/* Links */}
            <div className="flex justify-center items-center gap-4 mt-2">
              <button
                type="button"
                className="font-semibold text-sm text-[#ddb7ff] hover:underline transition-all bg-transparent border-0 cursor-pointer p-0"
                onClick={() => navigate("/signup")}
              >
                회원가입
              </button>
              <div className="w-1 h-1 rounded-full bg-[#4d4354]"></div>
              <a
                className="font-semibold text-sm text-[#cfc2d6] hover:text-[#dae2fd] transition-all"
                href="#"
              >
                비밀번호 찾기
              </a>
            </div>
          </div>
        </main>

        {/* Footer for identity (Simplified for Login) */}
        <footer className="w-full max-w-[1024px] mx-auto px-4 py-6 mt-auto opacity-60">
          <div className="flex flex-col md:flex-row justify-between items-center gap-4">
            <p className="font-base text-base text-[#cfc2d6]">
              © 2024 FestaPick. Celebrating kinetic energy.
            </p>
            <div className="flex gap-4">
              <a
                className="font-semibold text-sm text-[#cfc2d6] hover:text-[#ddb7ff] transition-colors"
                href="#"
              >
                About Us
              </a>
              <a
                className="font-semibold text-sm text-[#cfc2d6] hover:text-[#ddb7ff] transition-colors"
                href="#"
              >
                Customer Center
              </a>
            </div>
          </div>
        </footer>
      </div>
    </div>
  );
};

export default LoginPage;
