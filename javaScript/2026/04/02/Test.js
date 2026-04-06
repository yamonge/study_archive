const container = document.getElementById("menu-container");
const wheel = document.getElementById("wheel");
const cards = document.querySelectorAll(".card");
const indicator = document.getElementById("indicator");

// 반경이 줄고 카드가 커졌으므로 각도를 약간 넓혀 자연스러운 겹침 유도
const angleStep = 15;
const startOffset = -((cards.length - 1) * angleStep) / 2;

let currentAngle = 0;
let isDragging = false;
let startX = 0;
let startAngle = 0;
let dragDistance = 0;

// 드래그 중 실시간으로 가장 가까운 카드를 찾고,
// 거리에 따라 Z-index를 동적으로 부여하여 중앙 카드가 항상 맨 위에 오도록 함
const updateFocusDuringDrag = () => {
  let closestCard = null;
  let minDiff = Infinity;

  cards.forEach((card) => {
    const cardAngle = parseFloat(card.dataset.angle);
    const diff = Math.abs(cardAngle - -currentAngle);

    // ★ 동적 Z-index 계산: 중앙(diff=0)일수록 높은 값을 가짐 (완벽한 레이어 정렬)
    card.style.zIndex = Math.round(100 - diff);

    if (diff < minDiff) {
      minDiff = diff;
      closestCard = card;
    }
  });

  if (closestCard && !closestCard.classList.contains("focused")) {
    cards.forEach((c) => c.classList.remove("focused"));
    closestCard.classList.add("focused");
    updateIndicatorColor(closestCard);
  }
};

// 초기 세팅
cards.forEach((card, index) => {
  const angle = startOffset + index * angleStep;
  card.style.setProperty("--angle", `${angle}deg`);
  card.dataset.angle = angle;

  if (card.classList.contains("focused")) {
    currentAngle = -angle;
    wheel.style.setProperty("--global-angle", `${currentAngle}deg`);
    updateIndicatorColor(card);
  }
});

// 처음 로드될 때 Z-index 및 포커스 정렬 한번 실행
updateFocusDuringDrag();

const startDrag = (e) => {
  isDragging = true;
  dragDistance = 0;
  startX = e.type.includes("mouse") ? e.pageX : e.touches[0].pageX;
  startAngle = currentAngle;
  wheel.style.transition = "none";
};

const moveDrag = (e) => {
  if (!isDragging) return;
  e.preventDefault();
  const x = e.type.includes("mouse") ? e.pageX : e.touches[0].pageX;
  const dx = x - startX;
  dragDistance = Math.abs(dx);

  // ★ 드래그 민감도 대폭 축소 (0.25 -> 0.12)
  // 숫자가 작을수록 무겁고 뻑뻑하게 돌아감 (휙휙 넘어가는 현상 방지)
  currentAngle = startAngle + dx * 0.12;

  const maxLimit = Math.abs(startOffset) + 15;
  if (currentAngle > maxLimit) currentAngle = maxLimit;
  if (currentAngle < -maxLimit) currentAngle = -maxLimit;

  wheel.style.setProperty("--global-angle", `${currentAngle}deg`);
  updateFocusDuringDrag();
};

const endDrag = () => {
  if (!isDragging) return;
  isDragging = false;
  wheel.style.transition = "transform 0.5s cubic-bezier(0.25, 1, 0.5, 1)";

  if (dragDistance > 3) {
    snapToClosestCard();
  }
};

const snapToClosestCard = () => {
  const focusedCard = document.querySelector(".card.focused");
  if (focusedCard) {
    const targetAngle = -parseFloat(focusedCard.dataset.angle);
    currentAngle = targetAngle;
    wheel.style.setProperty("--global-angle", `${currentAngle}deg`);

    // 스냅되는 동안의 회전도 반영하기 위해 약간의 지연 후 레이어 재정렬
    setTimeout(updateFocusDuringDrag, 50);
  }
};

const jumpToCard = (card) => {
  const targetAngle = -parseFloat(card.dataset.angle);
  currentAngle = targetAngle;
  wheel.style.transition = "transform 0.5s cubic-bezier(0.25, 1, 0.5, 1)";
  wheel.style.setProperty("--global-angle", `${currentAngle}deg`);

  // 클릭으로 넘어갈 때도 Z-index 자연스럽게 업데이트
  updateFocusDuringDrag();
  updateIndicatorColor(card);
};

function updateIndicatorColor(card) {
  const glowColor = card.style.getPropertyValue("--c1-glow");
  if (glowColor) {
    indicator.style.background = glowColor.replace("0.5", "0.7");
  }
}

cards.forEach((card) => {
  card.addEventListener("click", () => {
    if (dragDistance > 3) return;
    jumpToCard(card);
  });
});

container.addEventListener("mousedown", startDrag);
container.addEventListener("touchstart", startDrag, { passive: false });
window.addEventListener("mousemove", moveDrag);
window.addEventListener("touchmove", moveDrag, { passive: false });
window.addEventListener("mouseup", endDrag);
window.addEventListener("touchend", endDrag);
