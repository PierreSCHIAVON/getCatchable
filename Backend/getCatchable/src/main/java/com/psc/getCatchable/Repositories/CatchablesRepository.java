package com.psc.getCatchable.Repositories;

import com.psc.getCatchable.Entity.Catchable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatchablesRepository extends JpaRepository<Catchable, Long> {
}
