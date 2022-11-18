package org.github.web.mongo.dao;

import lombok.extern.slf4j.*;
import lombok.*;
import org.github.sso.mongo.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.springframework.data.domain.Sort.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class IStudentDaoTests {
  @Autowired
  IStudentDao studentDao;

  @Test
  void findAll() {
    val students = studentDao.findAll();
    log.info(students.toString());
    val all = studentDao.findAll(sort(Student.class).by(Student::getAge));
    log.info(all.toString());
  }

  @Test
  void page() {
    val pageRequest = PageRequest.of(1, 10, sort(Student.class).by(Student::getAge));
    val page        = studentDao.findAll(pageRequest);
    log.info(page.toString());
  }

  @Test
  void save() {
    val student = new Student();
    student.setId("2");
    student.setName("Rose");
    student.setAge(13);
    studentDao.save(student);
    log.info(student.toString());
  }
}
