package Resource;

import java.util.ListResourceBundle;

public class Place_ca extends ListResourceBundle {
    static final Object[][] contents = {
            {"0", "llac"},
            {"1", "mar"},
            {"2", "muntanyes"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
