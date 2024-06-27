package hhplus.specialLecture.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class LectureApplicationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 신청한 멤버 아이디
     */
    private long memberId;

    /**
     * 신청된 강의 정보 아이디
     */
    private long lectureOptionId;

    /**
     * 강의 신청 날짜
     */
    private LocalDateTime applyDt;

    public LectureApplicationHistory (long memberId, long lectureOptionId) {
        this.memberId = memberId;
        this.lectureOptionId = lectureOptionId;
        this.applyDt = LocalDateTime.now();
    }

//    //이미 신청 완료된 사람 실패 처리
//    boolean haveMemberId (long memberId, long lectureOptionId) throws LectureException {
//        if(this.lectureOptionId == lectureOptionId && this.memberId == memberId) {
//            throw new LectureException(LectureException.ExceptionType.DUP_MEMBER, "이미 신청한 특강입니다.");
//        }
//        return true;
//    }
}
