import { useEffect, useState } from "react";
import TaskForm from "./components/TaskForm.jsx";
import TaskList from "./components/TaskList.jsx";
import TaskSummary from "./components/TaskSummary.jsx";
import { getTasks, createTask } from "./api.js";

export default function App() {
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [listError, setListError] = useState("");
  const [saving, setSaving] = useState(false);
  const [readAttempt, setReadAttempt] = useState(0);

  useEffect(() => {
    const controller = new AbortController();
    setLoading(true);
    setListError("");
    getTasks(controller.signal)
      .then((data) => { if (!controller.signal.aborted) setTasks(data); })
      .catch(() => {
        if (!controller.signal.aborted) setListError("Could not load tasks. Check that the backend is running, then retry.");
      })
      .finally(() => { if (!controller.signal.aborted) setLoading(false); });
    return () => controller.abort();
  }, [readAttempt]);

  async function addTask(task) {
    setSaving(true);
    try {
      const created = await createTask(task);
      setTasks((current) => current.some((item) => item.id === created.id)
        ? current : [...current, created]);
    } finally {
      setSaving(false);
    }
  }

  function toggleTask(id) {
    setTasks((current) => current.map((task) => task.id === id
      ? { ...task, completed: !task.completed } : task));
  }
  function deleteTask(id) {
    setTasks((current) => current.filter((task) => task.id !== id));
  }

  return (
    <main className="app-shell">
      <section className="app-card" aria-labelledby="page-title">
        <header className="app-header">
          <p className="eyebrow">INEW-2434 | Module 3 Phase 2</p>
          <h1 id="page-title">React Task Tracker</h1>
          <p>Add tasks and priorities to your Spring Boot task list.</p>
        </header>
        <TaskForm onAddTask={addTask} saving={saving} loading={loading} />
        {loading ? <p role="status">Loading tasks…</p> : listError ? (
          <div><p role="alert">{listError}</p>
            <button type="button" disabled={saving} onClick={() => setReadAttempt((n) => n + 1)}>Retry</button>
          </div>
        ) : (
          <>
            <TaskSummary tasks={tasks} />
            <p>Completion and deletion below affect this view only and reset on refresh.</p>
            <TaskList tasks={tasks} onToggleTask={toggleTask} onDeleteTask={deleteTask} />
          </>
        )}
      </section>
    </main>
  );
}
