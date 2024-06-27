package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.Lecture;
import hhplus.specialLecture.domain.LectureOption;
import hhplus.specialLecture.service.LectureOptionsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LectureOptionsRepositoryImplTest {

    @Autowired
    LectureOptionsRepository lectureOptionsRepository;

    @Test
    @DisplayName("강의 정보 저장")
    public void testSaveLectureOption() {
        //given
        Lecture lecture = new Lecture();
        lecture.setLectureName("항해 플러스 백엔드 강의");

        List<LectureOption> lectureOptions = new ArrayList<>();
        List<LectureOption> lectureOptionsResult = new ArrayList<>();

        LectureOption lectureOption1 = new LectureOption();
        LectureOption lectureOption2 = new LectureOption();
        LectureOption lectureOption3 = new LectureOption();

        lectureOption1.setInstructorName("허재");
        lectureOption1.setLectureDt(LocalDateTime.of(2024, 7, 14, 0, 0, 0));
        lectureOption1.setMaxNum(30);
        lectureOption1.setApplyNum(30);
        lectureOption1.setLecture(lecture);

        lectureOption2.setInstructorName("하헌우");
        lectureOption2.setLectureDt(LocalDateTime.of(2024, 7, 14, 0, 0, 0));
        lectureOption2.setMaxNum(30);
        lectureOption2.setApplyNum(15);
        lectureOption2.setLecture(lecture);

        lectureOption3.setInstructorName("이석범");
        lectureOption3.setLectureDt(LocalDateTime.of(2024, 7, 14, 0, 0, 0));
        lectureOption3.setMaxNum(30);
        lectureOption3.setApplyNum(10);
        lectureOption3.setLecture(lecture);

        lectureOptions.add(lectureOption1);
        lectureOptions.add(lectureOption2);
        lectureOptions.add(lectureOption3);

        //when
        for (LectureOption lectureOption : lectureOptions) {
            lectureOptionsResult.add(lectureOptionsRepository.save(lectureOption));
        }

        //then
        Assertions.assertThat(lectureOptionsRepository.findAll().size()).isEqualTo(lectureOptionsResult.size());
    }
}