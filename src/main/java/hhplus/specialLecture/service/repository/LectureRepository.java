package hhplus.specialLecture.service.repository;

import hhplus.specialLecture.domain.Lecture;

public interface LectureRepository {
    /*
        1. 강의 저장
        2. 강의 조회
     */
    Lecture save(Lecture lecture);
}
