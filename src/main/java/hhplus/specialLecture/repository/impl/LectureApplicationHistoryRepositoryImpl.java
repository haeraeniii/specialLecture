package hhplus.specialLecture.repository.impl;

import hhplus.specialLecture.domain.LectureApplicationHistory;
import hhplus.specialLecture.repository.LectureApplicationHistoryJpaRepository;
import hhplus.specialLecture.service.repository.LectureApplicationHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LectureApplicationHistoryRepositoryImpl implements LectureApplicationHistoryRepository {

    private final LectureApplicationHistoryJpaRepository lectureApplicationHistoryJpaRepo;


    //히스토리 저장
    @Override
    public LectureApplicationHistory save(LectureApplicationHistory lectureApplicationHistory) {
        return lectureApplicationHistoryJpaRepo.save(lectureApplicationHistory);
    }

    //신청 내역 조회
    @Override
    public LectureApplicationHistory findLectureApplicationHistoryByMemberIdAndLectureOptionId(long memberId, long lectureOptionId) {
        return lectureApplicationHistoryJpaRepo.findLectureApplicationHistoryByMemberIdAndLectureOptionId(memberId, lectureOptionId);
    }


}
