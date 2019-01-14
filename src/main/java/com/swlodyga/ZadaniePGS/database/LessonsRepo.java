package com.swlodyga.ZadaniePGS.database;

import com.swlodyga.ZadaniePGS.model.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsRepo extends JpaRepository<Lessons, Long> {
}
