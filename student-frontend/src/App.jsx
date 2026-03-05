import { useEffect, useState } from "react";
import StudentForm from "./components/StudentForm";
import StudentList from "./components/StudentList";
import {
  addStudent,
  getAllStudents,
  updateStudent,
  deleteStudent,
} from "./api/studentApi";
import "./App.css";

function App() {
  const [students, setStudents] = useState([]);
  const [selectedStudent, setSelectedStudent] = useState(null);

  useEffect(() => {
    loadStudents();
  }, []);

  const loadStudents = async () => {
    const response = await getAllStudents();
    setStudents(response.data);
  };

  const handleSave = async (student) => {
    if (selectedStudent) {
      await updateStudent(selectedStudent.id, student);
    } else {
      await addStudent(student);
    }

    setSelectedStudent(null);
    loadStudents();
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure?")) {
      await deleteStudent(id);
      loadStudents();
    }
  };

  return (
    <div className="container">
      <h1>Student Management</h1>

      <StudentForm
        onSave={handleSave}
        selectedStudent={selectedStudent}
        onCancel={() => setSelectedStudent(null)}
      />

      <StudentList
        students={students}
        onEdit={setSelectedStudent}
        onDelete={handleDelete}
      />
    </div>
  );
}

export default App;