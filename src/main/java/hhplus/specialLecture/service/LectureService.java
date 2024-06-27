package hhplus.specialLecture.service;

import hhplus.specialLecture.domain.LectureApplicationHistory;
import hhplus.specialLecture.domain.LectureOption;
import hhplus.specialLecture.exception.LectureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LectureService {
    /*
        요구사항
        1. 동일한 신청자는 한 번의 수강 신청만 성공할 수 있음
        2. 한 강의에 신청자가 30명이 초과되면 이후 신청자는 요청 실패
        3. 어떤 유저가 특강을 신청했는지 히스토리 저장
        4. 특강이 날짜별로 여러개 존재
        5. 특강 신청 전에 특강 목록을 조회해볼 수 있어야 함
        6. 특강 신청자에회 성공여부를 알려줘야 함
     */
    private final LectureRepository lectureRepository;

    private final LectureOptionsRepository lectureOptionsRepository;

    private final LectureApplicationHistoryRepository lectureApplicationHistoryRepo;

    //특강 신청
    public void lectureApply(Long memberId, Long lectureOptionId) throws LectureException {

        LectureOption option = lectureOptionsRepository.getById(lectureOptionId);

        // 해당 히스토리가 존재할 경우
        if(chkSuccess(memberId, lectureOptionId)) {
            throw new LectureException(LectureException.ExceptionType.DUP_MEMBER, "이미 신청한 특강입니다.");
        }

        // 정원 체크 (+1 or 인원 초과 exception)
        option.increaseEnrollCount();

        LectureApplicationHistory history = new LectureApplicationHistory(memberId, lectureOptionId);

        lectureApplicationHistoryRepo.save(history);
    }

    // 강의 전체 리스트
    public List<LectureOption> lectureList () {
        return lectureOptionsRepository.findAll();
    }


    // 특강 신청 완료 여부 조회
    public boolean chkSuccess (Long memberId, Long lectureOptionId) {
        LectureApplicationHistory chkHistory = lectureApplicationHistoryRepo.findLectureApplicationHistoryByMemberIdAndLectureOptionId(memberId, lectureOptionId);

        return chkHistory != null;
    }


}
