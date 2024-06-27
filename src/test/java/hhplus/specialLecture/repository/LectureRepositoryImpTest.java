package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.Lecture;
import hhplus.specialLecture.service.repository.LectureRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@SpringBootTest
class LectureRepositoryImpTest {
    @Autowired
    LectureRepository lectureRepository;

    @Test
    @DisplayName("강의 저장 & 조회 테스트")
    @Transactional
    @Rollback(false)
    public void testGetLectureId() {
        //given
        Lecture lecture = new Lecture();
        lecture.setLectureName("항해99 백엔드 강의");
        lecture.setOptions(new ArrayList<>());

        //when
        Lecture saveLecture = lectureRepository.save(lecture);

        //then
        Long id = saveLecture.getId();
        Assertions.assertThat(saveLecture.getId()).isEqualTo(id);
    }
}