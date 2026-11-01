# Phase 2 reflection — complete after running the application

## Request journey
TaskForm prevents the normal page submission and validates the title. App calls
createTask in api.js, which sends JSON to Spring Boot. TaskController validates
TaskRequest, TaskStore assigns an ID and stores the task, and the API returns 201.
React appends that returned task and clears the form after success.

## Props versus state
App owns tasks and request state. It passes tasks to TaskList and TaskSummary.
TaskList passes each task to TaskCard. TaskForm owns its field values and receives
the onAddTask callback through props.

## Frontend versus backend validation
The frontend gives immediate feedback and blocks a blank or spaces-only title.
The backend validates independently because Postman or another client can bypass React.
Priority must use the same low/medium/high values in both layers.

## One bug I fixed
The Maven “no POM in this directory” problem was resolved by opening the terminal in the folder containing pom.xml.

## Refresh versus backend restart
I created a task called “Start a coding club” with High priority. After refreshing the browser, the task still appeared because React loaded it from the running Spring Boot backend. After restarting Spring Boot, the task list was empty because tasks are stored temporarily in backend memory.

## Failure and recovery
When I stopped the Spring Boot backend and refreshed the page, the tracker displayed a loading-error message and a Retry button. After restarting the backend and clicking Retry, the task list loaded successfully. When I tried to save “Practice API testing” with High priority while the backend was down, an error appeared and saving stopped. The title and priority remained in the form so I could try again.
