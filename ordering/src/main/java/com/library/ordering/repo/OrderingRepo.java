package com.library.ordering.repo;

import com.library.ordering.entity.Orders;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepo extends JpaRepository<Orders, Long> {
  Optional<Orders> findById(Long id);
}
