CREATE TABLE IF NOT EXISTS WORDS(ID INT PRIMARY KEY, TEXT VARCHAR(255))
    AS SELECT * FROM CSVREAD('./public/words.csv');