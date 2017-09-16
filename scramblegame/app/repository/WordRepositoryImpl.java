package repository;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import play.db.jpa.JPAApi;
import context.ScrambleGameExecutionContext;
import dao.WordData;

@Singleton
public class WordRepositoryImpl implements WordRepository{
    private final JPAApi jpaApi;
    private final ScrambleGameExecutionContext ec;
    @Inject
    public WordRepositoryImpl(JPAApi api, ScrambleGameExecutionContext ec) {
        this.jpaApi = api;
        this.ec = ec;
    }

    @Override
    public CompletionStage<String> getRandom(Long id) {
        return supplyAsync(() -> wrap(em -> lookup(em,id)).get().getText(), ec);
    }
    @Override
    public CompletionStage<Stream<WordData>> getCompoundWord(String word) {
        return supplyAsync(() -> wrap(em -> getCompoundWord(em,word)), ec);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Optional<WordData> lookup(EntityManager em, Long id) {
        TypedQuery<WordData> query = em.createQuery("SELECT d FROM WordData d where id = :id", WordData.class)
                                           .setParameter("id", id);
        return Optional.of(query.getSingleResult());
    }

    @SuppressWarnings("unchecked")
    private Stream<WordData> getCompoundWord(EntityManager em, String word) {
        Query query = em.createNativeQuery("SELECT * FROM WORDS d where TEXT REGEXP '^(?:([" + word + "])(?!\1))+$'", WordData.class);
        return query.getResultList().stream();
    }

}
