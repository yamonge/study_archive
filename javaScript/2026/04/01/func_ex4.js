function greet(name = "손님", greeting = "안녕하세요.") {
  console.log(`${greeting} ${name}`);
}

greet();
greet("길동님");
greet("길동님", "반갑습니다.");
