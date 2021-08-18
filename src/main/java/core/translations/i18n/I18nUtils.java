package core.translations.i18n;

import core.entity.User;
import core.security.PortalUtil;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nUtils {

    public static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");

    public static String getMessage(String message)
    {
        // FIXME adicionar idioma no usuario
        User user = PortalUtil.getCurrentUser();
        if(user != null)
        {
            String language
        }
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", DEFAULT_LOCALE);
        return bundle.getString(message);
    }
}
