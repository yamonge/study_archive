import AxiosInstance from "./AxiosInstance";
import Common from "../utils/Commons";
import axios from "axios";

const publicApi = axios.create({ baseURL: Common.HM_DOMAIN });

const AxiosApi = {
  // 인증 (Auth)
  login: (credentials) => publicApi.post("/member/login", credentials),
  signup: (userInfo) => publicApi.post("/member/signup", userInfo),

  // 게시글 전체 조회(페이지 네이션)
  getPosts: (page = 0, size = 10) =>
    AxiosInstance.get("/posts", { params: { page, size } }),

  // 게시글 상세 조회
  getPost: (postId) => AxiosInstance.get(`/posts/${postId}`),

  // 게시글 작성
  createPost: (postData) => AxiosInstance.post("/posts", postData),

  // 게시글 수정
  updatePost: (postId, postData) =>
    AxiosInstance.put(`/posts/${postId}`, postData),

  // 게시글 삭제
  deletePost: (postId) => AxiosInstance.delete(`/posts/${postId}`),

  // 댓글 조회
  getComments: (postId) => AxiosInstance.get(`/posts/${postId}/comments`),

  // 댓글 작성
  createComment: (postId, commentData) =>
    AxiosInstance.post(`/posts/${postId}/comments`, commentData),

  // 댓글 수정
  updateComment: (postId, commentId, commentData) =>
    AxiosInstance.put(`/posts/${postId}/comments/${commentId}`, commentData),

  // 댓글 삭제
  deleteComment: (postId, commentId) =>
    AxiosInstance.delete(`/posts/${postId}/comments/${commentId}`),

  // 회원 전체 조회(페이지 네이션)
  getMembers: (page = 0, size = 20) =>
    AxiosInstance.get("/members/showall", { params: { page, size } }),

  // 회원 상세 조회
  getMember: (memberEmail) =>
    AxiosInstance.get(`/member/detail`, {
      params: { memberEmail: memberEmail },
    }),

  // 회원 정보 수정
  updateMember: (memberId, memberData) =>
    AxiosInstance.put(`/members/${memberId}`, memberData),

  // 회원 탈퇴
  deleteMember: (memberId) => AxiosInstance.delete(`/members/${memberId}`),
};

export default AxiosApi;
