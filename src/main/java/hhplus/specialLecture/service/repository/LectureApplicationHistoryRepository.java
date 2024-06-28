package hhplus.specialLecture.service.repository;

import hhplus.specialLecture.domain.LectureApplicationHistory;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

public interface LectureApplicationHistoryRepository {
    /*
        1. 히스토리 저장
        2. 히스토리 조회
     */

    LectureApplicationHistory save(LectureApplicationHistory lectureApplicationHistory);

    LectureApplicationHistory findLectureApplicationHistoryByMemberIdAndLectureOptionId (long memberId, long lectureOptionId);
}
