package de.srvn.web;

import de.srvn.domain.Ruderer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * @author Markus Moormann
 * @version 20.08.13 - 13:46
 */
@RestResource(path = "ruderer", rel = "ruderer")
public interface RudererRepository extends PagingAndSortingRepository<Ruderer, Integer> {
}
