import { fireEvent, render, screen, waitFor } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import SignUpPage from "./SignUpPage";
import AxiosApi from "../api/AxiosApi";

const mockNavigate = jest.fn();

jest.mock("react-router-dom", () => ({
  ...jest.requireActual("react-router-dom"),
  useNavigate: () => mockNavigate,
}));

jest.mock("../api/AxiosApi", () => ({
  signup: jest.fn(),
}));

describe("SignUpPage UI 및 입력값 단위 테스트", () => {
  beforeEach(() => {
    jest.clearAllMocks();
    window.alert = jest.fn();
  });

  const renderSignUpPage = () => {
    render(
      <MemoryRouter>
        <SignUpPage />
      </MemoryRouter>,
    );
  };

  test("회원가입 화면의 필수 UI 요소가 렌더링된다", () => {
    renderSignUpPage();

    expect(screen.getByRole("heading", { name: "회원가입" })).toBeInTheDocument();
    expect(screen.getByPlaceholderText("example@festapick.com")).toBeInTheDocument();
    expect(screen.getByPlaceholderText("비밀번호를 입력하세요")).toBeInTheDocument();
    expect(screen.getByPlaceholderText("이름을 입력하세요")).toBeInTheDocument();
    expect(screen.getByRole("button", { name: "회원가입" })).toBeInTheDocument();
    expect(screen.getByRole("button", { name: "로그인" })).toBeInTheDocument();
  });

  test("초기 렌더링 시 입력 필드는 비어 있고 필수 입력 속성이 적용되어 있다", () => {
    renderSignUpPage();

    const emailInput = screen.getByPlaceholderText("example@festapick.com");
    const passwordInput = screen.getByPlaceholderText("비밀번호를 입력하세요");
    const nameInput = screen.getByPlaceholderText("이름을 입력하세요");
    const submitButton = screen.getByRole("button", { name: "회원가입" });

    expect(emailInput).toHaveValue("");
    expect(passwordInput).toHaveValue("");
    expect(nameInput).toHaveValue("");
    expect(emailInput).toBeRequired();
    expect(passwordInput).toBeRequired();
    expect(nameInput).toBeRequired();
    expect(submitButton).toBeEnabled();
  });

  test("입력 필드에 값을 입력하면 화면의 input value에 반영된다", () => {
    renderSignUpPage();

    const emailInput = screen.getByPlaceholderText("example@festapick.com");
    const passwordInput = screen.getByPlaceholderText("비밀번호를 입력하세요");
    const nameInput = screen.getByPlaceholderText("이름을 입력하세요");

    fireEvent.change(emailInput, { target: { value: "tester@example.com" } });
    fireEvent.change(passwordInput, { target: { value: "12345678" } });
    fireEvent.change(nameInput, { target: { value: "테스터" } });

    expect(emailInput).toHaveValue("tester@example.com");
    expect(passwordInput).toHaveValue("12345678");
    expect(nameInput).toHaveValue("테스터");
  });

  test("이메일 형식이 올바르지 않으면 email input의 유효성 검증이 실패한다", () => {
    renderSignUpPage();

    const emailInput = screen.getByPlaceholderText("example@festapick.com");

    fireEvent.change(emailInput, { target: { value: "wrong-email-format" } });

    expect(emailInput).toBeInvalid();
  });

  test("필수 입력값을 비운 채 제출하면 회원가입 API가 호출되지 않는다", () => {
    renderSignUpPage();

    const submitButton = screen.getByRole("button", { name: "회원가입" });

    fireEvent.click(submitButton);

    expect(AxiosApi.signup).not.toHaveBeenCalled();
  });

  test("정상 입력 후 제출하면 회원가입 API 호출, 성공 안내, 로그인 페이지 이동이 수행된다", async () => {
    AxiosApi.signup.mockResolvedValueOnce({ data: { success: true } });
    renderSignUpPage();

    fireEvent.change(screen.getByPlaceholderText("example@festapick.com"), {
      target: { value: "tester@example.com" },
    });
    fireEvent.change(screen.getByPlaceholderText("비밀번호를 입력하세요"), {
      target: { value: "12345678" },
    });
    fireEvent.change(screen.getByPlaceholderText("이름을 입력하세요"), {
      target: { value: "테스터" },
    });
    fireEvent.click(screen.getByRole("button", { name: "회원가입" }));

    await waitFor(() => {
      expect(AxiosApi.signup).toHaveBeenCalledWith({
        memberEmail: "tester@example.com",
        memberPwd: "12345678",
        memberName: "테스터",
        memberRole: "ROLE_USER",
      });
    });
    expect(window.alert).toHaveBeenCalledWith("회원가입 성공! 환영합니다.");
    expect(mockNavigate).toHaveBeenCalledWith("/login");
  });

  test("로그인 버튼을 클릭하면 로그인 페이지로 이동한다", () => {
    renderSignUpPage();

    fireEvent.click(screen.getByRole("button", { name: "로그인" }));

    expect(mockNavigate).toHaveBeenCalledWith("/login");
  });
});
