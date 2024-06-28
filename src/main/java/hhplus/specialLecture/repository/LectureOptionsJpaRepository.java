package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.LectureOption;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface LectureOptionsJpaRepository extends JpaRepository<LectureOption, Long> {

    List<LectureOption> findAll();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "10000")})
    LectureOption getById(Long id);
}
