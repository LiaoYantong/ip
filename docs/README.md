# Stewie Chatbot - User Guide



Welcome to **Stewie**, your sarcastic but helpful task management assistant!  
Stewie helps you keep track of **todos, deadlines, and events** through a chat interface, either in the console or via a GUI.

---

## Features

### 1. Add Tasks

- **Todo**

todo <description>

Adds a simple task.  
Example:


todo Buy groceries


- **Deadline**


deadline <description> /by <yyyy-MM-dd>

Adds a task that must be completed by a certain date.  
Example:


deadline Submit report /by 2026-03-01


- **Event**


event <description> /slot <date1> /slot <date2> ...

Adds an event with **tentative slots**. Later, you can confirm one slot.  
Example:


event Team meeting /slot 2026-02-20 /slot 2026-02-21


---

### 2. List Tasks

- **Command:**


list

Shows all tasks in your task list with their type and status.

---

### 3. Mark or Unmark Tasks

- **Mark as done:**


mark <task_number>

- **Mark as not done:**


unmark <task_number>


---

### 4. Delete Tasks

- **Command:**


delete <task_number>

Removes a task from your list.  
Example:


delete 2


---

### 5. Find Tasks

- **Command:**


find <keyword>

Searches for tasks containing the keyword.  
Example:


find report


---

### 6. Exit

- **Command:**


bye

Exits the chatbot