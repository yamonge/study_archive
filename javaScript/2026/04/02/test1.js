// src/api/apiInstance.js
import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-Type": "application/json",
  },
});

// 요청 보내기 직전 실행
api.interceptors.request.use(
  (config) => {
    const accessToken = localStorage.getItem("accessToken");

    if (accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }

    return config;
  },
  (error) => Promise.reject(error)
);

// 응답 받은 직후 실행
api.interceptors.response.use(
  (response) => response,
  async (error) => {
    const originalRequest = error.config;

    if (
      error.response?.status === 401 &&
      !originalRequest._retry
    ) {
      originalRequest._retry = true;

      try {
        const refreshToken = localStorage.getItem("refreshToken");

        if (!refreshToken) {
          throw new Error("refreshToken 없음");
        }

        const res = await axios.post("http://localhost:8080/member/reissue", {
          refreshToken,
        });

        const tokenData = res.data.data;

        localStorage.setItem("accessToken", tokenData.accessToken);
        localStorage.setItem("refreshToken", tokenData.refreshToken);

        originalRequest.headers.Authorization = `Bearer ${tokenData.accessToken}`;

        return api(originalRequest);
      } catch (reissueError) {
        localStorage.removeItem("accessToken");
        localStorage.removeItem("refreshToken");

        window.location.href = "/login";

        return Promise.reject(reissueError);
      }
    }

    return Promise.reject(error);
  }
);

export default api;