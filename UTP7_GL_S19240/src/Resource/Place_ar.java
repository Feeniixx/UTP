package Resource;

import java.util.ListResourceBundle;

public class Place_ar extends ListResourceBundle {
    static final Object[][] contents = {
            {"0", "بحيرة"},
            {"1", "بحر"},
            {"2", "الجبال"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
