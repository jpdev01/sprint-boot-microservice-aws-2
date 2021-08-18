package core.translations.i18n;

import core.entity.Language;
import core.entity.User;
import core.security.PortalUtil;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nUtils {

    public static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");

    public static String getMessage(String message)
    {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", getCurrentLocale());
        return bundle.getString(message);
    }

    public static Language getCurrentLanguage()
    {
        User currentUser = PortalUtil.getCurrentUser();
        if(currentUser != null)
        {
            return currentUser.getLanguage();
        }
        return Language.valueOf(DEFAULT_LOCALE.getLanguage());
    }


    public static Locale getCurrentLocale()
    {
        return new Locale(getStringLanguage(),getCurrentCountry());
    }

    public static String getStringLanguage()
    {
        Language language = getCurrentLanguage();
        if(language.equals(Language.PR_BR))
        {
            return "pt";
        }
        else if(language.equals(Language.EN_US))
        {
            return "en";
        }
        return "pt";
    }

    public static String getCurrentCountry()
    {
        //fixme validar se isso nao pode ser guardado no banco, criando uma entidade language
        String language = getCurrentLanguage().name();
        if(language.equals(Language.PR_BR))
        {
            return "br";
        }
        else if(language.equals(Language.EN_US))
        {
            return "us";
        }
        else
        {
            return "en";
        }
    }
}
