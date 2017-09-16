package services;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

import javax.inject.Inject;

import play.libs.concurrent.HttpExecutionContext;
import repository.WordRepository;
import dto.WordResource;

public class WordResourceHandler {
    private final WordRepository repository;
    private final HttpExecutionContext ec;
    private final int MAX_WORDS_COUNT = 370100;

    @Inject
    public WordResourceHandler(WordRepository repository,
            HttpExecutionContext ec) {
        this.repository = repository;
        this.ec = ec;
    }
    public CompletionStage<String> getRandomWord() {
        int randomNumber = (new Random()).nextInt(MAX_WORDS_COUNT) + 1;
        return repository.getRandom(Long.valueOf(randomNumber));
    }
    public CompletionStage<Stream<WordResource>> getCompoundWord(String word) {
        return repository.getCompoundWord(word).thenApplyAsync(wordDataStream -> {
            return wordDataStream.map(data -> new WordResource(data));
        }, ec.current());
    }
}
