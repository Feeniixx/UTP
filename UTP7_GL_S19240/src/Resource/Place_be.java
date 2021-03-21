package Resource;

import java.util.ListResourceBundle;

public class Place_be extends ListResourceBundle {
    static final Object[][] contents = {
            {"0", "возера"},
            {"1", "мора"},
            {"2", "горы"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
