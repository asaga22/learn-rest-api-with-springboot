package erkhaz.learnrestapi.controller;


import erkhaz.learnrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentController {


    /**
     * Spring boot REST API with Path Variable
     * {d} - URI template variable
     * http://localhost:8080/students/1
     *
     * @param studentId
     * @return
     */
//    @GetMapping("students/{id}")
//    public Student studentPathVariable(@PathVariable("id") int studentId) {
//        return new Student(studentId, "name1", "name2");
//    }
    @GetMapping("{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId) {
        Student student = new Student(studentId, "name1", "name2");
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "headerVal example")
                .header("transfer-encoding", "UTF-8")
                .body(student);
    }


    /**
     * Spring boot REST API with Request Param
     * http://localhost:8080/students/query?id=id
     */
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id) {
        return new Student(id, "name1", "name2");
    }


    /**
     * Spring boot REST API that handle HTTP Post Request
     *
     * @param student
     * @return
     */
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return student;
    }


    /**
     * Spring boot REST API that handles HTTP PUT request - update exising resource
     */
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        return student;
    }


    /**
     * Spring boot REST API that handles HTTP DELETE request - deleting the exisitng resource
     */
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        return "student deleted successfully";
    }
}
