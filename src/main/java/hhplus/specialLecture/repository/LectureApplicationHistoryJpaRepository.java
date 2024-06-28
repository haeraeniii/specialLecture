package hhplus.specialLecture.repository;

import hhplus.specialLecture.domain.LectureApplicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureApplicationHistoryJpaRepository extends JpaRepository<LectureApplicationHistory, Long> {
    LectureApplicationHistory findLectureApplicationHistoryByMemberIdAndLectureOptionId (long memberId, long lectureOptionId);
}
