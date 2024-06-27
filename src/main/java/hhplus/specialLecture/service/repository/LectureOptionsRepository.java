package hhplus.specialLecture.service.repository;

import hhplus.specialLecture.domain.LectureOption;

import java.util.List;

public interface LectureOptionsRepository {
    /*
        1. 강의 옵션 저장
        2. 강의 옵션 조회
     */

    LectureOption save (LectureOption lectureOption);

    List<LectureOption> saveAll (List<LectureOption> options);

    List<LectureOption> findAll ();

    LectureOption getById (Long id);
}
