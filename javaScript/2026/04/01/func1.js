function birdSing() {
  console.log("새가 즐겁게 노래합니다");
}

function catCry() {
  console.log("고양이가 슬프게 웁니다.");
}

function dogDance() {
  console.log("강아지가 신나게 춤을 춥니다.");
}

function swimFish(name) {
  console.log(`${name} 가 수영을 합니다`);
}

function checkAnimalMood(callback, ...args) {
  callback(...args);
}

function checkFunc(...arg) {
  if (arg[0] == "happy") {
    arg[1]();
  } else {
    arg[2]();
  }
}

function checkFunc2(mood, action) {
  if (action[mood]) {
    action[mood]();
  } else {
    action.sleepy;
  }
}

// checkAnimalMood(birdSing);
// checkAnimalMood(catCry);
// checkAnimalMood(dogDance);
// checkAnimalMood(swimFish, "참다랑어");
// checkFunc("happy", birdSing, catCry);
checkFunc2("happy", {
  happy: dogDance,
  sad: catCry,
  angry: birdSing,
  sleepy: () => console.log("잠을 잡니다"),
});
