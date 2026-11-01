# React Task Tracker Starter

This is the starter project for HCC INEW-2434 Module 2: React Frontend Foundations.

## What this project demonstrates

- React functional components
- Props and parent-child communication
- `useState`
- Form events and validation
- List rendering with stable keys
- Conditional rendering
- Responsive CSS
- Basic accessibility practices

The project intentionally uses local React state only. Students will connect it to a Java Spring Boot REST API in a later module.

## Prerequisites

Install:

1. Node.js LTS from https://nodejs.org/en/download/
2. An editor or IDE. Recommended options are PyCharm, Visual Studio Code, or IntelliJ IDEA Community Edition.

## Run the project

Open a terminal in this folder and run:

```bash
npm install
npm run dev
```

Open the local URL printed by Vite, usually `http://localhost:5173`.

To create a production build:

```bash
npm run build
```

## PyCharm setup

1. Download PyCharm from https://www.jetbrains.com/pycharm/download/.
2. Open PyCharm and choose **Open**.
3. Select the `react-task-tracker-starter` folder.
4. Open the built-in terminal from **View > Tool Windows > Terminal**.
5. Run `npm install`.
6. Run `npm run dev`.
7. Open the URL displayed in the terminal.

PyCharm is used here as the editor and terminal. React itself runs through Node.js and Vite.

## VS Code setup

1. Download VS Code from https://code.visualstudio.com/.
2. Choose **File > Open Folder**.
3. Select this project folder.
4. Open **Terminal > New Terminal**.
5. Run `npm install`, then `npm run dev`.

## Student extension tasks

After running the starter project, students should:

1. Add a priority field to each task.
2. Add a filter for All, Active, and Completed tasks.
3. Add an edit-task feature.
4. Move the starter data into a separate data file.
5. Add a `TaskSummary` component.
6. Explain where `fetch()` would be used to call `GET /api/tasks` in Spring Boot.

## Common problems

**`npm: command not found`**: Node.js is not installed or the terminal must be restarted after installation.

**Port already in use**: Open the alternative URL printed by Vite, or stop the other development server.

**Blank page**: Check the terminal for errors and confirm the file names match the imports exactly.

**Changes do not appear**: Save the file and refresh the browser. Vite normally reloads the page automatically.

## Responsible AI use

AI tools may help explain errors or suggest ideas. Students must understand, test, and be able to explain submitted code. Do not submit API keys, passwords, or private information.
