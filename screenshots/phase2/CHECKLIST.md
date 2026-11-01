# Required evidence — capture from the real application

Use DevTools Network with the task endpoints and priority model from the instructor clarification.
- test-a.png: list and GET http://localhost:8080/api/tasks, 200, JSON array.
- test-b.png: create "Start a coding club", priority high. Show POST JSON,
  201 response with id/title/priority/completed, row once, success and cleared form.
  Add extra screenshots if needed for payload and response.
- test-c.png: task remains after browser refresh without backend restart.
- test-d.png: title consisting only of spaces; visible validation, no POST in cleared Network log.
- test-d-postman.png: direct spaces-only title POST returns 400; GET proves no extra record.
- test-e.png: stop backend and refresh; failed read and Retry visible.
- test-e-retry.png: restart backend and click Retry; successful GET and list/empty state.
- test-e-save.png: after a successful read, stop backend without refreshing;
  submit a valid task; show error, saving stopped and both fields preserved.
- loading.png: throttle network temporarily to capture Loading tasks…, then disable throttling.
- backend-tests.png: mvn test passes with all tests enabled.
- frontend-tests.png: all three node validation tests pass.
- build.png: npm run build succeeds.

Postman valid payload: {"title":"Start a coding club","priority":"high"}
Invalid payload: {"title":"   ","priority":"medium"}
Refresh preserves created tasks in backend memory; backend restart clears task storage.
No screenshots in this folder have been fabricated. Add your own evidence before submitting.
