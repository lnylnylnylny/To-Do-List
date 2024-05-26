import React, { useState } from 'react';

const TodoItem = ({ todo, toggleTodo, deleteTodo, updateTodo }) => {
  const [isEditing, setIsEditing] = useState(false);
  const [editText, setEditText] = useState(todo.name);

  const handleSave = () => {
    if (editText.trim() === '') return;
    updateTodo(todo.id, editText);
    setIsEditing(false);
  };

  const handleKeyDown = (e) => {
    if (e.key === 'Enter') {
      handleSave();
    }
  };

  return (
    <li>
      <div>
        <input
          type="checkbox"
          checked={todo.isCompleted}
          onChange={() => toggleTodo(todo.id)}
        />
        {isEditing ? (
          <input
            type="text"
            value={editText}
            onChange={(e) => setEditText(e.target.value)}
            onKeyDown={handleKeyDown}
          />
        ) : (
          <span className={todo.isCompleted ? 'completed-text' : ''}>
            {todo.name}
          </span>
        )}
      </div>
      <div className="buttons">
        {isEditing ? (
          <button className="save-button" onClick={handleSave}>
            저장
          </button>
        ) : (
          <button onClick={() => setIsEditing(true)}>✏️</button>
        )}
        <button onClick={() => deleteTodo(todo.id)}>🗑️</button>
      </div>
    </li>
  );
};

export default TodoItem;
