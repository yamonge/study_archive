import axios from "axios";
import Common from "../utils/Commons";

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

    // accessToken 만료 또는 인증 실패
    if (error.response.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;

      const refreshToken = Common.getRefreshToken();

      if (!refreshToken) {
        throw new Error("refreshToken 없음");
      }

      const response = Common.handleUnauthorized();

      if (response) {
        originalRequest.headers.Authorization = `Bearer ${Common.getAccessToken()}`;
        return AxiosInstance(originalRequest);
      }

      localStorage.clear();
      window.location.href = "/login";
    }

    return Promise.reject(error);
  },
);

export default AxiosInstance;
