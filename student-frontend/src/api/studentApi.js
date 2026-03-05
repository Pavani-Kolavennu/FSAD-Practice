import axios from "axios";

// Base URL from your controller
const BASE_URL = "http://localhost:8080/api/student";

// CREATE student
export const addStudent = (student) => {
  return axios.post(`${BASE_URL}/add`, student);
};

// GET all students
export const getAllStudents = () => {
  return axios.get(`${BASE_URL}/getall`);
};

// GET student by ID
export const getStudentById = (id) => {
  return axios.get(`${BASE_URL}/getid/${id}`);
};

// UPDATE student
export const updateStudent = (id, student) => {
  return axios.put(`${BASE_URL}/update/${id}`, student);
};

// DELETE student
export const deleteStudent = (id) => {
  return axios.delete(`${BASE_URL}/delete/${id}`);
};

// SEARCH students
export const searchStudent = (name, course) => {
  return axios.get(`${BASE_URL}/search`, {
    params: {
      name: name,
      course: course,
    },
  });
};