package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.LectureOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureOptionsJpaRepository extends JpaRepository<LectureOption, Long> {

    List<LectureOption> findAll();

    LectureOption getById(Long id);
}
