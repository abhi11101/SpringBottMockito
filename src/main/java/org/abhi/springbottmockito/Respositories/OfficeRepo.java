package org.abhi.springbottmockito.Respositories;

import org.abhi.springbottmockito.Entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepo extends JpaRepository<Office,Integer> {
}
