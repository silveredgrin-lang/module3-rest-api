export default function TaskSummary({ tasks }) {
  const completed = tasks.filter((task) => task.completed).length;
  return (
    <section className="summary" aria-label="Task summary">
      <span>{tasks.length - completed} active</span>
      <span>{completed} completed</span>
      <span>{tasks.length} total</span>
    </section>
  );
}
