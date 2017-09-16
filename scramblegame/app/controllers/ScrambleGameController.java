package controllers;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.WordResourceHandler;

import views.html.*;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ScrambleGameController extends Controller {
    private HttpExecutionContext ec;
    private WordResourceHandler handler;

    @Inject
    public ScrambleGameController(HttpExecutionContext ec,
            WordResourceHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    public Result index() {
        return ok(scramblegame.render());
    }

    public CompletionStage<Result> getNextGame() {
        return handler.getRandomWord().thenApplyAsync(inputWord->{
            List<String> inputList = getDisOrderWord(inputWord);
            ObjectMapper mapper = new ObjectMapper();
            JSONObject result = new JSONObject();
            result.put("value",String.join(",", inputList));
            try {
                return ok(mapper.readTree(result.toString()));
            } catch (Exception e) {
                return ok(mapper.createObjectNode());
            }
        }, ec.current());
    }

    public CompletionStage<Result> getCompoundWord(String inputWord) {
        char[] letters = inputWord.toCharArray();
        Map<Character, Integer> countLetters = new HashMap<Character, Integer>();
        for (char c: letters) {
            countLetters.put(new Character(c), Integer.valueOf(StringUtils.countMatches(inputWord, c)));
        }
        return handler.getCompoundWord(inputWord).thenApplyAsync(word -> {
            ObjectMapper mapper = new ObjectMapper();
            final List<String> wordList = word.map(e->e.getText()).filter(
                    input -> {
                        char[] le = input.toCharArray();
                        for (char c: le) {
                            if (StringUtils.countMatches(input, c) != countLetters.get(new Character(c))) {
                                return false;
                            }
                        }
                        return true;
                    }).collect(Collectors.toList());
            JSONArray result = new JSONArray();
            for (String w: wordList) {
                JSONObject jo = new JSONObject();
                jo.put("value", w);
                result.put(jo);
            }
            try {
                return ok(mapper.readTree(result.toString()));
            } catch (Exception e) {
                return ok(mapper.createObjectNode());
            }
        }, ec.current());
    }

    private List<String> getDisOrderWord(String word) {
        List<String> toogleList = new ArrayList<String>();
        int size = word.length();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < size) {
            int random = randomGenerator .nextInt(size);
            if (!numbers.contains(random)) {
                numbers.add(random);
                toogleList.add(String.valueOf(word.charAt(random)));
            }
        }
        return toogleList;
    }
}
