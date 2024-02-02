package zerobase.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @Operation(summary = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장")
    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "기록 일자",
                    example = "2024-02-02") LocalDate date,
            @RequestBody String text
    ){
        diaryService.createDiary(date, text);
    }

    @Operation(summary = "선택한 날짜의 모든 일기 데이터를 가져옵니다")
    @GetMapping("/read/diary")
    List<Diary> readDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "조회 일자",
                    example = "2024-02-02") LocalDate date
    ){
        return diaryService.readDiary(date);
    }

    @Operation(summary = "선택한 기간 중의 모든 일기 데이터를 가져옵니다")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
            @RequestParam (name = "startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "조회할 기간의 첫번째 날",
                    example = "2024-02-02") LocalDate startDate,
            @RequestParam (name = "endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "조회할 기간의 마지막 날",
                    example = "2024-02-02") LocalDate endDate
    ){
        return diaryService.readDiaries(startDate, endDate);
    }

    @Operation(summary = "선택한 날짜의 첫번째 일기 데이터를 수정합니다")
    @PutMapping("/update/diary")
    void updateDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "수정 일자",
                    example = "2024-02-02") LocalDate date,
            @RequestBody String text
    ){
        diaryService.updateDiary(date, text);
    }

    @Operation(summary = "선택한 날짜의 모든 일기 데이터를 삭제합니다")
    @DeleteMapping("/delete/diary")
    void deleteDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(description = "삭제 일자",
                    example = "2024-02-02") LocalDate date
    ){
        diaryService.deleteDiary(date);
    }
}
