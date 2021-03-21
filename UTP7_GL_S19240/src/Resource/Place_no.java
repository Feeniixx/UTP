package Resource;

import java.util.ListResourceBundle;

public class Place_no extends ListResourceBundle {
    static final Object[][] contents = {
            {"0", "innsjø"},
            {"1", "sjø"},
            {"2", "fjellene"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
