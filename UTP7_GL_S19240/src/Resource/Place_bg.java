package Resource;

import java.util.ListResourceBundle;

public class Place_bg extends ListResourceBundle {
    static final Object[][] contents = {
            {"0", "езеро"},
            {"1", "море"},
            {"2", "планини"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}