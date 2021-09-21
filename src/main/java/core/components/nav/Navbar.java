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
        this.fields.add(newField);
    }

    public List<FieldNavInterface> getFields() {
        return fields;
    }

    public void setFields(List<FieldNavInterface> fields) {
        this.fields = fields;
    }
}
