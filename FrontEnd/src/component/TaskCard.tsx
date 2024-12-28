import {Task} from "../data/init-data";
import React from "react";

interface Props {
    task: Task;
    onTaskDone: (task: Task) => void
}

const TaskCard = ({task, onTaskDone} : Props) => {
    const checkboxChangeHandle = (e: React.ChangeEvent<HTMLInputElement>) => {
        e.preventDefault();
        onTaskDone(task);
    };
    return <div>
        <h1>{task.title}</h1>
        <p>{task.description}</p>
        <p>{new Date(task.creationDate).toISOString()}</p>
        <p>{(task.updateDate) && new Date(task.updateDate).toISOString()}</p>
        <label>Splneno: </label>
        <input type="checkbox" name="myCheckbox" value="myCheckbox" checked={task.done} onChange={checkboxChangeHandle} />
    </div>;
} 
export default TaskCard;