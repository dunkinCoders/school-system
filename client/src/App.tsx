import { useState } from "react";
import "./App.css";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";

import { Routes, Route } from "react-router-dom";
import Login from "./views/Login";

function App() {
  return (
    <>
      <header>
        <Header />
      </header>

      <main>
        <Sidebar />

        <Routes>
          <Route path="/" element={<h1>Home</h1>} />
          <Route path="/profile" element={<h1>Profile</h1>} />
          <Route path="/login" element={<Login />} />
          <Route path="/schedule" element={<h1>Schedule</h1>} />
          <Route path="/journals" element={<h1>Journals</h1>} />
        </Routes>
      </main>
    </>
  );
}

export default App;
