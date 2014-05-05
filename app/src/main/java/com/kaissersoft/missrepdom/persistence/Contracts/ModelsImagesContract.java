package com.kaissersoft.missrepdom.persistence.Contracts;

import android.net.Uri;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;

/**
 * Created by Eefret on 5/4/2014.
 */
public interface ModelsImagesContract extends ProviGenBaseContract {

    @Column(Column.Type.INTEGER)
    public static final String MODEL_NUMBER = "MODEL_NUMBER";

    @Column(Column.Type.BLOB)
    public static final String MODEL_BASE64_IMAGE = "MODEL_BASE64_IMAGE";

    @Column(Column.Type.TEXT)
    public static final String MODEL_IMAGE_CACHED_PATH = "MODEL_IMAGE_CACHED_PATH";

    @Column(Column.Type.INTEGER)
    public static final String MODEL_IMAGE_NET_URL = "MODEL_IMAGE_NET_URL";

    @ContentUri
    public static final Uri CONTENT_URI = Uri.parse("content://com.kaissersoft.missrepdom/models_images");
}
