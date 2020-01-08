package org.cleancode.journal.service;

import com.vaadin.flow.i18n.I18NProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class TranslationProvider implements I18NProvider {

    @Override
    public List<Locale> getProvidedLocales() {
        return List.of(Locale.ENGLISH, Locale.GERMAN);
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        var bundle = ResourceBundle.getBundle("translation", locale);
        return bundle.getString(key);
    }
}