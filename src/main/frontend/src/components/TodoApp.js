import React, { useState, useEffect } from 'react';
import axios from 'axios';
import TodoList from './TodoList';

const TodoApp = () => {
  const [todos, setTodos] = useState([]);
  const [newTaskName, setNewTaskName] = useState("");

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await axios.get('http://localhost:8080/task');
      setTodos(response.data);
    } catch (error) {
      console.error('Error fetching tasks', error);
    }
  };

  const addTodo = async () => {
    if (newTaskName.trim() === '') return;
    try {
      await axios.post('http://localhost:8080/task', { name: newTaskName, isCompleted: false });
      fetchTasks();
      setNewTaskName('');
    } catch (error) {
      console.error('Error adding task', error);
    }
  };

  const toggleTodo = async (id) => {
    try {
      const todo = todos.find(t => t.id === id);
      await axios.put('http://localhost:8080/task/isComplete', { id, isCompleted: !todo.isCompleted });
      fetchTasks();
    } catch (error) {
      console.error('Error toggling task', error);
    }
  };

  const deleteTodo = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/task?id=${id}`);
      fetchTasks();
    } catch (error) {
      console.error('Error deleting task', error);
    }
  };

  const updateTodo = async (id, newText) => {
    if (newText.trim() === '') return;
    try {
      await axios.put('http://localhost:8080/task/name', { id, name: newText });
      fetchTasks();
    } catch (error) {
      console.error('Error updating task', error);
    }
  };

  const handleAddTodo = () => {
    addTodo();
  };

  const handleKeyDown = (e) => {
    if (e.key === 'Enter') {
      handleAddTodo();
    }
  };

  return (
    <div className="todo-container">
      <div className="todo-header">
        <h1>To-Do List</h1>
        <div className="input-container">
          <input
            type="text"
            value={newTaskName}
            onChange={(e) => setNewTaskName(e.target.value)}
            placeholder="할 일을 추가하세요..."
            onKeyDown={handleKeyDown}
          />
          <button onClick={handleAddTodo}>추가</button>
        </div>
      </div>
      <TodoList
        todos={todos}
        toggleTodo={toggleTodo}
        deleteTodo={deleteTodo}
        updateTodo={updateTodo}
      />
    </div>
  );
};

export default TodoApp;
