package hhplus.specialLecture.repository.impl;

import hhplus.specialLecture.domain.Lecture;
import hhplus.specialLecture.repository.LectureJpaRepository;
import hhplus.specialLecture.service.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureRepositoryImpl implements LectureRepository {

    private final LectureJpaRepository lectureJpaRepository;

    @Override
    public Lecture save(Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }
}
