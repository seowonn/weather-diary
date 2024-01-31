package zerobase.weather.controller;

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

    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text
    ){
        diaryService.createDiary(date, text);
    }

    @GetMapping("/read/diary")
    List<Diary> readDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ){
        return diaryService.readDiary(date);
    }

    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
            @RequestParam (name = "startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam (name = "endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ){
        return diaryService.readDiaries(startDate, endDate);
    }

    @PutMapping("/update/diary")
    void updateDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text
    ){
        diaryService.updateDiary(date, text);
    }

    @DeleteMapping("/delete/diary")
    void deleteDiary(
            @RequestParam (name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ){
        diaryService.deleteDiary(date);
    }
}
