package dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="words")
public class WordData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;
    public String text;

    public WordData() {

    }

    public WordData(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
