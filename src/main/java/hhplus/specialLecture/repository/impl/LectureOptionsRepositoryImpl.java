package hhplus.specialLecture.repository.impl;

import hhplus.specialLecture.domain.LectureOption;
import hhplus.specialLecture.repository.LectureOptionsJpaRepository;
import hhplus.specialLecture.service.repository.LectureOptionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LectureOptionsRepositoryImpl implements LectureOptionsRepository {

    private final LectureOptionsJpaRepository lectureOptionsJpaRepository;

    @Override
    public LectureOption save(LectureOption lectureOption) {
        return lectureOptionsJpaRepository.save(lectureOption);
    }

    @Override
    public List<LectureOption> saveAll(List<LectureOption> options) {
        return lectureOptionsJpaRepository.saveAll(options);
    }

    @Override
    public List<LectureOption> findAll() {
        return lectureOptionsJpaRepository.findAll();
    }

    @Override
    public LectureOption getById(Long id) {
        return lectureOptionsJpaRepository.getById(id);
    }
}
