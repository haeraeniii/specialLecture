package hhplus.specialLecture.service.repository;

import hhplus.specialLecture.domain.LectureOption;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface LectureOptionsRepository {
    /*
        1. 강의 옵션 저장
        2. 강의 옵션 조회
     */

    LectureOption save (LectureOption lectureOption);

    List<LectureOption> saveAll (List<LectureOption> options);

    List<LectureOption> findAll ();

    @Lock(LockModeType.PESSIMISTIC_READ)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "10000")})
    LectureOption getById (Long id);
}
