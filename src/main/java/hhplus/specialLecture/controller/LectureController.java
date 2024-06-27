package hhplus.specialLecture.controller;

import hhplus.specialLecture.domain.LectureOption;
import hhplus.specialLecture.exception.LectureException;
import hhplus.specialLecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService service;

    @PostMapping("/lectures/apply")
    public void apply (
        @RequestParam Long memberId,
        @RequestParam Long lectureOptionId
    ) throws LectureException {
        service.lectureApply(memberId, lectureOptionId);
    }

    @GetMapping("/lectures")
    public List<LectureOption> getLectureList () {
        return service.lectureList();
    }

    @PostMapping("/lectures/application/{memberId}")
    public boolean applyResult (
            @PathVariable String memberId,
            @RequestParam Long lectureOptionId
    ) {
        return service.chkSuccess(Long.valueOf(memberId), lectureOptionId);
    }
}
