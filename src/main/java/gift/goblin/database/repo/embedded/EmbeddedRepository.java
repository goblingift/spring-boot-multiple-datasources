package gift.goblin.database.repo.embedded;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gift.goblin.database.model.Foo;

@Repository
public interface EmbeddedRepository extends JpaRepository<Foo, Long> {

  Foo findByFoo(String foo);
}
