package javawatirmark;


import javawatirmark.model.Model;

public class PageModel extends Model{

    public DefaultValue firstname = new DefaultValue("Justin");
    public DefaultValue companySelect = new DefaultValue("National");
    public DefaultValue includeEmail = new DefaultValue("True");
    public DefaultValue gender = new DefaultValue("Female");

    public PageModel(){
        super();
        createDefaultValues();
    }
}
