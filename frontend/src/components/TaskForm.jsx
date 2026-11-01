import { useRef, useState } from "react";
import { isValidTitle } from "../validation.mjs";

export default function TaskForm({ onAddTask, saving, loading }) {
  const [title, setTitle] = useState("");
  const [priority, setPriority] = useState("medium");
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");
  const submitting = useRef(false);

  async function handleSubmit(event) {
    event.preventDefault();
    if (submitting.current) return;
    setError("");
    setSuccess("");
    if (!isValidTitle(title)) {
      setError("Please enter a task title; spaces alone are not enough.");
      return;
    }
    if (title.trim().length > 80) {
      setError("Task titles must be at most 80 characters.");
      return;
    }
    submitting.current = true;
    try {
      await onAddTask({ title: title.trim(), priority });
      setTitle("");
      setPriority("medium");
      setSuccess("Task added successfully.");
    } catch (error) {
      setError(error instanceof TypeError
        ? "Could not save your task. Check that the backend is running. Your entries have been kept."
        : error.message);
    } finally {
      submitting.current = false;
    }
  }

  return (
    <form className="task-form" onSubmit={handleSubmit}>
      <label htmlFor="task-title">New task (required)</label>
      <input type="text" id="task-title" value={title} disabled={saving || loading}
        onChange={(event) => setTitle(event.target.value)}
        aria-required="true" aria-invalid={Boolean(error)}
        aria-describedby={error ? "task-error" : undefined} />
      <label htmlFor="task-priority">Priority</label>
      <select id="task-priority" value={priority} disabled={saving || loading}
        onChange={(event) => setPriority(event.target.value)}>
        <option value="low">Low</option>
        <option value="medium">Medium</option>
        <option value="high">High</option>
      </select>
      <button type="submit" disabled={saving || loading}>{saving ? "Saving…" : "Add task"}</button>
      {saving && <p role="status">Saving task…</p>}
      {error && <p id="task-error" className="form-error" role="alert">{error}</p>}
      <p role="status">{success}</p>
    </form>
  );
}
