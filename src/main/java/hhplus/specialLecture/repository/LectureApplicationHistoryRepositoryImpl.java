package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.LectureApplicationHistory;
import hhplus.specialLecture.service.LectureApplicationHistoryRepository;
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
