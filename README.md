# Module 3 Phase 2: Connected Task Tracker

Extends the uploaded React tracker and Java Spring Boot Phase 1 API. Keeps App,
TaskForm, TaskList and TaskCard; adds TaskSummary and priority.

## Prerequisites
Java 17, Maven, and Node.js LTS supported by the installed Vite version.
Use `npm ci` to install the versions pinned in frontend/package-lock.json.

## Start both servers
Terminal 1, repository root (contains pom.xml):
```sh
mvn test
mvn spring-boot:run
```
Backend: http://localhost:8080

Terminal 2, repository root:
```sh
cd frontend
npm ci
npm run dev -- --port 5173 --strictPort
```
Frontend: http://localhost:5173
CORS explicitly allows this origin, GET/POST, and Content-Type. If changing the
frontend port, also update TaskController's CORS origin and restart Spring Boot.
The backend URL is defined once in frontend/src/api.js.

## Task API
GET /api/tasks returns 200 with an array (initially empty).
POST /api/tasks accepts JSON such as:
```json
{"title":"Start a coding club","priority":"high"}
```
Returns 201 with server-generated id, trimmed title, priority and completed:false.
Title must be nonblank and at most 80 characters. Priority must be low, medium,
or high. Invalid input returns 400 without adding a task.
Task model: { id, title, priority, completed }.

React reads real backend tasks on mount, aborts obsolete reads, checks HTTP
responses, and adds the returned task once. Failed saves preserve form entries.
Retry reloads a failed list. Frontend validation blocks spaces-only titles before POST.

## Scope and storage
Storage is temporary backend memory. Browser refresh reloads created tasks from
the API; backend restart resets the task list. No database or login is needed.
The original completion/delete controls operate on the current React view only;
their changes reset on refresh. They do not call update/delete endpoints.
The original /api/ideas API and its tests remain for Phase 1 compatibility;
React uses /api/tasks. Original instructions are in README-phase1.md.

## Automated checks
Repository root:
```sh
mvn test
```
frontend directory:
```sh
node --test tests/validation.test.mjs
npm run build
```
All Phase 1 tests remain enabled. Added TaskApiTest covers reads, valid creation,
spaces-only input, invalid priority and CORS. IdeaApiTest also checks spaces-only input.

## Browser/Postman evidence
Follow screenshots/phase2/CHECKLIST.md. Save actual screenshots from your running
application, including readable method, URL, HTTP status, JSON payload/response.
Tests/build alone do not replace browser evidence.
See CHECKS.md for checks performed on the prepared package and limitations.
Complete reflection.md with your own observations before submission.

## GitHub submission
Use the existing module3-rest-api repository. Copy these files into that checkout,
keeping its .git directory and any original ignore rules. Do not upload target,
node_modules, dist, .vs, .env, or secrets. Commit package.json and package-lock.json.
Review `git status`, then stage the intended source, tests, docs and evidence:
```sh
git add .
git commit -m "Complete Module 3 Phase 2 React Integration"
git push
```
Confirm source, tests, README, reflection and screenshots are visible on GitHub.
Submit the repository URL and reply to the instructor's email with that URL as clarified.
