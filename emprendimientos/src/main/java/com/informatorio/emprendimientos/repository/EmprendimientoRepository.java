package com.informatorio.emprendimientos.repository;

import com.informatorio.emprendimientos.entity.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Long> {
}
