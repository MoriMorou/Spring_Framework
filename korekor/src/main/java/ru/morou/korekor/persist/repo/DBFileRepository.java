package ru.morou.korekor.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.morou.korekor.persist.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {
}
