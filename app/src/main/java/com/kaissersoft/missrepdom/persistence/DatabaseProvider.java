package com.kaissersoft.missrepdom.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.kaissersoft.missrepdom.persistence.Contracts.ModelsContract;
import com.kaissersoft.missrepdom.persistence.Contracts.ModelsImagesContract;
import com.kaissersoft.missrepdom.persistence.Contracts.UserPreferencesContract;
import com.tjeannin.provigen.ProviGenProvider;
import com.tjeannin.provigen.helper.TableBuilder;
import com.tjeannin.provigen.helper.TableUpdater;

/**
 * Created by Eefret on 5/4/2014.
 */
public class DatabaseProvider extends ProviGenProvider {
    @Override
    public SQLiteOpenHelper openHelper(Context context) {
        return new SQLiteOpenHelper(getContext(),"MissRepDomDatabase",null,1) {
            @Override
            public void onCreate(SQLiteDatabase database) {
                new TableBuilder(ModelsContract.class).createTable(database);
                new TableBuilder(ModelsImagesContract.class).createTable(database);
                new TableBuilder(UserPreferencesContract.class).createTable(database);
                //Populate Database here
                //UserPreferences
                ContentValues cv = new ContentValues();
                cv.put(UserPreferencesContract.HAS_VOTED,0);
                cv.put(UserPreferencesContract.MODEL_VOTED,0);

                database.insert("user_preferences",null,cv);
                //getContext().getContentResolver().insert(UserPreferencesContract.CONTENT_URI,cv);
                Log.d("DatabaseProvider","database populated");
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
                new TableUpdater().addMissingColumns(sqLiteDatabase,ModelsContract.class);
                new TableUpdater().addMissingColumns(sqLiteDatabase,ModelsImagesContract.class);
                new TableUpdater().addMissingColumns(sqLiteDatabase,UserPreferencesContract.class);
            }
        };

    }

    @Override
    public Class[] contractClasses() {
        return new Class[]{ModelsContract.class, ModelsImagesContract.class,UserPreferencesContract.class};
    }
}
