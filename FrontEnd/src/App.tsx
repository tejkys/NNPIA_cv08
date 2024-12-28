import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Tasks from './page/Tasks'
import { tasks } from './data/init-data'
import Header from "./component/ui/Header";
import {Provider} from "react-redux";
import store from "./features/store";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Tasks from "./page/Tasks";
import Header from "./component/ui/Header";
import TaskDetail from "./page/TaskDetail";
function App() {
  const [count, setCount] = useState(0)

   return (
      <Provider store={store}>
            <BrowserRouter>
            <Header />
            <Routes>
                <Route path={"/task"} element={<Tasks />} />
                <Route path={"/task/:id"} element={<TaskDetail />} />
            </Routes>
        </BrowserRouter>
      </Provider>
    )
}

export default App
