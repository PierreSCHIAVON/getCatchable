package com.psc.getCatchable.Repositories;

import com.psc.getCatchable.Entity.Catchable;
import com.psc.getCatchable.Entity.CatchableType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatchablesRepository extends JpaRepository<Catchable, Long> {

    List<Catchable> findByType(CatchableType type);
}
