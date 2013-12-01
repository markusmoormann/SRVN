package de.srvn.web.bootstrap;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Markus Moormann
 * @version 01.12.13 - 20:26
 */
@Component
public class LuceneIndexBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(LuceneIndexBootstrap.class);

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void rebuildIndex() {
        logger.debug("starting to rebuild index");
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer().start();
    }

}
