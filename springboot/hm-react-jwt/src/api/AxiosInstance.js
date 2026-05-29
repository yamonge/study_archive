import axios from "axios";
import Common from "./utils/Commons";

// 공통 axios 객체
const AxiosInstance = axios.create({
  baseURL: Common.HM_DOMAIN,
  headers: {
    "Content-Type": "application/json",
  },
});

// 요청 인터셉터
AxiosInstance.interceptors.request.use(
  (config) => {
    const accessToken = Common.getAccessToken();

    if (accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

// 응답 인터셉터
AxiosInstance.interceptors.response.use(
  (response) => {
    return response;
  },
  async (error) => {
    const originalRequest = error.config;

    // 서버 응답이 없거나 요청 정보가 없으면 그대로 에러 반환
    if (!error.response || !originalRequest) {
      return Promise.reject(error);
    }

    // accessToken 만료 또는 인증 실패
    if (error.response.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;

      try {
        const refreshToken = Common.getRefreshToken();

        if (!refreshToken) {
          throw new Error("refreshToken 없음");
        }

        const response = Common.handleUnauthorized();

        const newAccessToken = response.data.accessToken;

        Common.setAccessToken(newAccessToken);

        originalRequest.headers.Authorization = `Bearer ${newAccessToken}`;

        return AxiosInstance(originalRequest);
      } catch (reissueError) {
        Common.setAccessToken(null);
        Common.setRefreshToken(null);

        alert("로그인이 만료되었습니다. 다시 로그인해주세요.");
        window.location.href = "/login"; // 로그인 페이지로 리다이렉트

        return Promise.reject(reissueError);
      }
    }

    return Promise.reject(error);
  },
);

export default AxiosInstance;
