package Lesson_1;


public interface DiskDao {
    void insert(Disk disk);
    String findTitleById(Long id);
}
