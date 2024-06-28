package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {
}
