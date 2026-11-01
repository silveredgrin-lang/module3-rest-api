const API_URL = "http://localhost:8080/api/tasks";

async function readResponse(response) {
  if (!response.ok) {
    if (response.status === 400) {
      throw new Error("Check your task: title must contain 1–80 characters and priority must be low, medium, or high.");
    }
    throw new Error(`Request failed (HTTP ${response.status}). Please try again.`);
  }
  return response.json();
}

export async function getTasks(signal) {
  const response = await fetch(API_URL, { signal });
  const tasks = await readResponse(response);
  if (!Array.isArray(tasks)) throw new Error("The server returned an unexpected task list.");
  return tasks;
}

export async function createTask(task) {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task),
  });
  return readResponse(response);
}
