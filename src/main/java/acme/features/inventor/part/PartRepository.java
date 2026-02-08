
package acme.features.inventor.part;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.client.repositories.AbstractRepository;
import acme.entities.invention.Part;

public interface PartRepository extends AbstractRepository {

	@Query("SELECT p FROM Part p WHERE p.invention.id = :inventionId")
	Collection<Part> findPartsByInvention(int inventionId);

}
