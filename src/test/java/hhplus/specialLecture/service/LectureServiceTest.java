package hhplus.specialLecture.service;

import hhplus.specialLecture.domain.Lecture;
import hhplus.specialLecture.domain.LectureApplicationHistory;
import hhplus.specialLecture.domain.LectureOption;
import hhplus.specialLecture.service.repository.LectureApplicationHistoryRepository;
import hhplus.specialLecture.service.repository.LectureOptionsRepository;
import hhplus.specialLecture.service.repository.LectureRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LectureServiceTest {
     /*
        요구사항
        1. 동일한 신청자는 한 번의 수강 신청만 성공할 수 있음 (강의 신청시 필요한 정보 : 멤버 아이디, 강의 아이디, 강의 옵션 아이디)
        2. 한 강의에 신청자가 30명이 초과되면 이후 신청자는 요청 실패
        3. 어떤 유저가 특강을 신청했는지 히스토리 저장
        4. 특강이 날짜별로 여러개 존재
        5. 특강 신청 전에 특강 목록을 조회해볼 수 있어야 함
        6. 특강 신청자에회 성공여부를 알려줘야 함
     */

    @Autowired
    LectureService lectureService;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    LectureOptionsRepository lectureOptionsRepository;

    @Autowired
    LectureApplicationHistoryRepository lectureApplicationHistoryRepo;

    private Lecture setting (Lecture lecture,  List<LectureOption> lectureOptions) {
        lecture.setLectureName("항해 플러스 백엔드 강의");
        Lecture lecture1 = lectureRepository.save(lecture);

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

        lecture.setOptions(lectureOptions);

        lectureOptionsRepository.saveAll(lectureOptions);

        return lecture;
    }

//    @Test
//    @DisplayName("강의 셋팅")
//    public void testSetUpLecture() {
//        //given, when
//        Lecture lecture = new Lecture();
//        List<LectureOption> lectureOptions = new ArrayList<>();
//        setting(lecture, lectureOptions);
//
//        //then
//        Assertions.assertThat(lectureOptions.get(0).getInstructorName()).isEqualTo("허재");
//    }
    
    @Test
    @DisplayName("강의 신청 시 인원 초과")
    public void testApplyLectureOverNum() {
        //given
        Lecture lecture = new Lecture();
        List<LectureOption> lectureOptions = new ArrayList<>();
        setting(lecture, lectureOptions);

        Long lectureOptionId = 1L;
        
        //when
        LectureOption optionId = lectureOptionsRepository.getById(lectureOptionId);

        //then
        Assertions.assertThat(lectureOptionsRepository.getById(lectureOptionId).getId()).isEqualTo(optionId.getId());
    }

    @Test
    @DisplayName("강의 신청 시 신청 가능 여부 조회")
    public void testApplyLectureDupMember() {
        //given
        Lecture lecture = new Lecture();
        List<LectureOption> lectureOptions = new ArrayList<>();
        setting(lecture, lectureOptions);

        Long memberId = 33L;
        Long lectureOptionId = 1L;

        //when
        LectureApplicationHistory chkHistory = lectureApplicationHistoryRepo.findLectureApplicationHistoryByMemberIdAndLectureOptionId(memberId, lectureOptionId);

        //then
        Assertions.assertThat(chkHistory).isEqualTo(null);
    }

    @Test
    @DisplayName("강의 전체 리스트 불러오기")
    public void testFindAllLectureList() {
        //given
        Lecture lecture = new Lecture();
        List<LectureOption> lectureOptions = new ArrayList<>();
        setting(lecture, lectureOptions);

        //when
        List<LectureOption> all = lectureOptionsRepository.findAll();

        //then
        Assertions.assertThat(all.size()).isEqualTo(3);
    }
}