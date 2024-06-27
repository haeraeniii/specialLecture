package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.Lecture;
import hhplus.specialLecture.service.LectureRepository;
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
