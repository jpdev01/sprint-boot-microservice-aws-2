package core.service.components.nav;

import core.components.nav.DropdownFieldNav;
import core.components.nav.FieldNav;
import core.components.nav.FieldNavInterface;
import core.components.nav.Navbar;
import core.translations.i18n.I18nUtils;
import org.springframework.stereotype.Service;
import utils.PatternUrl;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavbarService {

    public Navbar get(){
        Navbar navbar = new Navbar();

        navbar.addField(new FieldNav(I18nUtils.getString("start"), "fa fa-home", PatternUrl.getHome()));
        navbar.addField(new FieldNav(I18nUtils.getString("salesPortal"),"fa fa-cart-plus", PatternUrl.getStoreSpace(), true, true));
        // FIXME arrumar link quando componente existir
        navbar.addField(new FieldNav(I18nUtils.getString("box"),"fa fa-folder-open-o", ""));
        navbar.addField(new FieldNav(I18nUtils.getString("payments"),"fa fa-credit-card-alt", ""));

        DropdownFieldNav dropdown = new DropdownFieldNav("queries", "fa fa-home");
        dropdown.addField(new FieldNav(I18nUtils.getString("customers"), PatternUrl.getListRoute(PatternUrl.getCustomer())));
        dropdown.addField(new FieldNav(I18nUtils.getString("products"), PatternUrl.getListRoute(PatternUrl.getProduct())));
        dropdown.addField(new FieldNav(I18nUtils.getString("providers"), PatternUrl.getListRoute(PatternUrl.getProvider())));
        dropdown.addField(new FieldNav(I18nUtils.getString("users"), PatternUrl.getListRoute(PatternUrl.getUser())));
        navbar.addField(dropdown);

        DropdownFieldNav dropdownMore = new DropdownFieldNav("more", "fa fa-plus");
        dropdownMore.addField(new FieldNav("birthdays"));
        navbar.addField(dropdownMore);
        navbar.addField(new FieldNav("exit", "fa fa-sign-out"));

        return navbar;
    }
}
