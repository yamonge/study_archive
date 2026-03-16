// 1. 색상을 바꿀 요소들을 모두 선택합니다.
const nav = document.querySelector(".nav");
const menuLinks = document.querySelectorAll(".menu ul li");
const loginBtn1 = document.querySelector(".login_bar button:nth-child(1)");

// 2. 색상이 바뀔 기준점이 되는 섹션
const section2 = document.querySelector(".main_02_container");

const observer = new IntersectionObserver(
  (entries) => {
    entries.forEach((entry) => {
      if (entry.isIntersecting) {
        // [직접 속성 변경] 밝은 배경으로 변경
        nav.style.backgroundColor = "white";
        nav.style.color = "#02093a";
        loginBtn1.style.color = "#02093a";

        // 여러 개인 요소들은 반복문으로 변경
        menuLinks.forEach((li) => (li.style.color = "#02093a"));
      } else {
        // [직접 속성 변경] 원래 남색 배경으로 복구
        nav.style.backgroundColor = "#02093a";
        nav.style.color = "white";
        loginBtn1.style.color = "white";

        menuLinks.forEach((li) => (li.style.color = "white"));
        svgPaths.forEach((path) => (path.style.fill = "white"));

        nav.style.borderBottom = "none";
      }
    });
  },
  { rootMargin: "0px 0px -600px 0px" },
);

observer.observe(section2);
