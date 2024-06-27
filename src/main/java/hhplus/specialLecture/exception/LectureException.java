package hhplus.specialLecture.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LectureException extends Exception {

    public enum ExceptionType {
        /**
         * 정원 초과
         */
        OVER_MAX_NUM,

        /**
         * 동일한 강의 이미 신청
         */
        DUP_MEMBER
    }

    private final ExceptionType exceptionType;

    public LectureException (ExceptionType exceptionType, String message) {
        super (message);
        this.exceptionType = exceptionType;
    }
}
