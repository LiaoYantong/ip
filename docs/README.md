# Stewie Chatbot – User Guide

**Stewie** is a desktop application that helps you manage your tasks with a sarcastic flair, packaged in a clean and minimalist GUI. :D



---

## Feature List

- **Adding Tasks:** `todo | deadline | event`
- **Listing Tasks:** `list`
- **Finding Tasks:** `find`
- **Completing Tasks:** `mark | unmark`
- **Deleting Tasks:** `delete`
- **Exiting the App:** `bye`
- **Persistent Storage:** Tasks are automatically saved and loaded from disk.

---

## Adding Tasks

**Description:**  
Add tasks for Stewie to keep track of! There are three types:

### 1. Todo
`todo <task-name>`

General task with no date or time.

**Example:**  
`todo Buy groceries`

Creates a Todo Task named “Buy groceries”.

### 2. Deadline
`deadline <task-name> /by <yyyy-MM-dd>`

Task that must be completed by a certain date.

**Example:**  
`deadline Submit report /by 2026-03-01`

Creates a Deadline Task named “Submit report” due on 1st March 2026.

### 3. Event
`event <task-name> /slot <date1> /slot <date2> ...`

Event with tentative slots. You can confirm one slot later.

**Example:**  
`event Team meeting /slot 2026-02-20 /slot 2026-02-21`

Creates an Event Task named “Team meeting” with tentative slots on 20th and 21st February 2026.

---

## Listing Tasks

**Description:**  
List all tasks that have been added.

**Format:**  
`list`


---

## Finding Tasks

**Description:**  
Search for a specific task by its name (case-insensitive).

**Format:**  
`find <partial-task-name>`


**Example:**  
If Stewie has tasks:  

`Buy groceries`

`Submit report`

`Team meeting`

`find rep`

Will return: `Submit report`.

---

## Completing Tasks

**Description:**  
Mark a Task as completed.

**Format:**  
`mark <task-index>`


**Unmark a Task:**  
`unmark <task-index>`


**Note:**  
Task indices can be found from `list` or `find` commands.

**Example:**  
If Stewie has tasks:  

`Task 1`

`Task 2`

`Task 3`

`mark 2`

Marks Task 2 as completed.  

`unmark 2`

Marks Task 2 as not done.

---

## Deleting Tasks

**Description:**  
Delete a Task.

**Format:**  
`delete <task-index>`


**Example:**  
If Stewie has tasks:  

`Task 1`

`Task 2`

`Task 3`

`delete 2`

Removes Task 2 from the list. Task 3 now becomes index 2.

---

## Exiting the App

**Description:**  
Closes Stewie and **saves all tasks to disk** automatically.

**Format:**  
bye


---

## Data Storage & Loading

**Description:**  
Stewie automatically saves all tasks to a file (`stewie.txt`) in your `data/` folder.

- When the app starts, it loads all tasks from the file.
- When you add, mark, unmark, or delete tasks, the file is updated automatically.
- This ensures your tasks persist between sessions.
