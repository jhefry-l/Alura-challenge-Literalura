package valverde.com.mx.literalura.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Language {

    ENGLISH("en", "English"),
    SPANISH("es", "Spanish"),
    FRENCH("fr", "French"),
    GERMAN("de", "German"),
    CHINESE("zh", "Chinese"),
    JAPANESE("ja", "Japanese"),
    ITALIAN("it", "Italian"),
    PORTUGUESE("pt", "Portuguese"),
    RUSSIAN("ru", "Russian"),
    HINDI("hi", "Hindi"),
    ARABIC("ar", "Arabic");

    private final String code;

    private final String displayName;

    Language(String code, String displayName){
        this.code = code;
        this.displayName = displayName;
    }

}
