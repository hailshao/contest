package com.team7.first.domain;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import com.github.liaochong.myexcel.core.annotation.ExcelModel;

import java.time.LocalDateTime;

/**
 * @author liaochong
 * @version 1.0
 */
@ExcelModel(sheetName = "艺术生", useFieldNameAsTitle = true)
public class ArtCrowd extends People {

    @ExcelColumn(order = 3, index = 3)
    private String paintingLevel;

    @ExcelColumn(order = 4, title = "是否会跳舞", groups = {People.class, String.class}, index = 4)
    private boolean dance;

    @ExcelColumn(order = 5, title = "考核时间", groups = {People.class, String.class}, index = 5)
    private LocalDateTime assessmentTime;

    @ExcelColumn(order = 6, defaultValue = "---")
    private String hobby;

    public String getPaintingLevel() {
        return paintingLevel;
    }

    public void setPaintingLevel(String paintingLevel) {
        this.paintingLevel = paintingLevel;
    }

    public boolean isDance() {
        return dance;
    }

    public void setDance(boolean dance) {
        this.dance = dance;
    }

    public LocalDateTime getAssessmentTime() {
        return assessmentTime;
    }

    public void setAssessmentTime(LocalDateTime assessmentTime) {
        this.assessmentTime = assessmentTime;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
