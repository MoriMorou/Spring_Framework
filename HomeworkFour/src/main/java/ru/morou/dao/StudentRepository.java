package ru.morou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.morou.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom{

}