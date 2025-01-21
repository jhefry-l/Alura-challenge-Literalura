package valverde.com.mx.literalura.services;

import lombok.AllArgsConstructor;
import valverde.com.mx.literalura.models.LanguageT;
import valverde.com.mx.literalura.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService{

    private final LanguageRepository languageRepository;

    @Override
    public void saveLanguage(LanguageT language) {
        languageRepository.save(language);
    }
}
