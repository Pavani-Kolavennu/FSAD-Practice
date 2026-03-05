import StudentItem from "./StudentItem";

const StudentList = ({ students, onEdit, onDelete }) => {
  return (
    <table className="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Course</th>
          <th>Actions</th>
        </tr>
      </thead>

      <tbody>
        {students.length === 0 ? (
          <tr>
            <td colSpan="4" style={{ textAlign: "center" }}>
              No students found
            </td>
          </tr>
        ) : (
          students.map((student) => (
            <StudentItem
              key={student.id}
              student={student}
              onEdit={onEdit}
              onDelete={onDelete}
            />
          ))
        )}
      </tbody>
    </table>
  );
};

export default StudentList;