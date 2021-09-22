package core.repository;

import core.entity.Enterprise;
import core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer>
{
}
