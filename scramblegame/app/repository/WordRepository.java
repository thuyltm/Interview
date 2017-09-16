package repository;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

import dao.WordData;

public interface WordRepository {
    CompletionStage<Stream<WordData>> getCompoundWord(String word);
    CompletionStage<String> getRandom(Long id);
}
