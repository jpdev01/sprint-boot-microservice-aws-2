package core.components.nav;

import java.util.ArrayList;
import java.util.List;

public class Navbar {

    private List<FieldNavInterface> fields = new ArrayList<>();

    public Navbar()
    {

    }

    public Navbar(List<FieldNavInterface> fields)
    {
        this.fields = fields;
    }

    public void addField(FieldNavInterface newField)
    {
        if(newField.getOrder() == null)
        {
            newField.setOrder(this.fields.size() + 1);
        }
        this.fields.add(newField);
    }

    public List<FieldNavInterface> getFields() {
        return fields;
    }

    public void setFields(List<FieldNavInterface> fields) {
        this.fields = fields;
    }

    /*
     * Valida order
     */
    public void safeOrderedFields(FieldNavInterface newField)
    {
        this.fields.sort((a, b) -> {
            if(b.getOrder() == null)
            {
                b.setOrder(1);
            }
            if(a.getOrder() == null)
            {
                a.setOrder(2);
            }
            return a.getOrder() - b.getOrder();
        });
    }

}
