function addTodo() {
  const ul = document.getElementById("todoList");
  const li = document.createElement("li");
  const input = document.getElementById("todoInput");
  const text = input.value;

  li.textContent = text;
  ul.appendChild(li);
}
