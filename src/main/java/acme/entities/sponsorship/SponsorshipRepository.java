
package acme.entities.sponsorship;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;

@Repository
public interface SponsorshipRepository extends AbstractRepository {

	@Query("select sum(d.money.amount) from Donation d where d.sponsorship.id = :id")
	Double calculateTotalAmountBySponsorshipId(int id);

	@Query("select count(d) from Donation d where d.sponsorship.id = :id")
	Integer countDonationsBySponsorshipId(int id);

	@Query("select s from Sponsorship s where s.ticker = :ticker")
	Sponsorship findByTicker(String ticker);
}
