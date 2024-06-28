package hhplus.specialLecture.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Lecture {
    /**
     * 강의 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lecture_id")
    private long id;

    /**
     * 강의명
     */
    private String lectureName;

    /**
     * 강의 정보 리스트
     */
    @OneToMany(mappedBy = "lecture")
    private List<LectureOption> options = new ArrayList<>();

}
