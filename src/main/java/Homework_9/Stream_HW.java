package Homework_9;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_HW {

    public static List<Course> getUniqueCourses(List<Student> studentList) {
        return studentList.stream()
                .map(q -> (Course) q.getAllCourses())
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> getCurious(List<Student> studentList) {
        return studentList.stream()
                .sorted(Comparator.comparingInt((Student sl) -> sl.getAllCourses().size()).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> attendClass(List<Student> studentList, Course course) {
        return studentList.stream()
                .filter(q -> q.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }

}
