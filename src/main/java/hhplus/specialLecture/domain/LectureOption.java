package hhplus.specialLecture.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hhplus.specialLecture.exception.LectureException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class LectureOption {
    /**
     * 신청 성공한 강의 리스트 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 강사명
     */
    private String instructorName;

    /**
     * 강의 날짜
     */
    private LocalDateTime lectureDt;

    /**
     * 강의 신청 가능 최대 인원
     */
    private long maxNum;

    /**
     * 현재까지 신청한 인원
     */
    private long applyNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    @JsonIgnore
    private Lecture lecture;

    // 정원이 초과라면 실패
    public void increaseEnrollCount() throws LectureException {
        if(maxNum == applyNum) {
            throw new LectureException(LectureException.ExceptionType.OVER_MAX_NUM, "이미 인원 마감된 특강입니다.");
        }
        applyNum++;
    }
}
