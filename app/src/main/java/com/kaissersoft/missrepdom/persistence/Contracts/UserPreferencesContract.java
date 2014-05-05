package com.kaissersoft.missrepdom.persistence.Contracts;

import android.net.Uri;

import com.tjeannin.provigen.ProviGenBaseContract;
import com.tjeannin.provigen.annotation.Column;
import com.tjeannin.provigen.annotation.ContentUri;

/**
 * Created by Eefret on 5/4/2014.
 */
public interface UserPreferencesContract extends ProviGenBaseContract {

    @Column(Column.Type.INTEGER)
    public static final String HAS_VOTED = "HAS_VOTED";

    @Column(Column.Type.INTEGER)
    public static final String MODEL_VOTED = "MODEL_VOTED";


    @ContentUri
    public static final Uri CONTENT_URI = Uri.parse("content://com.kaissersoft.missrepdom/user_preferences");


}
