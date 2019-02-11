package gift.goblin.database.repo.backup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gift.goblin.database.model.Foo;

@Repository
public interface BackupRepository extends JpaRepository<Foo, Long> {

  Foo findByFoo(String foo);
}
