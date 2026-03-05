import { useEffect, useState } from "react";
import { getAllStudents, addStudent } from "../api/studentApi";
import StudentForm from "../components/StudentForm";
import StudentList from "../components/StudentList";

const StudentPage = () => {
  const [students, setStudents] = useState([]);

  const loadStudents = async () => {
    const response = await getAllStudents();
    setStudents(response.data);
  };

  const saveStudent = async (student) => {
    await addStudent(student);
    loadStudents();
  };

  useEffect(() => {
    loadStudents();
  }, []);

  return (
    <div>
      <StudentForm onSave={saveStudent} />
      <StudentList students={students} refresh={loadStudents} />
    </div>
  );
};

export default StudentPage;