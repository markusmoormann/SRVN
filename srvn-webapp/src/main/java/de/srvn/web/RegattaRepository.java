package de.srvn.web;

import de.srvn.domain.Regatta;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * @author Markus Moormann
 * @version 21.08.13 - 20:54
 */
@RestResource(path = "regatta", rel = "regatta")
public interface RegattaRepository extends PagingAndSortingRepository<Regatta, Integer> {
}
