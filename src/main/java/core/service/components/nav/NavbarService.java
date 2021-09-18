package core.service.components.nav;

import core.components.nav.DropdownFieldNav;
import core.components.nav.FieldNav;
import core.components.nav.FieldNavInterface;
import core.components.nav.Navbar;
import org.springframework.stereotype.Service;
import utils.PatternUrl;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavbarService {

    public Navbar get(){
        Navbar navbar = new Navbar();

        List<FieldNavInterface> fields = new ArrayList<>();
        fields.add(new FieldNav("Ínicio","fa fa-home", PatternUrl.getHome()));
        fields.add(new FieldNav("Portal de vendas","fa fa-cart-plus", PatternUrl.getStoreSpace(), true, true));
        // FIXME arrumar link quando componente existir
        fields.add(new FieldNav("Caixa","fa fa-folder-open-o", ""));
        fields.add(new FieldNav("Pagamentos","fa fa-credit-card-alt", ""));

        DropdownFieldNav dropdown = new DropdownFieldNav("Consultas", "fa fa-home");
        dropdown.addField(new FieldNav("Clientes", PatternUrl.getListRoute(PatternUrl.getCustomer())));
        dropdown.addField(new FieldNav("Produtos", PatternUrl.getListRoute(PatternUrl.getProduct())));
        dropdown.addField(new FieldNav("Fornecedores", PatternUrl.getListRoute(PatternUrl.getProvider())));
        dropdown.addField(new FieldNav("Usuários", PatternUrl.getListRoute(PatternUrl.getUser())));
        fields.add(dropdown);

        DropdownFieldNav dropdownMore = new DropdownFieldNav("Mais", "fa fa-plus");
        dropdownMore.addField(new FieldNav("Aniversariantes"));
        fields.add(dropdownMore);
        fields.add(new FieldNav("Sair", "fa fa-sign-out"));
        navbar.setFields(fields);
        return navbar;
    }
}
