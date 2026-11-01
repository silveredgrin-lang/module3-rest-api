export default function TaskCard({ task, onToggle, onDelete }) {
  return (
    <li className={`task-card ${task.completed ? "completed" : ""}`}>
      <label className="task-label">
        <input
          type="checkbox"
          checked={task.completed}
          onChange={() => onToggle(task.id)}
        />
        <span>{task.title} — Priority: {task.priority}</span>
      </label>
      <button className="delete-button" type="button" onClick={() => onDelete(task.id)}>
        Delete
      </button>
    </li>
  );
}
