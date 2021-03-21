package Resource;

import java.util.ListResourceBundle;

public class Place_ru extends ListResourceBundle {
    static final Object[][] contents = {
            {"0", "озеро"},
            {"1", "море"},
            {"2", "горы"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}