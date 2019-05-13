package ru.morou;

public enum Command {
    // какие у студента курсы
    STUDENTS_COURSES("/st_course"),

    // какие студенты записаны на курс
    COURSE_STUDENTS("/courses"),

    // оценки студентов
    MARKS_STUDENTS("/marks"),

    // удалить студента
    DELETE_ST("/delete_st"),

    // удалить курс
    DELETE_COURSE("/delete_co");

    public String getText() {
        return text;
    }

    private String text;

    Command(String s) {
        text = s;
    }
}
