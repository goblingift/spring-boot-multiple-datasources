package com.foobar.bar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foobar.foo.domain.Foo;

@Repository
public interface BarRepository extends JpaRepository<Foo, Long> {

  Foo findById(Long id);
  Foo findByFoo(String foo);
}
