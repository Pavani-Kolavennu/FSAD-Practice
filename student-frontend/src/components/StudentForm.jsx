import { useEffect, useState } from "react";

const StudentForm = ({ onSave, selectedStudent, onCancel }) => {
  const [student, setStudent] = useState({
    id: "",
    name: "",
    course: "",
  });

  useEffect(() => {
    if (selectedStudent) {
      setStudent(selectedStudent);
    }
  }, [selectedStudent]);

  const handleChange = (e) => {
    setStudent({
      ...student,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSave(student);
    setStudent({ id: "", name: "", course: "" });
  };

  return (
    <form className="form" onSubmit={handleSubmit}>
      <h2>{selectedStudent ? "Update Student" : "Add Student"}</h2>

      {/* ID REQUIRED for ADD */}
      {!selectedStudent && (
        <input
          type="number"
          name="id"
          placeholder="Student ID"
          value={student.id}
          onChange={handleChange}
          required
        />
      )}

      {/* ID SHOWN (DISABLED) for EDIT */}
      {selectedStudent && (
        <input type="number" value={student.id} disabled />
      )}

      <input
        type="text"
        name="name"
        placeholder="Student Name"
        value={student.name}
        onChange={handleChange}
        required
      />

      <input
        type="text"
        name="course"
        placeholder="Course"
        value={student.course}
        onChange={handleChange}
        required
      />

      <button type="submit">
        {selectedStudent ? "Update" : "Save"}
      </button>

      {selectedStudent && (
        <button type="button" className="cancel" onClick={onCancel}>
          Cancel
        </button>
      )}
    </form>
  );
};

export default StudentForm;