package javawatirmark;

import javawatirmark.model.DefaultStringValue;
import javawatirmark.model.Model;

public class PageModel extends Model {

    public DefaultStringValue firstname = new DefaultStringValue("Justin");
    public DefaultStringValue companySelect = new DefaultStringValue("National");
    public DefaultStringValue gender = new DefaultStringValue("Female");

    public PageModel() {
        super();
        createDefaultValues();
    }
}
