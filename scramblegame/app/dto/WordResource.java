package dto;

import dao.WordData;

public class WordResource {
    private String text;
    public WordResource(WordData data) {
        this.text = data.text;
    }
    public String getText() {
        return text;
    }
}
