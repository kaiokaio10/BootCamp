package camp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import camp.entity.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long>  {

}
