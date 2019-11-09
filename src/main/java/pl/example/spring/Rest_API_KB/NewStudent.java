package pl.example.spring.Rest_API_KB;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {
    final String name;
    final String number;
    final String grupa;

    @JsonCreator
    public NewStudent(@JsonProperty("name") String name,@JsonProperty("number") String number,@JsonProperty("grupa") String grupa) {
        this.name = name;
        this.number = number;
        this.grupa = grupa;
    }
}
