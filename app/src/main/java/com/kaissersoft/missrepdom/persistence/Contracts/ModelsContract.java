package com.kaissersoft.missrepdom.persistence.Contracts;

import android.net.Uri;
import android.util.TypedValue;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;

/**
 * Created by Eefret on 5/4/2014.
 */

public interface ModelsContract extends ProviGenBaseContract {

    @Column(Column.Type.TEXT)
    public static final String MODEL_NAME = "MODEL_NAME";

    @Column(Column.Type.INTEGER)
    public static final String MODEL_NUMBER = "MODEL_NUMBER";

    @Column(Column.Type.TEXT)
    public static final String MODEL_PROVINCE = "MODEL_PROVINCE";

    @Column(Column.Type.INTEGER)
    public static final String MODEL_AGE = "MODEL_AGE";

    @Column(Column.Type.TEXT)
    public static final String MODEL_SIZE = "MODEL_SIZE";

    @Column(Column.Type.TEXT)
    public static final String MODEL_MEASURES = "MODEL_MEASURES";

    @Column(Column.Type.INTEGER)
    public static final String MODEL_VOTES = "MODEL_VOTES";

    @ContentUri
    public static final Uri CONTENT_URI = Uri.parse("content://com.kaissersoft.missrepdom/models");

}
